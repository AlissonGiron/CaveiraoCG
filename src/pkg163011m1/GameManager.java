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
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author AlissonGiron
 */
public class GameManager {
    private ArrayList<Entity> SceneEntities;
    private int SceneWidth;
    private int SceneHeight;
    
    public GameManager(int width, int height) {
        SceneEntities = new ArrayList<>();
        setSceneHeight(height);
        setSceneWidth(width);
    }

    /**
     * @return the SceneEntities
     */
    public ArrayList<Entity> getSceneEntities() {
        return SceneEntities;
    }

    /**
     * @param game
     * @param SceneEntities the SceneEntities to set
     */
    public void setSceneEntities(Entity game, ArrayList<Entity> SceneEntities) {
        
        SceneEntities.stream().filter(t -> t.getParent() == null).forEach(o -> o.setParent(game));
        
        this.SceneEntities = SceneEntities;
    }
    
    public void addSceneEntity(Entity entity)
    {
        this.SceneEntities.add(entity);
    }
    
    
    public void removeSceneEntity(String name)
    {
        this.SceneEntities.removeIf(t -> t.getEntityName().equals(name));
    }
    
    private List<Shape> GetAllShapes() {
        List<Shape> CurrShapes = new ArrayList<>();
        
        try {
            getSceneEntities().stream().forEach((Entity e) -> {
                Animation anim = e.getCurrAnimation();

                if(anim == null) return;

                EntityFrame frame = anim.getCurrFrame();

                if(frame == null) return;

                CurrShapes.addAll(frame.getSprite());

                e.Action();
            });
        }
        catch (Exception ex) {
            
        }
        
        return CurrShapes
               .stream()
               .sorted((a, b) -> Integer.compare(a.getZ(), b.getZ()))
               .collect(Collectors.toList());
    }

    public void DrawFrame(Graphics2D g, int vida_Boss, int vida_Player, boolean shakeScreen) {

        GetAllShapes().forEach((Shape shape) -> {
            g.setColor(shape.getColor());
            
            int x = shape.getX() + shape.getParent().getX();
            int y = shape.getY() + shape.getParent().getY();
            int width = shape.getWidth();
            int height = shape.getHeight();
            
            switch(shape.getType())
            {
                case Oval:
                    g.fillOval(x, y, width, height);
                    break;
                case Rectangle:
                    g.fillRect(x, y, width, height);
                    break;
            }
        });
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g.drawString("Caveirão", getSceneWidth() - 200, 100);
        
        int width = getSceneWidth() / 4;
        int percentage = (width*2) / 100;

        g.setColor(Color.RED);
        g.fillRect((2 * width ), 120, percentage * vida_Boss, 10);

        // vidas
        for (int i = 0; i < vida_Player; i++) {
            g.setColor(Color.RED);
            g.fillOval(50 + (i * 70), 100, 50, 50);
            g.setColor(new Color(255, 255, 255, 120));
            g.fillOval(80 + (i * 70), 110, 15, 15);
        }        
        
        if(shakeScreen)
        {
            g.setColor(new Color(255, 0, 0, 60));
            g.fillRect(0, 0, getSceneWidth(), getSceneHeight());
        }
    }

    /**
     * @return the SceneWidth
     */
    public int getSceneWidth() {
        return SceneWidth;
    }

    /**
     * @param SceneWidth the SceneWidth to set
     */
    public void setSceneWidth(int SceneWidth) {
        this.SceneWidth = SceneWidth;
    }

    /**
     * @return the SceneHeight
     */
    public int getSceneHeight() {
        return SceneHeight;
    }

    /**
     * @param SceneHeight the SceneHeight to set
     */
    public void setSceneHeight(int SceneHeight) {
        this.SceneHeight = SceneHeight;
    }
}
