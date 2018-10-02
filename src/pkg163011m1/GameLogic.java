/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg163011m1;

import Entity.Entity;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlissonGiron
 */
public class GameLogic {
    
    private int qtdEnemies;
    private GameManager manager;
    private Boss b;
    private Character c;
    private Entity parent;
    
    private int height;
    private int width;
    
    public GameLogic(Entity parent, GameManager gm, Boss boss, Character ch, int height, int width)
    {
        manager = gm;
        b = boss;
        c = ch;
        this.parent = parent;
        setHeight(height);
        setWidth(width);
        
        StartThreads();
    }
    
    private void StartThreads()
    {
        Thread t_Boss = new Thread(new Runnable() {
            @Override
            public void run() {
                ControlBoss();
            }
        });
        
        Thread t_spawnEnemies = new Thread(new Runnable() {
            @Override
            public void run() {
                SpawnEnemy();
            }
        });
        
        Thread t_damageAlert = new Thread(new Runnable() {
            @Override
            public void run() {
                damageAlert();
            }
        });

        Thread t_damageBoss = new Thread(new Runnable() {
            @Override
            public void run() {
                damageBoss();
            }
        });
        
        t_damageBoss.start();
        t_Boss.start();
        t_spawnEnemies.start();
        t_damageAlert.start();
    }
    
    public void SpawnEnemy()
    {
        setQtdEnemies(getQtdEnemies() + 1);
        getManager().addSceneEntity(new Enemy("enemy" + getQtdEnemies(), -100, getHeight() - 50));
        
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SpawnEnemy();
    }
    
    public void damageAlert()
    {
        try 
        {
            if(getC().isCanReceiveDamage())
            {
                getC().damagePlayer();
                
                for (int i = 10; i > 0; i--) {
                    parent.setX(i);
                    parent.setY(-i);

                    Thread.sleep(10);

                    parent.setY(i);
                    parent.setX(-i);
                }
            
                parent.setX(0);
                parent.setY(0);
                
                getC().setCanReceiveDamage(false);
            }
            
            Thread.sleep(100);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        damageAlert();
    }
    
    
    private void damageBoss() {
        if(b.isCanReceiveDamage())
        {
            b.damageBoss();
            b.setCanReceiveDamage(false);
        }
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        damageBoss();
    }
    
    public void ControlBoss() 
    {
        try {
            getB().setCurrAnimation("LeftArmUp");
            Thread.sleep(1000);
            getB().getCurrAnimation().ResetAnimation();
            
            getB().setCurrAnimation("LeftArmDown");
            Thread.sleep(1000);
            getB().getCurrAnimation().ResetAnimation();

            getB().setCurrAnimation("RightArmUp");
            Thread.sleep(1000);
            getB().getCurrAnimation().ResetAnimation();

            getB().setCurrAnimation("RightArmDown");
            Thread.sleep(1000);
            getB().getCurrAnimation().ResetAnimation();
            
            ControlBoss();
        } catch (InterruptedException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the qtdEnemies
     */
    public int getQtdEnemies() {
        return qtdEnemies;
    }

    /**
     * @param qtdEnemies the qtdEnemies to set
     */
    public void setQtdEnemies(int qtdEnemies) {
        this.qtdEnemies = qtdEnemies;
    }

    /**
     * @return the manager
     */
    public GameManager getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(GameManager manager) {
        this.manager = manager;
    }

    /**
     * @return the b
     */
    public Boss getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(Boss b) {
        this.b = b;
    }

    /**
     * @return the c
     */
    public Character getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Character c) {
        this.c = c;
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
    
}
