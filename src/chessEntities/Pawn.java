package chessEntities;

import chess_games.PiecesLocation;

public class Pawn extends Pieces {
	
	public Pawn(char player) {
		super('P', player);
		
	}

	@Override
	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo) {
		int Difference = (this.player=='b') ? locFrom.getFile()-locTo.getFile() : locTo.getFile()-locFrom.getFile();
		System.out.println((Difference>0 && Difference <3));
		System.out.println(locFrom.getRank() == locFrom.getRank());
		if((Difference>0 && Difference <3) && (locFrom.getRank() == locFrom.getRank()))
			return true;
		
		return false;
	}
	
	
}
