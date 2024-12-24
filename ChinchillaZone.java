import java.util.LinkedList;

public class ChinchillaZone extends AbstractZone implements Zoneable {


    public LinkedList<Chinchilla> chinchillas;
    int PantryHay;
    int PantryPellets;

    String PantryLabel;


    public ChinchillaZone(LinkedList<Chinchilla> chinchillas) {

        this.chinchillas=chinchillas;
        PantryHay=0;
        PantryPellets=0;
        PantryLabel="Chinchilla: "+PantryPellets+" pellets, "+PantryHay+" hay";

    }

    /**
     * Looks up a pet in the zone and computers its age relative to human years
     *
     * @param petName the name of the pet.
     * @return the age of the pet converted into human years using the per-pet
     * calculation
     * or -1 if that pet name is not in this zone
     */
    @Override
    public int inHumanYears(String petName) {
        int age=-2;
        for (Chinchilla chin:chinchillas) {
            if (chin.getName().equals(petName))
            {age=chin.getAge();}
        }
        if (age==-2){
            return -1;
        }
        else {
            return age*10;
        }
    }

    /**
     * @param foodName The name of a food item expected to be stocked in this
     *                 zone's pantry
     * @param foodAmt  A non-negative number (>= 0) representing how much of that
     *                 food is going into the pantry
     * @return `this` zone for the purpose of method chaining
     */
    @Override
    public Zoneable restockPetFood(String foodName, int foodAmt) {
        if (foodName.equals("pellets")) {
            PantryPellets = PantryPellets + foodAmt;
        }
        if (foodName.equals("hay")) {
            PantryHay = PantryHay + foodAmt;
        }

        return this;

    }
    /**
     * For each animal in the zone, brings them in to eat
     * Use their eats() method on each type of food in the pantry for them
     *
     * @return `this` zone for the purpose of method chaining
     * If a food item in the zone goes negative, set it to 0. (No need for
     * "unknown" logic).
     */
    @Override
    public Zoneable feedZone() {
        PantryPellets = PantryPellets - 3*chinchillas.size();
        PantryHay = PantryHay - 1*chinchillas.size();
        if (PantryHay<0){
            PantryHay=0;
        }
        if (PantryPellets<0){
            PantryPellets=0;
        }
        return this;
    }

    /**
     *
     * @param petName the pet to look up in the zone, you may assume the pet is in
    the zone
     * @return the pet with the given petName
     */
    @Override
    public Petable getPet(String petName) {
        Petable pet = null;
        for (Chinchilla chin:chinchillas)
        {
            if (chin.getName().equals(petName))
            {pet=chin;}
        }
        return pet;
    }

    /**
     *
     * @return the amount of food for Chinchillas in format "Chinchilla: # pellets, # hay"
     */
    @Override
    public String getPantryLabel() {
        return
                "Chinchilla: " + PantryPellets + " pellets," + " " + PantryHay + " hay" ;
    }

    /**
     *
     * @param c
     * @param x
     * @param y
     * @return distance of the given chinchilla
     */
    public double FindDistance (Chinchilla c, int x, int y) {
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
     * @return the name of the closest chinchilla to the given coordinates
     */
    @Override
    public String closestPet(int x, int y) {

        if(chinchillas.isEmpty()) {
            return "No Pets Found" ;
        }


        else {
            double Least_Distance= Double.MAX_VALUE;
            Chinchilla chin = null;
            for  (Chinchilla ct : chinchillas) {
                if (Least_Distance > FindDistance(ct,x,y) ) {
                    Least_Distance=FindDistance(ct,x,y);
                    chin=ct;
                }
            }
            return chin.getName();
        }
    }
    @Override
    public LinkedList<? extends Petable> getZone() { return this.chinchillas;}
}
