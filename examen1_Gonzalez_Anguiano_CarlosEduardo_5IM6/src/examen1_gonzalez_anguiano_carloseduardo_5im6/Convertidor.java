/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1_gonzalez_anguiano_carloseduardo_5im6;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Alumno
 */
public class Convertidor extends JFrame {

    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bpunto,bce,bconv;
    
    private JPanel panelNums;
    
    int count;
    
    ArrayList<JButton> listaBotones = new ArrayList<>();
    
    private JTextField entrada;

    public Convertidor() {
        super();
        this.setSize(420, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.inicializarComponentes();
        this.configComponentes();
        this.agregarLista();
        this.agrgarComponentes();
        this.acciones();
        this.setVisible(true);
    }
    
    public void agregarLista(){
        this.listaBotones.add(b0);
        this.listaBotones.add(b1);
        this.listaBotones.add(b2);
        this.listaBotones.add(b3);
        this.listaBotones.add(b4);
        this.listaBotones.add(b5);
        this.listaBotones.add(b6);
        this.listaBotones.add(b7);
        this.listaBotones.add(b8);
        this.listaBotones.add(b9);
    }

    public void inicializarComponentes() {
        this.entrada = new JTextField();
        this.b1 = new JButton("1");
        this.b2 = new JButton("2");
        this.b3 = new JButton("3");
        this.b4 = new JButton("4");
        this.b5 = new JButton("5");
        this.b6 = new JButton("6");
        this.b7 = new JButton("7");
        this.b8 = new JButton("8");
        this.b9 = new JButton("9");
        this.b0 = new JButton("0");
        this.bpunto = new JButton(".");
        this.bce = new JButton("CE");
        this.bconv = new JButton("CONV");
        this.panelNums = new JPanel();
    }
    
    public void configComponentes(){
        
        this.panelNums.setBounds(60, 60, 300, 300);
        this.panelNums.setLayout(new GridLayout(3,4));
        
        this.bconv.setBounds(60, 360, 300, 60);
        this.entrada.setBounds(60,0, 300, 60);
        
        this.bconv.setVisible(true);
        this.entrada.setVisible(true);
        this.panelNums.add(b1);
        this.panelNums.add(b2);
        this.panelNums.add(b3);
        this.panelNums.add(b4);
        this.panelNums.add(b5);
        this.panelNums.add(b6);
        this.panelNums.add(b7);
        this.panelNums.add(b8);
        this.panelNums.add(b9);
        this.panelNums.add(b0);
        this.panelNums.add(bpunto);
        this.panelNums.add(bce);
        this.panelNums.setVisible(true);
    }
    
    private void agrgarComponentes(){
        this.add(panelNums);
        this.add(bconv);
        this.add(entrada);
    }
    
    public void acciones(){
        bconv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 entrada.setText(Float.toString(convertir(entrada.getText())));
            }
        });
        
        
        count = 0;
        
        for(JButton temp: this.listaBotones){
            temp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                     entrada.setText(entrada.getText()+temp.getText());
                }
            });
            count++;
        }
        
        bce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 entrada.setText("");
            }
        });
        bpunto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 entrada.setText(entrada.getText()+".");
            }
        });
    }
    
    private float convertir(String pesos){
        float dolares = Float.valueOf(pesos)/19;
        return dolares;
    }
}
