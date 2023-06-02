import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MenuInitial extends Menu
{
    private static final int OPTION_START = 1;
    private static final int OPTION_RECORD = 2;
    private static final int OPTION_HOWPLAY = 3;
    private static final int OPTION_EXIT = 4;   
    private static final int DIRECTION_INITIAL = 4;
    private int direction= DIRECTION_INITIAL;

    public MenuInitial()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        setBackground("background_menu.png");
        timerDelay.mark();
    }

    public void act()
    {
        // Add your action code here.
        showOptions();

        handleKeys();

        moveSelector();

        handleOption();
    }

    protected void showOptions ()
    {   
        showText("1)Level Selection", getWidth()/2, getHeight()/2);

        showText("2)Records            ", getWidth()/2, getHeight()/2 + 40);

        showText("3)How to play (?) ", getWidth()/2, getHeight()/2 + 80);

        showText("4)Exit                     ", getWidth()/2, getHeight()/2 + 120);
        
        showText("Press enter to select...", getWidth()/2, getHeight()/2 + 250);

    }

    protected void handleKeys()
    {
        if(Greenfoot.isKeyDown("down") && timerDelay.millisElapsed() >= 300){
            direction = DIRECTION_DOWN;
            timerDelay.mark();
        }else if(Greenfoot.isKeyDown("up") && timerDelay.millisElapsed() >= 300){
            direction = DIRECTION_UP;
            timerDelay.mark();
        }else if(Greenfoot.isKeyDown("enter") && timerDelay.millisElapsed() >= 300){
            selectionOption();
            timerDelay.mark();
        }
    }  

    private void moveSelector(){
        switch(direction){
            case DIRECTION_DOWN: 
                if(displacement < 120){
                    showText(" ", getWidth()/2 - 88, getHeight()/2 + displacement);
                    displacement += 40;
                    showText(">", getWidth()/2 - 88, getHeight()/2 + displacement);
                    direction = -1;
                    Greenfoot.delay(10);
                }
                break;
            case DIRECTION_UP:
                if(displacement > 0){
                    showText(" ", getWidth()/2 - 88, getHeight()/2 + displacement);
                    displacement -= 40;
                    showText(">", getWidth()/2 - 88, getHeight()/2 + displacement);
                    direction = -1;
                    Greenfoot.delay(10);
                }
                break;
            case DIRECTION_INITIAL:
                showText(">", getWidth()/2 - 88, getHeight()/2);
                break;
        }
    }

    private void handleOption(){
        if(displacement == 0){
            option = OPTION_START;
        }else if(displacement == 40){
            option = OPTION_RECORD;
        }else if(displacement == 80){
            option = OPTION_HOWPLAY;
        }else if(displacement == 120){
            option = OPTION_EXIT;
        }
    }

    private void selectionOption()
    {
        switch(option){
            case OPTION_START:
                Greenfoot.setWorld(new LevelSelection());
                break;
            case OPTION_RECORD:
                Greenfoot.setWorld(new MenuRecord());
                break;
            case OPTION_HOWPLAY:
                Greenfoot.setWorld(new HowToPlay());
                break;
            case OPTION_EXIT:
                Greenfoot.stop();
                break;
        }
    }
}

