package chess_games;

import chessEntities.*;

public class Position {
	private PiecesLocation loc;
	private Pieces piece;
	
	
	public Position(PiecesLocation loc,Pieces piece) {
		this.setPiece(piece);
		this.loc = loc;
	}


	public PiecesLocation getLoc() {
		return loc;
	}

	public void setLoc(PiecesLocation loc) {
		this.loc = loc;
	}

	public Pieces getPiece() {
		return piece;
	}

	public void setPiece(Pieces piece) {
		this.piece = piece;
	}

	
	
}
