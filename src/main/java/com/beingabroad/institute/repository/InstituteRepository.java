package com.beingabroad.institute.repository;

import com.beingabroad.institute.model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepository extends JpaRepository<Institute, Long>
{
}
