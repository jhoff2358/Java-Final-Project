import javax.swing.*;

public class Box extends JTextField{
    private int row, col, index, cell, width = 9, height = 9, cellWidth = 3;
    public Box(int index){
        this.index = index;
        row = (int)(index / width);
        col = index % width;
    }
}
