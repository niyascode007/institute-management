package com.beingabroad.institute.service;

import com.beingabroad.institute.model.Institute;
import com.beingabroad.institute.request.InstituteRequest;

import java.util.List;
import java.util.Optional;

public interface InstituteService
{
    Institute save(Institute institute);

    Institute updateById(Institute institute, Long id);

    List<Institute> getAll();

    Optional<Institute> getById(Long id);

    Institute partialUpdate(InstituteRequest instituteRequest, Long id);
}
