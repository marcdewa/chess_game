package chess_games;

public class PiecesLocation {
	
		private int rank;
		private int file;
		
		public PiecesLocation(int rank,int file) {
			this.rank=rank;
			this.file=file;
		}
		
		public PiecesLocation(char rank, char file) {
			this.rank = rank - 64;
			this.file = file - 48;
		}
		
		public int getRank() {
			return rank;
		}
		public void setRank(int rank) {
			this.rank = rank;
		}
		public int getFile() {
			return file;
		}
		public void setFile(int file) {
			this.file = file;
		}
		
		
}


