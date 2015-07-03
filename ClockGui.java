import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Font;


public class ClockGui extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel square5;
	private JPanel square3;
	private JPanel square2;
	private JPanel square1_1;
	private JPanel square1_2;
	
	private JTextArea details;
	
	private JSpinner hourSpinner;
	private JSpinner minuteSpinner;
	
	private JButton checkTime;
	
	public ClockGui() {
		setTitle("Fibonacci Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		square5 = new JPanel();
		square5.setBounds(125, 5, 200, 200);
		square5.setBorder(new LineBorder(new Color(0, 0, 0)));
		square5.setBackground(Color.YELLOW);
		square5.setOpaque(true);
		getContentPane().add(square5);
		
		square3 = new JPanel();
		square3.setBounds(5, 85, 120, 120);
		square3.setBorder(new LineBorder(new Color(0, 0, 0)));
		square3.setBackground(Color.PINK);
		square3.setOpaque(true);
		getContentPane().add(square3);

		square2 = new JPanel();
		square2.setBounds(5, 5, 80, 80);
		square2.setBorder(new LineBorder(new Color(0, 0, 0)));
		square2.setBackground(Color.CYAN);
		square2.setOpaque(true);
		getContentPane().add(square2);
		
		square1_1 = new JPanel();
		square1_1.setBounds(85, 5, 40, 40);
		square1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		square1_1.setBackground(Color.RED);
		square1_1.setOpaque(true);
		getContentPane().add(square1_1);
		
		square1_2 = new JPanel();
		square1_2.setBounds(85, 45, 40, 40);
		square1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		square1_2.setBackground(Color.GREEN);
		square1_2.setOpaque(true);
		getContentPane().add(square1_2);
		
		details = new JTextArea();
		details.setFont(new Font("Courier", Font.PLAIN, 13));
		details.setBounds(330, 5, 150, 200);
		details.setEditable(false);
		getContentPane().add(details);
		
		SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 12, 1);
		hourSpinner = new JSpinner();
		hourSpinner.setModel(model);
		((DefaultEditor) hourSpinner.getEditor()).getTextField().setEditable(false);
		hourSpinner.setBounds(35, 217, 50, 30);
		getContentPane().add(hourSpinner);
		
		model = new SpinnerNumberModel(0, 0, 55, 5);
		minuteSpinner = new JSpinner();
		minuteSpinner.setModel(model);
		((DefaultEditor) minuteSpinner.getEditor()).getTextField().setEditable(false);
		minuteSpinner.setBounds(97, 217, 50, 30);
		getContentPane().add(minuteSpinner);
		
		checkTime = new JButton("Check Time");
		checkTime.setBounds(175, 217, 120, 30);
		getContentPane().add(checkTime);
		
		setSize(330,230);
		setVisible(true);
		setResizable(false);
	}
	
	public void setButtonText(String st) {
		checkTime.setText(st);
	}
	
	public void setMinute(int value) {
		minuteSpinner.setValue(value);
	}
	
	public void setHour(int value) {
		hourSpinner.setValue(value);
	}
	
	public int getMinute() {
		return (int)minuteSpinner.getValue();
	}
	
	public int getHour() {
		return (int)hourSpinner.getValue();
	}
	
	public JButton getCheckTime() {
		return checkTime;
	}
	
	public JTextArea getDetails() {
		return details;
	}

	public JPanel getSquare5() {
		return square5;
	}

	public JPanel getSquare3() {
		return square3;
	}

	public JPanel getSquare2() {
		return square2;
	}

	public JPanel getSquare1_1() {
		return square1_1;
	}

	public JPanel getSquare1_2() {
		return square1_2;
	}
}
