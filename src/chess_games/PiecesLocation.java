package chess_games;



public class PiecesLocation {
	
		private int rank;
		private int file;
		
		public PiecesLocation(int file, int rank) {
			this.rank=rank;
			this.file=file;
		}
		
		public PiecesLocation(char file, char rank) {
			this.rank = rank - 64;
			this.file = file - 48;
		}
		
		public PiecesLocation(String Loc) throws Exception {
			int rank = Loc.charAt(0)-64;
			int file = Loc.charAt(1)-48;
			if(coordinateValidation(rank,file))
				throw new Exception("invalid coordinate"); 
			this.rank = rank;
			this.file = file;
		}
		

		
		private boolean coordinateValidation(int rank,int file) {
			if(rank < 0 || rank > 8) {
				return true;
			}
			if(file < 0 || file > 8) {
				return true;
			}
			return false;
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


