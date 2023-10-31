import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnakeGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeGame extends World
{

    /**
     * Constructor for objects of class SnakeGame.
     * 
     */
    private Snake snake;
    private int score;

    public SnakeGame(){
        super(600, 600, 1);
        snake = new Snake();
        addObject(snake, getWidth() / 2, getHeight() / 2);
        score = 0;
        showScore(); // Menampilkan skor saat permainan dimulai
        spawnFood();
    }
    
    public boolean isGameOver() {
        return (snake != null) && (snake.hitWall() || snake.hitItself());
    }
    
    public void act() {
        if (isGameOver()) {
            Greenfoot.stop();
            showText("Game Over! Score: " + score, getWidth() / 2, getHeight() / 2);
        } else {
            snake.move();
            checkCollision();
        }
    }

    public void checkCollision() {
        if (snake.isTouchingFood()) {
            increaseScore(1); // Tambah skor saat ular memakan makanan
            removeObjects(getObjectsAt(snake.getX(), snake.getY(), Food.class)); // Hapus makanan saat disentuh oleh ular
            spawnFood(); // Buat makanan baru
            showScore(); // Perbarui tampilan skor
        }

        if (isGameOver()) {
            Greenfoot.stop();
            showText("Game Over! Score: " + score, getWidth() / 2, getHeight() / 2);
        }
    }
    
    public void increaseScore(int points) {
        score += points; // Tambahkan skor
    }

    public void showScore() {
        showText("Score: " + score, 50, 20); // Menampilkan skor di posisi (50, 20)
    }

    public void spawnFood() {
        addObject(new Food(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
    }
    
    
}
