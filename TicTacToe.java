package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {

    Random rand= new Random();
    JFrame frame = new JFrame();
    JPanel title = new JPanel();
    JPanel button = new JPanel();
    JLabel txt = new JLabel();
    JButton [] buttons = new JButton[9];
    boolean player1;

    TicTacToe(){

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize( 600, 600);
    frame.getContentPane().setBackground(new Color(50,50,50));
    frame.setLayout((new BorderLayout()));
    frame.setVisible(true);

    txt.setBackground( new Color(99,96,106));
    txt.setForeground(new Color(250,208,201));
    txt.setFont(new Font("Monospaced", Font.BOLD,65));
    txt.setHorizontalAlignment(JLabel.CENTER);
    txt.setText("TIC TAC TOE");
    txt.setOpaque(true);

    title.setLayout(new BorderLayout());
    title.setBounds(0,0,900,100);

    button.setLayout((new GridLayout(3,3)));
    button.setBackground( new Color(150,150,150));

    for(int i = 0; i<9; i++){
        buttons[i] = new JButton();
        button.add(buttons[i]);
        buttons[i].setFont( new Font("Sanserif", Font.BOLD,120));
        buttons[i].setFocusable(false);
        buttons[i].addActionListener(this);
    }

    title.add(txt);
    frame.add(title, BorderLayout.NORTH);
    frame.add(button);

    firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i < 9; i++){
            if(e.getSource()==buttons[i]){
                if(player1){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(200,0,0));
                        buttons[i].setText("X");
                        player1 = false;
                        txt.setText("O turn");
                        check();
                    }

                }
                else{
                    if(buttons[i].getText()== ""){
                        buttons[i].setForeground(new Color(0,0,116));
                        buttons[i].setText("O");
                        player1 = true;
                        txt.setText("X turn");
                        check();
                    }
                }

            }
        }
    }

    public void  firstTurn(){
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e){
        e.printStackTrace();
    }

if (rand.nextInt(2)==0){
    player1 = true;
    txt.setText("X turn");
}
else{
    player1 = false;
    txt.setText("O Turn");
}
    }
    public void check(){
        if(
                (buttons[0].getText()=="X")&&
                (buttons[1].getText()=="X")&&
                (buttons[2].getText()=="X")
                 ){
            xWins(0,1,2);

        }
        if(
                (buttons[3].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[5].getText()=="X")
        ){
            xWins(3,4,5);

        }
        if(
                (buttons[6].getText()=="X")&&
                (buttons[7].getText()=="X")&&
                (buttons[8].getText()=="X")
        ){
            xWins(6,7,8);

        }
        if(
                (buttons[0].getText()=="X")&&
                (buttons[3].getText()=="X")&&
                (buttons[6].getText()=="X")
        ){
            xWins(0,3,6);

        }
        if(
                (buttons[1].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[7].getText()=="X")
        ){
            xWins(1,4,7);

        }
        if(
                (buttons[2].getText()=="X")&&
                (buttons[5].getText()=="X")&&
                (buttons[8].getText()=="X")
        ){
            xWins(2,5,8);

        }
        if(
                (buttons[0].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[8].getText()=="X")
        ){
            xWins(0,4,8);

        }
        if(
                (buttons[2].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[6].getText()=="X")
        ){
            xWins(2,4,6);

        }

        // 0 wins

        if(
                (buttons[0].getText()=="O")&&
                (buttons[1].getText()=="O")&&
                (buttons[2].getText()=="O")
        ){
            oWins(0,1,2);

        }
        if(
                (buttons[3].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[5].getText()=="O")
        ){
            oWins(3,4,5);

        }
        if(
                (buttons[6].getText()=="O")&&
                (buttons[7].getText()=="O")&&
                (buttons[8].getText()=="O")
        ){
            oWins(6,7,8);

        }
        if(
                (buttons[0].getText()=="O")&&
                (buttons[3].getText()=="O")&&
                (buttons[6].getText()=="O")
        ){
            oWins(0,3,6);

        }
        if(
                (buttons[1].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                 (buttons[7].getText()=="O")
        ){
            oWins(1,4,7);

        }
        if(
                (buttons[2].getText()=="O")&&
                (buttons[5].getText()=="O")&&
                (buttons[8].getText()=="O")
        ){
            oWins(2,5,8);

        }
        if(
                (buttons[0].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[8].getText()=="O")
        ){
            oWins(0,4,8);

        }
        if(
                (buttons[2].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[6].getText()=="O")
        ){
            oWins(2,4,6);

        }

    }

    public void xWins(int a, int b, int c){
    buttons[a].setBackground(Color.green);
    buttons[b].setBackground(Color.green);
    buttons[c].setBackground(Color.green);

    for (int i =9; i<9; i++){
        buttons[i].setEnabled(false);
    }
    txt.setText("X Wins");
    }
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (int i =9; i<9; i++){
            buttons[i].setEnabled(false);
        }
        txt.setText("O Wins");
    }
}
