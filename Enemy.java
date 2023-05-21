import greenfoot.*;

public class Enemy extends Tank
{
    private SimpleTimer timer = new SimpleTimer();
    private int [] countCollision = {0, 0, 0, 0};
    
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
            direction = (int) (Math.random() * 3);
            timer.mark();
        }
        moveTank();
    }
    protected void checkCollisions(){
        Wall wall = (Wall)this.getOneIntersectingObject(Wall.class);
        World world = getWorld();
        
          if(wall != null){
         directionCollision = direction;
         move[directionCollision] = false;
         switch (directionCollision){
             case DIRECTION_RIGHT:
                    setLocation(getX() - 5, getY());
                    countCollision [0]++;
                    direction = (int) (Math.random() * 3);
                break;
            case DIRECTION_LEFT:
                    setLocation(getX() + 5, getY());
                    direction = (int) (Math.random() * 3);
                    countCollision [1] ++;
                break;
            case DIRECTION_UP:
                    setLocation(getX(),getY() + 5);
                    direction = (int) (Math.random() * 3);
                    countCollision [2] ++;
                break;
            case DIRECTION_DOWN:
                    setLocation(getX(),getY() - 5);
                    direction = (int) (Math.random() * 3);
                    countCollision [3] ++;
                break;
            }
        }
        if (getX() <= 16) {
            setLocation(25, getY());
            direction = (int) (Math.random() * 3);
            countCollision [1] ++;
        } else if (getX() >= getWorld().getWidth() - 25) {
            setLocation(getWorld().getWidth() - 18, getY());
            direction = (int) (Math.random() * 3);
            countCollision [0] ++;
        }
        
        if (getY() <= 20) {
            setLocation(getX(), 25);
            direction = (int) (Math.random() * 3);
            countCollision [2] ++;
        } else if (getY() >= getWorld().getHeight() - 20) {
            setLocation(getX(), getWorld().getHeight() - 25);
            direction = (int) (Math.random() * 3);
            countCollision [3] ++;
        }
    }
}
