package chess_games;

public class Position {
	private PiecesLocation loc;
	public char piece;
	private char Player;
	
	public Position(PiecesLocation loc,char piece,char Player) {
		pieceColor(Player,piece);
		this.loc = loc;
		this.Player = Player;
	}

	public void pieceColor (char player , char piece ) {
		if(player!='b') {
			this.piece=(char) (piece+32);
		}else this.piece = piece;
	}
	
	
}
