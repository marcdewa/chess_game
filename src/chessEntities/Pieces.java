package chessEntities;


import chess_games.MoveCoordinate;
import chess_games.Board;
import chess_games.Player;

public abstract class Pieces {
	
	protected char pieceName;
	protected Player player;
	protected boolean hasMoved;
	protected Board[][] board;//Board[][] for offset check
	
	public abstract boolean canMove(MoveCoordinate moveLoc,boolean execute);
	
	public Pieces(char piece , char player,Board[][] board) {
		this.player = new Player(player);
		this.pieceName = (char) (piece + this.player.isBlackOrWhite());
		this.hasMoved = false;
		this.board = board;
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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public boolean isHasMoved() {
		return hasMoved;
	}

	public void setHasMoved(boolean execute,boolean hasMoved) {
		boolean temp = this.hasMoved;
		this.hasMoved = hasMoved;
		if(!execute) this.hasMoved=temp;
	}

	public char getPieceName() {
		return pieceName;
	}
	
	

}
