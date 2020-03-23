package chessEntities;

import chess_games.PiecesLocation;

public class Knight extends Pieces {
	
	public Knight(char player) {
		super('K', player);
	}
	
	@Override
	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo) {
		return false;
	}
}
