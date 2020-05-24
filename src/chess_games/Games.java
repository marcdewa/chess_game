package chess_games;

import java.util.Scanner;

import chessEntities.*;


public class Games {
	Position[][] board ;
	Move move;
	BoardPrinter print;
	Scanner scan ;
	
	public Games() {
		print = new BoardPrinter(this);
		scan = new Scanner(System.in);
		board = new Position[10][10];
		move = new Move(board);
		defaultPieceLocation('b');
		defaultPieceLocation('w');
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
		board[file][rank] = new Position(new PiecesLocation(file,rank),piece);
	}
	
	public boolean coordinateMove(String input,char player)  {
		if(input.length() != 5) {
			System.out.println("invalid coordinate");
			return false;
		}
		
		try {
			MoveCoordinate movLoc = new MoveCoordinate(input,this);
			return move.movingPiece(player,movLoc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public void startGame() {
		while(true) {
			Turn('w');
			Turn('b');
		}
	}
	
	private void Turn(char player) {
		print.clear();
		String coor = null;
		String color = (player == 'b') ? "black" : "white"; 
		String colorOpp = (player == 'b') ? "white" : "black"; 
		print.print();
		if(move.isInCheck(player)) {
			if(move.checkmated(player)) {
				System.out.println(colorOpp +" Win!");
				System.exit(0);
			}else {
				System.out.println("Your king is in check");
			}
		}
		System.out.println(color+" move: ");
		coor = scan.nextLine();
		if(!coordinateMove(coor,player)) {
			Turn(player);
			
		}
		
	}

}
