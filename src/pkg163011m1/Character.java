package pkg163011m1;

import Entity.Animation;
import Entity.Entity;
import Entity.EntityFrame;
import Entity.Shape;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author AlissonGiron
 */
public class Character extends Entity {
    private int jumpValue;
    private int direction;
    private int jumps;
    private int chao;
    private int vida;
    private boolean canReceiveDamage;
    
    public Character(int height)
    {
        super("Player", 50, 500);
        
        direction = 0;
        jumps = 2;
        vida = 3;
        
        setColisor(new Rectangle(-20, -100, 200, 200));
        canReceiveDamage = false;
        
        setChao(height);
        
        CreateWalkAnimation();
        CreateIdleAnimation();
        
        setCurrAnimation("Idle");
    }
    
    public void CreateWalkAnimation()
    {
        EntityFrame frame1 = new EntityFrame(this, new Shape[] 
        {
            new Shape("hat", -20, -85, 1, 25, 25, new Color(125,255,189,255)),
            new Shape("leftArm", 15, -25, 1, 15, 15, Color.GRAY),
            new Shape("body", -10, -50, 1, 30, 40, Color.DARK_GRAY),
            new Shape("leftLeg", -7, -15, 1, 10, 15, Color.DARK_GRAY),
            new Shape("rightLeg", 7, -15, 1, 10, 15, Color.DARK_GRAY),
            new Shape("rightArm", -20, -25, 1, 15, 15, Color.GRAY),
            new Shape("head", -20, -80, 1, 50, 50, new Color(255,255,255,180)),
            new Shape("rightEye", 15, -55, 1, 10, 10, Color.WHITE),
            new Shape("leftEye", -5, -55, 1, 10, 10, Color.WHITE),
            new Shape("rightEyeball", 20, -50, 1, 5, 5, Color.DARK_GRAY),
            new Shape("leftEyeball", 0, -50, 1, 5, 5, Color.DARK_GRAY),
            new Shape("nose", 10, -48, 1, 8, 5, Color.DARK_GRAY)
        });
        
        EntityFrame frame2 = new EntityFrame(this, new Shape[] 
        {
            new Shape("hat", -20, -90, 1, 25, 25, new Color(125,255,189,255)),
            new Shape("leftArm", 2, -25, 1, 15, 15, Color.GRAY),
            new Shape("body", -10, -50, 1, 30, 40, Color.DARK_GRAY),
            new Shape("leftLeg", 2, -15, 1, 10, 15, Color.DARK_GRAY),
            new Shape("rightLeg", -2, -15, 1, 10, 15, Color.DARK_GRAY),
            new Shape("rightArm", -2, -25, 1, 15, 15, Color.GRAY),
            new Shape("head", -20, -85, 1, 50, 50, new Color(255,255,255,180)),
            new Shape("rightEye", 15, -65, 1, 10, 10, Color.WHITE),
            new Shape("leftEye", -5, -65, 1, 10, 10, Color.WHITE),
            new Shape("rightEyeball", 20, -60, 1, 5, 5, Color.DARK_GRAY),
            new Shape("leftEyeball", 0, -60, 1, 5, 5, Color.DARK_GRAY),
            new Shape("nose", 10, -58, 1, 8, 5, Color.DARK_GRAY)
        });
        
        EntityFrame frame3 = new EntityFrame(this, new Shape[] 
        {
            new Shape("hat", -20, -85, 1, 25, 25, new Color(125,255,189,255)),
            new Shape("leftArm", 15, -25, 1, 15, 15, Color.GRAY),
            new Shape("body", -10, -50, 1, 30, 40, Color.DARK_GRAY),
            new Shape("leftLeg", -7, -15, 1, 10, 15, Color.DARK_GRAY),
            new Shape("rightLeg", 7, -15, 1, 10, 15, Color.DARK_GRAY),
            new Shape("rightArm", -20, -25, 1, 15, 15, Color.GRAY),
            new Shape("head", -20, -80, 1, 50, 50, new Color(255,255,255,180)),
            new Shape("rightEye", 15, -55, 1, 10, 10, Color.WHITE),
            new Shape("leftEye", -5, -55, 1, 10, 10, Color.WHITE),
            new Shape("rightEyeball", 20, -50, 1, 5, 5, Color.DARK_GRAY),
            new Shape("leftEyeball", 0, -50, 1, 5, 5, Color.DARK_GRAY),
            new Shape("nose", 10, -48, 1, 8, 5, Color.DARK_GRAY)
        });
        
        ArrayList<EntityFrame> frames = new ArrayList<>();
        frames.add(frame1);
        frames.add(frame2);
        frames.add(frame3);
        
        Animation idle = new Animation("Walk", frames);
        
        addAnimation(idle);
        
        idle.SmoothAnimation(20);
    }
    
