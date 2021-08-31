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


public class Pet 
{
    private String name;
    private String species;
    private int age;
    private List<Pet> ancestry = new ArrayList<Pet>();
    
    public Pet(String name, int age, List<Pet> ancestry)
    {
        this.name = name;
        this.age = age;
        this.ancestry = ancestry;
    }
    
    public void setSpecies(String species)
    {
        this.species = species;
    }
    
    public String getSpecies()
    {
        return species;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public List<Pet> getAncestry()
    {
        return this.ancestry;
    }
    
    public Pet mate(Pet spouse, String name) throws AnimalSpeciesException
    {
        Pet child = null;
        List<Pet> a = new ArrayList<Pet>();
        a.add(this);
        a.add(spouse);

        if(this.species == spouse.getSpecies())
        {
            child = this.species == "Dog" ? new Dog(name, 0, a) : new Cat(name, 0, a);
        }
        else
        {
            throw new AnimalSpeciesException("Cats and dogs cannot breed.");
        }
        return child;        
    }
}

class Cat extends Pet 
{
    public Cat(String name, int age, List<Pet> ancestry)
    {
        super(name, age, ancestry);
        this.setSpecies("Cat");
    }    
}

class Dog extends Pet 
{
    public Dog(String name, int age, List<Pet> ancestry)
    {
        super(name, age, ancestry);
        this.setSpecies("Dog");
    }    
}