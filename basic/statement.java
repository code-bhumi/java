public class statement {
    static void checkage(int age) {
        if (age < 18) {
            System.out.println("Access denied you are not old enough!");
        } else {
            System.ot.println("Access granted");
        }
    }
    public static void main(String[] args) {
        checkage(21);
    }
}