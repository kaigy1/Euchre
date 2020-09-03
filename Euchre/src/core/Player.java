/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author kaigy
 */
public abstract class Player 
{
    
    String name;

    ArrayList<Card> hand;
    ArrayList<Card> sortedHand;
    
    boolean acceptTrump;
    
    JPanel ui;

    
    Player()
    {
       hand=new ArrayList<>();
        
    }
    
    public JPanel getUi() {
        return ui;
    }

    public void setUi(JPanel ui) {
        this.ui = ui;
    }
    
    
    void displayHand()
    {
        
        
    for(Card c:sortedHand)
        {
        System.out.print("Card : ");    
        System.out.print(c.number);
        System.out.print(" of ");
        System.out.println(c.suit);
        }
    }
    //loop to short the hand of player
    void sortBySuit()
    {   
        int checking=0;
        sortedHand=new ArrayList();
        
        
        while(hand.size()>0)
        {
            int position = 0;
           Card firstCard=new Card();
           firstCard=hand.get(0);
           checking=0;
           Card nextCard;
         for(int i=1;i<hand.size();i++)
         {
             
             
             nextCard=hand.get(i);
             
             if((nextCard.suit.rank<firstCard.suit.rank)||(nextCard.suit.rank==firstCard.suit.rank)&&(nextCard.number.value<firstCard.number.value))
             {
                
                position=i; 
                firstCard=nextCard;
             }
         }
            
          hand.remove(position);
          sortedHand.add(firstCard);
        }
        
        hand=sortedHand;
    }

    public ArrayList<Card> getSortedHand() {
        return sortedHand;
    }
    
    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract Card playCard();
    public abstract void makeTrump();

    public boolean isAcceptTrump() {
        return acceptTrump;
    }

    public void setAcceptTrump(boolean acceptTrump) {
        this.acceptTrump = acceptTrump;
    }

    
}
