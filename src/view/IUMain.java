/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.PgmImage;

/**
 *
 * @author wlima
 */
public class IUMain extends javax.swing.JFrame {
    PgmImage img;
    /**
     * Creates new form IUMain
     */
    public IUMain() {
        initComponents();
        
        menuDisable();
    }
    
    // Disable item menu
    public void menuDisable() {
        menuNegative.setEnabled(false);
        menuDarkenI.setEnabled(false);
        menuDarkenII.setEnabled(false);
        menuItemAdd.setEnabled(false);
        menuItemMult.setEnabled(false);
        menuItemRight.setEnabled(false);
        menuItemLeft.setEnabled(false);
        menuItemHorizontal.setEnabled(false);
        menuItemVertical.setEnabled(false);
        menuItembinary.setEnabled(false);
        menuItemHighLight1.setEnabled(false);
        menuItemHighLight2.setEnabled(false);
        menuItemSub1.setEnabled(false);
        menuItemSubtraction2.setEnabled(false);
        MenuItemTransform.setEnabled(false);
        menuItemZoom.setEnabled(false);
        menuItemZoomOut.setEnabled(false);
        menuItemSave.setEnabled(false);
        _16.setEnabled(false);
        _8.setEnabled(false);
        _4.setEnabled(false);
        _2.setEnabled(false);
    }
    
