import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class PowerUp extends Actor
{
    private SimpleTimer timerFlashes = new SimpleTimer();
    private SimpleTimer timerExistence = new SimpleTimer();
    private int secondsExistence;
    private static final String IMAGE_UNSEEN = "images/unseenImage.png";
    private String imagePower;
    
    public PowerUp(String imagePower, int secondsExistence){
        this.imagePower = imagePower;
        setImage(imagePower);
        timerExistence.mark();
        this.secondsExistence = secondsExistence;
    }
    
    protected void flashesImage(){
        setImage(IMAGE_UNSEEN);
        if(timerFlashes.millisElapsed() >= 500){
            setImage(imagePower);
            timerFlashes.mark();
        }
    }
    
    protected void handleExistence(){
        if(secondsExistence == 0){
            getWorld().removeObject(this);
        }else if (timerExistence.millisElapsed() >= 1000) {
            timerExistence.mark();
            secondsExistence--;
        }
    }
    
    protected abstract void power();
    
}
