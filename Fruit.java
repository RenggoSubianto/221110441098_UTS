import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fruit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fruit extends Actor{
     private String[] fruitImages = {
        "fruit.png" // Tambahkan nama file gambar buah lainnya di sini
    };

    public Fruit() {
        setImage(selectRandomFruit());
    }

    private String selectRandomFruit() {
        int index = Greenfoot.getRandomNumber(fruitImages.length);
        return fruitImages[index];
    }
}