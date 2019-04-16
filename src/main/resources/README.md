README
======

create table test(id bigint primary key auto_increment, name varchar(255), sex bigint);
create table gender(id bigint primary key auto_increment, gender varchar(255));

H2 database ~/charles.swires/test

https://github.com/CharlieSwires/Test
https://github.com/CharlieSwires/jpa-test

compile jpa-test using the following : mvn package
copy the jpa-test.war to tomcat webapps
copy the angular js app Test to webapps then
start tomcat
In a browser go to localhost:8080/Test
