CREATE TABLE `person` (
	`id` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`name` VARCHAR(150) NOT NULL COLLATE 'utf8mb4_general_ci',
	`adress` VARCHAR(250) NOT NULL COLLATE 'utf8mb4_general_ci',
	`gender` VARCHAR(30) NOT NULL COLLATE 'utf8mb4_general_ci',
	`dayOfBirth` DATE NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `reader` (
	`id` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`type` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`email` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`phoneN` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`id`) USING BTREE,
	CONSTRAINT `FK_reader_person` FOREIGN KEY (`id`) REFERENCES `person` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `employee` (
	`shift` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`role` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`id` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`id`) USING BTREE,
	CONSTRAINT `FK_employee_person` FOREIGN KEY (`id`) REFERENCES `person` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `book` (
	`id` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`title` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`yearPNs` INT(20) NOT NULL,
	`quantity` INT(11) NOT NULL,
	`author` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`type` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `borrowing` (
	`id` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`reader` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`employee` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`total` INT(11) NOT NULL,
	`date` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `FK_borrowing_reader` (`reader`) USING BTREE,
	INDEX `FK_borrowing_employee` (`employee`) USING BTREE,
	CONSTRAINT `FK_borrowing_employee` FOREIGN KEY (`employee`) REFERENCES `employee` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_borrowing_reader` FOREIGN KEY (`reader`) REFERENCES `reader` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `borrowingsatae` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`bookid` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`borrowingid` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`quantity` INT(11) NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `FK_borrowingsatae_book` (`bookid`) USING BTREE,
	INDEX `FK_borrowingsatae_borrowing` (`borrowingid`) USING BTREE,
	CONSTRAINT `FK_borrowingsatae_book` FOREIGN KEY (`bookid`) REFERENCES `book` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_borrowingsatae_borrowing` FOREIGN KEY (`borrowingid`) REFERENCES `borrowing` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=17
;
