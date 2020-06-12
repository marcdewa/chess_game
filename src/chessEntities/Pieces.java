package chessEntities;

import chess_games.Games;
import chess_games.MoveCoordinate;
import chess_games.PiecesLocation;
import chess_games.Board;

public abstract class Pieces {
	protected char pieceName;
	protected char player;
	protected boolean hasMoved;
	protected Board[][] board;
	
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


	public char getPieceName() {
		return pieceName;
	}

	public Pieces(char piece , char player,Board[][] board) {
		this.pieceName = piece;
		this.player = player;
		this.hasMoved = false;
		this.board = board;
		pieceColorDetermination(player);
	}
	
	private void pieceColorDetermination(char player) {
		if(player!='b') pieceName=(char) (pieceName+32);
	}

	
	protected boolean fileDifferenceIsEqualsTo(int number,MoveCoordinate movLoc) {
		return Math.abs(movLoc.getLocFromFile() - movLoc.getLocToFile()) == number;
	}
	
	protected boolean rankDifferenceIsEqualsTo(int number,MoveCoordinate movLoc) {
		return Math.abs(movLoc.getLocFromRank() - movLoc.getLocToRank()) == number;
	}
	
	public boolean isKing(int i, int j) {
		return pieceName=='K'|| pieceName=='k';
	}
	
	public boolean isPawn(int i, int j) {
		return pieceName=='P'|| pieceName=='p';
	}
	
	

}
