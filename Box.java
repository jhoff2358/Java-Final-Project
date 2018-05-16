import javax.swing.*;

public class Box{
    public int width = 9, height = 9;
    public int cellNum, row, col, valueOfText;
    public int[] rowPos, colPos, cellPos, intersect;
    public JTextField field;
    public boolean changeable;
    public Box(JTextField t, int row, int col){
        field = t;
        this.row = row;
        this.col = col;
        cellNum = 3 * ((int)(row / 3)) + (int)(col / 3);
        if(!field.getText().equals("")){
            valueOfText = Integer.parseInt(field.getText());
            changeable = false;
        } else {
            valueOfText = 0;
            changeable = true;
        }
    }
    
    public void update(int newInt) {
        valueOfText = newInt;
    }

}
