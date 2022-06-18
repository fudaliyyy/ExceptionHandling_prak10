/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionhandling;

/**
 *
 * @author Zephyrus
 */
public class Healer extends Character {
    Healer(){
        setHP(70);
        setAttack(10);
        setDefense(10);
    }

    @Override
    public boolean attack(){
        boolean hit = (int) (Math.random()*100) < 85; return hit;
    }
    public void heal(){
        setHP(getHP() + 25);
    }
}
