package tictactoe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */

    

public abstract  class TicTacToe  implements ActionListener{
    
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel =new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield= new JLabel();
    JButton[ ]buttons = new JButton[9];
    boolean player1_turn;
    
    
    TicTacToe(){
        
        //create JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        //create textfields
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        
        textfield.setOpaque(true);
        
        //Title panel
       title_panel.setLayout(new BorderLayout());
       title_panel.setBounds(0,0,800,100);
       button_panel.setLayout(new GridLayout(3,3));
       button_panel.setBackground(new Color(150,150,150));
       
       for(int i=0; i<9; i++){
           buttons[i] = new JButton();
           button_panel.add(buttons[i]);
           buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
           buttons[i].setFocusable(false);
           buttons[i].addActionListener(this);
       }
       
       title_panel.add(textfield);
       frame.add(title_panel,BorderLayout.NORTH); //Title panel stick to the top
       frame.add(button_panel);
        firstTurn();
           
    }
    @Override
    public void actionPerformed(ActionEvent e){
     for (int i=0; i<9; i++)
         //check each of nine buttons
         if(e.getSource()==buttons[i]){
             //check who's turn
         if(player1_turn)
         {
             if ("".equals(buttons[i].getText())){
                 buttons[i].setForeground(new Color(255,0,0));
                 buttons[i].setText("x");
                 player1_turn=false;
                 textfield.setText("O turn");
                 check();
             }
         }
             else
             {
               if ("".equals(buttons[i].getText())){
                 buttons[i].setForeground(new Color(0,255,0));
                 buttons[i].setText("o");
                 player1_turn=true;
                 textfield.setText("X turn");
                 check();
             }
         }         
         }   
}

   
     
    
    public void firstTurn() {
        //delay before assingning turn
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
    //set player's turns
    if(random.nextInt(2)==0){
        player1_turn=true;
        textfield.setText("x Turn");
    }
    else{
        player1_turn=false;
        textfield.setText("o turn");
    }
    
    
    }
    
    public void check(){
        //check x win conditions
    
        
        if( ( buttons[0].getText()=="x")&&
            (buttons[1].getText()=="x")&&
             ( buttons[2].getText()=="x"))
        {
           
        xWins(0,1,2);
        
    }
        
        
        if( ( buttons[3].getText()=="x")&&
            (buttons[4].getText()=="x")&&
             ( buttons[5].getText()=="x"))
        {
           
        xWins(3,4,5);
        
    }
        if( ( buttons[6].getText()=="x")&&
            (buttons[7].getText()=="x")&&
             ( buttons[8].getText()=="x"))
        {
           
        xWins(6,7,8);
        
    }
        if( ( buttons[0].getText()=="x")&&
            (buttons[3].getText()=="x")&&
             ( buttons[6].getText()=="x"))
        {
           
        xWins(0,3,6);
        
    }
        if( ( buttons[1].getText()=="x")&&
            (buttons[4].getText()=="x")&&
             ( buttons[7].getText()=="x"))
        {
           
        xWins(1,4,7);
        
    }
        if( ( buttons[2].getText()=="x")&&
            (buttons[5].getText()=="x")&&
             ( buttons[8].getText()=="x"))
        {
           
        xWins(2,5,8);
        
    }
        if( ( buttons[0].getText()=="x")&&
            (buttons[4].getText()=="x")&&
             ( buttons[8].getText()=="x"))
        {
           
        xWins(0,4,8);
        
    }
        if( ( buttons[2].getText()=="x")&&
            (buttons[4].getText()=="x")&&
             ( buttons[6].getText()=="x"))
        {
           
        xWins(2,4,6);
        
    }
        //check o win conditions
        
        if( ( buttons[0].getText()=="o")&&
            (buttons[1].getText()=="o")&&
             ( buttons[2].getText()=="o"))
        {
           
        oWins(0,1,2);
        
    }
        
        
        if( ( buttons[3].getText()=="o")&&
            (buttons[4].getText()=="o")&&
             ( buttons[5].getText()=="o"))
        {
           
        oWins(3,4,5);
        
    }
        if( ( buttons[6].getText()=="o")&&
            (buttons[7].getText()=="o")&&
             ( buttons[8].getText()=="o"))
        {
           
        oWins(6,7,8);
        
    }
        if( ( buttons[0].getText()=="o")&&
            (buttons[3].getText()=="o")&&
             ( buttons[6].getText()=="o"))
        {
           
        oWins(0,3,6);
        
    }
        if( ( buttons[1].getText()=="o")&&
            (buttons[4].getText()=="o")&&
             ( buttons[7].getText()=="o"))
        {
           
        oWins(1,4,7);
        
    }
        if( ( buttons[2].getText()=="o")&&
            (buttons[5].getText()=="o")&&
             ( buttons[8].getText()=="o"))
        {
           
        oWins(2,5,8);
        
    }
        if( ( "o".equals(buttons[0].getText()))&&
            (buttons[4].getText()=="o")&&
             ( buttons[8].getText()=="o"))
        {
           
        oWins(0,4,8);
        
    }
        if( ( buttons[2].getText()=="o")&&
            (buttons[4].getText()=="o")&&
             ( buttons[6].getText()=="o"))
        {
           
        oWins(2,4,6);
        
    }}
    
     public void xWins( int a ,int b,int c){
    buttons[a].setBackground(Color.red);
        buttons[b].setBackground(Color.red);
        buttons[c].setBackground(Color.red);
        //diable buttons
        for(int i= 0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
        
    }
    
     public void oWins( int a ,int b,int c){
         buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        //diable buttons
        for(int i= 0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("0 wins");
        
    }

    
}

   

