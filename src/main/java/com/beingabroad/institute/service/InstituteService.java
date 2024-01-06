package com.beingabroad.institute.service;

import com.beingabroad.institute.model.Institute;

import java.util.List;
import java.util.Optional;

public interface InstituteService
{
    Institute save(Institute institute);

    List<Institute> getAll();

    Optional<Institute> getById(Long id);
}
