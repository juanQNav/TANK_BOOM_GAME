import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelTwo extends Level
{
    private SimpleTimer timer = new SimpleTimer();
    private int time = 70;
    private int score = 0;
    
    public LevelTwo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600,1,2);
        prepare();
        setBackground("background.png");
    }
    
    public void act()
    {
        // Add your action code here.
        updateHud();

        checkTime();

        spawnEnemyWhenAnotherDied();

        spawnPowerUp();
    }
    
    protected void prepare () {
        addObject(player, (getWidth() - 50)/2, (getHeight() + 100)/2);
        addObject(eagle, (getWidth() - 50)/2, (getHeight() - 50)/2);
        addObject(new Enemy(2),70,180);
        addObject(new Enemy(2),70,500);
        addObject(new Enemy(2),900,500);
        addObject(new Enemy(2),900,180);
        
        
        //player rounded
        addObject(new Bush(),475,260);
        addObject(new Bush(),475,280);
        addObject(new Bush(),475,300);
        
        addObject(new Bush(),375,260);
        addObject(new Bush(),375,280);
        addObject(new Bush(),375,300);
        addObject(new Bush(),375,320);
        addObject(new Bush(),400,320);
        addObject(new Bush(),425,320);
        addObject(new Bush(),450,320);
        addObject(new Bush(),475,320);
        
        addObject(new Bush(),375,240);
        addObject(new Bush(),375,220);
        addObject(new Bush(),400,220);
        addObject(new Bush(),425,220);
        addObject(new Bush(),450,220);
        addObject(new Bush(),475,220);
        addObject(new Bush(),475,240);
        
        addObject(new Bush(),450,240);
        addObject(new Bush(),425,240);
        addObject(new Bush(),400,240);
        
        addObject(new Bush(),450, 260);
        addObject(new Bush(),425, 260);
        addObject(new Bush(),400, 260);
        
        addObject(new Bush(),450, 280);
        addObject(new Bush(),425, 280);
        addObject(new Bush(),400, 280);
        
        addObject(new Bush(),450,300);
        addObject(new Bush(),425,300);
        addObject(new Bush(),400,300);
        
        //first section
        addObject(new Wall(),300,200);
        addObject(new Wall(),300,220);
        addObject(new Wall(),300,240);
        addObject(new Wall(),275,200);
        addObject(new Wall(),275,220);
        addObject(new Wall(),275,240);
        
        addObject(new HardBlock(),275,260);
        addObject(new HardBlock(),300,260);
        addObject(new HardBlock(),275,280);
        addObject(new HardBlock(),300,280);
        
        addObject(new Wall(),275,300);
        addObject(new Wall(),300,300);
        addObject(new Wall(),275,320);
        addObject(new Wall(),300,320);
        
        //second section
        addObject(new Wall(),550,200);
        addObject(new Wall(),550,220);
        addObject(new HardBlock(),550,240);
        addObject(new HardBlock(),550,260);
        addObject(new HardBlock(),550,280);
        addObject(new HardBlock(),550,300);
        addObject(new Wall(),550,320);
        
        addObject(new Wall(),575,200);
        addObject(new Wall(),575,220);
        addObject(new HardBlock(),575,240);
        addObject(new HardBlock(),575,260);
        addObject(new HardBlock(),575,280);
        addObject(new HardBlock(),575,300);
        addObject(new Wall(),575,320);
        
        //other
        addObject(new HardBlock(),725,240);
        addObject(new HardBlock(),750,240);
        addObject(new HardBlock(),775,240);
        addObject(new HardBlock(),800,240);
        
        addObject(new Wall(),725,340);
        addObject(new Wall(),750,340);
        addObject(new Wall(),775,340);
        addObject(new Wall(),800,340);
        
        
        addObject(new Bush(),725,360);
        addObject(new Bush(),725,380);
        addObject(new Bush(),725,400);
        addObject(new Bush(),725,420);
        
        addObject(new Bush(),750,360);
        addObject(new Bush(),750,380);
        addObject(new Bush(),750,400);
        addObject(new Bush(),750,420);
        
        addObject(new Bush(),775,360);
        addObject(new Bush(),775,380);
        addObject(new Bush(),775,400);
        addObject(new Bush(),775,420);
        addObject(new Bush(),775,440);
        addObject(new Bush(),775,460);
        addObject(new Bush(),775,480);
        addObject(new Bush(),775,500);
        
        addObject(new Bush(),800,360);
        addObject(new Bush(),800,380);
        addObject(new Bush(),800,400);
        addObject(new Bush(),800,420);
        addObject(new Bush(),800,440);
        addObject(new Bush(),800,460);
        addObject(new Bush(),800,480);
        addObject(new Bush(),800,500);
        
        addObject(new Bush(),825,360);
        addObject(new Bush(),825,380);
        addObject(new Bush(),825,400);
        addObject(new Bush(),825,420);
        addObject(new Bush(),825,440);
        addObject(new Bush(),825,460);
        addObject(new Bush(),825,480);
        addObject(new Bush(),825,500);
        
        addObject(new Bush(),850,360);
        addObject(new Bush(),850,380);
        addObject(new Bush(),850,400);
        addObject(new Bush(),850,420);
        addObject(new Bush(),850,440);
        addObject(new Bush(),850,460);
        addObject(new Bush(),850,480);
        addObject(new Bush(),850,500);
        
        addObject(new Bush(),875,360);
        addObject(new Bush(),875,380);
        addObject(new Bush(),875,400);
        addObject(new Bush(),875,420);
        addObject(new Bush(),875,440);
        addObject(new Bush(),875,460);
        addObject(new Bush(),875,480);
        addObject(new Bush(),875,500);
        
        addObject(new Bush(),900,360);
        addObject(new Bush(),900,380);
        addObject(new Bush(),900,400);
        addObject(new Bush(),900,420);
        addObject(new Bush(),900,440);
        addObject(new Bush(),900,460);
        addObject(new Bush(),900,480);
        addObject(new Bush(),900,500);
        
        //other
        addObject(new Wall(),575, 500);
        addObject(new Wall(),550, 500);
        addObject(new Wall(),575, 520);
        addObject(new Wall(),550, 520);
        
        addObject(new Bush(),575,540);
        //hidden blocks
        addObject(new HardBlock(),575,560);
        addObject(new HardBlock(),575,580);
        addObject(new Bush(),575,560);
        addObject(new Bush(),575,580);
        
        addObject(new Bush(),550,540);
        addObject(new Bush(),550,560);
        addObject(new Bush(),550,580);
        
        addObject(new Bush(),600,520);
        addObject(new Bush(),600,540);
        addObject(new Bush(),600,560);
        addObject(new Bush(),600,580);
        
        addObject(new Wall(),600,500);
        addObject(new Wall(),625,500);
        addObject(new Wall(),650,500);
        
        addObject(new Wall(),650,480);
        addObject(new Wall(),650,460);
        addObject(new Wall(),650,440);
        
        //other
        addObject(new Wall(),750,440);
        addObject(new Wall(),750,460);
        addObject(new Wall(),750,480);
        addObject(new Wall(),750,500);
        
        addObject(new Bush(),750,520);
        addObject(new Bush(),750,540);
        addObject(new Bush(),750,560);
        addObject(new Bush(),750,580);
        
        addObject(new Bush(),775,520);
        addObject(new Bush(),775,540);
        addObject(new Bush(),775,560);
        addObject(new Bush(),775,580);
        
        
        //hidden blocks
        addObject(new HardBlock(),800,520);
        addObject(new Bush(),800,520);
        addObject(new Bush(),800,540);
        addObject(new Bush(),800,560);
        addObject(new Bush(),800,580);
        
        addObject(new Bush(),825,520);
        addObject(new Bush(),825,540);
        addObject(new Bush(),825,560);
        addObject(new Bush(),825,580);
        
        addObject(new Bush(),850,520);
        addObject(new Bush(),850,540);
        addObject(new Bush(),850,560);
        addObject(new Bush(),850,580);
        
        addObject(new Bush(),875,520);
        addObject(new Bush(),875,540);
        addObject(new Bush(),875,560);
        addObject(new Bush(),875,580);
        
        addObject(new Bush(),900,520);
        addObject(new Bush(),900,540);
        addObject(new Bush(),900,560);
        addObject(new Bush(),900,580);
        
        //other
        addObject(new Wall(),725,200);
        addObject(new Wall(),750,200);
        addObject(new Wall(),775,200);
        addObject(new Wall(),800,200);
        
        addObject(new Wall(),725,180);
        addObject(new Wall(),750,180);
        addObject(new Wall(),775,180);
        addObject(new Wall(),800,180);
        
        //hidden blocks
        addObject(new HardBlock(),825,180);
        addObject(new HardBlock(),850,180);
        addObject(new HardBlock(),875,180);
        addObject(new HardBlock(),900,180);

        addObject(new Bush(),825,180);
        addObject(new Bush(),850,180);
        addObject(new Bush(),875,180);
        addObject(new Bush(),900,180);
        
        addObject(new Bush(),825,200);
        addObject(new Bush(),850,200);
        addObject(new Bush(),875,200);
        addObject(new Bush(),900,200);
        
        addObject(new HardBlock(),725,80);
        addObject(new HardBlock(),750,80);
        addObject(new HardBlock(),775,80);
        addObject(new HardBlock(),800,80);
        
        addObject(new HardBlock(),725,60);
        addObject(new HardBlock(),750,60);
        addObject(new HardBlock(),775,60);
        addObject(new HardBlock(),800,60);
        
        addObject(new Bush(),725,40);
        addObject(new Bush(),750,40);
        addObject(new Bush(),775,40);
        addObject(new Bush(),800,40);
        
        addObject(new Bush(),725,20);
        addObject(new Bush(),750,20);
        addObject(new Bush(),775,20);
        addObject(new Bush(),800,20);
        
        addObject(new Bush(),725,0);
        addObject(new Bush(),750,0);
        addObject(new Bush(),775,0);
        addObject(new Bush(),800,0);
        
        addObject(new Wall(),550,20);
        addObject(new Wall(),525,20);
        addObject(new Wall(),500,20);
        addObject(new Wall(),475,20);
        
        addObject(new HardBlock(),550,40);
        addObject(new HardBlock(),525,40);
        addObject(new HardBlock(),500,40);
        addObject(new HardBlock(),475,40);
        
        addObject(new Wall(),550,60);
        addObject(new Wall(),525,60);
        addObject(new Wall(),500,60);
        addObject(new Wall(),475,60);
        
        addObject(new Wall(),250,40);
        addObject(new Wall(),250,60);
        addObject(new Wall(),250,80);
        
        addObject(new Wall(),150,20);
        addObject(new Wall(),25,20);
        addObject(new Wall(),100,60);
        
        addObject(new HardBlock(),175,100);
        addObject(new HardBlock(),200,100);
        addObject(new HardBlock(),225,100);
        addObject(new HardBlock(),250,100);
        
        addObject(new Bush(),275,40);
        addObject(new Bush(),275,60);
        addObject(new Bush(),275,80);
        
        addObject(new Bush(),300,40);
        addObject(new Bush(),300,60);
        addObject(new Bush(),300,80);
        
        addObject(new Bush(),325,40);
        addObject(new Bush(),325,60);
        addObject(new Bush(),325,80);
        
        addObject(new Wall(),350,40);
        addObject(new Wall(),350,60);
        addObject(new Wall(),350,80);
        
        //other
        addObject(new Bush(),125,460);
        addObject(new Bush(),150,460);
        addObject(new Bush(),175,460);
        addObject(new Bush(),200,460);
        
        addObject(new Bush(),150,480);
        addObject(new Bush(),125,480);
        addObject(new Bush(),175,480);
        addObject(new Bush(),200,480);
        
        addObject(new Bush(),125,500);
        addObject(new Bush(),150,500);
        addObject(new Bush(),175,500);
        addObject(new Bush(),200,500);
        
        //other
        addObject(new Wall(),350,500);
        addObject(new Wall(),375,500);
        addObject(new Wall(),400,500);
        
        addObject(new Wall(),450,420);
        addObject(new Wall(),425,420);
        addObject(new Wall(),400,420);
        
        addObject(new HardBlock(),550,380);
        addObject(new HardBlock(),550,400);
        
        addObject(new Wall(),450,560);
        
        //other
        addObject(new HardBlock(),150,360);
        addObject(new HardBlock(),125,360);
        addObject(new HardBlock(),100,360);
        
        addObject(new Wall(),75,360);
        addObject(new Wall(),50,360);
        addObject(new Wall(),25,360);
        
        //other
        addObject(new Bush(),50,260);
        addObject(new Bush(),75,260);
        addObject(new Bush(),100,260);
        addObject(new Bush(),125,260);
        
        addObject(new Wall(),175,260);
        addObject(new Wall(),200,260);
    }
    
}
