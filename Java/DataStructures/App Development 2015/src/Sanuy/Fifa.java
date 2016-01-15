package Sanuy;

import java.util.ArrayList;

/**
 * Created by rome on 12/16/2015.
 */
public class Fifa {

    public Fifa() {
    }

    public ArrayList constructingPlayers() {
    SoccerPlayer player1 = new SoccerPlayer();

    SoccerPlayer player2 = new SoccerPlayer("Messi", 5, 60, "Barcelona", "Forward", 10);

    player1.setName("Ronaldo");
    player1.setClub("Madrid");
    player1.setHeight(6);
    player1.setNumber(7);
    player1.setWeight(80);
    player1.setPosition("Forward");

    ArrayList<SoccerPlayer> players = new ArrayList();
    players.add(player1);
    players.add(player2);

    System.out.println("Players added");

        return players;

}
    public static int addMe(){
        return 2;
    }

}

