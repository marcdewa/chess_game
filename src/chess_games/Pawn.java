package chess_games;

public class Pawn extends Pieces {
	public Pawn(String player,PiecesLocation loc) {
		super(loc);
		if(player.equals("black")) {
			pieces = 'P';
		}
		else pieces = 'p';
	}
	
}
