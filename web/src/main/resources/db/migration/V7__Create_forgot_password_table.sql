CREATE TABLE forgot_password (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  forgot_password_key NVARCHAR(50) NOT NULL ,
  created_on DATETIME NOT NULL ,
  used_on DATETIME NULL ,
  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (user_id)  REFERENCES user(id)
);