package pack8;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

public class GugudanClientEx01 extends JFrame {

	private JPanel contentPane;
	private JSpinner spinner1;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GugudanClientEx01 frame = new GugudanClientEx01();
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
	public GugudanClientEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uAD6C\uAD6C\uB2E8", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 21, 749, 108);
		contentPane.add(panel);
		panel.setLayout(null);
		
		spinner1 = new JSpinner();
		spinner1.setModel(new SpinnerNumberModel(1, 1, 9, 1));
		spinner1.setBounds(136, 34, 415, 22);
		panel.add(spinner1);
		
		JSpinner spinner2 = new JSpinner();
		spinner2.setModel(new SpinnerNumberModel(2, 1, 9, 1));
		spinner2.setBounds(136, 66, 415, 22);
		panel.add(spinner2);
		
		JButton btn1 = new JButton("구구단 출력");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Socket socket = null;
				
				BufferedWriter bw = null;
				BufferedReader br = null;
				
				try {
					System.out.println( "서버와 연결 중입니다." );
					socket = new Socket( "localhost", 7777 );
					System.out.println("서버와 연결와 연결되었습니다." );
		            
					bw = new BufferedWriter( new OutputStreamWriter( socket.getOutputStream(), "utf-8" ) );
					br = new BufferedReader( new InputStreamReader( socket.getInputStream(), "utf-8" ) );
		            
					bw.write( "2:3" + System.lineSeparator() );
					bw.flush();
		               
					textArea.setText( br.readLine().replaceAll( ":", "\n" ) );
					
				} catch( UnknownHostException e1 ) {
					// TODO Auto-generated catch block
					System.out.println( "[에러] : " + e1.getMessage() );
				} catch( UnsupportedEncodingException e1 )  {
					// TODO Auto-generated catch block
					System.out.println( "[에러] : " + e1.getMessage() );
				} catch( IOException e1 ) {
					// TODO Auto-generated catch block
					System.out.println( "[에러] : " + e1.getMessage() );
				} finally {
					if( bw != null ) try { bw.close(); } catch( IOException e1 ) {}
					if( br != null ) try { br.close(); } catch( IOException e1 ) {}
					
					if( socket != null ) try { socket.close(); } catch( IOException e1 ) {}
				}
			}
		});
		btn1.setBounds(563, 33, 162, 55);
		panel.add(btn1);
		
		JLabel lbl1 = new JLabel("시작단");
		lbl1.setBounds(30, 37, 73, 15);
		panel.add(lbl1);
		
		JLabel lbl2 = new JLabel("끝  단");
		lbl2.setBounds(30, 69, 73, 15);
		panel.add(lbl2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 139, 749, 412);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}
}
