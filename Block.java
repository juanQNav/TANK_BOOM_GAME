import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Block extends Actor
{
    private  int countShoot;
    
    public Block(int countShoot){
        this.countShoot= countShoot;
    }
    public void act() {
        checkShoot();
        breakBlock();
    }

    private void checkShoot() {
        Projectile proyectile = (Projectile) getOneIntersectingObject(Projectile.class);

        if (proyectile != null) {
            countShoot--;
            getWorld().removeObject(proyectile);
        }
    }

    private void breakBlock() {
        if (countShoot == 0) {
            getWorld().removeObject(this);
        }
    }
}
