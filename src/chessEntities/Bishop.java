package chessEntities;

import chess_games.PiecesLocation;

public class Bishop extends Pieces {
	
	public Bishop(char player) {
		super('B', player);
	}
	
	@Override
	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo) {
		return false;
		
	}
	
}