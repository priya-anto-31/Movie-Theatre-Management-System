# 🎬 Movie Theatre Management System

This is a basic Movie Theatre Management System developed using **Java ** and **MySQL**. It allows users to book tickets, check seat availability, and view movie details.

## ✨ Features

-  **Book Tickets** for selected movies  
-  **Check Available Seats**  
-  **View Movie Details** like director, year, collection, and language  
-  **Search or Delete Movie Records** by year (console-based)

## 📁 Files Description

- `movie1.java` – GUI for booking tickets and checking available seats (`bookticket` database)  
- `movie2.java` – GUI for displaying movie details (`indianmovies` database)  
- `movie3.java` – Console-based movie search by year  
- `movie4.java` – Console-based deletion of movies before a specific year  

## 🗄️ Database Info

### 📚 `bookticket` Database  
**Table: `movies`**
| Column Name     | Data Type |
|------------------|------------|
| `Movie_Name`     | VARCHAR    |
| `Seats_Available`| INT        |

---

### 🎞️ `indianmovies` Database  
**Table: `movies`**
| Column Name   | Data Type |
|----------------|------------|
| `Movie_Name`   | VARCHAR    |
| `Director`     | VARCHAR    |
| `Year`         | INT        |
| `Collection`   | DOUBLE     |
| `Language`     | VARCHAR    |
