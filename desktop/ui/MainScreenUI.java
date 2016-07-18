package ui;

import presenter.AddNewShowPresenter;
import presenter.MainScreenPresenter;
import ui.views.MainScreenView;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class MainScreenUI extends DefaultJPanel implements MainScreenView{
	
	MainScreenPresenter presenter;
	CustomShowList showList;
	JPanel panel;
	
	public MainScreenUI() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "My Shows", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(43, 11, 922, 623);
		add(panel);
		panel.setLayout(null);
		
		showList = new CustomShowList();
		showList.setBounds(6, 16, 910, 600);
		panel.add(showList);
		
		JButton button = new JButton("+");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				addShow();
			}
		});
		button.setBounds(50, 640 , 50, 50);
		add(button);
		
		JButton refreshBtn = new JButton("Refresh");
		refreshBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.remove(showList);
				showList = new CustomShowList();
				showList.setBounds(6, 16, 910, 600);
				panel.add(showList);
				revalidate();
				repaint();
			}
		});
		refreshBtn.setBounds(120, 650, 90, 25);
		add(refreshBtn);
		
	}

	private void addShow() {
		AddNewShowUI add = new AddNewShowUI();
		AddNewShowPresenter presenter = new AddNewShowPresenter(add);
		presenter.start();
	}
	
	@Override
	public void setMainScreenPresenter(MainScreenPresenter presenter) {
		this.presenter = presenter;
		
	}
}
