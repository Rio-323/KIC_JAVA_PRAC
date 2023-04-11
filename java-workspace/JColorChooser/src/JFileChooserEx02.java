import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JFileChooserEx02 extends JFrame {

	private JPanel contentPane;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFileChooserEx02 frame = new JFileChooserEx02();
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
	public JFileChooserEx02() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton = new JButton("이미지 보기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser("C:\\");
			    FileNameExtensionFilter filter = new FileNameExtensionFilter("이미지 파일", "jpg", "png", "jpeg");
			    fileChooser.setFileFilter(filter);
			    int result = fileChooser.showOpenDialog(JFileChooserEx02.this);
			        
			    if (result == JFileChooser.APPROVE_OPTION) {
			    	lbl.setText("");
			        File selectedFile = fileChooser.getSelectedFile();
			         try {
			        	 Image image = ImageIO.read(selectedFile);
			             lbl.setIcon(new ImageIcon(image));
			             } catch (IOException e1) {
			                e1.printStackTrace();
			            }
			        }
			    }
			});
		btnNewButton.setBounds(6, 6, 188, 29);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 47, 737, 478);
		contentPane.add(scrollPane);
		
		lbl = new JLabel("New label");
		// lbl.setIcon(new ImageIcon("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/JColorChooser/src/Desert.jpg"));
		scrollPane.setViewportView(lbl);
	}

}
