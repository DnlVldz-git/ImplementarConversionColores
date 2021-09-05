/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author dani_
 */
public class PrincipalFrame extends JFrame {

    public JPanelImagen pnlImg1;
    public JPanelImagen pnlImg2;
    private JButton btnEj1;
    private JButton btnEj2;
    private JButton btnEj3;
    private JPanel pnl;
    private PnlBotn pnlBtn;
    private PanelBtnBN pnlBN;
    private PnlBtnColor pnlColor;

    public PrincipalFrame() {
        super.setSize(300, 200);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);

        btnEj1 = new JButton("Ejercicio 1");
        btnEj2 = new JButton("Ejercicio 2");
        btnEj3 = new JButton("Ejercicio 3");
        pnl = new JPanel();
        pnlColor = new PnlBtnColor();

        pnlBN = new PanelBtnBN();

        pnl.setSize(900, 700);

        pnl.add(Box.createRigidArea(new Dimension(0, 100)));
        pnl.add(btnEj1);
        pnl.add(btnEj2);
        pnl.add(btnEj3);

        btnEj1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                remove(pnl);
                pnlImg1 = new JPanelImagen("img.png");
                add(pnlImg1, BorderLayout.WEST);

                pnlBtn = new PnlBotn();
                add(pnlBtn, BorderLayout.SOUTH);
                setSize(1200, 700);

