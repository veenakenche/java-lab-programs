import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String name;
    private String author;
    private double price;
    private int numPages;
    public Book(String name, String author, double price, int numPages) {     
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getNumPages() {
        return numPages;
    }
    public String toString() {
        return "Book Details:\n" +
               "Name: " + name + "\n" +
               "Author: " + author + "\n" +
               "Price: $" + price + "\n" +
               "Number of Pages: " + numPages;
    }
}

public class BookStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        System.out.print("Enter the number of books you want to create: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for book " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Author: ");
            String author = scanner.nextLine();

            System.out.print("Price: ");                                                              
            double price = scanner.nextDouble();

            System.out.print("Number of Pages: ");
            int numPages = scanner.nextInt();
            scanner.nextLine();

            books.add(new Book(name, author, price, numPages));
        }

        System.out.println("\nBooks created:");
        for (Book book : books) {
            System.out.println(book);
            System.out.println();
        }

        scanner.close();
    }
}
