package Main;

public class King extends Pieces {
	private boolean castling;


	public King(char player,Board[][] board) {
		super('K', player,board);
		this.castling = false;
		
	}
	
	@Override
	public boolean canMove(MoveCoordinate movLoc ,boolean execute) {
		if(fileDifferenceIsEqualsTo(1,movLoc) && rankDifferenceIsEqualsTo(0,movLoc) ) {
			return true;
		}
		if(rankDifferenceIsEqualsTo(1,movLoc) && fileDifferenceIsEqualsTo(0,movLoc)) {
			return true;
		}
		if(rankDifferenceIsEqualsTo(1,movLoc) && fileDifferenceIsEqualsTo(1,movLoc)) {
			return true;
		}
		else if(!hasMoved) {
			return castlingValidation(movLoc,execute);
			
		}
		return false;
	}
	
	public boolean isCastling() {
		return castling;
	}
	
	private void setCastling(boolean execute,boolean castling) {
		if(execute) this.castling=true;
	}

	private boolean castlingValidation(MoveCoordinate movLoc,boolean execute) {
		if(fileDifferenceIsEqualsTo(0,movLoc) ){
			
			if(kingsideCastlingValidation(movLoc)
					&&isRookHasMoved(movLoc.getLocTo(),1)) {
					setCastling(execute,false);
					return false;
				}
			
			else if(queensideCastlingValidation(movLoc)
					&& isRookHasMoved(movLoc.getLocTo(),-2))
				 {
					setCastling(execute,false);
					return false;
				}
				
		}
		else{
			setCastling(execute,false);
			return false;
		}
		
		setCastling(execute,true);
		return true;
	}

	private boolean isRookHasMoved(Location locTo, int i) {
		return board[locTo.getFile()][locTo.getRank()+i].getPiece().isHasMoved();
	}

	private boolean queensideCastlingValidation(MoveCoordinate movLoc) {
		int x = movLoc.getLocFromFile();
		int y = movLoc.getLocFromRank();
		return (movLoc.getLocFromRank()>movLoc.getLocToRank()) &&(isBoardNull(x,y-1)|| isBoardNull(x,y-2) ||isBoardNull(x,y-3));
	}

	private boolean kingsideCastlingValidation(MoveCoordinate movLoc) {
		int x = movLoc.getLocFromFile(); 
		int y = movLoc.getLocFromRank(); 
		return (movLoc.getLocFromRank()<movLoc.getLocToRank())&&(isBoardNull(x,y+1) || isBoardNull(x,y+2));
	}
	
	private boolean isBoardNull(int x , int y) {
		return board[x][y] == null;
	}
}
