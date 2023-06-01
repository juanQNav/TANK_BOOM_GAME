import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Time extends PowerUp
{
    private static final String IMAGE_POWER = "images/powerUp_time.png";

    public Time(){
        super(IMAGE_POWER, 10);
    }

    public void act()
    {
        flashesImage(); 
        power();
        handleExistence();
    }

    protected void power(){
        Player player = (Player)this.getOneIntersectingObject(Player.class);

        if(player != null){
            player.setplayerShield(true);
            Level level = (Level)getWorld();
            level.alterTime(40);
            getWorld().removeObject(this);
        }
    }
}
