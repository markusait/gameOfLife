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



    //helper function for countLivingNeighbors to apply boundaries roules
    public static int adjuster(int num, int limit) {
        if (num >= 0 && num <= limit) {
            return num;
        } else {
            if (num > limit) {
                return 0;
            } else {
                return limit;
            }
        }

    }
    //counting all 8 Neighbors of a cell in 2D Grid
    public static int countLivingNeighbors(boolean[][] board, int x, int y) {
        int dx;
        int dy;
        int xLength = board.length - 1;
        int yLength = board[0].length -1;
        int sum = 0;
        int[][] moves = {
                {-1, -1},
                {-1, 0},
                {-1, 1},
                {0, -1},
                {0, 1},
                {1, -1},
                {1, 0},
                {1, 1}
        };
        for (int i = 0; i < moves.length; i++) {
            dx = adjuster(x + moves[i][0], xLength - 1);
            dy = adjuster(y + moves[i][1], yLength -1);
            if(board[dx][dy]){
                ++sum;
            }
        }
        return sum;
    }
    //getting the next State of a Cell based on the given rules
    public static boolean getNextState(boolean[][] board, int x, int y) {
    int livingNeighbors = countLivingNeighbors(board, x, y);
    boolean cell = board[x][y];
    if (!cell && livingNeighbors == 3) {
        return true;
    } else if (cell && (livingNeighbors == 3 || livingNeighbors == 2)) {
        return true;
    } else {
        return false;
    	}
    }

    //calculating the next Gen based on the next State of each cell from previous board
    public static boolean[][] calculateNextGeneration(boolean[][] board){
        int xLength = board.length;
        int yLength = board[0].length;
        boolean[][] res = new boolean[xLength][yLength];
        for (int i = 0; i < xLength ; i++) {
            for (int j = 0; j < yLength ; j++) {
                res[i][j] = getNextState(board,i,j);
            }
        }
        return res;
    }
