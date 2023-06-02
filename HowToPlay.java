import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class HowToPlay extends Menu
{
    public HowToPlay()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600,1);
        setBackground("background_menu.png");
    }

    public void act(){
        showInstruction();

        showOptions();

        handleKeys();
    }

    protected void showOptions (){
        showText("Press enter to return...", getWidth()/2, getHeight()/2 + 230);
    }

    protected void handleKeys(){
        if(Greenfoot.isKeyDown("enter") && timerDelay.millisElapsed() >= 300){
            Greenfoot.setWorld(new MenuInitial());
        }
    }

    private void showInstruction(){
        showText("Movement Keys", getWidth()/2, getHeight()/2 - 40);

        showText("* Up arrow: move up           ", getWidth()/2, getHeight()/2);

        showText("* Down arrow: move down", getWidth()/2, getHeight()/2 + 40);

        showText("* Left arrow: move left      ", getWidth()/2, getHeight()/2 + 80);

        showText("* Right arrow: move right", getWidth()/2, getHeight()/2 + 120);

        showText("* Space: shoot                   ", getWidth()/2, getHeight()/2 + 160);
    }
}
