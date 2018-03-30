import java.util.Scanner;

public class Lesson2DZ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first number a:");
        double a = scanner.nextDouble();
        System.out.print("Enter second number b:");
        double b = scanner.nextDouble();
        
        double summa = a + b;
        double raznitsa = a - b;
        double umnozhenie = a * b;
        double delenie = a / b;
        
        System.out.println("a+b=" + summa);
        System.out.println("a-b=" + raznitsa);
        System.out.println("a*b=" + umnozhenie);
        System.out.println("a/b=" + delenie);
        
	}

}
