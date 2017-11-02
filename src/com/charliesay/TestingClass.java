package com.charliesay;

import com.charliesay.Entity.Ship;
import org.junit.Assert;
import org.junit.Test;

public class TestingClass {


    @Test
    public void testForBattlefield(){
        BattleField bf = new BattleField(10);
        Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]",bf.getBattleFieldLayout().toString());
    }

    @Test
    public void testForShipPopulation(){
        Ship ship = new Ship(4,4,"Destroyer",'R');
        Assert.assertEquals("[4, 5, 6, 7]",ship.getShipLocation().toString());
    }
   @Test
    public void testForShipinMinusZero() {
       Ship ship = new Ship(4, 1, "Destroyer", 'L');
       Assert.assertEquals("[]", ship.getShipLocation().toString());
   }
    @Test
    public void addShipToBattlefield(){
        BattleField bf = new BattleField(10);
        Ship ship = new Ship(2,4,"Destroyer",'R');
        Ship ship2 = new Ship(2,1,"Pink",'R');
        bf.shipContainerCheck(ship);
        bf.shipContainerCheck(ship2);
        System.out.println(bf.iterateThroughShips());
    }

    @Test
    public void testGameHandlerForHit(){
        GameHandler game = new GameHandler();
        game.setUp();
        System.out.println(game.getBf().iterateThroughShips());
        Assert.assertEquals("Got hit",game.checkForHit(1));
    }

    @Test
    public void testGameHandlerForMiss(){
        GameHandler game = new GameHandler();
        game.setUp();
        System.out.println(game.getBf().iterateThroughShips());
        Assert.assertEquals("No hit",game.checkForHit(7));
    }

    @Test
    public void testForSink(){
        GameHandler game = new GameHandler();
        game.setUp();
        System.out.println(game.getBf().iterateThroughShips());
        game.checkForHit(1);
        game.checkForHit(2);
        game.checkForHit(2);
        System.out.println(game.getBf().iterateThroughShips());
    }
}
