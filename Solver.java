import java.util.ArrayList;

public class Solver{
    public static void solve(Box[] boxes){
        do{
            for(int i = 0; i < boxes.length; i++){
                boxes[i].rowPos = checkRow(boxes[i]);
                boxes[i].colPos = checkCol(boxes[i], boxes);
                boxes[i].cellPos = checkCell(boxes[i], boxes);
                if(boxes[i].valueOfText == 0){
                    boxes[i].intersect = intersection(boxes[i], boxes[i].rowPos, boxes[i].colPos, boxes[i].cellPos);
                }
            }
            complete(boxes);
        } while(!isSolved(boxes));
        System.out.println();
        System.out.println("Completed!!!");
        Print(boxes);
    }
    public static int[] checkRow(Box box) {
        int[] output = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = box.index - box.col; i < box.index-box.col+9; i++) {
            if (Main.boxes[i].valueOfText != 0) {
                output[Main.boxes[i].valueOfText - 1] = 0;
            }
        }
        return output;
    }
    public static int[] checkCol(Box box, Box[] boxes) {
        int[] output = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < boxes.length; i++) {
            if(boxes[i].col == box.col){
                if (Main.boxes[i].valueOfText != 0) {
                    output[Main.boxes[i].valueOfText - 1] = 0;
                }
            }
        }
        return output;
    }
    public static int[] checkCell(Box box, Box[] boxes) {
        int[] output = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int cellN = box.cellNum;
        for (int i = 0; i < boxes.length; i++) {
            if(boxes[i].cellNum == cellN){
                if (Main.boxes[i].valueOfText != 0) {
                    output[boxes[i].valueOfText - 1] = 0;
                }
            }
        }
        return output;
    }
    public static boolean isSolved(Box[] boxes){
        int cellTot = 0, rowTot = 0, colTot = 0;
        for(int j = 0; j < 9; j++){
            for(int i = 0; i < boxes.length; i++){
                if(boxes[i].cellNum == j){
                    cellTot += boxes[i].valueOfText;
                }
                if(boxes[i].row == j){
                    rowTot += boxes[i].valueOfText;
                }
                if(boxes[i].col == j){
                    colTot += boxes[i].valueOfText;
                }
            }
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
    public static void complete(Box[] boxes){
        int count = 0, j, num = -1;
        for(int i = 0; i < boxes.length; i++){
            if(boxes[i].intersect == null) continue;
            for(j = 0; j < boxes[i].intersect.length; j++){
                if(boxes[i].intersect[j] != 0){
                    count++;
                    num = j;
                }
            }
            if(count == 1) boxes[i].valueOfText = boxes[i].intersect[num];
            count = 0;
        }
    }
    public static void Print(Box[] boxes){
        System.out.println();
        for(int i = 0; i < boxes[0].rowPos.length; i++){
            for(int j = 0; j < boxes[0].rowPos.length; j++){
                System.out.print(boxes[9 * i + j].valueOfText + " ");
            }
            System.out.println();
        }
    }
}
