package chessEntities;

import chess_games.PiecesLocation;
import chess_games.Position;
public class Rook extends Pieces {
	
	public Rook(char player) {
		super('R', player);
	}
	
	@Override
	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo,Position[][] board) {
		
		
		if(locFrom.getFile() != locTo.getFile() && locFrom.getRank() != locTo.getRank()){
			return false;
		}
		
		if(!jumpOverPieceRowCheck(locFrom, locTo, board)) {
			return false;
		}
		if(!jumpOverPieceColumnCheck(locFrom, locTo, board)) {
			return false;
		}
		
		return true;
		
	}

	private boolean jumpOverPieceColumnCheck(PiecesLocation locFrom, PiecesLocation locTo, Position[][] board) {
		int offset;
		if(locFrom.getRank() != locTo.getRank()){
			offset = (locFrom.getRank() < locTo.getRank()) ? 1 : -1;
			for(int x = locFrom.getRank() + offset; x != locTo.getRank(); x += offset){
				if(board[locFrom.getFile()][x] != null){
					return false;
				}
			}
		}
		return true;
	}

	private boolean jumpOverPieceRowCheck(PiecesLocation locFrom, PiecesLocation locTo, Position[][] board) {
		int offset;
		if(locFrom.getFile() != locTo.getFile()){
			offset = (locFrom.getFile() < locTo.getFile())? 1: -1;
			for(int x = locFrom.getFile() + offset; x != locTo.getFile(); x += offset){
				if(board[x][locFrom.getRank()] != null){
					return false;
				}
			}
		}
		return true;
	}

}