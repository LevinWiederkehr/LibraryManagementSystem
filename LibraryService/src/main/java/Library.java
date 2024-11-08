import java.util.List;
import java.util.Optional;

public class Library implements LibraryService, UserService {
    private static Library instance;
    private Repository<Book> bookRepository = new Repository<>();
    private Repository<Person> userRepository = new Repository<>();

    // Privater Konstruktor für das Singleton-Pattern
    private Library() {}

    // Methode, um die Singleton-Instanz der Library zu erhalten
    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    // Methode zum Abrufen aller Bücher
    public List<Book> getAllBooks() {
        return bookRepository.getAll();
    }

    // Implementierung der addBook Methode aus dem LibraryService Interface
    @Override
    public void addBook(Book book) {
        bookRepository.add(book);
    }

    // Implementierung der borrowBook Methode aus dem LibraryService Interface
    @Override
    public Book borrowBook(String title) throws BookNotFoundException {
        Optional<Book> book = bookRepository.getAll().stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst();

        if (book.isPresent()) {
            return book.get();
        } else {
            throw new BookNotFoundException("Book with title \"" + title + "\" not found.");
        }
    }

    // Implementierung der registerUser Methode aus dem UserService Interface
    @Override
    public void registerUser(Person user) {
        userRepository.add(user);
    }

    // Implementierung der removeUser Methode aus dem UserService Interface
    @Override
    public void removeUser(String userId) {
        userRepository.getAll().removeIf(user -> user.getId().equals(userId));
    }
}
