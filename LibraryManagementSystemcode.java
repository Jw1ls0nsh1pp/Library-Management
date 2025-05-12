```
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

        public class LibraryManagementSystem{
        static ArrayList<String> members = new ArrayList<>(); // Stores the names of registered library members
        static ArrayList<String> memberIds = new ArrayList<>(); // Stores the unique 5-character IDs assigned to each member
        static ArrayList<String> catalog = new ArrayList<>(); // Stores the titles of books available in the library.
        static ArrayList<String> borrowedBooks = new ArrayList<>(); // stores the titles of books currently borrowed by members.
        static ArrayList<String> borrowedBy = new ArrayList<>(); // Stores the member IDs of those who borrowed books.
        static ArrayList<Date> borrowDates = new ArrayList<>(); // Stores the dates on which the books were borrowed.

           public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);

           while (true) {
            try {
                System.out.println("Welcome to Library Management System");
                System.out.println("1. Register Member");
                System.out.println("2. Sign In");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");

                int choice = Integer.parseInt(scanner.nextLine()); // Throws exception for non-integer input

                if (choice == 1) {
                    registerMember(scanner);
                } else if (choice == 2) {
                    signIn(scanner);
                } else if (choice == 3) {
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number (1, 2, or 3).");
            }
        }

        scanner.close();
    }
   
        static void registerMember(Scanner scanner) {
        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();

        String memberId;
        while(true){
        System.out.print("Enter 5-Character Member ID: ");
        memberId = scanner.nextLine();

        if(memberId.length() == 5 && !memberIds.contains(memberId)){ // checks if the memberId entered by the user is exactly 5 characters long and it also checks if this memberId already exist in the datatbase
        members.add(name); // adds the new members name to the members list
        memberIds.add(memberId); //adds the validated membersId to the membersIds list 
        System.out.println(" Member " + name + " with ID: " + memberId + " registered successfully!");
        break;
       }
      else {
        System.out.println("Invalid or duplicate Member ID! Please enter a unique 5-character ID.");

      }
     }
   }

      static void signIn(Scanner scanner){
      System.out.println("Please Enter your Member ID: ");
      String memberId = scanner.nextLine();

      if(memberIds.contains(memberId)){ //checks if the memberId given by the user already exist in the memberIDs list 
       System.out.println( "Welcome back, Member " + memberId + " !");
        while(true) {
          System.out.println(" 1. Add Book ");
          System.out.println(" 2. Search for Book");
          System.out.println(" 3. Borrow Book ");
          System.out.println(" 4. Return Book");
          System.out.println(" 5. View Borrowed Books");
          System.out.println(" 6. Sign out " ); 
          System.out.println(" Please choose an option and continue: ");
          int choice = scanner.nextInt();
          scanner.nextLine();

         if(choice == 1){
         addBook(scanner);
         } else if(choice == 2) {
          searchBook(scanner);
         } else if(choice == 3){
         borrowBook(scanner, memberId);
         } else if (choice == 4) {
         returnBook(scanner, memberId);
         } else if ( choice == 5) {
         viewBorrowedBooks(memberId);
         } else if (choice == 6) {
         System.out.println("Signing out...");
         break;
         } else {
           System.out.println("Invalid choice. Please try again.");
         }
      
        }
        
      } else {
       System.out.println("Member ID not found. Please register first."); // will execute if the first if statement - if(memberIds.contains(memberID)) cant find the MemberId the user inputed
        }
      }

   static void addBook(Scanner scanner) {
    System.out.print("Enter Book Title: ");
    String title = scanner.nextLine();

    System.out.print("Enter Book ISBN: ");
    String isbn = scanner.nextLine();

    System.out.print("Enter Book Genre: ");
    String genre = scanner.nextLine();

    // Combine the details into a single string separated by semicolons
    String bookDetails = title + ";" + isbn + ";" + genre;
    catalog.add(bookDetails);

    System.out.println("Book '" + title + "' added to the catalog with ISBN: " + isbn + " and Genre: " + genre);
}

      

        static void searchBook(Scanner scanner) {
    System.out.print("Enter Book Title, ISBN, or Genre to Search: ");
    String query = scanner.nextLine();
    boolean found = false;

    // Loop through each book in the catalog
    for (int i = 0; i < catalog.size(); i++) {
        // Split the book details by the semicolon
        String[] bookDetails = catalog.get(i).split(";");

        // Check if the query matches the title, ISBN, or genre
        if (bookDetails[0].equalsIgnoreCase(query) || 
            bookDetails[1].equalsIgnoreCase(query) || 
            bookDetails[2].equalsIgnoreCase(query)) {
            System.out.println("Book Found: Title - " + bookDetails[0] + ", ISBN - " + bookDetails[1] + ", Genre - " + bookDetails[2]);
            found = true;
        }
    }

    // If no match was found
    if (!found) {
        System.out.println("Book not found in the catalog.");
    }
}

    static void borrowBook(Scanner scanner, String memberId) {
        System.out.print("Enter Book Title to Borrow: ");
        String bookTitle = scanner.nextLine();

        if (catalog.contains(bookTitle) && !borrowedBooks.contains(bookTitle)) {
            borrowedBooks.add(bookTitle);
            borrowedBy.add(memberId);
            borrowDates.add(new Date());
            System.out.println("Book '" + bookTitle + "' borrowed successfully.");
        } else {
            System.out.println("Book '" + bookTitle + "' is either not available or already borrowed.");
        }
    }

    static void returnBook(Scanner scanner, String memberId) {
        System.out.print("Enter Book Title to Return: ");
        String bookTitle = scanner.nextLine();

        int index = borrowedBooks.indexOf(bookTitle);
        if (index != -1 && borrowedBy.get(index).equals(memberId)) {
            borrowedBooks.remove(index);
            borrowedBy.remove(index);
            borrowDates.remove(index);
            System.out.println("Book '" + bookTitle + "' returned successfully.");
        } else {
            System.out.println("You have not borrowed this book.");
        }
    }

    static void viewBorrowedBooks(String memberId) {
        System.out.println("Borrowed books:");
        boolean found = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        for (int i = 0; i < borrowedBooks.size(); i++) {
            if (borrowedBy.get(i).equals(memberId)) {
                found = true;
                String bookTitle = borrowedBooks.get(i);
                Date borrowDate = borrowDates.get(i);
                System.out.println("- " + bookTitle + " (Borrowed on: " + dateFormat.format(borrowDate) + ")");

                // Check overdue
                long diff = new Date().getTime() - borrowDate.getTime();
                long days = diff / (1000 * 60 * 60 * 24);
                if (days > 7) {
                    System.out.println("  ** Overdue by " + (days - 7) + " days **");
                }
            }
        }

        if (!found) {
            System.out.println("No borrowed books.");
        }
    }

}


```
