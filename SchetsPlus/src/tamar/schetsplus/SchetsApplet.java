package tamar.schetsplus;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.net.URL;
import javax.swing.*;


public class SchetsApplet extends JApplet implements MouseListener,
		MouseMotionListener, ItemListener, KeyListener {
	SchetsCanv canvas;
	Tool currentTool;
	boolean isDeelVanApplicatie;
	ColorIcon colorIcon;

	public SchetsApplet() {
		this(false);
	}

	SchetsApplet(boolean app) {
		this.isDeelVanApplicatie = app;
		if (app)
			this.init();
	}

	public void init() {
		canvas = new SchetsCanv();
		colorIcon = new ColorIcon(canvas.getPenkleur());
		Collection<FileAction> files = createFileActions();
		Collection<ToolAktie> tools = maakToolAkties();
		Collection<Action> controls = maakControlAkties();

		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(canvas, BorderLayout.CENTER);
		c.add(maakToolBox(tools), BorderLayout.WEST);
		c.add(maakMenuBar(files, tools, controls), BorderLayout.NORTH);
		c.add(maakControlPanel(controls), BorderLayout.SOUTH);

		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
		canvas.addKeyListener(this);

	}

	public void setCurrentTool(Tool tool) {
		currentTool = tool;
	}

	private ImageIcon getImageIcon(String filename) {
		try {
			if (isDeelVanApplicatie) {
				return new ImageIcon(getClass().getResource(filename));
			} else {
				return new ImageIcon(new URL(this.getCodeBase(), filename));
			}
		} catch (Exception e) {
			return null;
		}
	}

	private Collection<FileAction> createFileActions() {
		LinkedList<FileAction> result;
		result = new LinkedList<FileAction>();
		result.add(new FileAction(canvas, "Save", "Save file to disk"));
		result.add(new FileAction(canvas, "Open", "Open file from disk"));
		return result;		
	}

	private Collection<ToolAktie> maakToolAkties() {
		currentTool = new PenTool();

		LinkedList<ToolAktie> result;
		result = new LinkedList<ToolAktie>();
		result.add(new ToolAktie(this, "Pen", "Draw", currentTool,
				getImageIcon("pen.gif")));
		result.add(new ToolAktie(this, "Line", "Line", new LijnTool()));
		result.add(new ToolAktie(this, "Outlined rectangle", "Outlined rectangle",
				new RectTool(false)));
		result.add(new ToolAktie(this, "Outlined oval", "Outlined oval",
				new OvalTool(false)));
		result.add(new ToolAktie(this, "Filled rectangle", "Filled rectangle",
				new RectTool(true)));
		result.add(new ToolAktie(this, "Filled oval", "Filled oval",
				new OvalTool(true)));
		result.add(new ToolAktie(this, "Tekst", "Tekst", new TekstTool()));
		result.add(new ToolAktie(this, "Eraser", "Delete an element",
				new GumTool(), getImageIcon("gum.gif")));
		return result;
	}


	private Collection<Action> maakControlAkties() {
		LinkedList<Action> result;
		result = new LinkedList<Action>();
		result.add(new ClearAction(canvas));
		result.add(new ColorAction(this, colorIcon));
		return result;
	}

	private Component maakControlPanel(Collection<Action> controls) {
		JPanel controlPanel = new JPanel();

		JToolBar toolbar = new JToolBar(JToolBar.HORIZONTAL);
		toolbar.setFloatable(false);
		for (Action act : controls)
			toolbar.add(act);
		controlPanel.add(toolbar);
		return controlPanel;
	}

	private Component maakMenuBar(Collection<FileAction> files, Collection<ToolAktie> tools,
			Collection<Action> controls) {
		JMenuBar menubar = new JMenuBar();
		JMenu menu;
		
		menu = new JMenu("File");
		for (Action fileAction : files) {
			menu.add(fileAction);
		}
		menubar.add(menu);

		menu = new JMenu("Tool");
		for (Action tool : tools) {
			menu.add(tool);
		}
		menubar.add(menu);

		menu = new JMenu("Edit");
		for (Action ctrl : controls) {
			menu.add(ctrl);
		}
		menubar.add(menu);

		menu = new JMenu("Help");
		menu.add(new AboutAktie());
		menubar.add(menu);

		return menubar;
	}

	private Component maakToolBox(Collection<ToolAktie> tools) {
		Box toolbox = new Box(BoxLayout.Y_AXIS);
		for (Action act : tools) {
			JButton button = new JButton((Icon) act.getValue(Action.DEFAULT));
			button.setToolTipText((String) act
					.getValue(Action.SHORT_DESCRIPTION));
			button.addActionListener(act);
			toolbox.add(button);
		}
		toolbox.add(Box.createVerticalGlue());
		return toolbox;
	}

	public void mousePressed(MouseEvent e) {
		this.currentTool.muisIngedrukt(canvas, e.getPoint());
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
		this.currentTool.muisVersleept(canvas, e.getPoint());
	}

	public void mouseClicked(MouseEvent e) {
		canvas.requestFocus();
	}

	public void itemStateChanged(ItemEvent event) {
		Object item = event.getItem();
		if (item instanceof Kleur)
			canvas.setPenkleur(((Kleur) item).getKleur());
	}

	public void keyTyped(KeyEvent e) {
		this.currentTool.letterIngetikt(canvas, (char) e.getKeyChar());
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
	}

	private static final long serialVersionUID = 1;
}