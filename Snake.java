import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Snake extends Actor {
    private int speed = 1; // Kecepatan pergerakan ular
    private int length = 1; // Panjang awal ular
    private int delay = 10; // Delay antar gerakan
    private int counter = 0; // Counter untuk delay
    private int[] xCoords = new int[100]; // Array untuk menyimpan koordinat x
    private int[] yCoords = new int[100]; // Array untuk menyimpan koordinat y
    private int direction = 0; // Arah awal ular (0 = ke kanan, 1 = ke atas, 2 = ke kiri, 3 = ke bawah)
    private int score;
    
    public Snake() {
        setImage("snake.png");
    }
    
    public void act() {
        // Pergerakan ular
        move();
        checkKeyPress();
        checkEdgeCollision();
        checkCollisionWithFood();
        checkCollision();
    }

    public void move() {
        for (int i = length - 1; i > 0; i--) {
            xCoords[i] = xCoords[i - 1];
            yCoords[i] = yCoords[i - 1];
        }

        if (direction == 0) {
            setLocation(getX() + speed, getY());
        } else if (direction == 1) {
            setLocation(getX(), getY() - speed);
        } else if (direction == 2) {
            setLocation(getX() - speed, getY());
        } else if (direction == 3) {
            setLocation(getX(), getY() + speed);
        }

        xCoords[0] = getX();
        yCoords[0] = getY();
    }

    public void checkKeyPress() {
        if (Greenfoot.isKeyDown("right") && direction != 2) {
            direction = 0;
        }
        if (Greenfoot.isKeyDown("up") && direction != 3) {
            direction = 1;
        }
        if (Greenfoot.isKeyDown("left") && direction != 0) {
            direction = 2;
        }
        if (Greenfoot.isKeyDown("down") && direction != 1) {
            direction = 3;
        }
    }

    public void checkEdgeCollision() {
        if (getX() <= 0 || getX() >= getWorld().getWidth() - 1 || getY() <= 0 || getY() >= getWorld().getHeight() - 1) {
            Greenfoot.stop();
        }
    }
    
    public boolean hitWall() {
        return getX() <= 0 || getX() >= getWorld().getWidth() - 1 || getY() <= 0 || getY() >= getWorld().getHeight() - 1;
    }

    public boolean hitItself() {
        for (int i = 1; i < length; i++) {
            if (getX() == xCoords[i] && getY() == yCoords[i]) {
                return true;
            }
        }
        return false;
    }

    public int getLength() {
        return length;
    }
    
    public void extend(){
        length++;
        getWorld().addObject(new Tail(), xCoords[length - 1], yCoords[length - 1]);
    }
    
     public void reduceLength() {
        if (length > 1) {
            getWorld().removeObject(getWorld().getObjects(Tail.class).get(getWorld().getObjects(Tail.class).size() - 1));
            length--;
        } else {
            length = 0;
        }
    }

    public boolean isTouchingFood() {
        return isTouching(Food.class);
    }
    
    public void checkCollisionWithFood() {
        if (isTouching(Food.class)) {
            removeTouching(Food.class); // Hapus makanan saat disentuh oleh ular
            increaseScore(1); // Tambahkan skor ular setiap kali ular mengambil makanan
        }
    }

    public void increaseScore(int points) {
        // Tambahkan nilai points ke skor ular
        // (mungkin Anda perlu menambahkan variabel score di kelas Snake dan method untuk mengaksesnya)
    }
    
    public void checkCollision() {
        if (isTouching(Food.class)) {
        extend(); // Increase snake's length by adding a new Tail
        removeTouching(Food.class); // Remove the food when touched by the snake
        }
    }
    
}
