package chessEntities;

import chess_games.PiecesLocation;

public abstract class Pieces {
	protected char pieceName;
	protected char player;
	
	
	public char getPlayer() {
		return player;
	}

	public void setPlayer(char player) {
		this.player = player;
	}

	public char getPieceName() {
		return pieceName;
	}

	public void setPieceName(char pieceName) {
		this.pieceName = pieceName;
	}

	public Pieces(char piece , char player) {
		this.pieceName = piece;
		this.player = player;
		pieceColorDetermination(player);
	}
	
	public void pieceColorDetermination(char player) {
		if(player!='b') pieceName=(char) (pieceName+32);
	}
	
	public boolean fileDifferenceIsEqualsTo(int number,PiecesLocation locFrom,PiecesLocation locTo) {
		return Math.abs(locFrom.getFile() - locTo.getFile()) == number;
	}
	
	public boolean rankDifferenceIsEqualsTo(int number,PiecesLocation locFrom,PiecesLocation locTo) {
		return Math.abs(locFrom.getRank() - locTo.getRank()) == number;
	}
	
	
	
	public abstract boolean canMove(PiecesLocation locFrom,PiecesLocation locTo);

}
