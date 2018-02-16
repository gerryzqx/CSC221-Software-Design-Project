import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

// Displays a intersection of two sets A and B 
// with ovals showing the three possible situations
// A = B, A ∩ B = Φ, and A ∩ B ≠ Φ 

public class VennDiagram extends JPanel
{
	private int choice; // user's choice of what possible set combinations
	
	// a constructor that set the user's choice
	public VennDiagram(int myChoice)
	{
		choice = myChoice;
	}
	
	// draw three different situations of venn diagrams based on the user input
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int width = getWidth()/2; // width is 392
		int height = getHeight()/2; // height is 230
		int radius = getWidth()/5; // radius is 156
		
		// Using switch cases to display the three different possible
		// situations for the sets A and B depending on what number
		// the user enters
		switch(choice)
		{
			// If user enters 1, draws a circle that is colored orange 
		   // in the center of the panel with the label A = B
			case 1:
				g.setColor(Color.ORANGE);
				// oval's (x,y,width,height) are (236,74,312,312) 
				g.fillOval(width - radius, height - radius, radius*2, radius*2);
				g.setColor(Color.BLACK);
				// location of "A = B" label is (377,70)
				g.drawString("A = B", width - 15, height - 160);
				break;
				
			// If user enters 2, draws two separate circle in the panel, 
			// one colored in magenta the other in light gray with the 
			// label A for the magenta circle and B for the light gray circle
			case 2:
				g.setColor(Color.MAGENTA);
				// oval's (x,y,width,height) are (392,74,312,312)
				g.fillOval(width, height - radius, radius*2, radius*2);
				g.setColor(Color.LIGHT_GRAY);
				// oval's (x,y,width,height) are (50,74,312,312)
				g.fillOval(width - 342, height - radius, radius*2, radius*2);
				g.setColor(Color.BLACK);
				// location of "A" label is (202, 70)
				g.drawString("A", width - 190, height - 160);
				// location of "B" label is (547,70)
				g.drawString("B", width + 155, height - 160);
				break;
			
			// If the user enters 3, draw two circles that intersect in 
			// the middle to form a venn diagram in the panel, one circle colored 
			// in blue the other circle colored in red with the intersection 
			// area colored in cyan. The blue circle is labeled A, red circle 
			// is labeled B and the intersection area is labeled A ∩ B
			case 3:
				g.setColor(Color.BLUE);
				// oval's (x,y,width,height) are (62,74,312,312)
				g.fillOval(width - 330, height - radius, radius*2, radius*2);
				g.setColor(Color.RED);
				// oval's (x,y,width,height) are (207,74,312,312)
				g.fillOval(width - 185, height - radius, radius*2, radius*2);
				g.setColor(Color.CYAN);
				// 1st half arc's (x,y,width,height,startAngle, arcAngle) are (148,85,220,290,287,146)
				g.fillArc(width - 244, height - 145, width - 172, height + 60 , radius + 131, radius - 10);
				// 2nd half arc's (x,y,width,height,startAngle, arcAngle) are (207,85,240,290,108,144)
				g.fillArc(width - 185, height - 145, width - 152 , height + 60, radius - 48, radius - 12);
				g.setColor(Color.BLACK);
				// location of "A" label is(202, 70)
				g.drawString("A", width-190, height-160);
				// location of "B" label is (367, 70)
				g.drawString("B", width -25, height-160);
				// location of "A ∩ B" label is (272,70)
				g.drawString("A ∩ B", width -120, height-160);
				break;
		}
	}
}
