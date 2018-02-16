import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VennDiagramTest
{
	public static void main(String[] args)
	{
		// Display an input dialog that prompts the user to enter
		// a number between 1 - 3 depending on the dialog being display
		String inputChoice = JOptionPane.showInputDialog("Enter 1 for A = B\n"
														+ "Enter 2 for A ∩ B = Φ \n" 
														+ "Enter 3 for A ∩ B ≠ Φ");
		
		int choice = Integer.parseInt(inputChoice); // convert inputChoice to an int
		
		// create a panel that contains the drawing
		VennDiagram panel = new VennDiagram(choice);
		
		// create a new panel to hold the drawing depending on what choices
		// the user enter between the number 1 to 3
		if(choice == 1) 
		{
			JFrame application = new JFrame("A = B");
			application.add(panel); // add the panel to the frame
			application.setSize(800,500); // set the size of the frame to 800 by 500
			application.setVisible(true); // make the frame visible
			
			// set the frame to exit when it is closed
			application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		}
		else if(choice == 2)
		{
			JFrame application = new JFrame("A ∩ B = Φ");
			application.add(panel); // add the panel to the frame
			application.setSize(800,500); // set the size of the frame to 800 by 500
			application.setVisible(true); // make the frame visible
			
			// set the frame to exit when it is closed
			application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		}
		else
		{
			JFrame application = new JFrame("A ∩ B ≠ Φ");
			application.add(panel); // add the panel to the frame
			application.setSize(800,500); // set the size of the frame to 800 by 500
			application.setVisible(true); // make the frame visible
			
			// set the frame to exit when it is closed
			application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		}
	}
}


