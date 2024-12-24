import java.util.LinkedList;
public class BirdZone extends AbstractZone implements Zoneable {
    public LinkedList<Bird> birds;
    public int Seeds;
    public BirdZone(LinkedList<Bird> birds){
        this.birds=birds;
        Seeds=0;

    }

    /**
     *
     * @param petName the name of the pet.
     * @return the age of the pet converted to human years
     */

    @Override
    public int inHumanYears(String petName) {
        int age=-2;
        for (Bird bi:birds) {
            if (bi.getName().equals(petName))
            {age=bi.getAge();}
        }
        if (age==-2){
            return -1;
        }
        else {
            return age*9;
        }
    }

    /**
     *
     * @param foodName The name of a food item expected to be stocked in this
    zone's pantry
     * @param foodAmt A non-negative number (>= 0) representing how much of that
    food is going into the pantry
     * @return current object instance
     */

    @Override
    public Zoneable restockPetFood(String foodName, int foodAmt) {
        if (foodName.equals("seeds")) {
            Seeds = Seeds + foodAmt;
        }
        return this;
    }

    /**
     *
     * @return current object instance
     */
    @Override
    public Zoneable feedZone() {
        Seeds = Seeds - 1*birds.size();
        if (Seeds<0){
            Seeds=0;
        }
        return this;
    }

    /**
     *
     * @param petName the pet to look up in the zone, you may assume the pet is in
    the zone
     * @return returns the LinkedList for birds
     */
    @Override
    public Petable getPet(String petName) {
        Petable pet = null;
        for (Bird bi:birds)
        {
            if (bi.getName().equals(petName))
            {pet=bi;}
        }
        return pet;
    }

    /**
     *
     * @return the amount of seeds eaten in format "Bird: # seeds"
     */
    @Override
    public String getPantryLabel() {

        return "Bird: "+Seeds+" seeds";
    }

    /**
     *
     * @param c
     * @param x
     * @param y
     * @return the distance calculated of the bird
     */
    public double FindDistance3D (Bird c, int x, int y) {
        double distance;
        if (c.wingsClipped) {

            int x_difference;
            int y_difference;


            x_difference = c.location.x - x;
            int x_difference_sqr = x_difference * x_difference;
            y_difference = c.location.y - y;
            int y_difference_sqr = y_difference * y_difference;
            int x_y_z_add = y_difference_sqr + x_difference_sqr;

            distance = Math.sqrt(x_y_z_add);


        } else {

            int x_difference;
            int y_difference;


            x_difference = c.location.x - x;
            int x_difference_sqr = x_difference * x_difference;
            y_difference = c.location.y - y;
            int y_difference_sqr = y_difference * y_difference;
            int z_difference_sqr = 4;
            int x_y_z_add = y_difference_sqr + x_difference_sqr + z_difference_sqr;

            distance = Math.sqrt(x_y_z_add);

        }
        return distance;
    }

    /**
     *
     * @param x the 3D coord that only has the location information
     * @param y
     * @return the closest pet
     */
    @Override
    public String closestPet(int x, int y) {

        if(birds.isEmpty()) {
            return "No Pets Found" ;
        }
        else {
            double Least_Distance= Double.MAX_VALUE;
            Bird bi = null;
            for  (Bird bd : birds) {
                if (Least_Distance > FindDistance3D(bd,x,y) ) {
                    Least_Distance=FindDistance3D(bd,x,y);
                    bi=bd;
                }
            }
            return bi.getName();
        }
    }
    @Override
    public LinkedList<? extends Petable> getZone() { return this.birds;}
}
