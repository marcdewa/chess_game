package chess_games;

public class games {

	int[][] temp = new int[10][10]; 
	public void print() {
		for(int i = 9 ; i > 0 ; i--) {
			
			for(int j = 0 ; j < 8 ; j++) {
				
				if(i==1) System.out.print(" "+(char)(j+65)+" ");
				
				else System.out.print(" "+temp[i][j]+" ");
			}
			if(i!=1)
			System.out.println(" "+(i-1)+" ");
		}
	}
	
	public games() {
		print();
	}

	public static void main(String[] args) {
		new games();

	}

}
