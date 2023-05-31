import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)import java.uitil.List;
import java.util.ArrayList;
import java.util.List;

public class Proyectile extends Actor
{
    private static final int SPEED = 10;
    private int direction;
    private static final int DIRECTION_RIGHT = 0;
    private static final int DIRECTION_LEFT = 1;
    private static final int DIRECTION_UP = 2;
    private static final int DIRECTION_DOWN = 3;
    private boolean fromEnemy;
    private String []images;
    private SimpleTimer timer = new SimpleTimer();

    public Proyectile(int direction, boolean fromEnemy){
        this.direction = direction;
        this.fromEnemy = fromEnemy;
        images = new String[4];
        
        images[DIRECTION_RIGHT] = new String(
            "images/proyectile_right.png"
        );
        images[DIRECTION_LEFT] = new String(
            "images/proyectile_left.png"
        );
        images[DIRECTION_UP] = new String(
            "images/proyectile_up.png"
        );
        images[DIRECTION_DOWN] = new String(
            "images/proyectile_down.png"
        );        
        setImage(images[DIRECTION_RIGHT]);
    }

    public void act()
    {
        move();
        
        checkCollisions();
        
        handleImageSelector();
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
        Player playerVictim = (Player)this.getOneIntersectingObject(Player.class);
        
        
        if(isAtEdge()){
            getWorld().removeObject(this);
        }else if(enemy != null && !fromEnemy){
            LevelOne level = (LevelOne)getWorld();
            level.updateScore(100);
            enemy.updateLifes(-1);
            getWorld().removeObject(this);
        }else if(playerVictim != null && fromEnemy){
            playerVictim.updateLifes(-1);
            getWorld().removeObject(this);
        }
    }
    private void handleImageSelector(){
        setImage(images[direction]);
    }
}
