create table user (
  id int not null auto_increment,
  email varchar(50) NOT NULL UNIQUE ,
  password varchar(50) NOT NULL ,
  is_enabled bit default 1 not null,
  created_on DATETIME NOT NULL ,
  primary key (id)
);

