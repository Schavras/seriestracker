package ui;

import presenter.AddNewShowPresenter;
import ui.views.AddNewShowView;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import buttons.IconButton;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class AddNewShowUI extends DefaultJPanel implements AddNewShowView {
	private AddNewShowPresenter presenter;
	private JTextField idTF;
	private JTextField textField;
	JLabel sName;
	JLabel poster;
	IconButton addShowBtn ;
	boolean hasResult = false;
	
	public AddNewShowUI() {
		
		poster = new JLabel();
		poster.setBounds(10, 10, 240, 400);
		add(poster);
		
		idTF = new JTextField();
		idTF.setBounds(284, 83, 110, 20);
		add(idTF);
		idTF.setColumns(10);
		
		JLabel lblSearchByImdb = new JLabel("Search By IMDB ID");
		lblSearchByImdb.setBounds(284, 58, 110, 14);
		add(lblSearchByImdb);
		
		JButton btnIDSearch = new JButton("Search");
		btnIDSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchByID();
			}
		});
		btnIDSearch.setBounds(284, 114, 110, 23);
		add(btnIDSearch);
		
		/*textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(449, 83, 208, 20);
		add(textField);
		
		JLabel lblSearchByName = new JLabel("Search By Name");
		lblSearchByName.setBounds(449, 58, 110, 14);
		add(lblSearchByName);*/
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(288, 178, 46, 14);
		add(lblName);
		
		sName = new JLabel();
		sName.setBounds(371, 178, 176, 14);
		add(sName);
		
		addShowBtn = new IconButton("resources//buttons//addShowIcon.png");
		addShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addShow();
			}
		});
		addShowBtn.setBounds(10, 421, 240, 50);
		addShowBtn.setVisible(hasResult);
		add(addShowBtn);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				revalidate();
				close();
			}
		});
		btnBack.setBounds(1140, 644, 110, 50);
		add(btnBack);
	}

	@Override
	public void setAddNewShowPresenter(AddNewShowPresenter presenter) {
		this.presenter = presenter;
		
	}

	@Override
	public String getID() {
		return idTF.getText();
	}

	@Override
	public void searchByID() {
		
		hasResult = presenter.searchById(getID());
		showInfo();
		showAddButton();
	}
	
	private void showInfo(){
		sName.setText(presenter.showName());
		poster.setIcon(new ImageIcon(presenter.showPoster()));
	}
	
	private void showAddButton(){
		addShowBtn.setVisible(hasResult);
	}

	@Override
	public void addShow() {
		MainUI.stFrame.validate();
		presenter.addShow();
		close();
		
	}
}
