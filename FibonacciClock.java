import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;


public class FibonacciClock {
	
	static final int NONE = 0; //white
	static final int MINUTE = 1; //green
	static final int HOUR = 2; //red
	static final int BOTH = 3; //blue
	
	private Square square5;
	private Square square3;
	private Square square2;
	private Square square1_1;
	private Square square1_2;
	
	private ClockGui cg;
	
	private boolean showDetails;
	private boolean showQuiz;
	private boolean showTime;
	
	private String minuteDetails;
	private String hourDetails;
	private String minuteMoreDetails;
	
	private int hourCount;
	private int minuteCount;
	private int hour;
	private int minute;
	
	public FibonacciClock() {
		cg = new ClockGui();
		final JTextArea details = cg.getDetails();
		final JPanel squareLabel5 = cg.getSquare5();
		final JPanel squareLabel3 = cg.getSquare3();
		final JPanel squareLabel2 = cg.getSquare2();
		
		square5 = new Square(NONE, squareLabel5, 5);
		square3 = new Square(NONE, squareLabel3, 3);
		square2 = new Square(NONE, squareLabel2, 2);
		square1_1 = new Square(NONE, cg.getSquare1_1(), 1);
		square1_2 = new Square(NONE, cg.getSquare1_2(), 1);
		
		updateSquares();
		
		Timer SimpleTimer = new Timer(1000, new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	updateSquares();
		    }
		});
		
		showDetails = false;
		showQuiz = false;
		showTime = false;
		
		squareLabel5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dimension frameSize = cg.getSize();
				if (!showDetails) {
					StringBuilder sb = new StringBuilder();
					sb.append("White = null");
					sb.append("\n");
					sb.append("Green = minute");
					sb.append("\n");
					sb.append("Red   = hour");
					sb.append("\n");
					sb.append("Blue  = both");
					sb.append("\n");
					sb.append("\n");
					sb.append("Hour:");
					sb.append("\n");
					sb.append(hourDetails);
					sb.append("\n");
					sb.append("\n");
					sb.append("Minute:");
					sb.append("\n");
					sb.append(minuteDetails);
					sb.append("\n");
					sb.append("          = ");
					sb.append(minuteMoreDetails);
					details.setText(sb.toString());
					cg.setSize((int)frameSize.getWidth() + 155, (int)frameSize.getHeight());
					showDetails = !showDetails;
				} else {
					details.setText("");
					cg.setSize((int)frameSize.getWidth() - 155, (int)frameSize.getHeight());
					showDetails = !showDetails;
				}
			}
		});
		
		squareLabel3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dimension frameSize = cg.getSize();
				if (!showQuiz) {
					resetQuiz();
					cg.setSize((int)frameSize.getWidth(), (int)frameSize.getHeight() + 50);
					showQuiz = !showQuiz;
				} else {
					cg.setSize((int)frameSize.getWidth(), (int)frameSize.getHeight() - 50);
					showQuiz = !showQuiz;
				}
			}
		});
		
		squareLabel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showTime = !showTime;
				updateTime();
			}
		});
		
		final JButton checkTime = cg.getCheckTime();
		
		checkTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Calendar calendar = updateTime();
				if (calendar.get(Calendar.HOUR) != cg.getHour() || ((calendar.get(Calendar.MINUTE)/5)*5) != cg.getMinute()) {
					checkTime.setText("WRONG");
				} else {
					checkTime.setText("CORRECT");
				}
			}
		});
		
		SimpleTimer.start();
	}
	
	private void resetQuiz() {
		cg.setHour(0);
		cg.setMinute(0);
		cg.setButtonText("Check Time");
	}
	
	private Calendar updateTime() {
		Calendar calendar = GregorianCalendar.getInstance();
		if (showTime) {
			cg.setTitle("Fibonacci Clock - " + (new SimpleDateFormat("hh:mm:ss a")).format(calendar.getTime()));
		} else {
			cg.setTitle("Fibonacci Clock");
		}
		return calendar;
	}
	
	private void hourSetSquare(StringBuilder sb, Square square) {
		int value = square.getValue();
		if (hour >= value) {
			hour -= value;
			square.setColour(HOUR);
			sb.append(value);
			hourCount += value;
		} else {
			sb.append(0);
		}
	}
	
	private void minuteSetSquare(StringBuilder sb, Square square) {
		int value = square.getValue();
		if (minute >= value) {
			minute -= value;
			setMinuteColour(square);
			sb.append(value);
			minuteCount += value;
		} else {
			sb.append(0);
		}
	}
	
	private void updateSquares() {
		Calendar calendar = updateTime();
		hour = calendar.get(Calendar.HOUR);
		minute = calendar.get(Calendar.MINUTE) / 5;
		
		StringBuilder hourSB = new StringBuilder();
		StringBuilder minuteSB = new StringBuilder();
		
		hourCount = 0;
		minuteCount = 0;
		
		hourSetSquare(hourSB, square5);
		hourSB.append("+");
		hourSetSquare(hourSB, square3);
		hourSB.append("+");
		hourSetSquare(hourSB, square2);
		hourSB.append("+");
		hourSetSquare(hourSB, square1_1);
		hourSB.append("+");
		hourSetSquare(hourSB, square1_2);
		hourSB.append(" = ");
		hourSB.append(hourCount);
		hourDetails = hourSB.toString();
		
		minuteSetSquare(minuteSB, square5);
		minuteSB.append("+");
		minuteSetSquare(minuteSB, square3);
		minuteSB.append("+");
		minuteSetSquare(minuteSB, square2);
		minuteSB.append("+");
		minuteSetSquare(minuteSB, square1_1);
		minuteSB.append("+");
		minuteSetSquare(minuteSB, square1_2);
		minuteSB.append(" = ");
		minuteSB.append(minuteCount);
		minuteSB.append("*5");
		minuteDetails = minuteSB.toString();
		minuteMoreDetails = String.valueOf(minuteCount * 5);
	}
	
	private void setMinuteColour(Square square) {
		if (square.getColour() == HOUR) {
			square.setColour(BOTH);
		} else {
			square.setColour(MINUTE);
		}
	}
	
	public static void main(String[] args) {
		new FibonacciClock();
	}

}
