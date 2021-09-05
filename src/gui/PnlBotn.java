/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
/**
 *
 * @author dani_
 */
public class PnlBotn extends JPanel{
    private JButton btn;
    private JButton btnSalir;
    
    public PnlBotn(){
        super.setSize(800, 200);
        super.setBackground(Color.WHITE);
        super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));  
        
        
        btn = new JButton("Convertir");
        btnSalir = new JButton("Regresar");
        add(Box.createRigidArea(new Dimension(500, 0)));
        add(btn);
        add(Box.createRigidArea(new Dimension(30, 0)));
        add(btnSalir);
    }    

    public JButton getBtn() {
        return btn;
    }
    
    public JButton getBtnSalir() {
        return btnSalir;
    }
}
