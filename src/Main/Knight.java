package Main;

public class Knight extends Pieces {
	
	public Knight(char player,Board[][] board) {
		super('N', player,board);
	}
	
	@Override
	public boolean canMove(MoveCoordinate movLoc ,boolean execute) {
		
		if(fileDifferenceIsEqualsTo(2,movLoc) && rankDifferenceIsEqualsTo(1,movLoc))
			return true;
		
		if(fileDifferenceIsEqualsTo(1,movLoc)&& rankDifferenceIsEqualsTo(2,movLoc))
			return true;
		
		return false;
	}
}
