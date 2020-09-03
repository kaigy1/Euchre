/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import static constants.constants.MAX_PASSES;
import javax.swing.JOptionPane;
import userInterface.AiPlayerUi;

/**
 *
 * @author kaigy
 */
public class AiPlayer extends Player
{
 Game game;
 
 
    
 //functions I will probably use later.
 //   

 
 
 
public Card playCard()
    {
    
        return null;
    }

public void makeTrump()
    {
        AiPlayerUi aiUi=(AiPlayerUi)getUi();
        
        int check=game.trumpCheck;
        if (check==MAX_PASSES)
        {
            JOptionPane.showMessageDialog(aiUi,"you have to accept trump");
            setAcceptTrump(true);
        }
        else
        {
        int trumpSuitCards=0;
        for(Card card:hand)
            {
            if(card.suit==game.trump.getSuit())
               {
                   trumpSuitCards++;
               } 
        
            }
                
        if (trumpSuitCards>=3)
        {
            setAcceptTrump(true);
            System.out.println(name);
            System.out.println(" has said: Pick it Up!");
            JOptionPane.showMessageDialog(aiUi, name + " said Pick it Up");
        }
        else
            {
                setAcceptTrump(false);
                
            System.out.println(name);
            System.out.println(" has said: Pass!");
            JOptionPane.showMessageDialog(aiUi, name + " said Pass");

            }
        }
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
 
    
}
