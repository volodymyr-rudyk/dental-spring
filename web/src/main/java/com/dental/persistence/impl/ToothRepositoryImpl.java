package com.dental.persistence.impl;

import com.dental.persistence.entity.Tooth;
import com.dental.persistence.repository.AbstractRepository;
import com.dental.persistence.repository.ToothRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by vrudyk on 7/3/2016.
 */
@Repository
@Transactional
public class ToothRepositoryImpl extends AbstractRepository<Tooth> implements ToothRepository {

  public ToothRepositoryImpl() {
    super(Tooth.class);
  }

  @Override
  public List<Tooth> getAllToothByPatientId(Long patientId) {
    String q = "select t from User t where t.patient_id = :patientId";

    Query namedQuery = entityManager.createQuery(q);
    namedQuery.setParameter("patientId", patientId);
    return namedQuery.getResultList();
  }

  @Override
  public Tooth get(Long toothId, Long patientId) {
    String q = "from Tooth as t where t.id = :toothId and t.patient.id = :patientId";

    Query query = entityManager.createQuery(q);
    query.setParameter("toothId", toothId);
    query.setParameter("patientId", patientId);
    List list = query.getResultList();
    if(list.size() > 0) {
      Tooth t = (Tooth) list.get(0);
//      Hibernate.initialize(t.getCures());
      return t;
    }
    return null;
  }

  @Override
  public Tooth get(Long id) {
    return entityManager.find(Tooth.class, id);
  }

  @Override
  public Tooth save(Tooth entity) {
    entityManager.persist(entity);
    return entity;
  }

  @Override
  public List<Tooth> getList() {
    return null;
  }

  @Override
  public void remove(Long id) {
    Tooth tooth = get(id);
    entityManager.remove(tooth);
  }

  @Override
  public Tooth update(Tooth entity) {
    return entityManager.merge(entity);
  }
}
