# Order Management System

A simple **Java + JDBC based Order Management System** that demonstrates how real-world order workflows are handled using a relational database.

This project is built for **college / learning purposes** and focuses on clean database design and core backend concepts.

---

## 🚀 Features

- Place an order
- Add multiple products to a single order
- View order history
- View items inside an order
- Cancel an order (status-based, not delete)
- Proper use of DAO pattern
- Relational database design (One-to-Many)

---

## 🧠 Concepts Used

- Java (Core)
- JDBC
- DAO Design Pattern
- SQL (CRUD operations)
- One-to-Many relationship
- Foreign Keys
- Prepared Statements

---

## 🗂 Database Design

### Tables Used
- `users`
- `products`
- `orders`
- `order_items`

### Relationships
- One **user** can have many **orders**
- One **order** can have many **order_items**
- Each **order_item** is linked to one **product**


---

## ⚙️ How It Works (Flow)

1. User places an order
2. Order is stored in `orders` table
3. Generated `order_id` is returned
4. Products are stored in `order_items` using the same `order_id`
5. User can view orders and their items
6. User can cancel an order (status updated to `CANCELLED`)

---

## ❌ Order Deletion Policy

Orders are **not deleted** from the database.  
Instead, the order status is updated to maintain order history.

---

## 🔐 Security Note

Database credentials are **not meant to be pushed publicly**.  
Use environment variables or local configuration for credentials.

---

## 🧪 Sample Operations

- Place Order
- View My Orders
- View Order Items
- Cancel Order

---

## 👨‍💻 Author

**Mayank Chawla**

---

## 📄 License

This project is for educational purposes only.
