package com.android.kevinlibrary;

import com.android.kevinkotlin.ccc.Hero;

public class JavaExample {

    private int mHitPoints = 123;

    public static void main(String[] args) {
        System.out.println(Hero.makeProclamation());


        SpellBook spellBook = new SpellBook();
        // System.out.println(spellBook.getSpells());
        System.out.println(spellBook.spells);
    }

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
}
