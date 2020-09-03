/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Card;
import core.HumanPlayer;
import core.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author lucas Heredia
 */
public class HumanPlayerUi extends JPanel {
    HumanPlayer human;
    ArrayList<JButton>cards;
    CardUi cardUi;
    GameUi gameUi;
    
     HumanPlayerUi(Player player,int i,GameUi gameUi)
    {
        this.gameUi=gameUi;
        
        human=(HumanPlayer)player;
        initComponents();
        
    }
    
    private void initComponents()
    {
        
        
       setPreferredSize(new Dimension(150, 120));
       setMinimumSize(new Dimension(100,50));
       setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        
        
        displayCards();
        
     
    }
        //loops to create each card ai players
        
        private void displayCards()
        {
            cards=new ArrayList<>();
            JButton b;
        for(int i=0;i<5;i++)
        {
        b=new JButton();
        b.setSize(50,50);
        b.setBorder(BorderFactory.createLineBorder(Color.black));
        //b.setText("Card "+i);
        cardUi=new CardUi(human.getHand().get(i),b);
        b=cardUi.getButton();
        cards.add(b);
        add(b);
        
        
        
        
        
        }
        
    }
}
