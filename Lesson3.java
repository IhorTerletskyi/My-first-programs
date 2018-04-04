import java.util.Scanner;
import java.util.Arrays;

public class Lesson3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /* Задание 1 объеденяю с заданием 3
         * - Ввести с клавиатуры массив из 10 чисел
         * - разбить его на два массива равной длины
         * - отсортировать все три массива
         * - вывести их на экран         */
		
		Scanner scan = new Scanner(System.in);
		int[] customerArray = new int[10];
		
		System.out.print("Enter 1st number");
		customerArray[0] = scan.nextInt();
		System.out.print("Enter 2nd number");
		customerArray[1] = scan.nextInt();
		System.out.print("Enter 3rd number");
		customerArray[2] = scan.nextInt();
		System.out.print("Enter 4th number");
		customerArray[3] = scan.nextInt();
		System.out.print("Enter 5th number");
		customerArray[4] = scan.nextInt();
		System.out.print("Enter 6th number");
		customerArray[5] = scan.nextInt();
		System.out.print("Enter 7th number");
		customerArray[6] = scan.nextInt();
		System.out.print("Enter 8th number");
		customerArray[7] = scan.nextInt();
		System.out.print("Enter 9th number");
		customerArray[8] = scan.nextInt();
		System.out.print("Enter 10th number");
		customerArray[9] = scan.nextInt();
		System.out.println("You enter:" + Arrays.toString(customerArray));
		
		int[] halfArray1 = new int[5];
		int[] halfArray2 = new int[5];
		
		System.arraycopy(customerArray, 0, halfArray1, 0, 5);
		System.arraycopy(customerArray, 5, halfArray2, 0, 5);
		
		Arrays.sort(customerArray);
		Arrays.sort(halfArray1);
		Arrays.sort(halfArray2);
		
		System.out.println("Customer array:" + Arrays.toString(customerArray));
		System.out.println("First half array:" + Arrays.toString(halfArray1));
		System.out.println("Second half array:" + Arrays.toString(halfArray2));
		
		/* Задание 2.
		 * - Задать массив из N чисел (например 4 числа)
		 * - поменять первый и последний элементы местами
		 * - вывести массив на экран
		 */
		
		int[] array4Number = {10, 25, 13, 99};
		System.out.println("array of 4 number:" + Arrays.toString(array4Number));
		int temp = array4Number[0];
		array4Number[0] = array4Number[3];
		array4Number[3] = temp;
		System.out.println("Modificed array of 4 number:" + Arrays.toString(array4Number));
		
		/* Задание 4. Посчитать среднне арифметическое массива.
		 * буду использовать введенный массив 10 элементов customerArray из первого задания 
		 */
		
		
		double sredarif = (customerArray[0] + customerArray[1] + customerArray[2] 
				+ customerArray[3] + customerArray[4] + customerArray[5] + 
				customerArray[6] + customerArray[7] + customerArray[8] + customerArray[9]) / 10;
		System.out.println("Srednee arifmeticheskoe =" + sredarif);
		
		/* Задание 5. Написать код для зеркального преобразования массива
		 * т.к. циклы мы еше не учили, сделаю деревянным методом и буду использовать
		 * введенный отсортированный массив из первого задания
		 */
		
		int[] mirrorArray = new int[10];
		mirrorArray[0] = customerArray[9];
		mirrorArray[1] = customerArray[8];
		mirrorArray[2] = customerArray[7];
		mirrorArray[3] = customerArray[6];
		mirrorArray[4] = customerArray[5];
		mirrorArray[5] = customerArray[4];
		mirrorArray[6] = customerArray[3];
		mirrorArray[7] = customerArray[2];
		mirrorArray[8] = customerArray[1];
		mirrorArray[9] = customerArray[0];
		System.out.println("Mirror array:" + Arrays.toString(mirrorArray));
		
		/*Задание 6. Написать программу, которая позволит задать длину массива с клавиатуры,
		 * наполнить его элементами, а затем выводить нужный элемент по его индексу на консоль.
		 */
	    int dlina;
	    int index;
	    	    
	    System.out.print("Enter array length:");
	    dlina = scan.nextInt();
	    int[] arrayNNumbers = new int[dlina];
	    Arrays.fill(arrayNNumbers, 7);
	    System.out.print("Enter element array index:");
	    index = scan.nextInt();
	    System.out.println(index + "th element = " + arrayNNumbers[index]);
	
	}

}
