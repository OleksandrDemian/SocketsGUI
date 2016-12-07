import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;

public class Main {

	protected Shell shlClient;
	private Text text;
	private Text text_1;
	private Client client = new Client();
	private Server server;
	private Button btnSetPrefix;
	private List list;

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
		
		text = new Text(shlClient, SWT.BORDER);
		text.setBounds(10, 353, 414, 21);
		
		Button btnNewButton = new Button(shlClient, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				invia(text.getText());
				list.add("Client: " + text.getText());
				text.setText("");
			}
		});
		btnNewButton.setBounds(10, 380, 414, 25);
		btnNewButton.setText("New Button");
		
		text_1 = new Text(shlClient, SWT.BORDER);
		text_1.setBounds(10, 10, 76, 21);
		
		btnSetPrefix = new Button(shlClient, SWT.NONE);
		btnSetPrefix.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				client.setPrefix(text_1.getText());
			}
		});
		btnSetPrefix.setBounds(92, 10, 75, 21);
		btnSetPrefix.setText("Set prefix");
		
		list = new List(shlClient, SWT.BORDER);
		list.setBounds(10, 37, 414, 310);

	}
	
	private void invia(String s){
		client.invia(s);
	}
	
	public void addFromServer(String message){
		Display.getDefault().asyncExec(new Runnable(){
			public void run(){
				list.add("Server: " + message);
			}
		});
	}
}
