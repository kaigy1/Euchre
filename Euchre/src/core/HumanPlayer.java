/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import static constants.constants.MAX_PASSES;
import javax.swing.JOptionPane;
import userInterface.HumanPlayerUi;

/**
 *
 * @author kaigy
 */
public class HumanPlayer extends Player 
{
    Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public Card playCard()
    {
        return null;
    }    
    
    @Override
    public void makeTrump()
    {
        HumanPlayerUi hUi=(HumanPlayerUi)getUi();
        int check=game.trumpCheck;
        if (check==MAX_PASSES)
        {
            
            JOptionPane.showMessageDialog(hUi,"You have to accept trump");
            setAcceptTrump(true);
        }
        else
        {
        
            int i=JOptionPane.showConfirmDialog(null, "hey pal, do you accept the trump suit?");
            if(i==0)
                setAcceptTrump(true);
            else if(i==1){
                setAcceptTrump(false);
                
            }
            
         
        }
    }
}
