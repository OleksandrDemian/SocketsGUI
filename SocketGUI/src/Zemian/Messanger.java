package Zemian;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Messanger extends Shell {
	private Text message;
	private Text txtLab;
	private Utente utente = new Utente();
	private Server server;
	
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
		
		server = new Server();
		
		List list = new List(this, SWT.BORDER);
		list.setBounds(170, 10, 414, 383);
		
		message = new Text(this, SWT.BORDER);
		message.setBounds(170, 399, 333, 25);
		
		Button btnSend = new Button(this, SWT.NONE);
		btnSend.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		btnSend.setBounds(509, 397, 75, 25);
		btnSend.setText("Send");
		
		List allChats = new List(this, SWT.BORDER);
		allChats.setBounds(10, 10, 154, 356);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Chat c = new Chat(txtLab.getText());
				server.addReceiver(c);
			}
		});
		btnNewButton.setBounds(10, 399, 154, 25);
		btnNewButton.setText("Start chat");
		
		txtLab = new Text(this, SWT.BORDER);
		txtLab.setText("Lab06_");
		txtLab.setBounds(10, 372, 154, 21);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(610, 477);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
