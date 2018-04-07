import java.util.Scanner;
import java.util.Arrays;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		//���� ������������� ��������������� ���������
		String customerString;
		System.out.print("Enter math:");
		customerString = scan.nextLine();
		
		//������������� ������ � ������ ��������
		char[] customerStringChar = customerString.toCharArray();
		
		//���� ���������� �������������� ��������
		int countOfMathOperation = 0;
		for(int i=0; i<customerStringChar.length; i++){
			if(customerStringChar[i] == '+'){
				countOfMathOperation++;
			}
			if(customerStringChar[i] == '-'){
				countOfMathOperation++;
			}
			if(customerStringChar[i] == '*'){
				countOfMathOperation++;
			}
			if(customerStringChar[i] == '/'){
				countOfMathOperation++;
			}
		}
		
		//�������� ������ ����� � ������ �������������� ��������
		String[] numbersTemp = new String[countOfMathOperation+1];
		char[] operators = new char[countOfMathOperation];
		int[] operatorsIndex = new int[countOfMathOperation];
		int numberOfArrayElement = -1;
		int beginIndex = 0;
		
		for(int i=0; i<customerStringChar.length; i++){
			if(customerStringChar[i] == '+'){
				numberOfArrayElement++;
				operators[numberOfArrayElement] = '+';
				operatorsIndex[numberOfArrayElement] = i;
				numbersTemp[numberOfArrayElement] = customerString.substring(beginIndex, i);
				beginIndex = i + 1;
			}
			if(customerStringChar[i] == '-'){
				numberOfArrayElement++;
				operators[numberOfArrayElement] = '-';
				operatorsIndex[numberOfArrayElement] = i;
				numbersTemp[numberOfArrayElement] = customerString.substring(beginIndex, i);
				beginIndex = i + 1;
			}
			if(customerStringChar[i] == '*'){
				numberOfArrayElement++;
				operators[numberOfArrayElement] = '*';
				operatorsIndex[numberOfArrayElement] = i;
				numbersTemp[numberOfArrayElement] = customerString.substring(beginIndex, i);
				beginIndex = i + 1;
			}
			if(customerStringChar[i] == '/'){
				numberOfArrayElement++;
				operators[numberOfArrayElement] = '/';
				operatorsIndex[numberOfArrayElement] = i;
				numbersTemp[numberOfArrayElement] = customerString.substring(beginIndex, i);
				beginIndex = i + 1;
			}
		}
		numbersTemp[countOfMathOperation] = customerString.substring(beginIndex);
		
		//������� �������� ������ �����
		double[] numbers = new double[countOfMathOperation+1];
		for(int i=0; i<=countOfMathOperation; i++){
			numbers[i] = Double.parseDouble(numbersTemp[i]);
		}
		
		//��������� ��������� ��� ���������� ��������
		double result = numbers[0];
		for(int i=0; i<operators.length; i++){
			if(operators[i] == '+'){
				result = result + numbers[i+1];
			}
			if(operators[i] == '-'){
				result = result - numbers[i+1];
			}
			if(operators[i] == '*'){
				result = result * numbers[i+1];
			}
			if(operators[i] == '/'){
				result = result / numbers[i+1];
			}
		}
		
		System.out.println("The result = " + result);


	}
	

}
