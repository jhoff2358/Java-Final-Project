import java.util.ArrayList;

public class Solver{
    public static void solve(Box[] boxes){
        do{
            for(int i = 0; i < boxes.length; i++){
                boxes[i].rowPos = checkRow(boxes[i]);
                boxes[i].colPos = checkCol(boxes[i]);
                boxes[i].cellPos = checkCell(boxes[i]);
                isOnlyNum(boxes[i].rowPos, boxes[i].colPos, boxes[i].cellPos);
            }
        } while(!isSolved(boxes));
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
            output[Main.boxes[i].valueOfText - 1] = 0;
        }
        return output;
    }
    public static int[] checkCell(Box box) { //TOMORRRROOOWOW
        int[] output = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = box.index - box.col; i < box.index-box.col+9; i++) {
            output[Main.boxes[i].valueOfText - 1] = 0;
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
    public static void isOnlyNum(int[] row, int[] col, int[] cell){
        
    }
}
