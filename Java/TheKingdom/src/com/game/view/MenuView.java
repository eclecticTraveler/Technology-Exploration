package com.game.view;

import static com.game.view.NewGame.waitTime;

public class MenuView extends View {
    public MenuView() {
        super("\n"
                + "\n\t---------------------------------------"
                + "\n\t  Welcome to the Menu "
                + "\n\t---------------------------------------"
                + "\n\t1 - New Game                          |"
                + "\n\t2 - Load Game                         |"
                + "\n\t3 - Options                           |"
                + "\n\t4 - Help                              |"
                + "\n\t5 - Credits                           |"
                + "\n\t                                      |"
                + "\n\tq - Exit to Desktop                   |"
                + "\n\t---------------------------------------");}
    
    public void doAction(char option) {
        //char option = value.charAt(0);
        switch (option) {
            case '1': //create and start a new game
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                startNewGame();
                break;
                
            case '2': //load an existing game
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                startExistingGame();
                break;
                
            case '3': //display the options menu
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                displayOptionsMenu();
                break;
                
            case '4': //display the help menu
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                displayHelpMenu();
                break;
                
            case '5': //display the credits
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                displayCreditsMenu();
                break;
                
            case 'q': //exit the game
                
                URL OptionClickSoundUrl = new URL("https://www.freesound.org/people/annabloom/sounds/219068/");
                AudioClip OptionClickSound = Applet.newAudioClip(OptionClickSoundUrl);
                OptionClickSound.play();
                
                exitGame();
                return;
                
            default:
                
                System.out.println("\n Invalid selection!");
                break;
                
        }
    }

    private void startNewGame() {
        NewGame newGame = new NewGame();
        newGame.display();
    }

    private void startExistingGame() {
        LoadGame load = new LoadGame();
        load.display();
    }

    private void displayOptionsMenu() {
        OptionsView options = new OptionsView();
        options.display();
    }

    private void displayHelpMenu() {
        HelpMenuView help = new HelpMenuView();
        help.display();
    }

    private void displayCreditsMenu() {
        CreditsView credits = new CreditsView();
        credits.display();
    }

    private void exitGame() {
        System.out.println("Thanks for playing! Want to see more? Visit SilverOasis.US!");
        waitTime(25000);
        System.exit(0);
    }

    @Override
    public String getInput() {
        System.out.println("*** string getInput ***");
        return null;
    }

    @Override
    public void doAction(String value) {
        System.out.println("*** doAction ***");
    }
    
}//END
