package chess_games;

public class Position {
	private PiecesLocation loc;
	public char piece;
	private char Player;
	
	public Position(PiecesLocation loc,char piece,char Player) {
		this.loc = loc;
		this.piece = piece;
		this.Player = Player;
	}

}
