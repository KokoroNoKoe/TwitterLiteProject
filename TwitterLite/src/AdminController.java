import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController implements ActionListener{
    private static AdminController instance = null;

    private AdminControlPanel adminControlPanel;

    private final String OPEN_USER_VIEW_BUTTON = "Open User View";


    public AdminController() {
        System.out.println("Admin controller");
        adminControlPanel = AdminControlPanel.getInstance();
        adminControlPanel.setController(this);

    }





    public void openUserView(String id) {

    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        String source = e.getActionCommand();


        if(source.equals(OPEN_USER_VIEW_BUTTON)){
            new UserPanel();
        }




    }


    //Singleton
    public static AdminController getInstance(){
        if(instance == null)
            return new AdminController();
        return instance;
    }

}
