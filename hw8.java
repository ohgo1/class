/************************************************************
* Gabriel Lopez
* Programming Languages 4430
* Homework 8- Cracker Barrel Puzzle Java
************************************************************/

import java.io.*;
import java.util.*;


public class hw8
{

 private static ArrayList<int[]> endlist = new ArrayList<int[]>(13);	// The final set of moves

 private final static int[][] MOVES = new int[][]
 {
 // The list of possible moves

  new int[]{ 0, 1, 3 },		new int[]{3,1,0},
  new int[]{ 0, 2, 5 }, 	new int[]{5,2,0},
  new int[]{ 1, 3, 6 },		new int[]{6,3,1},
  new int[]{ 1, 4, 8 },		new int[]{8,4,1},
  new int[]{ 2, 4, 7 },		new int[]{7,4,2},
  new int[]{ 2, 5, 9 },		new int[]{9,5,2},
  new int[]{ 3, 4, 5 },		new int[]{5,4,3},
  new int[]{ 3, 6, 10 },	new int[]{10,6,3},
  new int[]{ 3, 7, 12 },	new int[]{12,7,3},
  new int[]{ 4, 7, 11 },	new int[]{11,7,4},
  new int[]{ 4, 8, 13 },	new int[]{13,8,4},
  new int[]{ 5, 8, 12 },	new int[]{12,8,5},
  new int[]{ 5, 9, 14 }, 	new int[]{14,9,5},
  new int[]{ 6, 7, 8 },		new int[]{8,7,6},
  new int[]{ 7, 8, 9 },		new int[]{9,8,7},
  new int[]{ 10, 11, 12 },	new int[]{12,11,10},
  new int[]{ 11, 12, 13 },	new int[]{13,12,11},
  new int[]{ 12, 13, 14 },	new int[]{14,13,12}
 };




public static void main(String[] args) {


 int[] board = new int[15]; 
 ArrayList<Integer> fillP = new ArrayList<Integer>();
 ArrayList<Integer> freeP = new ArrayList<Integer>();
 ArrayList<int[]> moves = new ArrayList<int[]>();
 int numPegs = 0;
 
for (int j=0; j<15; j++)
		{
			fillP.add(j);				// set all of the filled spots to the index
			board[j]= 0;				// set these indexes to default at 0
		}

 for(int i=0;i<15;i++)
		{  
			board[i] = 1;   			// set all spots to 1
			fillP.add(i);  				// add all the 1 indexes to filled			

		}
		
	board[0] = 0;						// set the starting spot to 0
	fillP.remove(Integer.valueOf(0));
	freeP.add(0);						// add the starting spot to free

	
	

	
	for(int i=0;i<5;i++)
	{
		board[i]= 0;
		fillP.remove(Integer.valueOf(i));
		freeP.add(i);
		
		move(board,moves,fillP,freeP,numPegs);
			
				for(int j=0;j<14;j++)
				{
					//board[endlist.get(j)[0]]= 1;
					//board[endlist.get(j)[1]]= 1;
					//board[endlist.get(j)[2]]= 0;
					
				}
				   //Print out the steps to the solution
					System.out.println("    "+board[0]+"    ");
					System.out.println("   "+board[1]+" "+board[2]+"   ");
					System.out.println("  "+board[3]+" "+board[4]+" "+board[5]+"  ");
					System.out.println(" "+board[6]+" "+board[7]+" "+board[8]+" "+board[9]+" ");
					System.out.println(board[10]+" "+board[11]+" "+board[12]+" "+board[13]+" "+board[14]+"\n");
			
	}
					// Print out the solution
					System.out.println("\nSolution\n\n");
					System.out.println("    "+board[0]+"    ");
					System.out.println("   "+board[1]+" "+board[2]+"   ");
					System.out.println("  "+board[3]+" "+board[4]+" "+board[5]+"  ");
					System.out.println(" "+board[6]+" "+board[7]+" "+board[8]+" "+board[9]+" ");
					System.out.println(board[10]+" "+board[11]+" "+board[12]+" "+board[13]+" "+board[14]+"\n");
}

public static int move(int[] gameboard, ArrayList<int[]> moveslist, ArrayList<Integer> filledPegs, ArrayList<Integer> freePegs, int ctr)
{
	int[] tempBoard  = new int[15];											// Temp variables for the board, free, filled spaces, and movelist
	ArrayList<Integer> tempFilled  = new ArrayList<Integer>(filledPegs);	
	ArrayList<Integer> tempFree  = new ArrayList<Integer>(freePegs);		
	ArrayList<int[]> tempMlist  = new ArrayList<int[]>(moveslist);			
	int tempCtr = ctr;



   
        if(ctr==13)
        {
			endlist = new ArrayList<int[]>(moveslist);		//if there is a solution, return
            return 1;
        }


        for (int j=0; j<36;j++)
        {

            if(filledPegs.contains(MOVES[j][0])&&filledPegs.contains(MOVES[j][1])&&freePegs.contains(MOVES[j][2]))
            {

                tempCtr++;
                tempMlist.add(MOVES[j]);	//from, over, to
				tempFilled.remove(Integer.valueOf(MOVES[j][0]));  	// remove the jumping piece
				tempFilled.remove(Integer.valueOf(MOVES[j][1]));	// remove the jumped piece
				tempFree.add(MOVES[j][0]);							// add the jumping piece to free list
				tempFree.add(MOVES[j][1]);							// add the jumped piece to the free spot list
				tempFree.remove(Integer.valueOf(MOVES[j][2]));		// remove the previously free spot from the free list
				tempFilled.add(MOVES[j][2]);						// add that same spot to the filled list
				

                if(move(tempBoard,  tempMlist, tempFilled, tempFree, tempCtr)==1)
                {
                    return 1;
                }
            }
        }


        return 0;
    
}
}
