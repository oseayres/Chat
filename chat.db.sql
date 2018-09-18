BEGIN TRANSACTION;
CREATE TABLE `users` (
	`name`	TEXT UNIQUE,
	`password`	TEXT,
	PRIMARY KEY(`name`)
);
INSERT INTO `users` VALUES ('marco','123');
INSERT INTO `users` VALUES ('ze','123');
INSERT INTO `users` VALUES ('rodrigo','123');
CREATE TABLE `chat` (
	`id_chat`	INTEGER,
	`sender`	TEXT,
	`receiver`	TEXT,
	`content`	TEXT,
	`dt`	datetime,
	PRIMARY KEY(`id_chat`),
	FOREIGN KEY(`receiver`) REFERENCES `users`(`name`),
	FOREIGN KEY(`sender`) REFERENCES `users`(`name`)
);
INSERT INTO `chat` VALUES (1,'marco','ze','oi','2018-09-18 11:02:28');
INSERT INTO `chat` VALUES (2,'ze','marco','oi','2018-09-18 11:02:33');
INSERT INTO `chat` VALUES (3,'marco','ze','tudo bem?','2018-09-18 11:02:36');
INSERT INTO `chat` VALUES (4,'ze','marco','tudo e vc?','2018-09-18 11:02:42');
INSERT INTO `chat` VALUES (5,'marco','ze','bao dms','2018-09-18 11:02:47');
INSERT INTO `chat` VALUES (6,'ze','rodrigo','Vc é o taison?','2018-09-18 11:47:58');
INSERT INTO `chat` VALUES (7,'rodrigo','ze','Não, eu sou rodrigo','2018-09-18 11:48:14');
INSERT INTO `chat` VALUES (8,'rodrigo','ze','Rodrigo Taison','2018-09-18 11:48:26');
INSERT INTO `chat` VALUES (9,'ze','rodrigo','Então vc é o TAISON!','2018-09-18 11:48:42');
INSERT INTO `chat` VALUES (10,'ze','rodrigo','Tá precisando estudar mais hein cara','2018-09-18 11:49:00');
COMMIT;
