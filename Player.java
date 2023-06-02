import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Player extends Tank
{       
    private static final String IMAGE_RIGHT = "images/tank_right.png";
    private static final String IMAGE_LEFT = "images/tank_left.png";
    private static final String IMAGE_UP = "images/tank_up.png";
    private static final String IMAGE_DOWN = "images/tank_down.png";
    private SimpleTimer timerShieldEffect = new SimpleTimer();
    private int secondShield = 15;
    private static int score = 0;
    private boolean playerShield = false;

    public Player(int countShoot){
        super(IMAGE_RIGHT, IMAGE_LEFT, IMAGE_UP, IMAGE_DOWN, countShoot);
    }

    public void act()
    {
        if(isActing()){
            handleKeys();

            handleImageSelector();

            checkCollisions();

            handleShield();
        }
        checkCountShoot();
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
        if(Greenfoot.isKeyDown("space")){
            if(timerShoot.millisElapsed() >= 250){
                shoot(); 
                timerShoot.mark();
            }
        }
    }

    protected void shoot(){
        World world = getWorld();

        world.addObject(new Projectile(direction, false), getX(), getY());
    }

    protected void checkCountShoot(){
        if(countShoot < previousCountShoot && isActing()){
            showBoomExplodes();
            acting = false;
            boom_delay.mark();
            previousCountShoot = countShoot;
        }

        if(boom_delay.millisElapsed() >= 500 && !isActing()){
            World world = getWorld();
            setLocation((world.getWidth() - 50)/2,(world.getHeight() + 100)/2);    
            acting = true;
            boom_delay.mark();
        }
    }

    private void handleShield(){
        if(secondShield == 0){
            playerShield = false;
        }else if (timerShieldEffect.millisElapsed() >= 1000 && playerShield) {
            secondShield--;
            timerShieldEffect.mark();
        }
    }

    public void setplayerShield(boolean playerShield){
        this.playerShield = playerShield;
    }

    public boolean getPlayerShield(){
        return playerShield;
    }
}
