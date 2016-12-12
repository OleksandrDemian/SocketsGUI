package Zemian;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class Messanger extends Shell implements IMessageReceiver {
	private Text text;
	private String otherHost = "";

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Messanger shell = new Messanger(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Messanger(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		List list = new List(this, SWT.BORDER);
		list.setBounds(10, 10, 414, 383);
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(10, 399, 333, 25);
		
		Button btnSend = new Button(this, SWT.NONE);
		btnSend.setBounds(349, 399, 75, 25);
		btnSend.setText("Send");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 477);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	@Override
	public void receive(String from, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHost(String host) {
		// TODO Auto-generated method stub
		
	}
}
