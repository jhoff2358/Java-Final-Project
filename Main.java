import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{
    public static Box[][] boxes;
    public static void main(String args[]){
        new Frame();
    }
    public static void build(JTextField[][] jt, int rows, int cols){
        boxes = new Box[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                boxes[i][j] = new Box(jt[i][j], i, j);
            }
        }
    }

}
