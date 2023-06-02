import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class MenuRecord extends Menu
{
    private static final int OPTION_LEVEL1 = 1;
    private static final int OPTION_LEVEL2 = 2;
    private static final int OPTION_LEVEL3 = 3;
    private static final int OPTION_MENU_INITIAL = 4;
    private static final int OPTION_MENURECORD = 5;
    private static final int DIRECTION_INITIAL = 4;
    private int direction= DIRECTION_INITIAL;
    private boolean acting = true;

    public MenuRecord()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600,1);
        setBackground("background_menu.png");
    }

    public void act(){
        if(isActing()){
            showOptions();

            moveSelector();

            handleOption();
        }
        handleKeys();
    }

    protected void showOptions (){
        showText("1)Level 1", getWidth()/2, getHeight()/2);

        showText("2)Level 2", getWidth()/2, getHeight()/2 + 40);

        showText("3)Level 3", getWidth()/2, getHeight()/2 + 80);

        showText("4)Menu Initial", getWidth()/2, getHeight()/2 + 120);
    }

    protected void handleKeys(){
        if(isActing()){
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
        }else{
            if(Greenfoot.isKeyDown("enter") && timerDelay.millisElapsed() >= 300){
                cleanText();
                displacement = 0;
                delay = COUNT_DOWN_START_VALUE;
                option = OPTION_MENURECORD;
                selectionOption();
                option = -1;
                timerDelay.mark();
            }
        }

    }

    private void moveSelector(){
        switch(direction){
            case DIRECTION_DOWN: 
                if(displacement < 120){
                    showText(" ", getWidth()/2 - 88, getHeight()/2 + displacement);
                    displacement += 40;
                    showText(">", getWidth()/2 - 88, getHeight()/2 + displacement);
                    direction = -1;
                    Greenfoot.delay(10);
                }
                break;
            case DIRECTION_UP:
                if(displacement > 0){
                    showText(" ", getWidth()/2 - 88, getHeight()/2 + displacement);
                    displacement -= 40;
                    showText(">", getWidth()/2 - 88, getHeight()/2 + displacement);
                    direction = -1;
                    Greenfoot.delay(10);
                }
                break;
            case DIRECTION_INITIAL:
                showText(">", getWidth()/2 - 88, getHeight()/2);
                break;
        }
    }

    private void handleOption(){
        if(displacement == 0){
            option = OPTION_LEVEL1;
        }else if(displacement == 40){
            option = OPTION_LEVEL2;
        }else if(displacement == 80){
            option = OPTION_LEVEL3;
        }else if(displacement == 120){
            option = OPTION_MENU_INITIAL;
        }
    }

    private void selectionOption()
    {
        switch(option){
            case OPTION_LEVEL1:
                acting = false;
                cleanText();
                showRecord(OPTION_LEVEL1);
                returnShowOption();
                break;
            case OPTION_LEVEL2:
                acting = false;
                cleanText();
                showRecord(OPTION_LEVEL2);
                returnShowOption();
                break;
            case OPTION_LEVEL3:
                acting = false;
                cleanText();
                showRecord(OPTION_LEVEL3);
                returnShowOption();
                break;
            case OPTION_MENU_INITIAL: 
                Greenfoot.setWorld(new MenuInitial());
                returnShowOption();
                break;
            case OPTION_MENURECORD: 
                acting = true;
                showText(">", getWidth()/2 - 88, getHeight()/2);
        }
    }

    private void cleanText(){
        showText("", getWidth()/2, getHeight()/2);

        showText("", getWidth()/2, getHeight()/2 + 40);

        showText("", getWidth()/2, getHeight()/2 + 80);

        showText("", getWidth()/2, getHeight()/2 + 120);

        showText("", getWidth()/2, getHeight()/2 + 250);

        showText("", getWidth()/2 - 88, getHeight()/2 + displacement);

        showText("" ,getWidth()/2, getHeight()/2);

        showText("" ,getWidth()/2, getHeight()/2 + 10);
        for (int i = 0; i < 5; i++){
            showText("",getWidth()/2, getHeight()/2 + 50 +(25*i));
        }
    }

    private boolean isActing(){
       return acting == true;
    }

    private void returnShowOption(){
        showText("Pres enter to return...", getWidth()/2, getHeight()/2 + 250);
    }

    private void showRecord(int level) {
        List<RecordScore> records = FileManager.getAllRecordScores(level);

        records.sort(Comparator.comparingInt(RecordScore::getScore).reversed());

        showText("PLAYER NAME           |            SCORE" ,getWidth()/2, getHeight()/2);
        showText("-----------------------------------------------------" ,getWidth()/2, getHeight()/2 + 10);
        int count = Math.min(5, records.size());
        for (int i = 0; i < count; i++) {
            RecordScore record = records.get(i);
            showText(record.getPlayersName() + "                       " + record.getScore(),getWidth()/2, getHeight()/2 + 50 +(25*i));
        }
    }
}
