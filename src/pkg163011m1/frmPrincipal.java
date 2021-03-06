/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg163011m1;

import Entity.Entity;
import Entity.Shape;
import Entity.ShapeType;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


/**
 *
 * @author AlissonGiron
 */
public class frmPrincipal extends javax.swing.JFrame implements Runnable {
    
    Character c;
    Boss b;
    GameManager manager;
    Entity game;
    Graphics2D g;
    
    int qtdTiros = 0;
    private int lastDirection = 1;
    
    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
        initComponents();
        
        createBufferStrategy(2);
        Thread t = new Thread(this);
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_LEFT)
        {
            c.setDirection(-1);
            lastDirection = -1;
        }
        else if(evt.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            c.setDirection(1);
            lastDirection = 1;
        }
        else 
        {
            c.setDirection(0);
        }
        
        if(evt.getKeyCode() == KeyEvent.VK_SPACE)
        {
            c.setJump(300);
        }
        
        if(evt.getKeyCode() == KeyEvent.VK_V)
        {
            qtdTiros++;
            manager.addSceneEntity(new Projectile("tiro" + qtdTiros, c.getX(), c.getY() - 20, lastDirection));
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
        c.setDirection(0);
    }//GEN-LAST:event_formKeyReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:        
    }//GEN-LAST:event_formMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame = new frmPrincipal();
            
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        });
    }
    
    @Override
    public void run()
    {   
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConfigureGame();
        
        while(true)     
        {
            g = (Graphics2D) getBufferStrategy().getDrawGraphics();        
            g.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
            
            // pinta o fundo
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            
            UpdateScreen(g);
            
            getBufferStrategy().show();
            g.dispose();
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void ConfigureGame()
    {
        manager = new GameManager(getWidth(), getHeight());

        // instancia um objeto "pai" para todos os objetos em cena, para poder fazer o efeito de tremer a tela 
        game = new Entity("game", 0, 0); 
        c = new Character(getHeight() - 50);
        b = new Boss(getWidth(), getHeight());
        
        GameLogic gm = new GameLogic(game, manager, b, c, getHeight(), getWidth());

        Background background = new Background("Background", 0, 0, getWidth(), getHeight());
        
        Entity chao = new Entity("Floor", 0, getHeight() - 50);
        chao.setDefaultSprite(new Shape("floor", 0, 0, 3, getWidth(), 50, new Color(92, 56, 38, 255), ShapeType.Rectangle));
        
        ArrayList<Entity> entities = new ArrayList<>();
        
        // adiciona o boss no jogo
        entities.add(b);
        
        // adiciona o chao do jogo
        entities.add(chao);
        
        // adiciona as entidades dos olhos do boss
        entities.addAll(b.getEyes());
        
        // adiciona o jogador
        entities.add(c);
        
        // adiciona o fundo
        entities.add(background);
        
        // coloca as entidades em cena
        manager.setSceneEntities(game, entities);
    }
    
    private void LoseGame(Graphics2D g)
    {
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 200));
        g.drawString("GAME OVER", 100, 400);
    }
    
    private void WinGame(Graphics2D g)
    {
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 200));
        g.drawString("VENCEU!", 200, 400);
    }
    
    private void CheckColisions()
    {
        try {
            // verificar se o boss levou dano
            manager.getSceneEntities().stream().filter(t -> t != null && t.getEntityName().startsWith("tiro")).forEach(o -> {
                //g.drawRect(o.getColisor().x, o.getColisor().y, o.getColisor().width, o.getColisor().height);
                //g.drawRect(b.getColisor().x, b.getColisor().y, b.getColisor().width, b.getColisor().height);

                o.setColisor(new Rectangle(o.getX(), o.getY() - 30, 50, 50));

                if(b.getColisor().intersects(o.getColisor()))
                {
                    b.setCanReceiveDamage(true);
                    manager.removeSceneEntity(o.getEntityName());
                }
            });

            // verifica se inimigo atacou jogador
            manager.getSceneEntities().stream().filter(t -> t != null && t.getEntityName().startsWith("enemy")).forEach(o -> {
                o.setColisor(new Rectangle(o.getX() - 30, o.getY() - 90, 80, 100));

                if(c.getColisor().intersects(o.getColisor()))
                {
                    c.setCanReceiveDamage(true);
                }
            });

            Object[] entidades = manager.getSceneEntities().stream().filter(t -> t != null && t.getEntityName().startsWith("enemy")).toArray(); 

            // verifica se inimigo levou ataque do jogador
            for (int i = 0; i < entidades.length; i++) 
            {   
                if(entidades[i] == null) return;

                Entity entity = (Entity) entidades[i];

                entity.setColisor(new Rectangle(entity.getX() - 30, entity.getY() - 90, 80, 100));

                manager.getSceneEntities().stream().filter(t -> t != null && t.getEntityName().startsWith("tiro")).forEach(t -> {
                    t.setColisor(new Rectangle(t.getX(), t.getY() - 30, 50, 50));

                    if(entity.getColisor().intersects(t.getColisor()))
                    {
                        manager.removeSceneEntity(entity.getEntityName());
                        manager.removeSceneEntity(t.getEntityName());
                    }
                });
            }
        }
        catch(java.util.ConcurrentModificationException ex)
        {}
    }
    
    private void DrawFrame(Graphics2D g)
    {
        b.moveEyes(getWidth(), getHeight() - 50, c.getX(), c.getY());

        CheckColisions();

        manager.DrawFrame(g, b.getVida(), c.getVida(), c.isCanReceiveDamage());
    }
    
    private void UpdateScreen(Graphics2D g)
    {
        if(b.getVida() <= 0)
        {
            WinGame(g);
            return;
        }
            
        if(c.getVida() <= 0)
        {
            LoseGame(g);
            return;
        }
        
        DrawFrame(g);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
