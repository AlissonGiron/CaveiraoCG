/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.awt.Color;

/**
 *
 * @author AlissonGiron
 */
public class Shape {
    
    private Entity parent;
    
    private int x;
    private int y;
    private int z;
    private Color color;
    private String name;
    
    private int width;
    private int height;
    
    private ShapeType type;

    public Shape(String name, int x, int y, int z, int width, int height, Color color, ShapeType type) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.height = height;
        this.color = color;
        this.type = type;
    }
    
    public Shape(String name, int x, int y, int z, int width, int height, Color color) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.height = height;
        this.color = color;
        this.type = ShapeType.Oval;
    }    
    
    /**
     * @return the x
     */
    public int getX() {
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
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
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
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the z
     */
    public int getZ() {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(int z) {
        this.z = z;
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
     * @return the type
     */
    public ShapeType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ShapeType type) {
        this.type = type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
