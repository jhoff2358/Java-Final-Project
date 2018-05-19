import java.util.ArrayList;

public class Solver{
    public static void solve(Box[][] boxes, int rows, int cols){
        int currX = 0;
        int currY = 0;
        int count = 0;
        long time = System.currentTimeMillis();
        while (currY <= 8) {
            Box currBox = boxes[currX][currY];
            while (!boxes[currX][currY].changeable) {
                currX++;
                if (currX > 8) {
                    currY++;
                    currX = 0;
                }
                if (currY > 8) break;
                currBox = boxes[currX][currY];
            }
            if (currBox.valueOfText == 0) {
                currBox.valueOfText = 1;
                continue;
            }
            if (checkRow(currBox, boxes) && checkCol(currBox, boxes) && checkCell(currBox, boxes)) {
                currX++;
                if (currX > 8) {
                        currY++;
                        currX = 0;
                }
            } else {
                currBox.valueOfText++;
                while (currBox.valueOfText > 9) {
                    currBox.valueOfText = 0;
                    currX--;
                    if (currX < 0) {
                            currY--;
                            currX = 8;
                    }
                    currBox = boxes[currX][currY];
                    while (!currBox.changeable) {
                        currX--;
                        if (currX < 0) {
                            currY--;
                            currX = 8;
                        }
                        currBox = boxes[currX][currY];
                    }
                    if (currX < 0) {
                        currX = 8;
                        currY--;
                    }
                    currBox = boxes[currX][currY];
                    currBox.valueOfText++;
                }
            }
            count++;
            //System.out.println(count);
            //Frame.frame.printThing(boxes);
        }
        System.out.println("This took " + (double)(System.currentTimeMillis() - time) / 1000 + " seconds to complete."); 
        Frame.lastStep(boxes);
    }
    public static boolean checkRow(Box box, Box[][] boxes) {
        int curr = box.valueOfText;
        for (int i = 0; i < 9; i++) {
            if (i == box.row) continue;
            if (boxes[i][box.col].valueOfText == curr) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkCol(Box box, Box[][] boxes) {
        int curr = box.valueOfText;
        for (int i = 0; i < 9; i++) {
            if (i == box.col) continue;
            if (boxes[box.row][i].valueOfText == curr) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkCell(Box box, Box[][] boxes) {
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
}
