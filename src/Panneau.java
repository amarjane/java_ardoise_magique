import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;


public class Panneau extends JPanel{

	private static final long serialVersionUID = 7927346508983668566L;
	
	private int posX = -10;
	private int posY = -10;
	private int sizePoint = 10;
	
	private String form = "ROND";
	
	private Color couleur = Color.BLUE;
	
	private ArrayList<Point> points = new ArrayList<Point> ();
	
	private boolean erase = true;
	private boolean gommage = false;
	
	public Panneau() {
		
		this.addMouseMotionListener(new PanneauMotionAction());
		this.addMouseListener(new PanneauAction());
				
	}
	
	public void gommer(int x, int y) {
		
		Iterator<Point> iter = this.points.iterator();
		
		while (iter.hasNext()) {
			Point p = iter.next();
			if(
				p.getX() <= x &&
				x <= p.getX() + p.getWidth() &&
				p.getY() <= y &&
				y <= p.getY() + p.getHeight()
			){
				
				iter.remove();
				
			}			
		}
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());	
		
		if (this.erase) {
			
			this.erase = false;
			this.points.clear();
			
		} else {
			
			for(Point p : this.points){
				
				g.setColor(p.getColor());
				
				if (p.getForm() == "ROND") {
					
					g.fillOval(p.getX(), p.getY(), p.getWidth(), p.getHeight());	
				
				}
	
				if (p.getForm() == "CARRE") {
					
					g.fillRect(p.getX(), p.getY(), p.getWidth(), p.getHeight());	
				
				}
				
				if (p.getForm() == "TRIANGLE") {
					
					int X[] = {p.getX() + p.getWidth()/2, p.getX() + p.getWidth(), p.getX()};
					int Y[] = {p.getY(), p.getY() + p.getHeight(), p.getY() + p.getHeight()};
					g.fillPolygon(X, Y, 3);
				
				}
				
			}
		}
	}
	
	class PanneauMotionAction extends MouseMotionAdapter {
		
		public void mouseDragged(MouseEvent e) {
			if(!gommage) {
				
				points.add(new Point(
					e.getX(), 
					e.getY(), 
					sizePoint, 
					sizePoint, 
					couleur,
					form
				));
				
			} else {
				
				gommer(e.getX(), e.getY());
				
			}
			
			repaint();
		}
		
		public void mouseMoved(MouseEvent e) {
			
			
		}
		
	}
	
	class PanneauAction extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			if(!gommage) {
				
				points.add(new Point(
					e.getX(), 
					e.getY(), 
					sizePoint, 
					sizePoint, 
					couleur,
					form
				));
				
			} else {
				
				gommer(e.getX(), e.getY());
				
			}
			
			repaint();
		}
			
		public void mouseDragged(MouseEvent e) {}
		
		public void mouseEntered(MouseEvent e) {}
		
		public void mouseExited(MouseEvent e) {}
		
		public void mouseMoved(MouseEvent e) {}
		
		public void mousePressed(MouseEvent e) {
			if(!gommage) {
				
				points.add(new Point(
					e.getX(), 
					e.getY(), 
					sizePoint, 
					sizePoint, 
					couleur,
					form
				));
				
			} else {
				
				gommer(e.getX(), e.getY());
				
			}
			
			repaint();
		}
		
		public void mouseReleased(MouseEvent e) {}
		
		public void mouseWheelMoved(MouseWheelEvent e) {}
		
	}

	public Color getCouleur() {
		return this.couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public String getForm() {
		return this.form;
	}

	public void setForm(String form) {
		this.form = form;
	}
	
	public int getPosX() {
		return this.posX;
	}

	public void setPosX(int x) {
		this.posX = x;
	}
	
	public int getPosY() {
		return this.posY;
	}

	public void setPosY(int y) {
		this.posY = y;
	}
	
	public ArrayList<Point> getPoints() {
		return this.points;
	}

	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}
	
	public boolean getErase() {
		return this.erase;		
	}
	public void setErase(boolean b) {
		this.erase = b;
	}

	public int getSizePoint() {
		return sizePoint;
	}

	public void setSizePoint(int sizePoint) {
		this.sizePoint = sizePoint;
	}

	public boolean getGommage() {
		return gommage;
	}

	public void setGommage(boolean gommage) {
		this.gommage = gommage;
	}
	
}
