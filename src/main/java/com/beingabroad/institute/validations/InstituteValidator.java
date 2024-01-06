package com.beingabroad.institute.validations;

import com.beingabroad.institute.model.Institute;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class InstituteValidator implements Validator
{

    @Override
    public boolean supports(Class<?> clazz)
    {
        return Institute.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        Institute institute = (Institute) target;
        validateContactInformation(institute.getContactInformation(), errors);
        validateEstablishmentYear(institute.getEstablishmentYear(), errors);
    }

    private void validateContactInformation(Long contactInformation, Errors errors)
    {
        if (contactInformation == null || !isValid10DigitNumber(contactInformation))
        {
            errors.rejectValue("contactInformation", "invalid.contactInformation", "Contact information should be a valid 10-digit number");
        }
    }

    private void validateEstablishmentYear(Integer establishmentYear, Errors errors)
    {
        if (establishmentYear == null || establishmentYear < 1800)
        {
            errors.rejectValue("establishmentYear", "invalid.establishmentYear", "Establishment year should be after 1800");
        }
    }

    private boolean isValid10DigitNumber(Long number)
    {
        return String.valueOf(number).matches("\\d{10}");
    }
}
