
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.applet.*;
import javax.swing.JLabel;
import java.text.DecimalFormat;
import javax.swing.Timer;



class RunControl {
	public boolean runOK;
}

class Data implements Runnable
{
	private static final int left = 10;
	private static final int top = 300;
	private static final int width = 120;
	private static final int height = 150;
	private static final int inset = 5;
	
	private static final Color tankColor = new Color(5,5,5);
	private static final Color fillColor = new Color( 25, 25,112);
	private static final Color emptyColor = new Color(240,248,255);
	private static final int xstr = 20;
	private static final int ystr = 40;
	
	private JPanel	displayPanel;
	private int currentDepth;
	private double increment;
	private int sleepTime;
	private int limit;
	private RunControl check;

        
	
	public Data(RunControl rc)
	{
		check = rc;
		restart();
	}
	
	public void restart() { 
		currentDepth = 0;  
		increment =  1; 
		sleepTime = 250; 
		limit = height - inset;      
	}
	
	public void setLinkToPanel(JPanel aPanel) { displayPanel = aPanel; }
	
	public void paint(Graphics g)
	{
		int waterLevel = currentDepth;
		
		Color c = g.getColor();
		g.setColor(Color.WHITE); 
		g.fillRect(0,0,displayPanel.getWidth(),displayPanel.getHeight()); 
		g.setColor(Color.BLACK);		
		g.setColor(tankColor);
		g.fillRect(left, top, width, height);
		g.setColor(emptyColor);
		g.fillRect(left+inset, top, width-2*inset, height-inset);
		g.setColor(fillColor);
		g.fillRect(left+inset, top+height-inset-currentDepth, width-2*inset, currentDepth);		
		
		g.setColor (new Color(0,0,0));        //water level
		g.drawString("Water Level =",20 ,250);
		g.drawString(String.valueOf(waterLevel),100,250);
		
		
		g.setColor (new Color(139,69,19));   //house color
        g.fillRect (200,20,400,430);
        g.setColor(new Color(190,190,190));   //doors and chimney  
        g.fillRect (345,380,110,70);
        g.setColor (new Color(186,134,11));   //door knobs
        g.fillOval (382,412,10,10);
        g.fillOval (407,412,10,10);
        g.setColor (new Color(186,134,11));   //windows outer frame effec
        g.fillRect (221,61,78,78);
        g.fillRect (221,261,78,78);
        g.fillRect (221,361,78,78);
        g.fillRect (221,161,78,78);
        g.fillRect (501,261,78,78);
        g.fillRect (501,361,78,78);
        g.fillRect (501,61,78,78);
        g.fillRect (501,161,78,78);
        g.setColor (new Color(175,238,238));   //windows
        g.fillRect (225,65,70,70);
        g.fillRect (225,165,70,70);
        g.fillRect (225,265,70,70);
        g.fillRect (225,365,70,70);
        g.fillRect (505,65,70,70);
        g.fillRect (505,165,70,70);
        g.fillRect (505,265,70,70);
        g.fillRect (505,365,70,70);
        g.setColor (new Color(139,69,19));   //door sections
        g.fillRect (398,380,2,70);
        g.setColor (new Color(186,134,11));   //inner frame effect
        g.fillRect (257,265,5,70);
        g.fillRect (257,365,5,70);
        g.fillRect (257,165,5,70);
        g.fillRect (257,65,5,70);
        g.fillRect (538,265,5,70);
        g.fillRect (538,365,5,70);
        g.fillRect (538,165,5,70);
        g.fillRect (538,65,5,70);
        g.fillRect (225,298,70,5);
        g.fillRect (225,398,70,5);
        g.fillRect (225,198,70,5);
        g.fillRect (225,98,70,5);
        g.fillRect (505,298,70,5);
        g.fillRect (505,398,70,5);
        g.fillRect (505,198,70,5);
        g.fillRect (505,98,70,5);
                
        g.setColor (new Color(240,248,255));   //water pipe
        g.fillRect (100,400,100,10);
    
	}
	


	public void run()
	
	{
		///>/>
		for(;;) {

/*Claim (and temporarily at least Lock) the coordination object.
If it isn't ok to run, then wait for the object to be changed.  While
this thread is waiting, release the lock on the coordination object.
This thread will resume after a "notify" is performed by some other thread.
This thread should then check whether it is ok to continue.
*/
			synchronized(check) {
				while(!check.runOK) { 
					try { check.wait(); } catch(InterruptedException ie) { }
				}
			}
		
			if(increment>0) {
				// Tank is filling
				if(currentDepth < limit) {
					currentDepth += increment;	

					if(currentDepth>limit) currentDepth = limit;
				}
				else {
					// Tank is full
					limit = 0;
					increment = - increment;
				}
		}
			else {
				// Tank is Emptying
				if(currentDepth>0) {
					currentDepth += increment;  // -ve increment makes it go down!
					if(currentDepth<0) currentDepth = 0;
				}
				else {
					// Tank is empty
					limit = height - inset;
					increment = - increment;

				}	
			}
			displayPanel.repaint();
			try { Thread.sleep(sleepTime); } catch(InterruptedException ie) {}
		}
	}	


}
class MyPanel extends JPanel {
	Data fData;
	
	public MyPanel(Data aData) {  
		setPreferredSize(new Dimension(400,400));
		fData = aData;
	}

	public void paint(Graphics g) { 
		fData.paint(g);
	}
}

class GUI1 extends JFrame implements ActionListener {
    
        
	private static final String suspend = "Suspend";
	private static final String resume = "Resume";
	private boolean running;
	private MyPanel fPanel;
	private JButton fStartButton;
	private Data fData;
	private Thread fWorkThread;
	private RunControl fCheck;

	final JLabel label = new JLabel (String.valueOf (System.currentTimeMillis()));

	JLabel waterLevel;
    
	public void actionPerformed(ActionEvent e)
	{

/*You might want to lock the coordination variable while changing 
a value in its data field.  But in this case the value
is just a boolean so there won't be any issues of partial
updates etc.
 * */           
		
		if(running) {
			running = false;
			fCheck.runOK = false;
			fStartButton.setText(resume);
			                        
		}
		else {
									
			running = true;
			fCheck.runOK = true;
			fStartButton.setText(suspend);
			

/*Have changed the coordination variable, implicitly releasing any thread
blocked waiting for it to be ok to resume running.
Must also notify any such threads that it is now
appropriate for them to re-examine their state.
 */
 			
			synchronized(fCheck) { fCheck.notify(); }
		}
	}



	public GUI1()
	{
            
                
		fCheck = new RunControl();
		fData = new Data(fCheck);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		fPanel = new MyPanel(fData);
                
		this.getContentPane().add(fPanel, BorderLayout.CENTER);
		fData.setLinkToPanel(fPanel);
	        
	    //this.getContentPane().add(waterLevel, BorderLayout.NORTH);
	    
		fStartButton = new JButton(resume);
		fStartButton.addActionListener(this);
		this.getContentPane().add(fStartButton, BorderLayout.SOUTH);
		this.pack();
		running = false;
		fWorkThread = new Thread(fData);
		fWorkThread.start();
		
	
	         
	}
	
}


public class WaterTank extends Applet{
	public static void main(String[] args)
	{
		
		GUI1 aGUI = new GUI1();
		aGUI.setSize(800,600);
        aGUI.setLocationRelativeTo(null);
		aGUI.show();
	}
}


