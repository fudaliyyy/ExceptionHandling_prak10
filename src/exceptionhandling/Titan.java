/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionhandling;

/**
 *
 * @author Zephyrus
 */
public class Titan extends Character {
    Titan(){
        setHP(200);
        setAttack(45);
    }
    @Override
    public boolean attack(){
        boolean hit = (int) (Math.random()*100) < 40;
        return hit;
    }
}
