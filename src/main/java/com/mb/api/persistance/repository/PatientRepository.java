package com.mb.api.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mb.api.persistance.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>
{

}
