import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Tank extends Actor
{
    private static final int COUNT_DOWN_STAR_VALUE = 11;
    private static final int OFFSET = 8;
    private static final int DIRECTION_RIGHT = 0;
    private static final int DIRECTION_LEFT = 1;
    private static final int DIRECTION_UP = 2;
    private static final int DIRECTION_DOWN = 3;
    
    private int mouthDelay = COUNT_DOWN_STAR_VALUE;
    
    private String [][]images; 
    private int imageIndex;
    private int direction = DIRECTION_RIGHT;
    
    private int score;
    
    private boolean[] move = {true,true,true,true};
    private int directionCollision;
    
    public Tank(){
        images = new String[4][2];
            
        images[DIRECTION_RIGHT] = new String[]{
            "images/tank_right.png",
            "images/tank_right.png"
        };
        images[DIRECTION_LEFT] = new String[]{
            "images/tank_left.png",
            "images/tank_left.png"
        };
        images[DIRECTION_UP] = new String[]{
            "images/tank_up.png",
            "images/tank_up.png"
        };
        images[DIRECTION_DOWN] = new String[]{
            "images/tank_down.png",
            "images/tank_down.png"
        };        
        setImage(images[DIRECTION_RIGHT][0]);
    }
    public void act()
    {
        handleKeys();
        
        moveTank();
        
        handelImageSelector();
        
        checkCollisions();
        
        updateHud();
     
    }
    private void moveTank(){ 
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
    private void checkCollisions(){
        Wall wall = (Wall)this.getOneIntersectingObject(Wall.class);
          if(wall != null){
         directionCollision = direction;
         move[directionCollision] = false;
         switch (directionCollision){
         case DIRECTION_RIGHT:
                    setLocation(getX() - 2, getY());
                break;
            case DIRECTION_LEFT:
                    setLocation(getX() + 2, getY());
                break;
            case DIRECTION_UP:
                    setLocation(getX(),getY() + 2);
                break;
            case DIRECTION_DOWN:
                    setLocation(getX(),getY() - 2);
                break;
    }
    }
    }
    private void handleKeys(){
            if(Greenfoot.isKeyDown("left")){
        direction =  DIRECTION_LEFT;
    }else if(Greenfoot.isKeyDown("right")){
        direction =  DIRECTION_RIGHT;
    }else if(Greenfoot.isKeyDown("up")){
        direction = DIRECTION_UP;
    }else if(Greenfoot.isKeyDown("down")){
        direction = DIRECTION_DOWN;
    }
    }
    
    private void handelImageSelector(){
        mouthDelay --;
     if(mouthDelay == 0){
         imageIndex = (imageIndex + 1) % images[direction].length;
         
         setImage(images[direction][imageIndex]);
         
         mouthDelay = COUNT_DOWN_STAR_VALUE;
     }
    }
    
    private void updateHud(){
         World world = getWorld();
        
        world.showText("Score: " + score, world.getWidth() - 100,20);
    }
}
