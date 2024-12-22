-- Check if the database exists, if not, create it
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'pharmacy_management')
BEGIN
    CREATE DATABASE pharmacy_management;
END;

USE pharmacy_management;

CREATE TABLE roles (
    id INT IDENTITY(1,1) PRIMARY KEY,
    role_name VARCHAR(50) UNIQUE NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE()
);

-- Insert sample roles
INSERT INTO roles (role_name) VALUES ('admin'), ('employee');

CREATE TABLE users (
    id INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id INT NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Insert sample users
INSERT INTO users (username, password, role_id, full_name)
VALUES 
    ('admin', '123456', 1, 'System Administrator'),
    ('employee1', '123456', 2, 'Pharmacist 1'),
    ('employee2', '123456', 2, 'Pharmacist 2');

CREATE TABLE categories (
    id INT IDENTITY(1,1) PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL UNIQUE,
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE()
);

-- Insert sample categories
INSERT INTO categories (category_name)
VALUES ('Pain relief'), ('Antipyretic'), ('Vitamins');

CREATE TABLE medicines (
    id INT IDENTITY(1,1) PRIMARY KEY,
    medicine_name VARCHAR(255) NOT NULL,
    category_id INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Insert sample medicines
INSERT INTO medicines (medicine_name, category_id, price, stock)
VALUES
    ('Paracetamol', 1, 15000, 100),
    ('Aspirin', 2, 12000, 50),
    ('Vitamin C', 3, 8000, 200);

CREATE TABLE orders (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL,
    customer_name VARCHAR(255) NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    order_date DATETIME DEFAULT GETDATE(),
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Insert sample orders
INSERT INTO orders (user_id, customer_name, total_price)
VALUES
    (2, 'John Doe', 30000),
    (3, 'Jane Smith', 12000);

CREATE TABLE order_details (
    id INT IDENTITY(1,1) PRIMARY KEY,
    order_id INT NOT NULL,
    medicine_id INT NOT NULL,
    quantity INT NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (medicine_id) REFERENCES medicines(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Insert sample order details
INSERT INTO order_details (order_id, medicine_id, quantity, unit_price, total_price)
VALUES
    (1, 1, 2, 15000, 30000),
    (2, 2, 1, 12000, 12000);
