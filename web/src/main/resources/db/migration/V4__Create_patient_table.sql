create table patient (
	id int not null auto_increment,
  email varchar(50) NULL,
  first_name varchar(50),
  middle_name varchar(50),
  last_name varchar(50),
  address VARCHAR(50) NULL ,
  birthday date,
  gender VARCHAR(20) not NULL,
  phone varchar(30) NULL,
  primary key (id)
);
