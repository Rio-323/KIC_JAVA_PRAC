import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JDialogMainEx01 extends JFrame {

	private JPanel contentPane;
	private JButton btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDialogMainEx01 frame = new JDialogMainEx01();
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
	public JDialogMainEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn = new JButton("New button");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JDialogEx01 dialog = new JDialogEx01();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				
				dialog.setModal(true);
				// dialog.setLocationRelativeTo(contentPane);
				Dimension d = JDialogMainEx01.this.getSize();
				System.out.println(d.toString());
				
				Point p = JDialogMainEx01.this.getLocation();
				System.out.println(p.toString());
				
				Rectangle r = JDialogMainEx01.this.getBounds();
				System.out.println(r.toString());
				
				int fx = (int)r.getX();
				int fy = (int)r.getY();
				int fwidth = (int)r.getWidth();
				int fheight = (int)r.getHeight();
				
				int dwidth = 450;
				int dheight = 300;
				
				dialog.setBounds(fwidth / 2 - dwidth / 2 + fx, fheight / 2 - dheight / 2 + fy, dwidth, dheight);
				
				dialog.setVisible(true);
			}
		});
		btn.setBounds(6, 25, 117, 29);
		contentPane.add(btn);
	}
}
