/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author AlissonGiron
 */
public class Animation {
    
    private String AnimationName;
    private ArrayList<EntityFrame> Frames;
    private EntityFrame CurrFrame;
    private boolean RunOnce;
    
    public Animation() {
        Frames = new ArrayList<>();
    }
    
    public Animation(String name, ArrayList<EntityFrame> frames)
    {
        Frames = frames;
        AnimationName = name;
    }

    /**
     * @return the AnimationName
     */
    public String getAnimationName() {
        return AnimationName;
    }

    /**
     * @param AnimationName the AnimationName to set
     */
    public void setAnimationName(String AnimationName) {
        this.AnimationName = AnimationName;
    }

    /**
     * @return the Frames
     */
    public ArrayList<EntityFrame> getFrames() {
        return Frames;
    }

    /**
     * @param Frames the Frames to set
     */
    public void setFrames(ArrayList<EntityFrame> Frames) {
        this.Frames = Frames;
    }

    /**
     * @return the CurrFrame
     */
    public EntityFrame getCurrFrame() {
        try {
            return CurrFrame;
        }
        finally {
            int nextIndex = getFrames().indexOf(CurrFrame) + 1;
            
            if(nextIndex >= getFrames().size())
            {
                if(!RunOnce)
                    ResetAnimation();
            }
            else {
                CurrFrame = getFrames().get(nextIndex);
            }
        }
    }

    /**
     * @param CurrFrame the CurrFrame to set
     */
    public void setCurrFrame(EntityFrame CurrFrame) {
        this.CurrFrame = CurrFrame;
    }
    
    public void ResetAnimation() {
        if(getFrames().isEmpty())
        {
            this.setCurrFrame(null);
            return;
        }
        
        this.setCurrFrame(getFrames().get(0));
    }

    public void SmoothAnimation(int numFrames) {
        List<EntityFrame> frames = getFrames();
        int qtdShapes = frames.get(0).getSprite().size();
        Entity parent = getFrames().get(0).getSprite().get(0).getParent();
        
        List<Map<Integer, Shape>> grouped = new ArrayList<>();
        
        frames.get(0).getSprite().forEach((Shape s) -> {
            

            
            Map<Integer, Shape> shapes = new HashMap<>();
            
            shapes.put(0, s);
            String name = s.getName();
            
            for (int i = 1; i < frames.size(); i++) {
                Shape s2 = frames.get(i).getSprite().stream().filter(t -> t.getName().equals(name)).findFirst().orElse(null);
            
                if(s2 == null)
                {
                    s2 = new Shape("vazio", 0, 0, 0, 0, 0, new Color(0,0,0,0));
                }
            
                shapes.put(i, s2);
            }
            
            
            grouped.add(shapes);
        });
        
        
        grouped.forEach((Map<Integer, Shape> g) -> {
            
            int span = (numFrames - 2) / getFrames().size();

            Shape last = g.remove(g.size() - 1);
            Shape first = g.remove(0);
            
            List<Shape> others = new ArrayList<>();
            
            Integer[] keys = new Integer[g.keySet().size()];
            keys = g.keySet().toArray(keys);
            
            for(Integer key: keys)
            {
                others.add(g.remove(key));
            }
            
            g.put(0, first);
            g.put(numFrames - 1, last);

            if(others.isEmpty())
            {
                span = numFrames;
            }
            else if(others.size() == 1)
            {
                g.put(numFrames/2, others.get(0));
                span = numFrames/2;
            }
            else
            {
                for (int i = 0; i < others.size(); i++) {
                    g.put((int) span + (i * span), others.get(i));
                }
            }
            
            Shape currShape = null;
            double deltaX = 0;
            double deltaY = 0;
            double deltaWidth = 0;
            double deltaHeight = 0;
            
            // cores
            double deltaR = 0;
            double deltaG = 0;
            double deltaB = 0;
            double deltaA = 0;
            
            for (int i = 0; i < numFrames; i++) {
                if(g.containsKey(i))
                {
                    currShape = g.get(i);
                    
                    for (int j = i + 1; j < numFrames; j++) {
                        if(g.containsKey(j))
                        {
                            deltaX = (g.get(j).getX() - currShape.getX()) / (double) span;
                            deltaY = (g.get(j).getY() - currShape.getY()) / (double) span;
                            deltaWidth = (g.get(j).getWidth() - currShape.getWidth()) / (double) span;
                            deltaHeight = (g.get(j).getHeight() - currShape.getHeight()) / (double) span;
                            
                            deltaR = (g.get(j).getColor().getRed() - currShape.getColor().getRed()) / (double) span;
                            deltaG = (g.get(j).getColor().getGreen() - currShape.getColor().getGreen()) / (double) span;
                            deltaB = (g.get(j).getColor().getBlue() - currShape.getColor().getBlue()) / (double) span;
                            deltaA = (g.get(j).getColor().getAlpha()- currShape.getColor().getAlpha()) / (double) span;
                            
                            j = numFrames;
                        }
                    }
                    
                    continue;
                }
                
                int red = currShape.getColor().getRed() + (int)(deltaR * i);
                red = adjustColor(red);
                
                int green = currShape.getColor().getGreen() + (int)(deltaG * i);
                green = adjustColor(green);
                
                int blue = currShape.getColor().getBlue() + (int)(deltaB * i);
                blue = adjustColor(blue);
                
                int alpha = currShape.getColor().getAlpha() + (int)(deltaA * i);
                alpha = adjustColor(alpha);
                
                g.put(i, new Shape(currShape.getName(), currShape.getX() + (int)(deltaX * i), 
                                                        currShape.getY() + (int)(deltaY * i), 
                                                        currShape.getZ(), 
                                                        currShape.getWidth() + (int)(deltaWidth * i), 
                                                        currShape.getHeight() + (int)(deltaHeight * i), 
                                                        new Color(red, green, blue, alpha)));
            }
        });
        
        frames.clear();
        
        for (int i = 0; i < numFrames; i++) {
            List<Shape> finalshapes = new ArrayList<>();
            
            for (Map<Integer, Shape> s: grouped) {
                finalshapes.add(s.get(i));
            }

            Shape[] s = new Shape[finalshapes.size()];
            s = finalshapes.toArray(s);
            
            EntityFrame frame = new EntityFrame(parent, s);
            frames.add(frame);
        }
    }
    
    private int adjustColor(int value)
    {
        if(value > 255) return 255;
        
        if(value < 0) return 0;
        
        return value;
    }

    /**
     * @return the RunOnce
     */
    public boolean isRunOnce() {
        return RunOnce;
    }

    /**
     * @param RunOnce the RunOnce to set
     */
    public void setRunOnce(boolean RunOnce) {
        this.RunOnce = RunOnce;
    }
}
