public class game {

	public static void main(String[] args) {
		
	    int whoNext = 1, round = 0, remainder = 9;
	    TicTacToe map = new TicTacToe();

	    map.printGrid();

	    for (;;) {
	        switch (whoNext) {
	            case 1:
	                map.playerOne();
	                ++round;
	                whoNext = 2;
	                break;
	            case 2:
	                map.playerTwo();
	                whoNext = 1;
	                break;
	        }
	        --remainder;
	        map.printGrid();

	        if (round >= 3)
	            map.printWinner(map.judge(), remainder);
	    }
	}

}
