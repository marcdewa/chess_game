package chessEntities;

import chess_games.PiecesLocation;

public class King extends Pieces {
	
	public King(char player) {
		super('K', player);
	}
	
	@Override
	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo) {
		return false;
	}
}
