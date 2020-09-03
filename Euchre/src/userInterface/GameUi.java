/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import constants.constants;
import core.Game;
import core.Player;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author kaigy
 */
public class GameUi 
{// declaring everything and instanciating
   Game game;
   JFrame frame;
   
   
   JPanel aiOnePanel=new JPanel();
   JPanel tablePanel=new JPanel();
   JPanel aiTwoPanel=new JPanel();
   JPanel hpPanel=new JPanel();
   JPanel aiThreePanel=new JPanel();
   JPanel northPanel=new JPanel();
   JPanel scorePanel=new JPanel();
   
   
   JPanel trumpPanel;
   
  
    
   JLabel teamOneScoreLbl;
   JLabel teamOneScore;
   JLabel teamTwoScoreLbl;
   JLabel teamTwoScore; 
   JLabel trumpCard;
   
   JMenuBar menuBar;
   JMenu gameMenu=new JMenu();
   JMenu help=new JMenu();
   JMenuItem newGame=new JMenuItem("New Game");
   JMenuItem exit=new JMenuItem("exit");
   JMenuItem about=new JMenuItem("about");
   JMenuItem rules=new JMenuItem("rules");
   
   ArrayList<JLabel>stack;
   
   public GameUi(Game game1)
   {
       game=game1;
       
       initComponents();
       game.play();
   }
   public void initComponents()
   {
       //Things related to Jframe setsize etc
   frame=new JFrame("Euchre");   
   frame.setSize(1000,1000);
   frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
   frame.setLocationRelativeTo(null);
  
   stack= new ArrayList();
   
   //Things related to score panel setsize etc
   trumpPanel=new JPanel(new BorderLayout());
   trumpPanel.setMinimumSize(new Dimension(100, 20));
   trumpPanel.setPreferredSize(new Dimension(100, 120));
   trumpPanel.setBorder(BorderFactory.createTitledBorder("Trump"));
   trumpCard=new JLabel();
   
   CardUi trumpU=new CardUi(trumpCard,game.getTrump().getNumber(),game.getTrump().getSuit());
   trumpCard=trumpU.getLabel();
   trumpPanel.add(trumpCard);
           
           
   
   teamOneScoreLbl=new JLabel("Team One");
   teamOneScore=new JLabel();
   teamOneScore.setText(String.valueOf(game.getTheTeams().get(constants.ONE).getScore()));
   teamTwoScoreLbl=new JLabel("Team Two");
   teamTwoScore=new JLabel();
    teamTwoScore.setText(String.valueOf(game.getTheTeams().get(constants.TWO).getScore())); 
    
           
   //trump panel
   scorePanel=new JPanel(new BorderLayout());
   scorePanel.setMinimumSize(new Dimension(150, 100));
   scorePanel.setPreferredSize(new Dimension(150, 100));
   scorePanel.setBorder(BorderFactory.createTitledBorder("Score"));
   
   scorePanel.add(teamOneScoreLbl);
   scorePanel.add(teamOneScore);
   scorePanel.add(teamTwoScoreLbl);
   scorePanel.add(teamTwoScore);
   
   //Things related to table panel 
   tablePanel.setBorder(BorderFactory.createTitledBorder("Euchre"));
   tablePanel=new JPanel(new BorderLayout());
   northPanel=new JPanel(new BorderLayout());
   
   menuBar=new JMenuBar();
   frame.setJMenuBar(menuBar);
   
   
   //menubar setup.
   gameMenu=new JMenu("Game");
   menuBar.add(gameMenu);
   help=new JMenu("Help");
   menuBar.add(help);
   
   gameMenu.add(newGame);
   gameMenu.add(exit);
   
   
   
   help.add(rules);
   help.add(about);
   
   //ai panels setup and players setup
   aiOnePanel = new AiPlayerUi(game.tableLayout.get(1), 1,this);
   aiOnePanel.setBorder(BorderFactory.createLineBorder(Color.black));
   aiOnePanel.setBorder(BorderFactory.createTitledBorder("AI-1"));
   
   
   aiTwoPanel = new AiPlayerUi(game.tableLayout.get(2), 2,this);
   aiTwoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
   aiTwoPanel.setBorder(BorderFactory.createTitledBorder("Ai-2"));
   aiTwoPanel.setPreferredSize(new Dimension(400, 140));
   
   aiThreePanel = new AiPlayerUi(game.tableLayout.get(3), 3,this);
   aiThreePanel.setBorder(BorderFactory.createLineBorder(Color.black));
   aiThreePanel.setBorder(BorderFactory.createTitledBorder("AI-3"));
   
   hpPanel=new HumanPlayerUi(game.tableLayout.get(0),0,this);
   hpPanel.setBorder(BorderFactory.createTitledBorder(game.tableLayout.get(0).getName()));
   FlowLayout Layout = new FlowLayout();
   
   northPanel.setLayout(Layout);
   northPanel.setBorder(BorderFactory.createLineBorder(Color.black));
   northPanel.add(scorePanel);
   northPanel.add(aiTwoPanel);
   northPanel.add(trumpPanel);
   
   tablePanel.setPreferredSize(new Dimension(150, 100));
   tablePanel.setBorder(BorderFactory.createLineBorder(Color.black));
   
   
   for(Player p:game.tableLayout)
   {
       
      JLabel label=new JLabel();
      label.setPreferredSize(new Dimension(50, 50));
      CardUi cardU=new CardUi(label);
      label=cardU.getLabel();
      stack.add(label);
   }
   
   
   
   
   
//   tablePanel.add(stack.get(0),BorderLayout.SOUTH);
//   tablePanel.add(stack.get(1),BorderLayout.WEST);
//   tablePanel.add(stack.get(2),BorderLayout.NORTH);
//   tablePanel.add(stack.get(3),BorderLayout.EAST);
   
   
   
   //setting the place of each panel
   frame.add(northPanel, BorderLayout.NORTH);
   frame.add(tablePanel, BorderLayout.CENTER);
   frame.add(aiOnePanel, BorderLayout.WEST);
   
   frame.add(hpPanel, BorderLayout.SOUTH);
   frame.add(aiThreePanel, BorderLayout.EAST);
   frame.setVisible(true);
   about.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
       JOptionPane.showMessageDialog(frame,"Euchre version 1.0\n Lucas Carvalho Heredia\n Summer 2018");
       }
       
   });
   
   exit.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
       int answer=JOptionPane.YES_NO_OPTION;
           JOptionPane.showMessageDialog(frame,"Confirm to exit Euchre?", "exit", JOptionPane.YES_NO_OPTION);
       
       if(answer== JOptionPane.YES_OPTION)
           System.exit(0);
       }
       
   });
   
   
   
   rules.addActionListener(new ActionListener(){
    
       public void actionPerformed(ActionEvent e){
       
       }
   });
   
   
   }

   
   

    
}
