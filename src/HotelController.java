import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class HotelController {

	//have private model var
	HotelView view;
	
	public HotelController() {
		//initialize model
	}
/*	
	public void toInitial() {
		currentPanel = new ScreenInitial();
	}

	
	public void toGuestOptions() {
		currentPanel = new ScreenGuestOptions();
	}

	public void toMakeRes() {
		//use info from model; update panel whenever day is changed
		currentPanel = new ScreenMakeRes();
	}

	public void toManager() {
		currentPanel = new ScreenManager();
	}

	public void toManagerView() {
		currentPanel = new ScreenManagerView();
	}

	public void toReceiptOptions() {
		currentPanel = new ScreenReceiptOptions();
	}

	public void toReceipt() {
		currentPanel = new ScreenReceipt();
		// output will depend on "Simple" or "Comprehensive" format
	}
	
	public void toReservations() {
		currentPanel = new ScreenReservations();
		// get reservations from model
	}

	public void toUserID() {
		currentPanel = new ScreenUserID();
		// get userID from text field, put into model
	}
	
	public void toVacancies() {
		currentPanel = new ScreenVacancies();
		// get vacancies from model
	}
*/
	public ActionListener changeScreen(JPanel jp) {
		return new
				ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				updateView(jp);
			}
		};
	}
	
	
	private void updateView(JPanel jp) {
		view.changePanel(jp);
	}


}
