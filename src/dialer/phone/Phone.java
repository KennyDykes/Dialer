package dialer.phone;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * By: Kenith Dykes
 */

public class Phone extends JApplet {
	static String PhoneNumber = "";
	JLabel Result;
	  public void init()
	    {
	      new Phone();
	    }
	public Phone()
	    {
   
		Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        	
        final JTextField text=new JTextField();
        
        JPanel upper = new JPanel();
        upper.setLayout(new GridLayout(3,1));
        
        upper.add(text);
        upper.add(new JLabel("#"));
        upper.add(Result = new JLabel(""));
    /*
     * Call Button is added to the upper panel and uses an anonymous class    
     */
        JButton call;
        upper.add(call = new JButton("Call"));
                call.addActionListener(
                        new ActionListener()

        {
        public void actionPerformed(ActionEvent e) {
                System.out.println("Dialling "+PhoneNumber);
             
                text.setText("Dialling "+PhoneNumber+".......\n");
        }    
        }   );
                
    /*
     * Disconnect Button is added to the upper panel and uses an anonymous class            
     */
        JButton disconnect;
        upper.add(disconnect=new JButton("Hang Up"));
        disconnect.addActionListener(
                new ActionListener(){
      public void actionPerformed(ActionEvent e) {
         System.out.println("Called "+PhoneNumber);
         text.setText("Call Ending.....\n");
        }});
       
        
        JPanel center=new JPanel();
        center.setLayout(new GridLayout(4,0));
        center.add(text);
/*
 * Buttons for all numbers are added to the lower panel and uses an anonymous class to handle the clicks
 */
        JPanel lower = new JPanel();
        lower.setLayout(new GridLayout(4,3));

        String [] Phone = {"7","8","9","4","5","6",
                        "1","2","3","*","0","#"};

        for (int i=0;i<Phone.length;i++) {
                JButton current;
                lower.add(current = new JButton(Phone[i]));
                current.addActionListener(
                        new ActionListener()
        {
        public void actionPerformed(ActionEvent e) {
                PhoneNumber = PhoneNumber + e.getActionCommand();
                Result.setText(PhoneNumber);
                }
        }

        );
        }
        cp.add(upper,BorderLayout.NORTH);
        cp.add(center,BorderLayout.CENTER);
        cp.add(lower,BorderLayout.SOUTH);
        
    
        }
		
		

}
