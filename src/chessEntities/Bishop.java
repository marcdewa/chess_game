package chessEntities;

import chess_games.MoveCoordinate;
import chess_games.Board;

public class Bishop extends Pieces {
	
	public Bishop(char player,Board[][] board) {
		super('B', player,board);
	}
	
	@Override
	public boolean canMove(MoveCoordinate movLoc) {
		if(movingStraight(movLoc)){
			return false;
		}
		if(notMovingDiagonally(movLoc)){
			return false;
		}
		
		if(!jumpOverPieceCheck(movLoc)) {
			return false;
		}
		
		return true;
		
	}

	private boolean jumpOverPieceCheck(MoveCoordinate movLoc) {
		int fileOffSet =(movLoc.getLocFromFile() < movLoc.getLocToFile()) ? 1:-1;
		int rankOffSet = (movLoc.getLocFromRank() < movLoc.getLocToRank()) ? 1:-1;
		int y = movLoc.getLocFromRank() + rankOffSet;
		
		for(int x = movLoc.getLocFromFile()+ fileOffSet; x != movLoc.getLocToFile(); x += fileOffSet){
			if(board[x][y] != null ){
				return false;
			}
			
			y += rankOffSet;
		} return true;
	}

	private boolean notMovingDiagonally(MoveCoordinate movLoc) {
		return Math.abs(movLoc.getLocFromFile() - movLoc.getLocToFile()) != Math.abs(movLoc.getLocFromRank() - movLoc.getLocToRank());
	}

	private boolean movingStraight(MoveCoordinate movLoc) {
		return movLoc.getLocFromFile() == movLoc.getLocToFile() || movLoc.getLocFromRank() == movLoc.getLocToRank();
	}
	
}