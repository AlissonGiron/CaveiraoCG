/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg163011m1;

import Entity.Animation;
import Entity.Entity;
import Entity.EntityFrame;
import Entity.Shape;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author AlissonGiron
 */
public class Projectile extends Entity {
    
    private int direction;
    
    public Projectile(String name, int x, int y, int direction) {
        super(name, x, y);
        this.direction = direction;
        
        CreateIdleAnimation();
    }
    
    @Override
    public void Action() {
        setX((int)(getX() + 10 * direction));
    }
    
    public void CreateIdleAnimation()
    {
        EntityFrame frame1 = new EntityFrame(this, new Shape[] 
        {
            new Shape("ball1", 0, 0, 0, 15, 15, new Color(120,0,120,255)),
            new Shape("ball2", 15, -30, 0, 15, 15, new Color(120,120,0,255)),
            new Shape("ball3", 30, 0, 0, 15, 15, new Color(120,0,120,255)),
        });
        
        EntityFrame frame2 = new EntityFrame(this, new Shape[] 
        {
            new Shape("ball1", 10, -30, 0, 15, 15, new Color(150,255,189,255)),
            new Shape("ball2", 30,  0, 0, 15, 15, new Color(150,255,189,255)),
            new Shape("ball3", 0, 0, 0, 15, 15, new Color(150,255,189,255)),
        });
        
        ArrayList<EntityFrame> frames = new ArrayList<>();
        frames.add(frame1);
        frames.add(frame2);
        
        Animation idle = new Animation("Idle", frames);
        
        addAnimation(idle);
        
        idle.SmoothAnimation(10);
    }
}
