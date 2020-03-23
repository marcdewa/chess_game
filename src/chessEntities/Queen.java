package chessEntities;

import chess_games.PiecesLocation;

public class Queen extends Pieces {
	
	public Queen(char player) {
		super('Q', player);
	}
	
	@Override
	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo) {
		return false;
		
	}
}