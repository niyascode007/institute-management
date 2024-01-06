package com.beingabroad.institute.controller;

import com.beingabroad.institute.model.Institute;
import com.beingabroad.institute.service.InstituteService;
import com.beingabroad.institute.validations.InstituteValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/institute/api")
@RestController
@RequiredArgsConstructor
public class InstituteController
{

    private final InstituteService instituteService;

    @PostMapping("/create")
    public ResponseEntity<?> createInstitute(@RequestBody Institute institute, BindingResult result)
    {
        new InstituteValidator().validate(institute, result);
        if (result.hasErrors())
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getAllErrors());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(instituteService.save(institute));
    }

    @GetMapping("/list")
    public List<Institute> fetchInstituteList()
    {
        return instituteService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institute> fetchInstituteById(@PathVariable Long id)
    {
        Optional<Institute> data = instituteService.getById(id);

        return data.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

}
