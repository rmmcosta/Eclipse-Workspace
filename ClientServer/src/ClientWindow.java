import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ClientWindow {

	private JFrame frame;
	private JTextField inputServerIP;
	Client connection;
	JTextArea history;
	JTextPane myMessage;
	private JTextField inputPort;
	private JLabel lblPort;
	JButton btnSend;
	JLabel lblConnected;
	private JTextField inputName;
	private JLabel lblName;
	private JButton btnClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientWindow window = new ClientWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 467, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		history = new JTextArea();
		history.setEnabled(false);
		history.setEditable(false);
		history.setBounds(10, 110, 349, 256);
		frame.getContentPane().add(history);

		myMessage = new JTextPane();
		myMessage.setEnabled(false);
		myMessage.setBounds(10, 385, 349, 47);
		frame.getContentPane().add(myMessage);

		btnSend = new JButton("Send");
		btnSend.setEnabled(false);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SendMessage();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSend.setBounds(367, 391, 74, 35);
		frame.getContentPane().add(btnSend);

		inputServerIP = new JTextField();
		inputServerIP.setText("192.168.1.7");
		inputServerIP.setBounds(10, 28, 116, 20);
		frame.getContentPane().add(inputServerIP);
		inputServerIP.setColumns(10);

		JLabel lblServerIp = new JLabel("Server IP");
		lblServerIp.setLabelFor(inputServerIP);
		lblServerIp.setBounds(10, 11, 74, 14);
		frame.getContentPane().add(lblServerIp);

		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SetConnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConnect.setBounds(194, 27, 89, 23);
		frame.getContentPane().add(btnConnect);

		lblConnected = new JLabel("Disconnected");
		lblConnected.setForeground(new Color(255, 51, 0));
		lblConnected.setBounds(147, 77, 74, 20);
		frame.getContentPane().add(lblConnected);

		inputPort = new JTextField();
		inputPort.setText("80");
		inputPort.setBounds(136, 28, 46, 20);
		frame.getContentPane().add(inputPort);
		inputPort.setColumns(10);

		lblPort = new JLabel("Port");
		lblPort.setBounds(136, 11, 46, 14);
		frame.getContentPane().add(lblPort);

		inputName = new JTextField();
		inputName.setText("John Doe");
		inputName.setBounds(10, 77, 86, 20);
		frame.getContentPane().add(inputName);
		inputName.setColumns(10);

		lblName = new JLabel("Name");
		lblName.setBounds(10, 60, 46, 14);
		frame.getContentPane().add(lblName);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				history.setText("");
			}
		});
		btnClear.setBounds(367, 343, 74, 23);
		frame.getContentPane().add(btnClear);
	}

	private void SetConnection() throws Exception {
		try {
			connection = new Client(inputServerIP.getText(), Integer.parseInt(inputPort.getText()));
			myMessage.setEnabled(true);
			history.setEnabled(true);
			btnSend.setEnabled(true);
			lblConnected.setText("Connected");
			lblConnected.setForeground(new Color(0, 204, 51));
			Thread thread = new Thread() {
				public void run() {
					try {
						WaitingMessage();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			thread.start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void SendMessage() throws Exception {
		String msg = inputName.getText() + ":" + myMessage.getText();
		try {
			connection.Send(msg);
			myMessage.setText("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void WaitingMessage() throws Exception {
		String msg;
		try {
			while (true) {
				msg = connection.ReadMode();
				history.append(msg + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
