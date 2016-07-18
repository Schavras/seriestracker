package ui;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import javax.swing.JButton;

import ui.services.CustomShowComponentGenerator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomShowComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4771304833766568938L;
	
	BufferedImage image = null;
	JLabel title;
	JLabel lblNextepisode;
	
	public CustomShowComponent(String id) {
		
		final CustomShowComponentGenerator cscg = new CustomShowComponentGenerator(id);
		
		setLayout(null);
		setSize(new Dimension(900, 100));
		
		title = new JLabel(cscg.getTitle());
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		title.setBounds(72, 11, 235, 33);
		add(title);

		lblNextepisode = new JLabel(cscg.getNextEpisode());
 		lblNextepisode.setBounds(70, 53, 493, 14);
 		add(lblNextepisode);
 		

        JLabel lblNewLabel = new JLabel(new ImageIcon(cscg.getPoster()));
 		lblNewLabel.setBounds(10, 11, 52, 78);
 		add(lblNewLabel);
 		
 		JButton btnNewButton = new JButton("Next Episode");
 		btnNewButton.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				cscg.watchNextEpisode();
 				lblNextepisode.setText(cscg.getNextEpisode());
 			}
 		});
 		btnNewButton.setBounds(680, 7, 111, 82);
 		add(btnNewButton);
 		
 		JButton btnNewButton_1 = new JButton("Info");
 		btnNewButton_1.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent arg0) {
 				//lblNextepisode.setText(cscg.getNextEpisode());
 			}
 		});
 		btnNewButton_1.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 			}
 		});
 		btnNewButton_1.setBounds(801, 7, 89, 82);
 		add(btnNewButton_1);
 		
 		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomShowComponent [title=" + title + "]";
	}
}
