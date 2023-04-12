import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class UserMouseEvent3 extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent e) {
		String name = ((JButton)e.getSource()).getName();
		
		switch(name) {
		case "button1" : System.out.println("btn1 mouseClicked"); break;
		case "button2" : System.out.println("btn2 mouseClicked"); break;
		case "button3" : System.out.println("btn3 mouseClicked"); break;
		default : System.out.println("Error");
		}
	}
}
