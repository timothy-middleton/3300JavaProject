/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3300project;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Timothy Middleton
 */


public class Java3300Project {

    public static void lastNumberBeforeZero(int num, int subtracter)
    {
        if(num - subtracter <= 0)
        {
            System.out.println();
        } else
        {
            lastNumberBeforeZero(num-subtracter, subtracter);
        }
    }

    public static void main(String[] args) {
        final String[] names = {"Furball", "Destroyer", "Baba Yaga", "Chowder", "Flavonious", "Flavorious", "Gardevoir", "Pollo"};
        System.out.println("Step 1: Creating parent pets");
        List<Pet> emptyAncestry = new ArrayList<Pet>(); 
        List<Dog> dogs = new ArrayList<Dog>();
        List<Cat> cats = new ArrayList<Cat>();        
        Dog barryDog = new Dog("Barry", 2, emptyAncestry);
        System.out.println(String.format("Barry the %d year old %s has arrived.", barryDog.getAge(), barryDog.getSpecies()));
        Dog lucyDog = new Dog("Lucy", 2, emptyAncestry);
        System.out.println(String.format("Lucy the %d year old %s has arrived.", lucyDog.getAge(), lucyDog.getSpecies()));
        Dog maryDog = new Dog("Mary", 1, emptyAncestry);
        System.out.println(String.format("Mary the %d year old %s has arrived.", maryDog.getAge(), maryDog.getSpecies()));
        Dog chadDog = new Dog("Chad", 1, emptyAncestry);
        System.out.println(String.format("Chad the %d year old %s has arrived.", chadDog.getAge(), chadDog.getSpecies()));
        dogs.add(chadDog);
        dogs.add(barryDog);
        dogs.add(lucyDog);
        dogs.add(maryDog);
        Cat fuzzyCat = new Cat("Fuzzy", 3, emptyAncestry);
        System.out.println(String.format("Fuzzy the %d year old %s has arrived.", fuzzyCat.getAge(), fuzzyCat.getSpecies()));
        Cat fluffyCat = new Cat("Fluffy", 3, emptyAncestry);
        System.out.println(String.format("Fluffy the %d year old %s has arrived.", fluffyCat.getAge(), fluffyCat.getSpecies()));
        Cat candaceCat = new Cat("Candace", 4, emptyAncestry);
        System.out.println(String.format("Candace the %d year old %s has arrived.", candaceCat.getAge(), candaceCat.getSpecies()));
        Cat chuckCat = new Cat("Chuck", 4, emptyAncestry);
        System.out.println(String.format("Chuck the %d year old %s has arrived.", chuckCat.getAge(), chuckCat.getSpecies()));
        cats.add(fuzzyCat);
        cats.add(fluffyCat);
        cats.add(candaceCat);
        cats.add(chuckCat);
        
        System.out.println("All Parents created\n");
        System.out.println("Step 2: Trying to breed dogs and cats");
        
        dogs.forEach(d -> 
        {
            cats.forEach(c -> 
            {
                try
                {
                    Pet invalidPet = c.mate(d, "This name won't be used anyways.");
                } catch(AnimalSpeciesException e)
                {
                    System.out.println(e.getMessage());
                } 
                
            });
        });
        System.out.println("\nStep 3: Trying to breed animals of the same Species.");
        try
        {
            Pet pet1 = chuckCat.mate(candaceCat, names[0]);
            System.out.printf("%s the %s was born.\n", pet1.getName(), pet1.getSpecies());
            Pet pet2 = chadDog.mate(lucyDog, names[1]);
            System.out.printf("%s the %s was born.\n", pet2.getName(), pet2.getSpecies());
        } catch(AnimalSpeciesException e)
        {
            System.out.println(e.getMessage());
        }
         
        System.out.println("\nStep 4: Using Recursion to subtract 4 and find the last number from 421 before 0.");

        lastNumberBeforeZero(421, 4);
        
    }    
}
