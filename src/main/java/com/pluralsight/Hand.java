package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    public Hand(){
        cards = new ArrayList<>();
    }
    // A Card is dealt to the Hand and the Hand is responsible
// to store the card
    public void deal(Card card){
        cards.add(card);
    }
    public int getSize(){
        return cards.size();
    }
    // The Hand uses the methods of each card to determine
// the value of each card - and adds up all values
    public int getValue(){
        int value = 0;
        int aces = 0;
        for(Card card: cards){
            int pointValue = card.getPointValue();
            value += pointValue;
            if (pointValue == 11) {
                aces++;
            }
        }
        while (value > 21 && aces > 0) {
            value -= 10;
            aces --;
        }
        return value;
    }
    public void showCards() {
        System.out.println("Hand contains: ");
        for (Card card : cards) {
            System.out.println("   " + card);
        }
    }
}
