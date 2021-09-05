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
public class PnlBtnColor extends JPanel{
    private JComboBox cmbBox;
    private JLabel lbl;
    private JTextField fld;
    private JTextField fld2;
    private JButton btnRegresar;
    private JButton btnAceptar;

    public PnlBtnColor() {
        super.setSize(800, 200);
        super.setBackground(Color.WHITE);
        super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        cmbBox = new JComboBox();
        cmbBox.addItem("Rojo");
        cmbBox.addItem("Verde");
        cmbBox.addItem("Azul");
        fld = new JTextField(5);
        fld2 = new JTextField(5);
        Dimension dmn = new Dimension(15, 50);
        fld.setPreferredSize(dmn);
        lbl = new JLabel("Ingrese el rango de color: 0 - 255");
        btnRegresar = new JButton("Regresar");
        btnAceptar = new JButton("Aceptar");

        add(Box.createRigidArea(new Dimension(20, 0)));
        add(btnRegresar);
        add(Box.createRigidArea(new Dimension(20, 0)));
        add(cmbBox);
        add(Box.createRigidArea(new Dimension(20, 0)));
        add(lbl);
        add(Box.createRigidArea(new Dimension(20, 0)));
        add(fld);
        add(Box.createRigidArea(new Dimension(20, 0)));
        add(fld2);
        add(Box.createRigidArea(new Dimension(20, 0)));
        add(btnAceptar);                
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public JButton getBtnRegresar() {
        return btnRegresar;
    }
    
    public JComboBox getCmbBox(){
        return cmbBox;
    }
    
    public int getFldTxt(){
        try {
            int num = Integer.valueOf(fld.getText());            
            if ((num>=-1) && (num<=256)) {
                return num;
            }else{                
                throw new Exception();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Introduzca una cantidad correcta");
        }
        return -1;
    }
    public int getFldTxt2(){
        try {
            int num = Integer.valueOf(fld2.getText());            
            if ((num>=-1) && (num<=256)) {
                return num;
            }else{                
                throw new Exception();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Introduzca una cantidad correcta");
        }
        return -1;
    }
}
