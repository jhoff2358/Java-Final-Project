import java.util.ArrayList;

public class Solver{
    public static void solve(Box[][] boxes, int rows, int cols){
        do{
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    boxes[i][j].rowPos = checkRow(boxes[i][j]);
                    boxes[i][j].colPos = checkCol(boxes[i][j], boxes);
                    boxes[i][j].cellPos = checkCell(boxes[i][j], boxes);
                    if(boxes[i][j].valueOfText == 0){
                        boxes[i][j].intersect = intersection(boxes[i][j], boxes[i][j].rowPos, boxes[i][j].colPos, boxes[i][j].cellPos);
                    }
            }
        }
            complete(boxes);
        } while(!isSolved(boxes));
        System.out.println();
        System.out.println("Completed!!!");
        Print(boxes, rows, cols);
    }
    public static int[] checkRow(Box box) {
        int[] output = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 9; i++) {
            if (Main.boxes[box.row][i].valueOfText != 0) {
                output[Main.boxes[box.row][i].valueOfText - 1] = 0;
            }
        }
        return output;
    }
    public static int[] checkCol(Box box, Box[][] boxes) {
        int[] output = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < boxes[0].length; i++) {
            if (Main.boxes[i][box.col].valueOfText != 0) {
                output[Main.boxes[i][box.col].valueOfText - 1] = 0;
            }
        }
        return output;
    }
    public static int[] checkCell(Box box, Box[][] boxes) {
        int[] output = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int cellN = box.cellNum;
        for (int i = 0; i < boxes.length - 1; i++){
            for(int j = 0; j < boxes[0].length - 1; j++){
                if(boxes[i][j].cellNum == cellN){
                    if (Main.boxes[i][j].valueOfText != 0) {
                        output[boxes[i][j].valueOfText - 1] = 0;
                    }
                }
            }
        }
        return output;
    }
    public static boolean isSolved(Box[][] boxes){
        int cellTot = 0, rowTot = 0, colTot = 0, k = 1;
        for(int j = 0; j < boxes.length; j++){
            for(int i = 0; i < boxes[0].length; i++){
                if(boxes[i][j].cellNum == k){
                    cellTot += boxes[i][j].valueOfText;
                }
                if(boxes[i][j].row == k){
                    rowTot += boxes[i][j].valueOfText;
                }
                if(boxes[i][j].col == k){
                    colTot += boxes[i][j].valueOfText;
                }
            }
            k++;
            if(cellTot != 45) return false;
            if(rowTot != 45) return false;
            if(colTot != 45) return false;
            cellTot = 0;
            rowTot = 0; 
            colTot = 0;
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
    public static void complete(Box[][] boxes){
        int count = 0, num = -1;
        for(int i = 0; i < boxes.length; i++){
            for(int j = 0; j < boxes[0].length; j++){
                if(boxes[i][j].intersect == null) continue;
                for(j = 0; j < boxes[i][j].intersect.length; j++){
                    if(boxes[i][j].intersect[j] != 0){
                        count++;
                        num = j;
                    }
                }
                if(count == 1) boxes[i][j].valueOfText = boxes[i][j].intersect[num];
                count = 0;
            }
        }
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
