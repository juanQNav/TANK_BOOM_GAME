import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Shield extends PowerUp
{
    private static final String IMAGE_POWER = "images/powerUp_shield.png";
    
    public Shield(){
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
            getWorld().removeObject(this);
        }
    }
    
}
