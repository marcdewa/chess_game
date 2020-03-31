package chessEntities;

import chess_games.PiecesLocation;
import chess_games.Position;
public class Queen extends Pieces {
	
	public Queen(char player) {
		super('Q', player);
	}
	
	@Override
	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo,Position[][] board) {
		return false;
		
	}
}