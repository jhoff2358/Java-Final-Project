import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame{
    private JFrame JF;
    private JPanel pan1, pan2;
    JTextField jt[];
    private JButton solve;
    
    public Frame(){
        JF = new JFrame("Sudoku Solver");
        JF.setVisible(true);
        JF.pack();
        JF.setLayout(new BorderLayout());
        JF.setSize(600, 400);
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pan1 = new JPanel();
        pan2 = new JPanel();
        pan1.setLayout(new GridLayout(9, 9, 10, 10));
        jt = new JTextField[81];
        solve = new JButton("Solve!");
        JF.add(pan1);
        pan2.add(solve);
        JF.add(pan2, BorderLayout.SOUTH);
        for(int i = 0; i < jt.length; i++){
            jt[i] = new JTextField("");
            jt[i].setColumns(5);
            pan1.add(jt[i]);
        }
        solve.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               printThing(jt);
               Main.build(jt);
               Solver.solve(Main.boxes);
           }
            
        });
    }
    public void printThing(JTextField[] jt){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(jt[9 * i + j].getText() + "  ");
            }
            System.out.println();
        }
    }
}
