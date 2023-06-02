import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class LevelThree extends Level
{
    
    private SimpleTimer timer = new SimpleTimer();
    private int time = 90;
    private int score = 0;
    
    public LevelThree()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600,1);
        prepare();
        setBackground("background.png");
    }
    protected void prepare(){
        addObject(player, (getWidth() - 50)/2, (getHeight() + 100)/2);
        addObject(eagle, (getWidth() - 50)/2, (getHeight() - 50)/2);
        addObject(new Enemy(1),70,180);
        addObject(new Enemy(1),70,500);
        addObject(new Enemy(1),900,500);
        addObject(new Enemy(1),900,180);
        
        //section one
        addObject(new HardBlock(),500,0);
        addObject(new HardBlock(),500,20);
        addObject(new HardBlock(),500,40);
        addObject(new HardBlock(),500,60);
        addObject(new HardBlock(),500,80);
        addObject(new HardBlock(),500,100);
        addObject(new HardBlock(),500,120);
        
        addObject(new Bush(),500,220);
        addObject(new Bush(),500,240);
        addObject(new Bush(),500,260);
        addObject(new Bush(),500,280);
        addObject(new Bush(),500,300);
        addObject(new Bush(),500,320);
        
        addObject(new Wall(),500,420);
        addObject(new Wall(),500,440);
        addObject(new Wall(),500,460);
        addObject(new Wall(),500,480);
        addObject(new Wall(),500,500);
        addObject(new Wall(),500,520);
        
        //section two
        addObject(new Wall(),350,0);
        addObject(new Wall(),350,20);
        addObject(new Wall(),350,40);
        addObject(new Wall(),350,60);
        addObject(new Wall(),350,80);
        addObject(new Wall(),350,100);
        addObject(new Wall(),350,120);
        
        addObject(new Wall(),350,220);
        addObject(new Wall(),350,240);
        addObject(new Wall(),350,260);
        addObject(new Wall(),350,280);
        addObject(new Wall(),350,300);
        addObject(new Wall(),350,320);
        
        addObject(new Bush(),350,420);
        addObject(new Bush(),350,440);
        addObject(new Bush(),350,460);
        addObject(new Bush(),350,480);
        addObject(new Bush(),350,500);
        addObject(new Bush(),350,520);
        
        //other
        addObject(new Wall(),250,25);
        addObject(new Wall(),275,25);
        addObject(new Wall(),275,50);
        
        addObject(new Bush(),175,25);
        addObject(new Bush(),150,25);
        addObject(new Bush(),125,25);
        addObject(new Bush(),100,25);
        
        addObject(new Bush(),175,50);
        addObject(new Bush(),150,50);
        addObject(new Bush(),125,50);
        addObject(new Bush(),100,50);
        
        addObject(new Wall(),175,125);
        addObject(new Wall(),150,125);
        addObject(new Wall(),125,125);
        addObject(new Wall(),100,125);
        
        addObject(new Wall(),175,150);
        addObject(new Wall(),150,150);
        addObject(new Wall(),125,150);
        addObject(new Wall(),100,150);
        
        addObject(new HardBlock(),50,80);
        
        addObject(new HardBlock(),50,220);
        addObject(new HardBlock(),50,240);
        addObject(new HardBlock(),50,260);
        addObject(new HardBlock(),50,280);
        
        addObject(new Wall(),150,220);
        addObject(new Wall(),150,240);
        addObject(new Wall(),150,260);
        addObject(new Wall(),150,280);
        
        addObject(new Bush(),200,220);
        addObject(new Bush(),200,240);
        addObject(new Bush(),200,260);
        addObject(new Bush(),200,280);
        
        addObject(new Bush(),225,220);
        addObject(new Bush(),225,240);
        addObject(new Bush(),225,260);
        addObject(new Bush(),225,280);
        
        //hiddenBlocks
        addObject(new HardBlock(),250,220);
        addObject(new HardBlock(),250,240);
        addObject(new HardBlock(),250,260);
        addObject(new HardBlock(),250,280);
        
        addObject(new Bush(),250,220);
        addObject(new Bush(),250,240);
        addObject(new Bush(),250,260);
        addObject(new Bush(),250,280);
        
        //other
        addObject(new Wall(),50,380);
        addObject(new Wall(),50,400);
        addObject(new Wall(),75,400);
        addObject(new Wall(),75,380);
        
        addObject(new Wall(),150,400);
        addObject(new Wall(),150,380);
        
        addObject(new Wall(),225,400);
        
        addObject(new Wall(),250,380);
        
        //other
        addObject(new HardBlock(),100,550);
        addObject(new HardBlock(),125,550);
        addObject(new HardBlock(),150,550);
        addObject(new HardBlock(),175,550);
        
        addObject(new Wall(),150,500);
        
        addObject(new Wall(),200,460);
        
        addObject(new Wall(),275,550);
        
        
        //right side
        addObject(new Bush(),700,250);
        addObject(new Bush(),725,250);
        addObject(new Bush(),750,250);
        addObject(new Bush(),775,250);
        
        addObject(new Bush(),700,270);
        addObject(new Bush(),725,270);
        addObject(new Bush(),750,270);
        addObject(new Bush(),775,270);
        
        addObject(new Wall(),650,150);
        addObject(new Wall(),675,150);
        addObject(new Wall(),700,150);
        
        addObject(new HardBlock(),800,150);
        addObject(new HardBlock(),825,150);
        addObject(new HardBlock(),850,150);
        
        addObject(new Bush(),650,40);
        addObject(new Bush(),675,40);
        addObject(new Bush(),700,40);
        addObject(new Bush(),725,40);
        
        addObject(new Wall(),825,20);
        addObject(new Wall(),825,40);
        addObject(new Wall(),825,60);
        addObject(new Wall(),825,80);
        
        //other
        addObject(new HardBlock(),650,500);
        addObject(new HardBlock(),650,480);
        addObject(new HardBlock(),650,460);
        addObject(new HardBlock(),650,440);
        
        addObject(new Wall(),800,500);
        addObject(new Wall(),775,500);
        addObject(new Wall(),750,500);
        addObject(new Wall(),725,500);
        
        //hiddenBlocks
        addObject(new HardBlock(),750,380);
        addObject(new HardBlock(),775,380);
        addObject(new HardBlock(),800,380);
        addObject(new HardBlock(),825,380);
        
        addObject(new Bush(),750,380);
        addObject(new Bush(),775,380);
        addObject(new Bush(),800,380);
        addObject(new Bush(),825,380);
        
        addObject(new Wall(),800,300);
        addObject(new Wall(),800,320);
        addObject(new Wall(),800,340);
        addObject(new Wall(),800,360);
        
        addObject(new Wall(),600,300);
        addObject(new Wall(),600,320);
        addObject(new Wall(),600,340);
        addObject(new Wall(),600,360);
    }
}
