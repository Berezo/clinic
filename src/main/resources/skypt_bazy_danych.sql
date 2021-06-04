-- SHOW DATABASES;

-- CREATE DATABASE `clinic`;
-- CREATE USER 'clinic_admin'@'localhost' IDENTIFIED BY 'admin';
-- GRANT ALL PRIVILEGES ON * . * TO 'clinic_admin'@'localhost';

-- USE clinic;

-- DROP TABLE IF EXISTS visit;
-- DROP TABLE IF EXISTS prescription;
-- DROP TABLE IF EXISTS patient;
-- DROP TABLE IF EXISTS patient_address;
-- DROP TABLE IF EXISTS office_hours;
-- DROP TABLE IF EXISTS doctor;
-- DROP TABLE IF EXISTS doctor_address;


-- CREATE TABLE `patient_address`(
-- 	`id` INT AUTO_INCREMENT NOT NULL,
--     `house_number` INT,
--     `street` VARCHAR(50),
--     `city` VARCHAR(50),
--     `zip_code` VARCHAR(7),
--     CONSTRAINT `patient_address_pk` PRIMARY KEY(`id`)
--     );
--     
-- CREATE TABLE `patient`(
-- 	`id` INT AUTO_INCREMENT NOT NULL,
--     `first_name` VARCHAR(50) NOT NULL,
--     `surname` VARCHAR(50) NOT NULL,
--     `address_id` INT,
--     CONSTRAINT `patient_pk` PRIMARY KEY(`id`),
--     CONSTRAINT `patient_address_fk` FOREIGN KEY(`address_id`) REFERENCES `patient_address`(`id`) ON DELETE SET NULL
--     );

-- CREATE TABLE `doctor_address`(
-- 	`id` INT AUTO_INCREMENT NOT NULL,
--     `house_number` INT,
--     `street` VARCHAR(50),
--     `city` VARCHAR(50),
--     `zip_code` VARCHAR(7),
--     CONSTRAINT `doctor_address_pk` PRIMARY KEY(`id`)
--     );
--     
-- CREATE TABLE `doctor`(
-- 	`id` INT AUTO_INCREMENT NOT NULL,
--     `first_name` VARCHAR(50) NOT NULL,
--     `surname` VARCHAR(50) NOT NULL,
--     `is_specialist` BOOLEAN NOT NULL DEFAULT false,
--     `address_id` INT,
--     CONSTRAINT `doctor_pk` PRIMARY KEY(`id`),
--     CONSTRAINT `doctor_address_fk` FOREIGN KEY(`address_id`) REFERENCES `doctor_address`(`id`) ON DELETE SET NULL
--     );
--     
-- CREATE TABLE `prescription`(
-- 	`id` INT AUTO_INCREMENT NOT NULL,
--     `patient_id` INT,
--     `doctor_id` INT,
--     `description` VARCHAR(200),
--     `medicines` VARCHAR(200),
--     CONSTRAINT `prescription_pk` PRIMARY KEY(`id`),
--     CONSTRAINT `prescription_doctor_fk` FOREIGN KEY(`doctor_id`) REFERENCES `doctor`(`id`) ON DELETE SET NULL,
--     CONSTRAINT `prescription_patient_fk` FOREIGN KEY(`patient_id`) REFERENCES `patient`(`id`) ON DELETE SET NULL
--     );
--     
-- CREATE TABLE `visit`(
-- 	`id` INT AUTO_INCREMENT NOT NULL,
--     `patient_id` INT,
--     `doctor_id` INT,
--     `is_examination` BOOLEAN NOT NULL,
--     `patient_description` VARCHAR(200) NOT NULL,
--     `prescription_id` INT,
--     `registration_date` DATE NOT NULL,
--     `visit_date` DATETIME NOT NULL,
--     `visit_made` BOOLEAN NOT NULL,
--     `cancel_couse` VARCHAR(200),
--     CONSTRAINT `visit_pk` PRIMARY KEY(`id`),
--     CONSTRAINT `visit_patient_fk` FOREIGN KEY(`patient_id`) REFERENCES `patient`(`id`) ON DELETE SET NULL,
--     CONSTRAINT `visit_doctor_fk` FOREIGN KEY(`doctor_id`) REFERENCES `doctor`(`id`) ON DELETE SET NULL,
--     CONSTRAINT `visit_prescription_fk` FOREIGN KEY(`prescription_id`) REFERENCES `prescription`(`id`) ON DELETE SET NULL
--     );
--     
-- CREATE TABLE `office_hours`(
-- 	`id` INT AUTO_INCREMENT NOT NULL,
--     `doctor_id` INT,
--     `day` VARCHAR(20) NOT NULL,
--     `hour` TIME NOT NULL,
--     CONSTRAINT `office_hours_pk` PRIMARY KEY(`id`),
--     CONSTRAINT `office_hourst_doctor_fk` FOREIGN KEY(`doctor_id`) REFERENCES `doctor`(`id`) ON DELETE SET NULL
--     );
--     
--     
-- INSERT INTO `patient_address`(`house_number`, `street`, `city`, `zip_code`) VALUES ( 13, 'test', 'test_city', '11-111');
-- INSERT INTO `patient`(`first_name`, `surname`, `address_id`) VALUES ('test_name', 'test_surname', 1);

-- INSERT INTO `doctor_address`(`house_number`, `street`, `city`, `zip_code`) VALUES ( 10, 'test', 'test_doctor_city', '22-222');
-- INSERT INTO `doctor`(`first_name`, `surname`, `address_id`) VALUES ('test_doctor', 'test_surname', 1);


-- SELECT * FROM patient JOIN patient_address ON patient.address_id = patient_address.id;
-- SELECT * FROM patient_address;
-- SELECT * FROM patient;


SELECT * FROM doctor JOIN doctor_address ON doctor.address_id = doctor_address.id;
SELECT * FROM doctor;