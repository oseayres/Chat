BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `users` (
	`name`	TEXT UNIQUE,
	`password`	TEXT,
	PRIMARY KEY(`name`)
);
INSERT INTO `users` (name,password) VALUES ('marco','123');
INSERT INTO `users` (name,password) VALUES ('ze','123');
CREATE TABLE IF NOT EXISTS `chat` (
	`id_chat`	INTEGER,
	`sender`	TEXT,
	`receiver`	TEXT,
	`content`	TEXT,
	`dt`	datetime,
	PRIMARY KEY(`id_chat`),
	FOREIGN KEY(`receiver`) REFERENCES `users`(`name`),
	FOREIGN KEY(`sender`) REFERENCES `users`(`name`)
);
INSERT INTO `chat` (id_chat,sender,receiver,content,dt) VALUES (1,'marco','ze','oi','2018-09-18 11:02:28');
INSERT INTO `chat` (id_chat,sender,receiver,content,dt) VALUES (2,'ze','marco','oi','2018-09-18 11:02:33');
INSERT INTO `chat` (id_chat,sender,receiver,content,dt) VALUES (3,'marco','ze','tudo bem?','2018-09-18 11:02:36');
INSERT INTO `chat` (id_chat,sender,receiver,content,dt) VALUES (4,'ze','marco','tudo e vc?','2018-09-18 11:02:42');
INSERT INTO `chat` (id_chat,sender,receiver,content,dt) VALUES (5,'marco','ze','bao dms','2018-09-18 11:02:47');
COMMIT;
