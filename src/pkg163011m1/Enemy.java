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
public class Enemy extends Entity {
    
    @Override
    public void Action() {
        setX(getX() + 1);
    }
    
    public Enemy(String name, int x, int y) {
        super(name, x, y);
        
        CreateWalkAnimation();
        
        setCurrAnimation("Walk");
    }
    
    public void CreateWalkAnimation()
    {
        EntityFrame frame1 = new EntityFrame(this, new Shape[] 
        {
            new Shape("leftArm", 15, -35, 1, 35, 15, Color.GRAY),
            new Shape("body", -10, -50, 1, 30, 40, Color.gray),
            new Shape("leftLeg", -7, -15, 1, 10, 15, Color.gray),
            new Shape("rightLeg", 7, -15, 1, 10, 15, Color.gray),
            new Shape("rightArm", -20, -35, 1, 35, 15, Color.white),
            new Shape("head", -20, -80, 1, 50, 50, new Color(255,255,255,255)),
            new Shape("olho", 0, -60, 1, 10, 20, Color.gray),
            new Shape("olho2", 15, -60, 1, 10, 20, Color.gray)
        });
        
        EntityFrame frame2 = new EntityFrame(this, new Shape[] 
        {
            new Shape("leftArm", 2, -35, 1, 35, 15, Color.GRAY),
            new Shape("body", -10, -50, 1, 30, 40, Color.gray),
            new Shape("leftLeg", 2, -15, 1, 10, 15, Color.gray),
            new Shape("rightLeg", -2, -15, 1, 10, 15, Color.gray),
            new Shape("rightArm", -2, -35, 1, 35, 15, Color.white),
            new Shape("head", -20, -85, 1, 50, 50, new Color(255,255,255,255)),
            new Shape("olho", 0, -60, 1, 10, 20, Color.RED),
            new Shape("olho2", 15, -60, 1, 10, 20, Color.RED)
        });
        
        
        ArrayList<EntityFrame> frames = new ArrayList<>();
        frames.add(frame1);
        frames.add(frame2);
        
        Animation idle = new Animation("Walk", frames);
        
        addAnimation(idle);
        
        idle.SmoothAnimation(20);
    }
    
    
}
