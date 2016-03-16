create table user (
	id bigint(19) NOT NULL AUTO_INCREMENT,
	username varchar(255), 
	password varchar(255), 
	email varchar(255), 
	primary key (id)
);

create table user_role (
	id bigint(19) NOT NULL AUTO_INCREMENT,
	role_name varchar(255), 
	user_id bigint,
	primary key (id)
);

create table event_category (
	id bigint(19) NOT NULL AUTO_INCREMENT,
	name varchar(255), 
	create_by varchar(255) NOT NULL,
	created_date timestamp(23) NOT NULL,
	last_modified_by varchar(255),
	last_modified_date timestamp(23),
	primary key (id)
);

create table event (
	id bigint(19) NOT NULL AUTO_INCREMENT,
	institution_id bigint(19) NOT NULL,
	name varchar(255), 
	event_category_id bigint(19) NOT NULL,
	start_date timestamp(23) NOT NULL,
	end_date timestamp(23) NOT NULL,
	local varchar(255),
	description varchar(1000),
	create_by varchar(255) NOT NULL,
	created_date timestamp(23) NOT NULL,
	last_modified_by varchar(255),
	last_modified_date timestamp(23),
	primary key (id)
);

create table institution (
	id bigint(19) NOT NULL AUTO_INCREMENT,
	name varchar(255), 
	email varchar(255),
	site varchar(255),
	local varchar(255),
	create_by varchar(255) NOT NULL,
	created_date timestamp(23) NOT NULL,
	last_modified_by varchar(255),
	last_modified_date timestamp(23),
	primary key (id)
);

create table news (
	id bigint(19) NOT NULL AUTO_INCREMENT,
	title varchar(255), 
	description varchar(255),
	institution_id bigint(19) NOT NULL,
	author varchar(255),
	create_by varchar(255) NOT NULL,
	created_date timestamp(23) NOT NULL,
	last_modified_by varchar(255),
	last_modified_date timestamp(23),
	primary key (id)
);

create table room (
	id bigint(19) NOT NULL AUTO_INCREMENT,
	name varchar(255), 
	institution_id bigint(19) NOT NULL,
	create_by varchar(255) NOT NULL,
	created_date timestamp(23) NOT NULL,
	last_modified_by varchar(255),
	last_modified_date timestamp(23),
	primary key (id)
);

create table session (
	id bigint(19) NOT NULL AUTO_INCREMENT,
	name varchar(255), 
	description varchar(255), 
	event_id bigint(19) NOT NULL,
	room_id bigint(19) NOT NULL,
	start_date timestamp(23) NOT NULL,
	end_date timestamp(23) NOT NULL,
	create_by varchar(255) NOT NULL,
	created_date timestamp(23) NOT NULL,
	last_modified_by varchar(255),
	last_modified_date timestamp(23),
	primary key (id)
);

create table block (
	id bigint(19) NOT NULL AUTO_INCREMENT,
	name varchar(255), 
	email varchar(255),
	twitter varchar(255),
	linkedin varchar(255),
	curriculum varchar(255),
	create_by varchar(255) NOT NULL,
	created_date timestamp(23) NOT NULL,
	last_modified_by varchar(255),
	last_modified_date timestamp(23),
	primary key (id)
);
 
create table session_speaker (
	session_id bigint(19) NOT NULL,
	speaker_id bigint(19) NOT NULL,	
);
 
insert into user (id, username, password, email) values (1, 'root', 'root', 'root@localhost');
insert into user_role (id, role_name, user_id) values (1, 'ADMIN', 1);