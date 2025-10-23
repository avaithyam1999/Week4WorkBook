package com.pluralsight;

import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====BlackJack=====");

        System.out.println("Enter name for player 1:");
        String player1Name = scanner.nextLine();

        System.out.println("Enter name for player 2 or leave blank for single player");
        String player2Name = scanner.nextLine();
        if (player2Name.equals("")) {
            player2Name = "Dealer";
        }

        Deck deck = new Deck();
        System.out.println("Deck created and shuffled. Cards remaining: " + deck.getSize());

        Hand player1Hand = new Hand();
        Hand player2Hand = new Hand();

        System.out.println("\nDealing 2 cards to each player: \n");
        player1Hand.deal(deck.deal());
        player1Hand.deal(deck.deal());

        player2Hand.deal(deck.deal());
        player2Hand.deal(deck.deal());

        System.out.printf("\n %s's hand: ", player1Name);
        player1Hand.showCards();
        int player1Value = player1Hand.getValue();
        System.out.println("Cards total: " + player1Value);

        System.out.printf("\n %s's hand: ", player2Name);
        player1Hand.showCards();
        int player2Value = player1Hand.getValue();
        System.out.println("Cards total: " + player1Value);

        determineWinner(player1Value, player2Value, player2Name, player1Name);
    }

    private static void determineWinner(int player1Value, int player2Value, String player2Name, String player1Name) {
        boolean player1bust = player1Value > 21;
        boolean player2bust = player2Value > 21;

        if (player1bust && player2bust) {
            System.out.println("Both players lose. No winner.");
        } else if (player1bust) {
            System.out.printf("%s wins with a score of: %d", player2Name, player2Value);
        } else if (player2bust) {
            System.out.printf("%s wins with a score of: %d", player1Name, player1Value);
        } else {
            int scoreDifference1 = 21 - player1Value;
            int scoreDifference2 = 21 - player2Value;

            if (scoreDifference1 < scoreDifference2) {
                System.out.printf("""
                        %s Final Score: %d
                        %s Final Score: %d
                        
                        %s wins!
                        """, player1Name, player1Value, player2Name, player2Value, player1Name);
            }
            if (scoreDifference1 > scoreDifference2) {
                System.out.printf("""
                        %s Final Score: %d
                        %s Final Score: %d
                        
                        %s wins!
                        """, player1Name, player1Value, player2Name, player2Value, player2Name);
            } else if (scoreDifference1 < scoreDifference2) {
                System.out.printf("""
                        %s Final Score: %d
                        %s Final Score: %d
                        
                        %s wins!
                        """, player1Name, player1Value, player2Name, player2Value, player1Name);
            } else if (scoreDifference1 == scoreDifference2) {
                System.out.printf("""
                        %s Final Score: %d
                        %s Final Score: %d
                        
                        Tie Game!
                        """, player1Name, player1Value, player2Name, player2Value);
            }
        }
    }
}
