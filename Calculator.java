import java.util.Scanner;
import java.util.Arrays;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		//ввод математического выражения
		String customerString;
		System.out.print("Enter math:");
		customerString = scan.nextLine();
		
		//преобразовуем в массив символов
		char[] customerStringChar = customerString.toCharArray();
		
		//определяем количество математических операций
		int countOfMathOperation = 0;
		for(int counter=0; counter<customerStringChar.length; counter++){
			switch (customerStringChar[counter]) {
			case '+' :
			case '-' :
			case '*' :
			case '/' :
				countOfMathOperation++;
			}
		}
		
		//Разделяем введенную строку на массив чисел 		
		String[] numbersTemp = new String[countOfMathOperation+1];
		double[] numbers = new double[countOfMathOperation+1];		
		int numberOfArrayElement = -1;
		int beginIndex = 0;
		
		for(int counter=0; counter<customerStringChar.length; counter++){
			switch (customerStringChar[counter]) {
			case '+' :				
			case '-' :				
			case '*' :				
			case '/' :
				numberOfArrayElement++;				
				numbersTemp[numberOfArrayElement] = customerString.substring(beginIndex, counter);
				numbers[numberOfArrayElement] = Double.parseDouble(numbersTemp[numberOfArrayElement]);
				beginIndex = counter + 1;
				break;
			}			
		}
		numbersTemp[countOfMathOperation] = customerString.substring(beginIndex);
		numbers[countOfMathOperation] = Double.parseDouble(numbersTemp[countOfMathOperation]);
		
		//Решаем исходное выражение без приоритета знаков
		double result = numbers[0];
		numberOfArrayElement = 0;
		
		for(int counter=0; counter<customerStringChar.length; counter++){
			switch (customerStringChar[counter]) {
			    case '+':
			    	numberOfArrayElement++;
				    result = result + numbers[numberOfArrayElement];
				    break;
			    case '-':
			    	numberOfArrayElement++;
				    result = result - numbers[numberOfArrayElement];
				    break;
			    case '*':
			    	numberOfArrayElement++;
				    result = result * numbers[numberOfArrayElement];
				    break;
			    case '/':
			    	numberOfArrayElement++;
				    result = result / numbers[numberOfArrayElement];
				    break;
			
			}
		}
		
		System.out.println("The result = " + result);
	}
}
