USE [PharmaCity]
GO
/****** Object:  Table [dbo].[categories]    Script Date: 1/3/2025 5:33:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[categories](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[category_name] [nvarchar](100) NOT NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NOT NULL,
	[picture] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[customers]    Script Date: 1/3/2025 5:33:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customers](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[full_name] [nvarchar](255) NOT NULL,
	[phone_number] [nvarchar](15) NULL,
	[email] [nvarchar](100) NULL,
	[address] [nvarchar](500) NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NOT NULL,
	[picture] [nvarchar](255) NULL,
	[date_of_birth] [date] NULL,
	[customer_type] [nvarchar](50) NULL,
	[points] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[employee]    Script Date: 1/3/2025 5:33:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[employee](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[full_name] [nvarchar](255) NOT NULL,
	[phone_number] [nvarchar](15) NULL,
	[email] [nvarchar](100) NULL,
	[address] [nvarchar](500) NULL,
	[identity_card] [nvarchar](12) NULL,
	[picture] [nvarchar](255) NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NOT NULL,
	[role] [int] NULL,
	[salary] [decimal](10, 2) NULL,
	[start_date] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[invoices]    Script Date: 1/3/2025 5:33:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[invoices](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[order_id] [int] NOT NULL,
	[invoice_date] [datetime] NULL,
	[total_amount] [decimal](10, 2) NOT NULL,
	[amount_paid] [decimal](10, 2) NOT NULL,
	[payment_status] [nvarchar](50) NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NOT NULL,
	[picture] [nvarchar](255) NULL,
	[customer_name] [nvarchar](255) NULL,
	[customer_address] [nvarchar](255) NULL,
	[customer_phone] [nvarchar](15) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[medicines]    Script Date: 1/3/2025 5:33:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[medicines](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[medicine_name] [nvarchar](255) NOT NULL,
	[category_id] [int] NOT NULL,
	[price] [money] NULL,
	[stock] [int] NOT NULL,
	[manufacturing_date] [datetime] NOT NULL,
	[expiry_date] [datetime] NOT NULL,
	[picture] [nvarchar](255) NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NOT NULL,
	[supplier_id] [int] NULL,
	[unit] [nvarchar](50) NULL,
	[concentration] [nvarchar](50) NULL,
	[usage] [nvarchar](max) NULL,
	[contraindications] [nvarchar](max) NULL,
	[side_effects] [nvarchar](max) NULL,
	[storage] [nvarchar](max) NULL,
	[ingredients] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[order_details]    Script Date: 1/3/2025 5:33:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_details](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[order_id] [int] NOT NULL,
	[medicine_id] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[unit_price] [decimal](10, 2) NOT NULL,
	[total_price] [decimal](10, 2) NOT NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NOT NULL,
	[picture] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orders]    Script Date: 1/3/2025 5:33:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orders](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[customer_name] [nvarchar](255) NOT NULL,
	[total_price] [decimal](10, 2) NOT NULL,
	[order_date] [datetime] NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NOT NULL,
	[customer_id] [int] NULL,
	[employee_id] [int] NULL,
	[picture] [nvarchar](255) NULL,
	[payment_method] [nvarchar](50) NULL,
	[status] [nvarchar](50) NULL,
	[notes] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[price_history]    Script Date: 1/3/2025 5:33:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[price_history](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[medicine_id] [int] NOT NULL,
	[old_price] [decimal](10, 2) NOT NULL,
	[new_price] [decimal](10, 2) NOT NULL,
	[change_date] [datetime] NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NOT NULL,
	[picture] [nvarchar](255) NULL,
	[employee_id] [int] NULL,
	[reason] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[promotions]    Script Date: 1/3/2025 5:33:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[promotions](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[medicine_id] [int] NOT NULL,
	[discount_percent] [int] NOT NULL,
	[start_date] [datetime] NULL,
	[end_date] [datetime] NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NOT NULL,
	[picture] [nvarchar](255) NULL,
	[description] [nvarchar](max) NULL,
	[conditions] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[returns]    Script Date: 1/3/2025 5:33:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[returns](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[order_id] [int] NOT NULL,
	[medicine_id] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[reason] [nvarchar](500) NULL,
	[return_date] [datetime] NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NOT NULL,
	[picture] [nvarchar](255) NULL,
	[employee_id] [int] NULL,
	[status] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[roles]    Script Date: 1/3/2025 5:33:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[roles](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[role_name] [nvarchar](50) NOT NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NOT NULL,
	[picture] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[stock_history]    Script Date: 1/3/2025 5:33:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[stock_history](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[medicine_id] [int] NOT NULL,
	[change_type] [nvarchar](50) NOT NULL,
	[quantity] [int] NOT NULL,
	[change_date] [datetime] NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NOT NULL,
	[picture] [nvarchar](255) NULL,
	[employee_id] [int] NULL,
	[reason] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[suppliers]    Script Date: 1/3/2025 5:33:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[suppliers](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[supplier_name] [nvarchar](255) NOT NULL,
	[contact_phone] [nvarchar](15) NULL,
	[contact_email] [nvarchar](100) NULL,
	[address] [nvarchar](500) NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NOT NULL,
	[picture] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 1/3/2025 5:33:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](255) NOT NULL,
	[role_id] [int] NOT NULL,
	[full_name] [nvarchar](255) NOT NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NOT NULL,
	[employee_id] [int] NULL,
	[picture] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[categories] ON 
GO
INSERT [dbo].[categories] ([id], [category_name], [created_at], [updated_at], [isDelete], [picture]) VALUES (1, N'Thuốc giảm đau', CAST(N'2025-01-03T16:49:54.303' AS DateTime), CAST(N'2025-01-03T16:49:54.303' AS DateTime), 0, N'images//pain_relief.png')
GO
INSERT [dbo].[categories] ([id], [category_name], [created_at], [updated_at], [isDelete], [picture]) VALUES (2, N'Thuốc kháng sinh', CAST(N'2025-01-03T16:49:54.303' AS DateTime), CAST(N'2025-01-03T16:49:54.303' AS DateTime), 0, N'images//antibiotics.png')
GO
INSERT [dbo].[categories] ([id], [category_name], [created_at], [updated_at], [isDelete], [picture]) VALUES (3, N'Thuốc ho', CAST(N'2025-01-03T16:49:54.303' AS DateTime), CAST(N'2025-01-03T16:49:54.303' AS DateTime), 0, N'images//cough_medicine.png')
GO
INSERT [dbo].[categories] ([id], [category_name], [created_at], [updated_at], [isDelete], [picture]) VALUES (4, N'Vitamin và khoáng chất', CAST(N'2025-01-03T16:49:54.303' AS DateTime), CAST(N'2025-01-03T16:49:54.303' AS DateTime), 0, N'images//vitamins.png')
GO
SET IDENTITY_INSERT [dbo].[categories] OFF
GO
SET IDENTITY_INSERT [dbo].[customers] ON 
GO
INSERT [dbo].[customers] ([id], [full_name], [phone_number], [email], [address], [created_at], [updated_at], [isDelete], [picture], [date_of_birth], [customer_type], [points]) VALUES (1, N'Phạm Thị Lan', N'0909876543', N'ptlan@example.com', N'123 Đường A, Quận 1, TP.HCM', CAST(N'2025-01-03T16:55:13.957' AS DateTime), CAST(N'2025-01-03T16:55:13.957' AS DateTime), 0, N'images//customer1.png', CAST(N'1990-05-20' AS Date), N'Thường xuyên', 120)
GO
INSERT [dbo].[customers] ([id], [full_name], [phone_number], [email], [address], [created_at], [updated_at], [isDelete], [picture], [date_of_birth], [customer_type], [points]) VALUES (2, N'Nguyễn Văn Hùng', N'0987654321', N'nvhung@example.com', N'456 Đường B, Quận 2, TP.HCM', CAST(N'2025-01-03T16:55:13.957' AS DateTime), CAST(N'2025-01-03T16:55:13.957' AS DateTime), 0, N'images//customer2.png', CAST(N'1985-08-12' AS Date), N'VIP', 500)
GO
INSERT [dbo].[customers] ([id], [full_name], [phone_number], [email], [address], [created_at], [updated_at], [isDelete], [picture], [date_of_birth], [customer_type], [points]) VALUES (3, N'Trần Thị Hương', N'0912345678', N'tthuong@example.com', N'789 Đường C, Quận 3, TP.HCM', CAST(N'2025-01-03T16:55:13.957' AS DateTime), CAST(N'2025-01-03T16:55:13.957' AS DateTime), 0, N'images//customer3.png', CAST(N'1995-11-05' AS Date), N'Thường xuyên', 50)
GO
INSERT [dbo].[customers] ([id], [full_name], [phone_number], [email], [address], [created_at], [updated_at], [isDelete], [picture], [date_of_birth], [customer_type], [points]) VALUES (4, N'Nguyễn Văn A', N'0909876543', N'nguyenvana@email.com', N'123 Đường A, Quận 1, TP.HCM', CAST(N'2025-01-03T17:09:07.773' AS DateTime), CAST(N'2025-01-03T17:09:07.773' AS DateTime), 0, N'images//customerA.png', CAST(N'1990-05-20' AS Date), N'Thường xuyên', 100)
GO
INSERT [dbo].[customers] ([id], [full_name], [phone_number], [email], [address], [created_at], [updated_at], [isDelete], [picture], [date_of_birth], [customer_type], [points]) VALUES (5, N'Lê Thị B', N'0987654321', N'lethib@email.com', N'456 Đường B, Quận 2, TP.HCM', CAST(N'2025-01-03T17:09:07.773' AS DateTime), CAST(N'2025-01-03T17:09:07.773' AS DateTime), 0, N'images//customerB.png', CAST(N'1985-08-12' AS Date), N'VIP', 500)
GO
INSERT [dbo].[customers] ([id], [full_name], [phone_number], [email], [address], [created_at], [updated_at], [isDelete], [picture], [date_of_birth], [customer_type], [points]) VALUES (6, N'Trần Văn C', N'0913579246', N'tranvanc@email.com', N'789 Đường C, Quận 3, TP.HCM', CAST(N'2025-01-03T17:09:07.773' AS DateTime), CAST(N'2025-01-03T17:09:07.773' AS DateTime), 0, N'images//customerC.png', CAST(N'1995-11-05' AS Date), N'Thường xuyên', 50)
GO
INSERT [dbo].[customers] ([id], [full_name], [phone_number], [email], [address], [created_at], [updated_at], [isDelete], [picture], [date_of_birth], [customer_type], [points]) VALUES (7, N'Phạm Thị D', N'0947896541', N'phamthid@email.com', N'321 Đường D, Quận 4, TP.HCM', CAST(N'2025-01-03T17:09:07.773' AS DateTime), CAST(N'2025-01-03T17:09:07.773' AS DateTime), 0, N'images//customerD.png', CAST(N'1992-02-15' AS Date), N'Thường xuyên', 200)
GO
INSERT [dbo].[customers] ([id], [full_name], [phone_number], [email], [address], [created_at], [updated_at], [isDelete], [picture], [date_of_birth], [customer_type], [points]) VALUES (8, N'Hoàng Văn E', N'0931234567', N'hoangvane@email.com', N'654 Đường E, Quận 5, TP.HCM', CAST(N'2025-01-03T17:09:07.773' AS DateTime), CAST(N'2025-01-03T17:09:07.773' AS DateTime), 0, N'images//customerE.png', CAST(N'1980-09-09' AS Date), N'VIP', 300)
GO
SET IDENTITY_INSERT [dbo].[customers] OFF
GO
SET IDENTITY_INSERT [dbo].[employee] ON 
GO
INSERT [dbo].[employee] ([id], [full_name], [phone_number], [email], [address], [identity_card], [picture], [created_at], [updated_at], [isDelete], [role], [salary], [start_date]) VALUES (1, N'Nhân viên 1', N'0901234567', N'employee1@example.com', N'123 Đường A, Thành phố X', N'123456789', N'images//employee1.png', CAST(N'2025-01-03T16:54:31.210' AS DateTime), CAST(N'2025-01-03T16:54:31.210' AS DateTime), 0, 2, CAST(5000000.00 AS Decimal(10, 2)), CAST(N'2025-01-01' AS Date))
GO
INSERT [dbo].[employee] ([id], [full_name], [phone_number], [email], [address], [identity_card], [picture], [created_at], [updated_at], [isDelete], [role], [salary], [start_date]) VALUES (2, N'Nhân viên 2', N'0907654321', N'employee2@example.com', N'456 Đường B, Thành phố Y', N'987654321', N'images//employee2.png', CAST(N'2025-01-03T16:54:31.210' AS DateTime), CAST(N'2025-01-03T16:54:31.210' AS DateTime), 0, 2, CAST(4500000.00 AS Decimal(10, 2)), CAST(N'2025-02-01' AS Date))
GO
SET IDENTITY_INSERT [dbo].[employee] OFF
GO
SET IDENTITY_INSERT [dbo].[medicines] ON 
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (1, N'Paracetamol 500mg', 1, 15000.0000, 100, CAST(N'2024-01-01T00:00:00.000' AS DateTime), CAST(N'2026-01-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:02:58.893' AS DateTime), CAST(N'2025-01-03T17:02:58.893' AS DateTime), 0, 1, N'Viên nén', N'500mg', N'Uống 1-2 viên mỗi 4-6 giờ khi cần.', N'Mẫn cảm với paracetamol.', N'Buồn nôn, đau bụng.', N'Khô ráo, thoáng mát.', N'Paracetamol')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (2, N'Aspirin 81mg', 1, 12000.0000, 80, CAST(N'2024-03-01T00:00:00.000' AS DateTime), CAST(N'2026-03-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:02:58.893' AS DateTime), CAST(N'2025-01-03T17:02:58.893' AS DateTime), 0, 2, N'Viên nén', N'81mg', N'Uống 1 viên mỗi ngày.', N'Mẫn cảm với aspirin.', N'Chảy máu dạ dày.', N'Khô ráo, thoáng mát.', N'Aspirin')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (3, N'Ibuprofen 200mg', 1, 20000.0000, 90, CAST(N'2024-02-01T00:00:00.000' AS DateTime), CAST(N'2026-02-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:02:58.893' AS DateTime), CAST(N'2025-01-03T17:02:58.893' AS DateTime), 0, 1, N'Viên nén', N'200mg', N'Uống 1-2 viên mỗi 6-8 giờ.', N'Mẫn cảm với ibuprofen.', N'Buồn nôn, chóng mặt.', N'Khô ráo, thoáng mát.', N'Ibuprofen')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (4, N'Amoxicillin 500mg', 2, 50000.0000, 60, CAST(N'2024-02-01T00:00:00.000' AS DateTime), CAST(N'2026-02-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:02:58.893' AS DateTime), CAST(N'2025-01-03T17:02:58.893' AS DateTime), 0, 1, N'Viên nang', N'500mg', N'Uống 1 viên mỗi 8 giờ.', N'Mẫn cảm với penicillin.', N'Tiêu chảy, phát ban.', N'Khô ráo, thoáng mát.', N'Amoxicillin')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (5, N'Ciprofloxacin 500mg', 2, 40000.0000, 50, CAST(N'2024-03-01T00:00:00.000' AS DateTime), CAST(N'2026-03-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:02:58.893' AS DateTime), CAST(N'2025-01-03T17:02:58.893' AS DateTime), 0, 2, N'Viên nén', N'500mg', N'Uống 1 viên mỗi 12 giờ.', N'Không dùng cho trẻ dưới 18 tuổi.', N'Đau đầu, tiêu chảy.', N'Khô ráo, thoáng mát.', N'Ciprofloxacin')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (6, N'Azithromycin 500mg', 2, 70000.0000, 40, CAST(N'2024-04-01T00:00:00.000' AS DateTime), CAST(N'2026-04-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:02:58.893' AS DateTime), CAST(N'2025-01-03T17:02:58.893' AS DateTime), 0, 1, N'Viên nén', N'500mg', N'Uống 1 viên mỗi ngày.', N'Mẫn cảm với macrolide.', N'Nôn, đau bụng.', N'Khô ráo, thoáng mát.', N'Azithromycin')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (7, N'Terpin Codein 100ml', 3, 20000.0000, 80, CAST(N'2024-05-01T00:00:00.000' AS DateTime), CAST(N'2026-05-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:02:58.893' AS DateTime), CAST(N'2025-01-03T17:02:58.893' AS DateTime), 0, 1, N'Si-rô', N'100ml', N'Uống 10ml mỗi 4-6 giờ.', N'Mẫn cảm với codein.', N'Buồn ngủ.', N'Khô ráo, thoáng mát.', N'Terpin hydrat, Codein')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (8, N'Prospan 100ml', 3, 30000.0000, 90, CAST(N'2024-06-01T00:00:00.000' AS DateTime), CAST(N'2026-06-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:02:58.893' AS DateTime), CAST(N'2025-01-03T17:02:58.893' AS DateTime), 0, 1, N'Si-rô', N'100ml', N'Uống 5ml mỗi 8 giờ.', N'Mẫn cảm với thành phần.', N'Nôn, chóng mặt.', N'Khô ráo, thoáng mát.', N'Chiết xuất lá thường xuân')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (9, N'Bisolvon 100ml', 3, 25000.0000, 70, CAST(N'2024-07-01T00:00:00.000' AS DateTime), CAST(N'2026-07-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:02:58.893' AS DateTime), CAST(N'2025-01-03T17:02:58.893' AS DateTime), 0, 1, N'Si-rô', N'100ml', N'Uống 5ml mỗi 6-8 giờ.', N'Mẫn cảm với bromhexin.', N'Buồn nôn.', N'Khô ráo, thoáng mát.', N'Bromhexin hydrochloride')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (10, N'Thuốc Ỉa Chải', 1, 10000.0000, 100, CAST(N'2024-04-01T00:00:00.000' AS DateTime), CAST(N'2026-04-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:02:58.893' AS DateTime), CAST(N'2025-01-03T17:02:58.893' AS DateTime), 0, 1, N'Viên nén', N'2mg', N'Uống 2 viên sau lần tiêu chảy đầu tiên.', N'Không dùng cho trẻ dưới 6 tuổi.', N'Táo bón.', N'Khô ráo, thoáng mát.', N'Loperamid hydrochloride')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (11, N'Vitamin C 1000mg', 4, 20000.0000, 200, CAST(N'2024-03-01T00:00:00.000' AS DateTime), CAST(N'2026-03-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:02:58.893' AS DateTime), CAST(N'2025-01-03T17:02:58.893' AS DateTime), 0, 1, N'Viên sủi', N'1000mg', N'Hòa tan 1 viên trong nước, uống mỗi ngày.', N'Không dùng cho người bị sỏi thận.', N'Tiêu chảy.', N'Khô ráo, thoáng mát.', N'Vitamin C')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (12, N'Vitamin D3 2000IU', 4, 30000.0000, 150, CAST(N'2024-05-01T00:00:00.000' AS DateTime), CAST(N'2026-05-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:02:58.893' AS DateTime), CAST(N'2025-01-03T17:02:58.893' AS DateTime), 0, 1, N'Viên nén', N'2000IU', N'Uống 1 viên mỗi ngày.', N'Tăng canxi máu.', N'Táo bón.', N'Khô ráo, thoáng mát.', N'Vitamin D3')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (13, N'Multivitamin', 4, 50000.0000, 100, CAST(N'2024-06-01T00:00:00.000' AS DateTime), CAST(N'2026-06-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:02:58.893' AS DateTime), CAST(N'2025-01-03T17:02:58.893' AS DateTime), 0, 1, N'Viên nang', NULL, N'Uống 1 viên mỗi ngày.', N'Mẫn cảm với thành phần.', N'Rối loạn tiêu hóa.', N'Khô ráo, thoáng mát.', N'Vitamin A, B, C, D, E, Khoáng chất')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (14, N'Thuốc Cương Cứng', 3, 10000.0000, 100, CAST(N'2024-04-01T00:00:00.000' AS DateTime), CAST(N'2026-04-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:02:58.893' AS DateTime), CAST(N'2025-01-03T17:02:58.893' AS DateTime), 0, 1, N'Viên nén', N'2mg', N'Uống 2 viên sau lần tiêu chảy đầu tiên.', N'Không dùng cho trẻ dưới 6 tuổi.', N'Táo bón.', N'Khô ráo, thoáng mát.', N'Loperamid hydrochloride')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (22, N'Omeprazol 20mg', 3, 25000.0000, 150, CAST(N'2024-07-01T00:00:00.000' AS DateTime), CAST(N'2026-07-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:07:20.913' AS DateTime), CAST(N'2025-01-03T17:07:20.913' AS DateTime), 0, 2, N'Viên nang', N'20mg', N'Uống 1 viên trước bữa sáng.', N'Mẫn cảm với omeprazol.', N'Táo bón.', N'Khô ráo, thoáng mát.', N'Omeprazol')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (23, N'Ranitidine 150mg', 3, 20000.0000, 130, CAST(N'2024-08-01T00:00:00.000' AS DateTime), CAST(N'2026-08-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:07:20.913' AS DateTime), CAST(N'2025-01-03T17:07:20.913' AS DateTime), 0, 2, N'Viên nén', N'150mg', N'Uống 1 viên 2 lần/ngày.', N'Mẫn cảm với ranitidine.', N'Buồn nôn.', N'Khô ráo, thoáng mát.', N'Ranitidine')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (24, N'Ferrous Sulfate 325mg', 4, 30000.0000, 200, CAST(N'2024-09-01T00:00:00.000' AS DateTime), CAST(N'2026-09-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:07:20.913' AS DateTime), CAST(N'2025-01-03T17:07:20.913' AS DateTime), 0, 1, N'Viên nén', N'325mg', N'Uống 1 viên mỗi ngày.', N'Không dùng cho người bị thừa sắt.', N'Buồn nôn, tiêu chảy.', N'Khô ráo, thoáng mát.', N'Ferrous Sulfate')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (25, N'Folic Acid 5mg', 4, 15000.0000, 250, CAST(N'2024-10-01T00:00:00.000' AS DateTime), CAST(N'2026-10-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:07:20.913' AS DateTime), CAST(N'2025-01-03T17:07:20.913' AS DateTime), 0, 1, N'Viên nén', N'5mg', N'Uống 1 viên mỗi ngày.', N'Mẫn cảm với thành phần.', N'Nổi mẩn.', N'Khô ráo, thoáng mát.', N'Folic Acid')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (26, N'Vitamin E 400IU', 4, 20000.0000, 180, CAST(N'2024-11-01T00:00:00.000' AS DateTime), CAST(N'2026-11-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:07:20.913' AS DateTime), CAST(N'2025-01-03T17:07:20.913' AS DateTime), 0, 2, N'Viên nang', N'400IU', N'Uống 1 viên mỗi ngày.', N'Mẫn cảm với vitamin E.', N'Buồn nôn.', N'Khô ráo, thoáng mát.', N'Vitamin E')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (27, N'Canxi Carbonate 500mg', 4, 25000.0000, 150, CAST(N'2024-12-01T00:00:00.000' AS DateTime), CAST(N'2026-12-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:07:20.913' AS DateTime), CAST(N'2025-01-03T17:07:20.913' AS DateTime), 0, 1, N'Viên nén', N'500mg', N'Uống 1 viên sau bữa ăn.', N'Tăng canxi máu.', N'Táo bón.', N'Khô ráo, thoáng mát.', N'Canxi Carbonate')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (28, N'Loratadin 10mg', 3, 20000.0000, 150, CAST(N'2024-06-01T00:00:00.000' AS DateTime), CAST(N'2026-06-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:07:20.913' AS DateTime), CAST(N'2025-01-03T17:07:20.913' AS DateTime), 0, 2, N'Viên nén', N'10mg', N'Uống 1 viên mỗi ngày.', N'Mẫn cảm với loratadin.', N'Khô miệng.', N'Khô ráo, thoáng mát.', N'Loratadin')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (29, N'Cetirizine 10mg', 3, 25000.0000, 120, CAST(N'2024-07-01T00:00:00.000' AS DateTime), CAST(N'2026-07-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:07:20.913' AS DateTime), CAST(N'2025-01-03T17:07:20.913' AS DateTime), 0, 1, N'Viên nén', N'10mg', N'Uống 1 viên mỗi ngày.', N'Mẫn cảm với cetirizine.', N'Buồn ngủ.', N'Khô ráo, thoáng mát.', N'Cetirizine')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (30, N'Smecta 3g', 3, 15000.0000, 120, CAST(N'2024-06-01T00:00:00.000' AS DateTime), CAST(N'2026-06-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:07:20.913' AS DateTime), CAST(N'2025-01-03T17:07:20.913' AS DateTime), 0, 2, N'Gói', N'3g', N'Hòa tan 1 gói trong nước, uống 3 lần/ngày.', N'Không dùng cho trẻ dưới 2 tuổi.', N'Buồn nôn.', N'Khô ráo, thoáng mát.', N'Diosmectite')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (31, N'Loperamid 2mg', 3, 10000.0000, 100, CAST(N'2024-04-01T00:00:00.000' AS DateTime), CAST(N'2026-04-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:07:20.913' AS DateTime), CAST(N'2025-01-03T17:07:20.913' AS DateTime), 0, 1, N'Viên nén', N'2mg', N'Uống 2 viên sau lần tiêu chảy đầu tiên.', N'Không dùng cho trẻ dưới 6 tuổi.', N'Táo bón.', N'Khô ráo, thoáng mát.', N'Loperamid hydrochloride')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (32, N'Diclofenac 50mg', 1, 25000.0000, 140, CAST(N'2024-06-01T00:00:00.000' AS DateTime), CAST(N'2026-06-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:07:20.913' AS DateTime), CAST(N'2025-01-03T17:07:20.913' AS DateTime), 0, 2, N'Viên nén', N'50mg', N'Uống 1 viên mỗi 12 giờ.', N'Mẫn cảm với diclofenac.', N'Buồn nôn.', N'Khô ráo, thoáng mát.', N'Diclofenac Sodium')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (33, N'Naproxen 500mg', 1, 30000.0000, 100, CAST(N'2024-05-01T00:00:00.000' AS DateTime), CAST(N'2026-05-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:07:20.913' AS DateTime), CAST(N'2025-01-03T17:07:20.913' AS DateTime), 0, 1, N'Viên nén', N'500mg', N'Uống 1 viên mỗi 12 giờ.', N'Loét dạ dày.', N'Đau bụng.', N'Khô ráo, thoáng mát.', N'Naproxen Sodium')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (34, N'Colchicin 0.5mg', 3, 15000.0000, 80, CAST(N'2024-07-01T00:00:00.000' AS DateTime), CAST(N'2026-07-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:07:20.913' AS DateTime), CAST(N'2025-01-03T17:07:20.913' AS DateTime), 0, 1, N'Viên nén', N'0.5mg', N'Uống 1 viên mỗi 12 giờ.', N'Mẫn cảm với colchicin.', N'Tiêu chảy.', N'Khô ráo, thoáng mát.', N'Colchicin')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (35, N'Allopurinol 300mg', 3, 20000.0000, 90, CAST(N'2024-08-01T00:00:00.000' AS DateTime), CAST(N'2026-08-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:07:20.913' AS DateTime), CAST(N'2025-01-03T17:07:20.913' AS DateTime), 0, 1, N'Viên nén', N'300mg', N'Uống 1 viên mỗi ngày.', N'Mẫn cảm với allopurinol.', N'Phát ban.', N'Khô ráo, thoáng mát.', N'Allopurinol')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (36, N'Efferalgan 500mg', 1, 15000.0000, 100, CAST(N'2024-06-01T00:00:00.000' AS DateTime), CAST(N'2026-06-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:07:20.913' AS DateTime), CAST(N'2025-01-03T17:07:20.913' AS DateTime), 0, 1, N'Viên sủi', N'500mg', N'Hòa tan 1 viên trong nước, uống mỗi 6 giờ.', N'Mẫn cảm với paracetamol.', N'Nôn, buồn nôn.', N'Khô ráo, thoáng mát.', N'Paracetamol')
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [picture], [created_at], [updated_at], [isDelete], [supplier_id], [unit], [concentration], [usage], [contraindications], [side_effects], [storage], [ingredients]) VALUES (37, N'Panadol Extra', 1, 20000.0000, 90, CAST(N'2024-01-01T00:00:00.000' AS DateTime), CAST(N'2026-01-01T00:00:00.000' AS DateTime), N'images//panadol-regular-new.png', CAST(N'2025-01-03T17:07:20.913' AS DateTime), CAST(N'2025-01-03T17:07:20.913' AS DateTime), 0, 1, N'Viên nén', N'', N'Uống 1-2 viên mỗi 6 giờ.', N'Mẫn cảm với caffeine.', N'Mất ngủ.', N'Khô ráo, thoáng mát.', N'Paracetamol, Caffeine')
GO
SET IDENTITY_INSERT [dbo].[medicines] OFF
GO
SET IDENTITY_INSERT [dbo].[roles] ON 
GO
INSERT [dbo].[roles] ([id], [role_name], [created_at], [updated_at], [isDelete], [picture]) VALUES (1, N'Quản trị viên', CAST(N'2025-01-03T16:52:28.353' AS DateTime), CAST(N'2025-01-03T16:52:28.353' AS DateTime), 0, N'images//admin.png')
GO
INSERT [dbo].[roles] ([id], [role_name], [created_at], [updated_at], [isDelete], [picture]) VALUES (2, N'Nhân viên', CAST(N'2025-01-03T16:52:28.353' AS DateTime), CAST(N'2025-01-03T16:52:28.353' AS DateTime), 0, N'images//employee.png')
GO
SET IDENTITY_INSERT [dbo].[roles] OFF
GO
SET IDENTITY_INSERT [dbo].[suppliers] ON 
GO
INSERT [dbo].[suppliers] ([id], [supplier_name], [contact_phone], [contact_email], [address], [created_at], [updated_at], [isDelete], [picture]) VALUES (1, N'Công ty Dược phẩm A', N'0901234567', N'supplierA@example.com', N'123 Đường A, Thành phố X', CAST(N'2025-01-03T16:50:27.550' AS DateTime), CAST(N'2025-01-03T16:50:27.550' AS DateTime), 0, N'supplierA.png')
GO
INSERT [dbo].[suppliers] ([id], [supplier_name], [contact_phone], [contact_email], [address], [created_at], [updated_at], [isDelete], [picture]) VALUES (2, N'Công ty Dược phẩm B', N'0987654321', N'supplierB@example.com', N'456 Đường B, Thành phố Y', CAST(N'2025-01-03T16:50:27.550' AS DateTime), CAST(N'2025-01-03T16:50:27.550' AS DateTime), 0, N'supplierB.png')
GO
SET IDENTITY_INSERT [dbo].[suppliers] OFF
GO
SET IDENTITY_INSERT [dbo].[users] ON 
GO
INSERT [dbo].[users] ([id], [username], [password], [role_id], [full_name], [created_at], [updated_at], [isDelete], [employee_id], [picture]) VALUES (3, N'admin', N'123456', 1, N'Quản trị viên hệ thống', CAST(N'2025-01-03T16:54:54.010' AS DateTime), CAST(N'2025-01-03T16:54:54.010' AS DateTime), 0, NULL, N'images//admin_avatar.png')
GO
INSERT [dbo].[users] ([id], [username], [password], [role_id], [full_name], [created_at], [updated_at], [isDelete], [employee_id], [picture]) VALUES (4, N'employee1', N'123456', 2, N'Nhân viên 1', CAST(N'2025-01-03T16:54:54.010' AS DateTime), CAST(N'2025-01-03T16:54:54.010' AS DateTime), 0, 1, N'images//employee1.png')
GO
INSERT [dbo].[users] ([id], [username], [password], [role_id], [full_name], [created_at], [updated_at], [isDelete], [employee_id], [picture]) VALUES (5, N'employee2', N'123456', 2, N'Nhân viên 2', CAST(N'2025-01-03T16:54:54.010' AS DateTime), CAST(N'2025-01-03T16:54:54.010' AS DateTime), 0, 2, N'images//employee2.png')
GO
SET IDENTITY_INSERT [dbo].[users] OFF
GO
ALTER TABLE [dbo].[categories] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[customers] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[employee] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[invoices] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[medicines] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[order_details] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[orders] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[price_history] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[promotions] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[returns] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[roles] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[stock_history] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[suppliers] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[users] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[invoices]  WITH CHECK ADD  CONSTRAINT [FK_invoices_orders] FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[invoices] CHECK CONSTRAINT [FK_invoices_orders]
GO
ALTER TABLE [dbo].[medicines]  WITH CHECK ADD  CONSTRAINT [FK_medicines_categories] FOREIGN KEY([category_id])
REFERENCES [dbo].[categories] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[medicines] CHECK CONSTRAINT [FK_medicines_categories]
GO
ALTER TABLE [dbo].[medicines]  WITH CHECK ADD  CONSTRAINT [FK_medicines_suppliers] FOREIGN KEY([supplier_id])
REFERENCES [dbo].[suppliers] ([id])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[medicines] CHECK CONSTRAINT [FK_medicines_suppliers]
GO
ALTER TABLE [dbo].[order_details]  WITH CHECK ADD  CONSTRAINT [FK_order_details_medicines] FOREIGN KEY([medicine_id])
REFERENCES [dbo].[medicines] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[order_details] CHECK CONSTRAINT [FK_order_details_medicines]
GO
ALTER TABLE [dbo].[order_details]  WITH CHECK ADD  CONSTRAINT [FK_order_details_orders] FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[order_details] CHECK CONSTRAINT [FK_order_details_orders]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK_orders_customers] FOREIGN KEY([customer_id])
REFERENCES [dbo].[customers] ([id])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK_orders_customers]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK_orders_employee] FOREIGN KEY([employee_id])
REFERENCES [dbo].[employee] ([id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK_orders_employee]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK_orders_users] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK_orders_users]
GO
ALTER TABLE [dbo].[price_history]  WITH CHECK ADD  CONSTRAINT [FK_price_history_employee] FOREIGN KEY([employee_id])
REFERENCES [dbo].[employee] ([id])
GO
ALTER TABLE [dbo].[price_history] CHECK CONSTRAINT [FK_price_history_employee]
GO
ALTER TABLE [dbo].[price_history]  WITH CHECK ADD  CONSTRAINT [FK_price_history_medicines] FOREIGN KEY([medicine_id])
REFERENCES [dbo].[medicines] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[price_history] CHECK CONSTRAINT [FK_price_history_medicines]
GO
ALTER TABLE [dbo].[promotions]  WITH CHECK ADD  CONSTRAINT [FK_promotions_medicines] FOREIGN KEY([medicine_id])
REFERENCES [dbo].[medicines] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[promotions] CHECK CONSTRAINT [FK_promotions_medicines]
GO
ALTER TABLE [dbo].[returns]  WITH CHECK ADD  CONSTRAINT [FK_returns_employee] FOREIGN KEY([employee_id])
REFERENCES [dbo].[employee] ([id])
GO
ALTER TABLE [dbo].[returns] CHECK CONSTRAINT [FK_returns_employee]
GO
ALTER TABLE [dbo].[returns]  WITH CHECK ADD  CONSTRAINT [FK_returns_medicines] FOREIGN KEY([medicine_id])
REFERENCES [dbo].[medicines] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[returns] CHECK CONSTRAINT [FK_returns_medicines]
GO
ALTER TABLE [dbo].[returns]  WITH CHECK ADD  CONSTRAINT [FK_returns_orders] FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[returns] CHECK CONSTRAINT [FK_returns_orders]
GO
ALTER TABLE [dbo].[stock_history]  WITH CHECK ADD  CONSTRAINT [FK_stock_history_employee] FOREIGN KEY([employee_id])
REFERENCES [dbo].[employee] ([id])
GO
ALTER TABLE [dbo].[stock_history] CHECK CONSTRAINT [FK_stock_history_employee]
GO
ALTER TABLE [dbo].[stock_history]  WITH CHECK ADD  CONSTRAINT [FK_stock_history_medicines] FOREIGN KEY([medicine_id])
REFERENCES [dbo].[medicines] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[stock_history] CHECK CONSTRAINT [FK_stock_history_medicines]
GO
ALTER TABLE [dbo].[users]  WITH CHECK ADD  CONSTRAINT [FK_users_employee] FOREIGN KEY([employee_id])
REFERENCES [dbo].[employee] ([id])
GO
ALTER TABLE [dbo].[users] CHECK CONSTRAINT [FK_users_employee]
GO
ALTER TABLE [dbo].[users]  WITH CHECK ADD  CONSTRAINT [FK_users_roles] FOREIGN KEY([role_id])
REFERENCES [dbo].[roles] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[users] CHECK CONSTRAINT [FK_users_roles]
GO
/****** Object:  StoredProcedure [dbo].[getMedicineByName]    Script Date: 1/3/2025 5:33:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[getMedicineByName]
    @medicineName NVARCHAR(255)
AS
BEGIN
    SELECT 
        m.id,
        m.medicine_name,
        m.category_id,
        c.category_name, -- Lấy tên danh mục
        m.price,
        m.stock,
        m.manufacturing_date,
        m.expiry_date,
        m.picture,
        m.isDelete,
        m.supplier_id,
        s.supplier_name, -- Lấy tên nhà cung cấp
        m.unit,
        m.concentration,
        m.usage,
        m.contraindications,
        m.side_effects,
        m.storage,
        m.ingredients
    FROM medicines m
    LEFT JOIN categories c ON m.category_id = c.id
    LEFT JOIN suppliers s ON m.supplier_id = s.id
    WHERE m.medicine_name = @medicineName AND m.isDelete = 0; -- Lọc theo tên thuốc và chưa bị xóa
END;
GO
/****** Object:  StoredProcedure [dbo].[getMedicines]    Script Date: 1/3/2025 5:33:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[getMedicines]
AS
BEGIN
    SELECT 
        m.id,
        m.medicine_name,
        m.category_id,
        c.category_name, -- Lấy tên danh mục
        m.price,
        m.stock,
        m.manufacturing_date,
        m.expiry_date,
        m.picture,
        m.isDelete,
        m.supplier_id,
        s.supplier_name, -- Lấy tên nhà cung cấp
        m.unit,
        m.concentration,
        m.usage,
        m.contraindications,
        m.side_effects,
        m.storage,
        m.ingredients
    FROM medicines m
    LEFT JOIN categories c ON m.category_id = c.id
    LEFT JOIN suppliers s ON m.supplier_id = s.id
    WHERE m.isDelete = 0; -- Lọc những thuốc chưa bị xóa
END;
GO
