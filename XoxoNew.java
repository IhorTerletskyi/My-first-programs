import java.util.Scanner;

public class XoxoNew {
	
	//метод выбора режима игры
	static byte gameModeSelect(){
		byte gameMode = 0;
		boolean noOk = true;
		Scanner scan = new Scanner(System.in);
			
		while(noOk){
			System.out.println("1. 1 player. You are X.");
	        System.out.println("2. 1 player. You are 0.");
	        System.out.println("3. 2 players mode.");
	        System.out.print("Select game mode:");
	        gameMode = scan.nextByte();
	        if((gameMode<1) || (gameMode>3)){
	        	System.out.println("Wrong game mode. Must be 1 or 2 or 3.");
	        }else{
	        	noOk = false;
	        }
		}
		return gameMode;        
	}
	
	static void showGameField(char[] gameValue) {
		//Выводим первую строку игрового поля
		System.out.print(" 0 | 1 | 2     " + gameValue[0]);
		System.out.print(" | " + gameValue[1]);
		System.out.println(" | " + gameValue[2]);
		System.out.println("---+---+---   ---+---+---");
		//Выводим вторую строку игрового поля
		System.out.print(" 3 | 4 | 5     " + gameValue[3]);
		System.out.print(" | " + gameValue[4]);
		System.out.println(" | " + gameValue[5]);
		System.out.println("---+---+---   ---+---+---");
		//Выводим третью строку игрового поля
		System.out.print(" 6 | 7 | 8     " + gameValue[6]);
		System.out.print(" | " + gameValue[7]);
		System.out.println(" | " + gameValue[8]);		
	}
	
	/*метод, который узнает номер клеточки, в которую игрок-человек делает свой ход
	 * Для этого нам надо массив с уже сделанными ходами,
	 * массив поочередности хода для отображения текущего игрока
	 * и номер хода
	 */
	static byte humanPlayerCoordinate(byte[] noPosibleTurns, char[] xOr0, byte turn) {
		byte coordinate = -1;
		boolean coordinateWrong = true;		
		Scanner scan = new Scanner(System.in);
		System.out.println("Player " + xOr0[turn] + " turn");
		/*Вводим координату клеточки до тех пор, пока она не будет иметь значение
		 * пустой клеточки игрового поля
		 */		
		while(coordinateWrong) {
			System.out.print("Enter cell number:");
			coordinate = scan.nextByte();
			if(coordinate<0 || coordinate>8){
				System.out.println("Wrong coordinate. Must be from 0 to 8.");
				continue;
			}
			if(noPosibleTurns[coordinate]!=0){
				System.out.println("Wrong coordinate. This cell no free, please enter another square number.");
				continue;
			}
			coordinateWrong = false;
		}
		return coordinate;		
	}
	
