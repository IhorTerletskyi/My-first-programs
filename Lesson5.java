import java.util.Arrays;

public class Lesson5 {
	
	/*Написать функцию, которая принимает в качестве аргументов 
	 * одну строку X, целое число Y и число с плавающей точкой Z
	 * и возвращает как результат строку в виде
	 * S = x + y + z.
	 * Однобуквенные переменные использую потому что так сказано в постановке задачи
	 */
	static String newString(String x, int y, double z) {
		String tripleString = x + y + z;
		return tripleString;
	}
	
	/*Написать функцию, которая принимает массив чисел в качестве аргумента,
	 * увеличивает его первые 3 элемента на 1 и возвращает их сумму как результат.
	 * После изменения массив и сумму надо вывести на экран.
	 */
	static int summPlusThree(int[] massiv){
		int summ = 0;
		for(int element=0; element<massiv.length; element++){
			if(element<3){
				massiv[element]++;
			}			
			summ+=massiv[element];
			System.out.println("Element " + element + " = " + massiv[element]);
		}
		System.out.println("summ=" + summ);
		return summ;		
	}
	
	/*Написать ф-ю, которая принимает на вход массив чисел и возвращает его длину в байтах как результат
	 * 
	 * Исходя из того что переменная типа int это 4 байта, то количество байт
	 * это количество элементов массива увеличенное в 4 раза
	 */
	static int byteQuantity(int[] massiv){
		int quantity = massiv.length * 4;
		return quantity;
	}
	
	//Написать ф-ю для объединения 2-х массивов в один. Вывести результат на консоль	 
	static int[] twoInOneArray(int[] firstArray, int[] secondArray){
		int newArrayLength = firstArray.length + secondArray.length;
		int[] newArray = new int[newArrayLength];
		for(int element=0; element<firstArray.length; element++){
			newArray[element] = firstArray[element];
		}
		for(int element=0; element<secondArray.length; element++){
			newArray[firstArray.length + element] = secondArray[element];
		}
		return newArray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Все методы написаны из расчета произвольной длины массивов,
		 * но чтобы не заморачиватся с долгим введением значений я их задаю изначально
		 * 
		 * Однобуквенные переменные использую исходя из условий задания
		 */
		String x = "My number ";
		int y = 359;
		double z = 2.5;
		int[] firstArray = new int[]{10, 20, 50, 25, 20};
		int[] secondArray = new int[]{60, 70, 32, 8};
		
		String s = newString(x,y,z);
		System.out.println(s);
		
		int summOfFirstArrayPlusThree = summPlusThree(firstArray);
		//Еще раз выводим сумму элементов
		System.out.println("summ of first array =" + summOfFirstArrayPlusThree);
		
		int byteQuantityInFirstArray = byteQuantity(firstArray);
		System.out.println("byte quantity of first array =" + byteQuantityInFirstArray);
		
		int[] twoArrays = twoInOneArray(firstArray,secondArray);
		String twoArraysString = Arrays.toString(twoArrays);
		System.out.println(twoArraysString);

	}

}
