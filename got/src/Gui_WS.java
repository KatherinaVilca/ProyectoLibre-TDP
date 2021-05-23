package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JComboBox;


@SuppressWarnings("serial")
public class Gui_WS extends JFrame {

	private JPanel contentPane;
	private JLabel titulo;
	private Logica logica;
	private JPanel panel_2;
	private JTextPane textPane;
	private JPanel panel_3;
	private JPanel panel_5;
	private JComboBox<String> comboBox;
	private JButton cargarJFileChooser;
	
	private JButton  botonMostrarPrincipal;
	private JButton botonComenzar;
	private File elegido;
	private String palabrasCarpeta;
	private Traductor traductor;
	private JLabel tituloArchivos;
	private JList <String> visorArchivos;
	
	private JScrollPane scrollTextPane;
	
	private JScrollPane scrollVisorArchivos;;
	
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
		traductor = Traductor.getInstance();
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		
		logica= new Logica();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		initSubPaneles();
		initJFileChooser();
		initTitulos();
		initBotones();
		initContenidoArchivos();
		initComponentTextPane();		
		initComboBox();
		
		comboBox.addActionListener(new ActionListener() {
	            
            public void actionPerformed(ActionEvent e) {

                String s = (String) comboBox.getSelectedItem();

                switch (s) {
                    case "Ingles":
                      
                    			traductor.changeIngles();
                        break;
                    case "Español":
                        
                    			traductor.changeEspañol();
                        break;
                  
                    default:
                
                        break;
                }
                
                cambiarTitulos();
            }
        }
	        );
		
		
		cargarJFileChooser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				JFileChooser selector = new JFileChooser();
				textPane.setText("");
				selector.setCurrentDirectory(new File("."));
				selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						       
		        int respuesta = selector.showOpenDialog(Gui_WS.this);
		      
		        if ( !(respuesta == JFileChooser.APPROVE_OPTION) ) {
		        	
		          return;
		        }
		        
		        elegido = selector.getSelectedFile();
		        botonMostrarPrincipal.setEnabled(false);
		        		        
	          
		        if ( logica.esValido(elegido) ){
	        	  
		        	  palabrasCarpeta = logica.obtenerPalabrasMasUsadasDirectorio(respuesta);
		        	  botonComenzar.setEnabled(true);
		        	  botonMostrarPrincipal.setEnabled(false);
		        	  scrollVisorArchivos.setVisible(false);
		        	  
		        }
		        else {
		        	  	botonComenzar.setEnabled(false);
		          		JOptionPane.showMessageDialog(null, "Seleccione una carpeta que contenga archivos txt", "Error", respuesta);
	          		} 
			}
		});
		
		botonComenzar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				scrollVisorArchivos.setVisible(true);
				textPane.setText(palabrasCarpeta);
				visorArchivos.setListData( ( String[] ) logica.cargarArchi() );
				botonComenzar.setEnabled(false);
				botonMostrarPrincipal.setEnabled(true);	
			}
		}
		);
		
		botonMostrarPrincipal.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				textPane.setText(palabrasCarpeta);		
				
			}
		}); 
		
		visorArchivos.addListSelectionListener(new ListSelectionListener () {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				List<String> archivos = visorArchivos.getSelectedValuesList();
				
				for( String archivo : archivos) {
						
						textPane.setText(logica.seleccionArchivo( new File(archivo)));
				}
	
			}
			
		});
		
	}
	
	private void initBotones() {
		
		botonMostrarPrincipal = new JButton(traductor.obtenerPalabra(PalabrasClave.VER));
		botonMostrarPrincipal.setBounds(211, 193, 115, 21);
		botonMostrarPrincipal.setEnabled(false);
		panel_3.add(botonMostrarPrincipal);
		
		botonComenzar = new JButton(traductor.obtenerPalabra(PalabrasClave.COMENZAR));
		botonComenzar.setBounds(211, 61, 115, 21);
		botonComenzar.setEnabled(false);
		panel_3.add(botonComenzar);
	}
	
	private void initSubPaneles() {
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(null);
	}
			
	private void cambiarTitulos() {
		
		cargarJFileChooser.setText(traductor.obtenerPalabra(PalabrasClave.CARGAR));
		botonMostrarPrincipal.setText(traductor.obtenerPalabra(PalabrasClave.VER));
		botonComenzar.setText(traductor.obtenerPalabra(PalabrasClave.COMENZAR));
		tituloArchivos.setText(traductor.obtenerPalabra(PalabrasClave.ARCHIVOS));
	}
	
	private void initComponentTextPane() {
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		panel_2.add(textPane);		
		scrollTextPane = new JScrollPane(textPane);
		scrollTextPane.setBounds(20, 238, 228, 228);
		panel_3.add(scrollTextPane);
	}
	
	private void initTitulos() {
		
		JPanel panel = new JPanel();
		panel.setBounds(100, 100,500, 1550);
		contentPane.add(panel, BorderLayout.NORTH);
		
		titulo= new JLabel(" Winter is Coming");
		titulo.setVerticalAlignment(SwingConstants.TOP);
		titulo.setFont(new Font("Dialog", Font.PLAIN, 26));
		titulo.setBounds(214, 0, 298, 38);
		panel.add(titulo);
		
		tituloArchivos = new JLabel(traductor.obtenerPalabra(PalabrasClave.ARCHIVOS));
		tituloArchivos.setBounds(10, 20, 85, 21);
		panel_3.add(tituloArchivos);
			
	}

	private void initContenidoArchivos() {
		
		visorArchivos = new JList<String>();
		visorArchivos.setBounds(20, 51, 198, 141);
		panel_3.add(visorArchivos);
		
		scrollVisorArchivos = new JScrollPane(visorArchivos);
		scrollVisorArchivos.setBounds(20, 48, 181, 166);
		panel_3.add(scrollVisorArchivos);
		
	}

	private void initComboBox() {
		
		panel_5 = new JPanel();
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 50));
		contentPane.add(panel_5, BorderLayout.EAST);
		
		comboBox = new JComboBox<String>();
		comboBox.setEditable(true);
		comboBox.setSize(1500, 900);
		panel_5.add(comboBox);
		
	
		comboBox.addItem("Ingles");
		comboBox.addItem("Español");
		comboBox.setEditable(false);
	}
	
	private void initJFileChooser() {
		
		cargarJFileChooser = new JButton(traductor.obtenerPalabra(PalabrasClave.CARGAR)) ;
		cargarJFileChooser.setBounds(105, 20, 152, 21);
		panel_3.add(cargarJFileChooser);
	}
}

