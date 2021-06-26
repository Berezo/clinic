INSERT INTO `patient_address`(`house_number`, `street`, `city`, `zip_code`) VALUES ( '1a', 'Jarominiaka', 'Zabrze', '72-672');
INSERT INTO `patient`(`first_name`, `surname`, `address_id`) VALUES ('Tadeusz', 'Laskowski', 1);
INSERT INTO `patient_address`(`house_number`, `street`, `city`, `zip_code`) VALUES ( 12, 'Słowiańska', 'Kraków', '96-410');
INSERT INTO `patient`(`first_name`, `surname`, `address_id`) VALUES ('Brigida', 'Pawlak', 2);
INSERT INTO `patient_address`(`house_number`, `street`, `city`, `zip_code`) VALUES ( 7, 'Rzemieślnicza', 'Elbląg', '59-709');
INSERT INTO `patient`(`first_name`, `surname`, `address_id`) VALUES ('Klaudia', 'Michalik', 3);
INSERT INTO `patient_address`(`house_number`, `street`, `city`, `zip_code`) VALUES ( 36, 'Łąkowa', 'Częstochowa', '50-866');
INSERT INTO `patient`(`first_name`, `surname`, `address_id`) VALUES ('Natalia', 'Baran', 4);
INSERT INTO `patient_address`(`house_number`, `street`, `city`, `zip_code`) VALUES ( '5b', 'Zimowa', 'Koszalin', '67-078');
INSERT INTO `patient`(`first_name`, `surname`, `address_id`) VALUES ('Jakub', 'Ostrowski', 5);
INSERT INTO `patient_address`(`house_number`, `street`, `city`, `zip_code`) VALUES ( 70, 'Kasztanowa', 'Olsztyn', '49-400');
INSERT INTO `patient`(`first_name`, `surname`, `address_id`) VALUES ('Dorian', 'Chojnacki', 6);


INSERT INTO `doctor_address`(`house_number`, `street`, `city`, `zip_code`) VALUES ( 10, 'Gołuńska', 'Bydgoszcz', '269-327');
INSERT INTO `doctor`(`first_name`, `surname`, `address_id`) VALUES ('Patch', 'Adams', 1);
INSERT INTO `doctor_address`(`house_number`, `street`, `city`, `zip_code`) VALUES ( 13, 'Kasztanowa', 'Elbląg', '87-965');
INSERT INTO `doctor`(`first_name`, `surname`, `address_id`) VALUES ('Gregory', 'House', 2);
INSERT INTO `doctor_address`(`house_number`, `street`, `city`, `zip_code`) VALUES ( 6, 'Leśna', 'Suwałki', '57-920');
INSERT INTO `doctor`(`first_name`, `surname`, `address_id`) VALUES ('Jim', 'Turk', 3);


INSERT INTO `office_hours`(`doctor_id`, `day`, `start_hour`, `end_hour`) VALUES (1, 5, '8:15', '16:15');
INSERT INTO `office_hours`(`doctor_id`, `day`, `start_hour`, `end_hour`) VALUES (1, 1, '8:15', '16:15');
INSERT INTO `office_hours`(`doctor_id`, `day`, `start_hour`, `end_hour`) VALUES (1, 2, '8:15', '16:15');
INSERT INTO `office_hours`(`doctor_id`, `day`, `start_hour`, `end_hour`) VALUES (2, 4, '8:15', '16:15');
INSERT INTO `office_hours`(`doctor_id`, `day`, `start_hour`, `end_hour`) VALUES (2, 3, '8:15', '16:15');
INSERT INTO `office_hours`(`doctor_id`, `day`, `start_hour`, `end_hour`) VALUES (3, 5, '16:15', '20:00');
INSERT INTO `office_hours`(`doctor_id`, `day`, `start_hour`, `end_hour`) VALUES (3, 1, '16:15', '20:00');
INSERT INTO `office_hours`(`doctor_id`, `day`, `start_hour`, `end_hour`) VALUES (3, 3, '16:15', '20:00');
INSERT INTO `office_hours`(`doctor_id`, `day`, `start_hour`, `end_hour`) VALUES (3, 2, '16:15', '20:00');
INSERT INTO `office_hours`(`doctor_id`, `day`, `start_hour`, `end_hour`) VALUES (3, 3, '16:15', '20:00');

