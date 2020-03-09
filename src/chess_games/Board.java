package chess_games;

public class Board {
	private int[][] board ; 
	
	

	public Board() {
		board = new int [10][10];
	}

	public void print() {
		for(int i = 8 ; i > 0 ; i--) {
			
			for(int j = 1 ; j < 9 ; j++) {
				System.out.print(" "+i+"-"+j+" ");
			}
			System.out.println(" "+(i)+" ");
		}
		System.out.println(" A  B  C  D  E  F  G  H");
	}
}
