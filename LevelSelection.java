import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelSelection extends Menu
{
    private static final int OPTION_LEVELONE = 1;
    private static final int OPTION_LEVELTWO = 2;
    private static final int OPTION_LEVELTHREE = 3;
    private static final int OPTION_MENUINITIAL = 4;   
    private static final int DIRECTION_INITIAL = 4;
    private int direction= DIRECTION_INITIAL;

    public LevelSelection()
    {
        super(900, 600, 1);
        setBackground("background_menu.png");
    }

    public void act()
    {
        // Add your action code here.
        showOptions();

        handleKeys();

        moveSelector();

        handleOption();
    }

    protected void showOptions (){
        showText("1) Level one   ", getWidth()/2, getHeight()/2);

        showText("2) Level two  ", getWidth()/2, getHeight()/2 + 40);

        showText("3) Level three ", getWidth()/2, getHeight()/2 + 80);

        showText("4) Menu Initial", getWidth()/2, getHeight()/2 + 120);
    }

    protected void handleKeys()
    {
        if(Greenfoot.isKeyDown("down") && timerDelay.millisElapsed() >= 300){
            direction = DIRECTION_DOWN;
            timerDelay.mark();
        }else if(Greenfoot.isKeyDown("up") && timerDelay.millisElapsed() >= 300){
            direction = DIRECTION_UP;
            timerDelay.mark();
        }else if(Greenfoot.isKeyDown("enter") && timerDelay.millisElapsed() >= 300){
            selectionOption();
            timerDelay.mark();
        }
    } 

    private void moveSelector(){
        switch(direction){
            case DIRECTION_DOWN: 
                if(displacement < 120){
                    showText(" ", getWidth()/2 - 87, getHeight()/2 + displacement);
                    displacement += 40;
                    showText(">", getWidth()/2 - 87, getHeight()/2 + displacement);
                    direction = -1;
                    Greenfoot.delay(10);
                }
                break;
            case DIRECTION_UP:
                if(displacement > 0){
                    showText(" ", getWidth()/2 - 87, getHeight()/2 + displacement);
                    displacement -= 40;
                    showText(">", getWidth()/2 - 87, getHeight()/2 + displacement);
                    direction = -1;
                    Greenfoot.delay(10);
                }
                break;
            case DIRECTION_INITIAL:
                showText(">", getWidth()/2 - 87, getHeight()/2);
                break;
        }
    }

    private void handleOption(){
        if(displacement == 0){
            option = OPTION_LEVELONE;
        }else if(displacement == 40){
            option = OPTION_LEVELTWO;
        }else if(displacement == 80){
            option = OPTION_LEVELTHREE;
        }else if(displacement == 120){
            option = OPTION_MENUINITIAL;
        }
    }

    private void selectionOption(){
        switch(option){
            case OPTION_LEVELONE:
                Greenfoot.setWorld(new LevelOne());
                break;
            case OPTION_LEVELTWO:
                Greenfoot.setWorld(new LevelTwo());
                break;
            case OPTION_LEVELTHREE:
                Greenfoot.setWorld(new LevelThree());
                break;
            case OPTION_MENUINITIAL:
                Greenfoot.setWorld(new MenuInitial());
                break;
        }
    }
}
