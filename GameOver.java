import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends Menu
{
    private String playersName = null;
    private int score;
    int level;
    public GameOver(int score, int level)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        setBackground("background_menu.png");
        showText("GAME OVER", getWidth()/2, getHeight()/2);
        this.score = score;
        this.level = level;
    }

    public void act(){
        showOptions ();
        handleKeys();
    }

    private void askName(){
        // Pedir al usuario su nombre
        playersName = Greenfoot.ask("Please, enter your name:");
    }

    protected void showOptions (){
        showText("Press enter to continue...", getWidth()/2, getHeight()/2 + 230);
    }

    protected void handleKeys(){
        if(Greenfoot.isKeyDown("enter") && timerDelay.millisElapsed() >= 300){
            askName();
            saveRecordScore();
            Greenfoot.setWorld(new LevelSelection());
        }
    }
    private void saveRecordScore(){
        FileManager.registerScore(playersName,score, level);
    }
}
