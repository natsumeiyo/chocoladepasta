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
		Collection<ToolAktie> tools = maakToolAkties();
		Collection<ControlAktie> controls = maakControlAkties();

		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(canvas, BorderLayout.CENTER);
		c.add(maakToolBox(tools), BorderLayout.WEST);
		c.add(maakMenuBar(tools, controls), BorderLayout.NORTH);
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

	private Collection<ToolAktie> maakToolAkties() {
		currentTool = new PenTool();

		LinkedList<ToolAktie> result;
		result = new LinkedList<ToolAktie>();
		result.add(new ToolAktie(this, "Pen", "Vrije pentekening", currentTool,
				getImageIcon("pen.gif")));
		result.add(new ToolAktie(this, "Lijn", "Lijntekening", new LijnTool()));
		result.add(new ToolAktie(this, "Open rect", "Open rechthoek",
				new RectTool(false)));
		result.add(new ToolAktie(this, "Fill rect", "Gevulde rechthoek",
				new RectTool(true)));
		result.add(new ToolAktie(this, "Open oval", "Open ovaal",
				new OvalTool(false)));
		result.add(new ToolAktie(this, "Fill oval", "Gevulde ovaal",
				new OvalTool(true)));
		result.add(new ToolAktie(this, "Tekst", "Tekst", new TekstTool()));
		result.add(new ToolAktie(this, "Gum", "Uitgummen van de tekening",
				new GumTool(), getImageIcon("gum.gif")));
		return result;
	}

	private Collection<ControlAktie> maakControlAkties() {
		LinkedList<ControlAktie> result;
		result = new LinkedList<ControlAktie>();
		result.add(new ControlAktie(canvas, "Clear", "Tekening wissen"));
		result.add(new ControlAktie(canvas, "Rotate", "Tekening draaien"));
		return result;
	}

	private Component maakControlPanel(Collection<ControlAktie> controls) {
		JPanel controlPanel = new JPanel();

		JToolBar toolbar = new JToolBar(JToolBar.HORIZONTAL);
		toolbar.setFloatable(false);
		for (Action act : controls)
			toolbar.add(act);
		controlPanel.add(toolbar);

		controlPanel.add(Box.createHorizontalStrut(20));
		controlPanel.add(new JLabel("Penkleur"));
		JComboBox combo = new JComboBox();
		combo.addItem(new Kleur("zwart", Color.BLACK));
		combo.addItem(new Kleur("wit", Color.WHITE));
		combo.addItem(new Kleur("rood", Color.RED));
		combo.addItem(new Kleur("groen", Color.GREEN));
		combo.addItem(new Kleur("blauw", Color.BLUE));
		combo.addItemListener(this);
		controlPanel.add(combo);

		return controlPanel;
	}

	private Component maakMenuBar(Collection<ToolAktie> tools,
			Collection<ControlAktie> controls) {
		JMenuBar menubar = new JMenuBar();
		JMenu menu;

		menu = new JMenu("Tool");
		for (Action tool : tools)
			menu.add(tool);
		menubar.add(menu);

		menu = new JMenu("Edit");
		for (Action ctrl : controls)
			menu.add(ctrl);
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
//		this.currentTool.muisLosgelaten(canvas, e.getPoint());
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