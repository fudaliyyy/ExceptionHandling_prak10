/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Zephyrus
 */
public class ExceptionHandling {

    /**
     * @param args the command line arguments
     */
    static final Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        welcome();
        String name = in.nextLine();
        choosingClass(name);
        System.out.println("Thank you for playing !\n");
    }
    //Method Menu
    static void welcome(){
        System.out.println("==== Welcome to My Simple TurnBased Battle ! ====");
        System.out.println("Please Input your Name");
        System.out.print("NAME : ");
    } static void classMenu(){
        System.out.println("\nChoose your Class");
        System.out.println("[1]. MAGICIAN ");
        System.out.println("[2]. HEALER ");
        System.out.println("[3]. WARRIOR ");
    }
    static void choosingClass(String name){
        Character player;
        classMenu();
        int input = 0;
        try{
            input = in.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Wrong Input!");
        }
        in.nextLine();
        String agreed = "";
        switch(input){
            case 1 -> {
                System.out.println("You chose Magician, A descendant of a great Mage. \nYou can deal massive damage in cost of your hit chance and defense."
                );
                System.out.println("\nAre you sure you want to pick this class? (Yes/No)");
                agreed = in.nextLine();
                if(agreed.equalsIgnoreCase("Yes")){
                    player = new Magician();
                    start(player, name);
                }
                else{ break; }
            }
            case 2 -> {
                System.out.println("You chose Healer, A chosen scholar from holy ground. \nHealing is your specialty, you can heal every 2 rounds. ");
                System.out.println("\nAre you sure you want to pick this class? (Yes/No)");
                agreed = in.nextLine();
                if(agreed.equalsIgnoreCase("Yes")){
                    player = new Healer();
                    start(player, name);
                }
                else{ break; }
            }
 case 3 ->  {
     System.out.println("You chose Warrior, A fierce fighter in the great war. \nYou have good defense and hit chance, balance in every aspect. "
     );
     System.out.println("\nAre you sure you want to pick this class? (Yes/No)");
     agreed = in.nextLine();
     if(agreed.equalsIgnoreCase("Yes")){
         player = new Warrior();
         start(player, name);
     }
     else{ break; }
            }
            default -> choosingClass(name);
        }
        if(agreed.equalsIgnoreCase("No")){
            choosingClass(name);
        }
    }

    //Fight
    static void start(Character player, String name){
        System.out.println("================ STATS ================");
        player.info();
        System.out.println("=======================================");
        System.out.println("(Press anything to continue...)");
        in.nextLine();
        Titan titan = new Titan();

        int turn = 1;
        boolean end = false;
        while(!end){
            //Player Turn
            System.out.printf("=============== TURN %d ================\n", turn );
            boolean playerHit = player.attack();
            boolean titanHit = titan.attack();
            if(turn % 2 == 0 && turn > 0 && player instanceof Healer){
                randomizeHeal();
                ((Healer)player).heal();
            }
            randomizeAttack(player);
            if(playerHit){ randomizeSuccessfulAttack(player);
                titan.receiveDamage(player.getAttack());
                if(titan.getHP() == 0){
                    System.out.println("\nYou won !");
                    break;
                }
            } else{
                randomizeMissedAttack();
            }
            for(int i = 0; i < 100; i++){System.out.print("");}

            //Titan Turn
            System.out.println("=======================================");
            randomizeAttack(titan);
            if(titanHit){
                randomizeSuccessfulAttack(titan);
                player.receiveDamage(titan.getAttack());
                if(player.getHP() == 0){
                    System.out.println("\nYou died.");
                    break;
                }
            } else{
                randomizeMissedAttack();
            }
            for(int i = 0; i < 100; i++){System.out.print("");}
            //End Turn
            System.out.println("=======================================");
            System.out.printf("%s\t: %d\n", name, player.getHP());
            System.out.printf("%s\t: %d\n", titan.getClass().getSimpleName(),
                    titan.getHP());
            System.out.println("=======================================");
            System.out.println("(Press anything to continue...)");
            in.nextLine();
            turn++;
        }
        System.out.println();
        System.out.println("============== END BATTLE ==============");
        System.out.println("Name : " + name);
        player.info();
        System.out.println();
        titan.info();
        System.out.println("========================================");
    }

    static void randomizeAttack(Character player){ int rng= (int) (Math.random()*4);
        if(player instanceof Magician){
        switch (rng) {
            case 0 -> System.out.println("You cast Meteor Shower");
            case 1 -> System.out.println("You cast Frost Nova ");
            case 2 -> System.out.println("You cast Icicle Lance");
            case 3 -> System.out.println("You summon Thunderstorm ");
            default -> {
            }
        }
        }
        else if(player instanceof Warrior){
        switch (rng) {
            case 0 -> System.out.println("You swing your blade ");
            case 1 -> System.out.println("You throw your blade ");
            case 2 -> System.out.println("You charge and attack furiously");
            case 3 -> System.out.println("You punch the Titan at full force ");
            default -> {
            }
        }
        } else if(player instanceof Healer){
        switch (rng) {
            case 0 -> System.out.println("You cast Holy Light ");
            case 1 -> System.out.println("You cast Lex Divina ");
            case 2 -> System.out.println("You cast Adoramus ");
            case 3 -> System.out.println("You throw Holy Water ");
            default -> {
            }
        }
        } else if(player instanceof Titan){
        switch (rng) {
            case 0 -> System.out.println("The Titan grab and throw you ");
            case 1 -> System.out.println("The Titan bite your leg ");
            case 2 -> System.out.println("The Titan try to pull your head ");
            case 3 -> System.out.println("The Titan throw its punch");
            default -> {
            }
        }
        }
    }
    static void randomizeHeal(){
        int rng = (int) (Math.random()*3); switch(rng){
            case 0 -> System.out.println("Goddess blessed you, all pains are gone ")
                ;
            case 1 -> System.out.println("Divine hear your wishes, your wounds healed ");
            case 2 -> System.out.println("You cast Heal ");
            default -> {
            }
        }
        System.out.println("Restored 25 HP.\n");
    }
    static void randomizeMissedAttack(){
        int rng = (int) (Math.random()*5);
        switch (rng) {
            case 0 -> System.out.println("But it failed.");
            case 1 -> System.out.println("But it missed.");
            case 2 -> System.out.println("But it's not effective.");
            case 3 -> System.out.println("But it doesn't work.");
            case 4 -> System.out.println("But it's not working.");
            default -> {
            }
        }
    }
    static void randomizeSuccessfulAttack(Character player){
        if(player instanceof Magician){
            System.out.println("Dealt 60 damage.");
        } else if(player instanceof Warrior){
            System.out.println("Dealt 25 damage.");
        } else if (player instanceof Healer){
            System.out.println("Dealt 10 damage.");
        } else if (player instanceof Titan){
            System.out.println("It deals 45 damage. ");
        }
    }
}
