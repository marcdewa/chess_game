package chessEntities;

import chess_games.MoveCoordinate;
import chess_games.PiecesLocation;
import chess_games.Board;

public class King extends Pieces {
	private boolean castling;
	public boolean isCastling() {
		return castling;
	}

	public void setCastling(boolean castling) {
		this.castling = castling;
	}

	public King(char player,Board[][] board) {
		super('K', player,board);
		this.castling = false;
		
	}
	
	@Override
	public boolean canMove(MoveCoordinate movLoc) {
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
			return castlingValidation(movLoc);
			
		}
		return false;
	}

	private boolean castlingValidation(MoveCoordinate movLoc) {
		if(fileDifferenceIsEqualsTo(0,movLoc) ){
			
			if(kingsideCastlingValidation(movLoc)
					&&isRookHasMoved(movLoc.getLocTo(),1)) {
					castling = false;
					return false;
				}
			
			else if(queensideCastlingValidation(movLoc)
					&& isRookHasMoved(movLoc.getLocTo(),-2))
				 {
					castling = false;
					return false;
				}
				
		}
		else{
			castling = false;
			return false;
		}
		
		castling = true;
		return true;
	}

	private boolean isRookHasMoved(PiecesLocation locTo, int i) {
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
