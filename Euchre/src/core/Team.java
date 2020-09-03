/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;


import java.util.ArrayList;
/**
 *
 * @author kaigy
 */
public class Team 
{
    ArrayList<Player> team;
    int score;
    int tricks;
    String teamName;
    String playerName;
    
    public void setTName(String name){
    teamName=name;
        
    }
    
    public void addPlayer(Player p)
    {
        team.add(p);
    }
    public ArrayList<Player> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<Player> team) {
        this.team = team;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTricks() {
        return tricks;
    }

    public void setTricks(int tricks) {
        this.tricks = tricks;
    }

    public String getName() {
        return teamName;
    }

    
    
    public Team()
    {
        team=new ArrayList<>();
    }
    public void outputHands()
    {
    for(Player p:team)
        {
            p.sortBySuit();
            if(p instanceof HumanPlayer)
            {
            System.out.println("******************************");
            System.out.print("Player ");
            System.out.print(p.name);
            System.out.println("hand is");
            System.out.println("******************************");
               
            p.displayHand();
            }
        }
    }
    
    
      public void outputTeam()
     {
         
        
        System.out.println(teamName);
        
        for(Player x: team)
        {
            playerName=x.getName();
            System.out.println(playerName);
        }
     }

    
    
}
