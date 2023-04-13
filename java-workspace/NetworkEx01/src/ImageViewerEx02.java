import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;

public class ImageViewerEx02 extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageViewerEx02 frame = new ImageViewerEx02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ImageViewerEx02() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField1 = new JTextField();
		textField1.setText("https://");
		textField1.setBounds(6, 6, 532, 26);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setText("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/NetworkEx01/");
		textField2.setBounds(6, 44, 532, 26);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BufferedInputStream bis = null;
				BufferedOutputStream bos = null;
				String url = textField1.getText();
				String file = textField2.getText();
				
				try {

					HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
					
					bis = new BufferedInputStream(conn.getInputStream());
					bos = new BufferedOutputStream(new FileOutputStream(file));
					int data = 0;

					while((data = bis.read()) != -1) {
						bos.write(data);
					}
					System.out.println("다운 완료.");
					lbl.setIcon(new ImageIcon(file));
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally { 
					if(bis != null) { try { bis.close(); } catch (IOException e1) { e1.printStackTrace(); }}
					if(bos != null) { try { bos.close(); } catch (IOException e1) { e1.printStackTrace(); }}
				}
			}
		});
		btnNewButton.setBounds(550, 6, 117, 64);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 82, 661, 451);
		contentPane.add(scrollPane);
		
		lbl = new JLabel("");
		
		scrollPane.setViewportView(lbl);
	}
}
