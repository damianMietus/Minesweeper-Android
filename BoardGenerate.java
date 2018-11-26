package comdamianmietus.httpsgithub.minesweep;

import java.util.Random;

public class BoardGenerate extends MainActivity {


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


        for (int i = 0;  i < x; i++){
            for (int j = 0; j < y; j++){
                adjMines = 0;

                if (arr[i][j].value != -1){



                }
            }
        }

        return arr;
    }


}
