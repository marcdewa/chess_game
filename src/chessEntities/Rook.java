package chessEntities;

import chess_games.PiecesLocation;

public class Rook extends Pieces {
	
	public Rook(char player) {
		super('R', player);
	}
	
	@Override
	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo) {
		return false;
	}
}