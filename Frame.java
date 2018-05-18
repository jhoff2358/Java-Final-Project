import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Frame{
    private static JFrame JF;
    private static JPanel pan1, pan2;
    static JTextField jt[][];
    private JButton solve;
    public static int rows, cols;
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
                //jt[i][j] = new JTextField(Integer.toString(Main.board[i][j]));
                //jt[i][j] = new JTextField(Integer.toString(Main.antiop[i][j]));
                jt[i][j] = new JTextField("");
                jt[i][j].setFont(new Font("Arial", Font.PLAIN, 36));
                jt[i][j].setColumns(2);
                pan1.add(jt[i][j]);
            }
        }
        JF.setSize(JF.getPreferredSize());
        solve.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               //printThing(boxes);
               Main.build(jt, rows, cols);
               Solver.solve(Main.boxes, rows, cols);
           }
        });
    }
    public static void lastStep(Box[][] boxes){
        JFrame jf2 = new JFrame("Solved Sudoku");
        jf2.setLayout(new BorderLayout());
        JPanel jp = new JPanel();
        JPanel buttons = new JPanel();
        JButton b = new JButton("Solved Another?");
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
               // for(int i = 0; i < rows; i++){
                    // for(int j = 0; j < cols; j++){
                        
                    // }
               // }
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
    public void printThing(Box[][] boxes){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(boxes[i][j].valueOfText + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void update(Box[][] boxes) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                jt[i][j].setText(boxes[i][j].valueOfText + "");
                jt[i][j].updateUI();
            }
        }
        pan1.updateUI();
    }
}