    public void CreateIdleAnimation()
    {
        EntityFrame frame1 = new EntityFrame(this, new Shape[] 
        {
            new Shape("hat", -20, -85, 1, 25, 25, new Color(125,255,189,255)),
            new Shape("leftArm", 15, -25, 1, 15, 15, Color.GRAY),
            new Shape("body", -10, -50, 1, 30, 40, Color.DARK_GRAY),
            new Shape("leftLeg", -7, -15, 1, 10, 15, Color.DARK_GRAY),
            new Shape("rightLeg", 7, -15, 1, 10, 15, Color.DARK_GRAY),
            new Shape("rightArm", -20, -25, 1, 15, 15, Color.GRAY),
            new Shape("head", -20, -80, 1, 50, 50, new Color(255,255,255,180)),
            new Shape("rightEye", 15, -55, 1, 10, 10, Color.WHITE),
            new Shape("leftEye", -5, -55, 1, 10, 10, Color.WHITE),
            new Shape("rightEyeball", 20, -50, 1, 5, 5, Color.DARK_GRAY),
            new Shape("leftEyeball", 0, -50, 1, 5, 5, Color.DARK_GRAY),
            new Shape("nose", 10, -48, 1, 8, 5, Color.DARK_GRAY)
        });
        
        EntityFrame frame2 = new EntityFrame(this, new Shape[] 
        {
            new Shape("hat", -20, -95, 1, 25, 25, new Color(125,255,189,255)),
            new Shape("leftArm", 20, -25, 1, 15, 15, Color.GRAY),
            new Shape("body", -15, -60, 1, 40, 45, Color.DARK_GRAY),
            new Shape("leftLeg", -7, -15, 1, 10, 15, Color.DARK_GRAY),
            new Shape("rightLeg", 7, -15, 1, 10, 15, Color.DARK_GRAY),
            new Shape("rightArm", -25, -25, 1, 15, 15, Color.GRAY),
            new Shape("head", -20, -90, 1, 50, 50, new Color(255,255,255,180)),
            new Shape("rightEye", 15, -65, 1, 10, 10, Color.WHITE),
            new Shape("leftEye", -5, -65, 1, 10, 10, Color.WHITE),
            new Shape("rightEyeball", 20, -60, 1, 5, 5, Color.DARK_GRAY),
            new Shape("leftEyeball", 0, -60, 1, 5, 5, Color.DARK_GRAY),
            new Shape("nose", 10, -58, 1, 8, 5, Color.DARK_GRAY)
        });
        
        EntityFrame frame3 = new EntityFrame(this, new Shape[] 
        {
            new Shape("hat", -20, -85, 1, 25, 25, new Color(125,255,189,255)),
            new Shape("leftArm", 15, -25, 1, 15, 15, Color.GRAY),
            new Shape("body", -10, -50, 1, 30, 40, Color.DARK_GRAY),
            new Shape("leftLeg", -7, -15, 1, 10, 15, Color.DARK_GRAY),
            new Shape("rightLeg", 7, -15, 1, 10, 15, Color.DARK_GRAY),
            new Shape("rightArm", -20, -25, 1, 15, 15, Color.GRAY),
            new Shape("head", -20, -80, 1, 50, 50, new Color(255,255,255,180)),
            new Shape("rightEye", 15, -55, 1, 10, 10, Color.WHITE),
            new Shape("leftEye", -5, -55, 1, 10, 10, Color.WHITE),
            new Shape("rightEyeball", 20, -50, 1, 5, 5, Color.DARK_GRAY),
            new Shape("leftEyeball", 0, -50, 1, 5, 5, Color.DARK_GRAY),
            new Shape("nose", 10, -48, 1, 8, 5, Color.DARK_GRAY)
        });
        
        ArrayList<EntityFrame> frames = new ArrayList<>();
        frames.add(frame1);
        frames.add(frame2);
        frames.add(frame3);
        
        Animation idle = new Animation("Idle", frames);
        
        addAnimation(idle);
        
        idle.SmoothAnimation(30);
    }
    
    
    @Override
    public void Action() {
        if(getDirection() == 0)
        {
            setCurrAnimation("Idle");
        }
        else 
        {
            setCurrAnimation("Walk");
        }
        
        setColisor(new Rectangle(getX() - 25, getY() - 90, 60, 100));
        
        Move();
        Gravity();
        checkJump();
    }
    
    public void damagePlayer()
    {
        setVida(getVida() - 1);
        setCanReceiveDamage(false);
    }
    
    public void Move()
    {
        setX(getX() + getDirection() * 5);
    }
        
    public void Gravity() {
        if(getY() <= getChao() - 10)
        {
            setY(getY() + 10);
        }
        else if(getY() < getChao())
        {
            setY(getY() + 1);
        }
    }

    void checkJump() {
        if(getJumpValue() > 0)
        {
            setY(getY() - 20);
            setJumpValue(getJumpValue() - 20);
        }
    }
    
    void setJump(int delta)
    {
        setJumpValue(delta);
    }

    /**
     * @return the jumpValue
     */
    public int getJumpValue() {
        return jumpValue;
    }

    /**
     * @param jumpValue the jumpValue to set
     */
    public void setJumpValue(int jumpValue) {
        this.jumpValue = jumpValue;
    }

    /**
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * @return the jumps
     */
    public int getJumps() {
        return jumps;
    }

    /**
     * @param jumps the jumps to set
     */
    public void setJumps(int jumps) {
        this.jumps = jumps;
    }

    /**
     * @return the chao
     */
    public int getChao() {
        return chao;
    }

    /**
     * @param chao the chao to set
     */
    public void setChao(int chao) {
        this.chao = chao;
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
