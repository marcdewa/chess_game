package chessEntities;

import chess_games.MoveCoordinate;
import chess_games.PiecesLocation;
import chess_games.Position;
public class Rook extends Pieces {
	
	public Rook(char player,Position[][] board) {
		super('R', player,board);
	}
	
	@Override
	public boolean canMove(MoveCoordinate movLoc) {
	
		
		if(movLoc.getLocFromFile() != movLoc.getLocToFile()&& movLoc.getLocFromRank() != movLoc.getLocToRank()){
			return false;
		}
		
		if(!jumpOverPieceRowCheck(movLoc)) {
			return false;
		}
		if(!jumpOverPieceColumnCheck(movLoc)) {
			return false;
		}
		
		return true;
		
	}

	private boolean jumpOverPieceColumnCheck(MoveCoordinate movLoc) {
		int offset;
		int fromRank= movLoc.getLocFromRank();
		int fromFile= movLoc.getLocFromFile();
		int toRank = movLoc.getLocToRank();
		if(fromRank != toRank){
			offset = (fromRank < toRank) ? 1 : -1;
			for(int x = fromRank + offset; x != toRank; x += offset){
				if(board[fromFile][x] != null){
					return false;
				}
			}
		}
		return true;
	}

	private boolean jumpOverPieceRowCheck(MoveCoordinate movLoc) {
		int offset;
		int toFile= movLoc.getLocToFile();
		int fromFile= movLoc.getLocFromFile();
		int fromRank = movLoc.getLocFromRank();
		if(fromFile != toFile){
			offset = (fromFile < toFile)? 1: -1;
			for(int x = fromFile + offset; x != toFile; x += offset){
				if(board[x][fromRank] != null){
					return false;
				}
			}
		}
		return true;
	}

}