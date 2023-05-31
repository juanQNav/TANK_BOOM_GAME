import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Player extends Tank
{   
    private static String imageRight = "images/tank_right.png";
    private static String imageLeft = "images/tank_left.png";
    private static String imageUp = "images/tank_up.png";
    private static String imageDown = "images/tank_down.png";
    private static int score = 0;
    private static final int OFFSET_PROYECTILE = 5;
    private SimpleTimer timer = new SimpleTimer();
    private SimpleTimer boom_delay = new SimpleTimer();
    private int lifes = 4;
    private int previusLifes = 4;
    private boolean acting = true;
    
    
    public Player(){
        images = new String[4];

        images[DIRECTION_RIGHT] = new String(imageRight);
        images[DIRECTION_LEFT] = new String(imageLeft);
        images[DIRECTION_UP] = new String(imageUp);
        images[DIRECTION_DOWN] = new String(imageDown);        
        setImage(images[DIRECTION_RIGHT]);
    }

    public void act()
    {
        if(acting){
            handleKeys();

            handleImageSelector();

            checkCollisions();
        }
        checkLives();
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
            if(timer.millisElapsed() >= 250){
                shoot(); 
                timer.mark();
            }
        }
    }

   

    private void shoot(){
        World world = getWorld();

        world.addObject(new Proyectile(direction, false), getX(), getY());
    }

    private void checkLives(){
        if(lifes <= 0){
           Greenfoot.setWorld(new GameOver());
        }else if(lifes < previusLifes){
            explodes();
            acting = false;
            boom_delay.mark();
            previusLifes = lifes;
        }
        
        if(boom_delay.millisElapsed() >= 500){
                acting = true;
                boom_delay.mark();
        }
    }
    private void explodes(){
        setImage("images/boom1.png");
    }

    public void updateLifes(int lifes){
        previusLifes = this.lifes;
        this.lifes += lifes;        
    }
    public int getLifes(){
        return lifes;
    }
}
