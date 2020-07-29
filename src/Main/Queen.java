package Main;

public class Queen extends Pieces {
	
	public Queen(char player,Board[][] board) {
		super('Q', player,board);
	}
	
	@Override
	public boolean canMove(MoveCoordinate movLoc,boolean execute) {
		return new Rook(this.player.getColor(),this.board).canMove(movLoc,execute) || new Bishop(this.player.getColor(),this.board).canMove(movLoc,execute);
		
	}
}