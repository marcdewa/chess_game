package chessEntities;

import chess_games.PiecesLocation;
import chess_games.Position;

public class Knight extends Pieces {
	
	public Knight(char player) {
		super('K', player);
	}
	
	@Override
	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo,Position[][] board) {
		
		if(Math.abs(locTo.getFile() - locFrom.getFile()) == 2 && Math.abs(locTo.getRank() - locFrom.getRank()) == 1){
			return true;
		}
		
		if(Math.abs(locTo.getFile() - locFrom.getFile()) == 1 && Math.abs(locTo.getRank() - locFrom.getRank()) == 2){
			return true;
		}
		
		return false;
	}
}
