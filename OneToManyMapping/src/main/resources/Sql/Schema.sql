create table instructor(
id SERIAL,
firstname varchar(25),
lastname varchar(35),
email varchar(45),
instructor_id INTEGER NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(instructor_id) REFERENCES instructor_details(id)
);

create table  instructor_details(
id SERIAL,
youtubelink varchar(100),
linkedin varchar(100),
PRIMARY KEY(id)
);

--Table for courses which is having many to one relationship with instructor
CREATE TABLE courses(
	c_id SERIAL,
	title varchar(50),
	id integer,
	UNIQUE (title),
	PRIMARY KEY (c_id),
	FOREIGN KEY(id) REFERENCES instructor(id)
)

INSERT INTO courses (title,id) values ('Full stack Java',3)
INSERT INTO courses (title,id) values ('Core Java',3)
INSERT INTO courses (title,id) values ('Spring core',3)

create table review(
	id SERIAL,
	comments varchar(30),
	c_id integer,
	PRIMARY KEY(id),
	FOREIGN KEY(c_id) references courses(c_id)
)

-------------------------------------------------
create table student(
	sid serial,
	name varchar(25),
	email varchar(25),
	phone integer,
	primary key(sid)
)

create table course_student(
	course_id serial,
	student_id serial,
	FOREIGN KEY(course_id) references courses(c_id),
	FOREIGN KEY(student_id) references student(sid)
)