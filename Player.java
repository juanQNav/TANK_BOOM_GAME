import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Player extends Tank
{    
    private int score = 0;
    
    public Player(){
        images = new String[4];
            
        images[DIRECTION_RIGHT] = new String(
            "images/tank_right.png"
        );
        images[DIRECTION_LEFT] = new String(
            "images/tank_left.png"
        );
        images[DIRECTION_UP] = new String(
            "images/tank_up.png"
        );
        images[DIRECTION_DOWN] = new String(
            "images/tank_down.png"
        );        
        setImage(images[DIRECTION_RIGHT]);
    }
    public void act()
    {
        handleKeys();
        
        handleImageSelector();
        
        checkCollisions();
        
        updateHud();
     
    }
   
    private void handleKeys(){
            if(Greenfoot.isKeyDown("left")){
        direction =  DIRECTION_LEFT;
        moveTank();
    }else if(Greenfoot.isKeyDown("right")){
        direction =  DIRECTION_RIGHT;
        moveTank();
    }else if(Greenfoot.isKeyDown("up")){
        direction = DIRECTION_UP;
        moveTank();
    }else if(Greenfoot.isKeyDown("down")){
        direction = DIRECTION_DOWN;
        moveTank();
    }
    }
    
    private void updateHud(){
        World world = getWorld();
        world.showText("Score: " + score, world.getWidth() - 100,20);
    }
}
