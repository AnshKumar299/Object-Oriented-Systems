import java.util.ArrayList;

class Book {
    private String author;
    private String title;
    private String publisher;
    private int cost;
    private int stockposition;

    Book(String author, String title, String publisher, int cost, int stock) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.cost = cost;
        stockposition = stock;
    }

    String getauthor() {
        return author;
    }

    String gettitle() {
        return title;
    }

    String getpub() {
        return publisher;
    }

    int getcost() {
        return cost;
    }

    int getstock() {
        return stockposition;
    }

    void setcost(int i) {
        cost = i;
    }

    void setstock(int i) {
        stockposition = i;
    }

    void addcopies(int i) {
        stockposition += i;
    }

    void removecopies(int i) {
        stockposition -= i;
    }

    void display() {
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Publisher : " + publisher);
        System.out.println("Cost : " + cost);
        System.out.println("Books in stock : " + stockposition);
    }
}

class BookShop {
    ArrayList<Book> books = new ArrayList<Book>();

    void addBooks(Book b) {
        books.add(b);
    }

    void remove(Book b) {
        books.remove(b);
    }

    void searchbook(String title) {
        for (Book i : books) {
            if (i.gettitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: ");
                i.display();
                System.out.println();
                return;
            }
        }
        System.out.println("Book Not Found----- \n");
    }

    void buybooks(String title, int no) {
        for (Book i : books) {
            if (i.gettitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: ");
                if (i.getstock() < no) {
                    System.out.println("Required Number of copies not available");
                } else {
                    i.display();
                    System.out.println("Total Cost of " + no + " copies : " + i.getcost() * no);
                    i.removecopies(no);
                }
            }
        }
        System.out.println("Book Not Found----- \n");
    }
}

public class Q10 {
    public static void main(String[] args) {
        Book b1 = new Book("RC Sarkar", "Electronics simplified", "PSS", 1500, 12);
        Book b2 = new Book("Premchand", "Godan", "Raj Books", 120, 50);
        Book b3 = new Book("Colleen Hoover", "It ends with us", "NYP", 200, 43);

        BookShop bs = new BookShop();
        bs.addBooks(b1);
        bs.addBooks(b2);
        bs.addBooks(b3);

        String searchtitle = "Electronics Simplified";
        System.out.println("Book to be searched is : " + searchtitle);
        bs.searchbook(searchtitle);

        int tobuy = 12;
        System.out.println("To buy " + tobuy + " copies of " + searchtitle);
        bs.buybooks(searchtitle, tobuy);

        System.out.println();
        System.out.println("Updated details of books: ");
        for (Book i : bs.books) {
            i.display();
            System.out.println();
        }
    }
}
