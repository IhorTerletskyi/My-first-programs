
public class Lesson7 {
	
	/*���� ����� �� 3-� ���� �word1 word2 word3�.
	 *�������� 1-� � 3-� ����� ������� � ������� �� ����� ���������.
	 */
	static String replace (String primary) {
		String newString;
		StringBuilder str = new StringBuilder();
		String temp[] = primary.split(" ");
		String tempElement = temp[0];
		temp[0] = temp[temp.length-1];
		temp[temp.length-1] = tempElement;
		for (int counter = 0; counter < temp.length; counter++){
			str.append(temp[counter]);
			str.append(' ');
		}
		str.deleteCharAt(str.length()-1);
		newString = str.toString();
		System.out.println(newString);
		return newString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String customerString = "word1 word2 word3";
		replace(customerString);

	}

}
