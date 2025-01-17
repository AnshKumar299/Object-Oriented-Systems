abstract class Publication {
    int noOfPages, price;
    String publisher;

    int getpg() {
        return noOfPages;
    }

    int getprice() {
        return price;
    }

    String getpub() {
        return publisher;
    }

    void setpg(int s) {
        noOfPages = s;
    }

    void setprice(int s) {
        price = s;
    }

    void setpub(String s) {
        publisher = s;
    }

    void print() {
        System.out.println("Publication = " + getpub());
        System.out.println("Price = " + getprice());
        System.out.println("No. of pages = " + getpg());
    }
}

class Book extends Publication {
    Book(String publishername, int price, int pages) {
        setpg(pages);
        setprice(pages);
        setpub(publishername);
    }

    void display() {
        System.out.println("Type : Book");
        print();
        System.out.println();
    }
}

class Journal extends Publication {
    Journal(String publishername, int price, int pages) {
        setpg(pages);
        setprice(pages);
        setpub(publishername);
    }

    void display() {
        System.out.println("Type: Journal");
        print();
        System.out.println();
    }
}

public class Library {
    public static void main(String[] args) {
        Book b1 = new Book("Diamond Publishers", 350, 550);
        Book b2 = new Book("Raj Books", 200, 410);
        Book b3 = new Book("PC roy publications", 500, 850);
        Journal j1 = new Journal("JCK", 120, 90);
        Journal j2 = new Journal("JCL", 320, 240);
        System.out.println("3 books and 2 jounals created:");
        b1.display();
        b2.display();
        b3.display();
        j1.display();
        j2.display();
    }
}
