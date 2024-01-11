package com.beingabroad.institute.controller;

import com.beingabroad.institute.model.Institute;
import com.beingabroad.institute.request.InstituteRequest;
import com.beingabroad.institute.service.InstituteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/institute/api")
@RestController
@RequiredArgsConstructor
public class InstituteController
{

    private final InstituteService instituteService;

    @PostMapping("/create")
    public ResponseEntity<Institute> createInstitute(@RequestBody @Valid Institute institute)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(instituteService.save(institute));
    }

    @GetMapping("/list")
    public List<Institute> fetchInstituteList()
    {
        return instituteService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> fetchInstituteById(@PathVariable Long id)
    {
        Optional<Institute> instituteOptional = instituteService.getById(id);
        if (instituteOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(instituteService.getById(id));
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Institute not found for id :" + id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInstituteById(@RequestBody @Valid Institute institute, @PathVariable("id") Long id)
    {
        Optional<Institute> instituteOptional = instituteService.getById(id);
        if (instituteOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(instituteService.updateById(institute, id));
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Institute not found for id :" + id);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdateGeneric(@RequestBody @Valid InstituteRequest instituteRequest, @PathVariable("id") Long id)
    {
        Optional<Institute> instituteOptional = instituteService.getById(id);
        if (instituteOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(instituteService.partialUpdate(instituteRequest, id));
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Institute not found for id :" + id);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex)
    {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
