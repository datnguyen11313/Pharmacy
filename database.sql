-- Kiểm tra nếu database đã tồn tại, nếu không thì tạo mới
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
    [expiry_date] DATETIME NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE ON UPDATE CASCADE
);
GO

alter table medicines
add
isDelete bit default 0

UPDATE medicines
SET isDelete = 0
WHERE isDelete IS NULL;

INSERT INTO medicines (medicine_name, category_id, price, stock, manufacturing_date, expiry_date)
VALUES 
('Paracetamol', 1, 5000, 100, '2023-01-01', '2025-01-01'),
('Ibuprofen', 1, 10000, 200, '2023-02-01', '2025-02-01'),
('Amoxicillin', 2, 15000, 150, '2023-03-01', '2025-03-01'),
('Ciprofloxacin', 2, 20000, 120, '2023-04-01', '2025-04-01'),
('Vitamin C', 3, 5000, 300, '2023-01-15', '2025-01-15'),
('Multivitamins', 3, 7000, 400, '2023-02-20', '2025-02-20'),
('Antacid Tablets', 4, 8000, 250, '2023-03-10', '2025-03-10'),
('Loratadine', 5, 12000, 180, '2023-04-05', '2025-04-05'),
('Metformin', 6, 14000, 160, '2023-05-01', '2025-05-01'),
('Insulin', 6, 30000, 90, '2023-06-01', '2025-06-01'),
('Aspirin', 1, 4000, 500, '2023-02-10', '2025-02-10'),
('Omeprazole', 4, 10000, 230, '2023-03-15', '2025-03-15'),
('Clarithromycin', 2, 22000, 110, '2023-04-20', '2025-04-20'),
('Zinc Supplements', 3, 6000, 350, '2023-01-25', '2025-01-25'),
('Calcium Tablets', 3, 9000, 270, '2023-02-15', '2025-02-15'),
('Cetirizine', 5, 11000, 240, '2023-03-05', '2025-03-05'),
('Azithromycin', 2, 25000, 80, '2023-04-15', '2025-04-15'),
('Doxycycline', 2, 18000, 130, '2023-05-10', '2025-05-10'),
('Folic Acid', 3, 4500, 400, '2023-06-01', '2025-06-01'),
('Probiotics', 4, 7500, 300, '2023-07-01', '2025-07-01');

INSERT INTO medicines (medicine_name, category_id, price, stock, manufacturing_date, expiry_date)
VALUES
('Naproxen', 1, 8000, 150, '2023-07-01', '2025-07-01'),
('Ranitidine', 4, 12000, 200, '2023-06-15', '2025-06-15'),
('Simethicone', 4, 6000, 180, '2023-08-01', '2025-08-01'),
('Prednisolone', 5, 15000, 90, '2023-09-01', '2025-09-01'),
('Vitamin D3', 3, 7000, 220, '2023-07-20', '2025-07-20'),
('Vitamin B12', 3, 6500, 250, '2023-08-15', '2025-08-15'),
('Calamine Lotion', 6, 9500, 100, '2023-05-25', '2025-05-25'),
('Amoxicillin-Clavulanic Acid', 2, 28000, 120, '2023-06-10', '2025-06-10'),
('Cefuroxime', 2, 22000, 110, '2023-06-20', '2025-06-20'),
('Losartan', 6, 18000, 140, '2023-05-01', '2025-05-01'),
('Amlodipine', 6, 17000, 150, '2023-06-15', '2025-06-15'),
('Clopidogrel', 6, 25000, 130, '2023-05-20', '2025-05-20'),
('Lisinopril', 6, 20000, 100, '2023-04-15', '2025-04-15'),
('Furosemide', 6, 14000, 160, '2023-06-05', '2025-06-05'),
('Hydrochlorothiazide', 6, 15000, 170, '2023-07-10', '2025-07-10'),
('Levofloxacin', 2, 27000, 100, '2023-05-25', '2025-05-25'),
('Metronidazole', 2, 13000, 300, '2023-03-15', '2025-03-15'),
('Ketoconazole', 4, 20000, 150, '2023-04-01', '2025-04-01'),
('Salbutamol', 5, 18000, 120, '2023-03-20', '2025-03-20'),
('Beclomethasone', 5, 24000, 100, '2023-06-01', '2025-06-01');

-- Cập nhật tất cả các dòng để đảm bảo isDelete = 0
UPDATE medicines
SET isDelete = 0
WHERE isDelete IS NULL;


-- Cập nhật tất cả các dòng để đảm bảo isDelete = 0
UPDATE medicines
SET isDelete = 0
WHERE isDelete IS NULL;



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


INSERT INTO categories (category_name)
VALUES 
    ('Antibiotics'), ('Antihistamines'), ('Supplements'), ('Analgesics'), ('Antacids');
GO

INSERT INTO medicines (medicine_name, category_id, price, stock, manufacturing_date, expiry_date)
VALUES
    ('Amoxicillin', 4, 50000, 60, '2023-02-01', '2025-02-01'),
    ('Cetirizine', 5, 20000, 150, '2023-04-10', '2025-04-10'),
    ('Calcium Tablets', 3, 25000, 80, '2023-01-20', '2025-01-20'),
    ('Ibuprofen', 1, 18000, 90, '2023-03-25', '2025-03-25'),
    ('Ranitidine', 5, 22000, 40, '2023-05-15', '2025-05-15');
GO

INSERT INTO orders (user_id, customer_name, total_price)
VALUES
    (2, 'Michael Brown', 70000),
    (3, 'Emily Davis', 25000),
    (2, 'Robert Johnson', 40000);
GO


