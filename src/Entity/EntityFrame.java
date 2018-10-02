/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author AlissonGiron
 */
public class EntityFrame {
    private ArrayList<Shape> Sprite;
    
    public EntityFrame() {
        Sprite = new ArrayList<>();
    }
    
    public EntityFrame(Entity parent, Shape[] shapes) {
        Sprite = new ArrayList<>();
        
        for (Shape s : shapes) {
            s.setParent(parent);
            Sprite.add(s);
        }
    }

    /**
     * @return the Sprite
     */
    public ArrayList<Shape> getSprite() {
        return Sprite;
    }

    /**
     * @param Sprite the Sprite to set
     */
    public void setSprite(ArrayList<Shape> Sprite) {
        this.Sprite = Sprite;
    }
}
