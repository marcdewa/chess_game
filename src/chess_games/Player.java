package chess_games;

public class Player {
	private char color;

	public char getColor() {
		return color;
	}

	
	
	public Player(char color) {
		if(color != 'b' && color !='w') {
			throw new IllegalArgumentException();
		}
		this.color = color;
	}
	
	public int isBlackOrWhite() {
		int number=0;
		if(this.color=='b') return number+=32;
		return number;
		
	}
	
}
