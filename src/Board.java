import java.util.*;
public class Board {
	
       static String[][] values = new String[8][8];
       boolean isRunning = true;
       Scanner nextMove = new Scanner(System.in);
       HashMap <Integer,Pawn> pi = new HashMap();
    
        Rook rook1  = new Rook();
   		Rook rook2  = new Rook();
   	
    //////////////////////////////////Initiate the game and create the pieces///////////////////////////////////////////////

     
    public void initiatePieces() {
    	//declare pieces

    	for(int i=1; i<=8; i++) {
        	pi.put(i, new Pawn());
        }
    	
    	
    	for (int i = 0; i<values.length; i++) {
     	   for (int j = 0; j<values.length; j++) {
     		   values[i][j] = "X";
             }

         }
    	
    	//Put pieces in place
    	
    	
    	
    	for(int i=1; i<=8; i++) {
    		pi.get(i).currentPositionX = 1;
    		pi.get(i).currentPositionY = i-1;
    	}
    	
    	
    	for(int i=1; i<=8; i++) {
    		int pX = pi.get(i).currentPositionX;
    		int pY = pi.get(i).currentPositionY;
    		values[pX][pY] = "P";
    	}
    	
    	int r1X = rook1.currentPositionX = 0;
    	int r1Y = rook1.currentPositionY = 0;
    	values[r1X][r1Y] = "R";
    	
    	int r2X = rook2.currentPositionX = 0;
    	int r2Y = rook2.currentPositionY = 7;
    	values[r2X][r2Y] = "R";
    	

        for (int i = 0; i < values.length; i++) {

             for (int j = 0; j < values.length; j++) {

                 if(j == 7) {

                 System.out.print(values[i][j] + "\n");

                 } else {

                     System.out.print(values[i][j]);

                 }

             }

         }

    }

   

    //////////////////////////////////Player prompt and player decision///////////////////////////////////////////////  

public void playerMove() {
	
	HashMap <Integer, Integer> choices = new HashMap();
	for (int i = 1; i <= 8; i++) {
		choices.put(i,i);
	}

       while(isRunning) {
    	    System.out.println("\n which piece do you want to move? \n 1=Pawn \n 2=Rook");
            int answer = nextMove.nextInt();
            
            //////////////////////Pawns//////////////////////////////
            if (answer == 1) {
            System.out.println("Which Pawn would you like to move? (1-9)");
            int answer2 = nextMove.nextInt();
            
            int piece = choices.get(answer2);
                int pX = pi.get(piece).currentPositionX;
                int pY = pi.get(piece).currentPositionY;
                values[pX][pY] = "X";
                pi.get(piece).move();
                pX = pi.get(piece).currentPositionX;
                pY = pi.get(piece).currentPositionY;
                values[pX][pY] = "P";
                draw();
                pi.get(piece).moveCheck();	
            }
   				
            ////////////////////////Rooks//////////////////////////////
            if (answer == 2) {
            	System.out.println("Which Rook would you like to move? (1-2)");
            	int answer2 = nextMove.nextInt();
            		if (answer2 == 1) {
            			int rX = rook1.currentPositionX;
            			int rY = rook1.currentPositionX;
            			values[rX][rY] = "X";
            			rook1.move();
            			 rX = rook1.currentPositionX;
            			 rY = rook1.currentPositionY; 
            			 values[rX][rY] = "R";
            			 draw();
            			 rook1.moveCheck();
            		}
            }
            
       }

    }

public void draw() {
	for (int i = 0; i < values.length; i++) {

            for (int j = 0; j < values.length; j++) {

                if(j == 7) {

                System.out.print(values[i][j] + "\n");

                } else {

                    System.out.print(values[i][j]);

                }

            }

        }      

        }
}
