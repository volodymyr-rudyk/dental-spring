create table language (
  id int not null auto_increment,
  code varchar(2) NOT NULL,
  primary key (id)
);

INSERT INTO language (code)
    VALUE ('en');
INSERT INTO language (code)
    VALUE ('ua');

ALTER TABLE user
add column language_id INT not NULL DEFAULT 1,
add CONSTRAINT FOREIGN KEY (language_id)  REFERENCES  language(id);