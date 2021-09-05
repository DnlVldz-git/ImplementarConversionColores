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
public class PanelBtnBN extends JPanel {
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btnRegresar;

    public PanelBtnBN() {
        super.setSize(800, 200);
        super.setBackground(Color.WHITE);
        super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        btn1 = new JButton("1 bit");
        btn2 = new JButton("2 bits");
        btn3 = new JButton("4 bits");
        btn4 = new JButton("8 bits");
        btnRegresar = new JButton("Regresar");

        add(Box.createRigidArea(new Dimension(360, 0)));
        add(btnRegresar);
        add(Box.createRigidArea(new Dimension(50, 0)));
        add(btn1);
        add(Box.createRigidArea(new Dimension(30, 0)));
        add(btn2);
        add(Box.createRigidArea(new Dimension(30, 0)));
        add(btn3);
        add(Box.createRigidArea(new Dimension(30, 0)));
        add(btn4);

    }

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    public JButton getBtn1() {
        return btn1;
    }

    public JButton getBtn2() {
        return btn2;
    }

    public JButton getBtn3() {
        return btn3;
    }

    public JButton getBtn4() {
        return btn4;
    }
}
