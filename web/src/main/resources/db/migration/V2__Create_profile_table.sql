create table profile (
  id int not null auto_increment,
  first_name varchar(50),
  last_name varchar(50),
  birthday date,
  phone varchar(30),
  primary key (id)
);