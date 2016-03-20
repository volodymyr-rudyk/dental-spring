create table dentist_patient (
  id int not NULL auto_increment,
  dentist_id int not NULL,
  patient_id int not NULL,
  primary key (id),
  constraint dentist_patient_dentist_fk foreign key (dentist_id) references dentist(id),
  constraint dentist_patient_patient_fk foreign key (patient_id) references patient(id)
);


