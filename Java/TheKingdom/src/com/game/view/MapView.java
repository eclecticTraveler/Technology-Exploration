//// Java Collections - This is for the MAP, which I aptly named MapView
//package com.game.view;
//
//import com.game.KingdomGame;
//import com.game.model.Dungeon1;
//import com.game.model.Dungeon2;
//import com.game.model.Dungeon3;
//import com.game.model.Game;
//import com.game.model.Item;
//import com.game.model.Location;
//import com.game.model.Map;
//
//import java.util.HashMap;
//
//public class Map extends View {
//
//{
//
//    public static void main(String[] args)
//
//    {
//
//        HashMap<Integer, String> mapview = new HashMap<Integer, String>();
//
//        mapView.put(0001, "King");
//        mapView.put(0010, "Prince");
//        mapView.put(0011, "EvilTowerGuy");
//
//        System.out.println("mapView : " + mapView + "\n");
//
//        /*
//         * http://google-collections.googlecode.com/svn/trunk/javadoc/com/google/common/collect/ForwardingSortedMap.html
//         * Returns a view of the portion of this map whose keys range from fromKey, inclusive, to toKey, exclusive.
//         * subMap(K fromKey, K toKey)
//         */
//
//        screenMap<Integer, String> screenMap = mapView.subMap(0001, false,
//
//                0010, false);
//
//
//
//        System.out
//
//                .println("screenMap [fromInclusive and toInclusive are both false] : "
//
//
//                        + screenMap + "\n");
//
//
//        screenMap = mapView.subMap(0010, true,
//
//                0001, true);
//
//
//        System.out
//
//                .println("screenMap [fromInclusive and toInclusive are both true] : "
//
//                        + screenMap + "\n");
//
//
//    }
//
//
//}
