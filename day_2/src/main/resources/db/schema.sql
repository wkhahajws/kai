drop table if exists `u`;
create table `u`(
  `id` int(11) not null auto_increment,
  `name` varchar(255) default null,
  `age` int(11) default null,
  primary key (`id`)
) engine=InnoDB DEFAULT charset = utf8

