import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelOne extends World
{

    public LevelOne()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        prepare();
    }

    private void prepare(){
        addObject(new Player(), (getWidth() - 50)/2, (getHeight() - 50)/2);
        addObject(new Enemy(),70,180);
        addObject(new Enemy(),70,500);
        addObject(new Enemy(),900,500);
        addObject(new Enemy(),900,180);
        
        //walls on the far left
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

        addObject(new Wall(),175,260);
        addObject(new Wall(),200,260);
        addObject(new Wall(),225,260);
        addObject(new Wall(),250,260);
        addObject(new Wall(),275,260);
        addObject(new Wall(),300,260);
        addObject(new Wall(),325,260);
        addObject(new Wall(),350,260);
        //
        addObject(new Wall(),375,260);

        addObject(new Wall(),500,260);
        addObject(new Wall(),525,260);
        addObject(new Wall(),550,260);
        
        
        addObject(new Bush(),600,260);
        addObject(new Bush(),625,260);
        addObject(new Bush(),650,260);
        addObject(new Bush(),675,260);
        addObject(new Bush(),700,260);
        addObject(new Bush(),725,260);
        
        addObject(new HardBlock(),675,260);
        addObject(new HardBlock(),700,260);
        addObject(new HardBlock(),725,260);
    }
}
