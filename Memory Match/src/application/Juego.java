package application;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Juego {

	//Atributos
	JFrame ventana;
	//Presentacion:
	JPanel panelPresentacion;
	JLabel fondoPresentacion;
	JLabel BotonJugar;
	//Juego
	JPanel panelJuego;
	JLabel fondoJuego;
	JLabel matriz[][];
	int mat[][];
	int matAux [][];
	String Jugador;
	Random Aleatorio;
	JLabel nombreJugador;
	Timer tiempo;
	JLabel Cronometro;
	int min;
	int seg;
	int Contador;
	Timer tiempoEspera;
	int contSegEsp;
	Timer tiempoEspera1;
	int ban;
	int ban1;
	int antnum;
	int antx;
	int anty;
	int actualnum;
	int actualx;
	int actualy;
	//Constructor
	public Juego() {
		//Ventana
		ventana = new JFrame("Juego de Memoria");
		ventana.setSize(700, 500); //Tamaño de la ventana
		ventana.setLayout(null); //Para colocar los componentes donde queramos
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Cuando nuestro programa se cierre no se quede ejecutando en segundo plano
		ventana.setLocationRelativeTo(null); //Ventana en el centro de la pantalla
		ventana.setResizable(false); //Se deshabilita el botan de maximizar
		
		//Jpanel Presentancion
		panelPresentacion = new JPanel();
		panelPresentacion.setSize(ventana.getWidth(),ventana.getHeight()); //Tamaño de la ventana
		panelPresentacion.setLocation(0, 0);
		panelPresentacion.setLayout(null); //Para colocar los componentes donde queramos
		panelPresentacion.setVisible(true);
		
		
		//Fondo de Presentacion
		fondoPresentacion = new JLabel();
		fondoPresentacion.setSize(ventana.getWidth(),ventana.getHeight());//Tamaño del fondo
		fondoPresentacion.setLocation(0, 0);
		fondoPresentacion.setIcon(new ImageIcon("imagenes/fondo.JPG")); //Indicamos cual es el fondo
		fondoPresentacion.setVisible(true);
		panelPresentacion.add(fondoPresentacion,0);
		
		//Boton de Jugar
		BotonJugar = new JLabel();
		BotonJugar.setSize(150, 149);//Tamaño del boton
		BotonJugar.setLocation(270, 280);
		BotonJugar.setIcon(new ImageIcon("imagenes/Boton.PNG")); //Indicamos cual la imagen
		BotonJugar.setVisible(true);
		panelPresentacion.add(BotonJugar,0);
		
		//Panel juego
		panelJuego = new JPanel();
		panelJuego.setSize(ventana.getWidth(),ventana.getHeight()); //Tamaño de la ventana
		panelJuego.setLocation(0, 0);
		panelJuego.setLayout(null); //Para colocar los componentes donde queramos
		panelJuego.setVisible(true);
		
		//Fondo de Juego
		fondoJuego = new JLabel();
		fondoJuego.setSize(ventana.getWidth(),ventana.getHeight());//Tamaño del fondo
		fondoJuego.setLocation(0, 0);
		fondoJuego.setIcon(new ImageIcon("imagenes/fondo2.JPG")); //Indicamos cual es el fondo
		fondoJuego.setVisible(true);
		panelJuego.add(fondoJuego,0);
		
		//Nombre Jugador
		nombreJugador = new JLabel();
		nombreJugador.setSize(150,20);//Tamaño del fondo
		nombreJugador.setLocation(10, 100);
		nombreJugador.setForeground(Color.WHITE);
		nombreJugador.setVisible(true);
		panelJuego.add(nombreJugador,0);
	
		//Cronometro
		Cronometro = new JLabel();
		Cronometro.setSize(150,20);//Tamano del fondo
		Cronometro.setLocation(ventana.getWidth()-200,10);
		Cronometro.setForeground(Color.WHITE);
		Cronometro.setVisible(true);
		panelJuego.add(Cronometro,0);
		
		
		
		//Matriz Logica
		mat = new int [3][4];
		matAux = new int [3][4];
		Aleatorio = new Random();
		this.numerosAleatorios();
			
		//Matriz de imagenes
		matriz = new JLabel[3][4];
		for (int i=0; i<3;i++) {
			for(int j=0; j<4;j++) {
				matriz[i][j]=new JLabel();
				matriz[i][j].setBounds(130+(j*110), 50+(i*134), 110, 134);
				matriz[i][j].setIcon(new ImageIcon("imagenes/"+matAux[i][j]+".JPG"));
				matriz[i][j].setVisible(true);
				panelJuego.add(matriz[i][j],0);	
				
			}
			
		}
		
		//Tiempo
		
		min = 0;
		seg = 0;		
		tiempo = new Timer(1000, new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) {
				seg++;
				if(seg==60) {
					min++;
					seg=0;
				}
				Cronometro.setText("Tiempo: "+min+":"+seg);
			}});
		
		
		//Tiempo espera
		contSegEsp=0;
		tiempoEspera = new Timer (1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				contSegEsp++;
				
			}});
		tiempoEspera.start();
		tiempoEspera.stop();
		contSegEsp=0;
		ban=0;	
		ban1=0;
		//Evento de clic  de las cartas
		
		Contador=0;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				matriz[i][j].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						for(int k = 0; k < 3; k++) {
							for(int l = 0; l < 4; l++) {
								if(e.getSource()== matriz[k][l]) {
									if(matAux[k][l] ==0 && Contador != 2) {
									matAux[k][l] = mat[k][l];
									matriz[k][l].setIcon(new ImageIcon("imagenes/"+matAux[k][l]+".JPG"));
									Contador++;
									actualnum = mat[k][l];
									actualx = k;
									actualy = l;
									if(Contador == 1) {
									antnum =mat[k][l];
									antx = k;
									anty = l;
									}
									tiempoEspera1 = new Timer (500, new ActionListener() {
										
										public void actionPerformed(ActionEvent e)
										{
										if(Contador==2 && ban1 ==0) { 
											tiempoEspera.restart();
											ban1=1;
										}
									if(Contador==2 && contSegEsp== 2) {
										tiempoEspera.stop();
										contSegEsp=0;
										
										if(matAux[actualx][actualy]== matAux[antx][anty]) {
											matAux[actualx][actualy]=-1;
											matAux[antx][anty]= -1;
											matriz[actualx][actualy].setIcon(new ImageIcon("imagenes/"+matAux[actualx][actualy]+".JPG"));
											matriz[antx][anty].setIcon(new ImageIcon("imagenes/"+matAux[antx][anty]+".JPG"));
											Contador=0;
										}
										
										
										for(int m = 0; m < 3; m++) {
											for(int n = 0; n < 4; n++) {
												if(matAux[m][n]!=0 && matAux[m][n]!= -1) {
													matAux[m][n] = 0;
													matriz[m][n].setIcon(new ImageIcon("imagenes/"+matAux[m][n]+".JPG"));
													Contador=0;
													
												
												}
											}
										}
										tiempoEspera1.stop();
										ban1=0;
									}
										}});
									if(ban == 0) {
										tiempoEspera1.start();
										ban=1;
									}
									if(Contador == 2)
										tiempoEspera1.restart();
									}
								}
							}
						
						}
					}
				});
			}
		}
		
		
		
		
		
		
		BotonJugar.addMouseListener(new MouseAdapter() {
			@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("Presione el boton");
			
			Jugador= JOptionPane.showInputDialog(ventana, "Nombre del Jugador", "Escribe Aqui");
			while(Jugador==null||Jugador.compareTo("Escribe Aqui")==0 || Jugador.compareTo("")==0) {
				Jugador = JOptionPane.showInputDialog(ventana, "Debes ingresar usuario", "Escribe aqui");
			}
			
			nombreJugador.setText("Jugador: "+Jugador);
			tiempo.start();
			panelPresentacion.setVisible(false);
			ventana.add(panelJuego);
			panelJuego.setVisible(true);
			}});
		
		
		ventana.add(panelPresentacion); //Se agrega a la ventana
		ventana.setVisible(true);//Hacer visible la ventana
	}
	
	public void numerosAleatorios() {
		int acumulador=0;
		for (int i=0; i<3;i++) {
			for(int j=0; j<4;j++) {
				mat[i][j] = 0;
				matAux[i][j] = 0;
			}
			
		}
		
		for (int i=0; i<3;i++) {
			for(int j=0; j<4;j++) {
				mat[i][j] = Aleatorio.nextInt(9);
				do {
					acumulador=0;
				for (int k=0; k<3;k++) {
					for (int l=0; l<4;l++) {
						if (mat[i][j]==mat[k][l]) {
							acumulador +=1;
						}
					}
				}	
				if (acumulador==3) {
					mat[i][j] = Aleatorio.nextInt(9);
				}
			} while(acumulador==3);
		}	
	}
	/*for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				System.out.print(mat[i][j]+ " ");
			}
			System.out.println("");
		}*/
}	
}

