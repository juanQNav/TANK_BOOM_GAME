import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelOne extends World
{

    public LevelOne()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        prepare();
    }

    private void prepare(){
        addObject(new Player(), (getWidth() - 50)/2, (getHeight() - 50)/2);
        addObject(new Enemy(),70,180);
        addObject(new Enemy(),70,500);
        addObject(new Enemy(),900,500);
        addObject(new Enemy(),900,180);
        
        //walls on the far left
        
        addObject(new Bush(),0,65);
        addObject(new Bush(),0,85);
        addObject(new Bush(),0,110);
        addObject(new Bush(),0,135);
        
        //hard blocks hidden
        addObject(new HardBlock(),25,65);
        addObject(new HardBlock(),25,85);
        addObject(new HardBlock(),25,110);
        addObject(new HardBlock(),25,135);
        
        addObject(new Bush(),25,65);
        addObject(new Bush(),25,85);
        addObject(new Bush(),25,110);
        addObject(new Bush(),25,135);
        
        addObject(new Bush(),50,65);
        addObject(new Bush(),50,85);
        addObject(new Bush(),50,110);
        addObject(new Bush(),50,135);
        
        addObject(new Bush(),75,65);
        addObject(new Bush(),75,85);
        addObject(new Bush(),75,110);
        addObject(new Bush(),75,135);
        
        addObject(new Bush(),100,65);
        addObject(new Bush(),100,85);
        addObject(new Bush(),100,110);
        addObject(new Bush(),100,135);
        
        addObject(new Wall(),125,65);
        addObject(new Wall(),125,85);
        addObject(new Wall(),125,110);
        addObject(new Wall(),125,135);
        
        addObject(new Wall(),150,65);
        addObject(new Wall(),150,85);
        addObject(new Wall(),150,110);
        addObject(new Wall(),150,135);
        
        addObject(new Wall(),175,65);
        addObject(new Wall(),175,85);
        addObject(new Wall(),175,110);
        addObject(new Wall(),175,135);
        
        addObject(new Wall(),200,65);
        addObject(new Wall(),200,85);
        addObject(new Wall(),200,110);
        addObject(new Wall(),200,135);
        
        addObject(new Wall(),225,65);
        addObject(new Wall(),225,85);
        addObject(new Wall(),225,110);
        addObject(new Wall(),225,135);
        
        addObject(new Bush(),250,85);
        addObject(new Bush(),250,110);
        addObject(new Bush(),250,135);
        
        addObject(new Bush(),275,85);
        addObject(new Bush(),275,110);
        addObject(new Bush(),275,135);
        
        //mid
        addObject(new HardBlock(),175,195); //hidden block
        addObject(new Wall(),175,195);
        addObject(new Wall(),275,195);
        
        addObject(new Wall(),475,175);
        addObject(new Wall(),550,225);
        
        
        addObject(new Bush(),300,85);
        addObject(new Bush(),300,110);
        addObject(new Bush(),300,135);
        
        addObject(new Wall(),325,85);
        addObject(new Wall(),325,110);
        addObject(new Wall(),325,135);
        
        addObject(new Wall(),350,85);
        addObject(new Wall(),350,110);
        addObject(new Wall(),350,135);
        
        addObject(new Wall(),450,85);
        addObject(new Wall(),450,110);
        addObject(new Wall(),450,135);
        
        addObject(new HardBlock(),475,85);
        addObject(new HardBlock(),475,110);
        addObject(new HardBlock(),475,135);
        
        addObject(new HardBlock(),500,85);
        addObject(new HardBlock(),500,110);
        addObject(new HardBlock(),500,135);
        
        addObject(new Bush(),525,5);
        addObject(new Bush(),525,25);
        addObject(new Bush(),525,45);
        addObject(new HardBlock(),525,65); //hidden block
        addObject(new Bush(),525,65);
        addObject(new Bush(),525,85);
        addObject(new Bush(),525,110);
        addObject(new Bush(),525,135);
        
        addObject(new Bush(),550,5);
        addObject(new Bush(),550,25);
        addObject(new Bush(),550,45);
        addObject(new Bush(),550,65);
        addObject(new Bush(),550,85);
        addObject(new Bush(),550,110);
        addObject(new Bush(),550,135);
        
        addObject(new Bush(),575,5);
        addObject(new Bush(),575,25);
        addObject(new Bush(),575,45);
        addObject(new Bush(),575,65);
        addObject(new Bush(),575,85);
        addObject(new Bush(),575,110);
        addObject(new Bush(),575,135);
        
        addObject(new Bush(),600,5);
        addObject(new Bush(),600,25);
        addObject(new Bush(),600,45);
        addObject(new Bush(),600,65);
        addObject(new Bush(),600,85);
        addObject(new Bush(),600,110);
        addObject(new Bush(),600,135);
        
        addObject(new HardBlock(),625,5); //block hidden
        addObject(new Bush(),625,5);
        addObject(new Bush(),625,25);
        addObject(new Bush(),625,45);
        addObject(new Bush(),625,65);
        addObject(new Bush(),625,85);
        addObject(new Bush(),625,110);
        addObject(new HardBlock(),625,135); //block hidden
        addObject(new Bush(),625,135);

        addObject(new Wall(),650,5);
        addObject(new Wall(),650,25);
        addObject(new Wall(),650,45);
        addObject(new Wall(),650,65);
        addObject(new Wall(),650,85);
        addObject(new Wall(),650,110);
        addObject(new Wall(),650,135);
        
        
        addObject(new Wall(),750,65);
        addObject(new Wall(),750,85);
        addObject(new Wall(),750,110);
        addObject(new Wall(),750,135);
        
        
        addObject(new Wall(),775,65);
        addObject(new Wall(),775,85);
        addObject(new Wall(),775,110);
        addObject(new Wall(),775,135);
        
        addObject(new Wall(),800,65);
        addObject(new Wall(),800,85);
        addObject(new Wall(),800,110);
        addObject(new Wall(),800,135);
        
        addObject(new Wall(),825,65);
        addObject(new Wall(),825,85);
        addObject(new Wall(),825,110);
        addObject(new Wall(),825,135);
        
        addObject(new Bush(),850,65);
        addObject(new Bush(),850,85);
        addObject(new Bush(),850,110);
        addObject(new Bush(),850,135);
        
        addObject(new Bush(),875,65);
        addObject(new Bush(),875,85);
        addObject(new Bush(),875,110);
        addObject(new Bush(),875,135);
        
        addObject(new Bush(),900,65);
        addObject(new Bush(),900,85);
        addObject(new Bush(),900,110);
        addObject(new Bush(),900,135);
        
        
        
        //other section
        
        addObject(new Wall(),375,240);
        addObject(new Wall(),375,220);
        addObject(new Wall(),400,220);
        addObject(new Wall(),425,220);
        addObject(new Wall(),450,220);
        addObject(new Wall(),475,220);
        addObject(new Wall(),475,240);
        
        addObject(new Wall(),375,260);
        addObject(new Wall(),375,280);
        addObject(new Wall(),375,300);
        addObject(new Wall(),375,320);
        addObject(new Wall(),400,320);
        addObject(new Wall(),425,320);
        addObject(new Wall(),450,320);
        addObject(new Wall(),475,320);

        //player round
        
        addObject(new Wall(),475,260);
        addObject(new Wall(),475,280);
        addObject(new Wall(),475,300);
        
        addObject(new Bush(),600,260);
        addObject(new Bush(),600,280);
        addObject(new Bush(),600,300);
        addObject(new Bush(),600,320);
        addObject(new Bush(),600,340);
        addObject(new Bush(),600,360);
        addObject(new Bush(),600,380);
        addObject(new Bush(),600,400);
        addObject(new Bush(),600,420);
        addObject(new Bush(),600,440);
        addObject(new Bush(),600,460);
        
        addObject(new Bush(),625,260);
        addObject(new Bush(),625,280);
        addObject(new Bush(),625,300);
        addObject(new Bush(),625,320);
        addObject(new Bush(),625,340);
        addObject(new Bush(),625,360);
        addObject(new Bush(),625,380);
        addObject(new Bush(),625,400);
        addObject(new Bush(),625,420);
        addObject(new Bush(),625,440);
        addObject(new Bush(),625,460);
        
        addObject(new Bush(),650,260);
        addObject(new Bush(),650,280);
        addObject(new Bush(),650,300);
        addObject(new Bush(),650,320);
        addObject(new Bush(),650,340);
        addObject(new Bush(),650,360);
        addObject(new Bush(),650,380);
        addObject(new Bush(),650,400);
        addObject(new Bush(),650,420);
        addObject(new Bush(),650,440);
        addObject(new Bush(),650,460);
        
        
        addObject(new HardBlock(),675,260);
        addObject(new HardBlock(),675,280);
        addObject(new Wall(),675,380);
        addObject(new Wall(),675,400);
        
        addObject(new HardBlock(),700,260);
        addObject(new HardBlock(),700,280);
        addObject(new HardBlock(),700,360);
        addObject(new HardBlock(),700,380);
        
        
        addObject(new HardBlock(),725,260);
        addObject(new HardBlock(),725,280);
        addObject(new HardBlock(),725,360);
        addObject(new HardBlock(),725,380);
        
        //hidden blocks
        addObject(new HardBlock(),825,260);
        addObject(new HardBlock(),825,280);
        addObject(new HardBlock(),825,360);
        addObject(new HardBlock(),825,380);
        
        addObject(new Bush(),825,260);
        addObject(new Bush(),825,280);
        addObject(new Bush(),825,360);
        addObject(new Bush(),825,380);
        
        //hidden
        addObject(new HardBlock(),850,260);
        addObject(new HardBlock(),850,280);
        addObject(new Bush(),850,260);
        addObject(new Bush(),850,280);
        
        addObject(new HardBlock(),850,360);
        addObject(new HardBlock(),850,380);
        
        //hidden
        addObject(new HardBlock(),875,260);
        addObject(new HardBlock(),875,280);
        addObject(new Bush(),875,260);
        addObject(new Bush(),875,280);
        
        addObject(new HardBlock(),875,360);
        addObject(new HardBlock(),875,380);
        
        addObject(new Wall(),750,480);
        addObject(new HardBlock(),750,500);
        
        addObject(new Wall(),775,480);
        addObject(new HardBlock(),775,500);
        
        addObject(new Wall(),800,480);
        addObject(new HardBlock(),800,500);
        
        addObject(new Wall(),825,480);
        addObject(new HardBlock(),825,500);
        
        addObject(new Wall(),125,300);
        addObject(new Wall(),125,320);
        addObject(new Wall(),125,340);
        
        addObject(new HardBlock(),225,300);
        addObject(new HardBlock(),225,320);
        addObject(new HardBlock(),225,340);
        
        addObject(new Bush(),250,300);
        addObject(new Bush(),250,320);
        addObject(new Bush(),250,340);
        addObject(new Bush(),250,360);
        addObject(new Bush(),250,380);
        addObject(new Bush(),250,400);
        addObject(new Bush(),250,420);
        addObject(new Bush(),250,440);
        //hidden blocks
        addObject(new HardBlock(),250,460);
        addObject(new HardBlock(),250,480);
        addObject(new Bush(),250,460);
        addObject(new Bush(),250,480);
        addObject(new Bush(),250,500);
        addObject(new Bush(),250,520);
        addObject(new Bush(),250,540);
        addObject(new Bush(),250,560);
        addObject(new Bush(),250,580);
        
        addObject(new Bush(),275,300);
        addObject(new Bush(),275,320);
        addObject(new Bush(),275,340);
        //hidden blocks
        addObject(new HardBlock(),275,340);
        addObject(new HardBlock(),275,360);
        addObject(new Bush(),275,340);
        addObject(new Bush(),275,360);
        addObject(new Bush(),275,380);
        addObject(new Bush(),275,400);
        addObject(new Bush(),275,420);
        addObject(new Bush(),275,440);
        addObject(new Bush(),275,460);
        addObject(new Bush(),275,480);
        addObject(new Bush(),275,500);
        addObject(new Bush(),275,520);
        addObject(new Bush(),275,540);
        addObject(new Bush(),275,560);
        addObject(new Bush(),275,580);
        
        
        
        addObject(new Bush(),300,300);
        addObject(new Bush(),300,320);
        addObject(new Bush(),300,340);
        addObject(new Bush(),300,340);
        addObject(new Bush(),300,360);
        addObject(new Bush(),300,380);
        addObject(new Bush(),300,400);
        addObject(new Bush(),300,420);
        addObject(new Bush(),300,440);
        addObject(new Bush(),300,460);
        addObject(new Bush(),300,480);
        addObject(new Bush(),300,500);
        //hidden blocks
        addObject(new HardBlock(),300,520);
        addObject(new HardBlock(),300,540);
        addObject(new Bush(),300,520);
        addObject(new Bush(),300,540);
        addObject(new Bush(),300,560);
        addObject(new Bush(),300,580);
        
        
        addObject(new HardBlock(),325,300);
        addObject(new HardBlock(),325,320);
        addObject(new HardBlock(),325,340);
        
        addObject(new Wall(),150,500);
        addObject(new Wall(),175,500);
        addObject(new Wall(),200,500);
        
        addObject(new Wall(),150,420);
        
    }
}
