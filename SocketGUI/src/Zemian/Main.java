package Zemian;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.widgets.List;

public class Main implements IMessageReceiver {

	protected Shell shlClient;
	private Text text;
	private Text txtLab;
	private Client client = new Client();
	private Server server;
	private Button btnSetPrefix;
	private List list;
	private Text nameInput;
	private Utente utente = new Utente();

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
		
		server = new Server(this);
		
		Display display = Display.getDefault();
		createContents();
		shlClient.open();
		shlClient.layout();
		while (!shlClient.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlClient = new Shell();
		shlClient.setSize(450, 453);
		shlClient.setText("Client");
		shlClient.addShellListener(new ShellListener(){

			@Override
			public void shellActivated(ShellEvent arg0) { return; }
			@Override
			public void shellDeactivated(ShellEvent arg0) { return; }
			@Override
			public void shellDeiconified(ShellEvent arg0) { return; }
			@Override
			public void shellIconified(ShellEvent arg0) { return; }

			@Override
			public void shellClosed(ShellEvent arg0) {
				System.out.println("Chiudone");
				server.stopServer();
			}
		});
		
		text = new Text(shlClient, SWT.BORDER);
		text.setBounds(10, 353, 414, 21);
		
		nameInput = new Text(shlClient, SWT.BORDER);
		nameInput.setBounds(244, 10, 76, 21);
		
		Button btnNewButton = new Button(shlClient, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				invia(utente.getName(), text.getText());
				list.add(utente.getName() + ": " + text.getText());
				text.setText("");
			}
		});
		btnNewButton.setBounds(10, 380, 414, 25);
		btnNewButton.setText("Invia");
		
		txtLab = new Text(shlClient, SWT.BORDER);
		txtLab.setText("Lab06_");
		txtLab.setBounds(10, 10, 76, 21);
		
		btnSetPrefix = new Button(shlClient, SWT.NONE);
		btnSetPrefix.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				client.setPrefix(txtLab.getText());
			}
		});
		btnSetPrefix.setBounds(92, 10, 75, 21);
		btnSetPrefix.setText("Set host");
		
		list = new List(shlClient, SWT.BORDER);
		list.setBounds(10, 37, 414, 310);
		
		Button btnSetName = new Button(shlClient, SWT.NONE);
		btnSetName.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				utente.setName(nameInput.getText());
			}
		});
		btnSetName.setBounds(326, 10, 75, 21);
		btnSetName.setText("Set name");

	}
	
	private void invia(String name, String message){
		client.invia(name, message);
	}

	@Override
	public void setHost(String host) {
		
	}

	@Override
	public String getHost() {
		return null;
	}

	@Override
	public void receive(String from, String name, String message) {
		// TODO Auto-generated method stub
		Display.getDefault().asyncExec(new Runnable(){
			public void run(){
				list.add(from + ": " + message);
			}
		});
	}
}
