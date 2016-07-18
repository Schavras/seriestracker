package ui;

import javax.swing.JPanel;

import ui.views.View;
import java.awt.Color;

/**
 * The basic JPanel. Every UI is based on this class.
 * Implements the open() and close() methods, 
 * for displaying next or previous scene.
 *
 */
public class DefaultJPanel extends JPanel implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3476395543957132870L;
	
	public DefaultJPanel(){
		this.setBounds(100, 100, 1280, 720);
		setLayout(null);
	}
	
	/**
	 * Called to show the next scene. 
	 * The JPanel, which is gonna show, is added into 
	 * the parent Panel (  {@link MainUI#scenes scenes} )
	 * Then is shows the latest panel from
	 * {@link MainUI#cl Card Layout} list
	 */
	@Override
	public void open() {
		MainUI.scenes.add(this,this.toString());
		MainUI.cl.next(MainUI.scenes);
	}

	/**
	 *  Shows the previous panel from  {@link MainUI#cl Card Layout} list,
	 *  which is the previous screen
	 */
	@Override
	public void close() {
		MainUI.scenes.remove(this);
		MainUI.cl.previous(MainUI.scenes);
		
	}
	
	public void back(){
		MainUI.cl.previous(MainUI.scenes);
	}

	

}
