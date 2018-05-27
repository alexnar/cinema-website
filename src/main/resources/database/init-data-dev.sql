delete from CINEMASESSION;
delete from MOVIE;


INSERT INTO Movie (Title, Description, Director, DurationMin) VALUES ('Космическая одиссея 2001 года', 'Экипаж космического корабля С. С. Дискавери — капитаны Дэйв Боумэн, Фрэнк Пул и их бортовой компьютер ХЭЛ-9000 — должны исследовать район галактики и понять, почему инопланетяне следят за Землей. На этом пути их ждет множество неожиданных открытий…', 'Стэнли Кубрик', 305);
INSERT INTO Movie (Title, Description, Director, DurationMin) VALUES ('Криминальное чтиво', 'Винсент Вега и Джулс Винфилд проводят время в философских беседах в перерыве между разборками и «решением проблем». Параллельно разворачивается три истории.', 'Квентин Тарантино', 140);
INSERT INTO Movie (Title, Description, Director, DurationMin) VALUES ('Большой куш', 'Сделав ставку на подпольном боксерском поединке, Френки попадает в круговорот весьма нежелательных событий.', 'Гай Ричи', 160);

INSERT INTO HALL (NAME) VALUES ('Зал №1');
INSERT INTO HALL (NAME) VALUES ('Зал №2');
INSERT INTO HALL (NAME) VALUES ('Зал №3');

INSERT INTO CINEMASESSION (STARTTIME, MOVIEID, HALLID) VALUES ('2018-05-20 20:00:00', SELECT id FROM MOVIE WHERE TITLE = 'Космическая одиссея 2001 года', SELECT id FROM HALL WHERE NAME = 'Зал №1');
INSERT INTO CINEMASESSION (STARTTIME, MOVIEID, HALLID) VALUES ('2018-05-20 18:00:00', SELECT id FROM MOVIE WHERE TITLE = 'Космическая одиссея 2001 года', SELECT id FROM HALL WHERE NAME = 'Зал №1');
INSERT INTO CINEMASESSION (STARTTIME, MOVIEID, HALLID) VALUES ('2018-05-20 16:00:00', SELECT id FROM MOVIE WHERE TITLE = 'Космическая одиссея 2001 года', SELECT id FROM HALL WHERE NAME = 'Зал №2');
INSERT INTO CINEMASESSION (STARTTIME, MOVIEID, HALLID) VALUES ('2018-05-21 15:00:00', SELECT id FROM MOVIE WHERE TITLE = 'Криминальное чтиво', SELECT id FROM HALL WHERE NAME = 'Зал №2');
INSERT INTO CINEMASESSION (STARTTIME, MOVIEID, HALLID) VALUES ('2018-05-20 19:00:00', SELECT id FROM MOVIE WHERE TITLE = 'Криминальное чтиво', SELECT id FROM HALL WHERE NAME = 'Зал №3');
INSERT INTO CINEMASESSION (STARTTIME, MOVIEID, HALLID) VALUES ('2018-05-20 19:00:00', SELECT id FROM MOVIE WHERE TITLE = 'Большой куш', SELECT id FROM HALL WHERE NAME = 'Зал №1');



