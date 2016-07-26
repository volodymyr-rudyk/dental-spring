CREATE TABLE tooth (
  id         INT NOT NULL AUTO_INCREMENT,
  tooth_state NVARCHAR(30),
  tooth_bucket NVARCHAR(15) NOT NULL ,
  tooth_number INT NOT NULL ,
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