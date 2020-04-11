drop table if exists users;
create table users(
   id smallint unsigned not null auto_increment,
   user_name varchar(50) not null,
   sex int(3) not null default 1 check(sex in (1,2)),
   note varchar(256) not null,
   primary key(id)
)engine=innodb default charset=utf8;