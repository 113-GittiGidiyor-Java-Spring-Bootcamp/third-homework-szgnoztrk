INSERT INTO courses(course_id,course_code,course_credit_score,course_name,instructor_instructor_id) VALUES (1,'BM123',4,'Programlamaya Giriş',2);
INSERT INTO courses(course_id,course_code,course_credit_score,course_name,instructor_instructor_id) VALUES (2,'BM234',5,'Gömülü Sistemler',3);
INSERT INTO courses(course_id,course_code,course_credit_score,course_name,instructor_instructor_id) VALUES (3,'BM345',5,'Java Programlama',1);

INSERT INTO instructors(instructor_id,instructor_address,instructor_fullname,instructor_phone) VALUES (1,'İstanbul','Koray Güney',+905554443322);
INSERT INTO instructors(instructor_id,instructor_address,instructor_fullname,instructor_phone) VALUES (2,'Sakarya','Abdullah Talha Kabakuş',+906664443322);
INSERT INTO instructors(instructor_id,instructor_address,instructor_fullname,instructor_phone) VALUES (3,'Düzce','Resul Kara',+905559993322);

INSERT INTO permanent_instructor(vr_fixed_salary,instructor_id) VALUES (9000.0,2);

INSERT INTO STUDENTS(student_id,student_address,student_birthdate,student_fullname,student_gender) VALUES (1,'Esenyurt/İstanbul','1996-10-24','Sezgin Öztürk','Erkek');
INSERT INTO STUDENTS(student_id,student_address,student_birthdate,student_fullname,student_gender) VALUES (2,'Bağcılar/İstanbul','2001-02-06','İclal Boyacı','Kadın');
INSERT INTO STUDENTS(student_id,student_address,student_birthdate,student_fullname,student_gender) VALUES (3,'Kadıköy/İstanbul','1994-05-19','İrfan Can Kahveci','Erkek');
INSERT INTO STUDENTS(student_id,student_address,student_birthdate,student_fullname,student_gender) VALUES (4,'Avcılar/İstanbul','1996-04-22','Sezer Öztürk','Erkek');
INSERT INTO STUDENTS(student_id,student_address,student_birthdate,student_fullname,student_gender) VALUES (5,'Çan/Çanakkale','1999-12-06','Yağmur Azra','Kadın');


INSERT INTO students_courses(students_student_id,courses_course_id) VALUES (1,1);
INSERT INTO students_courses(students_student_id,courses_course_id) VALUES (1,2);
INSERT INTO students_courses(students_student_id,courses_course_id) VALUES (1,3);
INSERT INTO students_courses(students_student_id,courses_course_id) VALUES (2,3);
INSERT INTO students_courses(students_student_id,courses_course_id) VALUES (3,1);
INSERT INTO students_courses(students_student_id,courses_course_id) VALUES (3,2);
INSERT INTO students_courses(students_student_id,courses_course_id) VALUES (4,1);
INSERT INTO students_courses(students_student_id,courses_course_id) VALUES (4,3);

INSERT INTO visiting_researchers(vr_hourly_salary,instructor_id) VALUES (150.0,1);
INSERT INTO visiting_researchers(vr_hourly_salary,instructor_id) VALUES (200.0,3);