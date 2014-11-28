import java.util.Scanner;
class Main
{
    public static void main(String[] args)
    {
        int a = 4;
        method2();
        System.out.format("Printing from outside %d",a);
    }
    public static void method2() {
        int a =10;
        System.out.format("Printing from inside %d",a);
    }
}
