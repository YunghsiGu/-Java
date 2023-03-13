import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TypeApp implements KeyListener {
	
	JFrame title;
	JButton[] buttonr1, buttonr2, buttonr3, buttonr4, buttonr5;
	String[] row1 = {"~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "Backspace"};
	String[] row2 = {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\"};
	String[] row3 = {"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "\"", "Enter"};
	String[] row4 = {"Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?", "^"};
	String[] row5 = {" ", "<", "v", ">"};
	
	ArrayList<String> row1List = new ArrayList<>();
	ArrayList<String> row2List = new ArrayList<>();
	ArrayList<String> row3List = new ArrayList<>();
	ArrayList<String> row4List = new ArrayList<>();
	
	public static void main(String[] args) {
		
		new TypeApp();
	}
	
	public TypeApp() {
		
		initKeys();
		
		title = new JFrame("Typing Applicatioin");
		JPanel window = new JPanel();
		window.setLayout(new BorderLayout());
		
		// hint
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		
		JLabel label1 = new JLabel("Type some text using your keyboard. " +
		"The keys you press will be highlighted and the test will be displayed.");
		JLabel lable2 = new JLabel("Note: Clicking the buttons with your mouse will not perform any action.");
		
		p1.add(label1, BorderLayout.NORTH);
		p1.add(lable2, BorderLayout.CENTER);
		
		// text area
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		JTextArea area = new JTextArea(0, 0);
		area.setLineWrap(true);
		area.setEditable(true);
		area.setFont(area.getFont().deriveFont(12.0f));
		area.addKeyListener(this);
		
		JScrollPane scroll = new JScrollPane(area);	
		p2.add(scroll);
		
		JPanel r1 = new JPanel();
		buttonr1 = new JButton[row1.length];
		for (int i = 0; i < row1.length; ++i) {
			buttonr1[i] = new JButton(row1[i]);
			r1.add(buttonr1[i]);
		}
		
		JPanel r2 = new JPanel();
		buttonr2 = new JButton[row2.length];
		for (int i = 0; i < row2.length; ++i) {
			buttonr2[i] = new JButton(row2[i]);
			r2.add(buttonr2[i]);
		}
		
		JPanel r3 = new JPanel();
		buttonr3 = new JButton[row3.length];
		for (int i = 0; i < row3.length; ++i) {
			buttonr3[i] = new JButton(row3[i]);
			r3.add(buttonr3[i]);
		}
		
		JPanel r4 = new JPanel();
		buttonr4 = new JButton[row4.length];
		for (int i = 0; i < row4.length; ++i) {
			buttonr4[i] = new JButton(row4[i]);
			r4.add(buttonr4[i]);
		}
		
		JPanel r5 = new JPanel();
		buttonr5 = new JButton[row5.length];
		for (int i = 0; i < row5.length; ++i) {
			buttonr5[i] = new JButton(row5[i]);
			r5.add(buttonr5[i]);
		}
		buttonr5[0].setPreferredSize(new Dimension(525, 26));	// white space
		
		// keyboard
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(5, 14));
		p3.add(r1);
		p3.add(r2);
		p3.add(r3);
		p3.add(r4);
		p3.add(r5);
		
		window.add(p1, BorderLayout.NORTH);
		window.add(p2, BorderLayout.CENTER);
		window.add(p3, BorderLayout.SOUTH);
		
		title.setSize(1000, 600);
		title.add(window);
		title.setVisible(true);
	}
	
	public void initKeys() {
		
		for (int i = 0; i < row1.length; ++i)
			row1List.add(row1[i]);
		
		for (int i = 0; i < row2.length; ++i)
			row2List.add(row2[i]);
		
		for (int i = 0; i < row3.length; ++i)
			row3List.add(row3[i]);
		
		for (int i = 0; i < row4.length; ++i)
			row4List.add(row4[i]);
	}

	public void keyPressed(KeyEvent e) {
		
		char ch = e.getKeyChar();
		String strKey = (ch + "").toUpperCase();
		
		if (row1List.contains(strKey))
			buttonr1[row1List.indexOf(strKey)].setBackground(Color.yellow);
			
		if (row2List.contains(strKey))
			buttonr2[row2List.indexOf(strKey)].setBackground(Color.yellow);
			
		if (row3List.contains(strKey))
			buttonr3[row3List.indexOf(strKey)].setBackground(Color.yellow);
			
		if (row4List.contains(strKey))
			buttonr4[row4List.indexOf(strKey)].setBackground(Color.yellow);
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_BACK_SPACE:
			buttonr1[13].setBackground(Color.GREEN);
			break;
		case KeyEvent.VK_TAB:
			buttonr2[0].setBackground(Color.GREEN);
			break;
		case KeyEvent.VK_CAPS_LOCK:
			buttonr3[0].setBackground(Color.GREEN);
			break;
		case KeyEvent.VK_ENTER:
			buttonr3[12].setBackground(Color.GREEN);
			break;
		case KeyEvent.VK_SHIFT:
			buttonr4[0].setBackground(Color.GREEN);
			break;
		case KeyEvent.VK_SPACE:
			buttonr5[0].setBackground(Color.GREEN);
			break;
		case KeyEvent.VK_UP:
			buttonr4[11].setBackground(Color.GREEN);
			break;
		case KeyEvent.VK_LEFT:
			buttonr5[1].setBackground(Color.GREEN);
			break;
		case KeyEvent.VK_DOWN:
			buttonr5[2].setBackground(Color.GREEN);
			break;
		case KeyEvent.VK_RIGHT:
			buttonr5[3].setBackground(Color.GREEN);
			break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
		char c = e.getKeyChar();
		String strKey = (c + "").toUpperCase();
		
		if (row1List.contains(strKey))
			buttonr1[row1List.indexOf(strKey)].setBackground(null);

		if (row2List.contains(strKey))
			buttonr2[row2List.indexOf(strKey)].setBackground(null);

		if (row3List.contains(strKey))
			buttonr3[row3List.indexOf(strKey)].setBackground(null);
			
		if (row4List.contains(strKey))
			buttonr4[row4List.indexOf(strKey)].setBackground(null);

		switch (e.getKeyCode()) {
		case KeyEvent.VK_BACK_SPACE:
			buttonr1[13].setBackground(null);
			break;
		case KeyEvent.VK_TAB:
			buttonr2[0].setBackground(null);
			break;
		case KeyEvent.VK_CAPS_LOCK:
			buttonr3[0].setBackground(null);
			break;
		case KeyEvent.VK_ENTER:
			buttonr3[12].setBackground(null);
			break;
		case KeyEvent.VK_SHIFT:
			buttonr4[0].setBackground(null);
			break;
		case KeyEvent.VK_SPACE:
			buttonr5[0].setBackground(null);
			break;
		case KeyEvent.VK_UP:
			buttonr4[11].setBackground(null);
			break;
		case KeyEvent.VK_LEFT:
			buttonr5[1].setBackground(null);
			break;
		case KeyEvent.VK_DOWN:
			buttonr5[2].setBackground(null);
			break;
		case KeyEvent.VK_RIGHT:
			buttonr5[3].setBackground(null);
			break;
		}
	}
	public void keyTyped(KeyEvent e) {}
}