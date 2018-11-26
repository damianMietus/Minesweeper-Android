//package comdamianmietus.httpsgithub.minesweep;

import java.util.Random;

public class BoardGenerate /*extends MainActivity*/ {


    public static class Mine {
        // - 1 is a mine, 0 is blank, any other number determines no. of mines
        int value;
        boolean flagged;
    }

    static Mine[][] generateBoard(Mine[][]arr, int totalMines, int x, int y){
        int minesInPlay = 0;
        int x1, y1;
        int adjMines = 0;
        Random rand = new Random();
        // Initialize everything to blank
        for (int i = 0;  i < x; i++){
            for (int j = 0; j < y; j++){
                arr[i][j] = new Mine();
                arr[i][j].value = 0;
                arr[i][j].flagged = false;
            }
        }

        do{
            //Get random coordinates
            x1 = rand.nextInt(x);
            y1 = rand.nextInt(y);
            //System.out.println(x1+ " "+y1);

            if (arr[x1][y1].value != -1){
                arr[x1][y1].value = -1;
                minesInPlay++;
            }

        }while(minesInPlay < totalMines);

        // Reloop to put numbers for mine amounts
        x1 = 0;
        y1 = 0;

        //Edge Case Top Left, do check if it isn't a mine
        if (arr[x1][y1].value != -1){
            if (arr[x1+1][y1].value == -1){
                arr[x1][y1].value++;
            }
            if (arr[x1][y1+1].value == -1){
                arr[x1][y1].value++;
            }
            if (arr[x1+1][y1+1].value == -1){
                arr[x1][y1].value++;
            }        
        }
        //Check Top row until Top right
        for (int i = 1; i < y-1; i++){
            //Check if it isn't a mine
            if (arr[0][i].value != -1){
                //Check left
                if (arr[0][i-1].value == -1){
                    arr[0][i].value++;
                }
                //Check down left
                if (arr[1][i-1].value == -1){
                    arr[0][i].value++;
                }
                //Check down
                if (arr[1][i].value == -1){
                    arr[0][i].value++;
                }            
                //Check down right
                if (arr[1][i+1].value == -1){
                    arr[0][i].value++;
                }                
                //Check right
                if (arr[0][i+1].value == -1){
                    arr[0][i].value++;
                }                  
            } 
        }// End of top row
        //Edge Case Top Right, do check if it isn't a mine
        x1 = 0;
        y1 = y-1;
        if (arr[x1][y1].value != -1){
            if (arr[x1+1][y1].value == -1){
                arr[x1][y1].value++;
            }
            if (arr[x1][y1-1].value == -1){
                arr[x1][y1].value++;
            }
            if (arr[x1+1][y1-1].value == -1){
                arr[x1][y1].value++;
            }        
        }
        
        // Go from Top right to bottom right
        y1 = y-1;
        for (int i = 1; i < x-1; i++){
            //Check if it isn't a mine
            if (arr[i][y1].value != -1){
                //Check up
                if (arr[i-1][y1].value == -1){
                    arr[i][y1].value++;
                }
                //Check up left
                if (arr[i-1][y1-1].value == -1){
                    arr[i][y1].value++;
                }
                //Check left
                if (arr[i][y1-1].value == -1){
                    arr[i][y1].value++;
                }
                //Check down left
                if (arr[i+1][y1-1].value == -1){
                    arr[i][y1].value++;
                }
                //Check down
                if (arr[i+1][y1].value == -1){
                    arr[i][y1].value++;
                }
            } 
        }// End of right column
       //Edge Case Bottom Right, do check if it isn't a mine
        x1 = x-1;
        y1 = y-1;
        if (arr[x1][y1].value != -1){
            // left
            if (arr[x1][y1-1].value == -1){
                arr[x1][y1].value++;
            }
            // up left
            if (arr[x1-1][y1-1].value == -1){
                arr[x1][y1].value++;
            }
            // up
            if (arr[x1-1][y1].value == -1){
                arr[x1][y1].value++;
            }        
        }        
 
        // Go from bottom left to bottom right
        
        y1 = 0;
        x1 = x-1;
        for (int i = 1; i < y-1; i++){
            //Check if it isn't a mine
            if (arr[x1][i].value != -1){
                //Check left
                if (arr[x1][i-1].value == -1){
                    arr[x1][i].value++;
                }
                //Check up left
                if (arr[x1-1][i-1].value == -1){
                    arr[x1][i].value++;
                }
                //Check up
                if (arr[x1-1][i].value == -1){
                    arr[x1][i].value++;
                }
                //Check up right
                if (arr[x1-1][i+1].value == -1){
                    arr[x1][i].value++;
                }
                //Check right
                if (arr[x1][i+1].value == -1){
                    arr[x1][i].value++;
                }
            } 
        }// End of right column       
        
        
        

        for (int i = 0;  i < x; i++){
            for (int j = 0; j < y; j++){
                adjMines = 0;

                if (arr[i][j].value != -1){



                }
            }
        }

        return arr;
    }
    
    
    public static void main(String []args){
        int x = 8;
        int y = 10;
        int numMines = 20;
         
        Mine[][] mineList = new Mine[x][y];
        mineList = generateBoard(mineList, numMines, x, y);
       
        for (int i = 0;  i < x; i++){
            for (int j = 0; j < y; j++){
                if (mineList[i][j].value == -1){
                    System.out.print("X");
                } else {
                    System.out.print(mineList[i][j].value);
                }
            }
            System.out.println();
        }
            
    }


}
