import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Examples {

    public Examples(){

    }

    /* ANIMAL TESTS */

    @Test
    public void testAnimalEats(){
        Bird b = new Bird("Blue",4,12,new Coord2D(2,2),false);
        Cat c = new Cat("Mittens", 6, 12, new Coord2D(0,0), true);
        Chinchilla ch = new Chinchilla("Sparkles", 5, 25, new Coord2D(0, 0), 3);
        Chinchilla chi = new Chinchilla("Sparkles", 5, 25, new Coord2D(0, 0), 3);
        assertEquals(1,b.eats("seeds"));
        assertEquals(2, c.eats("treats"));
        assertEquals(3, ch.eats("pellets"));
        assertEquals(1, chi.eats("hay"));
    }
    @Test
    public void testCatEatsPet(){
        Cat c = new Cat("Aria",4,12,new Coord2D(2,2),true);
        Cat ca = new Cat("Aria",4,12,new Coord2D(2,2),false);
        assertEquals(2,c.eats("cans"));
        assertEquals(1, ca.eats("cans"));
    }
    @Test
    public void testCatEatsTreatsBaby(){
        Cat c = new Cat("Kitten",4,6,new Coord2D(2,2),true);
        assertEquals(1,c.eats("treats"));
    }


    @Test
    public void testChinchillaWeightInOz(){
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals(24, ch.getWeightInOz());
    }

    @Test
    public void animalGetName(){
        Bird b = new Bird("Blue",4,3,new Coord2D(0,0), true);
        Cat c = new Cat("Aria",4,20,new Coord2D(0,0), true);
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals("Blue", b.getName());
        assertEquals("Aria", c.getName());
        assertEquals("Dusty", ch.getName());
    }

    @Test
    public void testGetAge() {
       Bird b = new Bird("Worble",2, 4, new Coord2D(0,0), true);
       Cat c = new Cat("Mittens", 6, 12, new Coord2D(0,0), true);
       Chinchilla ch = new Chinchilla("Sparkles", 5, 25, new Coord2D(0, 0), 3);
       assertEquals(2, b.getAge());
       assertEquals(6, c.getAge());
       assertEquals(5, ch.getAge());
    }

    @Test
    public void testWeightOZ() {
        Bird b = new Bird("Worble",2, 4, new Coord2D(0,0), true);
        Cat c = new Cat("Mittens", 6, 12, new Coord2D(0,0), true);
        Chinchilla ch = new Chinchilla("Sparkles", 5, 25, new Coord2D(0, 0), 3);
        assertEquals(4, b.getWeightInOz());
        assertEquals(12, c.getWeightInOz());
        assertEquals(28, ch.getWeightInOz());
    }

@Test
public void testTotalPets() {
        LinkedList<Zoneable> zones = new LinkedList<>();
    Bird b = new Bird("Worble",2, 4, new Coord2D(0,0), true);
    Cat c = new Cat("Mittens", 6, 12, new Coord2D(0,0), true);
    Chinchilla ch = new Chinchilla("Sparkles", 5, 25, new Coord2D(0, 0), 3);
    SuperPetRescue sp = new SuperPetRescue(zones);
    assertEquals(0, sp.totalPets());
}
@Test
public void testGetHeaviestPetName() {
        LinkedList<Bird> birdList = new LinkedList<>();
        LinkedList<Cat> catList = new LinkedList<>();
        LinkedList<Chinchilla> chinchillaList = new LinkedList<>();
    Bird b = new Bird("Blue",4,12,new Coord2D(2,2),true);
    birdList.add(b);
    BirdZone bz = new BirdZone(birdList);
    Cat c = new Cat("Mittens", 6, 12, new Coord2D(0,0), true);
    catList.add(c);
    CatZone cz = new CatZone(catList);
    Chinchilla ch = new Chinchilla("Sparkles", 5, 25, new Coord2D(0, 0), 3);
    chinchillaList.add(ch);
    ChinchillaZone chz = new ChinchillaZone(chinchillaList);
    LinkedList<Zoneable> rescueList = new LinkedList<>();
    rescueList.add((Zoneable) bz);
    rescueList.add((Zoneable) cz);
    rescueList.add((Zoneable) chz);
    SuperPetRescue p = new SuperPetRescue(rescueList);
    assertEquals("Sparkles", p.getHeaviestPetsName());
}
    /** ZONE Tests */
    @Test
    public void birdZoneTestClosestClipped(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2),true));
        BirdZone bz = new BirdZone(birds);
        assertEquals("Blue", bz.closestPet(4,5));
    }

    @Test
    public void petsAnimalsInZone() {
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2),true));
        birds.add(new Bird("Bluey", 2, 2, new Coord2D(2, 2), true));
        cats.add(new Cat("Marshmallow", 2, 2, new Coord2D(2, 2), true));
        chinchillas.add(new Chinchilla("Maceys", 4, 20, new Coord2D(2, 2), 2));
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(2, bz.petsInZone());
        assertEquals(1, cz.petsInZone());
        assertEquals(1, chz.petsInZone());
    }
    @Test
    public void testHeaviestPetZone() {
        LinkedList<Bird> birds = new LinkedList<>();
        LinkedList<Cat> cats = new LinkedList<>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<>();
        birds.add(new Bird("Blue",1, 3, new Coord2D(2,2), true));
        cats.add(new Cat("Marshmallow", 2, 2, new Coord2D(2, 2), true));
        chinchillas.add(new Chinchilla("Maceys", 4, 20, new Coord2D(2, 2), 2));
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals("Blue", bz.heaviestPet().getName());
        assertEquals("Marshmallow", cz.heaviestPet().getName());
        assertEquals("Maceys", chz.heaviestPet().getName()); }
   @Test
    public void testVoidHeavyPet() {
        LinkedList<Bird> birds = new LinkedList<Bird>();
        LinkedList<Cat> cats = new LinkedList<>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<>();
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(null, bz.heaviestPet());
        assertEquals(null, cz.heaviestPet());
        assertEquals(null, chz.heaviestPet());
    }
    @Test
    public void testAnimalInHumanYears() {
        LinkedList<Bird> birds = new LinkedList<>();
        LinkedList<Cat> cats = new LinkedList<>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<>();
        birds.add(new Bird("Blue",1, 3, new Coord2D(2,2), true));
        cats.add(new Cat("Marshmallow", 2, 2, new Coord2D(2, 2), true));
        chinchillas.add(new Chinchilla("Maceys", 4, 20, new Coord2D(2, 2), 2));
        BirdZone bz = new BirdZone(birds);
        CatZone cz = new CatZone(cats);
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(9, bz.inHumanYears("Blue"));
        assertEquals(-1, bz.inHumanYears("Brown")); // bird does not exist
        assertEquals(12, cz.inHumanYears("Marshmallow"));
        assertEquals(-1, cz.inHumanYears("Mittens")); // cat does not exist
        assertEquals(40, chz.inHumanYears("Maceys"));
        assertEquals(-1, chz.inHumanYears("Kohls")); //chinchilla does not exist
    }
