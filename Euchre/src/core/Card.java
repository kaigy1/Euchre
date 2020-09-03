
package core;


import constants.constants.Color;
import constants.constants.Suit;
import constants.constants.Number;
/**
 *
 * @author kaigy
 */
public class Card 
{  // all the cards specifications suit color etc.
    Suit suit ;
    Color color;
    Number number;
// method to classify the card on color face and suit.
    //the "face" of the card is being represent by the variable "number". 
    public int hashCode()
    {
        int hashCode=0;
        hashCode+=number.hashCode();
        hashCode+=color.hashCode();
        hashCode+=suit.hashCode();
        return hashCode;
         
    }
    
    public boolean equals(Object object)
    {
        if(object instanceof Card)
        {
            Card card = (Card)object;
            return (card.number.equals(this.number) &&card.color.equals(this.color) &&card.suit.equals(this.suit));
                    
        }
        else
            return false;
    }
    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public void setNumber(java.lang.Number face) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
