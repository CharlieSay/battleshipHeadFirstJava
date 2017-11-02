package com.charliesay;

import com.charliesay.Entity.Ship;

import java.util.ArrayList;
import java.util.List;

public class BattleField {

    private List<Integer> battleFieldLayout = new ArrayList<Integer>();

    private List<Ship> shipContains = new ArrayList<Ship>();

    public BattleField(int SizeOfField){
        for (int i=1;i<SizeOfField+1;i++){
            battleFieldLayout.add(i);
        }
    }

    public void shipContainerCheck(Ship shiptoAdd){
        shipContains.add(shiptoAdd);
        for (Ship s : shipContains){
            if ((s.getShipLocation().contains(shiptoAdd.getShipLocation()))){
                System.out.println("Already exists.");
            }else{
                continue;
            }
        }
    }

    public List<Ship> getShipContains() {
        return shipContains;
    }

    public boolean checkForLocation(int i){
        for (Ship s : getShipContains()){
          if (s.isDead()){System.out.println("Ship Here is dead already"); return false;}
            for (int integerCheck : s.getShipLocation()){
                if (integerCheck == i){
                    if (s.gotHit(i)){
                        s.removeHitFromLocation(i);
                        return true;
                    }else{
                        s.setIfDead(true);
                        System.out.println("Dead");
                        return false;
                    }

                }else{
                    continue;
                }
            }
        }
        return false;
    }

    public String iterateThroughShips(){
        String builder = "";
        for (Ship s : getShipContains()){
            builder = builder + " " + s.getStringName() + "/" + s.getShipLocation().toString();
        }
        return builder;
    }


    public List<Integer> getBattleFieldLayout() {
        return battleFieldLayout;
    }
}