INSERT INTO order_details (order_id, medicine_id, quantity, unit_price, total_price)
VALUES
    (1, 4, 2, 18000, 36000),
    (1, 5, 1, 22000, 22000),
    (2, 3, 1, 25000, 25000),
    (3, 2, 2, 20000, 40000);
GO

-- Cập nhật bảng roles để thêm cột isDelete
ALTER TABLE roles
ADD isDelete BIT DEFAULT 0;
GO

-- Cập nhật bảng users để thêm cột isDelete
ALTER TABLE users
ADD isDelete BIT DEFAULT 0;
GO


-- Cập nhật bảng categories để thêm cột isDelete
ALTER TABLE categories
ADD isDelete BIT DEFAULT 0;
GO


ALTER TABLE orders
ADD isDelete BIT DEFAULT 0;
GO

ALTER TABLE order_details
ADD isDelete BIT DEFAULT 0;
GO
-- Cập nhật bảng customers để thêm cột isDelete
ALTER TABLE customers
ADD isDelete BIT DEFAULT 0;
GO

-- Cập nhật bảng invoices để thêm cột isDelete
ALTER TABLE invoices
ADD isDelete BIT DEFAULT 0;
GO



-- Cập nhật bảng price_history để thêm cột isDelete
ALTER TABLE price_history
ADD isDelete BIT DEFAULT 0;
GO


-- Cập nhật bảng stock_history để thêm cột isDelete
ALTER TABLE stock_history
ADD isDelete BIT DEFAULT 0;
GO

-- Cập nhật bảng promotions để thêm cột isDelete
ALTER TABLE promotions
ADD isDelete BIT DEFAULT 0;
GO

-- Cập nhật bảng returns để thêm cột isDelete
ALTER TABLE returns
ADD isDelete BIT DEFAULT 0;
GO

-- Cập nhật bảng audit_logs để thêm cột isDelete
ALTER TABLE audit_logs
ADD isDelete BIT DEFAULT 0;
GO


-- Cập nhật bảng invoices để thêm cột isDelete
ALTER TABLE invoices
ADD isDelete BIT DEFAULT 0;
GO


CREATE TABLE customers (
    id INT IDENTITY(1,1) PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(15),
    email VARCHAR(100),
    address VARCHAR(500),
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE()
);
GO

-- Cập nhật bảng orders để tham chiếu bảng customers
ALTER TABLE orders
ADD customer_id INT;

-- Thêm khóa ngoại
ALTER TABLE orders
ADD FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE SET NULL ON UPDATE CASCADE;
GO

-- Tạo bảng invoices
CREATE TABLE invoices (
    id INT IDENTITY(1,1) PRIMARY KEY,
    order_id INT NOT NULL,
    invoice_date DATETIME DEFAULT GETDATE(),
    total_amount DECIMAL(10, 2) NOT NULL,
    amount_paid DECIMAL(10, 2) NOT NULL DEFAULT 0,
    payment_status VARCHAR(50) DEFAULT 'Unpaid',
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE ON UPDATE CASCADE
);
GO



-- Tạo bảng suppliers
CREATE TABLE suppliers (
    id INT IDENTITY(1,1) PRIMARY KEY,
    supplier_name VARCHAR(255) NOT NULL,
    contact_phone VARCHAR(15),
    contact_email VARCHAR(100),
    address VARCHAR(500),
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE()
);
GO

-- Cập nhật bảng medicines để liên kết với bảng suppliers
ALTER TABLE medicines
ADD supplier_id INT;

-- Thêm khóa ngoại
ALTER TABLE medicines
ADD FOREIGN KEY (supplier_id) REFERENCES suppliers(id) ON DELETE SET NULL ON UPDATE CASCADE;
GO


-- Tạo bảng price_history
CREATE TABLE price_history (
    id INT IDENTITY(1,1) PRIMARY KEY,
    medicine_id INT NOT NULL,
    old_price DECIMAL(10, 2) NOT NULL,
    new_price DECIMAL(10, 2) NOT NULL,
    change_date DATETIME DEFAULT GETDATE(),
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (medicine_id) REFERENCES medicines(id) ON DELETE CASCADE ON UPDATE CASCADE
);
GO


-- Tạo bảng stock_history
CREATE TABLE stock_history (
    id INT IDENTITY(1,1) PRIMARY KEY,
    medicine_id INT NOT NULL,
    change_type VARCHAR(50) NOT NULL, -- "Import" hoặc "Sale"
    quantity INT NOT NULL,
    change_date DATETIME DEFAULT GETDATE(),
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (medicine_id) REFERENCES medicines(id) ON DELETE CASCADE ON UPDATE CASCADE
);
GO


-- Tạo bảng promotions
CREATE TABLE promotions (
    id INT IDENTITY(1,1) PRIMARY KEY,
    medicine_id INT NOT NULL,
    discount_percent INT NOT NULL, -- Giảm giá theo phần trăm
    start_date DATETIME DEFAULT GETDATE(),
    end_date DATETIME,
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (medicine_id) REFERENCES medicines(id) ON DELETE CASCADE ON UPDATE CASCADE
);
GO


-- Tạo bảng returns
CREATE TABLE returns (
    id INT IDENTITY(1,1) PRIMARY KEY,
    order_id INT NOT NULL,
    medicine_id INT NOT NULL,
    quantity INT NOT NULL,
    reason VARCHAR(500),
    return_date DATETIME DEFAULT GETDATE(),
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (medicine_id) REFERENCES medicines(id) ON DELETE CASCADE ON UPDATE CASCADE
);
GO


-- Tạo bảng audit_logs
CREATE TABLE audit_logs (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL,
    action_type VARCHAR(50) NOT NULL,
    action_details VARCHAR(500) NOT NULL,
    action_time DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
);
GO
