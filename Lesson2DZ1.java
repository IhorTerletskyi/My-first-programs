import java.util.Scanner;

public class Lesson2DZ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first string:");
        String s1 = scanner.nextLine();
        System.out.print("Enter second string:");
        String s2 = scanner.nextLine();
        System.out.print("Enter third string:");
        String s3 = scanner.nextLine();
        
        System.out.println("s1+s3:" + s1 + s3);
        System.out.println("s3+s2+s1:" + s3 + s2 + s1);
        System.out.println("s1+s2+s3:" + s1 + s2 + s3);
	}

}
