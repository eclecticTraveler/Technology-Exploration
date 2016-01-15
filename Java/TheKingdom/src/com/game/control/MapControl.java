package com.game.control;

import com.game.model.Scene;
import com.game.KingdomGame;
import com.game.model.Game;
import com.game.model.Map;
import java.io.Serializable;

public class MapControl implements Serializable{
    public enum SceneType{
        
        begin,
        dungeon1,
        dungeon2,
        dungeon3,
        kingdom,
        end
        
    }//End SceneType
    
    public static Map createMap() {
        
        Map map  = new Map (2,3);   
        Scene[] scenes = createScenes();       
        GameControl.assignScenesToLocations(map, scenes);          
        return map;
        
    }//End createMap()

    private static Scene[] createScenes() {
        Game game = KingdomGame.getCurrentGame(); 
        Scene[] scenes = new Scene[SceneType.values().length];
        
        
        Scene beginScene = new Scene();
        beginScene.setDescription(
        "\n\tSeek out the King in the kingdom.");
        beginScene.setMapSymbol(" 1 ");      
        scenes[SceneType.begin.ordinal()] = beginScene;
        
        
        Scene dungeon1Scene = new Scene();
        dungeon1Scene.setDescription(
        "\n\tIce Caverns");
        dungeon1Scene.setMapSymbol(" 2 ");      
        scenes[SceneType.dungeon1.ordinal()] = dungeon1Scene;
              
        
        Scene dungeon2Scene = new Scene();
        dungeon2Scene.setDescription(
        "\n\tFiery Depths");
        dungeon2Scene.setMapSymbol(" 3 ");      
        scenes[SceneType.dungeon2.ordinal()] = dungeon2Scene;
        
        
        Scene dungeon3Scene = new Scene();
        dungeon3Scene.setDescription(
        "\n\tSpooky Hollow");
        dungeon3Scene.setMapSymbol(" 4 ");      
        scenes[SceneType.dungeon3.ordinal()] = dungeon3Scene;
               
        
        Scene kingdomScene = new Scene();
        kingdomScene.setDescription(
        "\n\tThe Royal Kingdom");
        kingdomScene.setMapSymbol(" 5 ");      
        scenes[SceneType.kingdom.ordinal()] = kingdomScene;
                
        
        Scene endScene = new Scene();
        endScene.setDescription(
        "\n\tKing Jeffrey: You've saved our land, and the lands of so many others."
                + "\n\tThank you, hero.");       
        endScene.setMapSymbol(" 6 ");
        scenes [SceneType.end.ordinal()] = endScene;
        
        return scenes;
        
    }//End createScenes()
    
    static void moveActorsToStartingLocation(Map map) {
    
    }

}//END
