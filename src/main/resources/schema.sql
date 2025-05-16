CREATE TABLE customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact VARCHAR(255) NOT NULL,
    industry VARCHAR(255) NOT NULL
);

CREATE TABLE project (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    department_name VARCHAR(255) NOT NULL,
    project_manager VARCHAR(255) NOT NULL,
    project_leader VARCHAR(255) NOT NULL,
    project_rank VARCHAR(10) NOT NULL,
    sales_amount INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    project_type VARCHAR(30) NOT NULL,
    CONSTRAINT fk_project_customer FOREIGN KEY (customer_id) REFERENCES customer(id)
);
