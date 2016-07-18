package presenter;

import ui.views.MainScreenView;

public class MainScreenPresenter {

	MainScreenView view;
	
	
	public MainScreenPresenter(MainScreenView view){
		this.view = view;
	}
	
	public void start(){
		view.setMainScreenPresenter(this);
		view.open();
	}
	
	
}
