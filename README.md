# 📦 Inventory Management System

A desktop-based inventory management application built using **Java Swing** and **JDBC**, backed by **MySQL** database. This application allows users to manage stock in/out, billing, and inventory records with real-time updates and validations.

---

## 🛠️ Tech Stack

- **Language:** Java (Swing)
- **Database:** MySQL
- **UI:** Java Swing (JFrame, JTable, JPanels)
- **Database Connection:** JDBC
- **IDE:** NetBeans / IntelliJ IDEA

---

## 🚀 Features

- 📋 Add, update, and delete inventory items
- 🧾 Billing system with real-time stock adjustments
- 🔍 Search and filter products
- 📊 View current stock levels
- 👥 Role-Based Access Control (Admin/User)
- ✅ Input validations for quantity, price, etc.
- 🔄 Responsive UI built with Java Swing
- 💾 Data persistence using MySQL and JDBC

---

## 📂 Project Structure

inventory_system/
├── src/
│ ├── database/ # JDBC connection classes
│ ├── gui/ # All Swing GUI components
│ ├── models/ # Data classes (e.g., Product, User)
│ └── services/ # Business logic & database queries
└── README.md


---

## 🧪 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/sahadev234/inventory_system.git
   cd inventory_system
2.Import into your Java IDE (NetBeans, IntelliJ IDEA, etc.)

3.Set up your MySQL database:

4.Create a new database named inventory_db

5.Run the provided SQL script (if available) to generate tables

6.Update DB credentials in the connection file (e.g., DBConnection.java)

7.Run the main class (e.g., Main.java)
