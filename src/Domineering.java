import java.util.Scanner;

public class Domineering {
	/**
	 * Main method, begin game.
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println("Welcome to Domineering.");
		Domineering game = new Domineering();
		game.play();
	}
	
	//Input
	public static final Scanner INPUT = new Scanner(System.in);
	
	//Horizontal player
	public static final boolean HORIZONTAL = false;
	
	//Vertical player
	public static final boolean VERTICAL = true;
	
	//Game board
	private boolean[][] squares;
	
	/**
	 * Creates a new Domineering game.
	 */
	public Domineering() {
		squares = new boolean[8][8];
		
	}
	
	/**
	 * Play the game
	 */
	public void play(){
		boolean player = HORIZONTAL;
		
		while(true){
			System.out.println("\n " + this);
			
			if(player == HORIZONTAL){
				System.out.println("Horizontal to play: ");
			} else { 
				System.out.println("Vertical to play: ");
			}
			
			if(!hasLegalMoveFor(player)){
				System.out.println("No legal moves -- you lose!");
				return;
			}

			System.out.print("Row: ");
			int row = INPUT.nextInt();
			System.out.print("Column: ");
			int col = INPUT.nextInt();
			playAt(row, col, player);
			player = !player;
		}
	}
	
	/**
	 * Play for the player at the specified location.
	 * @param row
	 * @param column
	 * @param player
	 */
	public void playAt(int row, int column, boolean player){
		squares[row][column] = true;
		if(player == HORIZONTAL){
			squares[row][column + 1] = true;
		} else {
			squares[row + 1][column] = true;
		}
	}
	
	/**
	 * Determines whether the specified player has a legal move available.
	 * @param player
	 * @return
	 */
	public boolean hasLegalMoveFor(boolean player){
		int rowOffset = 0;
		int columnOffset = 0;
		
		if(player == HORIZONTAL){
			columnOffset = 1;
		} else {
			rowOffset = 1;
		}
		
		for(int row = 0; row < (8 - rowOffset); row++) {
			for(int column = 0; column < (8 - columnOffset); column++){
				if(!squares[row][column] && !squares[row + rowOffset][column + columnOffset]){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Returns a string representation of the game board.
	 */
	public String toString(){
		String result = "  0 1 2 3 4 5 6 7";
		for(int row = 0; row < 8; row ++){
			result += "\n " + row;
			for(int col = 0; col < 8; col ++){
				if(squares[row][col]){
					result += " #";
				}
				else{
					result += " .";
				}
			}
		}
		return result;
	}
}
