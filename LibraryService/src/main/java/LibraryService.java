// LibraryService.java
public interface LibraryService {
    void addBook(Book book);
    Book borrowBook(String title) throws BookNotFoundException;
}

