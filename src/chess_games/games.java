package chess_games;

public class games {
	Position[][] b ;

	
	public games() {
		b = new Position[10][10];
		defaultPieceLocation('b');
		defaultPieceLocation('w');
	}
	
	public void defaultPieceLocation(char player) {
		int Side = (player=='b')? 8 : 1 ; 
		int bw = (player=='b')? -1 : 1;
		//Rook
		setNewPieceAt(Side,1,"Rook",player);
		setNewPieceAt(Side,8,"Rook",player);
		
		//Knight
		setNewPieceAt(Side,2,"Night",player);
		setNewPieceAt(Side,7,"Night",player);
		//Emang sengaja 'Night' belum ketemu algoritmanya
		
		//Bishop
		setNewPieceAt(Side,3,"Bishop",player);
		setNewPieceAt(Side,6,"Bishop",player);
		
		//Queen
		setNewPieceAt(Side,4,"Queen",player);
		
		//King
		setNewPieceAt(Side,5,"Queen",player);
		
		
		//Pawn
		for(int i=1; i<9;i++) {
			setNewPieceAt(Side+bw,i,"Pawn",player);
		}

	}
	
	public void setNewPieceAt(int file,int rank,String piece,char player) {
		b[file][rank] = new Position(new PiecesLocation(file,rank),piece.charAt(0),player);
	}
	
	public void coordinateMove(String newLoc) {
		String From;
		String To;
		PiecesLocation locFrom;
		PiecesLocation locTo;
		
		
		From = newLoc.substring(0,2);
		locFrom = new PiecesLocation(From.charAt(0),From.charAt(1));
		To = newLoc.substring(3,5);
		locTo = new PiecesLocation(To.charAt(0),To.charAt(1));
		
		b[locTo.getFile()][locTo.getRank()]= b[locFrom.getFile()][locFrom.getRank()];
		b[locTo.getFile()][locTo.getRank()].setLoc(locTo);
		b[locFrom.getFile()][locFrom.getRank()] = null;
	}

	public void print() {
		
			for(int i = 8 ; i > 0 ; i--) {
			
				for(int j = 1 ; j < 9 ; j++) {
					
					if(b[i][j] != null) {
					System.out.print(" "+b[i][j].piece+" ");
					}else blackOrWhiteBoardColor(i, j);
					
				}
				System.out.println(" "+(i)+" ");
			}
			System.out.println(" A  B  C  D  E  F  G  H");
	}

	private void blackOrWhiteBoardColor(int i, int j) {
		if(isEven(i)) {
			if(isEven(j)) {
				System.out.print(" + ");
			}
			else System.out.print(" - ");
		}
		else {
				if(isEven(j)) {
					System.out.print(" - ");
				}
				else System.out.print(" + ");
			
		}
	}

	private boolean isEven(int i) {
		return i%2==0;
	}

}
