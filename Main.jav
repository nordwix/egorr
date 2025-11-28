import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Запуск програми (все классы в одном файле) ===");

        Book book1 = new Book(
            "978-0321356680", 
            "Effective Java", 
            "Joshua Bloch", 
            2018
        );
        Book book2 = new Book(
            "978-0132350884", 
            "Clean Code", 
            "Robert C. Martin", 
            2008
        );

        Reader reader1 = new Reader(
            "R001", 
            "Іван Петренко", 
            "050-123-45-67"
        );
        
        Librarian librarian1 = new Librarian(
            "L001",
            "Мария Васильевна",
            "09:00-17:00"
        );

        System.out.println("\n--- Созданные объекты Книг ---");
        System.out.println(book1);
        System.out.println(book2);

        System.out.println("\n--- Созданный объект Читателя ---");
        System.out.println(reader1);

        System.out.println("\n--- Созданный объект Библиотекаря ---");
        System.out.println(librarian1);
        
        System.out.println("\n--- Демонстрация работы методов ---");
        reader1.takeBook(book1);
        librarian1.issueBook(book1, reader1);
        reader1.returnBook(book1);

        System.out.println("\n=== Завершение программы ===");
    }
}

class Book {

    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private String status;

    public Book() {
        this.status = "в наличии";
    }

    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.status = "в наличии";
    }

    public void issueBook() {
        System.out.println("INFO: Книга '" + this.title + "' помечается как 'выдана'.");
        this.status = "выдана";
    }

    public void returnBook() {
        System.out.println("INFO: Книга '" + this.title + "' помечается как 'в наличии'.");
        this.status = "в наличии";
    }
    
    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", status='" + status + '\'' +
                '}';
    }
}

class Reader {

    private String readerId;
    private String fullName;
    private String phoneNumber;
    private List<Book> borrowedBooks;

    public Reader(String readerId, String fullName, String phoneNumber) {
        this.readerId = readerId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    public void takeBook(Book book) {
        System.out.println("INFO: Читатель '" + this.fullName + "' пытается взять книгу '" + book.getTitle() + "'");
    }

    public void returnBook(Book book) {
        System.out.println("INFO: Читатель '" + this.fullName + "' пытается вернуть книгу '" + book.getTitle() + "'");
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId='" + readerId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", borrowedBooksCount=" + borrowedBooks.size() +
                '}';
    }
}

class Librarian {
    
    private String employeeId;
    private String fullName;
    private String shift;

    public Librarian(String employeeId, String fullName, String shift) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.shift = shift;
    }

    public void issueBook(Book book, Reader reader) {
        System.out.println("INFO: Библиотекарь '" + this.fullName + "' выдает книгу '" + book.getTitle() + "' читателю '" + reader.toString() + "'");
    }
    
    public void acceptBookReturn(Book book) {
        System.out.println("INFO: Библиотекарь '" + this.fullName + "' принимает возврат книги '" + book.getTitle() + "'");
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "employeeId='" + employeeId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shift='" + shift + '\'' +
                '}';
    }
}
