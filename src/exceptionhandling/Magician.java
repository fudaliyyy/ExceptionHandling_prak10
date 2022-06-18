/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionhandling;

/**
 *
 * @author Zephyrus
 */
public class Magician extends Character {
    Magician(){
        setHP(100);
        setAttack(60);
        setDefense(10);
    }

    @Override
    public boolean attack(){
        boolean hit = (int) (Math.random()*100) < 35;
        return hit;
    }
}
