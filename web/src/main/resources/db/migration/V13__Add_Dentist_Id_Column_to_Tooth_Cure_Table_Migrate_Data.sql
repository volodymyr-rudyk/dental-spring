ALTER TABLE tooth_cure
  ADD COLUMN dentist_id INT;

ALTER TABLE tooth_cure
    ADD CONSTRAINT FOREIGN KEY (dentist_id) REFERENCES dentist(id);

UPDATE tooth_cure tc
    INNER JOIN tooth t ON tc.tooth_id = t.id
    INNER JOIN patient p ON t.patient_id = p.id
    INNER JOIN dentist_patient dp ON p.id = dp.patient_id
    INNER JOIN dentist d on dp.dentist_id = d.id
SET tc.dentist_id = d.id;