package ui.views;

/**
 * The basic interface of views
 */
public interface View {
    /**
     * Open the view, and display it's content
     */
    void open();
    
    /**
     * Close the view
     */
    void close();
    
    void back();

}