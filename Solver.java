import java.util.ArrayList;

public class Solver{
    static Box[][] boxes = Main.boxes;
    public static void solve(Box[][] boxes, int rows, int cols){
        
        int currX = 0;
        int currY = 0;
        while (currX <= 8) {
            
            System.out.println("X: " + currX + "Y: " + currY);
            Box currBox = boxes[currX][currY];
            while (!boxes[currX][currY].changeable) {
                if (currX > 8) {
                    currY++;
                    currX = 0;
                }
                currX++;
            }
            if (currBox.valueOfText == 0) currBox.valueOfText = 1;
            if (checkRow(currBox) && checkCol(currBox) && checkCell(currBox)) {
                currX++;
                if (currX > 8) {
                        currY++;
                        currX = 0;
                }
            } else {
                currBox.valueOfText++;
                if (currBox.valueOfText == 10) {
                    currBox.valueOfText = 0;
                    while (!boxes[currX][currY].changeable) {
                        if (currX < 0) {
                            currY--;
                            currX = 8;
                        }
                        currX--;
                    }
                    currX--;
                    if (currX < 0) {
                        currX = 8;
                        currY--;
                    }
                }
            }
            Frame.update(boxes);
        }
        System.out.println("Solved");
        Print(boxes, 9, 9);
    }
    public static boolean checkRow(Box box) {
        int curr = box.valueOfText;
        for (int i = 0; i < 9; i++) {
            if (i == box.row) continue;
            if (boxes[i][box.col].valueOfText == curr) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkCol(Box box) {
        int curr = box.valueOfText;
        for (int i = 0; i < 9; i++) {
            if (i == box.col) continue;
            if (boxes[box.row][i].valueOfText == curr) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkCell(Box box) {
        int curr = box.valueOfText;
        int cellRow = (box.row/3)*3;
        int cellCol = (box.col/3)*3;
        for (int i = cellRow; i < cellRow + 3; i++) {
            for (int j = cellCol; j < cellCol + 3; j++) {
                if (i == box.row && j == box.col) continue;
                if (boxes[i][j].valueOfText == curr) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] intersection(Box box, int[] row, int[] col, int[] cell){
        int[] intersect = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for(int i = 0; i < row.length; i++){
            if(row[i] == col[i] && col[i] == cell[i] && box.valueOfText == 0){
                intersect[i] = col[i];
            }
        }
        return intersect;
    }
    
    public static void Print(Box[][] boxes, int rows, int cols){
        System.out.println();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(boxes[i][j].valueOfText + " ");
            }
            System.out.println();
        }
    }
}
