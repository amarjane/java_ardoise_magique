import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;


public class Fenetre extends JFrame {

	private static final long serialVersionUID = 8164118974463460991L;

	private JPanel panel = new JPanel();
	private Panneau panneau = new Panneau();
	private int diff = 10;
	
	// ToolBar
	
	private JToolBar toolBar = new JToolBar();
	
	private JButton carreTool = new JButton(new ImageIcon("images/carre.png"));
	private JButton rondTool = new JButton(new ImageIcon("images/rond.png"));
	private JButton triangleTool = new JButton(new ImageIcon("images/triangle.png"));
	
	private JButton rougeTool = new JButton(new ImageIcon("images/rouge.png"));
	private JButton bleuTool = new JButton(new ImageIcon("images/bleu.png"));
	private JButton vertTool = new JButton(new ImageIcon("images/vert.png"));
	private JButton blancTool = new JButton(new ImageIcon("images/blanc.png"));
	private JButton cyanTool = new JButton(new ImageIcon("images/cyan.png"));
	private JButton grisTool = new JButton(new ImageIcon("images/gris.png"));
	private JButton jauneTool = new JButton(new ImageIcon("images/jaune.png"));
	private JButton marronTool = new JButton(new ImageIcon("images/marron.png"));
	private JButton orangeTool = new JButton(new ImageIcon("images/orange.png"));
	private JButton roseTool = new JButton(new ImageIcon("images/rose.png"));
	private JButton violetTool = new JButton(new ImageIcon("images/violet.png"));
	private JButton noirTool = new JButton(new ImageIcon("images/noir.png"));
	
	private ArrayList<JButton> buttonColor = new ArrayList<JButton>();
	
	private JButton plusTool = new JButton(new ImageIcon("images/plus.png"));
	private JButton minusTool = new JButton(new ImageIcon("images/minus.png"));
	private JButton gommeTool = new JButton(new ImageIcon("images/gomme.png"));
	
	// Menu
	
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu fichier = new JMenu("Fichier");
	private JMenu edition = new JMenu("Edition");
	
	private JMenuItem effacer = new JMenuItem("Effacer");
	private JMenuItem quitter = new JMenuItem("Quitter");
	
	private JMenu form = new JMenu("Forme du pointeur");
	private JMenu couleur = new JMenu("Couleur du pointeur");
	private JMenu sizeMenu = new JMenu("Taille du pointeur");
	
	private JMenuItem rondMenu = new JMenuItem("Rond");
	private JMenuItem carreMenu = new JMenuItem("Carré");
	private JMenuItem triangleMenu = new JMenuItem("Triangle");
	
	private JMenuItem rougeMenu = new JMenuItem("Rouge");
	private JMenuItem vertMenu = new JMenuItem("Vert");
	private JMenuItem bleuMenu = new JMenuItem("Bleu");
	private JMenuItem blancMenu = new JMenuItem("Blanc");
	private JMenuItem cyanMenu = new JMenuItem("Cyan");
	private JMenuItem grisMenu = new JMenuItem("Gris");
	private JMenuItem jauneMenu = new JMenuItem("Jaune");
	private JMenuItem marronMenu = new JMenuItem("Marron");
	private JMenuItem orangeMenu = new JMenuItem("Orange");
	private JMenuItem roseMenu = new JMenuItem("Rose");
	private JMenuItem violetMenu = new JMenuItem("Violet");
	private JMenuItem noirMenu = new JMenuItem("Noir");
	
	private ArrayList<JMenuItem> menuItemColor = new ArrayList<JMenuItem>();
	
	private JMenuItem plusMenu = new JMenuItem("Agrandir");
	private JMenuItem minusMenu = new JMenuItem("Rétrécir");
	
	// Constructor
	
	public Fenetre() {
		
		this.initList();
		this.initMenu();
		this.initTool();
		this.initPanel();
		this.initAction();

		this.setTitle("Ardoise Magique de Papa pour Sarah");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
	}
	
	// initialisation of Components
	
