package chessEntities;

import chess_games.Games;
import chess_games.MoveCoordinate;
import chess_games.PiecesLocation;
import chess_games.Position;

public abstract class Pieces {
	protected char pieceName;
	protected char player;
	protected boolean hasMoved;
	protected Position[][] board;
	
	public abstract boolean canMove(MoveCoordinate moveLoc);
	
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

	public Pieces(char piece , char player,Position[][] board) {
		this.pieceName = piece;
		this.player = player;
		this.hasMoved = false;
		this.board = board;
		pieceColorDetermination(player);
	}
	
	public void pieceColorDetermination(char player) {
		if(player!='b') pieceName=(char) (pieceName+32);
	}

	
	public boolean fileDifferenceIsEqualsTo(int number,MoveCoordinate movLoc) {
		return Math.abs(movLoc.getLocFromFile() - movLoc.getLocToFile()) == number;
	}
	
	public boolean rankDifferenceIsEqualsTo(int number,MoveCoordinate movLoc) {
		return Math.abs(movLoc.getLocFromRank() - movLoc.getLocToRank()) == number;
	}
	
	public boolean isKing(int i, int j) {
		return pieceName=='K'|| pieceName=='k';
	}
	
	

}
