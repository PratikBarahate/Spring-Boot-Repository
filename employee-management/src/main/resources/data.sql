insert into employee(employee_id, employee_name, employee_birth_date, employee_salary)
values(1001, 'Naveen', current_date(), 15633);

insert into employee(employee_id, employee_name, employee_birth_date, employee_salary)
values(1002, 'Pooja', current_date(), 78633.21);

insert into employee(employee_id, employee_name, employee_birth_date, employee_salary)
values(1003, 'Reshma', current_date(), 35600.45);


insert into project(project_id, project_name, employee_employee_id)
values(100001, 'Sigma', 1002);


insert into project(project_id, project_name, employee_employee_id)
values(100002, 'Dell', 1002);


insert into project(project_id, project_name, employee_employee_id)
values(100003, 'Sony', 1001);