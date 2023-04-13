import java.awt.EventQueue;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageViewerEx01 extends JFrame {

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
					ImageViewerEx01 frame = new ImageViewerEx01();
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
	public ImageViewerEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField1 = new JTextField();
		textField1.setText("https://");
		textField1.setBounds(12, 10, 444, 21);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setText( new File("").getAbsolutePath().replaceAll( "\\\\", "/" ) + "/" );
		textField2.setBounds(12, 41, 444, 21);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JButton btn = new JButton("저장");
		btn.addMouseListener(new MouseAdapter() {
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
		btn.setBounds(468, 9, 97, 53);
		contentPane.add(btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 76, 553, 675);
		contentPane.add(scrollPane);
		
		lbl = new JLabel("");
		scrollPane.setViewportView(lbl);
	}
}
