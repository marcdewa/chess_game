package chessEntities;

import chess_games.PiecesLocation;
import chess_games.Position;

public class Bishop extends Pieces {
	
	public Bishop(char player) {
		super('B', player);
	}
	
	@Override
	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo,Position[][] board) {
		if(movingStraight(locFrom, locTo)){
			return false;
		}
		if(notMovingDiagonally(locFrom, locTo)){
			return false;
		}
		
		if(!jumpOverPieceCheck(locFrom, locTo, board)) {
			return false;
		}
		
		return true;
		
	}

	private boolean jumpOverPieceCheck(PiecesLocation locFrom, PiecesLocation locTo, Position[][] board) {
		int fileOffSet =(locFrom.getFile() < locTo.getFile()) ? 1:-1;
		int rankOffSet = (locFrom.getRank() < locTo.getRank()) ? 1:-1;
		//System.out.println(fileOffSet);
		//System.out.println(rankOffSet);
		int y = locFrom.getRank() + rankOffSet;
		
		for(int x = locFrom.getFile()+ fileOffSet; x != locTo.getFile(); x += fileOffSet){
			//System.out.println(x+" "+""+y+"\n");
			if(board[x][y] != null ){
				return false;
			}
			
			y += rankOffSet;
		} return true;
	}

	private boolean notMovingDiagonally(PiecesLocation locFrom, PiecesLocation locTo) {
		return Math.abs(locFrom.getFile() - locTo.getFile()) != Math.abs(locFrom.getRank() - locTo.getRank());
	}

	private boolean movingStraight(PiecesLocation locFrom, PiecesLocation locTo) {
		return locFrom.getFile() == locTo.getFile() || locFrom.getRank() == locTo.getRank();
	}
	
}