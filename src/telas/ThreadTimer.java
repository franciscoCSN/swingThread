package telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ThreadTimer extends JDialog{
	
	private JPanel jpanel = new JPanel(new GridBagLayout());
	JLabel jlabel1 = new JLabel("Thread time 1");
	JLabel jlabel2 = new JLabel("Thread time 2");
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JButton btn1 = new JButton("start");
	JButton btn2 = new JButton("stop");
	
	Thread Timer1 = new Thread();
	Thread Timer2 = new Thread();
	
	public ThreadTimer() {
		setTitle("Litle timer");
		setSize(new Dimension(240,360));
		setLocation(Integer.valueOf((int) Window.CENTER_ALIGNMENT),Integer.valueOf((int) Window.CENTER_ALIGNMENT));
		setResizable(false);
		
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = 0;
		grid.gridy = 0;
		grid.gridwidth = 2;
		grid.anchor = GridBagConstraints.WEST;
		grid.insets = new Insets(5, 10, 2, 2);
		
		
		
		jlabel1.setPreferredSize(new Dimension(200,25));
		jpanel.add(jlabel1, grid);
		
		grid.gridy++;
		tf1.setPreferredSize(new Dimension(200,25));
		tf1.setEditable(false);
		jpanel.add(tf1,grid);
		
		grid.gridy++;
		jlabel2.setPreferredSize(new Dimension(200,25));
		jpanel.add(jlabel2, grid);
	
		grid.gridy++;
		tf2.setPreferredSize(new Dimension(200,25));
		tf2.setEditable(false);
		jpanel.add(tf2,grid);
		
		grid.gridwidth = 1;
		grid.gridy++;
		btn1.setPreferredSize(new Dimension(93,25));
		jpanel.add(btn1,grid);
		
		
		grid.gridx++;
		btn2.setPreferredSize(new Dimension(93,25));
		btn2.setEnabled(false);
		jpanel.add(btn2,grid);
		//********************************************
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Timer1 = new Thread(timer1);
				Timer1.start();
				
				Timer2 = new Thread(timer2);
				Timer2.start();
				btn1.setEnabled(false);
				btn2.setEnabled(true);
				
			}
		});
		//*********************************************
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Timer1.stop();
				
				
				Timer2.stop();
				btn1.setEnabled(true);
				btn2.setEnabled(false);
			}
		});
		
		
		
		
		add(jpanel,BorderLayout.WEST);
		setVisible(true);
		
		
	}
	private Runnable timer1 = new Runnable() {

		@Override
		public void run() {
			while(true) {
				// TODO Auto-generated method stub
				tf1.setText(new SimpleDateFormat("dd/MM/yy hh:mm:ss")
						.format(Calendar.getInstance().getTime()));

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};
	private Runnable timer2 = new Runnable() {

		@Override
		public void run() {
			while(true) {
				// TODO Auto-generated method stub
				tf2.setText(new SimpleDateFormat("dd/MM/yy hh:mm:ss")
						.format(Calendar.getInstance().getTime()));

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};
}
