import java.util.ArrayList;
import java.util.Scanner;

// superclass Publication for all types of publications
class Publication {

    // private makes only this class can access them
    private String title;
    private String author;
    private int publicationYear;

    // constructor to set up the publication
    Publication(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // get title
    String getTitle() {
        return title;
    }

    // get author
    String getAuthor() {
        return author;
    }

    // get publicationYear
    int getPublicationYear() {
        return publicationYear;
    }

    // display publication info
    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// child class of publication - Book
class Book extends Publication {

    private String ISBN; // unique ID for the book

    // constructor
    Book(String title, String author, int publicationYear, String ISBN) {
        super(title, author, publicationYear); // call publication constructor
        this.ISBN = ISBN; // set the ISBN
    }

    // get ISBN
    String getISBN() {
        return ISBN;
    }

    @Override // Override displayInfo() to also show the ISBN
    void displayInfo() {
        super.displayInfo(); // call the parent method to print title, author, year
        System.out.println("ISBN: " + ISBN); // add ISBN on top
    }
}

class Magazine extends Publication {

    private int issueNumber; // issue of magazine

    Magazine(String title, String author, int publicationYear, int issueNumber) {
        super(title, author, publicationYear); // call publication constructor
        this.issueNumber = issueNumber; // set the issue number
    }

    // get issueNumber
    int getIssueNumber() {
        return issueNumber;
    }

    @Override // show the issue number
    void displayInfo() {
        super.displayInfo(); // print title, author, year
        System.out.println("Issue Number: " + issueNumber); // add issue number
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Publication> library = new ArrayList<>(); // store all publications (books and magazines)

        System.out.println("Enter the number of books to add:");
        int numBooks = Integer.parseInt(scanner.nextLine()); // read number of books

        // loop to get details for each book
        for (int i = 1; i <= numBooks; i++) {
            System.out.println("Enter Book " + i + " details:");

            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Author: ");
            String author = scanner.nextLine();

            System.out.print("Publication Year: ");
            int year = Integer.parseInt(scanner.nextLine());

            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();

            Book book = new Book(title, author, year, isbn); // create a new Book object with the input info

            library.add(book); // add the book to list
        }

        // get Magazines from user
        System.out.println("Enter the number of magazines to add:");
        int numMagazines = Integer.parseInt(scanner.nextLine()); // read number of magazines

        // loop to get details for each magazine
        for (int i = 1; i <= numMagazines; i++) {
            System.out.println("Enter Magazine " + i + " details:"); // tell user which magazine

            System.out.print("Title: ");
            String title = scanner.nextLine(); // read title

            System.out.print("Author: ");
            String author = scanner.nextLine(); // read author

            System.out.print("Publication Year: ");
            int year = Integer.parseInt(scanner.nextLine()); // read year

            System.out.print("Issue Number: ");
            int issueNum = Integer.parseInt(scanner.nextLine()); // read issue number

            // Create a Magazine object with the info we got
            Magazine magazine = new Magazine(title, author, year, issueNum);

            library.add(magazine); // add the magazine to our library list
        }

        System.out.println("\nLibrary Collection:");

        // loop through every item in the library ArrayList
        for (Publication pub : library) {
            pub.displayInfo();
            System.out.println("---");
        }

        scanner.close();
    }
}
