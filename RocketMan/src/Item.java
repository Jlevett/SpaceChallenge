/*
Create an Item class that includes a String name
and an int weight that will represent an item to be carried by the rockets
 */
public class Item {
    private String name;
    private int weight;

    public Item(String y, int x){
        this.name = y;
        this.weight = x;
    }
    public int getWeight(){return weight;}
}
