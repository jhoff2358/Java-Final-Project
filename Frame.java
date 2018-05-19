import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Frame{
    private static JFrame JF;
    private static JPanel pan1, pan2;
    public static Box[][] boxes;
    static JTextField jt[][];
    private JButton solve;
    public static int rows, cols;
    public static int[][] board = {
        {5,3,0,0,7,0,0,0,0},
        {6,0,0,1,9,5,0,0,0},
        {0,9,8,0,0,0,0,6,0},
        {8,0,0,0,6,0,0,0,3},
        {4,0,0,8,0,3,0,0,1},
        {7,0,0,0,2,0,0,0,6},
        {0,6,0,0,0,0,2,8,0},
        {0,0,0,4,1,9,0,0,5},
        {0,0,0,0,8,0,0,7,9}
    };
    public static int[][] antiop = {
        {0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,3,0,8,5},
        {0,0,1,0,2,0,0,0,0},
        {0,0,0,5,0,7,0,0,0},
        {0,0,4,0,0,0,1,0,0},
        {0,9,0,0,0,0,0,0,0},
        {5,0,0,0,0,0,0,7,3},
        {0,0,2,0,1,0,0,0,0},
        {0,0,0,0,4,0,0,0,9}
    };
    public Frame(){
        JF = new JFrame("Sudoku Solver");
        JF.setVisible(true);
        JF.pack();
        JF.setLayout(new BorderLayout());
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rows = 9; 
        cols = 9;
        pan1 = new JPanel(); // text fields
        pan2 = new JPanel(); // solve button
        pan1.setLayout(new GridLayout(rows, cols, 5, 5));
        jt = new JTextField[rows][cols];
        solve = new JButton("Solve!");
        JF.add(pan1);
        pan2.add(solve);
        JF.add(pan2, BorderLayout.SOUTH);
        for(int i = 0; i < rows; i++){ 
            for(int j = 0; j < cols; j++){
                //jt[i][j] = new JTextField(Integer.toString(board[i][j]));
                //jt[i][j] = new JTextField(Integer.toString(antiop[i][j]));
                jt[i][j] = new JTextField("");
                jt[i][j].setFont(new Font("Arial", Font.PLAIN, 36));
                jt[i][j].setColumns(2);
                pan1.add(jt[i][j]);
            }
        }
        JF.setSize(JF.getPreferredSize());
        solve.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               boxes = new Box[rows][cols];
               for(int i = 0; i < rows; i++){ 
                   for(int j = 0; j < cols; j++){
                       boxes[i][j] = new Box(jt[i][j], i, j);
                   }
                }
               Solver.solve(boxes, rows, cols);
           }
        });
    }
    public static void lastStep(Box[][] boxes){
        JFrame jf2 = new JFrame("Solved Sudoku");
        jf2.setLayout(new BorderLayout());
        JPanel jp = new JPanel();
        JPanel buttons = new JPanel();
        JButton b = new JButton("Solve Another?");
        JButton yes = new JButton("Yes!   (:");
        JButton no = new JButton("No!   );");
        jp.setLayout(new GridLayout(rows, cols, 5, 5));
        JTextField jt2[][] = new JTextField[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                jt2[i][j] = new JTextField(boxes[i][j].valueOfText + "");
                jt2[i][j].setEditable(false);
                jt2[i][j].setColumns(2);
                jt2[i][j].setFont(new Font("Arial", Font.PLAIN, 36));
                jp.add(jt2[i][j]);
            }
        }
        buttons.add(b);
        jf2.add(buttons, BorderLayout.SOUTH);
        jf2.add(jp, BorderLayout.NORTH);
        jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf2.pack();
        jf2.setSize(JF.getWidth(), JF.getHeight());
        jf2.setVisible(true);
        b.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               buttons.add(yes);
               buttons.add(no);
               b.setVisible(false);
           }
        });
        yes.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               jf2.dispose();
               JF.dispose();
               for(int i = 0; i < rows; i++){
                   for(int j = 0; j < cols; j++){
                   }
                }
               new Frame();
           }
        });
        no.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               jf2.dispose();
               JF.dispose();
           }
        });
    }
    public static void main(String args[]){
        new Frame();
    }
}
