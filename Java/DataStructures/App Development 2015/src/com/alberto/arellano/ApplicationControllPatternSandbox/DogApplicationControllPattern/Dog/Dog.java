package com.alberto.arellano.ApplicationControllPatternSandbox.DogApplicationControllPattern.Dog;

/**
 * Created by rome on 12/1/2015.
 */
public class Dog {
    private String name;
    private String breed;
    private float weight;
    private float height;
    private int age;

    public Dog(String name, String breed, float weight, float height, int age) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void bark(){
        try {
            System.out.println("Woof, WOOF!! WOOF!! (Barking loud)\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void kill(){
        try {
            Thread.currentThread().sleep(1000);
            System.out.println("(Dog Running Towards you)\n");
            Thread.currentThread().sleep(1000);
            System.out.println("ahhhhgggrrrrr!! (You are dead)\n");
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void eat(){
        try {
            Thread.currentThread().sleep(1000);
            System.out.println("uymmm mmmm!\n");
            System.out.println("(Eating Everything)\n");
            Thread.currentThread().sleep(500);
            System.out.println("uymmm mmmm!\n");
            Thread.currentThread().sleep(200);
            System.out.println("Done\n");
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fire(){
        try {
            System.out.println("BANG BANG!!!\n");
            System.out.println("auuuuUUU (Dead)\n");
            Thread.currentThread().sleep(1500);
            System.out.println("WHAT HAVE YOU DONE!!\n");
            Thread.currentThread().sleep(2000);
            System.out.println("No worries I can bring it back to life\n");
            Thread.currentThread().sleep(1000);
            System.out.println("Done\n");
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void create(){
        try {
            Thread.currentThread().sleep(1000);
            System.out.println("Cloning in process\n");
            Thread.currentThread().sleep(2000);
            System.out.println("Successful Cloning\n");
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
