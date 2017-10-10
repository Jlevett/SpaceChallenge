/*
Create classes U1 and U2 that extend the Rocket class and
override the land and launch methods to calculate the corresponding
chance of exploding and return either true or false based on a random
number using the probability equation for each

U-2 Rocket Specifications
Rocket cost = $120 Million
Rocket weight = 18 Tonnes
Max weight (with cargo) = 29 Tonnes
Chance of launch explosion = 4% * (cargo carried / cargo limit)
Chance of landing crash = 8% * (cargo carried / cargo limit)
 */

public class U2 extends Rocket {


    public U2() { //intializer method als known as constructyor
        rocketMaximumWeightWithoutCargo = 18000;
        rocketMaximumWeightWithCargo = 29000;
        currentWeightOfRocket =0;
        maximumCargoWeight=rocketMaximumWeightWithCargo-rocketMaximumWeightWithoutCargo;

        rocketCost = 120000000;
    }

    public boolean launch() {
        chance = Math.random();
        percent = 0.04;
        double chanceOfLaunchExploding = percent * ((double) currentWeightOfRocket / (double) maximumCargoWeight);
        if (chanceOfLaunchExploding >= chance) {
            System.out.println("U2 Blew Up On Launch!");
            return false;
        } else {
            System.out.println("U2 has had a Successful Launch!");
            return true;
        }
    }

    public boolean land() {
        chance = Math.random();
        percent = 0.08;
        double chanceOfLaunchExploding = percent * ((double) currentWeightOfRocket / (double) maximumCargoWeight);
        if (chanceOfLaunchExploding >= chance) {
            System.out.println("U2 Blew Crashed On Landing!");
            return false;
        } else {
            System.out.println("U2 has had a Successful Landing!");
            return true;
        }
    }
    public long getRocketCost(){
        return rocketCost;
    }
}