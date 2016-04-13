package com.dental.persistence.impl;

import com.dental.persistence.entity.Patient;
import com.dental.persistence.repository.AbstractRepository;
import com.dental.persistence.repository.PatientRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Created by light on 10/17/2015.
 */
@Repository
@Transactional("patientRepository")
public class PatientRepositoryImpl extends AbstractRepository<Patient> implements PatientRepository {

  public PatientRepositoryImpl() {
    super(Patient.class);
  }

  @Override
  public Patient findByFirstAndLastName(String firstName, String lastName) {
    TypedQuery<Patient> query =
        entityManager.createQuery("SELECT p FROM Patient p where p.firstName = :firstName " +
            " and p.lastName = :lastName", Patient.class);
    query.setParameter("firstName", firstName);
    query.setParameter("lastName", lastName);
    query.setMaxResults(1);
    List<Patient> patients = query.getResultList();

    return patients.size() > 0 ? patients.get(0) : null;
  }
}
