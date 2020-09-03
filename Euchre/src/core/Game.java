/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;


import constants.constants;
import constants.constants.Color;
import constants.constants.Suit;
import java.util.ArrayList;
import constants.constants.Number;
import java.util.Iterator;
import java.util.Random;

import java.util.Scanner;
import javax.swing.JOptionPane;
import userInterface.GameUi;
/*
 * 
 * 
 * 
 * 
 * @author kaigy
 */
public final class Game 
{
    // declaring variables
    Color color;
    GameUi ui;
    int dealerIndex;
    int leadPlayerIndex;
    Card trump;

   
    int trumpCheck;
    Team trumpTeam;
    
    
    Suit suit;
    Number number;
    Player leadPlayer;
    Player dealer;
    Player winPlayer;
    int round;
    ArrayList<Team> theTeams;
    public ArrayList<Player> tableLayout;

    public ArrayList<Player> getTableLayout() {
        return tableLayout;
    }
    Deck deck;
    Scanner data=new Scanner(System.in);
// getters and setters
    public Color getColor()
    {
        return color;
    }

     public Card getTrump() 
    {
        return trump;
    }
     
    public void setColor(Color color) {
        this.color = color;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public Player getLeadPlayer() {
        return leadPlayer;
    }

    public void setLeadPlayer(Player leadPlayer) {
        this.leadPlayer = leadPlayer;
    }

    public Player getDealer() {
        return dealer;
    }

    public void setDealer(Player dealer) {
        this.dealer = dealer;
    }

    public Player getWinPlayer() {
        return winPlayer;
    }

    public void setWinPlayer(Player winPlayer) {
        this.winPlayer = winPlayer;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
    
    private void generateDeck()
    {
        deck=new Deck();
    }
    
    
    public ArrayList<Team> getTheTeams() {
        return theTeams;
    }

    public void setTheTeams(ArrayList<Team> theTeams) {
        this.theTeams = theTeams;
    }

    
    
    
    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
    
    

    public Scanner getData() {
        return data;
    }

    public void setData(Scanner data) {
        this.data = data;
    }
    //calling the constructor
    //now also calling the new implemented deck.
    public Game()
    {
        
        createTeams();
   //     outputTeams();
        generateDeck();
        setTable();
        dealHand();
        displayHand();
       // play();
        
    }
    
    public void setTable()
    {
        tableLayout=new ArrayList<>();
        ArrayList<Team> team=theTeams;
        Team team1=theTeams.get(0);
        Team team2=theTeams.get(1);
        Player player1=team1.getTeam().get(0);
        Player player2=team1.getTeam().get(1);
        Player player3=team2.getTeam().get(0);
        Player player4=team2.getTeam().get(1);
        tableLayout.add(player1);
        tableLayout.add(player2);
        tableLayout.add(player3);
        tableLayout.add(player4);
        for(Player p:tableLayout)
        {
            System.out.println(p.name);
        
        }
    }
    void setGameUi(GameUi gameUi)
    {
    ui=gameUi;
    
    }
    public void setDealerAndLead()
    {
        Random rand = new Random();
        int rand1=rand.nextInt(4);
        dealerIndex= rand1;
        if(dealerIndex==3)
           leadPlayerIndex=0; 
        else
        leadPlayerIndex=dealerIndex+1;
    }
    void displayHand()
    {
        for(Team t:theTeams)
        {
//       System.out.println("******************************");
//       System.out.println(t.teamName);
//       System.out.println("******************************");
            t.outputHands();
        }
    }
    public void dealHand()
    {
//       System.out.println("******************************");
//       System.out.println("       Dealing the Cards       ");
//       System.out.println("******************************");
       setDealerAndLead();
       System.out.print("Player ");
       int playerId=dealerIndex;
       
       
       
       switch(playerId)
       {
           case 0: System.out.print(tableLayout.get(0).name);
           break;
           case 1: System.out.print(tableLayout.get(1).name);
           break;
           case 2: System.out.print(tableLayout.get(2).name);
           break;
           case 3: System.out.print(tableLayout.get(3).name);
           break;
           default:
           break;
                  
       }
       System.out.println(" will deal the hand");
//       System.out.println("******************************");
//       System.out.println(" FIRST DEAL, TWO CARDS EACH");
//       System.out.println("******************************");
       Iterator<Card> itr=deck.getDeck1().iterator();
       
       for(Player p:tableLayout)
       {
           dealOne(playerId,itr,p);
           if(playerId>3)
               playerId=0;
           playerId++;
       }
//       System.out.println("******************************");
//       System.out.println(" SECOND DEAL, THREE CARDS EACH");
//       System.out.println("******************************");
       for(Player p:tableLayout)
       {
           dealTwo(playerId,itr,p);
           if(playerId>3)
               playerId=0;
           playerId++;
       }
       trump=itr.next();
       
//       System.out.println("******************************");
//       System.out.println(" Displaying the Trump Card");
//       System.out.println("******************************");
//              System.out.print("The Trump Card is a ");
//       System.out.print(trump.number);
//        System.out.print(" of ");
//        System.out.println(trump.suit);
    
    }
    
    void dealOne(int playerId,Iterator<Card> cardi,Player p)
    {
        for(int i=0;i<2;i++)
        {
          Card card=cardi.next();
//        System.out.print("Dealing ");    
//        System.out.print(card.number);
//        System.out.print(" of ");
//        System.out.println(card.suit);
//        System.out.print("to ");
//        System.out.println(p.name);
            p.getHand().add(card);
            cardi.remove();
        }
       
       
    
    }
    
    void dealTwo(int playerIn,Iterator<Card> cardp,Player p)
    {
        for(int i=0;i<3;i++)
        {
                Card card=cardp.next();
//        System.out.print("Card : ");    
//        System.out.print(card.number);
//        System.out.print(" of ");
//        System.out.println(card.suit);
//        System.out.print("to player");
//        System.out.println(playerIn);
        p.getHand().add(card);
        cardp.remove();
        }
    }
    public void play()
    {
//     for(Player p:tableLayout)
//     {
//         p.makeTrump();
//     }
        trumpCheck();
    }
    
    void trumpCheck()
    {
        trumpCheck=0;
        int localP=leadPlayerIndex;
        
        while(trumpCheck< 4)
        {
          Player player=tableLayout.get(localP);
            System.out.println("player " + localP);
          player.makeTrump(); 
          if(player.acceptTrump) 
          {
             for(Team team:theTeams)
             {
                 if(team.getTeam().contains(player))
                 {
                     trumpTeam=team;
                     System.out.println(team.teamName);
                     System.out.println(" has accpeted the trump suit.");
//                     break;
                 }
//                 else
//                 {
//                     trumpCheck++;
//                 }
             }
             break;
          }
          else 
          {
             trumpCheck++; 
          }
        localP++;
        if(localP==4)
            localP=0;
        }

    }
    
    // instanciate the variables and ad to the teams.
    public void createTeams()
    {
        
        theTeams = new ArrayList<>();
        Team teamOne= new Team();
        Team teamTwo= new Team();
        teamOne.setTName("Team One");
        teamTwo.setTName("Team Two");
        
        
        String name=JOptionPane.showInputDialog("Enter your name");
        //System.out.println("What is your name?");
        //String name=data.next();
        HumanPlayer human=new HumanPlayer();
        human.setName(name);
        teamOne.addPlayer(human);
        //System.out.println("Human Player added to team One");
        System.out.println("Players at the table are.");
        AiPlayer ai;
        
        for(int i=1;i<=constants.numberAI;i++)
        {
            ai=new AiPlayer();
            
            
            ai.setName("Ai-"+i);
            
            if(teamOne.getTeam().size() < 2)
                teamOne.addPlayer(ai);
            else
                teamTwo.addPlayer(ai);
            ai.setGame(this);


        }
        human.setGame(this);
        
        
      theTeams.add(teamOne);
      theTeams.add(teamTwo);
    }
    
    
   //print outs the teams names and players' names. 
    public void outputTeams()
    {
        
        
       for(Team x:theTeams)
       {
           
            x.outputTeam();
       }
        
    }
    
    
    
    
}
