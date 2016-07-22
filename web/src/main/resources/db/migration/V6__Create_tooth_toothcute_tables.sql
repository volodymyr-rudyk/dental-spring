CREATE TABLE tooth (
  id         INT NOT NULL AUTO_INCREMENT,
  toothstate NVARCHAR(30),
  toothgrid NVARCHAR(15) NOT NULL ,
  patient_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (patient_id)  REFERENCES patient(id)
);
CREATE TABLE tooth_cure (
  id INT NOT NULL AUTO_INCREMENT,
  cure TEXT,
  createdOn DATETIME,
  tooth_id INT,
  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (tooth_id) REFERENCES tooth(id)
);