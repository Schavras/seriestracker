package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import ui.services.CustomShowComponentGenerator;
import javax.swing.JButton;

public class CustomShowList extends JPanel{
	
	ArrayList <CustomShowComponent> shows ;
	ShowsPanel showList ;
	JScrollPane scrollPane;
	
	public CustomShowList() {
		setLayout(null);
		
		shows = CustomShowComponentGenerator.generateList();
		
		showList = new ShowsPanel(shows);
		showList.setPreferredSize(new Dimension(900,shows.size()*100));
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(showList);
		scrollPane.setBounds(0, 0, 910, 600);
		add(scrollPane);
	}	
	
	
	
	public void refresh(){
		
	}
}