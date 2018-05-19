import javax.swing.*;

public class Box{
    public int cellNum, row, col, valueOfText;
    public JTextField field;
    public boolean changeable;
    public Box(JTextField t, int row, int col){
        field = t;
        this.row = row;
        this.col = col;
        cellNum = 3 * ((int)(row / 3)) + (int)(col / 3);
        if(field.getText().equals("") || field.getText().equals("0")) {
            valueOfText = 0;
            changeable = true;
        } else {
            valueOfText = Integer.parseInt(field.getText());
            changeable = false;
        }
    }
    public void update(int newInt) {
        valueOfText = newInt;
    }
}