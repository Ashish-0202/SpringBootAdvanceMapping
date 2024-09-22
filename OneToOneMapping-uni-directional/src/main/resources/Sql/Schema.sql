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