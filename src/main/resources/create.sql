DROP TABLE IF EXISTS ASSISTANCES;
DROP TABLE IF EXISTS POSITIVES;
DROP TABLE IF EXISTS GRADES;
DROP TABLE IF EXISTS STUDENTINCLASSROOM;
DROP TABLE IF EXISTS CLASSROOMS;
DROP TABLE IF EXISTS TEACHERS;
DROP TABLE IF EXISTS STUDENTS;
DROP TABLE IF EXISTS SUBJECTS;
DROP TABLE IF EXISTS ADMIN;
DROP TABLE IF EXISTS USERS;

CREATE TABLE IF NOT EXISTS USERS(

id identity primary key,
password VARCHAR(30)

);

CREATE TABLE IF NOT EXISTS ADMINS(
id primary key,
FOREIGN KEY(id) FROM USERS(id)
)

CREATE TABLE IF NOT EXISTS SUBJECTS(

id identity primary key,
name VARCHAR(50),
course INT,
description VARCHAR(30)

);

CREATE TABLE IF NOT EXISTS TEACHERS(

id primary key,
dni VARCHAR(9),
name VARCHAR(100),
age DATE,
idsub INT,
FOREIGN KEY(id) FROM USERS(id),
FOREIGN KEY(idsub) FROM SUBJECTS(id)

);

CREATE TABLE IF NOT EXISTS STUDENTS(

id primary key,
dni VARCHAR(9),
name VARCHAR(100),
age DATE,
course INT,
FOREIGN KEY(id) FROM USERS(id)

);

CREATE TABLE IF NOT EXISTS CLASSROOMS(

id identity primary key,
name VARCHAR(100) NOT NULL,
course INT NOT NULL,
idsub INT NOT NULL,
idteach INT NOT NULL,
qstudents INT NOT NULL,
FOREIGN KEY(idsub) FROM SUBJECTS(id),
FOREIGN KEY(idteach) FROM TEACHERS(id),
CHECK(qstudents<=20)

);

CREATE TABLE IF NOT EXISTS STUDENTSINCLASSROOMS(

id identity primary key,
idstud int,
idcr int,
FOREIGN KEY(idstud) FROM STUDENTS(id)

);

CREATE TABLE IF NOT EXISTS GRADES(

id identity primary key,
itsfinal boolean,
idstud int,
idsub int,
course int,
grade int NOT NULL,
description VARCHAR(300),
FOREIGN KEY(idstud) FROM STUDENTS(id),
FOREIGN KEY(idsub) FROM SUBJECTS(id)

);

CREATE TABLE IF NOT EXISTS POSITIVES(

id identity primary key,
idstud int,
idsub int,
positive boolean,
description VARCHAR(300),
dateadded date,
FOREIGN KEY(idstud) FROM STUDENTS(id),
FOREIGN KEY(idsub) FROM SUBJECTS(id)

);

CREATE TABLE IF NOT EXISTS ASSISTANCES(

id identity primary key,
idstud int,
idsub int,
assistance boolean,
dateassistance date,
FOREIGN KEY(idstud) FROM STUDENTS(id),
FOREIGN KEY(idsub) FROM SUBJECTS(id)

);

CREATE TABLE IF NOT EXISTS MEETINGS(

id identity primary key,
idstud int,
idteach int,
datemeet date,
description VARCHAR(300),
FOREIGN KEY(idstud) FROM STUDENTS(id),
FOREIGN KEY(idteach) FROM TEACHERS(id)

);