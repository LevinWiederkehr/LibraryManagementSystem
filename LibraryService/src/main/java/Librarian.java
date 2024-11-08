public class Librarian extends Person {
    public Librarian(String name, String id) {
        super(name, id);
    }

    @Override
    public void performRole() {
        System.out.println("Librarian managing library");
    }
}