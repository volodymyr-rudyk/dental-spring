create table user (
	id int not null auto_increment,
  email varchar(50) NOT NULL ,
  password varchar(50) NOT NULL ,
  is_enabled bit default 1 not null,
  dentist_id int not null,
  primary key (id),
	key dentist_fk (dentist_id),
  constraint dentist_fk foreign key (dentist_id) references dentist(id)
);
