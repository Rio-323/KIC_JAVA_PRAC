import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class JSliderEx02 extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private int red;
	private int green;
	private int blue;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JSliderEx02 frame = new JSliderEx02();
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
	public JSliderEx02() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("Red");
		lbl1.setBounds(6, 38, 61, 16);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("Green");
		lbl2.setBounds(6, 98, 61, 16);
		contentPane.add(lbl2);
		
		JLabel lbl3 = new JLabel("Blue");
		lbl3.setBounds(6, 159, 61, 16);
		contentPane.add(lbl3);
		
		JSlider slider1 = new JSlider();
		slider1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				red = slider1.getValue();
				
				if(panel != null) {
					Color color = new Color(red, green, blue);
					panel.setBackground(color);
				}
			}
		});
		slider1.setMinorTickSpacing(10);
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		slider1.setMajorTickSpacing(100);
		slider1.setMaximum(250);
		slider1.setBounds(52, 22, 621, 45);
		contentPane.add(slider1);
		
		JSlider slider2 = new JSlider();
		slider2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				green = slider2.getValue();
				if(panel != null) {
					Color color = new Color(red, green, blue);
					panel.setBackground(color);
				}
			}
		});
		slider2.setPaintTicks(true);
		slider2.setPaintLabels(true);
		slider2.setMinorTickSpacing(10);
		slider2.setMaximum(250);
		slider2.setMajorTickSpacing(100);
		slider2.setBounds(52, 82, 621, 45);
		contentPane.add(slider2);
		
		JSlider slider3 = new JSlider();
		slider3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				blue = slider3.getValue();
				if(panel != null) {
					Color color = new Color(red, green, blue);
					panel.setBackground(color);
				}	
			}
		});
		slider3.setPaintTicks(true);
		slider3.setPaintLabels(true);
		slider3.setMinorTickSpacing(10);
		slider3.setMaximum(250);
		slider3.setMajorTickSpacing(100);
		slider3.setBounds(52, 143, 621, 45);
		contentPane.add(slider3);
		
		panel = new JPanel();
		panel.setBounds(6, 266, 667, 167);
		contentPane.add(panel);
	}
}
