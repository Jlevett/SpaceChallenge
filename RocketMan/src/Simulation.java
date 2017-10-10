/*
Simulation class is responsible for reading item data and filling up the rockets.

loadItems: This method loads all items from a text file and returns an ArrayList of Items.
           Read the text file line by line and create an Item object for each and
           then add it to an ArrayList of Items. The method should then return that ArrayList.
loadU1: This method takes the ArrayList of Items returned from loadItems and starts creating
        U1 rockets. It first tries to fill up 1 rocket with as many items as possible before creating
        a new rocket object and filling that one until all items are loaded. The method then returns the
        ArrayList of those U1 rockets that are fully loaded.
loadU2: This method also takes the ArrayList of Items and starts creating U2 rockets and filling
        them with those items the same way as with U1 until all items are loaded. The method then returns
        the ArrayList of those U2 rockets that are fully loaded.
runSimulation: This method takes an ArrayList of Rockets and calls launch and land methods for each
               of the rockets in the ArrayList. Every time a rocket explodes or crashes (i.e if launch or land return
               false) it will have to send that rocket again. All while keeping track of the total budget required to
               send each rocket safely to Mars. runSimulation then returns the total budget required to send all
               rockets (including the crashed ones).
*/


import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Simulation {

/*loadItems: This method loads all items from a text file and returns an ArrayList of Items.
           Read the text file line by line and create an Item object for each and
           then add it to an ArrayList of Items. The method should then return that ArrayList. */
    public ArrayList<Item> loadItems(String txtfile) throws FileNotFoundException {
        ArrayList<Item> arrayList = new ArrayList<>();
        File file = new File(txtfile);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("=");

            Item newItem = new Item(parts[0], Integer.parseInt(parts[1]));
            arrayList.add(newItem);
        }
        return arrayList;

    }

/*loadU1: This method takes the ArrayList of Items returned from loadItems and starts creating
        U1 rockets. It first tries to fill up 1 rocket with as many items as possible before creating
        a new rocket object and filling that one until all items are loaded. The method then returns the
        ArrayList of those U1 rockets that are fully loaded.

       I designed loadU1 to use a while loop to demonstrate that this method can be achieved */
    public ArrayList<Rocket> loadU1(ArrayList<Item> itemList){
        ArrayList<Rocket> u1RocketsArrayList = new ArrayList<>();//Create an ArrayList of rockets
        int itemCounter=0; //Tracks item no#

        while(itemCounter < itemList.size()) {
            Rocket u1Rocket = new U1();//Create a new rocket.
            while (u1Rocket.canCarry(itemList.get(itemCounter))) {//Check if it can carry this next particular item
                u1Rocket.carry(itemList.get(itemCounter));//Add item to rocket
                itemCounter++; //increment to next item
                if(itemCounter == itemList.size())break;
            }
            u1RocketsArrayList.add(u1Rocket);
        }
        return u1RocketsArrayList;
    }

/*loadU2: This method also takes the ArrayList of Items and starts creating U2 rockets and filling
        them with those items the same way as with U1 until all items are loaded. The method then returns
        the ArrayList of those U2 rockets that are fully loaded.

        I designed U2 to use a enchanced for loop to demonstrate that this method can be achieved */
   public ArrayList<Rocket> loadU2(ArrayList<Item> itemList) {//METHOD START
       ArrayList<Rocket> u2RocketsArrayList = new ArrayList<>();//Create an ArrayList of rockets
       Rocket u2Rocket = new U2();//Create a new rocket.

        int counter =0;
        for (Item x : itemList) { //go through the passed array of lists.
            counter++;
            if (u2Rocket.canCarry(x)){ u2Rocket.carry(x);}
            else { //If cannot Carry
                u2RocketsArrayList.add(u2Rocket);
                u2Rocket = new U2();//Create a new rocket.
                u2Rocket.canCarry(x); //If can carry
                u2Rocket.carry(x);  //then add.
                if(counter == itemList.size() - 1)u2RocketsArrayList.add(u2Rocket);
            }
        }
        return u2RocketsArrayList;
    }

/*runSimulation: This method takes an ArrayList of Rockets and calls launch and land methods for each
               of the rockets in the ArrayList. Every time a rocket explodes or crashes (i.e if launch or land return
               false) it will have to send that rocket again. All while keeping track of the total budget required to
               send each rocket safely to Mars. runSimulation then returns the total budget required to send all
               rockets (including the crashed ones).*/
    public long runSimulation(ArrayList<Rocket> rockets){
        long totalBudget = 0;
        int rocketCounter =0;

        for(Rocket thisRocket: rockets) {
            boolean launchResult = thisRocket.launch();
            boolean landingResult;
            if (thisRocket.land()) landingResult = true;
            else landingResult = false;

            while (!launchResult || !landingResult) {
                rocketCounter++;
                totalBudget += thisRocket.getRocketCost();
                System.out.println("Rocket " + rocketCounter + " unsuccesfull! Send the exact same payload, model and pray!");
                launchResult = thisRocket.launch();
                landingResult = thisRocket.land();
            }
            if (launchResult&&landingResult) {
                rocketCounter++;
                totalBudget += thisRocket.getRocketCost();
                System.out.println("Rocket " + rocketCounter + " succesfull!");
            }
        }
    return totalBudget;
    }
}


