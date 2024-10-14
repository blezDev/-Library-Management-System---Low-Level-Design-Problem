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


## Documentation

For a detailed overview of the Library Management System
![UML](https://github.com/user-attachments/assets/d87b089e-4285-47af-b2db-542181a92527)

[UML View](https://github.com/user-attachments/files/17367840/desing.pdf)

## Class Diagram 

### 1. Abstract Account Class
An abstract class that represents the foundational attributes and methods for user accounts, including general members and librarians.

### 2. Abstract Book Class
An abstract class that defines the basic structure and properties of a book, including essential attributes like ISBN, title, and author.

### 3. BookInventory Class implementing Search, BookLending
A singleton class that manages the inventory of book items, facilitating operations like adding, removing, lending, and reserving books.

### 4. BookItem Class extends Book
A concrete class representing individual copies of a book, extending the abstract `Book` class with additional attributes like unique barcode and status.

### 5. Interface BookLending
An interface defining methods for lending and returning book items, ensuring a consistent lending process across implementations.

### 6. Enum BookStatus Class
An enumeration that defines the various statuses a book can have, such as available, reserved, loaned, or unavailable.

### 7. Librarian Class extends Account
A class that extends the `Account` class, representing a librarian with capabilities to manage books, patrons, and oversee lending processes.

### 8. Patron Class extends Account
A class that extends the `Account` class, representing a library member with attributes and methods to manage their borrowing history and account details.

### 9. PatronSystem Class
A class responsible for managing library patrons, including operations to add, update, and track borrowing history.

