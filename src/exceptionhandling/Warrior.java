/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionhandling;

/**
 *
 * @author Zephyrus
 */
public class Warrior extends Character {
Warrior(){
        setHP(80);
        setAttack(25);
        setDefense(30);
    }

@Override
    public boolean attack(){
        boolean hit = (int) (Math.random()*100) < 60;
        return hit;
    }
}
