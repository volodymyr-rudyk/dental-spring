create table dentist (
  id int not null auto_increment,
  first_name varchar(50),
  middle_name varchar(50),
  last_name varchar(50),
  address VARCHAR(50) NULL ,
  birthday date,
  phone varchar(30) NULL,
  user_id int not null,
  primary key (id),
  constraint user_fk foreign key (user_id) references user(id)
);