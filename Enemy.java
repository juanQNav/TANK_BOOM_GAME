import greenfoot.*;

public class Enemy extends Tank
{
    private SimpleTimer timer = new SimpleTimer();
    private SimpleTimer timerShoot = new SimpleTimer();
    
    public Enemy(){
        images = new String[4];

        images[DIRECTION_RIGHT] = new String(
            "images/tank2_right.png"
        );
        images[DIRECTION_LEFT] = new String(
            "images/tank2_left.png"
        );
        images[DIRECTION_UP] = new String(
            "images/tank2_up.png"
        );
        images[DIRECTION_DOWN] = new String(
            "images/tank2_down.png"
        );        
        setImage(images[DIRECTION_RIGHT]);
    }

    public void act()
    {
        checkCollisions();

        handleImageSelector();

        randomMove();
        
        atack();
    }

    private void randomMove(){
        if(timer.millisElapsed() >= 2000){
            direction = (int) (Math.random() * 4);
            timer.mark();
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
        
        world.addObject(new Proyectile(direction, true), getX(), getY());
    }
}
