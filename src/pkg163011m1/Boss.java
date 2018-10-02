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
import Entity.ShapeType;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author AlissonGiron
 */
public class Boss extends Entity {
 
    private ArrayList<Entity> eyes;
    private int vida;
    private boolean canReceiveDamage;
    
    public Boss(int height, int width) {
        super("Boss", width/2, 50);
        eyes = new ArrayList<>();
        
        setColisor(new Rectangle(getX(), getY(), 500, 550));
        vida = 100;
        canReceiveDamage = false;
        
        // olhos
        Entity leftEye = new Entity("olhoEsquerdo", 0, 0);
        leftEye.setParent(this);
        leftEye.setDefaultSprite(new Shape("leftEye", 90, 320, 1, 50, 50, Color.white));

        Entity rightEye = new Entity("olhoDireito", 0, 0);
        rightEye.setParent(this);
        rightEye.setDefaultSprite(new Shape("rightEye", 320, 320, 1, 50, 50, Color.white));

        eyes.add(leftEye);
        eyes.add(rightEye);
        
        EntityFrame frame1 = new EntityFrame(this, new Shape[] 
        {
            new Shape("pescoco1", 200, 500, 1, 100, 100, Color.DARK_GRAY),
            new Shape("pescoco2", 200, 580, 1, 100, 100, Color.DARK_GRAY),
            new Shape("cabeca", 0, 0, 1, 500, 500, Color.GRAY),
            new Shape("dente1", 100, 350, 1, 100, 200, Color.gray),
            new Shape("dente2", 200, 350, 1, 100, 200, Color.gray),
            new Shape("dente3", 300, 350, 1, 100, 200, Color.gray),
            new Shape("olhoesquerdo", 80, 200, 1, 100, 200, Color.black),
            new Shape("olhodireito", 310, 200, 1, 100, 200, Color.black),
            new Shape("nariz", 220, 350, 1, 50, 100, Color.black),
            new Shape("dedo1", -100, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo2", -150, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo3", -200, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo4", 600, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo5", 650, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo6", 700, 600, 4, 50, 100, Color.GRAY),            
            new Shape("dedo7", -100, 700, 3, 100, 50, Color.GRAY),
            new Shape("braco", -130, 650, 3, 50, 500, Color.DARK_GRAY),
            new Shape("mao", -180, 650, 3, 150, 150, Color.DARK_GRAY)
        });
        
        ArrayList<EntityFrame> frames = new ArrayList<>();
       
        frames.add(frame1);
        
        Animation anim = new Animation("Idle", frames);
        anim.setRunOnce(true);
        
        addAnimation(anim);        
        
        CreateAnimationRightArmUp();
        CreateAnimationRightArmDown();
        CreateAnimationLeftArmUp();
        CreateAnimationLeftArmDown();
    }
    
    public void damageBoss()
    {
        setVida(getVida() - 10);
        canReceiveDamage = false;
    }
    
    @Override
    public void Action() {
    }
    
    public void moveEyes(int width, int heightZero, int player_x, int player_y) {
        getEyes().get(0).setX((int) Math.round(((30.0 / width) * player_x)));
        getEyes().get(1).setX((int) Math.round(((30.0 / width) * player_x)));
        getEyes().get(1).setY(-((heightZero - player_y) / 20));
        getEyes().get(0).setY(-((heightZero - player_y) / 20));
    }

    /**
     * @return the eyes
     */
    public ArrayList<Entity> getEyes() {
        return eyes;
    }

    /**
     * @param eyes the eyes to set
     */
    public void setEyes(ArrayList<Entity> eyes) {
        this.eyes = eyes;
    }
    
    
    private void CreateAnimationRightArmDown()
    {
        EntityFrame frame1 = new EntityFrame(this, new Shape[] 
        {
            new Shape("pescoco1", 200, 500, 1, 100, 100, Color.DARK_GRAY),
            new Shape("pescoco2", 200, 580, 1, 100, 100, Color.DARK_GRAY),
            new Shape("cabeca", 0, 0, 1, 500, 500, Color.GRAY),
            new Shape("dente1", 100, 350, 1, 100, 200, Color.gray),
            new Shape("dente2", 200, 350, 1, 100, 200, Color.gray),
            new Shape("dente3", 300, 350, 1, 100, 200, Color.gray),
            new Shape("olhoesquerdo", 80, 200, 1, 100, 200, Color.black),
            new Shape("olhodireito", 310, 200, 1, 100, 200, Color.black),
            new Shape("nariz", 220, 350, 1, 50, 100, Color.black),
            new Shape("dedo1", -100, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo2", -150, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo3", -200, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo4", 600, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo5", 650, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo6", 700, 600, 4, 50, 100, Color.GRAY),            
            new Shape("dedo7", -100, 700, 3, 100, 50, Color.GRAY),
            new Shape("braco", -130, 600, 0, 50, 500, Color.DARK_GRAY),
            new Shape("mao", -180, 600, 0, 150, 150, Color.DARK_GRAY)
        });
        
        EntityFrame frame2 = new EntityFrame(this, new Shape[] 
        {
            new Shape("pescoco1", 200, 500, 1, 100, 100, Color.DARK_GRAY),
            new Shape("pescoco2", 200, 580, 1, 100, 100, Color.DARK_GRAY),
            new Shape("cabeca", 0, 0, 1, 500, 500, Color.GRAY),
            new Shape("dente1", 100, 350, 1, 100, 200, Color.gray),
            new Shape("dente2", 200, 350, 1, 100, 200, Color.gray),
            new Shape("dente3", 300, 350, 1, 100, 200, Color.gray),
            new Shape("olhoesquerdo", 80, 200, 1, 100, 200, Color.black),
            new Shape("olhodireito", 310, 200, 1, 100, 200, Color.black),
            new Shape("nariz", 220, 350, 1, 50, 100, Color.black),
            new Shape("dedo1", -100, 350, 4, 50, 100, Color.GRAY),
            new Shape("dedo2", -150, 400, 4, 50, 100, Color.GRAY),
            new Shape("dedo3", -200, 400, 4, 50, 100, Color.GRAY),
            new Shape("dedo4", 600, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo5", 650, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo6", 700, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo7", -100, 500, 3, 100, 50, Color.GRAY),
            new Shape("braco", -130, 420, 0, 50, 500, Color.DARK_GRAY),
            new Shape("mao", -180, 420, 0, 150, 150, Color.DARK_GRAY)
        });
        
        ArrayList<EntityFrame> frames = new ArrayList<>();
       
        frames.add(frame2);
        frames.add(frame1);
        
        Animation anim = new Animation("RightArmDown", frames);
        anim.setRunOnce(true);
        
        addAnimation(anim);
        
        anim.SmoothAnimation(60);
    }
    
    private void CreateAnimationRightArmUp()
    {
         
        EntityFrame frame1 = new EntityFrame(this, new Shape[] 
        {
            new Shape("pescoco1", 200, 500, 1, 100, 100, Color.DARK_GRAY),
            new Shape("pescoco2", 200, 580, 1, 100, 100, Color.DARK_GRAY),
            new Shape("cabeca", 0, 0, 1, 500, 500, Color.GRAY),
            new Shape("dente1", 100, 350, 1, 100, 200, Color.gray),
            new Shape("dente2", 200, 350, 1, 100, 200, Color.gray),
            new Shape("dente3", 300, 350, 1, 100, 200, Color.gray),
            new Shape("olhoesquerdo", 80, 200, 1, 100, 200, Color.black),
            new Shape("olhodireito", 310, 200, 1, 100, 200, Color.black),
            new Shape("nariz", 220, 350, 1, 50, 100, Color.black),
            new Shape("dedo1", -100, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo2", -150, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo3", -200, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo4", 600, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo5", 650, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo6", 700, 600, 4, 50, 100, Color.GRAY),            
            new Shape("dedo7", -100, 700, 3, 100, 50, Color.GRAY),
            new Shape("braco", -130, 600, 0, 50, 500, Color.DARK_GRAY),
            new Shape("mao", -180, 600, 0, 150, 150, Color.DARK_GRAY)
        });
        
        EntityFrame frame2 = new EntityFrame(this, new Shape[] 
        {
            new Shape("pescoco1", 200, 500, 1, 100, 100, Color.DARK_GRAY),
            new Shape("pescoco2", 200, 580, 1, 100, 100, Color.DARK_GRAY),
            new Shape("cabeca", 0, 0, 1, 500, 500, Color.GRAY),
            new Shape("dente1", 100, 350, 1, 100, 200, Color.gray),
            new Shape("dente2", 200, 350, 1, 100, 200, Color.gray),
            new Shape("dente3", 300, 350, 1, 100, 200, Color.gray),
            new Shape("olhoesquerdo", 80, 200, 1, 100, 200, Color.black),
            new Shape("olhodireito", 310, 200, 1, 100, 200, Color.black),
            new Shape("nariz", 220, 350, 1, 50, 100, Color.black),
            new Shape("dedo1", -100, 350, 4, 50, 100, Color.GRAY),
            new Shape("dedo2", -150, 400, 4, 50, 100, Color.GRAY),
            new Shape("dedo3", -200, 400, 4, 50, 100, Color.GRAY),
            new Shape("dedo4", 600, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo5", 650, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo6", 700, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo7", -100, 500, 3, 100, 50, Color.GRAY),
            new Shape("braco", -130, 420, 0, 50, 500, Color.DARK_GRAY),
            new Shape("mao", -180, 420, 0, 150, 150, Color.DARK_GRAY)
        });
        
        ArrayList<EntityFrame> frames = new ArrayList<>();
        frames.add(frame1);
        frames.add(frame2);
        
        Animation anim = new Animation("RightArmUp", frames);
        anim.setRunOnce(true);
        
        addAnimation(anim);
        
        anim.SmoothAnimation(60);
    }
    
    private void CreateAnimationLeftArmDown()
    {
        EntityFrame frame1 = new EntityFrame(this, new Shape[] 
        {
            new Shape("pescoco1", 200, 500, 1, 100, 100, Color.DARK_GRAY),
            new Shape("pescoco2", 200, 580, 1, 100, 100, Color.DARK_GRAY),
            new Shape("cabeca", 0, 0, 1, 500, 500, Color.GRAY),
            new Shape("dente1", 100, 350, 1, 100, 200, Color.gray),
            new Shape("dente2", 200, 350, 1, 100, 200, Color.gray),
            new Shape("dente3", 300, 350, 1, 100, 200, Color.gray),
            new Shape("olhoesquerdo", 80, 200, 1, 100, 200, Color.black),
            new Shape("olhodireito", 310, 200, 1, 100, 200, Color.black),
            new Shape("nariz", 220, 350, 1, 50, 100, Color.black),
            new Shape("dedo1", -100, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo2", -150, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo3", -200, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo4", 600, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo5", 650, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo6", 700, 600, 4, 50, 100, Color.GRAY),            
            new Shape("dedo7", 550, 700, 3, 100, 50, Color.GRAY),
            new Shape("braco", 650, 600, 0, 50, 500, Color.DARK_GRAY),
            new Shape("mao", 600, 600, 0, 150, 150, Color.DARK_GRAY)
        });
        
        EntityFrame frame2 = new EntityFrame(this, new Shape[] 
        {
            new Shape("pescoco1", 200, 500, 1, 100, 100, Color.DARK_GRAY),
            new Shape("pescoco2", 200, 580, 1, 100, 100, Color.DARK_GRAY),
            new Shape("cabeca", 0, 0, 1, 500, 500, Color.GRAY),
            new Shape("dente1", 100, 350, 1, 100, 200, Color.gray),
            new Shape("dente2", 200, 350, 1, 100, 200, Color.gray),
            new Shape("dente3", 300, 350, 1, 100, 200, Color.gray),
            new Shape("olhoesquerdo", 80, 200, 1, 100, 200, Color.black),
            new Shape("olhodireito", 310, 200, 1, 100, 200, Color.black),
            new Shape("nariz", 220, 350, 1, 50, 100, Color.black),
            new Shape("dedo1", -100, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo2", -150, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo3", -200, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo4", 600, 350, 4, 50, 100, Color.GRAY),
            new Shape("dedo5", 650, 400, 4, 50, 100, Color.GRAY),
            new Shape("dedo6", 700, 400, 4, 50, 100, Color.GRAY),
            new Shape("dedo7", 550, 500, 3, 100, 50, Color.GRAY),
            new Shape("braco", 650, 420, 0, 50, 500, Color.DARK_GRAY),
            new Shape("mao", 600, 420, 0, 150, 150, Color.DARK_GRAY)
        });
        
        ArrayList<EntityFrame> frames = new ArrayList<>();
       
        frames.add(frame2);
        frames.add(frame1);
        
        Animation anim = new Animation("LeftArmDown", frames);
        anim.setRunOnce(true);
        
        addAnimation(anim);
        
        anim.SmoothAnimation(60);
    }
    
    private void CreateAnimationLeftArmUp()
    {
         
        EntityFrame frame1 = new EntityFrame(this, new Shape[] 
        {
            new Shape("pescoco1", 200, 500, 1, 100, 100, Color.DARK_GRAY),
            new Shape("pescoco2", 200, 580, 1, 100, 100, Color.DARK_GRAY),
            new Shape("cabeca", 0, 0, 1, 500, 500, Color.GRAY),
            new Shape("dente1", 100, 350, 1, 100, 200, Color.gray),
            new Shape("dente2", 200, 350, 1, 100, 200, Color.gray),
            new Shape("dente3", 300, 350, 1, 100, 200, Color.gray),
            new Shape("olhoesquerdo", 80, 200, 1, 100, 200, Color.black),
            new Shape("olhodireito", 310, 200, 1, 100, 200, Color.black),
            new Shape("nariz", 220, 350, 1, 50, 100, Color.black),
            new Shape("dedo1", -100, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo2", -150, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo3", -200, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo4", 600, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo5", 650, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo6", 700, 600, 4, 50, 100, Color.GRAY),            
            new Shape("dedo7", 550, 700, 3, 100, 50, Color.GRAY),
            new Shape("braco", 650, 600, 0, 50, 500, Color.DARK_GRAY),
            new Shape("mao", 600, 600, 0, 150, 150, Color.DARK_GRAY)
        });
        
        EntityFrame frame2 = new EntityFrame(this, new Shape[] 
        {
            new Shape("pescoco1", 200, 500, 1, 100, 100, Color.DARK_GRAY),
            new Shape("pescoco2", 200, 580, 1, 100, 100, Color.DARK_GRAY),
            new Shape("cabeca", 0, 0, 1, 500, 500, Color.GRAY),
            new Shape("dente1", 100, 350, 1, 100, 200, Color.gray),
            new Shape("dente2", 200, 350, 1, 100, 200, Color.gray),
            new Shape("dente3", 300, 350, 1, 100, 200, Color.gray),
            new Shape("olhoesquerdo", 80, 200, 1, 100, 200, Color.black),
            new Shape("olhodireito", 310, 200, 1, 100, 200, Color.black),
            new Shape("nariz", 220, 350, 1, 50, 100, Color.black),
            new Shape("dedo1", -100, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo2", -150, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo3", -200, 600, 4, 50, 100, Color.GRAY),
            new Shape("dedo4", 600, 350, 4, 50, 100, Color.GRAY),
            new Shape("dedo5", 650, 400, 4, 50, 100, Color.GRAY),
            new Shape("dedo6", 700, 400, 4, 50, 100, Color.GRAY),
            new Shape("dedo7", 550, 500, 3, 100, 50, Color.GRAY),
            new Shape("braco", 650, 420, 0, 50, 500, Color.DARK_GRAY),
            new Shape("mao", 600, 420, 0, 150, 150, Color.DARK_GRAY)
        });
        
        ArrayList<EntityFrame> frames = new ArrayList<>();
        frames.add(frame1);
        frames.add(frame2);
        
        Animation anim = new Animation("LeftArmUp", frames);
        anim.setRunOnce(true);
        
        addAnimation(anim);
        
        anim.SmoothAnimation(60);
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @return the canReceiveDamage
     */
    public boolean isCanReceiveDamage() {
        return canReceiveDamage;
    }

    /**
     * @param canReceiveDamage the canReceiveDamage to set
     */
    public void setCanReceiveDamage(boolean canReceiveDamage) {
        this.canReceiveDamage = canReceiveDamage;
    }
    
}