	/*метод, который узнает номер клеточки, в которую игрок-компьютер делает свой ход
	 * Для этого нам надо массив с уже сделанными ходами,
	 * массив поочередности хода для отображения текущего игрока
	 * и номер хода
	 */	
	static byte computerPlayer(byte[] madeTurns, char[] xOr0, byte turn) {
		byte coordinate = -1;
		byte[] controlSumm = controlSummCounter(madeTurns);	
		
		//Логика ИИ взависимости от текущего хода
		switch(turn) {
		//Если ИИ крестик, то первый ход его и крестик ставим по центру
		case 0:
			coordinate = 4;
			break;
		/*Если ИИ нолик, то первый нолик ставится в центр,
		 * если центральная клеточка занята, то в клеточку номер 0
		 */
		case 1:
			if(madeTurns[4] == 0) {
				coordinate = 4;
			}else{
				coordinate = 0;
			}
			break;
		/*Если нолик стоит в клеточках 0, 2 или 6 -- крестик ставим напротив по диагонали
		 * В остальных случаях в клеточке 0
		 */
		case 2:
			coordinate = 0;
			if(madeTurns[0] == 3){
				coordinate = 8;
			}
			if(madeTurns[2] == 3){
				coordinate = 6;
			}
			if(madeTurns[6] == 3){
				coordinate = 2;
			}
			break;
		/*Обороняемся от победы крестиков
		 * Если победа кресиков не грозит, ставим нолик в свободную угловую ячейку
		 */
		case 3:
			for(byte controlSummIndex=0;controlSummIndex<8;controlSummIndex++){
				if(controlSumm[controlSummIndex] == 20){
					coordinate = freeCellFinder(madeTurns, controlSummIndex);
				}
				if(coordinate == -1) {
					if(madeTurns[0] == 0){
						coordinate = 0;
					}
					if(madeTurns[2] == 0){
						coordinate = 2;
					}
					if(madeTurns[6] == 3){
						coordinate = 6;
					}
				}
			}
			break;
		/*Дальше логика такая:
		 * - Проверяем возможную победу противника и мешаем ему
		 * - На всякий случай проверяем возможность выиграть, и если она есть, выигрываем
		 * Если нет возможности помешать или выиграть ходим в любую ячейку
		 */
		case 4:
		case 6:		
			for(byte controlSummIndex=0;controlSummIndex<8;controlSummIndex++){
				if(controlSumm[controlSummIndex] == 6){
					coordinate = freeCellFinder(madeTurns, controlSummIndex);
				}
				if(controlSumm[controlSummIndex] == 20){
					coordinate = freeCellFinder(madeTurns, controlSummIndex);
				}
			}
			if(coordinate == -1) {
				for(byte cellNumber = 0; cellNumber<9; cellNumber++){
					if(madeTurns[cellNumber] == 0){
						coordinate = cellNumber;						
					}
				}
			}
			break;
		case 5:
		case 7:
			for(byte controlSummIndex=0;controlSummIndex<8;controlSummIndex++){
				if(controlSumm[controlSummIndex] == 20){
					coordinate = freeCellFinder(madeTurns, controlSummIndex);
				}
				if(controlSumm[controlSummIndex] == 6){
					coordinate = freeCellFinder(madeTurns, controlSummIndex);
				}				
			}
			if(coordinate == -1) {
				for(byte cellNumber = 0; cellNumber<9; cellNumber++){
					if(madeTurns[cellNumber] == 0){
						coordinate = cellNumber;
					}
				}
			}
			break;
		//Занимаем оставшуюсь ячейку
		case 8:
			for(byte cellNumber = 0; cellNumber<9; cellNumber++){
				if(madeTurns[cellNumber] == 0){
					coordinate = cellNumber;
				}
			}
			break;
		}
		return coordinate;
	}
	
	//метод просчета контрольных сумм победы
	static byte[] controlSummCounter(byte[] currentGameField) {
		byte[] controlSumm = {0,0,0,0,0,0,0,0}; //массив контрольных сумм
		//Высчитываем контрольные суммы победы
    	controlSumm[0] = (byte) (currentGameField[0] + currentGameField[1] + currentGameField[2]);
    	controlSumm[1] = (byte) (currentGameField[3] + currentGameField[4] + currentGameField[5]);
    	controlSumm[2] = (byte) (currentGameField[6] + currentGameField[7] + currentGameField[8]);
    	controlSumm[3] = (byte) (currentGameField[0] + currentGameField[3] + currentGameField[6]);
    	controlSumm[4] = (byte) (currentGameField[1] + currentGameField[4] + currentGameField[7]);
    	controlSumm[5] = (byte) (currentGameField[2] + currentGameField[5] + currentGameField[8]);
    	controlSumm[6] = (byte) (currentGameField[0] + currentGameField[4] + currentGameField[8]);
    	controlSumm[7] = (byte) (currentGameField[2] + currentGameField[4] + currentGameField[6]);
    	return controlSumm;
	}
	
