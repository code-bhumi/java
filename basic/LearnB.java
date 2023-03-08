public class LearnB {
    public static void main(String[] args) {
        String name = "Adwita";
        int age = 5;
        System.out.println("Hi I am " + name + ", I am " + age + " years old !!!");

        name = "Atharv";
        age = 3;
        System.out.println("Hi I am " + name + ", I am " + age + " years old !!!");

        final char temp = 'v';
        for (int i = 0; i < name.length(); ++i) {
            if (name.charAt(i) == temp)
                System.out.println("I found out v at " + i);
        }
    }
}
