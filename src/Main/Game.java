package Main;

import java.util.Scanner;



/* Maaf ko , saya baru sadar diakhir project kalok saya terbalik menggunakan 
 * maksud file dan rank , disini saya menggunakan 
 * 
 * File sebagai Row
 * Rank sebagai Column
 * 
 * Mohon dimengerti ya ko hehehe saya masih sangat awam dicatur soalnya,
 * dan sudah terlalu sulit untuk mengubah semuanya , karena
 * saya sadar pas semua function udah hampir jadi
 * Terima kasih ko.
 * */


public class Game {
	public Board[][] board ;
	public Move move;
	private BoardPrinter print;
	private Scanner scan ;
	private Location lastMovedLoc;
	private Location tempMovedLoc;
	
	public Game() {
		this.scan = new Scanner(System.in);
		this.board = new Board[10][10];
		this.print = new BoardPrinter(board);
		this.move = new Move(board);
	}
	
	public void startGame() {
		defaultPieceLocation('b');
		defaultPieceLocation('w');
		while(true) {
			Turn('w');
			Turn('b');
		}
	}
	
	public void defaultPieceLocation(char player) {
		int startPoint = isBlack(player)? 8 : 1 ; 
		int forwardMovement = isBlack(player)? -1 : 1;

		setNewPieceAt(startPoint,1,new Rook(player,board));
		setNewPieceAt(startPoint,8,new Rook(player,board));
		
		setNewPieceAt(startPoint,2,new Knight(player,board));
		setNewPieceAt(startPoint,7,new Knight(player,board));
		
		setNewPieceAt(startPoint,3,new Bishop(player,board));
		setNewPieceAt(startPoint,6,new Bishop(player,board));
	
		setNewPieceAt(startPoint,4,new Queen(player,board));
	
		setNewPieceAt(startPoint,5,new King(player,board));

		for(int i=1; i<9;i++) {
			setNewPieceAt(startPoint+forwardMovement,i,new Pawn(player,board));
		}

	}


	private boolean isBlack(char player) {
		return player=='b';
	}
	
	public void setNewPieceAt(int file,int rank,Pieces piece) {
		board[file][rank] = new Board(new Location(file,rank),piece);
	}
	
	private void Turn(char player) {
		
		print.clear();
		
		String input = null;
		String color = (player == 'b') ? "black" : "white"; 
		
		print.print();
		
		boolean isChecked = isChecked(player);
		isCheckmateOrStalemate(player,isChecked);
		
		System.out.println(color+" move: ");
		Board[][] oldBoard = move.cloning(board);
		input = scan.nextLine();
		if(!coordinateMove(input,player) || isChecked) {
			move.reverseMove(oldBoard);
			System.out.println("Invalid Move");
			Turn(player);
		}
		resetEnPassantEveryPawn();

	}

	private void resetEnPassantEveryPawn() {
		if(this.lastMovedLoc!=null) {
			int file=this.lastMovedLoc.getFile();
			int rank = this.lastMovedLoc.getRank();
			if(isBoardNull(file, rank)) {
				if(isPawn(file, rank))
				{
					 ((Pawn)board[file][rank].getPiece()).setMove2FilesFalse();
				}
			}
		
		}
		int tempFile=tempMovedLoc.getFile();
		int tempRank=tempMovedLoc.getRank();
		this.lastMovedLoc = new Location(tempFile,tempRank);
	}

	private boolean isPawn(int file, int rank) {
		return board[file][rank].getPiece().isPawn(file,rank);
	}

	private boolean isBoardNull(int file, int rank) {
		return board[file][rank]!=null;
	}

	
	private boolean coordinateMove(String input,char player)  {		
		try {
			MoveCoordinate movLoc = new MoveCoordinate(input,this);
			this.tempMovedLoc = new Location(movLoc.getLocToFile(),movLoc.getLocToRank());
			return move.movingPiece(new Player(player),movLoc,true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	

	private void isCheckmateOrStalemate(char player , boolean isChecked) {
		String colorOpp = (player == 'b') ? "white" : "black";
		boolean noAnyLegalMove = !anyLegalMoveCheck(player);
		
		if(isCheckmate(player,noAnyLegalMove,isChecked)) {
			System.out.println(colorOpp +" Win!");
			System.exit(0);
		}
		if(isStalemate(player, noAnyLegalMove,isChecked)) {
			System.out.println("Draw");
			System.exit(0);
		};
	}


	public boolean isCheckmate(char player,boolean noAnyLegalMove,boolean isChecked) {
		return noAnyLegalMove && isChecked;
	}


	public boolean isStalemate(char player, boolean noAnyLegalMove,boolean isChecked) {
		return noAnyLegalMove && !isChecked;
	}
	
	public boolean isChecked(char player){
        Location kingPos = kingPosition(player);
        int file = kingPos.getFile();
        int rank = kingPos.getRank();
        for(int i = 1; i<board.length; i++){
            for(int j = 1; j<board[0].length; j++){
                if(board[i][j] != null){
                    if(board[i][j].canMove(new MoveCoordinate(new Location(i,j), new Location(file,rank)),false) && 
                    		board[i][j].getColor() != player){
                    	return true;
                    }
                }
            }
        }
        return false;
    }
	
	private Location kingPosition(char player) {
		int file = 0;
		int rank = 0;
		
		for(int i = 8 ; i > 0 ; i--) {
			
			for(int j = 1 ; j < 9 ; j++) {
				
				if(board[i][j] != null && move.isKing(i, j) && board[i][j].getColor() == player) {
					file=i;
					rank=j;
					break;
				}
				
			}

		}
		
		return new Location(file,rank);
	}

	
    private boolean anyLegalMoveCheck(char color){
    	Board[][] oldBoard = move.cloning(board);
        for(int x = 1; x<board.length-1; x++){
            for(int y = 1; y<board[0].length-1; y++){
                for(int w = 1; w<board.length-1; w++){
                    for(int z = 1; z<board[0].length-1; z++){
                        try{
                            if(isBoardNull(y, x)){
                            	MoveCoordinate mc = new MoveCoordinate(y,x,z,w,this);
                                if(board[y][x].getColor()==color){
                                	if(board[z][w]==null) {
                                        if(isLegalMove(color, oldBoard, mc)) return true;
                                	}else if(board[z][w].getColor()!=color) {
                                		if(isLegalMove(color, oldBoard, mc)) return true;
                                	}
                                }
                            }
                            move.reverseMove(oldBoard);
                        } catch(Exception e){
                        	move.reverseMove(oldBoard);
                        }
                    }
                }
            }
        }
        move.reverseMove(oldBoard);
        return false;
    }

	private boolean isLegalMove(char color, Board[][] oldBoard, MoveCoordinate mc) {
		if(move.movingPiece(new Player(color),mc,false) && !isChecked(color)) {
                            
			move.reverseMove(oldBoard);
		        return true;
		}
		move.reverseMove(oldBoard);
		return false;
	}

}
