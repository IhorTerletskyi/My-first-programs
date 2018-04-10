import java.util.Scanner;
import java.util.Arrays;

public class Lesson4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //Задание 1. Вывести на экран числа от 10 до 20 с помощью всех известных циклов.
		
		//Цикл while
		byte chislo = 10;
		while(chislo<=20){
			System.out.print(chislo + ",");
			chislo++;
		}
		System.out.println(" ");
		
		//Цикл do-while
		chislo = 10;
		do{
			System.out.print(chislo + ",");
			chislo++;
		}while(chislo<=20);
		System.out.println(" ");
		
		//цикл for
		for(chislo=10;chislo<=20;chislo++){
			System.out.print(chislo + ",");
		}
		System.out.println(" ");
		
		//цикл for-each
		byte[] array1020 = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		for(byte array1020Element:array1020){
			System.out.print(array1020Element + ",");
		}
		System.out.println(" ");
		
		//Задание 2. Вывести на экран все числа от 1 до 100, которые делятся на 3 без остатка.
		byte hundred = 1;
		while(hundred<101){
			if(hundred % 3 == 0){
				System.out.print(hundred + ",");
			}
			hundred++;
		}
		System.out.println(" ");
		
		//Задание 3. Заполнить массив числами от 100 до 0.
		byte[] array100 = new byte[101];
		for(byte counter=100; counter>=0; counter--){
			array100[counter] = counter;
		}
		
		/*Задание 4. Дано массив из 10 целых чисел. 
		 * Вывести на экран сумму всех его элементов кроме первого и последнего.
		 * Я использую массив array1020 из 1го задания (он из 11 элементов)
		 */
		int summArray = 0;
		for(int counter=1; counter<array1020.length-1;counter++){
			summArray = summArray + array1020[counter];
		}
		System.out.println(summArray);
		
		/*Задание 6 и 7. Найти в массиве чисел элементы с наибольшим и наименьшим значениями.
		 * Найти в массиве число, которое повторяется наибольшее количество раз. 
		 * Не использовать коллекции.
		 */
		
		byte[] arrayTask67 = {1,3,7,1,5,77,0,7,7,4,2};
		byte minArray = arrayTask67[0];
		byte maxArray = arrayTask67[0];
		for(byte counter=1; counter<11; counter++){
			if(arrayTask67[counter] < minArray){
			    minArray = arrayTask67[counter];
			   }
			if(arrayTask67[counter]>maxArray){
				maxArray = arrayTask67[counter];
			   }
		}
		System.out.println("min=" + minArray);
		System.out.println("max=" + maxArray);
		
		byte countTemp;
		byte count = 1;
		byte index = 0;
		for(byte currentArrayElement=0; currentArrayElement<11; currentArrayElement++){
			countTemp = 0;
			for(byte anotherArrayElement=currentArrayElement; anotherArrayElement<11; anotherArrayElement++){
				if(arrayTask67[currentArrayElement] == arrayTask67[anotherArrayElement]){
					countTemp++;
				}				
			}
			if(countTemp>count){
				count = countTemp;
				index = currentArrayElement;
			}
		}
		System.out.println("Frequntly repited element #" + index + "=" + arrayTask67[index]);
		System.out.println("Repited " + count + " times");
		
		/*Задание 9. Написать метод для зеркального переворота 
		 * элементов в массиве ([1, 2, 3, 4] -> [4, 3, 2, 1]).
		 * Используем массив arrayTask67 из задания 6 и 7.
		 */
		byte temp;
		for(byte counter=0; counter<arrayTask67.length/2; counter++){
			temp = arrayTask67[counter];
			arrayTask67[counter] = arrayTask67[(arrayTask67.length - 1) - counter];
			arrayTask67[(arrayTask67.length - 1) - counter] = temp;
		}
		System.out.println(Arrays.toString(arrayTask67));
		
		/*Задание 10. Написать метод, который заполнит массив произвольного размера 
		 * числами по возрастанию, начиная с центра массива, 
		 * например, [5,4,3,2,1,0,1,2,3,4,5].
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("enter array length:");
		int arrayLength = scan.nextInt();
		int[] newArray = new int[arrayLength];
		
		newArray[arrayLength/2] = 0;
		for(int counter=0;counter<arrayLength/2; counter++){
			newArray[arrayLength - 1 - counter] = arrayLength/2 - counter;
			newArray[counter] = arrayLength/2 - counter;
		}
		System.out.println(Arrays.toString(newArray));
	}

}
