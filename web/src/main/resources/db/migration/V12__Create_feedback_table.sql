create table feedback (
  id int not null auto_increment,
  email nvarchar(50) NULL,
  feedback nvarchar(2000),
  primary key (id)
);