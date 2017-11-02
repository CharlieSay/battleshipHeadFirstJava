package com.charliesay;

import com.charliesay.Entity.Ship;

public class GameHandler {

    public BattleField getBf() {
        return bf;
    }

    private BattleField bf;
    private Ship ship;
    private Ship ship2;

    void setUp(){
        bf = new BattleField(10);
        ship = new Ship(2,4,"Destroyer",'R');
        ship2 = new Ship(2,1,"Pink",'R');
        bf.shipContainerCheck(ship);
        bf.shipContainerCheck(ship2);
    }

    public String checkForHit(Integer hitLoc){
        if(getBf().checkForLocation(hitLoc)){
            return ("Got hit");
        }else{
            return ("No hit");
        }
    }
}
