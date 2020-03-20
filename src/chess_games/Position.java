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


	public PiecesLocation getLoc() {
		return loc;
	}

	public void setLoc(PiecesLocation loc) {
		this.loc = loc;
	}

	public char getPiece() {
		return piece;
	}

	public void setPiece(char piece) {
		this.piece = piece;
	}

	public char getPlayer() {
		return Player;
	}

	public void setPlayer(char player) {
		Player = player;
	}
	
	
	
}
