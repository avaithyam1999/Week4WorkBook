package com.pluralsight;

import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                 _     _            _    _            _   \s
                | |   | |          | |  (_)          | |  \s
                | |__ | | __ _  ___| | ___  __ _  ___| | __
                | '_ \\| |/ _` |/ __| |/ / |/ _` |/ __| |/ /
                | |_) | | (_| | (__|   <| | (_| | (__|   <\s
                |_.__/|_|\\__,_|\\___|_|\\_\\ |\\__,_|\\___|_|\\_\\
                                       _/ |               \s
                                      |__/                \s
                """);

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

        System.out.println("\nDealing 2 cards to each player: \n================================");
        player1Hand.deal(deck.deal());
        player1Hand.deal(deck.deal());



        player2Hand.deal(deck.deal());
        player2Hand.deal(deck.deal());

        System.out.printf("\n %s's hand: ", player1Name);
        player1Hand.showCards();
        int player1Value = player1Hand.getValue();
        System.out.println("Current total: " + player1Value);

        while (player1Hand.getValue() < 21) {
            System.out.printf("%s, would you like to hit or stay?", player1Name);
            String hitStayChoice = scanner.nextLine();
            if (hitStayChoice.equals("hit")) {
                player1Hand.deal(deck.deal());
                System.out.printf("%s's new hand: ", player1Name);
                player1Hand.showCards();
                player1Value = player1Hand.getValue();
                System.out.printf("Current total: %d", player1Value);

                if (player1Value > 21) {
                    System.out.println("\nBusted!");
                }
            } else if (hitStayChoice.equals("stay")){
                break;
            }
        }

        System.out.printf("\n %s's hand: ", player2Name);
        player2Hand.showCards();
        int player2Value = player2Hand.getValue();
        System.out.println("Current total: " + player2Value);

        while (player2Hand.getValue() < 21) {
            System.out.printf("%s, would you like to hit or stay?", player2Name);
            String hitStayChoice = scanner.nextLine();
            hitStayChoice.toLowerCase();
            if (hitStayChoice.equals("hit")) {
                player2Hand.deal(deck.deal());
                System.out.printf("%s's new hand: ", player2Name);
                player2Hand.showCards();
                player2Value = player2Hand.getValue();
                System.out.printf("Current total: %d\n", player2Value);

                if (player2Value > 21) {
                    System.out.println("\nBusted!");
                }
            } else if (hitStayChoice.equals("stay")) {
                break;
            }
        }

        determineFinalWinner(player1Value, player2Value, player2Name, player1Name);
    }

    private static void determineFinalWinner(int player1Value, int player2Value, String player2Name, String player1Name) {
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
