import java.util.Arrays;

public class Lesson5 {
	
	/*�������� �������, ������� ��������� � �������� ���������� 
	 * ���� ������ X, ����� ����� Y � ����� � ��������� ������ Z
	 * � ���������� ��� ��������� ������ � ����
	 * S = x + y + z.
	 * ������������� ���������� ��������� ������ ��� ��� ������� � ���������� ������
	 */
	static String newString(String x, int y, double z) {
		String tripleString = x + y + z;
		return tripleString;
	}
	
	/*�������� �������, ������� ��������� ������ ����� � �������� ���������,
	 * ����������� ��� ������ 3 �������� �� 1 � ���������� �� ����� ��� ���������.
	 * ����� ��������� ������ � ����� ���� ������� �� �����.
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
	
	/*�������� �-�, ������� ��������� �� ���� ������ ����� � ���������� ��� ����� � ������ ��� ���������
	 * 
	 * ������ �� ���� ��� ���������� ���� int ��� 4 �����, �� ���������� ����
	 * ��� ���������� ��������� ������� ����������� � 4 ����
	 */
	static int byteQuantity(int[] massiv){
		int quantity = massiv.length * 4;
		return quantity;
	}
	
	//�������� �-� ��� ����������� 2-� �������� � ����. ������� ��������� �� �������	 
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
		
		/*��� ������ �������� �� ������� ������������ ����� ��������,
		 * �� ����� �� ������������� � ������ ��������� �������� � �� ����� ����������
		 * 
		 * ������������� ���������� ��������� ������ �� ������� �������
		 */
		String x = "My number ";
		int y = 359;
		double z = 2.5;
		int[] firstArray = new int[]{10, 20, 50, 25, 20};
		int[] secondArray = new int[]{60, 70, 32, 8};
		
		String s = newString(x,y,z);
		System.out.println(s);
		
		int summOfFirstArrayPlusThree = summPlusThree(firstArray);
		//��� ��� ������� ����� ���������
		System.out.println("summ of first array =" + summOfFirstArrayPlusThree);
		
		int byteQuantityInFirstArray = byteQuantity(firstArray);
		System.out.println("byte quantity of first array =" + byteQuantityInFirstArray);
		
		int[] twoArrays = twoInOneArray(firstArray,secondArray);
		String twoArraysString = Arrays.toString(twoArrays);
		System.out.println(twoArraysString);

	}

}
