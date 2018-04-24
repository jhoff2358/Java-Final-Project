import javax.swing.*;

public class Box extends JTextField{
    private int index, width = 9, height = 9;
    public int cellNum, row, col, valueOfText;
    public Box(JTextField t, int index){
        this.index = index;
        row = (int)(index / width);
        col = index % width;
        cellNum = 3 * ((int)(row / 3)) + (int)(col / 3);
        valueOfText = Integer.parseInt(t.getText());
    }
}
