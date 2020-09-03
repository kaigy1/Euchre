/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import constants.constants.Suit;
import constants.constants.Number;
import core.Card;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author kaigy
 */
public class CardUi 
{
    Card card;
    ImageIcon imageIcon;
    JButton button;
    JLabel label;
    int position;
    
    public CardUi(Card c,JButton b)
    {
        this.card=c;
        this.button=b;
        
        selectFrontImage(this.button);
    }

    
    
    public CardUi(Card c,JLabel l,int i)
    {
        card=c;
        label=l;
        position=i;
        
        if(position==1||position==3)
        {
         
        selectVerticalBackImage(); 
        }
        else
        {
        selectHorizontalBackImage();   
        }    
   
    }        
    
     public CardUi(JLabel l)
    {
        label=l;
        selectHorizontalBackImage();
    
    }
    
     public CardUi(JLabel label, Number face, Suit suit)
    {
        this.label = label;
        Card card = new Card();
        card.setNumber(face);
        card.setSuit(suit);
        this.card = card;
        selectFrontImage(label);
    }
     
    public void selectVerticalBackImage()
    {
            String fileName = "../images/backVertical.jpg";
         
            try
        {
            URL imgURL = getClass().getResource(fileName);

            //System.out.println("image file name is " + fileName);
            if(imgURL != null)
            {
                imageIcon = new ImageIcon(imgURL);
                imageIcon = imageResizeVertical(imageIcon);
                label = new JLabel(imageIcon);    
            }
        }
        catch(Exception ex)
        {
            System.err.println("Couldn't find file: " + fileName);
            imageIcon = null;
        }
        
        

//        imageIcon = new ImageIcon(getClass().getResource(fileName));
//        Image image = imageIcon.getImage();
//        Image newImage = image.getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH);
//        imageIcon = new ImageIcon(newImage);
//        
//                
//                
//        label = new JLabel(imageIcon);
    
    }
     
     public void selectFrontImage(JComponent component)
     {
         
         String fileName = "../images/";
         switch(card.getNumber())
         {
             case NINE:
                 fileName=fileName + "9";
                 break;
             case TEN:
                 fileName=fileName + "10";
                 break;
             case JACK:
                 fileName=fileName + "J";
                 break;
             case QUEEN:
                 fileName=fileName + "Q";
                 break;
             case KING:
                 fileName=fileName + "K";
                 break;
             case ACE:
                 fileName=fileName + "A";
                 break;    
         
         }
         
         
         switch(card.getSuit())
         {
             case CLUBS:
                 fileName=fileName + "C.png";
                 break;
             case HEARTS:
                 fileName=fileName + "H.png";
                 break;
             case DIAMONDS:
                 fileName=fileName + "D.png";
                 break;
             case SPADES:
                 fileName=fileName + "S.png";
          
         }
        
          try
        {
            URL imgURL = getClass().getResource(fileName);
            //System.out.println("image file name is " + fileName);
            if(imgURL != null)
            {        
                imageIcon = new ImageIcon(imgURL);
                imageIcon = imageResizeHorizontal(imageIcon);
            }
        
            if(component instanceof JLabel)
                label = new JLabel(imageIcon);
            else
                button = new JButton(imageIcon);        
        }
        catch(Exception ex)
        {
            System.err.println("Couldn't find file: " + fileName);
            imageIcon = null;            
        }
        
//        imageIcon = new ImageIcon(getClass().getResource(fileName));
//        Image image = imageIcon.getImage();
//        Image newImage = image.getScaledInstance(75,100, java.awt.Image.SCALE_SMOOTH);
//        imageIcon = new ImageIcon(newImage);
//        
//                
//                
//        button = new JButton(imageIcon);
             
             
                 
     }
    
     private void selectHorizontalBackImage(){
         
        String fileName = "../images/backHorizontal.jpg";

        try
        {
            URL imgURL = getClass().getResource(fileName);
            if(imgURL != null)
            {        
                imageIcon = new ImageIcon(imgURL);
                imageIcon = imageResizeHorizontal(imageIcon);
                label = new JLabel(imageIcon);    
            }
        }
        catch(Exception ex)
        {
            System.err.println("Couldn't find file: " + fileName);
            imageIcon = null;
        }



//        imageIcon = new ImageIcon(getClass().getResource(fileName));
//        Image image = imageIcon.getImage();
//        Image newImage = image.getScaledInstance(75,100 , java.awt.Image.SCALE_SMOOTH);
//        imageIcon = new ImageIcon(newImage);
//        
//        label = new JLabel(imageIcon);
         
         
     }
     
     private ImageIcon imageResizeHorizontal(ImageIcon icon)
    {
        Image image = icon.getImage();
        Image newImage = 
               image.getScaledInstance(70, 100, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }   
     
     private ImageIcon imageResizeVertical(ImageIcon icon)
    {
        Image image = icon.getImage();
        Image newImage = 
               image.getScaledInstance(100, 70, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }
     
    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
    
     
}
