package chessEntities;

import chess_games.MoveCoordinate;
import chess_games.Board;
public class Queen extends Pieces {
	
	public Queen(char player,Board[][] board) {
		super('Q', player,board);
	}
	
	@Override
	public boolean canMove(MoveCoordinate movLoc) {
		return new Rook(this.player,this.board).canMove(movLoc) || new Bishop(this.player,this.board).canMove(movLoc);
		
	}
}