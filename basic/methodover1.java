public class methodover1 {
    static int plusMethodInt(int x, int y) {
    return x + y;
    } 

static double plusMethodDouble(double x, double y) {
    return x + y;
    }

public static void main(String[] args) {
    int myNum1 = plusMethodInt(6,7);
    double myNum2 = plusMethodDouble(5.3,8.7);
    system.out.println("int: " + myNum1);
    system.out.println("double: " + myNum2);
    }

}