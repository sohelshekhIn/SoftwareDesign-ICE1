/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * @modifier Sohel Shekh - 991759597
 * @modified 2025-01-26 - Added random card generation and user input handling
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1); // Generates random value between 1-13
            c.setSuit(Card.SUITS[random.nextInt(4)]); // Randomly selects a suit from SUITS array
            System.out.println(c.getSuit());
            System.out.println(c.getValue());
            magicHand[i] = c;
            //c.setValue(insert call to random number generator here)
            //c.setSuit(Card.SUITS[insert call to random number between 0-3 here])
        }

         Card luckyCard = new Card();
        luckyCard.setValue(2); // Hard-coded value
        luckyCard.setSuit("Clubs"); 
        
        System.out.print("Pick a card value (1-13): ");
        int userValue = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Pick a card suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = scanner.nextLine();

        
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);
        
        boolean found = false;
       
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
            found = true;
                break;
            }
        }
            // if the user getts the lucky card
         if (luckyCard.getValue() == userCard.getValue() && luckyCard.getSuit().equalsIgnoreCase(userCard.getSuit())) {
            found = true;
            System.out.println("Congratulations! You picked the lucky card!");
        }
        
         if (found) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is not in the magic hand.");
        }

    }
    
}
