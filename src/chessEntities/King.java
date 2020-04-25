package chessEntities;

import chess_games.PiecesLocation;
import chess_games.Position;
public class King extends Pieces {
	private boolean castling;
	public boolean isCastling() {
		return castling;
	}

	public void setCastling(boolean castling) {
		this.castling = castling;
	}

	public King(char player) {
		super('K', player);
		this.castling = false;
		
	}
	
	@Override
	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo,Position[][] board) {
		if(fileDifferenceIsEqualsTo(1,locFrom,locTo) ||rankDifferenceIsEqualsTo(1,locFrom,locTo) ) {
			return true;
		}
		else if(!hasMoved) {
			return castlingValidation(locFrom, locTo, board);
		}
		return false;
	}

	private boolean castlingValidation(PiecesLocation locFrom, PiecesLocation locTo, Position[][] board) {
		if(fileDifferenceIsEqualsTo(0,locFrom,locTo) ){
			if(kingsideCastlingValidation(locFrom, locTo, board)){
				if(rookHasMoved(locTo,1,board)) {
					castling = false;
					return false;
				}
			}
		
			else if(queensideCastlingValidation(locFrom, locTo, board)){
				if(rookHasMoved(locTo,-2,board)) {
					castling = false;
					return false;
				}
			}	
		}else{

			castling = false;
			return false;
		}
		castling = true;
		return true;
	}

	private boolean rookHasMoved(PiecesLocation locTo, int i, Position[][] board) {
		return board[locTo.getFile()][locTo.getRank()+i].getPiece().isHasMoved();
	}

	private boolean queensideCastlingValidation(PiecesLocation locFrom, PiecesLocation locTo, Position[][] board) {
		return (locFrom.getRank()>locTo.getRank()) &&(board[locFrom.getFile()][locFrom.getRank() - 1] == null || board[locFrom.getFile()][locFrom.getRank() - 2] == null ||board[locFrom.getFile()][locFrom.getRank() - 3] == null);
	}

	private boolean kingsideCastlingValidation(PiecesLocation locFrom, PiecesLocation locTo, Position[][] board) {
		return (locFrom.getRank()<locTo.getRank())&&(board[locFrom.getFile()][locFrom.getRank() + 1] == null || board[locFrom.getFile()][locFrom.getRank() + 2] == null);
	}
}
