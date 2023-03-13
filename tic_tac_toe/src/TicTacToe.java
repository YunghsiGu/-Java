import java.util.Scanner;

public class TicTacToe {
	
	enum Value {
		X(),
		O(),
		EMPTY();
	}
	private Value[][] grid = new Value[3][3];
	
	public TicTacToe() {
		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 3; ++j)
				grid[i][j] = Value.EMPTY;
	}
	/****************************************************************
	 * print_grid:  Print the grid.                                 *
	 * **************************************************************/
	public void printGrid() {
	    System.out.print("Player-1==> ");
	    System.out.println("X");
	    System.out.print("Player-2==> ");
	    System.out.println("O\n");
	    for (int i = 0; i < 3; ++i) {
	        for (int j = 0; j < 3; ++j) {
	            if (grid[i][j] == Value.X)
	            	System.out.printf("X");
	            else if (grid[i][j] == Value.O)
	            	System.out.printf("O");
	            else
	            	System.out.printf("%d", i * 3 + j + 1);

	            if (j == 2) {
	            	System.out.println("");
	                break;
	            } else           
	            	System.out.printf(" | ");
	        }

	        if (i == 2) {
	        	System.out.printf("\n\n");
	            break;
	        } else
	        	System.out.println("__  __  __");
	    }
	}
//	/****************************************************************
//	 * player_one:  Read the input and determine whether it is      *
//	 *              legal. If legal, change the storing character   *
//	 *              of the corresponding one in the grid into X.    *
//	 *              Then, clear the screen. If illegal, ask the     *
//	 *              user to input again.                            *
//	 * **************************************************************/
	public void playerOne() {
		Scanner scan = new Scanner(System.in);
	    int input;
	    for (;;) {
	        System.out.print("player 1 -> "); 
	        input = scan.nextByte();
	        int i = (input - 1) / 3;
	        int j = (input - 1) % 3;

	        if (1 <= input && input <= 9 && grid[i][j] == Value.EMPTY) {
	            grid[i][j] = Value.X;           
	            System.out.println("");
	            return;
	        } else {
	        	System.out.println("");
	        	System.out.println("I know that you just accidently draw in the wrong place, right? :)");
	        }
	    }
	}

	void playerTwo() {
		Scanner scan = new Scanner(System.in);
	    int input;
	    for (;;) {
	        System.out.print("player 2 -> "); 
	        input = scan.nextByte();
	        int i = (input - 1) / 3;
	        int j = (input - 1) % 3;

	        if (1 <= input && input <= 9 && grid[i][j] == Value.EMPTY) {
	            grid[i][j] = Value.O;           
	            System.out.println("");
	            return;
	        } else {
	        	System.out.println("");
	        	System.out.println("I know that you just accidently draw in the wrong place, right? :)");
	        }
	    }
	}
	/****************************************************************
	 * judge:   Determine whether any player won by row, column,    *
	 *          and diagonal. If player-1 won, return 1. If         *
	 *          player-2 won, return 2. If no one won, return 0.    *
	 * **************************************************************/
	public int judge() {
	    for (int i = 0, j = 0; i < 3; ++i)
	        if (grid[i][j] == grid[i][j + 1] && grid[i][j] == grid[i][j + 2])
	        	if (grid[i][j] == Value.X)
	        		return 1;
	        	else if (grid[i][j] == Value.O)
	        		return 2;
	    for (int i = 0, j = 0; j < 3; ++j)
	        if (grid[i][j] == grid[i + 1][j] && grid[i + 1][j] == grid[i + 2][j])
	        	if (grid[i][j] == Value.X)
	        		return 1;
	        	else if (grid[i][j] == Value.O)
	        		return 2;
	    if ((grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2]) || 
	        (grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0])) {
	        if (grid[1][1] == Value.X)
	        	return 1;
	        else if (grid[1][1] == Value.O)
	        	return 2;
	    }
	    return 0;
	}
	/****************************************************************
	 * print_winner:    Print the result of the game.               *
	 * **************************************************************/
	public void printWinner(int judge, int remainder) {
	    switch (judge) {
	        case 0:
	            if (remainder == 0) {
	                System.out.println("player-1 and player-2 are tying.");
	                System.exit(0);
	            } else
	                return;
	        case 1:
	            System.out.println("player-1 wins");
	            System.exit(0);
	        case 2:
	            System.out.println("player-2 wins");
	            System.exit(0);
	    }
	}
}