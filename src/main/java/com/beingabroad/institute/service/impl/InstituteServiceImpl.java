package com.beingabroad.institute.service.impl;

import com.beingabroad.institute.model.Institute;
import com.beingabroad.institute.repository.InstituteRepository;
import com.beingabroad.institute.request.InstituteRequest;
import com.beingabroad.institute.service.InstituteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstituteServiceImpl implements InstituteService
{

    private final InstituteRepository instituteRepository;

    @Override
    public Institute save(Institute institute)
    {
        return instituteRepository.save(institute);
    }

    @Override
    public Institute updateById(Institute instituteRequest, Long id)
    {
        Institute institute = instituteRepository.findById(id).orElseThrow(() -> new NoSuchElementException("institute not found for id: " + id));
        institute.setInstituteName(instituteRequest.getInstituteName());
        institute.setLocation(instituteRequest.getLocation());
        institute.setContactInformation(instituteRequest.getContactInformation());
        institute.setEmail(instituteRequest.getEmail());
        institute.setEstablishmentYear(instituteRequest.getEstablishmentYear());
        institute.setWebsiteUrl(instituteRequest.getWebsiteUrl());
        return instituteRepository.save(institute);

    }

    @Override
    public List<Institute> getAll()
    {
        return instituteRepository.findAll();
    }

    @Override
    public Optional<Institute> getById(Long id)
    {
        return instituteRepository.findById(id);
    }

    @Override
    public Institute partialUpdate(InstituteRequest instituteRequest, Long id)
    {
        Institute existingInstitute = instituteRepository.findById(id).orElseThrow(() -> new NoSuchElementException("institute not found for id: " + id));
        return instituteRepository.save(applyPartialUpdates(existingInstitute, instituteRequest));
    }

    @Override
    public void deleteById(Long id)
    {
        instituteRepository.deleteById(id);
    }

    private Institute applyPartialUpdates(Institute institute, InstituteRequest instituteRequest)
    {
        if (instituteRequest.getInstituteName() != null)
        {
            institute.setInstituteName(instituteRequest.getInstituteName());
        }
        if (instituteRequest.getLocation() != null)
        {
            institute.setLocation(instituteRequest.getLocation());
        }
        if (instituteRequest.getContactInformation() != null)
        {
            institute.setContactInformation(instituteRequest.getContactInformation());
        }
        if (instituteRequest.getEmail() != null)
        {
            institute.setEmail(instituteRequest.getEmail());
        }
        if (instituteRequest.getEstablishmentYear() != null)
        {
            institute.setEstablishmentYear(instituteRequest.getEstablishmentYear());
        }
        if (instituteRequest.getWebsiteUrl() != null)
        {
            institute.setWebsiteUrl(instituteRequest.getWebsiteUrl());
        }
        return institute;
    }

}
