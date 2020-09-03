
package euchre;

import core.Game;

import javax.swing.JOptionPane;
import userInterface.GameUi;

/**
 *
 * @author Lucas Carvalho heredia
 
 */
public class Euchre 
{
//main
    
    public static void main(String[] args) 
    {
        //System.out.println("Welcome to Euchre!");
        
        JOptionPane.showMessageDialog(null,"Let's Play Euchre!");
        Game game=new Game();
        GameUi gameUi=new GameUi(game);
        
        
       
    }
    
}
