import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
	
	public FibonacciClock() {
		cg = new ClockGui();
		square5 = new Square(NONE, cg.getPanel5());
		square3 = new Square(NONE, cg.getPanel3());
		square2 = new Square(NONE, cg.getPanel2());
		square1_1 = new Square(NONE, cg.getPanel1_1());
		square1_2 = new Square(NONE, cg.getPanel1_2());
		updateSquares();
		Timer SimpleTimer = new Timer(1000, new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	updateSquares();
		    }
		});
		SimpleTimer.start();
	}
	
	public void updateSquares() {
		Calendar calendar = GregorianCalendar.getInstance();
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE) / 5;
		
		cg.setTitle("Fibonacci Clock - " + (new SimpleDateFormat("HH:mm:ss")).format(calendar.getTime()));
		
		if (hour >= 5) {
			hour -= 5;
			square5.setColour(HOUR);
		}
		if (hour >= 3) {
			hour -= 3;
			square3.setColour(HOUR);
		}
		if (hour >= 2) {
			hour -= 2;
			square2.setColour(HOUR);
		}
		if (hour >= 1) {
			hour -= 1;
			square1_1.setColour(HOUR);
		}
		if (hour >= 1) {
			hour -= 1;
			square1_2.setColour(HOUR);
		}
		
		if (minute >= 5) {
			minute -= 5;
			setMinuteColour(square5);
		}
		if (minute >= 3) {
			minute -= 3;
			setMinuteColour(square3);
		}
		if (minute >= 2) {
			minute -= 2;
			setMinuteColour(square2);
		}
		if (minute >= 1) {
			minute -= 1;
			setMinuteColour(square1_1);
		}
		if (minute >= 1) {
			minute -= 1;
			setMinuteColour(square1_2);
		}
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
