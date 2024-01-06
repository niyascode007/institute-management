package com.beingabroad.institute.service.impl;

import com.beingabroad.institute.model.Institute;
import com.beingabroad.institute.repository.InstituteRepository;
import com.beingabroad.institute.service.InstituteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<Institute> getAll()
    {
        return instituteRepository.findAll();
    }

    @Override
    public Optional<Institute> getById(Long id)
    {
        return instituteRepository.findById(id);
    }
}