INSERT INTO `visit`(`patient_id`, `doctor_id`, `is_examination`, `patient_description`, `doctor_description`, `prescription_id`, `registration_date`, `visit_date`, `visit_made`, `cancel_cause`)
VALUES(1,1,false,'boli mnie brzuch.','',null,'2021-05-12','2021-05-13 8:15', false, '');

INSERT INTO `prescription`(`description`, `medicines`)
VALUES('dwa razy dziennie rano i wieczorek brać 1 tabletkę', 'rutinoskorbin');
INSERT INTO `visit`(`patient_id`, `doctor_id`, `is_examination`, `patient_description`, `doctor_description`,`prescription_id`, `registration_date`, `visit_date`, `visit_made`, `cancel_cause`)
VALUES(2,2,false,'Nic nie wiedzę.','Pacient nie widział, ale już widzi.',1,'2021-05-21','2021-05-22 8:15', true, null);

INSERT INTO `visit`(`patient_id`, `doctor_id`, `is_examination`, `patient_description`, `doctor_description`, `prescription_id`, `registration_date`, `visit_date`, `visit_made`, `cancel_cause`)
VALUES(3,3,false,'Mam katar',null,null,'2021-05-21','2021-05-22 16:30', false, 'Przestałem mieć katar');

INSERT INTO `users` (`username`,`password`,`enabled`) VALUES ('admin', '$2a$10$IW0jBlYMEdHivodxyANe0OGama9pyhGyEwFHRSrWeONVdBkVOHX8e', TRUE); -- haslo: admin
INSERT INTO `users` (`username`,`password`,`enabled`,`doctor_id`) VALUES ('doctor', '$2a$10$V0pN8/JA..J3xBcss/goYeLK8Bf2F0KzgXbQAtaqMQommzVwKBlwi', TRUE,1); -- haslo: doctor
INSERT INTO `users` (`username`,`password`,`enabled`,`patient_id`) VALUES ('patient', '$2a$10$Psx.sMBsZ2VZyEU.AaHapeummvXNlsn.FObhWOVk73uY9KVBubaZa', TRUE,1); -- haslo: patient

INSERT INTO `authorities` (`username`,`authority`) values ('admin','ROLE_ADMIN');
INSERT INTO `authorities` (`username`,`authority`) values ('admin','ROLE_DOCTOR');
INSERT INTO `authorities` (`username`,`authority`) values ('admin','ROLE_PATIENT');
INSERT INTO `authorities` (`username`,`authority`) values ('doctor','ROLE_DOCTOR');
INSERT INTO `authorities` (`username`,`authority`) values ('patient','ROLE_PATIENT');

SELECT * FROM patient JOIN patient_address ON patient.address_id = patient_address.id;


SELECT * FROM doctor JOIN doctor_address ON doctor.address_id = doctor_address.id;


SELECT * FROM prescription;


SELECT v.id, v.is_examination, v.patient_description, v.doctor_description, v.registration_date, v.visit_date, v.visit_made, v.cancel_cause,
d.first_name, d.surname,
p.first_name AS 'patient_first_name', p.surname AS 'patient_surname',
pre.description, pre.medicines
FROM visit as v
JOIN doctor AS d ON v.doctor_id=d.id
JOIN patient AS p ON v.patient_id=p.id
LEFT JOIN prescription AS pre ON v.prescription_id = pre.id;


SELECT d.first_name, d.surname, o.day, o.start_hour, o.end_hour
FROM doctor AS d
JOIN office_hours AS o ON o.doctor_id=d.id;