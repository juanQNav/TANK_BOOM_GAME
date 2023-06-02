import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World
{
    //atributos
    private static final int DIRECTION_UP = 0;
    private static final int DIRECTION_DOWN = 1;
    private static final int COUNT_DOWN_START_VALUE = 20;
    private static final int OPTION_START = 1;
    private static final int OPTION_RECORD = 2;
    private static final int OPTION_HOWPLAY = 3;
    private static final int OPTION_EXIT = 4;   
    private static final int DIRECTION_INITIAL = 4;
    private int direction= DIRECTION_INITIAL;
    private int displacement = 0;
    private int delay = COUNT_DOWN_START_VALUE;
    private int option = -1;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        setBackground("background_menu.png");
    }

    public void act()
    {
        // Add your action code here.
        showOptions();
        handleKeys();
        moveSelector();
        handleOption();
    }

    private void showOptions ()
    {   
        showText("Start Game", getWidth()/2, getHeight()/2);

        showText("Records", getWidth()/2, getHeight()/2 + 40);

        showText("How to play (?)", getWidth()/2, getHeight()/2 + 80);

        showText("Exit", getWidth()/2, getHeight()/2 + 120);

    }

    private void handleKeys()
    {
        if(Greenfoot.isKeyDown("down")){
            direction = DIRECTION_DOWN;
        }else if(Greenfoot.isKeyDown("up")){
            direction = DIRECTION_UP;
        }else if(Greenfoot.isKeyDown("enter")){
            selectionOption();
        }
    }  

    private void moveSelector(){
        switch(direction){
            case DIRECTION_DOWN: 
                if(displacement < 120){
                    showText(" ", getWidth()/2 - 87, getHeight()/2 + displacement);
                    displacement += 40;
                    showText(">", getWidth()/2 - 87, getHeight()/2 + displacement);
                    direction = -1;
                    Greenfoot.delay(10);
                }
                break;
            case DIRECTION_UP:
                if(displacement > 0){
                    showText(" ", getWidth()/2 - 87, getHeight()/2 + displacement);
                    displacement -= 40;
                    showText(">", getWidth()/2 - 87, getHeight()/2 + displacement);
                    direction = -1;
                    Greenfoot.delay(10);
                }
                break;
            case DIRECTION_INITIAL:
                showText(">", getWidth()/2 - 87, getHeight()/2);
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
                Greenfoot.setWorld(new LevelOne());
                break;
            case OPTION_RECORD:
                Greenfoot.setWorld(new Record());
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

