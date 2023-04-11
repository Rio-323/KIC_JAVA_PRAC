import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JTreeEx01 extends JFrame {

	private JPanel contentPane;
	private JTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTreeEx01 frame = new JTreeEx01();
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
	public JTreeEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tree = new JTree();
		tree.setShowsRootHandles(true);
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("click : " + tree.getSelectionPath());
			}
		});
//		tree.setModel(new DefaultTreeModel(
//			new DefaultMutableTreeNode("JTree") {
//				{
//					DefaultMutableTreeNode node_1;
//					node_1 = new DefaultMutableTreeNode("colors");
//						node_1.add(new DefaultMutableTreeNode("파란색"));
//						node_1.add(new DefaultMutableTreeNode("빨간색"));
//						node_1.add(new DefaultMutableTreeNode("초록색"));
//						node_1.add(new DefaultMutableTreeNode("노란색"));
//					add(node_1);
//					node_1 = new DefaultMutableTreeNode("sports");
//						node_1.add(new DefaultMutableTreeNode("basketball"));
//						node_1.add(new DefaultMutableTreeNode("soccer"));
//						node_1.add(new DefaultMutableTreeNode("football"));
//						node_1.add(new DefaultMutableTreeNode("hockey"));
//					add(node_1);
//					node_1 = new DefaultMutableTreeNode("food");
//						node_1.add(new DefaultMutableTreeNode("hot dogs"));
//						node_1.add(new DefaultMutableTreeNode("pizza"));
//						node_1.add(new DefaultMutableTreeNode("ravioli"));
//						node_1.add(new DefaultMutableTreeNode("bananas"));
//					add(node_1);
//				}
//			}
//		));
		
		tree.setModel(new DefaultTreeModel(makeTree("root")));
		tree.setBounds(6, 26, 172, 406);
		contentPane.add(tree);
	}
	
	public DefaultMutableTreeNode makeTree(String rootName) {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootName);
		
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("colors");
		DefaultMutableTreeNode leaf11 = new DefaultMutableTreeNode("파란색");
		DefaultMutableTreeNode leaf12 = new DefaultMutableTreeNode("빨간색");
		DefaultMutableTreeNode leaf13 = new DefaultMutableTreeNode("초록색");
		DefaultMutableTreeNode leaf14 = new DefaultMutableTreeNode("노란색");
		
		DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("sports");
//		DefaultMutableTreeNode leaf21 = new DefaultMutableTreeNode("basketball");
//		DefaultMutableTreeNode leaf22 = new DefaultMutableTreeNode("soccer");
//		DefaultMutableTreeNode leaf23 = new DefaultMutableTreeNode("football");
//		DefaultMutableTreeNode leaf24 = new DefaultMutableTreeNode("hockey");
		
		DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("food");
		DefaultMutableTreeNode leaf31 = new DefaultMutableTreeNode("hot dogs");
		DefaultMutableTreeNode leaf32 = new DefaultMutableTreeNode("pizza");
		DefaultMutableTreeNode leaf33 = new DefaultMutableTreeNode("ravioli");
		DefaultMutableTreeNode leaf34 = new DefaultMutableTreeNode("bananas");
		
		root.add(node1);
		root.add(node2);
		root.add(node3);
		
		node1.add(leaf11);
		node1.add(leaf12);
		node1.add(leaf13);
		node1.add(leaf14);
		
//		node2.add(leaf21);
//		node2.add(leaf22);
//		node2.add(leaf23);
//		node2.add(leaf24);
		
		node2.add(new DefaultMutableTreeNode("basketball"));
		node2.add(new DefaultMutableTreeNode("soccer"));
		node2.add(new DefaultMutableTreeNode("football"));
		node2.add(new DefaultMutableTreeNode("hockey"));
		
		node3.add(leaf31);
		node3.add(leaf32);
		node3.add(leaf33);
		node3.add(leaf34);
		return root;
	}
}