	//метод поиска свободной ячейки в одной из 8ми выиграшных комбинаций
	static byte freeCellFinder (byte[] madeTurns, byte controlSummNumber) {
		byte freeCell = 0;
		switch(controlSummNumber){
		    case 0:
		    	for(byte cellNumber=0; cellNumber<3; cellNumber++){
		    		if(madeTurns[cellNumber] == 0){
			    		freeCell = cellNumber;
			    	}
		    	}
		    	break;
		    case 1:
		    	for(byte cellNumber=3; cellNumber<6; cellNumber++){
		    		if(madeTurns[cellNumber] == 0){
			    		freeCell = cellNumber;
			    	}
		    	}
		    	break;
		    case 2:
		    	for(byte cellNumber=6; cellNumber<9; cellNumber++){
		    		if(madeTurns[cellNumber] == 0){
			    		freeCell = cellNumber;
			    	}
		    	}
		    	break;
		    case 3:
		    	for(byte cellNumber=0; cellNumber<9; cellNumber = (byte)(cellNumber+3)){
		    		if(madeTurns[cellNumber] == 0){
			    		freeCell = cellNumber;
			    	}
		    	}
		    	break;
		    case 4:
		    	for(byte cellNumber=1; cellNumber<9; cellNumber = (byte)(cellNumber+3)){
		    		if(madeTurns[cellNumber] == 0){
			    		freeCell = cellNumber;
			    	}
		    	}
		    	break;
		    case 5:
		    	for(byte cellNumber=2; cellNumber<9; cellNumber = (byte)(cellNumber+3)){
		    		if(madeTurns[cellNumber] == 0){
			    		freeCell = cellNumber;
			    	}
		    	}
		    	break;
		    case 6:
		    	for(byte cellNumber=0; cellNumber<9; cellNumber = (byte)(cellNumber+4)){
		    		if(madeTurns[cellNumber] == 0){
			    		freeCell = cellNumber;
			    	}
		    	}
		    	break;
		    case 7:
		    	for(byte cellNumber=2; cellNumber<7; cellNumber = (byte)(cellNumber+2)){
		    		if(madeTurns[cellNumber] == 0){
			    		freeCell = cellNumber;
			    	}
		    	}
		    	break;
		}
		return freeCell;
	}
	
	//проверяем есть ли победа или нет
	static boolean isNoVictory(byte[] controlSumm) {
		boolean noVictory = true;
		//Проверяем наличие победы
    	for(int counter=0; counter<8; counter++){
    		switch(controlSumm[counter]) {
    		case 9:
    			System.out.println("Second player 0 win!!!");
    			noVictory = false;
    			break;
    		case 30:
    			System.out.println("First player X win!!!");
    			noVictory = false;
    			break;
    		}
    	}
    	return noVictory;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		char[] turnSequence = {'X','0','X','0','X','0','X','0','X'}; //массив поочередности хода
        byte[] turnSequenceValue = {10,3,10,3,10,3,10,3,10}; //массив поочередности хода в числовом эквиваленте
        char[] turnMade = {' ',' ',' ',' ',' ',' ',' ',' ',' '}; //массив сделанных ходов
        byte[] turnMadeValue = {0,0,0,0,0,0,0,0,0}; //массив сделанных ходов в числовом эквиваленте
        byte[] controlSumm = {0,0,0,0,0,0,0,0}; //массив контрольных сумм
        byte currentTurnValue = -1; //номер клеточки куда делается текущий ход
        boolean gameContinue = true; //необходимость продолжения игры
        boolean computerFirstPlayer = false; //первенство хода компьютера
        byte gameMode; //вариант игры
        byte turn = -1; //номер текущего хода
        
        gameMode = gameModeSelect();
        if(gameMode == 2){
        	computerFirstPlayer = true;
        }
        
      //запускаем игру
        while (gameContinue) {
        	turn++;
        	showGameField(turnMade);
        	
        	switch(gameMode){
        	    case 1:
        	    case 2:
        	    	if(computerFirstPlayer){
        	    		currentTurnValue = computerPlayer(turnMadeValue, turnSequence, turn);
        	    		computerFirstPlayer = !computerFirstPlayer;
        	    	}else{
        	    		currentTurnValue = humanPlayerCoordinate(turnMadeValue, turnSequence, turn);
        	    		computerFirstPlayer = !computerFirstPlayer;
        	    	}
        	    	break;
        	    case 3:
        	    	currentTurnValue = humanPlayerCoordinate(turnMadeValue, turnSequence, turn);
        	    	break;
        	}
        	//
        	
        	
        	turnMade[currentTurnValue] = turnSequence[turn];
        	turnMadeValue[currentTurnValue] = turnSequenceValue[turn];
        	
        	controlSumm = controlSummCounter(turnMadeValue);
        	gameContinue = isNoVictory(controlSumm);
        	
        	/*Проверяем наличие ничьей
        	 * ничья происходит если это последний ход и нет победы
        	 * т.е. при значениях: 
        	 * turn == 8
        	 * gameContinue == true
        	 */
        	if((turn == 8)&&(gameContinue)){
        		showGameField(turnMade);
        		System.out.println("Nobody win...");
        		gameContinue = false;
        	}
        }

	}

}
