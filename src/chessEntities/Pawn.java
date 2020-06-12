package chessEntities;

import chess_games.MoveCoordinate;
import chess_games.PiecesLocation;
import chess_games.Board;
public class Pawn extends Pieces {
	
	public boolean isPromoted;
	public boolean isEnPassant;
	public boolean isMove2Files;
	
	public Pawn(char player,Board[][] board) {
		super('P', player,board);
		this.isPromoted = false;
		this.isEnPassant = false;
		this.isMove2Files = false;
		
	}

	@Override
	public boolean canMove(MoveCoordinate movLoc ,boolean execute) {
		Execute(execute);
		promotedMoveValidation(movLoc,execute);
		if(isEnPassantMove(movLoc)) {
			this.isEnPassant = true;
			return true;
		}
		else if(isTakingPiece(movLoc)) {
        	return true;
        }        
        else if(moveTwoFiles(movLoc)) {
        	this.isMove2Files = true;
        	return true;
        }
        else if(moveOneFile(movLoc)) {
        	return true;
        }
		
		return false;
	}
	
	private void Execute(boolean execute) {
		if(execute) {
			this.isEnPassant = false;
			this.isMove2Files = false;
		}
	}
	
	public void promotedMoveValidation(MoveCoordinate mc,boolean execute) {
		if(execute) {
			PiecesLocation locTo = mc.getLocTo();
			if(player.getColor() =='w' && locTo.getFile() == 8) this.isPromoted = true;
			if(player.getColor() =='b' && locTo.getFile() == 1) this.isPromoted = true;
		}
		
		
	}

	private boolean isEnPassantMove(MoveCoordinate movLoc) {
		int fromFile = movLoc.getLocFromFile();
		int toFile = movLoc.getLocToFile();
		int toRank = movLoc.getLocToRank();
		int enemyOffset = (this.player.getColor()== 'b')? 1 : -1;
		int fileOffset =toFile+enemyOffset;
		if(fileOffset <1 || fileOffset>8) {
			return false;
		}
		if(board[toFile+enemyOffset][toRank] != null) {
			//System.out.println(((Pawn) board[toFile+enemyOffset][toRank].getPiece()).isMove2Files);
			if((rankDifferenceIsEqualsTo(1,movLoc) 
					&&fileDifferenceIsEqualsTo(1,movLoc)) 
					&& board[toFile+enemyOffset][toRank] != null
					&& ((Pawn) board[toFile+enemyOffset][toRank].getPiece()).isMove2Files) {
				
	        	 if (this.player.getColor() == 'w') {
	                 if ((fromFile < toFile) ) {
	                	
	                     return true;
	                 }
	             }
	          
	             if (this.player.getColor() == 'b') {
	                 if (fromFile > toFile) {
	                     return true;
	                 }
	             }
	             
	        	
	        }
		}
        return false;
	}
	
	private boolean moveOneFile(MoveCoordinate movLoc) {
		int fromFile = movLoc.getLocFromFile();
		int toFile = movLoc.getLocToFile();
		int toRank = movLoc.getLocToRank();
		
		if ( fileDifferenceIsEqualsTo(1,movLoc)
                && rankDifferenceIsEqualsTo(0,movLoc) 
                && board[toFile][toRank]==null) {
            if (this.player.getColor() == 'w') {
                if (fromFile<toFile ) {
                    return true;
                }
            }
         
            if (this.player.getColor() == 'b') {
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
                && board[movLoc.getLocToFile()][movLoc.getLocToRank()] == null) {
            if (this.player.getColor() == 'w') {
                if (fromFile < toFile 
                		&& board[movLoc.getLocToFile()-1][movLoc.getLocToRank()] == null) {
                    return true;
                }
            }
            if (this.player.getColor() == 'b') {
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
			
        	 if (this.player.getColor() == 'w') {
                 if ((fromFile < toFile) ) {
                	
                     return true;
                 }
             }
          
             if (this.player.getColor() == 'b') {
                 if (fromFile > toFile) {
                     return true;
                 }
             }
             
        	
        }
        return false;
	}
	
	private boolean isFirstTurn(PiecesLocation locFrom) {
		if(this.player.getColor()=='b' && locFrom.getFile()==7) {
			return true;
		}
		if(this.player.getColor()=='w' && locFrom.getFile()==2) {
			return true;
		}
		return false;
	}
		
	
}
