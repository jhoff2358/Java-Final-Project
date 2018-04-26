import javax.swing.*;

public class Box extends JTextField{
    public int index, width = 9, height = 9;
    public int cellNum, row, col, valueOfText;
    public int[] rowPos, colPos, cellPos;
    public Box(JTextField t, int index){
        this.index = index;
        row = (int)(index / width);
        col = index % width;
        cellNum = 3 * ((int)(row / 3)) + (int)(col / 3);
        if(!t.getText().equals("")){
            valueOfText = Integer.parseInt(t.getText());
        } else {
            valueOfText = 0;
        }
    }
}
