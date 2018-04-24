import java.util.ArrayList;

public class Solver{
    public static void solve(){
    }
    
    public static int[] checkRow(Box box) {
        int[] output = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = box.index - box.col; i < box.index-box.col+9; i++) {
            if (!Main.boxes[i].valueOfText.equals("")) {
                output[Main.boxes[i].valueOfText-1] = 0;
            }
            
        }
        return output;
    }
    
    public static int[] checkCol(Box box) {
        int[] output = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = box.col; i < 80 - (9 - box.col); i+=9) {
            output[Main.boxes[i].valueOfText-1] = 0;
            
        }
        return output;
    }
    
    public static int[] checkCell(Box box) { //TOMORRRROOOWOW
        int[] output = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = box.index - box.col; i < box.index-box.col+9; i++) {
            output[Main.boxes[i].valueOfText-1] = 0;
            
        }
        return output;
    }
}
