# Library Management System - Low Level Design

A simple Library Management System that manages books, patrons, and the lending process.

## Functional Requirements

### 1. Book Management
#### Book Class
Define attributes such as:
- **Title**
- **Author**
- **ISBN**
- **Publication Year**

#### Operations:
- Add new books to the inventory.
- Remove existing books from the inventory.
- Update book information (e.g., title, author, etc.).

#### Search Functionality:
- Search books by:
  - **Title**
  - **Author**
  - **ISBN**

---

### 2. Patron Management
#### Patron Class
Define attributes such as:
- **Name**
- **Library ID**
- **Contact Information**

#### Operations:
- Add new patrons to the system.
- Update patron details.

#### Borrowing History:
- Maintain and track patron borrowing history.

---

### 3. Lending Process
#### Checkout Books:
- Allow patrons to check out available books.
- Update the inventory accordingly.

#### Return Books:
- Allow patrons to return borrowed books.
- Update the inventory and borrowing history.

---

### 4. Inventory Management
#### Available Books:
- Track the number of available books for checkout.

#### Borrowed Books:
- Track books that are currently checked out.