	private void initList() {
		
		this.buttonColor.add(this.rougeTool);
		this.buttonColor.add(this.bleuTool);
		this.buttonColor.add(this.vertTool);
		this.buttonColor.add(this.blancTool);
		this.buttonColor.add(this.cyanTool);
		this.buttonColor.add(this.grisTool);
		this.buttonColor.add(this.jauneTool);
		this.buttonColor.add(this.marronTool);
		this.buttonColor.add(this.noirTool);
		this.buttonColor.add(this.orangeTool);
		this.buttonColor.add(this.roseTool);
		this.buttonColor.add(this.violetTool);
		
		this.menuItemColor.add(this.rougeMenu);
		this.menuItemColor.add(this.bleuMenu);
		this.menuItemColor.add(this.vertMenu);
		this.menuItemColor.add(this.blancMenu);
		this.menuItemColor.add(this.cyanMenu);
		this.menuItemColor.add(this.grisMenu);
		this.menuItemColor.add(this.jauneMenu);
		this.menuItemColor.add(this.marronMenu);
		this.menuItemColor.add(this.noirMenu);
		this.menuItemColor.add(this.orangeMenu);
		this.menuItemColor.add(this.roseMenu);
		this.menuItemColor.add(this.violetMenu);
		
	}
	
	private void initMenu() {
		
		// Mnemonics
		
		this.fichier.setMnemonic('F');
		this.edition.setMnemonic('E');
		this.form.setMnemonic('o');
		this.carreMenu.setMnemonic('C');
		
		// Accelerator
		
		this.effacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		this.quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
		
		// Adding
		
		this.form.add(this.rondMenu);
		this.form.add(this.carreMenu);
		this.form.add(this.triangleMenu);
		
		for(JMenuItem jmi : this.menuItemColor) {
			
			this.couleur.add(jmi);
			
		}
		
		this.sizeMenu.add(this.plusMenu);
		this.sizeMenu.add(this.minusMenu);
		
		this.fichier.add(this.effacer);
		this.fichier.addSeparator();
		this.fichier.add(this.quitter);
		
		this.edition.add(this.form);
		this.edition.addSeparator();
		this.edition.add(this.couleur);
		this.edition.addSeparator();
		this.edition.add(this.sizeMenu);
		
		this.menuBar.add(this.fichier);
		this.menuBar.add(this.edition);
		this.setJMenuBar(this.menuBar);	
		
	}

	private void initTool() {
		
		// adding
		
		this.toolBar.add(this.carreTool);
		this.toolBar.add(this.rondTool);
		this.toolBar.add(this.triangleTool);
		
		this.toolBar.addSeparator();
				
		for(JButton b : this.buttonColor) {
			this.toolBar.add(b);
		}
		
		this.toolBar.addSeparator();
		
		this.toolBar.add(this.plusTool);
		this.toolBar.add(this.minusTool);
		this.toolBar.add(this.gommeTool);		
		
		// background
		
		this.carreTool.setBackground(Color.WHITE);
		this.rondTool.setBackground(Color.WHITE);
		this.rougeTool.setBackground(Color.WHITE);
		this.bleuTool.setBackground(Color.WHITE);
		this.vertTool.setBackground(Color.WHITE);
		
	}
	
	private void initPanel() {
		
		this.panel.setLayout(new BorderLayout());
		this.panel.add(this.toolBar, BorderLayout.NORTH);		
		this.panel.add(this.panneau, BorderLayout.CENTER);
		this.setContentPane(this.panel);

	}

	private void initAction() {
			
		this.effacer.addActionListener(new EffacerAction());
		this.quitter.addActionListener(new QuitterAction());
		
		this.carreMenu.addActionListener(new FormAction());
		this.rondMenu.addActionListener(new FormAction());
		this.triangleMenu.addActionListener(new FormAction());
		
		this.carreTool.addActionListener(new FormAction());
		this.rondTool.addActionListener(new FormAction());
		this.triangleTool.addActionListener(new FormAction());
		
		for(JMenuItem jmi : this.menuItemColor) {
			
			jmi.addActionListener(new ColorAction());
			
		}
	
		for(JButton b : this.buttonColor) {
		
			b.addActionListener(new ColorAction());
		
		}
		
		this.plusTool.addActionListener(new SizeAction());
		this.minusTool.addActionListener(new SizeAction());
		this.gommeTool.addActionListener(new GommeAction());
		
		this.plusMenu.addActionListener(new SizeAction());
		this.minusMenu.addActionListener(new SizeAction());
	}
			
	public JMenu getSizeMenu() {
		return sizeMenu;
	}

	public void setSizeMenu(JMenu sizeMenu) {
		this.sizeMenu = sizeMenu;
	}

