DROP TABLE IF EXISTS roles CASCADE;

CREATE TABLE roles(
emp_role VARCHAR(20) PRIMARY KEY,
permissions BOOLEAN
);

DROP TABLE IF EXISTS departments CASCADE;

CREATE TABLE departments(
dept_num INTEGER PRIMARY KEY,
dept_name VARCHAR UNIQUE
);

DROP TABLE IF EXISTS employees;

CREATE TABLE employees(
empl_id SERIAL PRIMARY KEY,
first_name VARCHAR(30) UNIQUE,
last_name VARCHAR(30) UNIQUE,
username VARCHAR(15) UNIQUE NOT NULL,
emp_password VARCHAR(90)  UNIQUE NOT NULL,
hours_worked INTEGER
);


--defining departments
INSERT INTO departments(dept_num, dept_name)
VALUES (0, 'New Hires'), (1, 'Production'), (2, 'Sales'), (3, 'Human Resources');

--defining role values
INSERT INTO roles(emp_role, permissions)
VALUES ('employee', FALSE),
('manager', TRUE ),
('admin', TRUE);

--adding new columns for foreign keys; determine if employee is manager or admin
ALTER TABLE employees ADD COLUMN dept_num INTEGER REFERENCES departments(dept_num);
ALTER TABLE employees ADD COLUMN emp_role VARCHAR(20) REFERENCES roles(emp_role);

INSERT INTO employees(
first_name,
last_name,
username,
emp_password,
hours_worked,
dept_num,
emp_role
)
VALUES ('Dan', 'Danielson', 'DanTheMan4', 'password1', 9, 1, 'employee'),
('Juan', 'Johnson', 'Jdude33', 'password44', 8, 1, 'employee'),
('Nick', 'Elback', 'NickJr17', 'password2', 11, 1, 'manager'),
('Mike', 'Myers', 'MandM99', 'password5', 6, 2, 'employee'),
('Steve', 'Steven', 'oldguy61', 'password51', 4, 2, 'employee'),
('Samantha', 'Sanchez', 'Samager0', 'password3', 11, 2, 'manager'),
('Chloe', 'Clifford', 'BossGirl777', 'password777', 8, 3, 'admin');