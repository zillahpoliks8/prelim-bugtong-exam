package com.uic.prelimexam.poliquitexam;

/**
 * Created by chain on 12/27/2017.
 */

public class Bugtong {
    public String bugtong[];
    public String choices[][];
    public String answer[];

    public final int MAX_SIZE = 5;          //Array maximum size
    public final int TOTAL_SIZE = 5;        //Total questions set for the user
    public static int questionShown = 0;    //Counter for total questions being shown to the user
    public static int SCORE = 50;           /*Scoring Rule:
                                                if correct score => sum of current score and timeremaining multiplied by 10
                                                else score => difference of current score and 10
                                                note: timeremaining is in seconds.
                                             */
    public Bugtong() {
        bugtong = new String [MAX_SIZE];
        choices = new String [MAX_SIZE][4];
        answer = new String [MAX_SIZE];

        bugtong[0] = "Isang balong malalim, punong-puno ng patalim.";
        choices[0][0] = "Bibig";
        choices[0][1] = "Ilong";
        choices[0][2] = "Tainga";
        choices[0][3] = "Mata";
        answer[0] = "A";

        bugtong[1] = "Dalawang batong maitim, malayo ang dinarating.";
        choices[1][0] = "Bibig";
        choices[1][1] = "Ilong";
        choices[1][2] = "Tainga";
        choices[1][3] = "Mata";
        answer[1] = "D";

        bugtong[2] = "Dalawang balon, hindi malingon.";
        choices[2][0] = "Bibig";
        choices[2][1] = "Ilong";
        choices[2][2] = "Tainga";
        choices[2][3] = "Mata";
        answer[2] = "C";

        bugtong[3] = "Naligo ang kapitan, hindi nabasa ang tiyan. ";
        choices[3][0] = "Sasakyan";
        choices[3][1] = "Bangka";
        choices[3][2] = "Bola";
        choices[3][3] = "Gulong";
        answer[3] = "B";

        bugtong[4] = "Limang puno ng niyog, isa’y matayog.";
        choices[4][0] = "Siko";
        choices[4][1] = "Binti";
        choices[4][2] = "Hita";
        choices[4][3] = "Daliri";
        answer[4] = "D";
    }

    public String getBugtong(int index){
        return bugtong[index];
    }

    public String getChoices(int index, int choice){
        return choices[index][choice];
    }

    public String getAnswer(int index){
        return answer[index];
    }

    public int getRandomIndex(){
        return 0 + new java.util.Random().nextInt(MAX_SIZE-1);
    }
}