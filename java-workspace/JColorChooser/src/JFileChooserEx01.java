import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class JFileChooserEx01 extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btn2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFileChooserEx01 frame = new JFileChooserEx01();
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
	public JFileChooserEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn = new JButton("New button");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser("C:\\");
				
				// file 확장자 필터
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Java Sourece", "java", "txt");
				fileChooser.setFileFilter(filter);
				
				int result = fileChooser.showOpenDialog(JFileChooserEx01.this);
				
				if(result == JFileChooser.APPROVE_OPTION) {
					System.out.println("확인");
					System.out.println(fileChooser.getSelectedFile().getName());
					File file = fileChooser.getSelectedFile();
					System.out.println(file.getName());
					System.out.println(file.getAbsolutePath());
					
					// list - file
					// IO - Stream
					textArea.setText("")
;					
					BufferedReader br = null;
					try {
						br = new BufferedReader(new FileReader(file));
						String line = null;
						while((line = br.readLine()) != null) {
							textArea.append(line + System.lineSeparator());
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						if(br != null) try { br.close(); } catch(IOException e1) { e1.printStackTrace(); }
					}
				} else if(result == JFileChooser.CANCEL_OPTION) {
					System.out.println("취소");
				}
				
			}
		});
		btn.setBounds(6, 6, 117, 29);
		contentPane.add(btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 58, 765, 473);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btn2 = new JButton("파일 저장");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser("C:\\");
				int result = fileChooser.showSaveDialog(JFileChooserEx01.this);
				
				if(result == JFileChooser.APPROVE_OPTION) {
					System.out.println("확인" + fileChooser.getSelectedFile().getName());
					System.out.println("확인" + fileChooser.getSelectedFile().getAbsolutePath());
					
					// BufferedWriter
					BufferedWriter bw = null;
					
					try {
						bw = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile()));
						bw.write(textArea.getText());
						
						JOptionPane.showMessageDialog(JFileChooserEx01.this, "내용 저장", "저장", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						try { bw.close(); } catch (IOException e1) { System.out.println("[Error] : " + e1.getMessage()); }
					}
					
					
				} else {
					System.out.println("취소");
				}
			}
		});
		btn2.setBounds(131, 6, 117, 29);
		contentPane.add(btn2);
	}

}
