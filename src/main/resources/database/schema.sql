DROP DATABASE IF EXISTS cinema;

CREATE DATABASE cinema;
USE cinema;

create table CinemaSession
(
	Id int not null
		primary key,
	StartTime datetime null,
	MovieId int null,
	HallId int null
)
engine=InnoDB
;

create index MovieId
	on CinemaSession (MovieId)
;

create index HallId
	on CinemaSession (HallId)
;

create table Hall
(
	Id int not null
		primary key,
	Name varchar(255) null
)
engine=InnoDB
;

alter table CinemaSession
	add constraint HallId
		foreign key (HallId) references Hall (Id)
;

create table Movie
(
	Id int not null
		primary key,
	Title varchar(255) null,
	Director varchar(255) null,
	Description text null,
	DurationMin int null
)
engine=InnoDB
;

alter table CinemaSession
	add constraint MovieId
		foreign key (MovieId) references Movie (Id)
;

