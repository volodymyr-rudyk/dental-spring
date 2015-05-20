create table user (
	id int not null auto_increment,
  login varchar(50),
  password varchar(50),
  is_enabled bit default 1 not null,
  profile_id int not null,
  primary key (id),
	key profile_fk (profile_id),
  constraint profile_fk foreign key (profile_id) references profile(id)
);
