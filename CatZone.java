import java.util.LinkedList;

public class CatZone extends AbstractZone implements Zoneable {
    public LinkedList<Cat> cats;
    int cans;
    int treats;

    /**
     *
     * @param cats
     */
    public CatZone(LinkedList<Cat> cats) {
        this.cats=cats;
        cans=0;
        treats=0;


    }

    /**
     *
     * @param petName the name of the pet.
     * @return the age of the cat in human years
     */
    @Override
    public int inHumanYears(String petName) {
        int age=-2;
        for (Cat ca:cats) {
            if (ca.getName().equals(petName))
            {age=ca.getAge();}
        }
        if (age==-2){
            return -1;
        }
        else {
            return age*6;
        }
    }

    /**
     *
     * @param foodName The name of a food item expected to be stocked in this
    zone's pantry
     * @param foodAmt A non-negative number (>= 0) representing how much of that
    food is going into the pantry
     * @return the current state of the object
     */
    @Override
    public Zoneable restockPetFood(String foodName, int foodAmt) {
        if (foodName.equals("cans")) {
            cans = cans + foodAmt;
        }
        if (foodName.equals("treats")) {
            treats = treats + foodAmt;
        }

        return this;

    }

    /**
     *
     * @return current state of the object
     */

    @Override
    public Zoneable feedZone() {
        for (Cat ct:cats) {
            treats = treats - 1 - ct.getWeightInOz() / 8;
            if (ct.hasBeenPetToday) {
                cans = cans - 2;
            } else {
                cans = cans - 1;
            }
        }

        if (cans<0){
            cans=0;
        }
        if (treats<0){
            treats=0;
        }
        return this;
    }

    /**
     *
     * @param petName the pet to look up in the zone, you may assume the pet is in
    the zone
     * @return the cat with the given petName
     */
    @Override
    public Petable getPet(String petName) {
        Petable pet = null;
        for (Cat ct:cats)
        {
            if (ct.getName().equals(petName))
            {pet=ct;}
        }
        return pet;
    }

    /**
     *
     * @return the amount of cat food in the format "Cat: # cans, # treats"
     */
    @Override
    public String getPantryLabel() {
        return "Cat: "+cans+" cans, "+treats+" treats";
    }

    /**
     *
     * @param c
     * @param x
     * @param y
     * @return the distance the cat has travelled
     */
    public double FindDistance (Cat c, int x, int y) {
        double distance;
        int x_difference;
        int y_difference;

        x_difference=c.location.x-x;
        int x_difference_sqr=x_difference*x_difference;
        y_difference=c.location.y-y;
        int y_difference_sqr=y_difference*y_difference;
        int x_y_add = y_difference_sqr + x_difference_sqr;

        distance=Math.sqrt(x_y_add);

        return distance;

    }

    /**
     *
     * @param x the 3D coord that only has the location information
     * @param y
     * @return the closest cat to the given coordinates
     */
    @Override
    public String closestPet(int x, int y) {

        if(cats.isEmpty()) {
            return "No Pets Found" ;
        }


        else {
            double Least_Distance= Double.MAX_VALUE;
            Cat cat = null;
            for  (Cat ct : cats) {
                if (Least_Distance > FindDistance(ct,x,y) ) {
                    Least_Distance=FindDistance(ct,x,y);
                    cat=ct;
                }
            }
            return cat.getName();
        }
    }



    @Override
    public LinkedList<? extends Petable> getZone() { return this.cats;}

}
