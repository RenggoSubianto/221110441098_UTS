import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Actor
{
    public Food() {
        // Set gambar makanan (pastikan Anda sudah menambahkan gambar makanan ke Greenfoot)
        setImage("food.png");
    }

    public void act() {
        // Logika makanan jika ular menyentuh makanan
        if (getOneIntersectingObject(Snake.class) != null) {
            Snake snake = (Snake) getOneIntersectingObject(Snake.class);
            snake.extend(); // Menambah panjang ular
            getWorld().removeObject(this); // Hapus makanan
            // Tambahkan logika peningkatan skor pemain jika diperlukan
        }
    }
}

