import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Menu extends World
{
    protected SimpleTimer timerDelay = new SimpleTimer();
    protected static final int DIRECTION_UP = 0;
    protected static final int DIRECTION_DOWN = 1;
    protected static final int COUNT_DOWN_START_VALUE = 20;
    protected int displacement = 0;
    protected int delay = COUNT_DOWN_START_VALUE;
    protected int option = -1;

    public Menu(int x, int y, int px)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(x, y, px);
    }

    protected abstract void showOptions ();

    protected abstract void handleKeys(); 
}

