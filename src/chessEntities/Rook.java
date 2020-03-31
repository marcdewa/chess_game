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
		
		int offset;
		
		if(locFrom.getFile() != locTo.getFile()){
			
			offset = (locFrom.getFile() < locTo.getFile())? 1: -1;
			
			for(int x = locFrom.getFile() + offset; x != locTo.getFile(); x += offset){
				//System.out.println(x+""+""+locFrom.getRank());
				if(board[x][locFrom.getRank()] != null){
					return false;
				}
			}
		}
		
		
		
		if(locFrom.getRank() != locTo.getRank()){
			offset = (locFrom.getRank() < locTo.getRank()) ? 1 : -1;
			for(int x = locFrom.getRank() + offset; x != locTo.getRank(); x += offset){
				//System.out.println(x+""+""+locFrom.getFile());
				if(board[locFrom.getFile()][x] != null){
					return false;
				}
			}
		}
		
		return true;
		
	}

}