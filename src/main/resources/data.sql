-- coding: utf-8 --
INSERT INTO customer (name, contact, industry) VALUES ('CustomerA', 'a@example.com', 'IT');
INSERT INTO customer (name, contact, industry) VALUES ('CustomerB', 'b@example.com', 'Manufacturing');
INSERT INTO customer (name, contact, industry) VALUES ('CustomerC', 'c@example.com', 'Distribution');
INSERT INTO customer (name, contact, industry) VALUES ('CustomerD', 'd@example.com', 'Finance');
INSERT INTO customer (name, contact, industry) VALUES ('CustomerE', 'e@example.com', 'Service');
INSERT INTO customer (name, contact, industry) VALUES ('CustomerF', 'f@example.com', 'IT');
INSERT INTO customer (name, contact, industry) VALUES ('CustomerG', 'g@example.com', 'Manufacturing');
INSERT INTO customer (name, contact, industry) VALUES ('CustomerH', 'h@example.com', 'Distribution');
INSERT INTO customer (name, contact, industry) VALUES ('CustomerI', 'i@example.com', 'Finance');
INSERT INTO customer (name, contact, industry) VALUES ('CustomerJ', 'j@example.com', 'Service');

INSERT INTO project (customer_id, department_name, project_manager, project_leader, project_rank, sales_amount, start_date, end_date, project_type) VALUES (1, 'Sales', 'Tanaka', 'Sato', 'S', 10000, '2025-01-01', '2025-06-30', 'NEW_DEVELOPMENT');
INSERT INTO project (customer_id, department_name, project_manager, project_leader, project_rank, sales_amount, start_date, end_date, project_type) VALUES (2, 'Development', 'Suzuki', 'Takahashi', 'A', 8000, '2025-02-01', '2025-07-31', 'MAINTENANCE');
INSERT INTO project (customer_id, department_name, project_manager, project_leader, project_rank, sales_amount, start_date, end_date, project_type) VALUES (3, 'Planning', 'Sasaki', 'Ito', 'B', 6000, '2025-03-01', '2025-08-31', 'PACKAGE_INTRODUCTION');
INSERT INTO project (customer_id, department_name, project_manager, project_leader, project_rank, sales_amount, start_date, end_date, project_type) VALUES (4, 'Sales', 'Watanabe', 'Yamamoto', 'C', 4000, '2025-04-01', '2025-09-30', 'NEW_DEVELOPMENT');
INSERT INTO project (customer_id, department_name, project_manager, project_leader, project_rank, sales_amount, start_date, end_date, project_type) VALUES (5, 'Development', 'Nakamura', 'Kobayashi', 'D', 2000, '2025-05-01', '2025-10-31', 'MAINTENANCE');
INSERT INTO project (customer_id, department_name, project_manager, project_leader, project_rank, sales_amount, start_date, end_date, project_type) VALUES (6, 'Planning', 'Kato', 'Yoshida', 'S', 9000, '2025-06-01', '2025-11-30', 'PACKAGE_INTRODUCTION');
INSERT INTO project (customer_id, department_name, project_manager, project_leader, project_rank, sales_amount, start_date, end_date, project_type) VALUES (7, 'Sales', 'Yamada', 'Sato', 'A', 7000, '2025-07-01', '2025-12-31', 'NEW_DEVELOPMENT');
INSERT INTO project (customer_id, department_name, project_manager, project_leader, project_rank, sales_amount, start_date, end_date, project_type) VALUES (8, 'Development', 'Saito', 'Takahashi', 'B', 5000, '2025-08-01', '2026-01-31', 'MAINTENANCE');
INSERT INTO project (customer_id, department_name, project_manager, project_leader, project_rank, sales_amount, start_date, end_date, project_type) VALUES (9, 'Planning', 'Matsumoto', 'Ito', 'C', 3000, '2025-09-01', '2026-02-28', 'PACKAGE_INTRODUCTION');
INSERT INTO project (customer_id, department_name, project_manager, project_leader, project_rank, sales_amount, start_date, end_date, project_type) VALUES (10, 'Sales', 'Inoue', 'Yamamoto', 'D', 1000, '2025-10-01', '2026-03-31', 'NEW_DEVELOPMENT');
