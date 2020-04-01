package chessEntities;

import chess_games.PiecesLocation;
import chess_games.Position;
public class King extends Pieces {
	
	public King(char player) {
		super('K', player);
	}
	
	@Override
	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo,Position[][] board) {
		if(fileDifferenceIsEqualsTo(1,locFrom,locTo) ||rankDifferenceIsEqualsTo(1,locFrom,locTo) ) {
			return true;
		}
		return false;
	}
}
