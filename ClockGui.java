import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;


public class ClockGui extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel panel5;
	private JPanel panel3;
	private JPanel panel2;
	private JPanel panel1_1;
	private JPanel panel1_2;
	
	public ClockGui() {
		setTitle("Fibonacci Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel5 = new JPanel();
		panel5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel5.setBackground(Color.YELLOW);
		panel5.setBounds(220, 100, 200, 200);
		getContentPane().add(panel5);
		
		panel3 = new JPanel();
		panel3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel3.setBackground(Color.PINK);
		panel3.setBounds(100, 180, 120, 120);
		getContentPane().add(panel3);
		
		panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2.setBackground(Color.CYAN);
		panel2.setBounds(100, 100, 80, 80);
		getContentPane().add(panel2);
		
		panel1_1 = new JPanel();
		panel1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel1_1.setBackground(Color.RED);
		panel1_1.setBounds(180, 100, 40, 40);
		getContentPane().add(panel1_1);
		
		panel1_2 = new JPanel();
		panel1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel1_2.setBackground(Color.GREEN);
		panel1_2.setBounds(180, 140, 40, 40);
		getContentPane().add(panel1_2);
		
		setSize(700,500);
		setVisible(true);
	}

	public JPanel getPanel5() {
		return panel5;
	}

	public JPanel getPanel3() {
		return panel3;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public JPanel getPanel1_1() {
		return panel1_1;
	}

	public JPanel getPanel1_2() {
		return panel1_2;
	}
}
