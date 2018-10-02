/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author AlissonGiron
 */
public class Entity {

    private String EntityName;

    private Entity parent;
    private int x;
    private int y;
    private int width;
    private int height;
    
    private Rectangle colisor;
    
    private ArrayList<Animation> Animations;
    private Animation CurrAnimation;
    
    public Entity(String name, int x, int y) {
        this.EntityName = name;
        this.x = x;
        this.y = y;
        Animations = new ArrayList<>();
        colisor = new Rectangle(x, y, width, height);
    }

    /**
     * @return the x
     */
    public int getX() {
        if(getParent() != null) return getParent().getX() + x;
        
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        if(getParent() != null) return getParent().getY() + y;
        
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the Animations
     */
    public ArrayList<Animation> getAnimations() {
        return Animations;
    }

    public void addAnimation(Animation animation)
    {
        animation.getFrames().forEach(f -> {
            f.getSprite().forEach(s -> s.setParent(this));
        });
        
        this.getAnimations().add(animation);
    }
    
    public void setDefaultSprite(ArrayList<Shape> Sprite)
    {
        Sprite.forEach(s -> s.setParent(this));
        
        EntityFrame frame = new EntityFrame();
        frame.setSprite(Sprite);
        
        this.getAnimations().removeIf(t -> t.getAnimationName().equals("Default"));
        
        Animation anim = new Animation("Default", new ArrayList<>(Collections.singletonList(frame)));
        this.getAnimations().add(anim);
    }
    
    public void setDefaultSprite(Shape Shape)
    {
        Shape.setParent(this);
        ArrayList<Shape> Sprite = new ArrayList<>(Collections.singletonList(Shape));
        
        EntityFrame frame = new EntityFrame();
        frame.setSprite(Sprite);
        
        this.getAnimations().removeIf(t -> t.getAnimationName().equals("Default"));
        
        Animation anim = new Animation("Default", new ArrayList<>(Collections.singletonList(frame)));
        this.getAnimations().add(anim);
    }
    
    
    public void removeAnimation(String name)
    {
        this.getAnimations().removeIf(t -> t.getAnimationName().equals(name));
    }
    
    public void addFrameToAnimation(String AnimationName, EntityFrame frame)
    {
        frame.getSprite().forEach(s -> s.setParent(this));
        
        Animation anim = this.getAnimations().stream().filter(t -> t.getAnimationName().equals(AnimationName)).findFirst().orElse(null);
    
        if(anim == null) return;
        
        anim.getFrames().add(frame);
    }

    /**
     * @return the CurrAnimation
     */
    public Animation getCurrAnimation() {
        
        if(!getAnimations().isEmpty() && CurrAnimation == null)
        {
            CurrAnimation = getAnimations().get(0);
        }
        
        return CurrAnimation;
    }
    
    public void Action() {}

    /**
     * @param name nome da animação
     */
    public void setCurrAnimation(String name) {
        if(getAnimations().isEmpty()) 
        {
            this.CurrAnimation = null;
            return;
        }
        
        this.CurrAnimation = getAnimations()
                .stream()
                .filter(t -> t.getAnimationName().equals(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * @return the EntityName
     */
    public String getEntityName() {
        return EntityName;
    }

    /**
     * @param EntityName the EntityName to set
     */
    public void setEntityName(String EntityName) {
        this.EntityName = EntityName;
    }

    /**
     * @return the parent
     */
    public Entity getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Entity parent) {
        this.parent = parent;
    }

    /**
     * @param Animations the Animations to set
     */
    public void setAnimations(ArrayList<Animation> Animations) {
        this.Animations = Animations;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the colisor
     */
    public Rectangle getColisor() {
        return colisor;
    }

    /**
     * @param colisor the colisor to set
     */
    public void setColisor(Rectangle colisor) {
        this.colisor = colisor;
    }
}
