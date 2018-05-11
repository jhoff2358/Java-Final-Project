import javax.swing.*;

public class Box{
    public int width = 9, height = 9;
    public int cellNum, row, col, valueOfText;
    public int[] rowPos, colPos, cellPos, intersect;
    public Box(JTextField t, int row, int col){
        row = row;
        col = col;
        cellNum = 3 * ((int)(row / 3)) + (int)(col / 3);
        if(!t.getText().equals("")){
            valueOfText = Integer.parseInt(t.getText());
        } else {
            valueOfText = 0;
        }
    }
}
