package com.charliesay.Entity;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private int size;
    private int location;
    private List<Integer> shipLocation = new ArrayList<Integer>();
    private char orientation;
    private int hits;
    private String stringName;
    private boolean isDead;

    public Ship(int size, int locationStart, String stringName, char ori) {
        this.size = size;
        this.location = locationStart;
        this.stringName = stringName;
        this.isDead = false;
        this.orientation = ori; //Left or Right
        positionPopulate();
    }

    public boolean gotHit(Integer hitToRemove){
        if (isDead()){
            return false;
        }else{
            hits++;
            System.out.println(hits);
            if (size == hits){
                setIfDead(true);
                System.out.print("Deub1");
                return false;
            }
            return true;
        }
    }

    public void removeHitFromLocation(Integer hitToRemove){getShipLocation().remove(hitToRemove);}

    public void positionPopulate(){
        if (orientation == 'L'){
            for (int i =0;i<size;i++){
                if ((location-i) <= 0){
                    System.out.println("Hit Zero - Big");
                    shipLocation.clear();
                    break;
                }else{
                    shipLocation.add(location-i);
                }
            }
        }else if (orientation == 'R'){
            for (int i =0;i<size;i++){
                shipLocation.add(location+i);
            }
        }
    }

    public String getStringName() { return stringName; }
    public List<Integer> getShipLocation() { return shipLocation; }
    public boolean isDead(){
        return isDead;
    }
    public void setIfDead(boolean setDead) {this.isDead = setDead;}
}