                pnlBtn.getBtnSalir().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        remove(pnlBtn);
                        remove(pnlImg1);
                        remove(pnlImg2);
                        pnl.add(Box.createRigidArea(new Dimension(0, 100)));
                        pnl.add(btnEj1);
                        pnl.add(btnEj2);
                        pnl.add(btnEj3);
                        add(pnl);
                        setSize(300, 200);
                    }
                });

                pnlBtn.getBtn().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            BufferedImage img = ImageIO.read(new File("img.png"));
                            //ancho
                            for (int x = 0; x < img.getWidth(); x++) {
                                //alto
                                for (int y = 0; y < img.getHeight(); y++) {

                                    int rgb = img.getRGB(x, y);
                                    Color color = new Color(rgb);

                                    Color colorNuevo = new Color((255 - color.getRed()), (255 - color.getGreen()), (255 - color.getBlue()));

                                    img.setRGB(x, y, colorNuevo.getRGB());

                                }
                            }
                            ImageIO.write(img, "png", new File("img2.png"));
                            pnlImg2 = new JPanelImagen("img2.png");
                            add(pnlImg2, BorderLayout.EAST);
                            setSize(1200, 701);
                            setSize(1200, 700);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                });
            }
        });

        btnEj2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JPanelImagen pnlImg = new JPanelImagen("img_bn_orig.png");
                remove(pnl);
                add(pnlImg, BorderLayout.WEST);
                add(pnlBN, BorderLayout.SOUTH);
                setSize(1100, 600);
                pnlBN.getBtn1().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if (pnlImg2 != null) {
                            remove(pnlImg2);
                        }
                        try {
                            BufferedImage img = ImageIO.read(new File("img_bn_orig.png"));
                            for (int x = 0; x < img.getWidth(); x++) {
                                for (int y = 0; y < img.getHeight(); y++) {
                                    int rgb = img.getRGB(x, y);
                                    Color color = new Color(rgb);
                                    int color1Bit = setColor1Bit(color.getRed());
                                    Color colorNuevo = new Color(color1Bit, color1Bit, color1Bit);
                                    img.setRGB(x, y, colorNuevo.getRGB());
                                }
                            }
                            ImageIO.write(img, "png", new File("img_bn_1.png"));
                            pnlImg2 = new JPanelImagen("img_bn_1.png");
                            add(pnlImg2, BorderLayout.EAST);
                            setSize(1200, 601);
                            setSize(1200, 600);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                });
                pnlBN.getBtn2().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if (pnlImg2 != null) {
                            remove(pnlImg2);
                        }
                        try {
                            BufferedImage img = ImageIO.read(new File("img_bn_orig.png"));
                            for (int x = 0; x < img.getWidth(); x++) {
                                for (int y = 0; y < img.getHeight(); y++) {
                                    int rgb = img.getRGB(x, y);
                                    Color color = new Color(rgb);
                                    int color1Bit = setColor2Bit(color.getRed());
                                    Color colorNuevo = new Color(color1Bit, color1Bit, color1Bit);
                                    img.setRGB(x, y, colorNuevo.getRGB());
                                }
                            }
                            ImageIO.write(img, "png", new File("img_bn_2.png"));
                            pnlImg2 = new JPanelImagen("img_bn_2.png");
                            add(pnlImg2, BorderLayout.EAST);
                            setSize(1200, 601);
                            setSize(1200, 600);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                });
                pnlBN.getBtn3().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if (pnlImg2 != null) {
                            remove(pnlImg2);
                        }
                        try {
                            BufferedImage img = ImageIO.read(new File("img_bn_orig.png"));
                            for (int x = 0; x < img.getWidth(); x++) {
                                for (int y = 0; y < img.getHeight(); y++) {
                                    int rgb = img.getRGB(x, y);
                                    Color color = new Color(rgb);
                                    int color1Bit = setColor4Bit(color.getRed());
                                    Color colorNuevo = new Color(color1Bit, color1Bit, color1Bit);
                                    img.setRGB(x, y, colorNuevo.getRGB());
                                }
                            }
                            ImageIO.write(img, "png", new File("img_bn_4.png"));
                            pnlImg2 = new JPanelImagen("img_bn_4.png");
                            add(pnlImg2, BorderLayout.EAST);
                            setSize(1200, 601);
                            setSize(1200, 600);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                });
                pnlBN.getBtn4().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if (pnlImg2 != null) {
                            remove(pnlImg2);
                        }
                        try {
                            BufferedImage img = ImageIO.read(new File("img_bn_orig.png"));
                            for (int x = 0; x < img.getWidth(); x++) {
                                for (int y = 0; y < img.getHeight(); y++) {
                                    int rgb = img.getRGB(x, y);
                                    Color color = new Color(rgb);
                                    int color1Bit = setColor8Bit(color.getRed());
                                    Color colorNuevo = new Color(color1Bit, color1Bit, color1Bit);
                                    img.setRGB(x, y, colorNuevo.getRGB());
                                }
                            }
                            ImageIO.write(img, "png", new File("img_bn_8.png"));
                            pnlImg2 = new JPanelImagen("img_bn_8.png");
                            add(pnlImg2, BorderLayout.EAST);
                            setSize(1200, 601);
                            setSize(1200, 600);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                });
                pnlBN.getBtnRegresar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if (pnlImg2 != null) {
                            remove(pnlBN);
                            remove(pnlImg2);
                            remove(pnlImg);
                            pnl.add(Box.createRigidArea(new Dimension(0, 100)));
                            pnl.add(btnEj1);
                            pnl.add(btnEj2);
                            pnl.add(btnEj3);
                            add(pnl);
                            setSize(300, 201);
                            setSize(300, 200);
                        } else {
                            remove(pnlBN);
                            remove(pnlImg);
                            pnl.add(Box.createRigidArea(new Dimension(0, 100)));
                            pnl.add(btnEj1);
                            pnl.add(btnEj2);
                            pnl.add(btnEj3);
                            add(pnl);
                            setSize(300, 201);
                            setSize(300, 200);
                        }
                    }
                });
            }
        });

        btnEj3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                remove(pnl);
                pnlImg1 = new JPanelImagen("img_color.png");
                add(pnlImg1, BorderLayout.WEST);

                add(pnlColor, BorderLayout.SOUTH);
                setSize(1100, 600);

                pnlColor.getBtnRegresar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        remove(pnlColor);
                        remove(pnlImg1);
                        pnl.add(Box.createRigidArea(new Dimension(0, 100)));
                        pnl.add(btnEj1);
                        pnl.add(btnEj2);
                        pnl.add(btnEj3);
                        add(pnl);
                        setSize(300, 201);
                        setSize(300, 200);
                    }
                });

                pnlColor.getBtnAceptar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if (pnlImg2 != null) {
                            remove(pnlImg2);
                        }
                        if (pnlColor.getCmbBox().getSelectedIndex() == -1) {
                            JOptionPane.showMessageDialog(null, "Seleccione el color");
                        } else {
                            try {
                                BufferedImage img = ImageIO.read(new File("img_color.png"));
                                for (int x = 0; x < img.getWidth(); x++) {
                                    for (int y = 0; y < img.getHeight(); y++) {
                                        int rgb = img.getRGB(x, y);
                                        Color color = new Color(rgb);
                                        if (pnlColor.getCmbBox().getSelectedIndex() == 0) {
                                            if ((color.getRed() >= pnlColor.getFldTxt()) && ((color.getRed() <= pnlColor.getFldTxt2()))) {
                                                Color colorNuevo = new Color(255, 255, 255);
                                                img.setRGB(x, y, colorNuevo.getRGB());
                                            }
                                        } else if (pnlColor.getCmbBox().getSelectedIndex() == 1) {
                                            if ((color.getGreen() >= pnlColor.getFldTxt()) && ((color.getGreen() <= pnlColor.getFldTxt2()))) {
                                                Color colorNuevo = new Color(255,255,255);
                                                img.setRGB(x, y, colorNuevo.getRGB());
                                            }
                                        } else if (pnlColor.getCmbBox().getSelectedIndex() == 2) {
                                            if ((color.getBlue() >= pnlColor.getFldTxt()) && ((color.getBlue() <= pnlColor.getFldTxt2()))) {
                                                Color colorNuevo = new Color(255,255, 255);
                                                img.setRGB(x, y, colorNuevo.getRGB());
                                            }
                                        }                                       
                                    }
                                }
                                ImageIO.write(img, "png", new File("img_color_mod.png"));
                                pnlImg2 = new JPanelImagen("img_color_mod.png");
                                add(pnlImg2, BorderLayout.EAST);
                                setSize(1200, 601);
                                setSize(1200, 600);
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                    }
                });
            }

        });

        add(pnl);
        super.setVisible(true);
    }

    public void changeColor() {

    }

    public int setColor1Bit(int color) {
        if (color <= 128) {
            return 0;
        } else if (color >= 129) {
            return 255;
        } else {
            return -1;
        }
    }

    public int setColor2Bit(int color) {
        if (color <= 63) {
            return 0;
        } else if ((color >= 64) && (color <= 127)) {
            return 64;
        } else if ((color >= 128) && (color <= 191)) {
            return 128;
        } else if ((color >= 192) && (color <= 255)) {
            return 192;
        } else {
            return -1;
        }
    }

    public int setColor4Bit(int color) {
        if (color <= 31) {
            return 0;
        } else if ((color >= 32) && (color <= 63)) {
            return 32;
        } else if ((color >= 64) && (color <= 95)) {
            return 64;
        } else if ((color >= 96) && (color <= 127)) {
            return 96;
        } else if ((color >= 128) && (color <= 159)) {
            return 128;
        } else if ((color >= 160) && (color <= 191)) {
            return 160;
        } else if ((color >= 192) && (color <= 223)) {
            return 192;
        } else if ((color >= 224) && (color <= 255)) {
            return 224;
        } else {
            return -1;
        }
    }

    public int setColor8Bit(int color) {
        if (color <= 15) {
            return 0;
        } else if ((color >= 16) && (color <= 31)) {
            return 16;
        } else if ((color >= 32) && (color <= 47)) {
            return 32;
        } else if ((color >= 48) && (color <= 63)) {
            return 48;
        } else if ((color >= 64) && (color <= 79)) {
            return 64;
        } else if ((color >= 80) && (color <= 95)) {
            return 80;
        } else if ((color >= 96) && (color <= 111)) {
            return 96;
        } else if ((color >= 112) && (color <= 127)) {
            return 112;
        } else if ((color >= 128) && (color <= 143)) {
            return 128;
        } else if ((color >= 144) && (color <= 159)) {
            return 144;
        } else if ((color >= 160) && (color <= 175)) {
            return 160;
        } else if ((color >= 176) && (color <= 191)) {
            return 176;
        } else if ((color >= 192) && (color <= 207)) {
            return 192;
        } else if ((color >= 208) && (color <= 223)) {
            return 208;
        } else if ((color >= 224) && (color <= 239)) {
            return 224;
        } else if ((color >= 240) && (color <= 255)) {
            return 240;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalFrame();

            }
        });
    }
}
