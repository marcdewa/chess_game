package chessEntities;

import chess_games.MoveCoordinate;
import chess_games.PiecesLocation;
import chess_games.Board;
public class Pawn extends Pieces {
	
	public boolean isPromoted;
	
	public Pawn(char player,Board[][] board) {
		super('P', player,board);
		this.isPromoted = false;
		
	}

	@Override
	public boolean canMove(MoveCoordinate movLoc) {
		promotedMoveValidation(player,movLoc);
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
	
	public void promotedMoveValidation(char player,MoveCoordinate mc) {
		PiecesLocation locTo = mc.getLocTo();
		if(player =='w' && locTo.getFile() == 8) this.isPromoted = true;
		if(player =='b' && locTo.getFile() == 1) this.isPromoted = true;
		
		
	}

	private boolean moveOneFile(MoveCoordinate movLoc) {
		int fromFile = movLoc.getLocFromFile();
		int toFile = movLoc.getLocToFile();
		int toRank = movLoc.getLocToRank();
		
		if ( fileDifferenceIsEqualsTo(1,movLoc)
                && rankDifferenceIsEqualsTo(0,movLoc) 
                && board[toFile][toRank]==null) {
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
                && isFirstTurn(movLoc.getLocFrom())
                && board[movLoc.getLocToFile()][movLoc.getLocToRank()] == null
                && board[movLoc.getLocToFile()][movLoc.getLocToRank()] == null) {
            if (this.player == 'w') {
                if (fromFile < toFile 
                		&& board[movLoc.getLocToFile()-1][movLoc.getLocToRank()] == null) {
                    return true;
                }
            }
            if (this.player == 'b') {
                if (fromFile > toFile
                		&& board[movLoc.getLocToFile()+1][movLoc.getLocToRank()] == null) {
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
		
		if((rankDifferenceIsEqualsTo(1,movLoc) 
				&&fileDifferenceIsEqualsTo(1,movLoc)) 
				&& board[toFile][toRank] != null) {
			
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
	
	private boolean isFirstTurn(PiecesLocation locFrom) {
		if(this.player=='b' && locFrom.getFile()==7) {
			return true;
		}
		if(this.player=='w' && locFrom.getFile()==2) {
			return true;
		}
		return false;
	}
		
	
}
