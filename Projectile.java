import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)import java.uitil.List;
import java.util.ArrayList;
import java.util.List;

public class Projectile extends Actor
{
    private static final int SPEED = 10;
     private static final int DIRECTION_RIGHT = 0;
    private static final int DIRECTION_LEFT = 1;
    private static final int DIRECTION_UP = 2;
    private static final int DIRECTION_DOWN = 3;
    private static final String IMAGE_IMPACT= "images/impact1.png";
    private static final String IMAGE_RIGHT = "images/proyectile_right.png";
    private static final String IMAGE_LEFT = "images/proyectile_left.png";
    private static final String IMAGE_UP = "images/proyectile_up.png";
    private static final String IMAGE_DOWN = "images/proyectile_down.png";
    
    private int direction;   
    private boolean fromEnemy;
    private String []images;
    private SimpleTimer timer = new SimpleTimer();
    private boolean acting = true;
    
    public Projectile(int direction, boolean fromEnemy){
        this.direction = direction;
        this.fromEnemy = fromEnemy;
        images = new String[4];
        
        images[DIRECTION_RIGHT] = IMAGE_RIGHT; 
        images[DIRECTION_LEFT] = IMAGE_LEFT;
        images[DIRECTION_UP] = IMAGE_UP;
        images[DIRECTION_DOWN] = IMAGE_DOWN;        
        setImage(images[DIRECTION_RIGHT]);
    }

    public void act()
    {
        if(isActing()){
            move();
            
            handleImageSelector();
        }
        checkCollisions();
    }

    private void move(){
        switch(direction){
            case DIRECTION_LEFT:
                setLocation(getX() - SPEED, getY());
                break;
            case DIRECTION_RIGHT:
                setLocation(getX() + SPEED, getY());
                break;
            case DIRECTION_UP:
                setLocation(getX(), getY() - SPEED);
                break;
            case DIRECTION_DOWN:
                setLocation(getX(), getY() + SPEED);
                break;
        }
    }

    private void checkCollisions(){
        Enemy enemy = (Enemy)this.getOneIntersectingObject(Enemy.class);
        Player player = (Player)this.getOneIntersectingObject(Player.class);
        Block block = (Block)this.getOneIntersectingObject(Block.class);
        Eagle eagle = (Eagle)this.getOneIntersectingObject(Eagle.class);
        
        if(isAtEdge() && isActing()){
            showImpactAnimation();
            acting = false;
            timer.mark();
        }else if(enemy != null && !fromEnemy && isActing()){
            showImpactAnimation();
            acting = false;
            Level level = (Level)getWorld();
            level.updateScore(100);
            enemy.updateCountShoot(-1);
            timer.mark();
        }else if(player != null && fromEnemy && isActing()){
            showImpactAnimation();
            if(!player.getPlayerShield()){
                player.updateCountShoot(-1);
            }
            acting = false;
            timer.mark();
        }else if(block != null && isActing()){
            showImpactAnimation();
            acting = false;
            timer.mark();
        }else if(eagle != null && isActing()){
            showImpactAnimation();
            acting = false;
            eagle.updateLife(-1);
            timer.mark();
        }
        if(timer.millisElapsed() >= 250 && !isActing()){
                getWorld().removeObject(this);
        }
    }
    
    private void handleImageSelector(){
        setImage(images[direction]);
    }
    private boolean isActing(){
        if(acting){
            return true;
        }else{
            return false;
        }
    }
    private void showImpactAnimation(){
        setImage(IMAGE_IMPACT);
    }
}
