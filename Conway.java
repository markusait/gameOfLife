// Conways' Game of Life
// Main Class omitted so code can be copy pasted into processing ide directly 


import java.util.Random;
   //creting random Grid with variable cols and rows 
   public static boolean[][] random2DGrid(int cols, int rows) {
        Random rand = new Random();
        boolean[][] res = new boolean[rows][cols];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                int randomNum = rand.nextInt(2);
                if (randomNum == 1) {
                    res[i][j] = true;
                } else {
                    res[i][j] = false;
                }
            }
        }
        return res;
    }

    //printing Grid in console 
    public static void print2DGrid(boolean[][] board) {
        int xLength = board.length;
        int yLength = board[0].length;
        boolean cell;
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                cell = board[i][j];
                if (cell) {
                    System.out.print("O");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
