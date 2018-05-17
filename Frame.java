import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame{
    private JFrame JF;
    private static JPanel pan1, pan2;
    static JTextField jt[][];
    private JButton solve;
    public int rows, cols;
    public Frame(){
        JF = new JFrame("Sudoku Solver");
        JF.setVisible(true);
        JF.pack();
        JF.setLayout(new BorderLayout());
        JF.setSize(600, 400);
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rows = 9; 
        cols = 9;
        pan1 = new JPanel(); // text fields
        pan2 = new JPanel(); // solve button
        pan1.setLayout(new GridLayout(9, 9, 10, 10));
        jt = new JTextField[rows][cols];
        solve = new JButton("Solve!");
        JF.add(pan1);
        pan2.add(solve);
        JF.add(pan2, BorderLayout.SOUTH);
        for(int i = 0; i < rows; i++){ 
            for(int j = 0; j < cols; j++){
                jt[i][j] = new JTextField(Integer.toString(Main.antiop[i][j]));
                //jt[i][j] = new JTextField("");
                jt[i][j].setFont(new Font("Arial", Font.PLAIN, 36));
                jt[i][j].setColumns(5);
                pan1.add(jt[i][j]);
            }
        }
        solve.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               //printThing(boxes);
               Main.build(jt, rows, cols);
               Solver.solve(Main.boxes, rows, cols);
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
