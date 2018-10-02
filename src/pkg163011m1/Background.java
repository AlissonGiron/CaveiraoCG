/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg163011m1;

import Entity.Entity;
import Entity.EntityFrame;
import Entity.Shape;
import Entity.ShapeType;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author AlissonGiron
 */
public class Background extends Entity {
    
    private int height;
    private int width;
    
    public Background(String name, int x, int y, int width, int height) {
        super(name, x, y);
        
        this.height = height;
        this.width = width;
        
        createBackground();
    }
    
    private void createBackground()
    {
        Color c = new Color(192, 192, 192, 30);
        Color gray = new Color(192, 192, 192, 30);
        Color orange = new Color(255, 165, 0, 150);
        Color white = new Color(255, 255, 255, 150);
        Color lightGray = new Color(220, 220, 220, 30);
        
        EntityFrame b = new EntityFrame(this, new Shape[] 
        {
            new Shape("torre", 100, 400, -100, 20, height, c, ShapeType.Rectangle),
            new Shape("torre", 140, 400, -100, 20, height, c, ShapeType.Rectangle),
            new Shape("torre", 180, 400, -100, 20, height, c, ShapeType.Rectangle),
            new Shape("torre", 80, 360, -100, 140, 20, c, ShapeType.Rectangle),
            new Shape("torre", 80, 320, -100, 140, 20, c, ShapeType.Rectangle),
            new Shape("torre", 80, 280, -100, 140, 20, c, ShapeType.Rectangle),
            new Shape("torre", 100, 0, -100, 20, 260, c, ShapeType.Rectangle),
            new Shape("torre", 140, 0, -100, 20, 260, c, ShapeType.Rectangle),
            new Shape("torre", 180, 0, -100, 20, 260, c, ShapeType.Rectangle),
            
            new Shape("torre", 1100, 400, -100, 20, height, c, ShapeType.Rectangle),
            new Shape("torre", 1140, 400, -100, 20, height, c, ShapeType.Rectangle),
            new Shape("torre", 1180, 400, -100, 20, height, c, ShapeType.Rectangle),
            new Shape("torre", 1080, 360, -100, 140, 20, c, ShapeType.Rectangle),
            new Shape("torre", 1080, 320, -100, 140, 20, c, ShapeType.Rectangle),
            new Shape("torre", 1080, 280, -100, 140, 20, c, ShapeType.Rectangle),
            new Shape("torre", 1100, 0, -100, 20, 260, c, ShapeType.Rectangle),
            new Shape("torre", 1140, 0, -100, 20, 260, c, ShapeType.Rectangle),
            new Shape("torre", 1180, 0, -100, 20, 260, c, ShapeType.Rectangle),
            
            new Shape("vela", 1000, 500, -100, 10, 50, white, ShapeType.Rectangle),
            new Shape("vela", 1000, 480, -100, 10, 20, orange),
            new Shape("vela", 1010, 470, -100, 10, 10, gray),
            new Shape("vela", 1005, 440, -100, 10, 10, gray),
            new Shape("vela", 990, 450, -100, 20, 20, gray),
            
            new Shape("vela", 250, 450, -100, 10, 50, white, ShapeType.Rectangle),
            new Shape("vela", 250, 430, -100, 10, 20, orange),
            new Shape("vela", 260, 420, -100, 10, 10, gray),
            new Shape("vela", 255, 390, -100, 10, 10, gray),
            new Shape("vela", 240, 400, -100, 20, 20, gray),
            
            new Shape("vela", 195, 0, -100, 5, 260, lightGray, ShapeType.Rectangle),
            new Shape("vela", 155, 0, -100, 5, 260, lightGray, ShapeType.Rectangle),
            new Shape("vela", 115, 0, -100, 5, 260, lightGray, ShapeType.Rectangle),
            new Shape("vela", 195, 400, -100, 5, height, lightGray, ShapeType.Rectangle),
            new Shape("vela", 155, 400, -100, 5, height, lightGray, ShapeType.Rectangle),
            new Shape("vela", 115, 400, -100, 5, height, lightGray, ShapeType.Rectangle),
            
            new Shape("vela", 1115, 0, -100, 5, 260, lightGray, ShapeType.Rectangle),
            new Shape("vela", 1155, 0, -100, 5, 260, lightGray, ShapeType.Rectangle),
            new Shape("vela", 1195, 0, -100, 5, 260, lightGray, ShapeType.Rectangle),
            
            new Shape("vela", 1115, 400, -100, 5, height, lightGray, ShapeType.Rectangle),
            new Shape("vela", 1155, 400, -100, 5, height, lightGray, ShapeType.Rectangle),
            new Shape("vela", 1195, 400, -100, 5, height, lightGray, ShapeType.Rectangle),
            
            new Shape("vela", 1205, 280, -100, 5, 20, lightGray, ShapeType.Rectangle),
            new Shape("vela", 1205, 320, -100, 5, 20, lightGray, ShapeType.Rectangle),
            new Shape("vela", 1205, 360, -100, 5, 20, lightGray, ShapeType.Rectangle),
            
            new Shape("vela", 1215, 280, -100, 5, 20, lightGray, ShapeType.Rectangle),
            new Shape("vela", 1215, 320, -100, 5, 20, lightGray, ShapeType.Rectangle),
            new Shape("vela", 1215, 360, -100, 5, 20, lightGray, ShapeType.Rectangle),
            
            new Shape("vela", 205, 280, -100, 5, 20, lightGray, ShapeType.Rectangle),
            new Shape("vela", 205, 320, -100, 5, 20, lightGray, ShapeType.Rectangle),
            new Shape("vela", 205, 360, -100, 5, 20, lightGray, ShapeType.Rectangle),
            
            new Shape("vela", 215, 280, -100, 5, 20, lightGray, ShapeType.Rectangle),
            new Shape("vela", 215, 320, -100, 5, 20, lightGray, ShapeType.Rectangle),
            new Shape("vela", 215, 360, -100, 5, 20, lightGray, ShapeType.Rectangle),
        });
        
        setDefaultSprite(b.getSprite());
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
    
}
