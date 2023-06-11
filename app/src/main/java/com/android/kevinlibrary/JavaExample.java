package com.android.kevinlibrary;

import com.android.kevinkotlin.ccc.Hero;

import java.io.IOException;

public class JavaExample {

    public static void main(String[] args) {
        System.out.println(Hero.makeProclamation());


        SpellBook spellBook = new SpellBook();
        // System.out.println(spellBook.getSpells());
        System.out.println(spellBook.spells);


        SpellBookKt.handOverFood("Apple");


        System.out.println(SpellBook.MAX_SPELL_COUNT);
        SpellBook.getSpellBookGreeting();

        try {
            new JavaExample().extendHandInFriendship();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            SpellBookKt.acceptApology();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int mHitPoints = 123;

    public String utterGreeting() {
        return "Hello";
    }

    public String determineFriendshipLevel() {
        return null;
    }

    public int getHitPoints() {
        return mHitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.mHitPoints = hitPoints;
    }

    public void extendHandInFriendship() throws IOException {
        throw new IOException();
    }
}
