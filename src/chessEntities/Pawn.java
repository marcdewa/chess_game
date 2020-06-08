package chessEntities;

import chess_games.MoveCoordinate;
import chess_games.PiecesLocation;
import chess_games.Position;
public class Pawn extends Pieces {
	
	public Pawn(char player,Position[][] board) {
		super('P', player,board);
		
	}

	@Override
	public boolean canMove(MoveCoordinate movLoc) {
        if(isTakingPiece(movLoc)) {
        	return true;
        }        
        else if(moveTwoFiles(movLoc)) {
        	return true;
        }
        else if(moveOneFile(movLoc)) {
        	return true;
        }
		return false;
	}

	private boolean moveOneFile(MoveCoordinate movLoc) {
		int fromFile = movLoc.getLocFromFile();
		int toFile = movLoc.getLocToFile();
		int toRank = movLoc.getLocToRank();
		if ( fileDifferenceIsEqualsTo(1,movLoc)
                && rankDifferenceIsEqualsTo(0,movLoc) && board[toFile][toRank]==null) {
            if(board[movLoc.getLocToFile()][movLoc.getLocToRank()] != null) 
            	return false;
            if (this.player == 'w') {
                if (fromFile<toFile ) {
                    return true;
                }
            }
         
            if (this.player == 'b') {
                if (fromFile > toFile) {
                    return true;
                }
            }

            
        }return false;
	}

	private boolean moveTwoFiles(MoveCoordinate movLoc) {
		int fromFile = movLoc.getLocFromFile();
		int toFile = movLoc.getLocToFile();
		
		if (fileDifferenceIsEqualsTo(2,movLoc)
                && rankDifferenceIsEqualsTo(0,movLoc)
                && isFirstTurn(movLoc.getLocFrom())) {
            if(board[movLoc.getLocToFile()][movLoc.getLocToRank()] != null) 
            	return false;
            if (this.player == 'w') {
                if (fromFile < toFile) {
                    return true;
                }
            }
            if (this.player == 'b') {
                if (fromFile > toFile) {
                    return true;
                }
            }

            
        }
		return false;
	}

	private boolean isTakingPiece(MoveCoordinate movLoc) {
		int fromFile = movLoc.getLocFromFile();
		int toFile = movLoc.getLocToFile();
		int toRank = movLoc.getLocToRank();
		
		if((rankDifferenceIsEqualsTo(1,movLoc) && 
        	fileDifferenceIsEqualsTo(1,movLoc)) && 
        	board[toFile][toRank] != null) {
        	 if (this.player == 'w') {
                 if ((fromFile < toFile) ) {
                	
                     return true;
                 }
             }
          
             if (this.player == 'b') {
                 if (fromFile > toFile) {
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
