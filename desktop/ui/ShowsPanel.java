package ui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Scrollable;

public class ShowsPanel extends JPanel implements Scrollable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7433869253245978796L;
	
	static int height = 0;
	public ArrayList<CustomShowComponent> shows;
	
	public ShowsPanel(ArrayList<CustomShowComponent> Tshows) {
		height = 0;
		shows = Tshows;
		setLayout(null);
		CustomShowComponent temp;
		for (int i = 0; i < shows.size(); i++){
			temp = shows.get(i);
			temp.setLocation(0, height);
			add(temp);
			height+=temp.getHeight();
			//System.out.println(i);
		}
		
		setSize(new Dimension(600, height));
		
		
	}
	
	@Override
	public Dimension getPreferredScrollableViewportSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getScrollableBlockIncrement(Rectangle visibleRect,
			int orientation, int direction) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getScrollableTracksViewportHeight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getScrollableTracksViewportWidth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getScrollableUnitIncrement(Rectangle visibleRect,
			int orientation, int direction) {
		// TODO Auto-generated method stub
		return 0;
	}


}
