import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{
    public static final int WIDTH = 9, HEIGHT = 9, CELL_HEIGHT = 3, CELL_WIDTH = 3;
    public static Box[] boxes;
    public static void main(String args[]){
        new Frame();
    }
    public static void build(JTextField[] jt){
        boxes = new Box[81];
        for(int i = 0; i < 81; i++){
            boxes[i] = new Box(jt[i], i);
            System.out.println(boxes[i].cellNum + "     " + boxes[i].valueOfText);
        }
    }

}
