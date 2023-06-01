import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public abstract class Tank extends Actor
{
    private static final int OFFSET = 3;
    protected static final int DIRECTION_RIGHT = 0;
    protected static final int DIRECTION_LEFT = 1;
    protected static final int DIRECTION_UP = 2;
    protected static final int DIRECTION_DOWN = 3;
    private static final String IMAGE_EXPLOSION= "images/boom1.png";
    
    protected String []images; 
    private static String imageRight;
    private static String imageLeft;
    private static String imageUp;
    private static String imageDown;
    protected int countShoot;
    protected int previousCountShoot = 4;
    protected int direction = DIRECTION_RIGHT;
    protected boolean[] move = {true,true,true,true};
    protected int directionCollision = DIRECTION_RIGHT;
    protected boolean acting = true;
    protected SimpleTimer boom_delay = new SimpleTimer();
    protected SimpleTimer timerShoot = new SimpleTimer();
    
    public Tank(String imageRight, String imageLeft, String imageUp, String imageDown, int countShoot){
        images = new String [4];
        
        images[DIRECTION_RIGHT] = imageRight;
        images[DIRECTION_LEFT] = imageLeft;
        images[DIRECTION_UP] = imageUp;
        images[DIRECTION_DOWN] = imageDown;
        
        setImage(images[DIRECTION_RIGHT]);
        this.countShoot = countShoot;
        previousCountShoot = countShoot;
    }

    public void act()
    {
               
    }

    protected void moveTank(){ 
        switch(direction){
            case DIRECTION_RIGHT:
                if(move[DIRECTION_RIGHT]){
                    setLocation(getX() + OFFSET, getY());
                    move[directionCollision] = true;
                }
                break;
            case DIRECTION_LEFT:
                if(move[DIRECTION_LEFT]){
                    setLocation(getX() - OFFSET, getY());
                    move[directionCollision] = true;
                }
                break;
            case DIRECTION_UP:
                if(move[DIRECTION_UP]){
                    setLocation(getX(),getY() - OFFSET);
                    move[directionCollision] = true;
                }
                break;
            case DIRECTION_DOWN:
                if(move[DIRECTION_DOWN]){
                    setLocation(getX(),getY() + OFFSET);
                    move[directionCollision] = true;
                }
                break;
        }
    }

    protected void checkCollisions(){
        Wall wall = (Wall)this.getOneIntersectingObject(Wall.class);
        HardBlock hardBlock = (HardBlock)this.getOneIntersectingObject(HardBlock.class);
        
        World world = getWorld();

        if(wall != null || hardBlock != null){
            directionCollision = direction;
            move[directionCollision] = false;
            switch (directionCollision){
                case DIRECTION_RIGHT:
                    setLocation(getX() - 5, getY());
                    break;
                case DIRECTION_LEFT:
                    setLocation(getX() + 5, getY());
                    break;
                case DIRECTION_UP:
                    setLocation(getX(),getY() + 5);
                    break;
                case DIRECTION_DOWN:
                    setLocation(getX(),getY() - 5);
                    break;
            }
        }
        if (getX() <= 20) {
            setLocation(22, getY());
        } else if (getX() >= getWorld().getWidth() - 20) {
            setLocation(getWorld().getWidth() - 22, getY());
        }

        if (getY() <= 20) {
            setLocation(getX(), 22);
        } else if (getY() >= getWorld().getHeight() - 20) {
            setLocation(getX(), getWorld().getHeight() - 22);
        }
    }

    protected void handleImageSelector(){
        setImage(images[direction]);
    }
    
    public void updateCountShoot(int countShoot){
        this.countShoot += countShoot;
    }

    public int getCountShoot(){
        return countShoot;
    }
    
    protected void showBoomExplodes(){
        setImage(IMAGE_EXPLOSION);
    }
    protected boolean isActing(){
        if(acting){
            return true;
        }else{
            return false;
        }
    }
    protected abstract void checkCountShoot();
    
    protected abstract void shoot();
}