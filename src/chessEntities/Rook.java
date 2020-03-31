package chessEntities;

import chess_games.PiecesLocation;
import chess_games.Position;
public class Rook extends Pieces {
	
	public Rook(char player) {
		super('R', player);
	}
	
	@Override
	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo,Position[][] board) {
		return false;
	}
}