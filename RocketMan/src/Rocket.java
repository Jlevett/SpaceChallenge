/*
Create a SpaceShip Interface that includes the definitions of these methods:

        launch: a method that returns either true or false indicating if
                the launch was successful or if the rocket has crashed.
        land: a method that also returns either true or false based on the success of the landing.
        canCarry: a method that takes an Item as an argument and returns true if the
                  rocket can carry such item or false if it will exceed the weight limit.
        carry: a method that also takes an Item object and updates the current weight of the rocket.
*/

public class Rocket implements SpaceShip {

    protected long rocketCost;

    protected int rocketMaximumWeightWithCargo;
    protected int rocketMaximumWeightWithoutCargo;
    protected int maximumCargoWeight;
    protected int currentWeightOfRocket;

    protected double chance;
    protected double percent;

    //Methods From inteface Spaceship

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public int carry(Item item) {//a method that also takes an Item object and updates the current weight of the rocket.
        currentWeightOfRocket +=item.getWeight();
        System.out.println("Current rocket Weighs: " + currentWeightOfRocket);
        return currentWeightOfRocket;
    }

    @Override
    public boolean canCarry(Item item) {//  a method that takes an Item as an argument and returns true if the rocket can carry such item or false if it will exceed the weight limit.
        if ((currentWeightOfRocket + item.getWeight()) <= maximumCargoWeight) {
            System.out.println("Can add item to this Rocket.");
            return true;
        } else {
       System.out.println("Cannot add item! Another Rocket is needed!");
        return false;
        }
    }

    public long getRocketCost(){
        return rocketCost;
    }
}



