package Main;

public class Pawn extends Pieces {
	
	private boolean isPromoted;
	private boolean isEnPassant;
	private boolean isMove2Files;
	
	public Pawn(char player,Board[][] board) {
		super('P', player,board);
		this.isPromoted = false;
		this.isEnPassant = false;
		this.isMove2Files = false;
		
	}

	@Override
	public boolean canMove(MoveCoordinate movLoc ,boolean execute) {
		setEnPassant(execute,false);
		setMove2Files(execute,false);
		promotedMoveValidation(movLoc,execute);
		if(isEnPassantMove(movLoc)) {
			setEnPassant(execute,true);
			return true;
		}
		else if(isTakingPiece(movLoc)) {
        	return true;
        }        
        else if(moveTwoFiles(movLoc)) {
        	setMove2Files(execute,true);
        	return true;
        }
        else if(moveOneFile(movLoc)) {
        	return true;
        }
		
		return false;
	}
	
	
	public void promotedMoveValidation(MoveCoordinate mc,boolean execute) {
			Location locTo = mc.getLocTo();
			if(player.getColor() =='w' && locTo.getFile() == 8) setPromoted(execute,true);
			if(player.getColor() =='b' && locTo.getFile() == 1) setPromoted(execute,true);
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
	
	private boolean isFirstTurn(Location locFrom) {
		if(this.player.getColor()=='b' && locFrom.getFile()==7) {
			return true;
		}
		if(this.player.getColor()=='w' && locFrom.getFile()==2) {
			return true;
		}
		return false;
	}
	
	
	public boolean isPromoted() {
		return this.isPromoted;
	}

	public boolean isEnPassant() {
		return this.isEnPassant;
	}

	public boolean isMove2Files() {
		return this.isMove2Files;
	}
	
	public boolean setMove2FilesFalse() {
		return this.isMove2Files = false;
	}

	private void setPromoted(boolean execute , boolean promoted) {
		if(execute) this.isPromoted = promoted;
	}

	private void setEnPassant(boolean execute , boolean enpassant) {
		if(execute) this.isEnPassant = enpassant;
	}

	private void setMove2Files(boolean execute , boolean move2files) {
		if(execute) this.isMove2Files = move2files;
	}
		
	
}
