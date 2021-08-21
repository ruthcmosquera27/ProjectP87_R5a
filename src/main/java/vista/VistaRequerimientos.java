package vista;

import java.util.ArrayList;

import controlador.ControladorRequerimientos;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;


public class VistaRequerimientos extends JFrame{

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;

    public VistaRequerimientos(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450,200,800,600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel etiqueta = new JLabel("Solucion Reto 5");
        etiqueta.setBounds(28,6,110,50);
        contentPane.add(etiqueta);

        JLabel autor = new JLabel("Ruth C Mosquera Nuñez");
        autor.setBounds(28,34,208,16);
        contentPane.add(autor);

        JScrollPane barra = new JScrollPane();
        barra.setBounds(28,70,740,460);
        contentPane.add(barra);

        textArea = new JTextArea();
        barra.setViewportView(textArea);
        
       
        JButton btnConsulta1 = new JButton("Consulta 1");
        btnConsulta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                requerimiento1();
            }
        });
        btnConsulta1.setBounds(28, 537, 117, 29);
        contentPane.add(btnConsulta1);

        JButton btnConsulta2 = new JButton("Consulta 2");
        btnConsulta2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                requerimiento2();
            }
        });
        btnConsulta2.setBounds(157,537,117,30);
        contentPane.add(btnConsulta2);

        JButton btnConsulta3 = new JButton("Consulta 3");
        btnConsulta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                requerimiento3();
            }
        });
        btnConsulta3.setBounds(300, 537, 120, 30);
        contentPane.add(btnConsulta3);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                textArea.setText("");
            }
        });
        btnLimpiar.setBounds(600,537,120,30);
        contentPane.add(btnLimpiar);
          
    }

    public void requerimiento1() {
        try {
            ArrayList<Requerimiento_1Vo> lista1 = controlador.consultarRequerimiento1();
            String salida = "   Lider por Salario  \n\nID_Lider\tNombre\tPrimer_Apellido\tSalario\n\n";
            for (Requerimiento_1Vo reque : lista1) {
                salida += reque.getID_Lider();
                salida += "\t";
                salida += reque.getNombre();
                salida += "\t";
                salida += reque.getPrimer_Apellido();
                salida += "\t";
                salida += reque.getSalario();
                salida += "\n";
            }
            textArea.setText(salida);

        } catch (SQLException e) {
            System.err.println("Se ha producido el siguiente error:" + e.getMessage());
        }
    }

    public void requerimiento2() {
        try {
            ArrayList<Requerimiento_2Vo> lista1 = controlador.consultarRequerimiento2();
            String salida = "   Nombre del Material  \n\nID_Proyecto\tNombre_Material\n\n";
            for (Requerimiento_2Vo reque : lista1) {
                salida += reque.getID_Proyecto();
                salida += "\t";
                salida += reque.getNombre_Material();
                salida += "\n";
            }
            textArea.setText(salida);

        } catch (SQLException e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
        }
    }

    public void requerimiento3() {
            String salida = "    Lider   \n\nInsertar Nuevo Lider ";
            salida += "\n";

        textArea.setText(salida);

    }

}
