import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    char direction = 'r';
    int deltaX = 0; // x velocity
    int deltaY = 0; // y velocity
    boolean isHit = false; // checks if player is damaged
    Actor actorGrabbed = null;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //item pickup and dropping
        if (Greenfoot.isKeyDown("g") && actorGrabbed == null && getOneIntersectingObject(Weapon2.class) != null) {
            // grab the object
            actorGrabbed = (Actor) getOneIntersectingObject(Weapon2.class);
            // the rest of this block will avoid the grabbed object from being hidden UNDER the Actor1 objects
            getWorld().removeObject(actorGrabbed);
            getWorld().addObject(actorGrabbed, getX(), getY());
        }
        // check for actual dragging of the object after moving object
        if (Greenfoot.isKeyDown("g") && actorGrabbed != null)
        {
            // drag the grabbed object
            actorGrabbed.setLocation(getX(), getY());
        }
        if (Greenfoot.isKeyDown("q") && actorGrabbed != null)
        {
            // release the object
            actorGrabbed = null;
        }
        //movement keys

        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - 3);
            direction = 'w';
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + 3);
            direction = 's';
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - 3, getY());
            direction = 'a';
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + 3, getY());
            direction = 'd';
        }
        // melee attack
        if (Greenfoot.isKeyDown("space")) {
            if (direction == 'w') {
                getWorld().addObject(new melee(), getX(), getY() - 30);
            }
            if (direction == 's') {
                getWorld().addObject(new melee(), getX(), getY() + 30);
            }
            if (direction == 'a') {
                getWorld().addObject(new melee(), getX() - 30, getY());
            }
            if (direction == 'd') {
                getWorld().addObject(new melee(), getX() + 30, getY());
            }
        }
    }

}
