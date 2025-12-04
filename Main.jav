import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class LibraryApp {
    
    public static class User {
        private int userId;
        private String firstName;
        private String lastName;
        private String login;
        private String password;
        protected String role;

        public User() {
            this.role = "звичайний користувач";
        }

        public User(int userId, String firstName, String lastName, String login, String password, String role) {
            this.userId = userId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.login = login;
            this.password = password;
            this.role = role;
        }

        public void register() {}
        public boolean authorize(String login, String password) {return false;}
        public void searchBook(String query) {}
        public void readBook(int bookId) {}
        public void addToFavorites(int bookId) {}
        
        public int getUserId() {return userId;}

        @Override
        public String toString() {
            return "User {" +
                    "userId=" + userId +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", login='" + login + '\'' +
                    ", role='" + role + '\'' +
                    '}';
        }
    }

    public static class Admin extends User {
        private int adminId;
        private List<String> actionsLog;

        public Admin() {
            super();
            this.adminId = 0;
            this.actionsLog = new ArrayList<>();
            this.role = "адміністратор";
        }

        public Admin(int adminId, String firstName, String lastName, String login, String password) {
            super(adminId, firstName, lastName, login, password, "адміністратор");
            this.adminId = adminId;
            this.actionsLog = new ArrayList<>();
        }

        public void addBook(Book book) {
            this.actionsLog.add("Додано книгу: " + book.getTitle());
        }

        public void deleteBook(int bookId) {
            this.actionsLog.add("Видалено книгу з ID: " + bookId);
        }

        public void editBookInfo(int bookId, String newTitle) {
            this.actionsLog.add("Відредаговано книгу з ID: " + bookId);
        }

        public void blockUser(int userId) {
            this.actionsLog.add("Заблоковано користувача з ID: " + userId);
        }

        @Override
        public String toString() {
            return "Admin {" +
                    "adminId=" + adminId +
                    ", firstName='" + super.firstName + '\'' +
                    ", lastName='" + super.lastName + '\'' +
                    ", login='" + super.login + '\'' +
                    ", role='" + super.role + '\'' +
                    ", actionsLogCount=" + actionsLog.size() +
                    '}';
        }
    }
    
    public static class Book {
        private int bookId;
        private String title;
        private String author;
        private int year;
        private String genre;
        private String type;
        private String fileLink;

        public Book() {
            this.year = 0;
            this.type = "електронна книга";
        }

        public Book(int bookId, String title, String author, int year, String genre, String type, String fileLink) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.year = year;
            this.genre = genre;
            this.type = type;
            this.fileLink = fileLink;
        }

        public String getTitle() {return this.title;}
        public String getContent() {return "Контент книги...";}
        public boolean isSearchable() {return true;}
        public int getBookId() {return bookId;}

        @Override
        public String toString() {
            return "Book {" +
                    "bookId=" + bookId +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", year=" + year +
                    ", genre='" + genre + '\'' +
                    ", type='" + type + '\'' +
                    ", fileLink='" + fileLink + '\'' +
                    '}';
        }
    }

    public static class Category {
        private int categoryId;
        private String name;
        private List<Integer> bookIds;

        public Category() {
            this.bookIds = new ArrayList<>();
        }

        public Category(int categoryId, String name) {
            this.categoryId = categoryId;
            this.name = name;
            this.bookIds = new ArrayList<>();
        }

        public void addBookId(int bookId) {
            this.bookIds.add(bookId);
        }

        public void removeBookId(int bookId) {
            this.bookIds.remove((Integer) bookId);
        }

        public void browseCategory() {}

        @Override
        public String toString() {
            return "Category {" +
                    "categoryId=" + categoryId +
                    ", name='" + name + '\'' +
                    ", bookCount=" + bookIds.size() +
                    '}';
        }
    }

    public static class LibraryCatalog {
        private List<Book> allBooks;
        private Map<Integer, Integer> bookCategoryMap;

        public LibraryCatalog() {
            this.allBooks = new ArrayList<>();
            this.bookCategoryMap = new HashMap<>();
        }

        public List<Book> searchByTitle(String title) {return new ArrayList<>();}
        public List<Book> searchByAuthor(String author) {return new ArrayList<>();}
        public List<Book> searchByGenre(String genre) {return new ArrayList<>();}
        public void displayResults(List<Book> results) {}
        public void linkBookToCategory(int bookId, int categoryId) {}

        @Override
        public String toString() {
            return "LibraryCatalog {" +
                    "totalBooks=" + allBooks.size() +
                    ", totalLinks=" + bookCategoryMap.size() +
                    ", status='Готовий до пошуку'" +
                    '}';
        }
    }

    public static class DownloadOrder {
        private int downloadId;
        private int userId;
        private int bookId;
        private LocalDateTime downloadDateTime;

        public DownloadOrder() {
            this.downloadDateTime = LocalDateTime.now();
        }

        public DownloadOrder(int downloadId, int userId, int bookId) {
            this.downloadId = downloadId;
            this.userId = userId;
            this.bookId = bookId;
            this.downloadDateTime = LocalDateTime.now();
        }

        public void recordDownload() {}
        public boolean checkLimit(int userId) {return true;}

        @Override
        public String toString() {
            return "DownloadOrder {" +
                    "downloadId=" + downloadId +
                    ", userId=" + userId +
                    ", bookId=" + bookId +
                    ", downloadDateTime=" + downloadDateTime.toString() +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Демонстрація створення об'єктів для Електронної Бібліотеки ---\n");

        User standardUser = new User(
            101, 
            "Олена", 
            "Іваненко", 
            "o.ivanenko", 
            "secure_pass123", 
            "звичайний користувач"
        );
        System.out.println("Об'єкт User:");
        System.out.println(standardUser.toString());
        System.out.println("------------------------");

        Admin libraryAdmin = new Admin(
            1, 
            "Петро", 
            "Сидоренко", 
            "admin_petro", 
            "admin_secret_pass"
        );
        Book dummyBook = new Book(200, "Тестова Книга", "Автор А", 2023, "Техніка", "електронна книга", "/path/test.pdf");
        libraryAdmin.addBook(dummyBook); 
        System.out.println("Об'єкт Admin:");
        System.out.println(libraryAdmin.toString());
        System.out.println("------------------------");

        Book scienceBook = new Book(
            201, 
            "Квантова Фізика для Чайників", 
            "Джон Сміт", 
            2020, 
            "Наукова література", 
            "електронна книга", 
            "/files/quant.pdf"
        );
        System.out.println("Об'єкт Book:");
        System.out.println(scienceBook.toString());
        System.out.println("------------------------");

        Category categoryScience = new Category(3, "Наукова література");
        categoryScience.addBookId(scienceBook.getBookId());
        System.out.println("Об'єкт Category:");
        System.out.println(categoryScience.toString());
        System.out.println("------------------------");

        LibraryCatalog catalog = new LibraryCatalog();
        System.out.println("Об'єкт LibraryCatalog:");
        System.out.println(catalog.toString());
        System.out.println("------------------------");

        DownloadOrder order = new DownloadOrder(
            5001, 
            standardUser.getUserId(),
            scienceBook.getBookId()
        );
        System.out.println("Об'єкт DownloadOrder:");
        System.out.println(order.toString());
        System.out.println("------------------------");
    }
}
