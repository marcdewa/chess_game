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
		b[Side][1] = new Position(new PiecesLocation(Side,1),'R',player);
		b[Side][8] = new Position(new PiecesLocation(Side,8),'R',player);
		
		//Knight
		b[Side][2] = new Position(new PiecesLocation(Side,2),'N',player);
		b[Side][7] = new Position(new PiecesLocation(Side,7),'N',player);
		
		//Bishop
		b[Side][3] = new Position(new PiecesLocation(Side,3),'B',player);
		b[Side][6] = new Position(new PiecesLocation(Side,6),'B',player);
		
		//Queen
		b[Side][4] = new Position(new PiecesLocation(Side,4),'Q',player);
		
		//King
		b[Side][5] = new Position(new PiecesLocation(Side,5),'K',player);
		
		//Pawn
		for(int i=1; i<9;i++) {
			b[Side+bw][i]=new Position(new PiecesLocation(7,i),'P',player);
		}

	}
	
	public void print() {
		
			for(int i = 8 ; i > 0 ; i--) {
			
				for(int j = 1 ; j < 9 ; j++) {
					if(b[i][j] != null) {
					System.out.print(" "+b[i][j].piece+" ");
					}else System.out.print("   ");
				}
				System.out.println(" "+(i)+" ");
			}
			System.out.println(" A  B  C  D  E  F  G  H");
	}

}
