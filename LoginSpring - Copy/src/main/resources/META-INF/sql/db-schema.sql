create table customer (id bigint generated by default as identity (start with 1), email varchar(255) not null, first_name varchar(255), last_name varchar(255), name varchar(100) not null, password varchar(255) not null, phone varchar(20), version integer, primary key (id))
