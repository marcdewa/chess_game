package chessEntities;

import chess_games.PiecesLocation;
import chess_games.Position;

public abstract class Pieces {
	protected char pieceName;
	protected char player;
	protected boolean hasMoved;
	
	
	public boolean isHasMoved() {
		return hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

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
		this.hasMoved = false;
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
	
	public boolean isKing(int i, int j) {
		return pieceName=='K'|| pieceName=='k';
	}
	
	public abstract boolean canMove(PiecesLocation locFrom,PiecesLocation locTo,Position[][] board);

}
