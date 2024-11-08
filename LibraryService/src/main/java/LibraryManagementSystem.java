import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = Library.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Beispielhafte Bücher und Nutzer hinzufügen
        library.addBook(new Book("1984", "George Orwell", "123456789"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "987654321"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "112233445"));
        library.addBook(new Book("Moby Dick", "Herman Melville", "998877665"));

        library.registerUser(new Member("Alice", "M001"));
        library.registerUser(new Member("Bob", "M002"));

        // Menü
        while (!exit) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Show all books");
            System.out.println("2. Add a new book");
            System.out.println("3. Borrow a book");
            System.out.println("4. Register a new user");
            System.out.println("5. Remove a user");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Puffer leeren

            switch (choice) {
                case 1:
                    showAllBooks(library);
                    break;
                case 2:
                    addNewBook(library, scanner);
                    break;
                case 3:
                    borrowBook(library, scanner);
                    break;
                case 4:
                    registerNewUser(library, scanner);
                    break;
                case 5:
                    removeUser(library, scanner);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void showAllBooks(Library library) {
        System.out.println("\n--- List of Available Books ---");
        for (Book book : library.getAllBooks()) {  // Verwende getAllBooks() statt direkten Zugriff
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", ISBN: " + book.getIsbn());
        }
    }

    private static void addNewBook(Library library, Scanner scanner) {
        System.out.println("\n--- Add a New Book ---");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        Book newBook = new Book(title, author, isbn);
        library.addBook(newBook);
        System.out.println("Book added successfully!");
    }

    private static void borrowBook(Library library, Scanner scanner) {
        System.out.println("\n--- Borrow a Book ---");
        System.out.print("Enter the title of the book you want to borrow: ");
        String title = scanner.nextLine();

        try {
            Book borrowedBook = library.borrowBook(title);
            System.out.println("You borrowed: " + borrowedBook.getTitle());
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void registerNewUser(Library library, Scanner scanner) {
        System.out.println("\n--- Register a New User ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter user ID: ");
        String id = scanner.nextLine();

        Person newUser = new Member(name, id);
        library.registerUser(newUser);
        System.out.println("User registered successfully!");
    }

    private static void removeUser(Library library, Scanner scanner) {
        System.out.println("\n--- Remove a User ---");
        System.out.print("Enter the user ID of the user to remove: ");
        String userId = scanner.nextLine();

        library.removeUser(userId);
        System.out.println("User removed successfully (if they existed).");
    }
}
