/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;


import constants.constants.Suit;
import constants.constants.Color;
import constants.constants.Number;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck 
{
//creating a deck of cards.
    Set<Card> deck;
    List<Card> deck1;

    public List<Card> getDeck1() {
        return deck1;
    }

    public void setDeck1(List<Card> deck1) {
        this.deck1 = deck1;
    }
    
    
    Set<Card> getDeck() {
        return deck;
    }

    public void setDeck(Set<Card> deck) {
        this.deck = deck;
    }
 //creates the deck of cards which is just a set of cards.
    public void generateDeck()
    {
//        System.out.println("*******************");
//        System.out.println("Generating the Deck of Cards");
//        System.out.println("*******************");
        deck= new HashSet();
        for(Number f:Number.values())
        {
            for(Suit s:Suit.values())
            {
                Card card=new Card();
                card.setSuit(s);
                card.setNumber(f);
                if(card.getSuit()==Suit.CLUBS||card.getSuit()==Suit.SPADES)
                    card.color=Color.BLACK;
                else
                    card.color=Color.RED;
            
        if(!(deck.contains(card)))
           deck.add(card);
            } 
        }
        
        
        
    }
    
    public void shuffleDeck()
    {
        ArrayList<Card> cardList=new ArrayList(deck);
        
        deck=new HashSet(cardList);
        
    }
    //method that loops through the deck and display the cards accordinly.
    public void displayDeck()
    {
    
        
        int size=deck.size();
        
        System.out.print("Deck size: ");
        System.out.println(size);
        System.out.print("Cards ");
        for(Card c:deck)
        {
            System.out.print("Card : ");    
            System.out.print(c.number);
            System.out.print(" of ");
            System.out.print(c.suit);
            System.out.print(" is color ");
            System.out.println(c.color);
        }
    }
    
    public void shuffleDeck(Set<Card> deck)
    {
//        System.out.println("*******************");
//        System.out.println("Shuffling the deck of cards");
//        System.out.println("*******************");
        deck1=new ArrayList<Card>(deck);
        Collections.shuffle(deck1);
        deck= new HashSet(deck1);
    }
    
//constructor calls functions implemented in the code    
    public Deck()
    {
 
        deck= new HashSet();
        generateDeck();
//        System.out.println("*******************");
//        System.out.println("Displaying the deck of cards");
//        System.out.println("*******************");
        
        shuffleDeck();
        shuffleDeck(deck);
//        System.out.println("*******************");
//        System.out.println("Displaying the shuffled deck of cards");
//        System.out.println("*******************");
       // displayCardList();
        
    }
    void displayCardList()
    {
    for(Card card:deck1)
        {
        System.out.print("Card : ");    
        System.out.print(card.number);
        System.out.print(" of ");
        System.out.print(card.suit);
        System.out.print(" is color ");
        System.out.println(card.color);
        }
    
    }
    
}
