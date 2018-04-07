import java.util.Scanner;
import java.util.Arrays;

public class Lesson3New {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Выполняю ДЗ с третьего урока с помощью циклов
		 * Объеденив задания в одно, получаю такие подпункты:
		 * - Задать с клавиатуры длину массива и ввести с клавиатуры все его элементы
		 * - Разбить его на два массива равной длины (или почти равной при неченом кол-ве элементов)
		 * - Отсортировать два полученных массива и вывести их на экран
		 * - в исходном массиве поменять первый и последний элемент местами и вывести его на экран
		 * - подсчитать среднее арифметическое в исходном массиве
		 * - зеркально преобразовать исходный массив
		 * - вывести на экран элемент, номер которого заданный с клавиатуры
		 */
		
		Scanner scan = new Scanner(System.in);
		int arrayLength;
		
		System.out.print("Enter array length:");
		arrayLength = scan.nextInt();
		double[] customerArray = new double[arrayLength];
		double sredAref = 0;
		
		for(int i=0; i<arrayLength; i++){
			System.out.print("Enter " + i + " element:");
			customerArray[i] = scan.nextDouble();
			sredAref = sredAref + customerArray[i];        //Сразу считаем среднее арифметическое массива
		}
		sredAref = sredAref / arrayLength;
		
		//Разбиваем массив на два, сортируем их и выводим на экран		
		double[] halfArray1 = new double[arrayLength/2];
		double[] halfArray2 = new double[arrayLength - (arrayLength/2)];
		
		System.arraycopy(customerArray, 0, halfArray1, 0, arrayLength/2);
		System.arraycopy(customerArray, arrayLength/2, halfArray2, 0, halfArray2.length);
		
		Arrays.sort(halfArray1);
		Arrays.sort(halfArray2);
		
		System.out.println(Arrays.toString(halfArray1));
		System.out.println(Arrays.toString(halfArray2));
		
		//меняем местами первый и последний элементы в исходном массиве
		double temp = customerArray[arrayLength-1];
		customerArray[arrayLength-1] = customerArray[0];
		customerArray[0] = temp;
		
		System.out.println(Arrays.toString(customerArray));
		
		//Выводим уже посчитанное среднее арифметическое
		System.out.println("Srednee arifmeticheskoe = " + sredAref);
		
		//Зеркально преображаем массив
		for(int i=0; i<arrayLength/2; i++){
			temp = customerArray[arrayLength-1 - i];
			customerArray[arrayLength-1 - i] = customerArray[i];
			customerArray[i] = temp;
		}
		System.out.println(Arrays.toString(customerArray));
		
		//Выводим на экран элемент, номер которого задан с клавиатуры
		System.out.print("Enter element number:");
		int elementNumber = scan.nextInt();
		System.out.println("Element nuber " + elementNumber + " = " + customerArray[elementNumber]);
	

	}

}
