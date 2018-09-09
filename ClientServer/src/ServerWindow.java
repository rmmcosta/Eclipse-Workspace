import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ServerWindow {

	private JFrame frame;
	private JTextField inputPort;
	private JButton btnEnd;
	Server server;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerWindow window = new ServerWindow();
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
	public ServerWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		inputPort = new JTextField();
		inputPort.setText("80");
		inputPort.setBounds(23, 41, 35, 20);
		frame.getContentPane().add(inputPort);
		inputPort.setColumns(10);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(23, 16, 46, 14);
		frame.getContentPane().add(lblPort);
		
		JButton btnInitializeServer = new JButton("Initialize Server");
		btnInitializeServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					server = new Server(Integer.parseInt(inputPort.getText()));
					server.ManageConnections();
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnInitializeServer.setBounds(68, 40, 139, 23);
		frame.getContentPane().add(btnInitializeServer);
		
		btnEnd = new JButton("End");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					server.StopServer();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEnd.setBounds(212, 40, 89, 23);
		frame.getContentPane().add(btnEnd);
	}
}