	class EffacerAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			panneau.setErase(true);
			panneau.repaint();	
		}	
	}
	
	class QuitterAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.exit(0);
			
		}
	}

	class ColorAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			panneau.setGommage(false);
			
			if (e.getSource().getClass().getName().equals("javax.swing.JMenuItem")) {
			
				if (e.getSource() == rougeMenu)
					panneau.setCouleur(Color.RED);
				else if (e.getSource() == vertMenu)
					panneau.setCouleur(Color.GREEN);
				else if (e.getSource() == bleuMenu)
					panneau.setCouleur(Color.BLUE);
				else if (e.getSource() == blancMenu)
					panneau.setCouleur(Color.WHITE);
				else if (e.getSource() == cyanMenu)
					panneau.setCouleur(Color.CYAN);
				else if (e.getSource() == grisMenu)
					panneau.setCouleur(Color.GRAY);
				else if (e.getSource() == jauneMenu)
					panneau.setCouleur(Color.YELLOW);
				else if (e.getSource() == marronMenu)
					panneau.setCouleur(new Color(165,42,42));
				else if (e.getSource() == noirMenu)
					panneau.setCouleur(Color.BLACK);
				else if (e.getSource() == orangeMenu)
					panneau.setCouleur(Color.ORANGE);
				else if (e.getSource() == roseMenu)
					panneau.setCouleur(Color.PINK);
				else 
					panneau.setCouleur(new Color(148,0,211));
			
			}
		
			if (e.getSource().getClass().getName().equals("javax.swing.JButton")) {
			
				if (e.getSource() == rougeTool)
					panneau.setCouleur(Color.RED);
				else if (e.getSource() == vertTool)
					panneau.setCouleur(Color.GREEN);
				else if (e.getSource() == bleuTool)
					panneau.setCouleur(Color.BLUE);
				else if (e.getSource() == blancTool)
					panneau.setCouleur(Color.WHITE);
				else if (e.getSource() == cyanTool)
					panneau.setCouleur(Color.CYAN);
				else if (e.getSource() == grisTool)
					panneau.setCouleur(Color.GRAY);
				else if (e.getSource() == jauneTool)
					panneau.setCouleur(Color.YELLOW);
				else if (e.getSource() == marronTool)
					panneau.setCouleur(new Color(165,42,42));
				else if (e.getSource() == noirTool)
					panneau.setCouleur(Color.BLACK);
				else if (e.getSource() == orangeTool)
					panneau.setCouleur(Color.ORANGE);
				else if (e.getSource() == roseTool)
					panneau.setCouleur(Color.PINK);
				else 
					panneau.setCouleur(new Color(148,0,211));
			
			}
		}		
	}
	
	class FormAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			panneau.setGommage(false);
			
			if (e.getSource().getClass().getName().equals("javax.swing.JMenuItem")) {
				
				if (e.getSource() == carreMenu)
					panneau.setForm("CARRE");
				else if (e.getSource() == rondMenu)
					panneau.setForm("ROND");
				else
					panneau.setForm("TRIANGLE");
			
			}
		
			if (e.getSource().getClass().getName().equals("javax.swing.JButton")) {
				
				if (e.getSource() == carreTool)
					panneau.setForm("CARRE");
				else if (e.getSource() == rondTool)
					panneau.setForm("ROND");
				else
					panneau.setForm("TRIANGLE");
			
			}
		}		
	}
	
	
	class SizeAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {	
			panneau.setGommage(false);

			if (e.getSource().getClass().getName().equals("javax.swing.JMenuItem")) {
				if (e.getSource() == plusMenu) {
					
					panneau.setSizePoint(panneau.getSizePoint() + diff);
				
				} else {
				
					panneau.setSizePoint(panneau.getSizePoint() - diff);
				
				}
			}
		
			if (e.getSource().getClass().getName().equals("javax.swing.JButton")) {	
				if (e.getSource() == plusTool) {
				
					panneau.setSizePoint(panneau.getSizePoint() + diff);
				
				} else {
				
					panneau.setSizePoint(panneau.getSizePoint() - diff);
				
				}
				
			}	
				
			if (panneau.getSizePoint() > 100) {
				
				panneau.setSizePoint(100);
			
			} else if (panneau.getSizePoint() <= 10) {
			
				panneau.setSizePoint(10);
			
			}
		}		
	}
	
	class GommeAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			panneau.setGommage(true);
			
		}
	
	}
}
