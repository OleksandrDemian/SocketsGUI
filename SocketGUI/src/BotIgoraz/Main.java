package BotIgoraz;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;

public class Main {

	Button btnOff,btnOn;
	List list;
	Bot b;
	Main main = this;
	
	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(492, 423);
		shell.setText("SWT Application");
		
		btnOn = new Button(shell, SWT.NONE);
		btnOn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				b = new Bot(main);
				b.start();
				btnOff.setEnabled(true);
				btnOn.setEnabled(false);
			}
		});
		btnOn.setBounds(10, 10, 200, 75);
		btnOn.setText("ON");
		
		btnOff = new Button(shell, SWT.NONE);
		btnOff.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void widgetSelected(SelectionEvent e) {
				b.stop();
				btnOn.setEnabled(true);
				btnOff.setEnabled(false);
			}
		});
		btnOff.setEnabled(false);
		btnOff.setText("OFF");
		btnOff.setBounds(10, 91, 200, 75);
		
		list = new List(shell, SWT.BORDER);
		list.setBounds(216, 10, 250, 365);

	}
	
	public void putList(String message){
		Display.getDefault().asyncExec(new Runnable(){
			public void run(){
				list.add(message);
			}
		});
	}
}
