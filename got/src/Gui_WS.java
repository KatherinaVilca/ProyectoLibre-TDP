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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
	private JList list_1;
	private String sel;
	JButton  btnNewButton_1;
	private JButton btnNewButton_2;
	private File elegido;
	
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
		
		list_1 = new JList();
		panel_JFileChooser.add(list_1);
		
		btnNewButton_1 = new JButton(traductor.obtenerPalabra(PalabrasClave.VER));
		btnNewButton_1.setBounds(319, 236, 85, 21);
		panel_3.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton(traductor.obtenerPalabra(PalabrasClave.COMENZAR));
		btnNewButton_2.setBounds(319, 70, 85, 21);
		panel_3.add(btnNewButton_2);
		
		
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
		
		comboBox.addActionListener(new ActionListener() {
	            
	            public void actionPerformed(ActionEvent e) {

	                String s = (String) comboBox.getSelectedItem();

	                switch (s) {//check for a match
	                    case "Ingles":
	                      traductor.changeE();
	      
	                       cambiarTitulos();
	                        break;
	                    case "Español":
	                        
	                       traductor.changeS();
	                       cambiarTitulos();
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
				       
				        	
				           elegido = selector.getSelectedFile();
				    
				            
				        }
				
				
			}
		});
		
	btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
		  sel=logica.seleccionCarpeta(elegido);
          textPane.setText(sel);
          list_1.setListData( ( Object[] ) logica.cargarArchi());
			}
	}
	);
		
		list_1.addListSelectionListener(new ListSelectionListener () {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				
				int in= e.getFirstIndex() ;
				String s = (String) list_1.getModel().getElementAt(in);
				
				File  f= new File(s);
				textPane.setText(logica.seleccionArchivo(f));

				
			}
			
			
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				textPane.setText(sel);		
				
			}
		});
		
	}
	
	private void cambiarTitulos() {
		
		Traductor t= Traductor.getInstance();
		System.out.println(t.obtenerPalabra(PalabrasClave.CARGAR));
		btnNewButton.setText(t.obtenerPalabra(PalabrasClave.CARGAR));
		
		btnNewButton_1.setText(t.obtenerPalabra(PalabrasClave.VER));
		
		btnNewButton_2.setText(t.obtenerPalabra(PalabrasClave.COMENZAR));
		
	}
}
