package Animacion;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;



public class Control_Animaciones {

	
	
	//numeroFrames es el numero total de frames
		//Empezar es el numero de frame desde el que se empieza
		//retrasarFrame belocidad de cambio de imagen
		public JFrame frame;
		public Graphics2D g2d;
		public Image imagen;
		public Point posicion;
		public Point velocidad;
		public double rotacion;
		public boolean visible;//si se ve la imagen
		public boolean invertir;
		
		public int numeroFrames, columnas, altoFrame, anchoFrame, contFrame,
				retrasarFrame, direccionFrame, empezar,posicionEmpezar,tiempo,tiempofin;
		public double moveranguloframe, caradelangulo;

		public Control_Animaciones (JFrame pantalla, Graphics2D graficos) {
			frame = pantalla;
			g2d = graficos;
			tiempo=0;
			tiempofin=0;
			
			setVisible(true);
			invertir = false;
			imagen = null;
			empezar = 0;
			posicion = new Point(0, 0);
			velocidad = new Point(0, 0);
			numeroFrames = 1;
			columnas = 1;
			altoFrame = 0;
			anchoFrame = 0;
			contFrame = 0;
			posicionEmpezar=0;

			retrasarFrame = 0;
			direccionFrame = 1;
			moveranguloframe = 0.0;
			caradelangulo = 0.0;
			rotacion = 0.0;
		}

		public JFrame getFrame() {
			return frame;
		}

		public Image getImagen() {
			return imagen;
		}

		public void setImagen(Image image) {
			imagen = image;
		}

		public void setGraficos(Graphics2D graficos) {
			g2d = graficos;
		}

		public Graphics2D getGraficos() {
			return g2d;
		}

		public int getWidth() {
			if (imagen != null) {
				return imagen.getWidth(frame);
			} else {
				return 0;
			}
		}

		public int getHeight() {
			if (imagen != null) {
				System.out.print(imagen.getHeight(frame));
				return imagen.getHeight(frame);
			} else
				return 0;
		}

		// metodo que devuelve la direccion de la imagen
		private URL getURL(String nombrebitmap) {
			URL url = null;
			try {
				url = this.getClass().getResource(nombrebitmap);
			} catch (Exception e) {
			}
			return url;
		}

		public Rectangle getRectangulo() {
			return (new Rectangle(posicion.x, posicion.y, altoFrame, anchoFrame));
		}

		public void cargar(String direccion, int _columnas, int totalframes,
				int altoframe, int anchoframe) {
			Toolkit tk = Toolkit.getDefaultToolkit();
			imagen = tk.getImage(getURL(direccion));
			while (imagen.getWidth(frame) <= 0);

			columnas = _columnas;
			numeroFrames = totalframes;
			altoFrame = altoframe;
			anchoFrame = anchoframe;

		}

		// metodo que hace la animacion actualizando la posicion de los frames y el
		// frame a mostrar
		private void actualizar() {
			// invertir la imagen
			if (invertir) {

			}

		

			if (numeroFrames > 1) {
				contFrame++;
				//(contFrame > retrasarFrame) controla el cambio de frame, cuando entra empezar se incrementa pasando al frame que este en la posicion que direccionFrame indique
				
				if (contFrame > retrasarFrame) {
					contFrame = 0;
					empezar += direccionFrame;

					if (empezar > numeroFrames - 1) {
						empezar = posicionEmpezar;

					} else if (empezar < 0) {
						empezar = numeroFrames - 1;
					}
				}

			
			}

		}

		public void rectangulo(Color c) {
			g2d.setColor(c);
			g2d.draw(getRectangulo());
		}

		// modificar metodo para poner los nombres de las variables correctamente
		public void dibujaSprite(boolean a,boolean b) {
			if(b){
			actualizar();}// Se le llama para actualizar la posicion y la imagen
			if(a){int framex = (empezar % columnas) * anchoFrame;// posicion x de el
															// frame en el
															// bitmap
			int framey = (empezar / columnas) * altoFrame;// posicion y de el
															// frame en el
															// bitmap

			g2d.drawImage(imagen, posicion.x, posicion.y, posicion.x + anchoFrame,
					posicion.y + altoFrame, framex, framey, framex + anchoFrame,
					framey + altoFrame, getFrame());}
		}

		public void setVisible(boolean _visible) {
			visible = _visible;
		}
		public boolean collidesWith(Rectangle rect) {
			return (rect.intersects(getRectangulo()));
			}
			//check for collision with another sprite
			public boolean collidesWith(Control_Animaciones sprite) {
			return (getRectangulo().intersects(sprite.getRectangulo()));
			}
			//check for collision with a point
			public boolean collidesWith(Point point) {
			return (getRectangulo().contains(point.x, point.y));
			
			}}
	
	

