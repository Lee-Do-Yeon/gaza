CREATE TABLE `user` (
 `user_id` int NOT NULL auto_increment primary key,
 `name` varchar(20) NOT NULL,
 `phone_number` varchar(15) NULL,
 `id` varchar(50) NOT NULL,
 `password` varchar(100) NOT NULL,
 `gender` varchar(10) NULL,
 `birthday` date NULL,
 `picture` varchar(255) NULL,
 `email` varchar(20) NOT NULL,
 `email_domain` varchar(20) NOT NULL,
 `state_code` varchar(10) NULL
);

CREATE TABLE `consulting` (
 `consulting_id` int NOT NULL auto_increment primary key,
 `reservation_id` int NOT NULL,
 `start_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
 `end_time` datetime NULL,
 `url` varchar(255) NULL,
 `is_activate` tinyint NULL DEFAULT 0
);

CREATE TABLE `review` (
 `review_id` int NOT NULL auto_increment primary key,
 `reservation_id` int NOT NULL,
 `content` varchar(255) NOT NULL,
 `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `score` int NOT NULL DEFAULT 0
);

CREATE TABLE `question` (
 `question_id` int NOT NULL auto_increment primary key,
 `content` varchar(255) NOT NULL,
 `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `user_id` int NOT NULL,
 `guide_id` int NOT NULL
);

CREATE TABLE `travel_route` (
 `travel_route_id` int NOT NULL auto_increment primary key,
 `reservation_id` int NOT NULL,
 `latitude` decimal NOT NULL,
 `longitude` decimal NOT NULL,
 `name` varchar(50) NOT NULL,
 `address` varchar(255) NOT NULL,
 `order` int NOT NULL
);

CREATE TABLE `answer` (
 `answer_id` int NOT NULL auto_increment primary key,
 `question_id` int NOT NULL,
 `content` varchar(255) NOT NULL,
 `create_date` datetime NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `recommend` (
 `recommend_id` int NOT NULL auto_increment primary key,
 `guide_id` int NOT NULL,
 `name` varchar(50) NOT NULL,
 `address` varchar(100) NOT NULL,
 `category_code` varchar(10) NOT NULL,
 `picture` varchar(255) NOT NULL,
 `latitude` decimal NOT NULL,
 `longitude` decimal NOT NULL
);

CREATE TABLE `guide` (
 `guide_id` int NOT NULL auto_increment primary key,
 `user_id` int NOT NULL,
 `oneline_introduction` varchar(50) NOT NULL,
 `introduction` varchar(255) NOT NULL,
 `picture` varchar(255) NOT NULL,
 `country` varchar(100) NOT NULL,
 `city` varchar(200) NOT NULL,
 `close_time_start` time NULL,
 `close_time_end` time NULL,
 `price` int NULL,
 `license` tinyint NULL DEFAULT 0
);

CREATE TABLE `guide_file` (
 `user_id` int NOT NULL,
 `id_file` varchar(255) NOT NULL,
 `certificate_residence` varchar(255) NOT NULL,
 `certificate` varchar(255) NULL
);

CREATE TABLE `guide_thema` (
 `guide_thema_id` int NOT NULL auto_increment primary key,
 `guide_id` int NOT NULL,
 `Field` varchar(10) NOT NULL
);

CREATE TABLE `user_thema` (
 `user_thema_id` int NOT NULL auto_increment primary key,
 `user_id` int NOT NULL,
 `Field` varchar(10) NOT NULL
);

CREATE TABLE `guide_language` (
 `guide_language_id` int NOT NULL auto_increment primary key,
 `guide_id` int NOT NULL,
 `Field` varchar(10) NOT NULL
);

CREATE TABLE `dayoff` (
 `dayoff_id` int NOT NULL auto_increment primary key,
 `guide_id` int NOT NULL,
 `dayoff_date` date NOT NULL
);

CREATE TABLE `reservation` (
 `reservation_id` int NOT NULL auto_increment primary key,
 `guide_id` int NOT NULL,
 `user_id` int NOT NULL,
 `state_code` varchar(10) NULL,
 `reservation_date` datetime NULL DEFAULT CURRENT_TIMESTAMP,
 `consulting_date` datetime NOT NULL,
 `travel_start_date` datetime NOT NULL,
 `travel_end_date` datetime NOT NULL,
 `number_of_people` int NOT NULL,
 `with_children` tinyint NULL DEFAULT 0,
 `with_elderly` tinyint NULL DEFAULT 0,
 `with_disabled` tinyint NULL DEFAULT 0,
 `note` varchar(255) NULL
);

CREATE TABLE `code` (
 `code_id` int NOT NULL auto_increment primary key,
 `parent_id` int NULL,
 `name` varchar(10) NOT NULL,
 `description` varchar(20) NULL
);


ALTER TABLE `guide_file` ADD CONSTRAINT `PK_GUIDE_FILE` PRIMARY KEY (
 `user_id`
);

ALTER TABLE `consulting` ADD CONSTRAINT `FK_reservation_TO_consulting_1` FOREIGN KEY (
 `reservation_id`
)
REFERENCES `reservation` (
 `reservation_id`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_reservation_TO_review_1` FOREIGN KEY (
 `reservation_id`
)
REFERENCES `reservation` (
 `reservation_id`
);

ALTER TABLE `question` ADD CONSTRAINT `FK_user_TO_question_1` FOREIGN KEY (
 `user_id`
)
REFERENCES `user` (
 `user_id`
);

ALTER TABLE `question` ADD CONSTRAINT `FK_guide_TO_question_1` FOREIGN KEY (
 `guide_id`
)
REFERENCES `guide` (
 `guide_id`
);

ALTER TABLE `travel_route` ADD CONSTRAINT `FK_reservation_TO_travel_route_1` FOREIGN KEY (
 `reservation_id`
)
REFERENCES `reservation` (
 `reservation_id`
);

ALTER TABLE `answer` ADD CONSTRAINT `FK_question_TO_answer_1` FOREIGN KEY (
 `question_id`
)
REFERENCES `question` (
 `question_id`
);

ALTER TABLE `recommend` ADD CONSTRAINT `FK_guide_TO_recommend_1` FOREIGN KEY (
 `guide_id`
)
REFERENCES `guide` (
 `guide_id`
);

ALTER TABLE `guide` ADD CONSTRAINT `FK_user_TO_guide_1` FOREIGN KEY (
 `user_id`
)
REFERENCES `user` (
 `user_id`
);

ALTER TABLE `guide_file` ADD CONSTRAINT `FK_user_TO_guide_file_1` FOREIGN KEY (
 `user_id`
)
REFERENCES `user` (
 `user_id`
);

ALTER TABLE `guide_thema` ADD CONSTRAINT `FK_guide_TO_guide_thema_1` FOREIGN KEY (
 `guide_id`
)
REFERENCES `guide` (
 `guide_id`
);

ALTER TABLE `user_thema` ADD CONSTRAINT `FK_user_TO_user_thema_1` FOREIGN KEY (
 `user_id`
)
REFERENCES `user` (
 `user_id`
);

ALTER TABLE `guide_language` ADD CONSTRAINT `FK_guide_TO_guide_language_1` FOREIGN KEY (
 `guide_id`
)
REFERENCES `guide` (
 `guide_id`
);

ALTER TABLE `dayoff` ADD CONSTRAINT `FK_guide_TO_dayoff_1` FOREIGN KEY (
 `guide_id`
)
REFERENCES `guide` (
 `guide_id`
);

ALTER TABLE `reservation` ADD CONSTRAINT `FK_guide_TO_reservation_1` FOREIGN KEY (
 `guide_id`
)
REFERENCES `guide` (
 `guide_id`
);

ALTER TABLE `reservation` ADD CONSTRAINT `FK_user_TO_reservation_1` FOREIGN KEY (
 `user_id`
)
REFERENCES `user` (
 `user_id`
);

ALTER TABLE `code` ADD CONSTRAINT `FK_code_TO_code_1` FOREIGN KEY (
 `parent_id`
)
REFERENCES `code` (
 `code_id`
);

