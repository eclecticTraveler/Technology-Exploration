package Sanuy;

/**
 * Created by rome on 12/16/2015.
 */
public class SoccerPlayer {

    private String name;
    private int height;
    private int weight;
    private String club;
    private String position;
    private int number;

    public  SoccerPlayer(){

    }

    public SoccerPlayer(String name, int height, int weight, String club, String position, int number) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.club = club;
        this.position = position;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
