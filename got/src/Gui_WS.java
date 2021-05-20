package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.AbstractListModel;

public class Gui_WS extends JFrame {

	private JPanel contentPane;
	private JLabel titulo;
	private JButton cargarJFileChooser;
	private Logica logica;
	private JPanel panel_2;
	private JTextPane textPane;
	private JPanel panel_3;
	private JPanel panel_5;
	private JComboBox comboBox;
	private JButton btnNewButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_WS frame = new Gui_WS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Gui_WS() {
		
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		
		Traductor traductor= Traductor.getInstance();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(100, 100,500, 1550);
		contentPane.add(panel, BorderLayout.NORTH);
		
		titulo= new JLabel(" Titulo");
		titulo.setVerticalAlignment(SwingConstants.TOP);
		titulo.setFont(new Font("Dialog", Font.PLAIN, 26));
		titulo.setBounds(214, 0, 298, 38);
		panel.add(titulo);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		btnNewButton = new JButton(traductor.obtenerPalabra(PalabrasClave.CARGAR)) ;
		btnNewButton.setBounds(303, 25, 111, 21);
		panel_3.add(btnNewButton);
		
		JPanel panel_JFileChooser = new JPanel();
		panel_JFileChooser.setBounds(10, 25, 283, 232);
		panel_3.add(panel_JFileChooser);
		panel.setSize(1, 60);
		
		textPane = new JTextPane();
		panel_2.add(textPane);
		
		panel_5 = new JPanel();
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 50));
		contentPane.add(panel_5, BorderLayout.EAST);
		
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setSize(1500, 900);
		panel_5.add(comboBox);
		
	
		comboBox.addItem("Ingles");
		comboBox.addItem("Español");
		
		comboBox.addActionListener(new ActionListener() {//add actionlistner to listen for change
	            
	            public void actionPerformed(ActionEvent e) {

	                String s = (String) comboBox.getSelectedItem();//get the selected item

	                switch (s) {//check for a match
	                    case "Ingles":
	                       traductor.getInstance().changeE();
	                        break;
	                    case "Español":
	                       traductor.getInstance().changeS();
	                        break;
	                  
	                    default:
	                    
	                        break;
	                }
	            }
	        }
	        );
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
						
				logica= new Logica();
				
				JFileChooser selector = new JFileChooser();
				selector.setFileFilter( new FiltroTXT());
			
						 	
						 selector.setCurrentDirectory(new File("."));
						selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						selector.setAcceptAllFileFilterUsed(false);
				       
				        int respuesta = selector.showOpenDialog(Gui_WS.this);
				      
				        if (respuesta == JFileChooser.APPROVE_OPTION) {
				       
				        	
				            File elegido = selector.getSelectedFile();
				            
				            //System.out.println(logica.seleccionCarpeta(elegido));
				            textPane.setText(logica.seleccionCarpeta(elegido));
					}
				
				
			}
		});
		
		
		
		
		
	        
	}
	
	private void iniciarJFileChooser() {

	}
}
