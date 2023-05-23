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
    private Player player;
    private boolean fromEnemy;
    public Proyectile(int direction, boolean fromEnemy){
    this.direction = direction;
    player = new Player();
    this.fromEnemy = fromEnemy;
    }
    
    public void act()
    {
            move();
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
        Wall wall = (Wall)this.getOneIntersectingObject(Wall.class);
        Enemy enemy = (Enemy)this.getOneIntersectingObject(Enemy.class);
        Player playerVictim = (Player)this.getOneIntersectingObject(Player.class);
        HardBlock hardBlock = (HardBlock)this.getOneIntersectingObject(HardBlock.class);
        
        if(wall != null){
           getWorld().removeObject(this);
           wall.getWorld().removeObject(wall);
        }else if(hardBlock != null){
            getWorld().removeObject(this);
        }else if (getX() <= 20) {
            getWorld().removeObject(this);
        } else if (getX() >= getWorld().getWidth() - 20) {
            getWorld().removeObject(this);
        }else if (getY() <= 20) {
            getWorld().removeObject(this);
        } else if (getY() >= getWorld().getHeight() - 20) {
            getWorld().removeObject(this);
        }else if(enemy != null && !fromEnemy){
            player.setScore(1);
            getWorld().removeObject(player);
            enemy.getWorld().removeObject(enemy);
            getWorld().removeObject(this);
        }else if(playerVictim != null && fromEnemy){
            getWorld().removeObject(playerVictim);
            getWorld().removeObject(this);
        }
    }
}
