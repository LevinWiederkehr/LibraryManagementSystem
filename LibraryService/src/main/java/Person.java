// Person.java
public abstract class Person {
    private String name;
    private String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {  // Diese Methode stellt die ID bereit
        return id;
    }

    // Abstrakte Methode, die in den abgeleiteten Klassen implementiert wird
    public abstract void performRole();
}
