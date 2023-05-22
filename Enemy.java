import greenfoot.*;

public class Enemy extends Tank
{
    private SimpleTimer timer = new SimpleTimer();

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
    }

    private void randomMove(){

        if(timer.millisElapsed() >= 2000){
            direction = (int) (Math.random() * 4);
            timer.mark();
        }
        moveTank();
    }
}
