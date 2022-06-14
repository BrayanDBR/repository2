package application;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Juego {

	//Atributos
	JFrame ventana;
	//Presentacion:
	JPanel panelPresentacion;
	JLabel fondoPresentacion;
	JLabel BotonJugar;
	//Juego
	JPanel panelJuego;
	JLabel matriz[][];
	int mat[][];
	String Jugador;
	Random Aleatorio;
	
	//Constructor
	public Juego() {
		//Ventana
		ventana = new JFrame("Juego de Memoria");
		ventana.setSize(700, 500); //Tama�o de la ventana
		ventana.setLayout(null); //Para colocar los componentes donde queramos
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Cuando nuestro programa se cierre no se quede ejecutando en segundo plano
		ventana.setLocationRelativeTo(null); //Ventana en el centro de la pantalla
		ventana.setResizable(false); //Se deshabilita el botan de maximizar
		
		//Jpanel Presentancion
		panelPresentacion = new JPanel();
		panelPresentacion.setSize(ventana.getWidth(),ventana.getHeight()); //Tama�o de la ventana
		panelPresentacion.setLocation(0, 0);
		panelPresentacion.setLayout(null); //Para colocar los componentes donde queramos
		panelPresentacion.setVisible(true);
		
		
		//Fondo de Presentacion
		fondoPresentacion = new JLabel();
		fondoPresentacion.setSize(ventana.getWidth(),ventana.getHeight());//Tama�o del fondo
		fondoPresentacion.setIcon(new ImageIcon("imagenes/fondo.JPG")); //Indicamos cual es el fondo
		panelPresentacion.add(fondoPresentacion,0);
		
		//Boton de Jugar
		BotonJugar = new JLabel();
		BotonJugar.setSize(150, 149);//Tama�o del boton
		BotonJugar.setLocation(270, 280);
		BotonJugar.setIcon(new ImageIcon("imagenes/Boton.PNG")); //Indicamos cual la imagen
		BotonJugar.setVisible(true);
		panelPresentacion.add(BotonJugar,0);
		
		//Panel juego
		panelJuego = new JPanel();
		panelJuego.setSize(ventana.getWidth(),ventana.getHeight()); //Tama�o de la ventana
		panelJuego.setLocation(0, 0);
		panelJuego.setLayout(null); //Para colocar los componentes donde queramos
		panelJuego.setVisible(true);
		
		//Matriz Logica
		mat = new int [2][2];
		this.numerosAleatorios();
		
		
		BotonJugar.addMouseListener(new MouseAdapter() {
			@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("Presione el boton");
		}
			
		});
		
		
		ventana.add(panelPresentacion); //Se agrega a la ventana
		ventana.setVisible(true);//Hacer visible la ventana
	}
	
	public void numerosAleatorios() {
		
		for (int i=0; i<2;i++) {
			for(int j=0; j<2;j++) {
				mat[i][j] = 0;}
		}
		
		
		for (int i=0; i<2;i++) {
			for(int j=0; j<2;j++) {
				mat[i][j] = Aleatorio.nextInt(2);
				System.out.print(mat[i][j]+" ");
			
						}
			System.out.print(" ");
					}
				}			
		}

