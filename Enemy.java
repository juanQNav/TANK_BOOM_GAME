import greenfoot.*;

public class Enemy extends Tank
{
    private static String imageRight = "images/tank2_right.png";
    private static String imageLeft = "images/tank2_left.png";
    private static String imageUp = "images/tank2_up.png";
    private static String imageDown = "images/tank2_down.png";
    private SimpleTimer timer = new SimpleTimer();
    private SimpleTimer timerShoot = new SimpleTimer();
    private int lifes;
    private boolean acting = true;
    private SimpleTimer boom_delay = new SimpleTimer();
    public Enemy(int lifes){
        this.lifes = lifes;
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

            checkCollisions();

            handleImageSelector();

            randomMove();

            atack();
        }
        checkLifes();
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

    private void shoot(){
        World world = getWorld();

        world.addObject(new Proyectile(direction, true), getX(), getY());
    }

    private void checkLifes() {
        if (lifes <= 0 && acting) {
            explodes();
            acting = false;
            boom_delay.mark();
        }
        if (!acting && boom_delay.millisElapsed() >= 200) {
            getWorld().removeObject(this);
        }
    }

    private void explodes(){
        setImage("images/boom1.png");
    }

    public void updateLifes(int lifes){
        this.lifes += lifes;
    }

    public int getLifes(){
        return lifes;
    }
}