@Test
public void testRestockPetFood() {
    LinkedList<Bird> birds = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    LinkedList<Chinchilla> chinchillas = new LinkedList<>();
    birds.add(new Bird("Blue",1, 3, new Coord2D(2,2), true));
    cats.add(new Cat("Marshmallow", 2, 2, new Coord2D(2, 2), true));
    chinchillas.add(new Chinchilla("Maceys", 4, 20, new Coord2D(2, 2), 2));
    BirdZone bz = new BirdZone(birds);
    CatZone cz = new CatZone(cats);
    ChinchillaZone chz = new ChinchillaZone(chinchillas);
    assertEquals(bz, bz.restockPetFood("seeds",20));
    assertEquals(cz, cz.restockPetFood("cans", 3));
    assertEquals(cz, cz.restockPetFood("treats", 0));
    assertEquals(cz, cz.restockPetFood("cans", -20));
    assertEquals(cz, cz.restockPetFood("treats", 10000));
    assertEquals(chz, chz.restockPetFood("pellets", 20));
    assertEquals(cz.getPantryLabel(), "Cat: -17 cans, 10000 treats");
}
@Test
public void testFeedZone() {
    LinkedList<Bird> birds = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    LinkedList<Chinchilla> chinchillas = new LinkedList<>();
    birds.add(new Bird("Blue",1, 3, new Coord2D(2,2), true));
    cats.add(new Cat("Marshmallow", 2, 2, new Coord2D(2, 2), true));
    chinchillas.add(new Chinchilla("Maceys", 4, 20, new Coord2D(2, 2), 2));
    chinchillas.add(new Chinchilla("Target", 7, 18, new Coord2D(6, 3), 7));
    chinchillas.add(new Chinchilla("Walmart", 3, 21, new Coord2D(3, 8), 9));
    BirdZone bz = new BirdZone(birds);
    CatZone cz = new CatZone(cats);
    ChinchillaZone chz = new ChinchillaZone(chinchillas);
    assertEquals(bz, bz.feedZone());
    assertEquals(cz, cz.feedZone());
    assertEquals(chz, chz.feedZone());
    chz.restockPetFood("pellets", 4);
    chz.restockPetFood("hay", 2);
    chz.feedZone();
    assertEquals("Chinchilla: 0 pellets, 0 hay", chz.getPantryLabel());
}
@Test
public void testGetPet() {
    LinkedList<Bird> birds = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    LinkedList<Chinchilla> chinchillas = new LinkedList<>();
    birds.add(new Bird("Blue",1, 3, new Coord2D(2,2), true));
    cats.add(new Cat("Marshmallow", 2, 2, new Coord2D(2, 2), true));
    chinchillas.add(new Chinchilla("Maceys", 4, 20, new Coord2D(2, 2), 2));
    BirdZone bz = new BirdZone(birds);
    CatZone cz = new CatZone(cats);
    ChinchillaZone chz = new ChinchillaZone(chinchillas);
    assertEquals(birds.get(0), bz.getPet("Blue"));
    assertEquals(null, bz.getPet("Bluey")); //not in zone
    assertEquals(cats.get(0), cz.getPet("Marshmallow"));
    assertEquals(null, cz.getPet("Cocoa")); //not in zone
    assertEquals(chinchillas.get(0), chz.getPet("Maceys"));
    assertEquals(null, chz.getPet("TJ Maxx")); //not in zone
}
@Test
public void testGetPantryLabel() {
    LinkedList<Bird> birds = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    LinkedList<Chinchilla> chinchillas = new LinkedList<>();
    birds.add(new Bird("Blue",1, 3, new Coord2D(2,2), true));
    cats.add(new Cat("Marshmallow", 2, 2, new Coord2D(2, 2), true));
    chinchillas.add(new Chinchilla("Maceys", 4, 20, new Coord2D(2, 2), 2));
    BirdZone bz = new BirdZone(birds);
    CatZone cz = new CatZone(cats);
    ChinchillaZone chz = new ChinchillaZone(chinchillas);
    assertEquals("Bird: 0 seeds", bz.getPantryLabel());
    assertEquals("Cat: 0 cans, 0 treats", cz.getPantryLabel());
    assertEquals("Chinchilla: 0 pellets, 0 hay", chz.getPantryLabel());
}
@Test
public void testClosestPet() {
    LinkedList<Bird> birds = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    LinkedList<Chinchilla> chinchillas = new LinkedList<>();
    birds.add(new Bird("Blue",1, 3, new Coord2D(2,2), true));
    cats.add(new Cat("Marshmallow", 2, 2, new Coord2D(2, 2), true));
    chinchillas.add(new Chinchilla("Maceys", 4, 20, new Coord2D(2, 2), 2));
    BirdZone bz = new BirdZone(birds);
    CatZone cz = new CatZone(cats);
    ChinchillaZone chz = new ChinchillaZone(chinchillas);
    assertEquals("Blue", bz.closestPet(0, 0));
    assertEquals("Marshmallow", cz.closestPet(0, 0));
    assertEquals("Maceys", chz.closestPet(0, 0));
}
    @Test
    public void birdZoneTestHeaviest1Bird(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2),true));
        BirdZone bz = new BirdZone(birds);
        assertEquals("Blue", bz.heaviestPet().getName());
    }

}
