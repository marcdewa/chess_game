[33mcommit de78d4de21fac63314f77e9f5173d8f43dbde026[m[33m ([m[1;36mHEAD -> [m[1;32mmaster[m[33m, [m[1;31morigin/master[m[33m)[m
Author: Marcellino <marc_dewa@yahoo.com>
Date:   Thu Apr 2 02:44:36 2020 +0700

    all piece regular moves complete

[1mdiff --git a/src/chessEntities/Bishop.java b/src/chessEntities/Bishop.java[m
[1mindex 25934a4..5e16a92 100644[m
[1m--- a/src/chessEntities/Bishop.java[m
[1m+++ b/src/chessEntities/Bishop.java[m
[36m@@ -18,6 +18,15 @@[m [mpublic class Bishop extends Pieces {[m
 			return false;[m
 		}[m
 		[m
[32m+[m		[32mif(!jumpOverPieceCheck(locFrom, locTo, board)) {[m
[32m+[m			[32mreturn false;[m
[32m+[m		[32m}[m
[32m+[m[41m		[m
[32m+[m		[32mreturn true;[m
[32m+[m[41m		[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mprivate boolean jumpOverPieceCheck(PiecesLocation locFrom, PiecesLocation locTo, Position[][] board) {[m
 		int fileOffSet =(locFrom.getFile() < locTo.getFile()) ? 1:-1;[m
 		int rankOffSet = (locFrom.getRank() < locTo.getRank()) ? 1:-1;[m
 		//System.out.println(fileOffSet);[m
[36m@@ -31,10 +40,7 @@[m [mpublic class Bishop extends Pieces {[m
 			}[m
 			[m
 			y += rankOffSet;[m
[31m-		}[m
[31m-		[m
[31m-		return true;[m
[31m-		[m
[32m+[m		[32m} return true;[m
 	}[m
 [m
 	private boolean notMovingDiagonally(PiecesLocation locFrom, PiecesLocation locTo) {[m
[1mdiff --git a/src/chessEntities/King.java b/src/chessEntities/King.java[m
[1mindex 3fce804..24b533c 100644[m
[1m--- a/src/chessEntities/King.java[m
[1m+++ b/src/chessEntities/King.java[m
[36m@@ -10,6 +10,9 @@[m [mpublic class King extends Pieces {[m
 	[m
 	@Override[m
 	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo,Position[][] board) {[m
[32m+[m		[32mif(fileDifferenceIsEqualsTo(1,locFrom,locTo) ||rankDifferenceIsEqualsTo(1,locFrom,locTo) ) {[m
[32m+[m			[32mreturn true;[m
[32m+[m		[32m}[m
 		return false;[m
 	}[m
 }[m
[1mdiff --git a/src/chessEntities/Knight.java b/src/chessEntities/Knight.java[m
[1mindex dd70ea9..0bd15bb 100644[m
[1m--- a/src/chessEntities/Knight.java[m
[1m+++ b/src/chessEntities/Knight.java[m
[36m@@ -12,11 +12,11 @@[m [mpublic class Knight extends Pieces {[m
 	@Override[m
 	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo,Position[][] board) {[m
 		[m
[31m-		if(Math.abs(locTo.getFile() - locFrom.getFile()) == 2 && Math.abs(locTo.getRank() - locFrom.getRank()) == 1){[m
[32m+[m		[32mif(fileDifferenceIsEqualsTo(2,locFrom,locTo) && rankDifferenceIsEqualsTo(1,locFrom,locTo)){[m
 			return true;[m
 		}[m
 		[m
[31m-		if(Math.abs(locTo.getFile() - locFrom.getFile()) == 1 && Math.abs(locTo.getRank() - locFrom.getRank()) == 2){[m
[32m+[m		[32mif(fileDifferenceIsEqualsTo(1,locFrom,locTo)&& rankDifferenceIsEqualsTo(1,locFrom,locTo)){[m
 			return true;[m
 		}[m
 		[m
[1mdiff --git a/src/chessEntities/Pawn.java b/src/chessEntities/Pawn.java[m
[1mindex 099d8ba..efde258 100644[m
[1m--- a/src/chessEntities/Pawn.java[m
[1m+++ b/src/chessEntities/Pawn.java[m
[36m@@ -11,11 +11,25 @@[m [mpublic class Pawn extends Pieces {[m
 [m
 	@Override[m
 	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo,Position[][] board) {[m
[31m-		[m
[31m-        if ( fileDifferenceIsEqualsTo(1,locFrom,locTo)[m
[31m-                && rankDifferenceIsEqualsTo(0,locFrom,locTo)) {[m
[32m+[m
[32m+[m[32m        if(isTakingPiece(locFrom, locTo, board)) {[m
[32m+[m[41m        [m	[32mreturn true;[m
[32m+[m[32m        }[m[41m        [m
[32m+[m[32m        else if(moveTwoFiles(locFrom, locTo)) {[m
[32m+[m[41m        [m	[32mreturn true;[m
[32m+[m[32m        }[m
[32m+[m[32m        else if(moveOneFile(locFrom, locTo, board)) {[m
[32m+[m[41m        [m	[32mreturn true;[m
[32m+[m[32m        }[m
[32m+[m
[32m+[m		[32mreturn false;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mprivate boolean moveOneFile(PiecesLocation locFrom, PiecesLocation locTo, Position[][] board) {[m
[32m+[m		[32mif ( fileDifferenceIsEqualsTo(1,locFrom,locTo)[m
[32m+[m[32m                && rankDifferenceIsEqualsTo(0,locFrom,locTo) && board[locTo.getFile()][locFrom.getFile()]==null) {[m
             if (this.player == 'w') {[m
[31m-                if (locFrom.getFile() < locTo.getFile()) {[m
[32m+[m[32m                if ((locFrom.getFile() < locTo.getFile()) ) {[m
                	[m
                     return true;[m
                 }[m
[36m@@ -26,9 +40,11 @@[m [mpublic class Pawn extends Pieces {[m
                     return true;[m
                 }[m
             }[m
[31m-        }[m
[31m-        [m
[31m-        if (fileDifferenceIsEqualsTo(2,locFrom,locTo)[m
[32m+[m[32m        }return false;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mprivate boolean moveTwoFiles(PiecesLocation locFrom, PiecesLocation locTo) {[m
[32m+[m		[32mif (fileDifferenceIsEqualsTo(2,locFrom,locTo)[m
                 && rankDifferenceIsEqualsTo(0,locFrom,locTo)[m
                 && isFirstTurn(locFrom)) {[m
 [m
[36m@@ -44,10 +60,30 @@[m [mpublic class Pawn extends Pieces {[m
                     return true;[m
                 }[m
             }[m
[32m+[m[41m            [m
[32m+[m[32m        }return false;[m
[32m+[m	[32m}[m
 [m
[32m+[m	[32mprivate boolean isTakingPiece(PiecesLocation locFrom, PiecesLocation locTo, Position[][] board) {[m
[32m+[m		[32mif((rankDifferenceIsEqualsTo(1,locFrom,locTo) &&[m[41m [m
[32m+[m[41m        [m	[32mfileDifferenceIsEqualsTo(1,locFrom,locTo)) &&[m[41m [m
[32m+[m[41m        [m	[32mboard[locTo.getFile()][locTo.getRank()] != null) {[m
[32m+[m[41m        [m	[32m if (this.player == 'w') {[m
[32m+[m[32m                 if ((locFrom.getFile() < locTo.getFile()) ) {[m
[32m+[m[41m                	[m
[32m+[m[32m                     return true;[m
[32m+[m[32m                 }[m
[32m+[m[32m             }[m
[32m+[m[41m          [m
[32m+[m[32m             if (this.player == 'b') {[m
[32m+[m[32m                 if (locFrom.getFile() > locTo.getFile()) {[m
[32m+[m[32m                     return true;[m
[32m+[m[32m                 }[m
[32m+[m[32m             }[m
[32m+[m[41m             [m
[32m+[m[41m        	[m
         }[m
[31m-        [m
[31m-		return false;[m
[32m+[m[32m        return false;[m
 	}[m
 	[m
 	public boolean isFirstTurn(PiecesLocation locFrom) {[m
[1mdiff --git a/src/chessEntities/Queen.java b/src/chessEntities/Queen.java[m
[1mindex 7daf156..808f29b 100644[m
[1m--- a/src/chessEntities/Queen.java[m
[1m+++ b/src/chessEntities/Queen.java[m
[36m@@ -10,7 +10,7 @@[m [mpublic class Queen extends Pieces {[m
 	[m
 	@Override[m
 	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo,Position[][] board) {[m
[31m-		return false;[m
[32m+[m		[32mreturn new Rook(this.player).canMove(locFrom, locTo,board) || new Bishop(this.player).canMove(locFrom, locTo,board);[m
 		[m
 	}[m
 }[m
\ No newline at end of file[m
[1mdiff --git a/src/chessEntities/Rook.java b/src/chessEntities/Rook.java[m
[1mindex 344f8f3..4248881 100644[m
[1m--- a/src/chessEntities/Rook.java[m
[1m+++ b/src/chessEntities/Rook.java[m
[36m@@ -11,27 +11,25 @@[m [mpublic class Rook extends Pieces {[m
 	@Override[m
 	public boolean canMove(PiecesLocation locFrom,PiecesLocation locTo,Position[][] board) {[m
 		[m
[32m+[m[41m		[m
 		if(locFrom.getFile() != locTo.getFile() && locFrom.getRank() != locTo.getRank()){[m
 			[m
 			return false;[m
 		}[m
 		[m
[31m-		int offset;[m
[31m-		[m
[31m-		if(locFrom.getFile() != locTo.getFile()){[m
[31m-			[m
[31m-			offset = (locFrom.getFile() < locTo.getFile())? 1: -1;[m
[31m-			[m
[31m-			for(int x = locFrom.getFile() + offset; x != locTo.getFile(); x += offset){[m
[31m-				//System.out.println(x+""+""+locFrom.getRank());[m
[31m-				if(board[x][locFrom.getRank()] != null){[m
[31m-					return false;[m
[31m-				}[m
[31m-			}[m
[32m+[m		[32mif(!jumpOverPieceRowCheck(locFrom, locTo, board)) {[m
[32m+[m	