USE [PharmaCity]
GO
/****** Object:  Table [dbo].[audit_logs]    Script Date: 12/28/2024 7:29:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[audit_logs](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[action_type] [varchar](50) NOT NULL,
	[action_details] [varchar](500) NOT NULL,
	[action_time] [datetime] NULL,
	[isDelete] [bit] NULL,
	[employee_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[categories]    Script Date: 12/28/2024 7:29:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[categories](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[category_name] [varchar](100) NOT NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[customers]    Script Date: 12/28/2024 7:29:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customers](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[full_name] [varchar](255) NOT NULL,
	[phone_number] [varchar](15) NULL,
	[email] [varchar](100) NULL,
	[address] [varchar](500) NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[employee]    Script Date: 12/28/2024 7:29:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[employee](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[full_name] [varchar](255) NOT NULL,
	[phone_number] [varchar](15) NULL,
	[email] [varchar](100) NULL,
	[address] [varchar](500) NULL,
	[identity_card] [varchar](12) NULL,
	[picture] [varbinary](max) NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[invoices]    Script Date: 12/28/2024 7:29:37 PM ******/
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
	[payment_status] [varchar](50) NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[medicines]    Script Date: 12/28/2024 7:29:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[medicines](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[medicine_name] [varchar](255) NOT NULL,
	[category_id] [int] NOT NULL,
	[price] [decimal](10, 2) NOT NULL,
	[stock] [int] NOT NULL,
	[manufacturing_date] [datetime] NOT NULL,
	[expiry_date] [datetime] NOT NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NULL,
	[supplier_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[order_details]    Script Date: 12/28/2024 7:29:37 PM ******/
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
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orders]    Script Date: 12/28/2024 7:29:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orders](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[customer_name] [varchar](255) NOT NULL,
	[total_price] [decimal](10, 2) NOT NULL,
	[order_date] [datetime] NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NULL,
	[customer_id] [int] NULL,
	[employee_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[price_history]    Script Date: 12/28/2024 7:29:37 PM ******/
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
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[promotions]    Script Date: 12/28/2024 7:29:37 PM ******/
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
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[returns]    Script Date: 12/28/2024 7:29:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[returns](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[order_id] [int] NOT NULL,
	[medicine_id] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[reason] [varchar](500) NULL,
	[return_date] [datetime] NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[roles]    Script Date: 12/28/2024 7:29:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[roles](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[role_name] [varchar](50) NOT NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[stock_history]    Script Date: 12/28/2024 7:29:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[stock_history](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[medicine_id] [int] NOT NULL,
	[change_type] [varchar](50) NOT NULL,
	[quantity] [int] NOT NULL,
	[change_date] [datetime] NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[suppliers]    Script Date: 12/28/2024 7:29:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[suppliers](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[supplier_name] [varchar](255) NOT NULL,
	[contact_phone] [varchar](15) NULL,
	[contact_email] [varchar](100) NULL,
	[address] [varchar](500) NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 12/28/2024 7:29:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[role_id] [int] NOT NULL,
	[full_name] [varchar](255) NOT NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
	[isDelete] [bit] NULL,
	[employee_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[categories] ON 
GO
INSERT [dbo].[categories] ([id], [category_name], [created_at], [updated_at], [isDelete]) VALUES (1, N'Pain relief', CAST(N'2024-12-24T14:17:56.137' AS DateTime), CAST(N'2024-12-24T14:17:56.137' AS DateTime), NULL)
GO
INSERT [dbo].[categories] ([id], [category_name], [created_at], [updated_at], [isDelete]) VALUES (2, N'Antipyretic', CAST(N'2024-12-24T14:17:56.137' AS DateTime), CAST(N'2024-12-24T14:17:56.137' AS DateTime), NULL)
GO
INSERT [dbo].[categories] ([id], [category_name], [created_at], [updated_at], [isDelete]) VALUES (3, N'Vitamins', CAST(N'2024-12-24T14:17:56.137' AS DateTime), CAST(N'2024-12-24T14:17:56.137' AS DateTime), NULL)
GO
INSERT [dbo].[categories] ([id], [category_name], [created_at], [updated_at], [isDelete]) VALUES (4, N'Antibiotics', CAST(N'2024-12-25T14:18:09.593' AS DateTime), CAST(N'2024-12-25T14:18:09.593' AS DateTime), NULL)
GO
INSERT [dbo].[categories] ([id], [category_name], [created_at], [updated_at], [isDelete]) VALUES (5, N'Antihistamines', CAST(N'2024-12-25T14:18:09.593' AS DateTime), CAST(N'2024-12-25T14:18:09.593' AS DateTime), NULL)
GO
INSERT [dbo].[categories] ([id], [category_name], [created_at], [updated_at], [isDelete]) VALUES (6, N'Supplements', CAST(N'2024-12-25T14:18:09.593' AS DateTime), CAST(N'2024-12-25T14:18:09.593' AS DateTime), NULL)
GO
INSERT [dbo].[categories] ([id], [category_name], [created_at], [updated_at], [isDelete]) VALUES (7, N'Analgesics', CAST(N'2024-12-25T14:18:09.593' AS DateTime), CAST(N'2024-12-25T14:18:09.593' AS DateTime), NULL)
GO
INSERT [dbo].[categories] ([id], [category_name], [created_at], [updated_at], [isDelete]) VALUES (8, N'Antacids', CAST(N'2024-12-25T14:18:09.593' AS DateTime), CAST(N'2024-12-25T14:18:09.593' AS DateTime), NULL)
GO
SET IDENTITY_INSERT [dbo].[categories] OFF
GO
SET IDENTITY_INSERT [dbo].[medicines] ON 
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (1, N'Paracetamol', 1, CAST(15000.00 AS Decimal(10, 2)), 100, CAST(N'2023-01-01T00:00:00.000' AS DateTime), CAST(N'2025-01-01T00:00:00.000' AS DateTime), CAST(N'2024-12-24T14:17:56.150' AS DateTime), CAST(N'2024-12-24T14:17:56.150' AS DateTime), 1, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (2, N'Aspirin', 2, CAST(12000.00 AS Decimal(10, 2)), 50, CAST(N'2023-03-15T00:00:00.000' AS DateTime), CAST(N'2025-03-15T00:00:00.000' AS DateTime), CAST(N'2024-12-24T14:17:56.150' AS DateTime), CAST(N'2024-12-24T14:17:56.150' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (3, N'Vitamin C', 3, CAST(8000.00 AS Decimal(10, 2)), 200, CAST(N'2023-06-10T00:00:00.000' AS DateTime), CAST(N'2025-06-10T00:00:00.000' AS DateTime), CAST(N'2024-12-24T14:17:56.150' AS DateTime), CAST(N'2024-12-24T14:17:56.150' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (4, N'Amoxicillin', 4, CAST(50000.00 AS Decimal(10, 2)), 60, CAST(N'2023-02-01T00:00:00.000' AS DateTime), CAST(N'2025-02-01T00:00:00.000' AS DateTime), CAST(N'2024-12-25T14:18:32.550' AS DateTime), CAST(N'2024-12-25T14:18:32.550' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (5, N'Cetirizine', 5, CAST(20000.00 AS Decimal(10, 2)), 150, CAST(N'2023-04-10T00:00:00.000' AS DateTime), CAST(N'2025-04-10T00:00:00.000' AS DateTime), CAST(N'2024-12-25T14:18:32.550' AS DateTime), CAST(N'2024-12-25T14:18:32.550' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (6, N'Calcium Tablets', 3, CAST(25000.00 AS Decimal(10, 2)), 80, CAST(N'2023-01-20T00:00:00.000' AS DateTime), CAST(N'2025-01-20T00:00:00.000' AS DateTime), CAST(N'2024-12-25T14:18:32.550' AS DateTime), CAST(N'2024-12-25T14:18:32.550' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (7, N'Ibuprofen', 1, CAST(18000.00 AS Decimal(10, 2)), 90, CAST(N'2023-03-25T00:00:00.000' AS DateTime), CAST(N'2025-03-25T00:00:00.000' AS DateTime), CAST(N'2024-12-25T14:18:32.550' AS DateTime), CAST(N'2024-12-25T14:18:32.550' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (8, N'Ranitidine', 5, CAST(22000.00 AS Decimal(10, 2)), 40, CAST(N'2023-05-15T00:00:00.000' AS DateTime), CAST(N'2025-05-15T00:00:00.000' AS DateTime), CAST(N'2024-12-25T14:18:32.550' AS DateTime), CAST(N'2024-12-25T14:18:32.550' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (9, N'Paracetamol', 1, CAST(5000.00 AS Decimal(10, 2)), 100, CAST(N'2023-01-01T00:00:00.000' AS DateTime), CAST(N'2025-01-01T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (10, N'Ibuprofen', 1, CAST(10000.00 AS Decimal(10, 2)), 200, CAST(N'2023-02-01T00:00:00.000' AS DateTime), CAST(N'2025-02-01T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (11, N'Amoxicillin', 2, CAST(15000.00 AS Decimal(10, 2)), 150, CAST(N'2023-03-01T00:00:00.000' AS DateTime), CAST(N'2025-03-01T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (12, N'Ciprofloxacin', 2, CAST(20000.00 AS Decimal(10, 2)), 120, CAST(N'2023-04-01T00:00:00.000' AS DateTime), CAST(N'2025-04-01T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (13, N'Vitamin C', 3, CAST(5000.00 AS Decimal(10, 2)), 300, CAST(N'2023-01-15T00:00:00.000' AS DateTime), CAST(N'2025-01-15T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (14, N'Multivitamins', 3, CAST(7000.00 AS Decimal(10, 2)), 400, CAST(N'2023-02-20T00:00:00.000' AS DateTime), CAST(N'2025-02-20T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (15, N'Antacid Tablets', 4, CAST(8000.00 AS Decimal(10, 2)), 250, CAST(N'2023-03-10T00:00:00.000' AS DateTime), CAST(N'2025-03-10T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (16, N'Loratadine', 5, CAST(12000.00 AS Decimal(10, 2)), 180, CAST(N'2023-04-05T00:00:00.000' AS DateTime), CAST(N'2025-04-05T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (17, N'Metformin', 6, CAST(14000.00 AS Decimal(10, 2)), 160, CAST(N'2023-05-01T00:00:00.000' AS DateTime), CAST(N'2025-05-01T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (18, N'Insulin', 6, CAST(30000.00 AS Decimal(10, 2)), 90, CAST(N'2023-06-01T00:00:00.000' AS DateTime), CAST(N'2025-06-01T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (19, N'Aspirin', 1, CAST(4000.00 AS Decimal(10, 2)), 500, CAST(N'2023-02-10T00:00:00.000' AS DateTime), CAST(N'2025-02-10T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (20, N'Omeprazole', 4, CAST(10000.00 AS Decimal(10, 2)), 230, CAST(N'2023-03-15T00:00:00.000' AS DateTime), CAST(N'2025-03-15T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (21, N'Clarithromycin', 2, CAST(22000.00 AS Decimal(10, 2)), 110, CAST(N'2023-04-20T00:00:00.000' AS DateTime), CAST(N'2025-04-20T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (22, N'Zinc Supplements', 3, CAST(6000.00 AS Decimal(10, 2)), 350, CAST(N'2023-01-25T00:00:00.000' AS DateTime), CAST(N'2025-01-25T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (23, N'Calcium Tablets', 3, CAST(9000.00 AS Decimal(10, 2)), 270, CAST(N'2023-02-15T00:00:00.000' AS DateTime), CAST(N'2025-02-15T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (24, N'Cetirizine', 5, CAST(11000.00 AS Decimal(10, 2)), 240, CAST(N'2023-03-05T00:00:00.000' AS DateTime), CAST(N'2025-03-05T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (25, N'Azithromycin', 2, CAST(25000.00 AS Decimal(10, 2)), 80, CAST(N'2023-04-15T00:00:00.000' AS DateTime), CAST(N'2025-04-15T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (26, N'Doxycycline', 2, CAST(18000.00 AS Decimal(10, 2)), 130, CAST(N'2023-05-10T00:00:00.000' AS DateTime), CAST(N'2025-05-10T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (27, N'Folic Acid', 3, CAST(4500.00 AS Decimal(10, 2)), 400, CAST(N'2023-06-01T00:00:00.000' AS DateTime), CAST(N'2025-06-01T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (28, N'Probiotics', 4, CAST(7500.00 AS Decimal(10, 2)), 300, CAST(N'2023-07-01T00:00:00.000' AS DateTime), CAST(N'2025-07-01T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), CAST(N'2024-12-25T15:58:35.660' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (29, N'Naproxen', 1, CAST(8000.00 AS Decimal(10, 2)), 150, CAST(N'2023-07-01T00:00:00.000' AS DateTime), CAST(N'2025-07-01T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (30, N'Ranitidine', 4, CAST(12000.00 AS Decimal(10, 2)), 200, CAST(N'2023-06-15T00:00:00.000' AS DateTime), CAST(N'2025-06-15T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (31, N'Simethicone', 4, CAST(6000.00 AS Decimal(10, 2)), 180, CAST(N'2023-08-01T00:00:00.000' AS DateTime), CAST(N'2025-08-01T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (32, N'Prednisolone', 5, CAST(15000.00 AS Decimal(10, 2)), 90, CAST(N'2023-09-01T00:00:00.000' AS DateTime), CAST(N'2025-09-01T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (33, N'Vitamin D3', 3, CAST(7000.00 AS Decimal(10, 2)), 220, CAST(N'2023-07-20T00:00:00.000' AS DateTime), CAST(N'2025-07-20T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (34, N'Vitamin B12', 3, CAST(6500.00 AS Decimal(10, 2)), 250, CAST(N'2023-08-15T00:00:00.000' AS DateTime), CAST(N'2025-08-15T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (35, N'Calamine Lotion', 6, CAST(9500.00 AS Decimal(10, 2)), 100, CAST(N'2023-05-25T00:00:00.000' AS DateTime), CAST(N'2025-05-25T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (36, N'Amoxicillin-Clavulanic Acid', 2, CAST(28000.00 AS Decimal(10, 2)), 120, CAST(N'2023-06-10T00:00:00.000' AS DateTime), CAST(N'2025-06-10T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (37, N'Cefuroxime', 2, CAST(22000.00 AS Decimal(10, 2)), 110, CAST(N'2023-06-20T00:00:00.000' AS DateTime), CAST(N'2025-06-20T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (38, N'Losartan', 6, CAST(18000.00 AS Decimal(10, 2)), 140, CAST(N'2023-05-01T00:00:00.000' AS DateTime), CAST(N'2025-05-01T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (39, N'Amlodipine', 6, CAST(17000.00 AS Decimal(10, 2)), 150, CAST(N'2023-06-15T00:00:00.000' AS DateTime), CAST(N'2025-06-15T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (40, N'Clopidogrel', 6, CAST(25000.00 AS Decimal(10, 2)), 130, CAST(N'2023-05-20T00:00:00.000' AS DateTime), CAST(N'2025-05-20T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (41, N'Lisinopril', 6, CAST(20000.00 AS Decimal(10, 2)), 100, CAST(N'2023-04-15T00:00:00.000' AS DateTime), CAST(N'2025-04-15T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (42, N'Furosemide', 6, CAST(14000.00 AS Decimal(10, 2)), 160, CAST(N'2023-06-05T00:00:00.000' AS DateTime), CAST(N'2025-06-05T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (43, N'Hydrochlorothiazide', 6, CAST(15000.00 AS Decimal(10, 2)), 170, CAST(N'2023-07-10T00:00:00.000' AS DateTime), CAST(N'2025-07-10T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (44, N'Levofloxacin', 2, CAST(27000.00 AS Decimal(10, 2)), 100, CAST(N'2023-05-25T00:00:00.000' AS DateTime), CAST(N'2025-05-25T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (45, N'Metronidazole', 2, CAST(13000.00 AS Decimal(10, 2)), 300, CAST(N'2023-03-15T00:00:00.000' AS DateTime), CAST(N'2025-03-15T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (46, N'Ketoconazole', 4, CAST(20000.00 AS Decimal(10, 2)), 150, CAST(N'2023-04-01T00:00:00.000' AS DateTime), CAST(N'2025-04-01T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (47, N'Salbutamol', 5, CAST(18000.00 AS Decimal(10, 2)), 120, CAST(N'2023-03-20T00:00:00.000' AS DateTime), CAST(N'2025-03-20T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
INSERT [dbo].[medicines] ([id], [medicine_name], [category_id], [price], [stock], [manufacturing_date], [expiry_date], [created_at], [updated_at], [isDelete], [supplier_id]) VALUES (48, N'Beclomethasone', 5, CAST(24000.00 AS Decimal(10, 2)), 100, CAST(N'2023-06-01T00:00:00.000' AS DateTime), CAST(N'2025-06-01T00:00:00.000' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), CAST(N'2024-12-25T15:59:54.327' AS DateTime), 0, NULL)
GO
SET IDENTITY_INSERT [dbo].[medicines] OFF
GO
SET IDENTITY_INSERT [dbo].[order_details] ON 
GO
INSERT [dbo].[order_details] ([id], [order_id], [medicine_id], [quantity], [unit_price], [total_price], [created_at], [updated_at], [isDelete]) VALUES (1, 1, 1, 2, CAST(15000.00 AS Decimal(10, 2)), CAST(30000.00 AS Decimal(10, 2)), CAST(N'2024-12-24T14:17:56.180' AS DateTime), CAST(N'2024-12-24T14:17:56.180' AS DateTime), NULL)
GO
INSERT [dbo].[order_details] ([id], [order_id], [medicine_id], [quantity], [unit_price], [total_price], [created_at], [updated_at], [isDelete]) VALUES (2, 2, 2, 1, CAST(12000.00 AS Decimal(10, 2)), CAST(12000.00 AS Decimal(10, 2)), CAST(N'2024-12-24T14:17:56.180' AS DateTime), CAST(N'2024-12-24T14:17:56.180' AS DateTime), NULL)
GO
INSERT [dbo].[order_details] ([id], [order_id], [medicine_id], [quantity], [unit_price], [total_price], [created_at], [updated_at], [isDelete]) VALUES (3, 1, 4, 2, CAST(18000.00 AS Decimal(10, 2)), CAST(36000.00 AS Decimal(10, 2)), CAST(N'2024-12-25T14:18:59.350' AS DateTime), CAST(N'2024-12-25T14:18:59.350' AS DateTime), NULL)
GO
INSERT [dbo].[order_details] ([id], [order_id], [medicine_id], [quantity], [unit_price], [total_price], [created_at], [updated_at], [isDelete]) VALUES (4, 1, 5, 1, CAST(22000.00 AS Decimal(10, 2)), CAST(22000.00 AS Decimal(10, 2)), CAST(N'2024-12-25T14:18:59.350' AS DateTime), CAST(N'2024-12-25T14:18:59.350' AS DateTime), NULL)
GO
INSERT [dbo].[order_details] ([id], [order_id], [medicine_id], [quantity], [unit_price], [total_price], [created_at], [updated_at], [isDelete]) VALUES (5, 2, 3, 1, CAST(25000.00 AS Decimal(10, 2)), CAST(25000.00 AS Decimal(10, 2)), CAST(N'2024-12-25T14:18:59.350' AS DateTime), CAST(N'2024-12-25T14:18:59.350' AS DateTime), NULL)
GO
INSERT [dbo].[order_details] ([id], [order_id], [medicine_id], [quantity], [unit_price], [total_price], [created_at], [updated_at], [isDelete]) VALUES (6, 3, 2, 2, CAST(20000.00 AS Decimal(10, 2)), CAST(40000.00 AS Decimal(10, 2)), CAST(N'2024-12-25T14:18:59.350' AS DateTime), CAST(N'2024-12-25T14:18:59.350' AS DateTime), NULL)
GO
SET IDENTITY_INSERT [dbo].[order_details] OFF
GO
SET IDENTITY_INSERT [dbo].[orders] ON 
GO
INSERT [dbo].[orders] ([id], [user_id], [customer_name], [total_price], [order_date], [created_at], [updated_at], [isDelete], [customer_id], [employee_id]) VALUES (1, 2, N'John Doe', CAST(30000.00 AS Decimal(10, 2)), CAST(N'2024-12-24T14:17:56.167' AS DateTime), CAST(N'2024-12-24T14:17:56.167' AS DateTime), CAST(N'2024-12-24T14:17:56.167' AS DateTime), NULL, NULL, NULL)
GO
INSERT [dbo].[orders] ([id], [user_id], [customer_name], [total_price], [order_date], [created_at], [updated_at], [isDelete], [customer_id], [employee_id]) VALUES (2, 3, N'Jane Smith', CAST(12000.00 AS Decimal(10, 2)), CAST(N'2024-12-24T14:17:56.167' AS DateTime), CAST(N'2024-12-24T14:17:56.167' AS DateTime), CAST(N'2024-12-24T14:17:56.167' AS DateTime), NULL, NULL, NULL)
GO
INSERT [dbo].[orders] ([id], [user_id], [customer_name], [total_price], [order_date], [created_at], [updated_at], [isDelete], [customer_id], [employee_id]) VALUES (3, 2, N'Michael Brown', CAST(70000.00 AS Decimal(10, 2)), CAST(N'2024-12-25T14:18:49.910' AS DateTime), CAST(N'2024-12-25T14:18:49.910' AS DateTime), CAST(N'2024-12-25T14:18:49.910' AS DateTime), NULL, NULL, NULL)
GO
INSERT [dbo].[orders] ([id], [user_id], [customer_name], [total_price], [order_date], [created_at], [updated_at], [isDelete], [customer_id], [employee_id]) VALUES (4, 3, N'Emily Davis', CAST(25000.00 AS Decimal(10, 2)), CAST(N'2024-12-25T14:18:49.910' AS DateTime), CAST(N'2024-12-25T14:18:49.910' AS DateTime), CAST(N'2024-12-25T14:18:49.910' AS DateTime), NULL, NULL, NULL)
GO
INSERT [dbo].[orders] ([id], [user_id], [customer_name], [total_price], [order_date], [created_at], [updated_at], [isDelete], [customer_id], [employee_id]) VALUES (5, 2, N'Robert Johnson', CAST(40000.00 AS Decimal(10, 2)), CAST(N'2024-12-25T14:18:49.910' AS DateTime), CAST(N'2024-12-25T14:18:49.910' AS DateTime), CAST(N'2024-12-25T14:18:49.910' AS DateTime), NULL, NULL, NULL)
GO
SET IDENTITY_INSERT [dbo].[orders] OFF
GO
SET IDENTITY_INSERT [dbo].[roles] ON 
GO
INSERT [dbo].[roles] ([id], [role_name], [created_at], [updated_at], [isDelete]) VALUES (1, N'admin', CAST(N'2024-12-24T14:17:56.107' AS DateTime), CAST(N'2024-12-24T14:17:56.107' AS DateTime), NULL)
GO
INSERT [dbo].[roles] ([id], [role_name], [created_at], [updated_at], [isDelete]) VALUES (2, N'employee', CAST(N'2024-12-24T14:17:56.107' AS DateTime), CAST(N'2024-12-24T14:17:56.107' AS DateTime), NULL)
GO
SET IDENTITY_INSERT [dbo].[roles] OFF
GO
SET IDENTITY_INSERT [dbo].[users] ON 
GO
INSERT [dbo].[users] ([id], [username], [password], [role_id], [full_name], [created_at], [updated_at], [isDelete], [employee_id]) VALUES (1, N'admin', N'123456', 1, N'System Administrator', CAST(N'2024-12-24T14:17:56.127' AS DateTime), CAST(N'2024-12-24T14:17:56.127' AS DateTime), NULL, NULL)
GO
INSERT [dbo].[users] ([id], [username], [password], [role_id], [full_name], [created_at], [updated_at], [isDelete], [employee_id]) VALUES (2, N'employee1', N'123456', 2, N'Pharmacist 1', CAST(N'2024-12-24T14:17:56.127' AS DateTime), CAST(N'2024-12-24T14:17:56.127' AS DateTime), NULL, NULL)
GO
INSERT [dbo].[users] ([id], [username], [password], [role_id], [full_name], [created_at], [updated_at], [isDelete], [employee_id]) VALUES (3, N'employee2', N'123456', 2, N'Pharmacist 2', CAST(N'2024-12-24T14:17:56.127' AS DateTime), CAST(N'2024-12-24T14:17:56.127' AS DateTime), NULL, NULL)
GO
SET IDENTITY_INSERT [dbo].[users] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__categori__5189E255D3E30B29]    Script Date: 12/28/2024 7:29:37 PM ******/
ALTER TABLE [dbo].[categories] ADD UNIQUE NONCLUSTERED 
(
	[category_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__roles__783254B1D9B0DD4E]    Script Date: 12/28/2024 7:29:37 PM ******/
ALTER TABLE [dbo].[roles] ADD UNIQUE NONCLUSTERED 
(
	[role_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__users__F3DBC5724FF71450]    Script Date: 12/28/2024 7:29:37 PM ******/
ALTER TABLE [dbo].[users] ADD UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[audit_logs] ADD  DEFAULT (getdate()) FOR [action_time]
GO
ALTER TABLE [dbo].[audit_logs] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[categories] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[categories] ADD  DEFAULT (getdate()) FOR [updated_at]
GO
ALTER TABLE [dbo].[categories] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[customers] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[customers] ADD  DEFAULT (getdate()) FOR [updated_at]
GO
ALTER TABLE [dbo].[customers] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[invoices] ADD  DEFAULT (getdate()) FOR [invoice_date]
GO
ALTER TABLE [dbo].[invoices] ADD  DEFAULT ((0)) FOR [amount_paid]
GO
ALTER TABLE [dbo].[invoices] ADD  DEFAULT ('Unpaid') FOR [payment_status]
GO
ALTER TABLE [dbo].[invoices] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[invoices] ADD  DEFAULT (getdate()) FOR [updated_at]
GO
ALTER TABLE [dbo].[invoices] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[medicines] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[medicines] ADD  DEFAULT (getdate()) FOR [updated_at]
GO
ALTER TABLE [dbo].[medicines] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[order_details] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[order_details] ADD  DEFAULT (getdate()) FOR [updated_at]
GO
ALTER TABLE [dbo].[order_details] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[orders] ADD  DEFAULT (getdate()) FOR [order_date]
GO
ALTER TABLE [dbo].[orders] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[orders] ADD  DEFAULT (getdate()) FOR [updated_at]
GO
ALTER TABLE [dbo].[orders] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[price_history] ADD  DEFAULT (getdate()) FOR [change_date]
GO
ALTER TABLE [dbo].[price_history] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[price_history] ADD  DEFAULT (getdate()) FOR [updated_at]
GO
ALTER TABLE [dbo].[price_history] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[promotions] ADD  DEFAULT (getdate()) FOR [start_date]
GO
ALTER TABLE [dbo].[promotions] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[promotions] ADD  DEFAULT (getdate()) FOR [updated_at]
GO
ALTER TABLE [dbo].[promotions] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[returns] ADD  DEFAULT (getdate()) FOR [return_date]
GO
ALTER TABLE [dbo].[returns] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[returns] ADD  DEFAULT (getdate()) FOR [updated_at]
GO
ALTER TABLE [dbo].[returns] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[roles] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[roles] ADD  DEFAULT (getdate()) FOR [updated_at]
GO
ALTER TABLE [dbo].[roles] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[stock_history] ADD  DEFAULT (getdate()) FOR [change_date]
GO
ALTER TABLE [dbo].[stock_history] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[stock_history] ADD  DEFAULT (getdate()) FOR [updated_at]
GO
ALTER TABLE [dbo].[stock_history] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[suppliers] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[suppliers] ADD  DEFAULT (getdate()) FOR [updated_at]
GO
ALTER TABLE [dbo].[suppliers] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[users] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[users] ADD  DEFAULT (getdate()) FOR [updated_at]
GO
ALTER TABLE [dbo].[users] ADD  DEFAULT ((0)) FOR [isDelete]
GO
ALTER TABLE [dbo].[audit_logs]  WITH NOCHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[audit_logs]  WITH CHECK ADD  CONSTRAINT [FK_audit_logs_employee] FOREIGN KEY([employee_id])
REFERENCES [dbo].[employee] ([id])
GO
ALTER TABLE [dbo].[audit_logs] CHECK CONSTRAINT [FK_audit_logs_employee]
GO
ALTER TABLE [dbo].[invoices]  WITH CHECK ADD FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[medicines]  WITH CHECK ADD FOREIGN KEY([category_id])
REFERENCES [dbo].[categories] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[medicines]  WITH CHECK ADD FOREIGN KEY([supplier_id])
REFERENCES [dbo].[suppliers] ([id])
ON UPDATE CASCADE
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[order_details]  WITH CHECK ADD FOREIGN KEY([medicine_id])
REFERENCES [dbo].[medicines] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[order_details]  WITH CHECK ADD FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[orders]  WITH NOCHECK ADD FOREIGN KEY([customer_id])
REFERENCES [dbo].[customers] ([id])
ON UPDATE CASCADE
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[orders]  WITH NOCHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK_orders_employee] FOREIGN KEY([employee_id])
REFERENCES [dbo].[employee] ([id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK_orders_employee]
GO
ALTER TABLE [dbo].[price_history]  WITH CHECK ADD FOREIGN KEY([medicine_id])
REFERENCES [dbo].[medicines] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[promotions]  WITH CHECK ADD FOREIGN KEY([medicine_id])
REFERENCES [dbo].[medicines] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[returns]  WITH CHECK ADD FOREIGN KEY([medicine_id])
REFERENCES [dbo].[medicines] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[returns]  WITH CHECK ADD FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[stock_history]  WITH CHECK ADD FOREIGN KEY([medicine_id])
REFERENCES [dbo].[medicines] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[users]  WITH NOCHECK ADD FOREIGN KEY([role_id])
REFERENCES [dbo].[roles] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[users]  WITH CHECK ADD  CONSTRAINT [FK_users_employee] FOREIGN KEY([employee_id])
REFERENCES [dbo].[employee] ([id])
GO
ALTER TABLE [dbo].[users] CHECK CONSTRAINT [FK_users_employee]
GO
