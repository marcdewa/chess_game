package chessEntities;

import chess_games.PiecesLocation;

public class Pawn extends Pieces {
	
	public Pawn(char player) {
		super('P', player);
		
	}

	@Override
	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo) {
		
        if ( fileDifferenceIsEqualsTo(1,locFrom,locTo)
                && rankDifferenceIsEqualsTo(0,locFrom,locTo)) {
            if (this.player == 'w') {
                if (locFrom.getFile() < locTo.getFile()) {
               	
                    return true;
                }
            }
         
            if (this.player == 'b') {
                if (locFrom.getFile() > locTo.getFile()) {
                    return true;
                }
            }
        }
        
        if (fileDifferenceIsEqualsTo(2,locFrom,locTo)
                && rankDifferenceIsEqualsTo(0,locFrom,locTo)
                && isFirstTurn(locFrom)) {

            // White can only move forward
            if (this.player == 'w') {
                if (locFrom.getFile() < locTo.getFile()) {
                    return true;
                }
            }
            // Black can only move backward in a sense.
            if (this.player == 'b') {
                if (locFrom.getFile() > locTo.getFile()) {
                    return true;
                }
            }

        }
        
		return false;
	}
	
	public boolean isFirstTurn(PiecesLocation locFrom) {
		if(this.player=='b' && locFrom.getFile()==7) {
			return true;
		}
		if(this.player=='w' && locFrom.getFile()==2) {
			return true;
		}
		return false;
	}
		
	
}
