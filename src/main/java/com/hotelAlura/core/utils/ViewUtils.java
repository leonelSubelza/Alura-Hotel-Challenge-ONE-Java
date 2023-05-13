package com.hotelAlura.core.utils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewUtils {

    public static void setLineHoverToButton(JPanel panel, Color hoverColor){
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBorder(null);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBorder(new LineBorder(hoverColor));
            }
        });
    }
    
    public static void setHoverToButton(JPanel panel, Color defaultColor, Color hoverColor,JLabel label, Color fontDefaultColor, Color fontHoverColor) {
    	panel.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseExited(MouseEvent e) {
    			panel.setBackground(defaultColor);
            	label.setForeground(fontDefaultColor);
    			
    		}
            @Override
            public void mouseEntered(MouseEvent e) {
            	panel.setBackground(hoverColor);
            	label.setForeground(fontHoverColor);
            }
    	});
    }

    public static void handleExitHover(JLabel lblExit,Color defaultColor, Color hoverColor) {
        lblExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                lblExit.setForeground(defaultColor);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lblExit.setForeground(hoverColor);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                int confirm = JOptionPane.showOptionDialog(null, "¿Estás seguro que quieres salir?", "Advertencia",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    System.exit(0);
                }
            }
        });
    }

    public static void centerWindow(JFrame frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    public static void handleBackBtn(JFrame frame,JLabel lblBack) {
        lblBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lblBack.setForeground(new Color(140, 140, 140));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblBack.setForeground(Color.black);
            }
        });
    }
}
