package Sanuy;

import com.alberto.arellano.JavaCollections.ArrayListExperimentation;

import java.util.ArrayList;

/**
 * Created by rome on 12/16/2015.
 */
public class Competition {
    public static void main(String[] args) {
        ArrayList<SoccerPlayer> actualPlayers;
        int p;

        Fifa game = new Fifa();
    actualPlayers = game.constructingPlayers();

        System.out.println(actualPlayers);
        p = Fifa.addMe();

        Competition competition = new Competition();



    }

}
