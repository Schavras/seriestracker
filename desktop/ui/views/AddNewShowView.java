package ui.views;

import presenter.AddNewShowPresenter;

public interface AddNewShowView extends View {
	
	String getID();
	
	void setAddNewShowPresenter(AddNewShowPresenter presenter);
	
	void searchByID();
	
	void addShow();
	
}
