package com.game.view;

import junit.framework.*;

public class JUnitView extends View {
   //A test on JUNIT review
   protected int Player, Actor;
   
   // assigning the values
   protected void setUp(){
      player1=1;
      actor2=1;
   }

   // test method to add two values
   public void Add(){
      double result= player1 + actor2;
      assertTrue(result == 2);
   }
}
