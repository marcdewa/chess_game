package chessEntities;

import chess_games.PiecesLocation;
import chess_games.Position;
public class Knight extends Pieces {
	
	public Knight(char player) {
		super('K', player);
	}
	
	@Override
	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo,Position[][] board) {
		return false;
	}
}
