/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 *
 * @author kaigy
 */
public class constants 
{

public static final int numberAI=3;
public static final int numberCards=24;
public static final int playerCard=5;
public static final int handRounds=5;
public static final int MAX_PASSES=3;
public static final int MIN_TRUMP=3;
public static final int ONE=0;
public static final int TWO=1;

public enum Color
{
    BLACK,RED
}

    

    public enum Suit
{
        CLUBS (0), 
        DIAMONDS (1),
        HEARTS (2), 
        SPADES (3), ;
    public int rank;
    private Suit(int rank)
        {
            this.rank = rank;
        }
    }


public enum Number
{
    NINE(9),TEN(10),JACK(11),QUEEN(12),KING(13),ACE(14);
      public int value;
      private Number(int value)
      {
      this.value=value;
      
      }
}  



}
