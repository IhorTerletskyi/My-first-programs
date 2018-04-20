import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Lesson6 {
	
	/*Ввести с консоли дату. Сравнить ее с текущей датой в системе.
	 * Вывести отличающиеся части (год, месяц) на экран.
	 */
	static void dateEquals() {
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar currentDate = Calendar.getInstance();
		Calendar customerDate = Calendar.getInstance();
		
		System.out.print("Enter your date dd/MM/yyyy :");
		String enteringDate = scan.nextLine();
		
		try {
			Date userDate = sdf.parse(enteringDate);
			customerDate.setTime(userDate);
		}catch (ParseException e){
			System.out.println("Wrong Date!!!");
		}
		
		int currentYear = currentDate.get(Calendar.YEAR);
		int currentMonth = currentDate.get(Calendar.MONTH) + 1;
		int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);
		
		int userYear = customerDate.get(Calendar.YEAR);
		int userMonth = customerDate.get(Calendar.MONTH) + 1;
		int userDay = customerDate.get(Calendar.DAY_OF_MONTH);
		
		if(currentYear != userYear){
			System.out.printf("Current year = %d , but user year = %d", currentYear, userYear);
			System.out.println();
		}
		if(currentMonth != userMonth){
			System.out.printf("Current month = %d , but user month = %d", currentMonth, userMonth);
			System.out.println();
		}
		if(currentDay != userDay){
			System.out.printf("Current day = %d , but user day = %d", currentDay, userDay);
			System.out.println();
		}
		
	
	}
	
	//Написать свой вариант ф-и Arrays.equalsдля short[].
	static boolean isEqualsShort (short first[], short second[]) {
		boolean yes = true;		
		if(first.length != second.length) {
			yes = false;
		}
		
		for(int counter = 0; (counter < first.length)&&(yes); counter++) {
			if(first[counter] != second[counter]){
				yes = false;
			}			
		}
		
		return yes;
	}
	
	//Написать свой вариант ф-и Arrays.toString() для int[].
	static String intToString (int array[]) {
		String intInString;
		StringBuilder result = new StringBuilder();
		for(int counter = 0; counter < array.length; counter++) {
			result.append(array[counter]);
			result.append(", ");
		}
		result = result.delete(result.length()-2, result.length()-1);
		intInString = result.toString();
		return intInString;
	}
	
	//Написать код, который позволит менять и читать значения произвольных битов в массиве int-ов.
	static void bitChange(int array[]) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("What array element you whant to change? Select from 0 to %d", (array.length-1));
		int elementNumber = scan.nextInt();
		System.out.printf("Element number %d = %d", elementNumber, array[elementNumber]);
		System.out.println();
		System.out.printf("In binary = %32s", Integer.toBinaryString(array[elementNumber]));
		System.out.println();
		System.out.print("What bit you whant to change? Select from 0 to 31, where 0 it's rigtest bit.");
		int biteNumber = scan.nextInt();
		int biteCode = (int)Math.pow(2, biteNumber);
		int check = biteCode & array[elementNumber];
		int biteValue;
		if (check == biteCode){
			biteValue=1;
		}else{
			biteValue=0;
		}
		System.out.printf("Now bit number %d = %d. Are You whant to change that? 1 - yes", biteNumber, biteValue);
		int yesNo = scan.nextInt();
		if (yesNo == 1) {
			array[elementNumber] = biteCode ^ array[elementNumber];
		}
		System.out.printf("In binary = %32s", Integer.toBinaryString(array[elementNumber]));
		System.out.println();
		
	}
	
	/*Ввести с консоли число в бинарном формате.
	 * Перевести его в int и вывести на экран(“10” -> 2).
	 */
	static void binaryToInt() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number:");
		String binaryInString = scan.nextLine();
		int result = 0;
		for (int counter = 1; counter <= binaryInString.length(); counter++) {
			int charNumber = binaryInString.length() - counter;
			if(binaryInString.charAt(charNumber) == '1'){
				result += (int)Math.pow(2,counter-1);
			}
		}
		System.out.printf("%s --> %d", binaryInString, result);
		System.out.println();
	}
	
	/*Ввести с консоли целое число. 
	 * Посчитать количество единиц в его бинарном представлении (“1011”–> 3).
	 */
	static void oneValue () {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number:");
		int number = scan.nextInt();
		String numberBinary = Integer.toBinaryString(number);
		int result = 0;
		for (int counter = 0; counter < numberBinary.length(); counter++) {
			if(numberBinary.charAt(counter) == '1'){
				result++;
			}
		}
		System.out.printf("%s --> 1 is %d times", numberBinary, result);
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//dateEquals();
		
		short first[] = new short[] {1, 2, 3, 4, 5};
		short second[] = new short[] {1,1,3,4,5};
		boolean same = isEqualsShort(first,second);
		System.out.println("Arrays first and second is same:" + same);
		
		int array[] = new int[] {245, 85189, 2157,52, 36};
		String stringArray = intToString(array);
		System.out.println(stringArray);
		
		bitChange(array);
		
		binaryToInt();
		
		oneValue();
	}

}
