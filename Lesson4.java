import java.util.Scanner;
import java.util.Arrays;

public class Lesson4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //������� 1. ������� �� ����� ����� �� 10 �� 20 � ������� ���� ��������� ������.
		
		//���� while
		byte chislo = 10;
		while(chislo<=20){
			System.out.print(chislo + ",");
			chislo++;
		}
		System.out.println(" ");
		
		//���� do-while
		chislo = 10;
		do{
			System.out.print(chislo + ",");
			chislo++;
		}while(chislo<=20);
		System.out.println(" ");
		
		//���� for
		for(chislo=10;chislo<=20;chislo++){
			System.out.print(chislo + ",");
		}
		System.out.println(" ");
		
		//���� for-each
		byte[] array1020 = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		for(byte array1020Element:array1020){
			System.out.print(array1020Element + ",");
		}
		System.out.println(" ");
		
		//������� 2. ������� �� ����� ��� ����� �� 1 �� 100, ������� ������� �� 3 ��� �������.
		byte hundred = 1;
		while(hundred<101){
			if(hundred % 3 == 0){
				System.out.print(hundred + ",");
			}
			hundred++;
		}
		System.out.println(" ");
		
		//������� 3. ��������� ������ ������� �� 100 �� 0.
		byte[] array100 = new byte[101];
		for(byte i=0; i<101; i++){
			array100[i] = i;
		}
		
		/*������� 4. ���� ������ �� 10 ����� �����. 
		 * ������� �� ����� ����� ���� ��� ��������� ����� ������� � ����������.
		 * � ��������� ������ array1020 �� 1�� ������� (�� �� 11 ���������)
		 */
		int summArray = 0;
		for(byte i=1; i<10; i++){
			summArray = summArray + array1020[i];
		}
		System.out.println(summArray);
		
		/*������� 6 � 7. ����� � ������� ����� �������� � ���������� � ���������� ����������.
		 * ����� � ������� �����, ������� ����������� ���������� ���������� ���. 
		 * �� ������������ ���������.
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
		
		/*������� 9. �������� ����� ��� ����������� ���������� 
		 * ��������� � ������� ([1, 2, 3, 4] -> [4, 3, 2, 1]).
		 * ���������� ������ arrayTask67 �� ������� 6 � 7.
		 */
		byte temp;
			for(byte i=0; i<arrayTask67.length/2; i++){
			temp = arrayTask67[i];
			arrayTask67[i] = arrayTask67[(arrayTask67.length - 1) - i];
			arrayTask67[(arrayTask67.length - 1) - i] = temp;
		}
		System.out.println(Arrays.toString(arrayTask67));
		
		/*������� 10. �������� �����, ������� �������� ������ ������������� ������� 
		 * ������� �� �����������, ������� � ������ �������, 
		 * ��������, [5,4,3,2,1,0,1,2,3,4,5].
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
