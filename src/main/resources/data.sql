/*
INSERT INTO patient (name, birth_date, email, gender, blood_group)
VALUES
('Rahul Sharma', '1998-05-12', 'rahul.sharma@gmail.com', 'Male', 'A_POSITIVE'),
('Priya Verma', '2000-08-22', 'priya.verma@gmail.com', 'Female', 'B_POSITIVE'),
('Amit Singh', '1995-12-10', 'amit.singh@gmail.com', 'Male', 'O_POSITIVE'),
('Neha Gupta', '2001-03-18', 'neha.gupta@gmail.com', 'Female', 'AB_POSITIVE'),
('Karan Mehta', '1997-07-25', 'karan.mehta@gmail.com', 'Male', 'A_NEGATIVE');


INSERT INTO doctor (name, specialization, email)
VALUES
('Dr. Arjun Mehta', 'Cardiology', 'arjun.mehta@hospital.com'),
('Dr. Sneha Verma', 'Neurology', 'sneha.verma@hospital.com'),
('Dr. Rohan Sharma', 'Orthopedics', 'rohan.sharma@hospital.com'),
('Dr. Priya Nair', 'Dermatology', 'priya.nair@hospital.com'),
('Dr. Kunal Singh', 'Pediatrics', 'kunal.singh@hospital.com');

INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
VALUES
('2026-04-01 10:00:00', 'Regular health checkup', 1, 1),
('2026-04-02 11:30:00', 'Migraine and headache consultation', 2, 2),
('2026-04-03 09:15:00', 'Knee pain and joint stiffness', 3, 3),
('2026-04-04 14:00:00', 'Skin allergy and itching', 4, 4),
('2026-04-05 16:45:00', 'Child fever and cold symptoms', 5, 5),
('2026-04-06 12:00:00', 'Heart palpitations and chest discomfort', 1, 1),
('2026-04-07 15:20:00', 'Back pain after gym injury', 2, 3),
('2026-04-08 10:40:00', 'Routine pediatric consultation', 3, 5),
('2026-04-09 13:10:00', 'Acne and skin rash treatment', 4, 4),
('2026-04-10 17:00:00', 'Follow-up for neurological evaluation', 5, 2);
*/