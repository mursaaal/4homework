package com.company;

import java.util.Random;

public class Main {

    public static int bossHealth = 700;
    public static int[] heroesHealth = {250, 250, 250, 250};

    public static int bossAttack = 50;
    public static int[] heroesAttack = {20, 20, 20, 10};

    public static String bossDefenceType = "";
    public static String[] heroesAttackType = {"physical", "magical", "kinetic", "hill"};
    public static int heroHill = {20};

    public static void main(String[] args) {
        int roundNumber = 1;
        printStatistics(1);
        while (!isFinished()) {
            round(roundNumber);
            roundNumber++;
        }

    }

    public static void changeBossDefence() {
        Random r = new Random();
        int randomIndex = r.nextInt(3);
        bossDefenceType = heroesAttackType[randomIndex];
        System.out.println("boss defence: " + bossDefenceType);

    }

    public static void round(int number) {
        bossHit();
        heroesHit();
        heroHill();
        printStatistics();

    }

    public static boolean isFinished(){
        if (bossHealth <= 0) {
            System.out.println("heroes win!");
            return true;
        }
        if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0) {
            System.out.println("boss wins!");
            return true;
        }
        return false;
    }

    public static void bossHit(){
        for (int i = 0; i < heroesHealth.length; i++) {
            heroesHealth[i] = heroesHealth[i] - bossAttack;

            if (bossDefenceType.equals(heroesAttackType[i])){

            }
        }
    }

    public static void heroesHit(){
        for (int i = 0; i < heroesAttack.length; i++) {
            if (bossHealth>0 && heroesHealth[i]>0) {
                if (bossDefenceType.equals(heroesAttackType[i])) {
                    Random r = new Random();
                    int randomNumber = r.nextInt(9) + 2;
                    bossHealth = bossHealth - heroesAttack[i] * randomNumber;
                    System.out.println("critical damage" + (heroesAttack[i] * randomNumber));

                } else {
                    bossHealth = bossHealth - heroesAttack[i]; // bossHealth -= heroesAttack[i];
                }
                bossHealth = bossHealth - heroesAttack[i];
            }
        }
        public static void heroHill(){
            for(int i = 0; i <heroesHealth.length ; i++){
                if(heroesHealth[i]>0 && heroesHealth[3]>0){
                    heroesHealth [i] = heroesHealth[i] + heroHill;
                }
            }
        }

        public static void printStatistics(int round){
            System.out.println("__________________________________");
            System.out.println("Round " + round);
            System.out.println("boss health: " + bossHealth);
            System.out.println("warrior health: " + heroesHealth[0]);
            System.out.println("physical health: " + heroesHealth[1]);
            System.out.println("magical health: " + heroesHealth[2]);
            System.out.println("hiller health " + heroesHealth[3]);
            System.out.println("_________________________________");
        }
    }
}
