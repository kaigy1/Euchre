/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.AiPlayer;
import core.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author lucas Heredia
 */
public class AiPlayerUi extends JPanel 
{
AiPlayer ai;
int position;
ArrayList<JLabel> cards;
CardUi cardUi;
int width;
int height;


GameUi gameUi;
    


 AiPlayerUi(Player player,int position1,GameUi gameUi)
    {
        
        
        
        this.gameUi=gameUi;
        ai=(AiPlayer)player;
        position=position1;
        initComponents();
    }
//initializes every component and 
    private void initComponents() 
    {
      
       setPreferredSize(new Dimension(250, 100));
       setMinimumSize(new Dimension(100,50));
        cards=new ArrayList();
    
        if((position==1)||position==3)
        {
            width=10;
            height=100;
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
        else
        {
            width=100;
            height=50;
            setLayout(new BoxLayout(this,BoxLayout.X_AXIS));     
        }
               
        displayCards();        
    }
    //loops to create each card for ai players
 void displayCards()
 {
     JLabel p;
    for(int i=0;i<5;i++)
    {
        
     p=new JLabel();
     p.setSize(20,20);
     p.setBorder(BorderFactory.createLineBorder(Color.black));
     //p.setText("Card "+i);
     cardUi=new CardUi(ai.getHand().get(i),p,position);
     
     p=cardUi.getLabel();
     
     cards.add(p);
     add(p);
    
     
    }
 
 }
    
}
