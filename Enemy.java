import greenfoot.*;

public class Enemy extends Tank
{
    private static final String IMAGE_RIGHT = "images/tank2_right.png";
    private static final String IMAGE_LEFT = "images/tank2_left.png";
    private static final String IMAGE_UP = "images/tank2_up.png";
    private static final String IMAGE_DOWN = "images/tank2_down.png";
    private SimpleTimer timerMove = new SimpleTimer();
    
    
    
    public Enemy(int countShoot){
         super(IMAGE_RIGHT, IMAGE_LEFT, IMAGE_UP,IMAGE_DOWN, countShoot);
    }
    
    public void act()
    {
        if(isActing()){

            checkCollisions();

            handleImageSelector();

            randomMove();

            atack();
        }
        checkCountShoot();
    }

    private void randomMove(){
        if(timerMove.millisElapsed() >= 2000){
            direction = (int) (Math.random() * 4);
            timerMove.mark();
        }
        moveTank();
    }

    private void atack(){
        if(timerShoot.millisElapsed() >= 700){
            shoot();
            timerShoot.mark();
        }
    }

    protected void shoot(){
        World world = getWorld();

        world.addObject(new Projectile(direction, true), getX(), getY());
    }

    protected void checkCountShoot() {
        if (countShoot <= 0 && isActing()) {
            showBoomExplodes();
            acting = false;
            boom_delay.mark();
        }
        if (!isActing() && boom_delay.millisElapsed() >= 200) {
            Level level =(Level) getWorld();
            level.updateEnemyDied(1);
            getWorld().removeObject(this);
        }
    }

}