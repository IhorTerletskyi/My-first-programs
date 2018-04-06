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
		
		//Цикл for
		for(chislo=10;chislo<=20;chislo++){
			System.out.print(chislo + ",");
		}
		System.out.println(" ");
		
		//Цикл for-each
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
		for(byte i=0; i<101; i++){
			array100[i] = i;
		}
		
		/*Задание 4. Дано массив из 10 целых чисел. 
		 * Вывести на экран сумму всех его элементов кроме первого и последнего.
		 * Я использую массив array1020 из 1го задания (он из 11 элементов)
		 */
		int summArray = 0;
		for(byte i=1; i<10; i++){
			summArray = summArray + array1020[i];
		}
		System.out.println(summArray);
		
		/*Задание 6 и 7. Найти в массиве чисел элементы с наибольшим и наименьшим значениями.
		 * Найти в массиве число, которое повторяется наибольшее количество раз. 
		 * Не использовать коллекции.
		 */
		
		byte[] arrayTask67 = {1,3,7,1,5,77,0,7,7,4,2};
		byte minArray = arrayTask67[0];
		byte maxArray = arrayTask67[0];
		for(byte i=1; i<11; i++){
			if(arrayTask67[i] < minArray){
			    minArray = arrayTask67[i];
			   }
			if(arrayTask67[i]>maxArray){
				maxArray = arrayTask67[i];
			   }
		}
		System.out.println("min=" + minArray);
		System.out.println("max=" + maxArray);
		
		byte countTemp;
		byte count = 1;
		byte index = 0;
		for(byte i=0; i<11; i++){
			countTemp = 0;
			for(byte j=i; j<11; j++){
				if(arrayTask67[i] == arrayTask67[j]){
					countTemp++;
				}				
			}
			if(countTemp>count){
				count = countTemp;
				index = i;
			}
		}
		System.out.println("Frequntly repited element #" + index + "=" + arrayTask67[index]);
		System.out.println("Repited " + count + " times");
		
		/*Задание 9. Написать метод для зеркального переворота 
		 * элементов в массиве ([1, 2, 3, 4] -> [4, 3, 2, 1]).
		 * Используем массив arrayTask67 из задания 6 и 7.
		 */
		byte temp;
			for(byte i=0; i<arrayTask67.length/2; i++){
			temp = arrayTask67[i];
			arrayTask67[i] = arrayTask67[(arrayTask67.length - 1) - i];
			arrayTask67[(arrayTask67.length - 1) - i] = temp;
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
		if(arrayLength%2 == 0){
			for(int i=0; i<arrayLength/2; i++){
				newArray[(arrayLength/2-1) - i] = i+1;
				newArray[arrayLength/2 + i] = i+1;
			}
		}else{
			newArray[arrayLength/2] = 0;
			for(int i=1;i<=arrayLength/2; i++){
				newArray[arrayLength/2 - i] = i;
				newArray[arrayLength/2 + i] = i;
			}
		}
		System.out.println(Arrays.toString(newArray));
	}

}
