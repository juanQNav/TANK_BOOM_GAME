import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Player extends Tank
{   
    private static int score = 0;
    private static final int OFFSET_PROYECTILE = 5;
    private SimpleTimer timer = new SimpleTimer();
    
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
        }else if(Greenfoot.isKeyDown("space")){
            if(timer.millisElapsed()>=250){
               shoot(); 
               timer.mark();
            }
        }
    }

    private void updateHud(){
        World world = getWorld();
        world.showText("Score: " + score, world.getWidth() - 100,20);
    }
    
    private void shoot(){
        World world = getWorld();
        
        world.addObject(new Proyectile(direction), getX(), getY());
    }
    public void setScore(int score){
        this.score += score;
    }
}
