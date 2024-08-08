import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {

    JFrame frame;
    JTextField display, xScore, oScore;
    JLabel score;
    static int xWin = 0, oWin = 0;

    JButton[] button;
    JButton playAgain;
    JPanel buttonPanel, scoreCard;
    boolean turn = true;
    ImageIcon logo = new ImageIcon("SP.jpeg");
    TicTacToe(){


        setFrame();

    }
    public void setDisplay(){
        display = new JTextField("START (X first)");

        display.setBounds(10,10,470,50);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setFont(new Font("MV Boli",Font.BOLD,30));
        display.setHorizontalAlignment(JTextField.CENTER);
        display.setEditable(false);
    }

    public void addFrame(){

        frame.add(buttonPanel);
        frame.add(display);

    }
    public void setButton(){
        button = new JButton[9];
        playAgain = new JButton("Play Again");
        buttonPanel = new JPanel();


        playAgain.setFocusable(false);
        playAgain.setBackground(Color.GREEN);
        playAgain.setForeground(Color.BLACK);
        playAgain.setBounds(25,230,140,50);
        playAgain.setFont(new Font("MV Boli",Font.BOLD,20));
//        playAgain.setBorder(new LineBorder(Color.GRAY,3,true));
        playAgain.addActionListener(this);

        for(int i=0; i<9; i++){
            button[i] = new JButton();
            button[i].setFocusable(false);
            button[i].setBackground(Color.WHITE);
            button[i].addActionListener(this);
        }


        buttonPanel.setLayout(new GridLayout(3,3,0,0));
        buttonPanel.setBounds(10,60,470,400);
        buttonPanel.setBorder(new LineBorder(Color.BLACK, 2));

        for(int i=0; i<9; i++){
            buttonPanel.add(button[i]);
        }
    }

    public void setScoreCardLabels(){
        score = new JLabel();
        xScore = new JTextField("'X' = "+xWin);
        oScore = new JTextField("'O' = "+oWin);

        score.setBounds(10,10,150,50);
        score.setText("SCORE");
//        score.setBackground(Color.BLACK);
        score.setForeground(Color.BLACK);
        score.setFont(new Font("MV Boli",Font.BOLD,30));
        score.setHorizontalAlignment(JLabel.CENTER);
//        score.setEditable(false);
        
        xScore.setBounds(10,100,170,50);
        xScore.setBackground(Color.RED);
        xScore.setForeground(Color.WHITE);
        xScore.setFont(new Font("MV Boli",Font.BOLD,30));
        xScore.setHorizontalAlignment(JTextField.CENTER);
        xScore.setEditable(false);
        
        oScore.setBounds(10,150,170,50);
        oScore.setBackground(Color.BLUE);
        oScore.setForeground(Color.WHITE);
        oScore.setFont(new Font("MV Boli",Font.BOLD,30));
        oScore.setHorizontalAlignment(JTextField.CENTER);
        oScore.setEditable(false);



        scoreCard.add(score);
        scoreCard.add(xScore);
        scoreCard.add(oScore);
    }
    public void setScoreCard(){
        scoreCard = new JPanel();


        scoreCard.setBounds(490,100, 187,300);
        scoreCard.setLayout(null);
        scoreCard.add(playAgain);

        setScoreCardLabels();

        frame.add(scoreCard);
    }
    public void setFrame(){
        frame = new JFrame("Tic Tac Toe");


        setDisplay();
        setButton();
        setScoreCard();
        addFrame();

        frame.setSize(700,510);
        frame.setIconImage(logo.getImage());
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(turn){
            for(int i=0; i<9; i++){
                if(e.getSource()== button[i]) {
                    button[i].setText("X");
                    button[i].setFont(new Font("MV Boli",Font.BOLD,100));
                    button[i].setForeground(Color.BLACK);
                    button[i].setBackground(Color.RED);

                    display.setForeground(Color.WHITE);
                    display.setBackground(Color.BLUE);
                    display.setText("O's turn");
                    button[i].setEnabled(false);
                    check();
                    turn = false;
                }
            }
        }else{
            for(int i=0; i<9; i++){
                if(e.getSource()== button[i]) {
                    button[i].setText("O");
                    button[i].setFont(new Font("MV Boli",Font.BOLD,100));
                    button[i].setForeground(Color.BLACK);
                    button[i].setBackground(Color.BLUE);

                    display.setForeground(Color.WHITE);
                    display.setBackground(Color.RED);
                    display.setText("X's turn");
                    button[i].setEnabled(false);
                    check();
                    turn = true;
                }
            }
        }
        //for play again*********

        if(e.getSource()==playAgain){
            setDisplay();
            new TicTacToe();
            frame.dispose();
        }
    }
    public void check(){
        // for x------------
        if(button[0].getText().equals("X") && 
                button[1].getText().equals("X") &&
                    button[2].getText().equals("X")){
            xWin(0,1,2);
        }
        else if(button[3].getText().equals("X") &&
                    button[4].getText().equals("X") &&
                    button[5].getText().equals("X")){
            xWin(3,4,5);
        }
        else if(button[6].getText().equals("X") &&
                button[7].getText().equals("X") &&
                    button[8].getText().equals("X")){
            xWin(6,7,8);
        }

        else if(button[0].getText().equals("X") &&
                button[3].getText().equals("X") &&
                    button[6].getText().equals("X")){
            xWin(0,3,6);
        }
        else if(button[1].getText().equals("X") &&
                button[4].getText().equals("X") &&
                    button[7].getText().equals("X")){
            xWin(1,4,7);
        }
        else if(button[2].getText().equals("X") &&
                button[5].getText().equals("X") &&
                    button[8].getText().equals("X")){
            xWin(2,5,8);
        }

        else if(button[0].getText().equals("X") &&
                button[4].getText().equals("X") &&
                  button[8].getText().equals("X")){
            xWin(0,4,8);
        }
        else if(button[2].getText().equals("X") &&
                button[4].getText().equals("X") &&
                    button[6].getText().equals("X")){
            xWin(2,4,6);
        }

        // for o------------
        else if(button[0].getText().equals("O") &&
                button[1].getText().equals("O") &&
                    button[2].getText().equals("O")){
            oWin(0,1,2);
        }
        else if(button[3].getText().equals("O") &&
                button[4].getText().equals("O") &&
                    button[5].getText().equals("O")){
            oWin(3,4,5);
        }
        else if(button[6].getText().equals("O") &&
                button[7].getText().equals("O") &&
                    button[8].getText().equals("O")){
            oWin(6,7,8);
        }

        else if(button[0].getText().equals("O") &&
                button[3].getText().equals("O") &&
                    button[6].getText().equals("O")){
            oWin(0,3,6);
        }
        else if(button[1].getText().equals("O") &&
                button[4].getText().equals("O") &&
                    button[7].getText().equals("O")){
            oWin(1,4,7);
        }
        else if(button[2].getText().equals("O") &&
                button[5].getText().equals("O") &&
                    button[8].getText().equals("O")){
            oWin(2,5,8);
        }

        else if(button[0].getText().equals("O") &&
                button[4].getText().equals("O") &&
                    button[8].getText().equals("O")){
            oWin(0,4,8);
        }
        else if(button[2].getText().equals("O") &&
                button[5].getText().equals("O") &&
                    button[8].getText().equals("O")){
            oWin(2,5,8);
        }
        else if(button[0].getText().equals("O") &&
                button[4].getText().equals("O") &&
                button[8].getText().equals("O")){
            oWin(0,4,8);
        }
        else if(button[2].getText().equals("O") &&
                button[4].getText().equals("O") &&
                button[6].getText().equals("O")){
            oWin(2,4,6);
        }
    }

    public void xWin(int a, int b,int c){
        display.setText("Game Over: X wins");
        display.setBackground(Color.RED);

        button[a].setBackground(Color.green);
        button[b].setBackground(Color.green);
        button[c].setBackground(Color.green);
        
        for(int i=0; i<9;i++){
            button[i].setEnabled(false);
        }
        xWin ++;
        xScore.setText("'X' = "+xWin);
    }
    public void oWin(int a, int b, int c){
        display.setText("Game Over: O wins");
        display.setBackground(Color.BLUE);

        button[a].setBackground(Color.green);
        button[b].setBackground(Color.green);
        button[c].setBackground(Color.green);

        for(int i=0; i<9;i++){
            button[i].setEnabled(false);
        }
        oWin++;
        oScore.setText("'O' = "+oWin);

    }
}
