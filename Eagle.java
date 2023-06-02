import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Eagle extends Actor
{
    private int lifes = 5;
    
    public Eagle(){
    }
    public void act() {
        killEagle();
    }

    private void killEagle() {
        if (lifes == 0) {
            Level level = (Level) getWorld();
            Greenfoot.setWorld(new GameOver(level.getScore(), level.getLevel()));
            
            getWorld().removeObject(this);
        }
    }
    public int getLifes(){
        return lifes;
    }
    public void updateLife(int lifes){
        this.lifes += lifes;
    }
}
