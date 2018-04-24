import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{
    public static void main(String args[]){
        new Frame();
    }
    public static void build(JTextField[] jt){
        Box[] b = new Box[81];
        for(int i = 0; i < 81; i++){
            b[i] = new Box(jt[i], i);
            System.out.println(b[i].cellNum + "   " + b[i].valueOfText);
        }
    }
}
