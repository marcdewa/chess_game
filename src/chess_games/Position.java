package chess_games;

import chessEntities.*;

public class Position {
	private Pieces piece;
	
	
	public Position(PiecesLocation loc,Pieces piece){
		if(loc.getFile()>8 || loc.getRank()>8) {
			System.out.println("index out of range");
			System.exit(0);
		}
		this.setPiece(piece);
	}

	public Pieces getPiece() {
		return piece;
	}

	public void setPiece(Pieces piece) {
		this.piece = piece;
	}

	
	
}
