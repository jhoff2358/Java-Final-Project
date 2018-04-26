import java.util.ArrayList;

public class Solver{
    public static void solve(Box[] boxes){
        do{
            for(int i = 0; i < boxes.length; i++){
                boxes[i].rowPos = checkRow(boxes[i]);
                boxes[i].colPos = checkCol(boxes[i]);
                boxes[i].cellPos = checkCell(boxes[i], boxes);
                if(boxes[i].valueOfText != 0){
                    isOnlyNum(boxes[i], boxes[i].rowPos, boxes[i].colPos, boxes[i].cellPos);
                }
            }
        } while(!isSolved(boxes));
        System.out.println("Completed");
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
    public static int[] checkCol(Box box) {
        int[] output = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = box.col; i < 80 - (9 - box.col); i+=9) {
            if (Main.boxes[i].valueOfText != 0) {
                output[Main.boxes[i].valueOfText - 1] = 0;
            }
        }
        return output;
    }
    public static int[] checkCell(Box box, Box[] boxes) { //TOMORRRROOOWOW
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
        boolean out = true;
        for(int i = 0; i < boxes.length; i++){
            if(boxes[i].rowPos.length != 0 && boxes[i].colPos.length != 0 && boxes[i].cellPos.length != 0){
                out = false;
                break;
            }
        }
        return out;
    }
    public static void isOnlyNum(Box box, int[] row, int[] col, int[] cell){
        boolean firstFound = false, secondFound = false;
        int index = -1;
        for(int i = 0; i < row.length; i++){
            if(row[i] == col[i] && col[i] == cell[i] && !firstFound){
                firstFound = true;
                index = i;
            } else if(row[i] == col[i] && col[i] == cell[i] && !secondFound){
                secondFound = true;
                break;
            }
        }
        if(firstFound && !secondFound && index != -1){
            box.valueOfText = row[index];
        }
    }
}
