public class Member extends Person {
    public Member(String name, String id) {
        super(name, id);
    }

    @Override
    public void performRole() {
        System.out.println("Member borrowing books");
    }
}