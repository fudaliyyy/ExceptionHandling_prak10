/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionhandling;

/**
 *
 * @author Zephyrus
 */
public abstract class Character {
    private int defense, attack, HP;
    public abstract boolean attack();

    public void receiveDamage(int damage){
        damage = damage - this.defense;
        int newHP = (damage < 0)? this.HP : this.HP - damage;
        if(newHP < 0){
            setHP(0);
        } else {
            setHP(newHP);
        }
    }

    public void info(){
        System.out.println("Role : " + this.getClass().getSimpleName());
        System.out.println("HP : " + this.HP); System.out.println("Attack : " + this.attack);
        System.out.println("Defense : " + this.defense);
    }

    //Setter-Getter
    public void setDefense(int defense){
        this.defense = defense;
    }
    public int getDefense(){
        return this.defense;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }
    public int getAttack(){
        return this.attack;
    }
    public void setHP(int HP){
        this.HP = HP;
    }
    public int getHP(){
        return this.HP;
    }
}