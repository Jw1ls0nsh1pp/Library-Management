User Manual: Library Management System

Overview

This Library Management System allows users to manage the library's book catalog, register members, sign in, and perform actions such as borrowing and returning books. 
It also allows members to view their borrowed books and track overdue items. This system ensures smooth operations of a library and easy access to library resources.

1. System Requirements

Before using the system, ensure the following:

Java Development Kit (JDK) installed on your system.
A console or terminal to run the Java program.

2. Running the System

After launching the system, the main menu will appear with the following options:

1. Register Member
2. Sign In
3. Exit
   
3.1 Register Member
To register as a new member:

Select Option 1: Register Member.
Enter your name.
Enter a 5-character Member ID (unique for each member).
If the ID is valid (5 characters long and not previously used), the system will confirm your registration.

3.2 Sign In

To sign in to your account:

Select Option 2: Sign In.
Enter your Member ID.
Once verified, you can access various features of the system:
1. Add Book – Add a new book to the catalog.
2. Search for Book – Search for books by title, ISBN, or genre.
3. Borrow Book – Borrow a book from the catalog.
4. Return Book – Return a borrowed book.
5. View Borrowed Books – View the list of books you've borrowed and their due dates.
6. Sign Out – Exit from your account.
3.3 Exit

Select Option 3: Exit to quit the system.

4. Features

4.1 Register Member
When registering a new member:

The system requires a name and a 5-character Member ID.
The system checks for duplicate Member IDs to ensure uniqueness.

4.2 Add Book
To add a new book to the library catalog:

Enter the book title.
Enter the ISBN number.
Enter the genre of the book.
The system stores this information and confirms the addition.
4.3 Search for Book
To search for a book in the catalog:

Enter a title, ISBN, or genre.
The system checks the catalog and displays any matching results.

4.4 Borrow Book
To borrow a book:

Enter the book title you wish to borrow.
The system checks if the book is available and not already borrowed.
If available, the book is added to your list of borrowed books, and the borrowing date is recorded.

4.5 Return Book
To return a borrowed book:

Enter the book title you want to return.
The system checks if you have borrowed this book.
If correct, the book is removed from your borrowed list, and a confirmation is displayed.

4.6 View Borrowed Books
To view your borrowed books:

The system displays a list of books you've borrowed along with the borrowing date.
If the borrowed book is overdue (more than 7 days), the system notifies you about the overdue duration.

5. Handling Errors

Invalid Input: If an invalid option is entered (e.g., non-integer), the system will prompt you to enter a valid input.
Duplicate Member ID: If you attempt to register with an already used Member ID, the system will ask for a new one.
Book Borrowing: If a book is unavailable or already borrowed, you will be notified.

6. Exiting the System
To exit the system at any point:
Select Option 3: Exit from the main menu or sign out from your account.

7. Important Notes
Books can be borrowed for up to 7 days. The system tracks overdue books.
Member IDs must be unique and 5 characters long.
Ensure the system is running in an environment where the Java runtime is available.
