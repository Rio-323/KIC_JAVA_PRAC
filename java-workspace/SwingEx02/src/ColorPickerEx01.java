import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;

public class ColorPickerEx01 extends JFrame {

	private JPanel contentPane;
	private JSlider slider1;
	private JPanel panel;
	private JSlider slider2;
	private JSlider slider3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater( new Runnable() {
			public void run() {
				try {
					ColorPickerEx01 frame = new ColorPickerEx01();
					frame.setVisible( true );
				} catch( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
	}
	/**
	 * Create the frame.
	 */
	public ColorPickerEx01() {
		setResizable(false);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 800, 600 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
        
		contentPane.setLayout( null );
          
		slider1 = new JSlider();
		slider1.setMinorTickSpacing(10);
		slider1.setPaintLabels(true);
		slider1.setMajorTickSpacing( 100 );
		slider1.setMaximum( 255 );
		slider1.addChangeListener( new ChangeListener() {
			public void stateChanged( ChangeEvent e) {
			}
		} );
		slider1.setPaintTicks( true );
		slider1.setValue( 0 );
		slider1.setBounds( 82, 10, 690, 46 );
		contentPane.add( slider1 );
          
		slider2 = new JSlider();
		slider2.setPaintTicks(true);
		slider2.setPaintLabels(true);
		slider2.addChangeListener( new ChangeListener() {
			public void stateChanged( ChangeEvent e) {
			}
		} );
		slider2.setValue( 0 );
		slider2.setMaximum( 255 );
		slider2.setMajorTickSpacing( 100 );
		slider2.setMinorTickSpacing( 10 );
		slider2.setBounds( 82, 66, 690, 46 );
		contentPane.add( slider2 );
          
		slider3 = new JSlider();
		slider3.setMinorTickSpacing(10);
		slider3.setPaintLabels(true);
		slider3.addChangeListener( new ChangeListener() {
			public void stateChanged( ChangeEvent e ) {
			}
		} );
		slider3.setValue( 0 );
		slider3.setPaintTicks( true );
		slider3.setMaximum( 255 );
		slider3.setMajorTickSpacing( 100 );
		slider3.setBounds( 82, 122, 690, 46 );
		contentPane.add( slider3 );
          
		panel = new JPanel();
		panel.setBackground( Color.BLACK );
		panel.setBounds( 12, 178, 760, 158 );
		contentPane.add( panel );
		
		JLabel lbl1 = new JLabel("RED");
		lbl1.setBounds(13, 10, 57, 15);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("GREEN");
		lbl2.setBounds(12, 66, 57, 15);
		contentPane.add(lbl2);
		
		JLabel lbl3 = new JLabel("BLUE");
		lbl3.setBounds(13, 122, 57, 15);
		contentPane.add(lbl3);
	}
}
