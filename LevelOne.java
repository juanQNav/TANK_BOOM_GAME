import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends World
{

    /**
     * Constructor for objects of class LevelOne.
     * 
     */
    public LevelOne()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        prepare();
    }
    private void prepare(){
        addObject(new Player(), (getWidth() - 50)/2, (getHeight() - 50)/2);
        addObject(new Enemy(),70,180);
        
        //walls on the far left
        addObject(new Wall(),150,10);
        addObject(new Wall(),150,35);
        addObject(new Wall(),150,60);
        addObject(new Wall(),150,85);
        addObject(new Wall(),150,110);
        addObject(new Wall(),150,135);
        
        addObject(new Wall(),150,260);
        addObject(new Wall(),150,285);
        addObject(new Wall(),150,310);
        addObject(new Wall(),150,335);
        addObject(new Wall(),150,360);
        addObject(new Wall(),150,385);
        addObject(new Wall(),150,410);
        addObject(new Wall(),150,435);
    }
}
