public interface SpaceShip {
     boolean launch(); //returns true or flase if the launch was successful
     boolean land(); // returns either true or false based on the success of the landing
     boolean canCarry(Item item); //returns true if the rocket can carry the weight. Returns false it exceeds the weight limit
     int carry(Item item); //Updates the weight of the rocket.

}