    // Enable item menu
    public void menuEnable() {
        menuNegative.setEnabled(true);
        menuDarkenI.setEnabled(true);
        menuDarkenII.setEnabled(true);
        menuItemAdd.setEnabled(true);
        menuItemMult.setEnabled(true);
        menuItemRight.setEnabled(true);
        menuItemLeft.setEnabled(true);
        menuItemHorizontal.setEnabled(true);
        menuItemVertical.setEnabled(true);
        menuItembinary.setEnabled(true);
        menuItemHighLight1.setEnabled(true);
        menuItemHighLight2.setEnabled(true);
        menuItemSub1.setEnabled(true);
        menuItemSubtraction2.setEnabled(true);
        MenuItemTransform.setEnabled(true);
        menuItemZoom.setEnabled(true);
        menuItemZoomOut.setEnabled(true);
        menuItemSave.setEnabled(true);
        _16.setEnabled(true);
        _8.setEnabled(true);
        _4.setEnabled(true);
        _2.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuOpen = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuNegative = new javax.swing.JMenuItem();
        menuDarkenI = new javax.swing.JMenuItem();
        menuDarkenII = new javax.swing.JMenuItem();
        menuLighten = new javax.swing.JMenu();
        menuItemAdd = new javax.swing.JMenuItem();
        menuItemMult = new javax.swing.JMenuItem();
        menuRotate = new javax.swing.JMenu();
        menuItemRight = new javax.swing.JMenuItem();
        menuItemLeft = new javax.swing.JMenuItem();
        menuItemHorizontal = new javax.swing.JMenuItem();
        menuItemVertical = new javax.swing.JMenuItem();
        menuBinary = new javax.swing.JMenu();
        menuItembinary = new javax.swing.JMenuItem();
        menuReduction = new javax.swing.JMenu();
        _16 = new javax.swing.JMenuItem();
        _8 = new javax.swing.JMenuItem();
        _4 = new javax.swing.JMenuItem();
        _2 = new javax.swing.JMenuItem();
        menuHighlight = new javax.swing.JMenu();
        menuItemHighLight1 = new javax.swing.JMenuItem();
        menuItemHighLight2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuItemSub1 = new javax.swing.JMenuItem();
        menuItemSubtraction2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        MenuItemTransform = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuItemZoom = new javax.swing.JMenuItem();
        menuItemZoomOut = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menuItemSave = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        menuOpen.setText("Open");
        menuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpenActionPerformed(evt);
            }
        });
        jMenu1.add(menuOpen);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("to Darken");

        menuNegative.setText("Negative");
        menuNegative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNegativeActionPerformed(evt);
            }
        });
        jMenu2.add(menuNegative);

        menuDarkenI.setText("by value");
        menuDarkenI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDarkenIActionPerformed(evt);
            }
        });
        jMenu2.add(menuDarkenI);

        menuDarkenII.setText("by division");
        menuDarkenII.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDarkenIIActionPerformed(evt);
            }
        });
        jMenu2.add(menuDarkenII);

        jMenuBar1.add(jMenu2);

        menuLighten.setText("to Lighten");

        menuItemAdd.setText("add value");
        menuItemAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAddActionPerformed(evt);
            }
        });
        menuLighten.add(menuItemAdd);

        menuItemMult.setText("multiply floating point");
        menuItemMult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMultActionPerformed(evt);
            }
        });
        menuLighten.add(menuItemMult);

        jMenuBar1.add(menuLighten);

        menuRotate.setText("to Rotate");

        menuItemRight.setText("right (90º)");
        menuItemRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRightActionPerformed(evt);
            }
        });
        menuRotate.add(menuItemRight);

        menuItemLeft.setText("left (-90º)");
        menuItemLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLeftActionPerformed(evt);
            }
        });
        menuRotate.add(menuItemLeft);

        menuItemHorizontal.setText("horizontal (180º)");
        menuItemHorizontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemHorizontalActionPerformed(evt);
            }
        });
        menuRotate.add(menuItemHorizontal);

        menuItemVertical.setText("vertical (180º)");
        menuItemVertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVerticalActionPerformed(evt);
            }
        });
        menuRotate.add(menuItemVertical);

        jMenuBar1.add(menuRotate);

        menuBinary.setText("to Binary");
        menuBinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBinaryActionPerformed(evt);
            }
        });

        menuItembinary.setText("binarization");
        menuItembinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItembinaryActionPerformed(evt);
            }
        });
        menuBinary.add(menuItembinary);

        jMenuBar1.add(menuBinary);

        menuReduction.setText("Reduction");

        _16.setText("16");
        _16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _16ActionPerformed(evt);
            }
        });
        menuReduction.add(_16);

        _8.setText("8");
        _8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _8ActionPerformed(evt);
            }
        });
        menuReduction.add(_8);

        _4.setText("4");
        _4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _4ActionPerformed(evt);
            }
        });
        menuReduction.add(_4);

        _2.setText("2");
        _2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _2ActionPerformed(evt);
            }
        });
        menuReduction.add(_2);

        jMenuBar1.add(menuReduction);

        menuHighlight.setText("Highlight");

        menuItemHighLight1.setText("option 1");
        menuItemHighLight1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemHighLight1ActionPerformed(evt);
            }
        });
        menuHighlight.add(menuItemHighLight1);

        menuItemHighLight2.setText("option 2");
        menuItemHighLight2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemHighLight2ActionPerformed(evt);
            }
        });
        menuHighlight.add(menuItemHighLight2);

        jMenuBar1.add(menuHighlight);

        jMenu3.setText("to Subtract");

        menuItemSub1.setText("Subtraction 1");
        menuItemSub1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSub1ActionPerformed(evt);
            }
        });
        jMenu3.add(menuItemSub1);

        menuItemSubtraction2.setText("Subtraction 2");
        menuItemSubtraction2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSubtraction2ActionPerformed(evt);
            }
        });
        jMenu3.add(menuItemSubtraction2);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("to Power");

        MenuItemTransform.setText("transform ^ power");
        MenuItemTransform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemTransformActionPerformed(evt);
            }
        });
        jMenu4.add(MenuItemTransform);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("to Zoom");

        menuItemZoom.setText("Zoom-In");
        menuItemZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemZoomActionPerformed(evt);
            }
        });
        jMenu5.add(menuItemZoom);

        menuItemZoomOut.setText("Zoom-Out");
        menuItemZoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemZoomOutActionPerformed(evt);
            }
        });
        jMenu5.add(menuItemZoomOut);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Histogram");

        menuItemSave.setText("Save");
        jMenu6.add(menuItemSave);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 763, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpenActionPerformed
        String filename = "";
        FileInputStream f;
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PNG & PGM Images", "png", "pgm");
        chooser.setFileFilter(filter);
        
        int returnVal = chooser.showOpenDialog(null);
        
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            filename = chooser.getSelectedFile().getAbsolutePath();
            System.out.println("You chose to open this file: " +
                    filename);
            
            menuEnable();
            img = new PgmImage(filename);
            JOptionPane.showMessageDialog(null, "Imagem Aberta com Sucesso !\n");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao abrir a imagem !\n");
        }
        
       
    }//GEN-LAST:event_menuOpenActionPerformed

    private void menuNegativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNegativeActionPerformed
        try {
            img.convertToNegative();
            JOptionPane.showMessageDialog(null, "A imagem foi convertida para o negativo com sucesso !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuNegativeActionPerformed

    private void menuDarkenIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDarkenIActionPerformed
        int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para escurecer !\n"));
        try {
            img.convertToDarkenI(valor);
            JOptionPane.showMessageDialog(null, "A imagem foi escurecida sub o valor com sucesso !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuDarkenIActionPerformed

    private void menuDarkenIIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDarkenIIActionPerformed
        int value = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para escurecer !\n"));
        try {
            img.convertToDarkenII(value);
            JOptionPane.showMessageDialog(null, "A imagem foi escurecida através da div do valor com sucesso !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuDarkenIIActionPerformed

    private void menuItemAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAddActionPerformed
        int value = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para clarear !\n"));
        try {
            img.convertToLightenByAddValue(value);
            JOptionPane.showMessageDialog(null, "A imagem foi clareada com sucesso !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemAddActionPerformed

    private void menuItemMultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMultActionPerformed
        int value = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para clarear !\n"));
        try {
            img.convertToLightenByMultValue(value);
            JOptionPane.showMessageDialog(null, "A imagem foi clareada com sucesso !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemMultActionPerformed

    private void menuItemRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRightActionPerformed
        try {
            img.rotateRight();
            JOptionPane.showMessageDialog(null, "A imagem foi rotacionada para direita com sucesso (90º) !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemRightActionPerformed

    private void menuItemLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLeftActionPerformed
        try {
            img.rotateLeft();
            JOptionPane.showMessageDialog(null, "A imagem foi rotacionada para esquerda com sucesso (-90º) !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemLeftActionPerformed

    private void menuItemHorizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemHorizontalActionPerformed
        try {
            img.rotateHorizontal();
            JOptionPane.showMessageDialog(null, "A imagem foi rotacionada para horizontalmente com sucesso (180º) !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemHorizontalActionPerformed

    private void menuBinaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBinaryActionPerformed
        
    }//GEN-LAST:event_menuBinaryActionPerformed
    
    // Reduction to 16 bits
    private void _16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__16ActionPerformed
        try {
            img.reduction(16);
            JOptionPane.showMessageDialog(null, "A imagem foi reduzida (16 bits) com sucesso !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event__16ActionPerformed

    // Reduction to 8 bits
    private void _8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__8ActionPerformed
       try {
            img.reduction(8);
            JOptionPane.showMessageDialog(null, "A imagem foi reduzida (8 bits) com sucesso !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event__8ActionPerformed

    // Reduction to 4 bits
    private void _4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__4ActionPerformed
        try {
            img.reduction(4);
            JOptionPane.showMessageDialog(null, "A imagem foi reduzida (4 bits) com sucesso !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event__4ActionPerformed

    // Reduction to 2 bits
    private void _2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__2ActionPerformed
        try {
            img.reduction(2);
            JOptionPane.showMessageDialog(null, "A imagem foi reduzida (2 bits) com sucesso !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event__2ActionPerformed

    private void menuItembinaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItembinaryActionPerformed
        try {
            int value = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para realizar a binarização !\n"));
            img.binarization(value);
            JOptionPane.showMessageDialog(null, "A imagem foi binarizada com sucesso !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItembinaryActionPerformed

    private void menuItemVerticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerticalActionPerformed
        try {
            img.rotateVertical();
            JOptionPane.showMessageDialog(null, "A imagem foi rotacionada para vertical com sucesso (180º) !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemVerticalActionPerformed

    private void menuItemHighLight1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemHighLight1ActionPerformed
        try {
            int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor inicial do intervalo !\n"));
            int b = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor final do intervalo !\n"));
            int glevel1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro nível de cinza !\n"));
            int glevel2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo nível de cinza !\n"));
            img.highlightsTransformation(a, b, glevel1, glevel2);
            JOptionPane.showMessageDialog(null, "A imagem foi Realçada com sucesso !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemHighLight1ActionPerformed

    private void menuItemHighLight2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemHighLight2ActionPerformed
        try {
            int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor inicial do intervalo !\n"));
            int b = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor final do intervalo !\n"));
            int greyLevel = Integer.parseInt(JOptionPane.showInputDialog("Digite o nível de cinza !\n"));
            img.highlightsTransformation2(a, b, greyLevel);
            JOptionPane.showMessageDialog(null, "A imagem foi Realçada com sucesso !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemHighLight2ActionPerformed

    private void menuItemSub1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSub1ActionPerformed
         try {
            int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor inicial do intervalo !\n"));
            int b = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor final do intervalo !\n"));
            int glevel1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro nível de cinza !\n"));
            int glevel2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo nível de cinza !\n"));
            img.subtraction1(a, b, glevel1, glevel2);
            JOptionPane.showMessageDialog(null, "A imagem foi subtraída com sucesso !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemSub1ActionPerformed

    private void menuItemSubtraction2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSubtraction2ActionPerformed
       try {
            int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor inicial do intervalo !\n"));
            int b = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor final do intervalo !\n"));
            int greyLevel = Integer.parseInt(JOptionPane.showInputDialog("Digite o nível de cinza !\n"));
            img.subtraction2(a, b, greyLevel);
            JOptionPane.showMessageDialog(null, "A imagem foi subtraída com sucesso !\n");
        } catch (IOException ex) {
            Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemSubtraction2ActionPerformed

    private void MenuItemTransformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemTransformActionPerformed
        try {
             float power = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor da potência interval entre (0, 1) !\n"));
             img.transformPower(power);
             JOptionPane.showMessageDialog(null, "A imagem foi transformada com sucesso !\n");
         } catch (IOException ex) {
             Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_MenuItemTransformActionPerformed

    private void menuItemZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemZoomActionPerformed
         try {
             int n = Integer.parseInt(JOptionPane.showInputDialog("Digite qtde x que a imagem vai ser ampliada !\n"));
             img.zoomIn(n);
             JOptionPane.showMessageDialog(null, "A imagem foi ampliada com sucesso !\n");
         } catch (IOException ex) {
             Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_menuItemZoomActionPerformed

    private void menuItemZoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemZoomOutActionPerformed
        try {
             int n = Integer.parseInt(JOptionPane.showInputDialog("Digite qtde x que a imagem vai ser diminuída !\n"));
             img.zoomOut(n);
             JOptionPane.showMessageDialog(null, "A imagem foi diminuída com sucesso !\n");
         } catch (IOException ex) {
             Logger.getLogger(IUMain.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_menuItemZoomOutActionPerformed
    
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
            java.util.logging.Logger.getLogger(IUMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuItemTransform;
    private javax.swing.JMenuItem _16;
    private javax.swing.JMenuItem _2;
    private javax.swing.JMenuItem _4;
    private javax.swing.JMenuItem _8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuBinary;
    private javax.swing.JMenuItem menuDarkenI;
    private javax.swing.JMenuItem menuDarkenII;
    private javax.swing.JMenu menuHighlight;
    private javax.swing.JMenuItem menuItemAdd;
    private javax.swing.JMenuItem menuItemHighLight1;
    private javax.swing.JMenuItem menuItemHighLight2;
    private javax.swing.JMenuItem menuItemHorizontal;
    private javax.swing.JMenuItem menuItemLeft;
    private javax.swing.JMenuItem menuItemMult;
    private javax.swing.JMenuItem menuItemRight;
    private javax.swing.JMenuItem menuItemSave;
    private javax.swing.JMenuItem menuItemSub1;
    private javax.swing.JMenuItem menuItemSubtraction2;
    private javax.swing.JMenuItem menuItemVertical;
    private javax.swing.JMenuItem menuItemZoom;
    private javax.swing.JMenuItem menuItemZoomOut;
    private javax.swing.JMenuItem menuItembinary;
    private javax.swing.JMenu menuLighten;
    private javax.swing.JMenuItem menuNegative;
    private javax.swing.JMenuItem menuOpen;
    private javax.swing.JMenu menuReduction;
    private javax.swing.JMenu menuRotate;
    // End of variables declaration//GEN-END:variables
}
