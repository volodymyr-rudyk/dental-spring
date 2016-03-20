create table dentist (
  id int not null auto_increment,
  first_name varchar(50),
  middle_name varchar(50),
  last_name varchar(50),
  address VARCHAR(50) NULL ,
  birthday date,
  phone varchar(30) NULL,
  primary key (id)
);