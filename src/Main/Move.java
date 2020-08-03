package Main;




public class Move {
	private Board[][] board;
	private MoveCoordinate movLoc;
	private Player player;
	
	public Move(Board[][] board) {
		this.board = board;
	}
	
	public boolean movingPiece(Player player,MoveCoordinate movLoc,boolean execute) {
		this.movLoc = movLoc;
		this.player = player;
		if(isMoveValid(execute)) {
			if(isMovePawnPromotion()) {
				pawnPromotionMove();
				return true;
			}
			
			else if(isMoveEnPassant()) {
				
				enPassantMove(execute);
				return true;
			}
			
			else if(isMoveCastling()) {
				castlingMove(execute);
				return true;
			}
			
			performMove(execute);
			return true;
			
		}
		else return false;
		
	}
	
	private boolean isMoveValid(boolean execute) {
		int fromFile = movLoc.getLocFromFile();
		int fromRank = movLoc.getLocFromRank();
		if(!isEnemyPiece()) 
			return false;
		if(!(board[fromFile][fromRank].getColor() == player.getColor())) 
			return false;
		if(!(board[fromFile][fromRank].canMove(movLoc,execute))) 
			return false;
		if(movLoc.getPromotedPiece() != '\u0000' && !((Pawn) (board[fromFile][fromRank].getPiece())).isPromoted())
			return false;
		
		return true;
	}
	
	private void performMove(boolean execute) {
		board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPiece().setHasMoved(true,execute);
		board[movLoc.getLocToFile()][movLoc.getLocToRank()]= board[movLoc.getLocFromFile()][movLoc.getLocFromRank()];
		board[movLoc.getLocFromFile()][movLoc.getLocFromRank()] = null;
	}
	
	private void pawnPromotionMove() {
		char player = this.player.getColor();
		if(movLoc.getPromotedPiece() == 'Q') {
			setNewPieceAt(movLoc.getLocToFile(),movLoc.getLocToRank(),new Queen(player,board));
		}
		else if(movLoc.getPromotedPiece() == 'R') {
			setNewPieceAt(movLoc.getLocToFile(),movLoc.getLocToRank(),new Rook(player,board));
		}
		else if(movLoc.getPromotedPiece() == 'N') {
			setNewPieceAt(movLoc.getLocToFile(),movLoc.getLocToRank(),new Knight(player,board));
		}
		else if(movLoc.getPromotedPiece() == 'B') {
			setNewPieceAt(movLoc.getLocToFile(),movLoc.getLocToRank(),new Bishop(player,board));
		}
		board[movLoc.getLocFromFile()][movLoc.getLocFromRank()]=null;
	}
	
	public void setNewPieceAt(int file,int rank,Pieces piece) {
		board[file][rank] = new Board(new Location(file,rank),piece);
	}
	
	private boolean isMovePawnPromotion() {
		return isPawn(movLoc.getLocFromFile(),movLoc.getLocFromRank()) && ((Pawn) (board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPiece())).isPromoted();

	}
	
	
	private void enPassantMove(boolean execute) {
		char player = this.player.getColor();
		if(player == 'b') {
			board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPiece().setHasMoved(true,execute);
			board[movLoc.getLocToFile()][movLoc.getLocToRank()]= board[movLoc.getLocFromFile()][movLoc.getLocFromRank()];
			board[movLoc.getLocFromFile()][movLoc.getLocFromRank()] = null;
			board[movLoc.getLocFromFile()][movLoc.getLocToRank()] = null;
		}
		if(player == 'w') {
			board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPiece().setHasMoved(true,execute);
			board[movLoc.getLocToFile()][movLoc.getLocToRank()]= board[movLoc.getLocFromFile()][movLoc.getLocFromRank()];
			board[movLoc.getLocFromFile()][movLoc.getLocFromRank()] = null;
			board[movLoc.getLocFromFile()][movLoc.getLocToRank()] = null;
		}
		
	}
	
	private boolean isMoveEnPassant() {
		return isPawn(movLoc.getLocFromFile(),movLoc.getLocFromRank()) && ((Pawn) (board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPiece())).isEnPassant();

	}
	


	private void castlingMove(boolean execute) {
		performMove(execute);
		if(movLoc.getLocToRank()-movLoc.getLocFromRank()==2) {
			board[movLoc.getLocToFile()][movLoc.getLocToRank()+1].getPiece().setHasMoved(true,execute);
			board[movLoc.getLocToFile()][movLoc.getLocToRank()-1]= board[movLoc.getLocToFile()][movLoc.getLocToRank()+1];
			board[movLoc.getLocToFile()][movLoc.getLocToRank()+1] = null;
		}else {
			board[movLoc.getLocToFile()][movLoc.getLocToRank()-2].getPiece().setHasMoved(true,execute);
			board[movLoc.getLocToFile()][movLoc.getLocToRank()+1]= board[movLoc.getLocToFile()][movLoc.getLocToRank()-2];
			board[movLoc.getLocToFile()][movLoc.getLocToRank()-2] = null;
		}
		
	}
	

	
	private boolean isMoveCastling() {
		Location locFrom = movLoc.getLocFrom();
		return isKing(locFrom.getFile(),locFrom.getRank()) && ((King) (board[locFrom.getFile()][locFrom.getRank()].getPiece())).isCastling();
	}
	
	private boolean isEnemyPiece() {
		try {
			return board[movLoc.getLocToFile()][movLoc.getLocToRank()].getColor() != board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getColor();
		} catch (Exception e) {
			return true;
		}
	}
	

	
	public Board[][] cloning(Board[][] Board) {
		Board[][] oldBoard = new Board[10][10];
		for(int i = 8 ; i > 0 ; i--) {
			for(int j = 1 ; j < 9 ; j++) {
				oldBoard[i][j] = Board[i][j];

			}
		
		}
		return oldBoard;
	}
	
	public void reverseMove(Board[][] Board) {
		for(int i = 8 ; i > 0 ; i--) {
			for(int j = 1 ; j < 9 ; j++) {
				this.board[i][j] = Board[i][j];
			}
		}
	}
	

	
	private boolean isPawn(int i, int j) {
		return board[i][j].getPiece().isPawn(i, j);
	}
	
	public boolean isKing(int i, int j) {
		return board[i][j].getPiece().isKing(i, j);
	}
	
}
