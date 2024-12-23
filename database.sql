﻿-- Kiểm tra nếu database đã tồn tại, nếu không thì tạo mới
IF EXISTS (SELECT * FROM sys.databases WHERE name = 'PharmaCity')
BEGIN
    DROP DATABASE PharmaCity;
END;

GO

CREATE DATABASE PharmaCity;
GO

USE PharmaCity;
GO

-- Xóa bảng nếu đã tồn tại
IF EXISTS (SELECT * FROM sys.objects WHERE type = 'U' AND name = 'roles')
BEGIN
    DROP TABLE roles;
END;

GO

CREATE TABLE roles (
    id INT IDENTITY(1,1) PRIMARY KEY,
    role_name VARCHAR(50) UNIQUE NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE()
);
GO

-- Chèn dữ liệu mẫu vào bảng roles
INSERT INTO roles (role_name) VALUES ('admin'), ('employee');
GO

-- Xóa bảng nếu đã tồn tại
IF EXISTS (SELECT * FROM sys.objects WHERE type = 'U' AND name = 'users')
BEGIN
    DROP TABLE users;
END;

GO

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
GO

-- Chèn dữ liệu mẫu vào bảng users
INSERT INTO users (username, password, role_id, full_name)
VALUES 
    ('admin', '123456', 1, 'System Administrator'),
    ('employee1', '123456', 2, 'Pharmacist 1'),
    ('employee2', '123456', 2, 'Pharmacist 2');
GO

-- Xóa bảng nếu đã tồn tại
IF EXISTS (SELECT * FROM sys.objects WHERE type = 'U' AND name = 'categories')
BEGIN
    DROP TABLE categories;
END;

GO

CREATE TABLE categories (
    id INT IDENTITY(1,1) PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL UNIQUE,
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE()
);
GO

-- Chèn dữ liệu mẫu vào bảng categories
INSERT INTO categories (category_name)
VALUES ('Pain relief'), ('Antipyretic'), ('Vitamins');
GO

-- Xóa bảng nếu đã tồn tại
IF EXISTS (SELECT * FROM sys.objects WHERE type = 'U' AND name = 'medicines')
BEGIN
    DROP TABLE medicines;
END;

GO

CREATE TABLE medicines (
    id INT IDENTITY(1,1) PRIMARY KEY,
    medicine_name VARCHAR(255) NOT NULL,
    category_id INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    manufacturing_date DATETIME NOT NULL,
    expiry_date DATETIME NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE ON UPDATE CASCADE
);
GO

-- Chèn dữ liệu mẫu vào bảng medicines
INSERT INTO medicines (medicine_name, category_id, price, stock, manufacturing_date, expiry_date)
VALUES
    ('Paracetamol', 1, 15000, 100, '2023-01-01', '2025-01-01'),
    ('Aspirin', 2, 12000, 50, '2023-03-15', '2025-03-15'),
    ('Vitamin C', 3, 8000, 200, '2023-06-10', '2025-06-10');
GO

-- Xóa bảng nếu đã tồn tại
IF EXISTS (SELECT * FROM sys.objects WHERE type = 'U' AND name = 'orders')
BEGIN
    DROP TABLE orders;
END;

GO

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
GO

-- Chèn dữ liệu mẫu vào bảng orders
INSERT INTO orders (user_id, customer_name, total_price)
VALUES
    (2, 'John Doe', 30000),
    (3, 'Jane Smith', 12000);
GO

-- Xóa bảng nếu đã tồn tại
IF EXISTS (SELECT * FROM sys.objects WHERE type = 'U' AND name = 'order_details')
BEGIN
    DROP TABLE order_details;
END;

GO

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
GO

-- Chèn dữ liệu mẫu vào bảng order_details
INSERT INTO order_details (order_id, medicine_id, quantity, unit_price, total_price)
VALUES
    (1, 1, 2, 15000, 30000),
    (2, 2, 1, 12000, 12000);
GO
