import greenfoot.*;  

public class Score extends Actor {
    private int score;

    public Score() {
        this.score = 0;
        updateImage();
    }

    public void act() {
        updateImage();
    }

    public void addScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    private void updateImage() {
        GreenfootImage text = new GreenfootImage("Score: " + score, 20, Color.WHITE, new Color(0, 0, 0, 0));
        setImage(text);
    }
}