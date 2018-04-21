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
        for(JTextField j: jt){
            j = new JTextField();
            j.setColumns(5);
            pan1.add(j);
        }
        solve.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               printThing(jt);
           }
            
        });
    }
    public void printThing(JTextField[] jt){
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
                System.out.print(jt[j * i - 1].getText() + "  ");
            }
            System.out.println();
        }
    }
}
