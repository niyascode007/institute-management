package com.beingabroad.institute.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Institute
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Institute name is required")
    private String instituteName;

    @NotBlank(message = "Location is required")
    private String location;

    @NotNull(message = "Contact information is required")
    @Min(value = 1000000000L, message = "Contact information should be a valid 10-digit number")
    @Max(value = 9999999999L, message = "Contact information should be a valid 10-digit number")
    private Long contactInformation;

    @Email(message = "Email should be valid")
    private String email;

    @Min(value = 1800, message = "Establishment year should be after 1800")
    private Integer establishmentYear;


    @URL(message = "Website URL should be valid")
    private String websiteUrl;

}
