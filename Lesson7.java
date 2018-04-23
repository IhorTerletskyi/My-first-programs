
public class Lesson7 {
	
	/*Дано текст из 3-х слов "word1 word2 word3".
	 *поменять 1-е и 3-е слова местами и вывести результат на экран.
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
	
	/*Дано текст и определенное слово.
	 * Посчитать сколько раз заданное слово встречается в тексте.
	 */
	static int wordTimes(String text, String word){
		int timesValue = 0;
		int position = 0;		
		do{
			position = text.indexOf(word, position);
			if (position >= 0) {
				timesValue++;
				position += word.length();
			}
		}while(position>=0);
		System.out.printf("Word %s repeat %d times", word, timesValue);
		System.out.println();
		return timesValue;		
	}
	
	/*Дано 3 массива чисел.
	 *С помощью 1-2-х циклов найти сумму элементов во всех массивах.
	 *
	 *По моему мнению наименее ресурсоемкий и времязатратный метод посчитать все суммы тремя циклами,
	 *но задача состоит в том, чтобы впихнуть это все в один цикл.
	 */
	static int summOfThreeArrays (int array1[], int array2[], int array3[]) {
		int summ = 0;
		int counter = -1;
		int maxLength = array1.length;
		if (maxLength < array2.length) {
			maxLength = array2.length;
		}
		if (maxLength < array3.length) {
			maxLength = array3.length;
		}
		do {
			counter++;
			if (counter<array1.length) {
				summ += array1[counter];
			}
			if (counter<array2.length) {
				summ += array2[counter];
			}
			if (counter<array3.length) {
				summ += array3[counter];
			}
		}while(counter<maxLength);
		System.out.printf("Summ of three arrays = %d", summ);
		System.out.println();
		return summ;
	}
	
	/*Дано текст. Убрать лишние пробелы, расставить знаки препинания.
	 *Пример: «Я    длинное   предложение  Я     второе   предложение.»
	 *-> «Я длинное предложение. Я второе предложение.»
	 */
	static String spaceDeleterDotInputer (String text) {
		String newText;
		StringBuilder str = new StringBuilder(text.length());
		str.append(text.charAt(0));
		boolean isPreviosNoSpase = true;
		for(int counter = 1; counter < text.length(); counter++){
			if(text.charAt(counter) != ' ') {
				if(Character.isUpperCase(text.charAt(counter))){
					str.deleteCharAt(str.length() - 1);
					str.append(". ");
					str.append(text.charAt(counter));
					isPreviosNoSpase = true;
				}else{
					str.append(text.charAt(counter));
					isPreviosNoSpase = true;
				}
			}
			if (text.charAt(counter) == ' ') {
				if (isPreviosNoSpase) {
					str.append(' ');
					isPreviosNoSpase = false;
				}
			}
		}
		str.append('.');
		newText = str.toString();
		System.out.println(newText);
		return newText;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String customerString = "word1 word2 word3";
		replace(customerString);
		
		String text = "hello lalala! hello lolollo! hello!";
		String word = "lo";
		wordTimes(text,word);
		
		int array1[] = new int[] {1, 2, 5, 3, 4};
		int array2[] = new int[] {5, 5, 10};
		int array3[] = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		summOfThreeArrays(array1,array2,array3);
		
		String wrongText = "Something   wrong      whith    me      Please   fix     it";
		spaceDeleterDotInputer(wrongText);		

	}

}
