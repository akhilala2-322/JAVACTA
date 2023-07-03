package sdcet.cse.oop;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class StudentGradingSystem extends JFrame implements ActionListener {
	Container contentPane;
	JButton b;
	JLabel l1, l2, l3, lcta, ltot, lsee, lg, lgc, la;
	JTextField t1, t2, t3, t4, t5;
	JPanel p1, p2, p3, p4;

	public StudentGradingSystem(String title) {
		super(title);
		contentPane = this.getContentPane();

		b = new JButton("Calculate");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		ltot = new JLabel("Total Marks");
		lg = new JLabel("Grade");
		lgc = new JLabel("Grade Calculator");
		l1 = new JLabel("Enter IA-1 Marks");
		l2 = new JLabel("Enter IA-2 Marks");
		l3 = new JLabel("Enter IA-3 Marks");
		lcta = new JLabel("Enter CTA Marks");
		lsee = new JLabel("Enter SEE Marks");
		la = new JLabel("NOTE:If absent enter marks as 0");
		t1 = new JTextField(5);
		t2 = new JTextField(5);
		t3 = new JTextField(5);
		t4 = new JTextField(5);
		t5 = new JTextField(5);

		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p2.setLayout(new GridLayout(6, 2));
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p4.setLayout(new GridLayout(4, 1));
		p1.add(lgc, BorderLayout.CENTER);

		p2.add(l1);
		p2.add(t1);
		p2.add(l2);
		p2.add(t2);
		p2.add(l3);
		p2.add(t3);
		p2.add(lcta);
		p2.add(t4);
		p2.add(lsee);
		p2.add(t5);
		p4.add(p3);
		p3.add(b);
		p4.add(ltot);
		p4.add(lg);
		p4.add(la);

		contentPane.setLayout(new BorderLayout());
		contentPane.add(p1, BorderLayout.NORTH);
		contentPane.add(p2, BorderLayout.CENTER);
		contentPane.add(p4, BorderLayout.SOUTH);

		b.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		int c = calculate();
		if (c != -1) {
			ltot.setText("Total Marks is " + calculate());
			lg.setText("Grade is " + grade(calculate()));
		} else {
			ltot.setText("");
			lg.setText("");
		}
	}

	int calculate() throws NumberFormatException {
		int ia1 = 0, ia2 = 0, ia3 = 0, cta = 0, see = 0, cie = 0;
		try {
			ia1 = Integer.parseInt(t1.getText());
			ia2 = Integer.parseInt(t2.getText());
			ia3 = Integer.parseInt(t3.getText());
			cta = Integer.parseInt(t4.getText());
			see = Integer.parseInt(t5.getText());
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		}
		if (ia1 < 0 || ia1 > 20 || ia2 < 0 || ia2 > 20 || ia3 < 0 || ia3 > 20)

		{
			JOptionPane.showMessageDialog(this, "Invalid IA Marks", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		}

		if (cta < 0 || cta > 10) {
			JOptionPane.showMessageDialog(this, "Invalid CTA marks", "Error", JOptionPane.ERROR_MESSAGE);
			return -1;
		} else {

			int min = ia1;
			if (ia2 < min)
				min = ia2;
			else if (ia3 < min)
				min = ia3;
			else
				min = ia1;

			cie = ia1 + ia2 + ia3 - min + cta;
		}
		if (cie < 20) {
			JOptionPane.showMessageDialog(this, "Student is detained from taking SEE", "Error",
					JOptionPane.ERROR_MESSAGE);
			return -1;
		}
		if (see == 38 || see == 39)
			see = 40;
		if (see % 2 != 0) {
			see = (see + 1) / 2;
		} else
			see = see / 2;

		return cie + see;
	}

	String grade(int a) {
		if (a <= 100 && a >= 90)
			return "S";
		else if (a < 90 && a >= 80)
			return "A";
		else if (a < 80 && a >= 70)
			return "B";
		else if (a < 70 && a >= 60)
			return "C";
		else if (a < 60 && a >= 50)
			return "D";
		else if (a < 50 && a >= 40)
			return "E";
		else
			return "F";

	}
}

public class StusentGradingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new StudentGradingSystem("Students Grading System");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setBounds(200, 200, 500, 400);

		f.setVisible(true);
	}

}

