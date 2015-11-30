create table user (
	id int not null auto_increment,
  email varchar(50) NOT NULL ,
  password varchar(50) NOT NULL ,
  is_enabled bit default 1 not null,
  profile_id int not null,
  primary key (id),
	key profile_fk (profile_id),
  constraint profile_fk foreign key (profile_id) references profile(id)
);
