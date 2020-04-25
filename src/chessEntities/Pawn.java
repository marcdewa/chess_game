package chessEntities;

import chess_games.PiecesLocation;
import chess_games.Position;
public class Pawn extends Pieces {
	
	public Pawn(char player) {
		super('P', player);
		
	}

	@Override
	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo,Position[][] board) {
        if(isTakingPiece(locFrom, locTo, board)) {
        	return true;
        }        
        else if(moveTwoFiles(locFrom, locTo)) {
        	return true;
        }
        else if(moveOneFile(locFrom, locTo, board)) {
        	return true;
        }
		return false;
	}

	private boolean moveOneFile(PiecesLocation locFrom, PiecesLocation locTo, Position[][] board) {
		if ( fileDifferenceIsEqualsTo(1,locFrom,locTo)
                && rankDifferenceIsEqualsTo(0,locFrom,locTo) && board[locTo.getFile()][locTo.getRank()]==null) {
            if (this.player == 'w') {
                if ((locFrom.getFile() < locTo.getFile()) ) {
                    return true;
                }
            }
         
            if (this.player == 'b') {
                if (locFrom.getFile() > locTo.getFile()) {
                    return true;
                }
            }
        }return false;
	}

	private boolean moveTwoFiles(PiecesLocation locFrom, PiecesLocation locTo) {

		if (fileDifferenceIsEqualsTo(2,locFrom,locTo)
                && rankDifferenceIsEqualsTo(0,locFrom,locTo)
                && isFirstTurn(locFrom)) {
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
		return false;
	}

	private boolean isTakingPiece(PiecesLocation locFrom, PiecesLocation locTo, Position[][] board) {
		if((rankDifferenceIsEqualsTo(1,locFrom,locTo) && 
        	fileDifferenceIsEqualsTo(1,locFrom,locTo)) && 
        	board[locTo.getFile()][locTo.getRank()] != null) {
        	 if (this.player == 'w') {
                 if ((locFrom.getFile() < locTo.getFile()) ) {
                	
                     return true;
                 }
             }
          
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
