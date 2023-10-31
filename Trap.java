import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trap extends Actor
{
    public Trap() {
        setImage("trap.png");
    }

    public void act() {
        if (getOneIntersectingObject(Snake.class) != null) {
            Snake snake = (Snake) getOneIntersectingObject(Snake.class);
            snake.reduceLength(); // Metode untuk mengurangi panjang ular
            getWorld().removeObject(this);
        }
    }
}
