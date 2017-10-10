/*
Brief:
Send a list of items (Habitats, bunkers, food supplies, and rovers) to Mars
Use 2 rockets U1 and U2

The Mission is 2 phases
Phase 1 (use U1 rockets)
Send Building equipment and construction
Contains item names and weight in Kgs

Phase 2 (use U2 rockets)
Send the colony of humans with food resources.
Items names and weight in Kgs


Description of Below:
Create a Main class with the main method and start running the simulation:

Create a Simulation object
Load Items for Phase-1 and Phase-2
Load a fleet of U1 rockets for Phase-1 and then for Phase-2
Run the simulation using the fleet of U1 rockets and display the total budget required.
Repeat the same for U2 rockets and display the total budget for that.
 */

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)throws FileNotFoundException{

          u1Simulation();
          u2Simulation();
    }

    private static void u1Simulation()throws FileNotFoundException{
        //Create a Simulation object
        Simulation simulation1 = new Simulation(); //Create a new simulation;
        System.out.println("Create a new simulation object for U1");
        System.out.println("");

        //Load Items for Phase-1 and Phase-2
        ArrayList <Item> phase1 = simulation1.loadItems("phase-1.txt");
        System.out.println("Loaded items for Phase 1");
        ArrayList <Item> phase2 = simulation1.loadItems("phase-2.txt");
        System.out.println("");
        System.out.println("Loaded items for Phase 2");
        System.out.println("");

        //Load a fleet of U1 rockets for Phase-1 and then for Phase-2
        System.out.println("Load a fleet of Phase 1 U1 rockets with items");
        System.out.println("");
        ArrayList<Rocket> rocketPhase1 = simulation1.loadU1(phase1);
        System.out.println(rocketPhase1.size()+" Rockets need to be launched");
        System.out.println("");
        System.out.println("Load a fleet of Phase 2 U1 rockets with items");
        System.out.println("");
        ArrayList<Rocket> rocketPhase2 = simulation1.loadU1(phase2);
        System.out.println(rocketPhase2.size()+" Rockets need to be launched");
        System.out.println("");

        //Run the simulation using the fleet of U1 rockets and display the total budget required.
        System.out.println("Run Simulation of Phase 1 U1 rockets");
        System.out.println("");
        long phase1Cost = simulation1.runSimulation(rocketPhase1);
        System.out.println("");
        System.out.println("Run Simulation of Phase 2 U1 rockets");
        System.out.println("");
        long phase2Cost = simulation1.runSimulation(rocketPhase2);
        System.out.println("");
        System.out.println("Total cost for U1 is: $" + (phase1Cost+phase2Cost));
        System.out.println("");
    }
    private static void u2Simulation()throws FileNotFoundException{
        //Repeat the same for U2 rockets and display the total budget for that.
        Simulation simulation2 = new Simulation();
        System.out.println("Create a new simulation object for U2");
        System.out.println("");

        ArrayList <Item> phase1 = simulation2.loadItems("phase-1.txt");
        System.out.println("Loaded items for Phase 1");
        ArrayList <Item> phase2 = simulation2.loadItems("phase-2.txt");
        System.out.println("");
        System.out.println("Loaded items for Phase 2");
        System.out.println("");

        System.out.println("Load a fleet of Phase 1 U2 rockets with items");
        System.out.println("");
        ArrayList<Rocket> rocketPhase1 = simulation2.loadU2(phase1);
        System.out.println(rocketPhase1.size()+" Rockets need to be launched");
        System.out.println("");
        System.out.println("Load a fleet of Phase 2 U2 rockets with items");
        System.out.println("");
        ArrayList<Rocket> rocketPhase2 = simulation2.loadU2(phase2);
        System.out.println(rocketPhase2.size()+" Rockets need to be launched");
        System.out.println("");

        System.out.println("Run Simulation of Phase 1 U2 rockets");
        System.out.println("");
        long phase1Cost = simulation2.runSimulation(rocketPhase1);
        System.out.println("");
        System.out.println("Run Simulation of Phase 2 U2 rockets");
        System.out.println("");
        long phase2Cost = simulation2.runSimulation(rocketPhase2);
        System.out.println("");
        System.out.println("Total cost for U2 is: $" + (phase1Cost+phase2Cost));
        System.out.println("");

    }

}