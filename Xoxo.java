import java.util.Scanner;
public class Xoxo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        char[] turnSequence = {'X','0','X','0','X','0','X','0','X'}; //массив поочередности хода
        byte[] turnSequenceValue = {10,3,10,3,10,3,10,3,10}; //массив поочередности хода в числовом эквиваленте
        char[][] turnMade = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}}; //массив сделанных ходов
        byte[][] turnMadeValue = {{0,0,0},{0,0,0},{0,0,0}}; //массив сделанных ходов в числовом эквиваленте
        byte[] controlSumm = {0,0,0,0,0,0,0,0}; //массив контрольных сумм
        byte gorizontalValue;
        byte verticalValue;
        boolean gameContinue = true; //необходимость продолжения игры
        byte turn = -1; //номер текущего хода
        
        //запускаем игру
        while (gameContinue){
        	turn++;
        	
        	//выводим на экран в красивой форме игровое поле
        	System.out.flush();
        	System.out.println("    0   1   2");
        	System.out.print(" 0  " + turnMade[0][0]);
        	System.out.print(" | " + turnMade[0][1]);
        	System.out.println(" | " + turnMade[0][2]);
        	System.out.println("   ---+---+---");
        	System.out.print(" 1  " + turnMade[1][0]);
        	System.out.print(" | " + turnMade[1][1]);
        	System.out.println(" | " + turnMade[1][2]);
        	System.out.println("   ---+---+---");
        	System.out.print(" 2  " + turnMade[2][0]);
        	System.out.print(" | " + turnMade[2][1]);
        	System.out.println(" | " + turnMade[2][2]);
        	System.out.println();
        	
        	//Вводим координаты клеточки, куда ставим крестик или нолик
        	System.out.println("Player " + turnSequence[turn] + " turn!");
        	System.out.print("Enter gorizontal coordinate:");
        	gorizontalValue = scan.nextByte();
        	System.out.print("Enter vertical coordinate:");
        	verticalValue = scan.nextByte();
        	
        	turnMade[gorizontalValue][verticalValue] = turnSequence[turn];
        	turnMadeValue[gorizontalValue][verticalValue] = turnSequenceValue[turn];
        	
        	//Высчитываем контрольные суммы победы
        	controlSumm[0] = (byte) (turnMadeValue[0][0] + turnMadeValue[0][1] + turnMadeValue[0][2]);
        	controlSumm[1] = (byte) (turnMadeValue[1][0] + turnMadeValue[1][1] + turnMadeValue[1][2]);
        	controlSumm[2] = (byte) (turnMadeValue[2][0] + turnMadeValue[2][1] + turnMadeValue[2][2]);
        	controlSumm[3] = (byte) (turnMadeValue[0][0] + turnMadeValue[1][0] + turnMadeValue[2][0]);
        	controlSumm[4] = (byte) (turnMadeValue[0][1] + turnMadeValue[1][1] + turnMadeValue[2][1]);
        	controlSumm[5] = (byte) (turnMadeValue[0][2] + turnMadeValue[1][2] + turnMadeValue[2][2]);
        	controlSumm[6] = (byte) (turnMadeValue[0][0] + turnMadeValue[1][1] + turnMadeValue[2][2]);
        	controlSumm[7] = (byte) (turnMadeValue[2][0] + turnMadeValue[1][1] + turnMadeValue[0][2]);
        	
        	//Проверяем наличие победы или ничьей
        	for(int counter=0; counter<8; counter++){
        		switch(controlSumm[counter]) {
        		case 9:
        			System.out.println("Second player win!!!");
        			gameContinue = false;
        			break;
        		case 30:
        			System.out.println("First player win!!!");
        			gameContinue = false;
        			break;
        		}        		
        	}
        	if(turn == 8){
        		System.out.println("Nobody win...");
        		gameContinue = false;
        	}
        }
	}

}
