/*
Create classes U1 and U2 that extend the Rocket class and
override the land and launch methods to calculate the corresponding
chance of exploding and return either true or false based on a random
number using the probability equation for each


U-1 Rocket Specifications
Rocket cost = $100 Million
Rocket weight = 10 Tonnes
Max weight (with cargo) = 18 Tonnes
Chance of launch explosion = 5% * (cargo carried / cargo limit)
Chance of landing crash = 1% * (cargo carried / cargo limit)
 */


public class U1 extends Rocket {

    public U1() { //intial constructor
        rocketMaximumWeightWithoutCargo = 10000;
        rocketMaximumWeightWithCargo = 18000;
        currentWeightOfRocket =0;
        maximumCargoWeight=rocketMaximumWeightWithCargo-rocketMaximumWeightWithoutCargo;

        rocketCost = 100000000;
    }

    public boolean launch() {
        percent = 0.05;
        chance = Math.random();
        double chanceOfLaunchExploding = percent * ((double) currentWeightOfRocket / (double) maximumCargoWeight);
        if (chanceOfLaunchExploding >= chance) {
            System.out.println("U1 Blew Up On Launch!");
            return false;
        } else {
            System.out.println("U1 has had a Successful Launch!");
            return true;
        }
    }

    public boolean land() {
        percent = 0.01;
        chance = Math.random();
        double chanceOfLaunchExploding = percent * ((double) currentWeightOfRocket / (double) maximumCargoWeight);
        if (chanceOfLaunchExploding >= chance) {
            System.out.println("U1 Blew Crashed On Landing!");
            return false;
        } else {
            System.out.println("U1 has had a Successful Landing!");
            return true;

        }
    }
    public long getRocketCost(){
        return rocketCost;
    }
}