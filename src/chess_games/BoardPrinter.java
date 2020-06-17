package chess_games;

public class BoardPrinter {
	private Board[][] board;
	
	public BoardPrinter(Board[][] board) {
		this.board = board;
	}

	public void print() {
		
		for(int i = 8 ; i > 0 ; i--) {
		
			for(int j = 1 ; j < 9 ; j++) {
				
				if(!isBoardNull(i, j)) {
				System.out.print(" "+board[i][j].getPiece().getPieceName()+" ");
				}else plusOrMinusSymbol(i, j);
				
			}
			System.out.println(" "+(i)+" ");
		}
		System.out.println(" A  B  C  D  E  F  G  H");
	}

	private boolean isBoardNull(int i, int j) {
		return board[i][j] == null;
	}
	

	private void plusOrMinusSymbol(int i, int j) {
		if(isEven(i)) {
			
			if(isEven(j))System.out.print(" + ");
			else System.out.print(" - ");
			
		}
		else {
			
			if(isEven(j)) System.out.print(" - ");
			else System.out.print(" + ");
			
		}
	}

	private boolean isEven(int i) {
		return i%2==0;
	}
	
	public void clear() {
		for(int i = 0; i < 26; i++) System.out.println("");
	}
}
