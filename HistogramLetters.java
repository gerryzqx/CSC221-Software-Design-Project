import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;

// A program that calculates the n most frequent letters in a text file
// and calculate their probabilities and display it on a pie chart
public class HistogramLetters extends JPanel
{
	private char letter; // Keep track of which letter it is
	private double value; // Keep track of the value of each letter 
	private static double freqOfAllLetters; // Hold the total value of all the letters frequency
	private int n; // User choice for the n most frequent letters
	private static HistogramLetters[] character2; // Stores the letters and value in character2 object array
	
	// Constructor that copies the character values of letter to letter2
	HistogramLetters(char letter2)
	{
		letter = letter2;
	} 
	// Constructor that takes in the user's choice for n most frequent letters
	HistogramLetters(int myChoiceOfN)
	{
		n = myChoiceOfN;
	}
	// Count the characters in the specified char array, add the results 
	// to the values in character and count all the countable characters 
	// and add them to freqOfAllLetters
   public static void countLetters(String line, HistogramLetters[] character) 
   {
   	String lowerCase = line.toLowerCase(); // Change uppercase letters to lowercase
  	 	char[] individualChar = lowerCase.toCharArray(); // Convert the string lowerCase to char
	
  	 	for(int i = 0; i < individualChar.length; i++) 
  	 	{
  	 		if( individualChar[i] >= 'a' && individualChar[i] <= 'z') 
  	 		{
  	 			character[individualChar[i] - 'a'].value++; // Increment the value of that letter
  	 			freqOfAllLetters++; // Increment every time a character is counted
  	 		}
  	 	}
   }
   // Sort the array of HistogramLetters based on letter frequency
   public static void sortElement(HistogramLetters[] character) 
   {
   	HistogramLetters temp;

   	// Sort each element of the character array
   	for(int i = 0; i < character.length; i++)
   	{
   		// Find the smallest element in the rest of the character array
   		for(int j = i+1; j < character.length; j++)
   		{
   			// If we found something smaller than the current element
   			if(character[j].value > character[i].value) 
   			{
   				// Swap it with the current element
   				temp = character[i];
   				character[i] = character[j];
   				character[j] = temp;
   			}
   		}
   	}
   }

   // Calculate the probability of each letter by dividing each letter's frequency
   // by the freqOfAllLetters
   public static void probabilityOfLetters(HistogramLetters[] character)
   {
   	for(int i = 0; i < character.length; i++)
 		{
   	 	character[i].value = (character[i].value/freqOfAllLetters);
 		}
   }
   // Round the frequency number to 4 decimal place
   public static void roundDecimal(HistogramLetters[] character)
   {
   	for(int i = 0; i < character.length; i++)
   	{
   		character[i].value = (double)Math.round(character[i].value * 10000)/10000;
   	}
   }
   
   // Copy the elements in character into character2
   public static void copyArrayElements(HistogramLetters[] character)
   {
   	character2 = character.clone(); // Create a exact copy of the character array
   }
   
   Color cadet = new Color(91,158,160); // Create the color cadet
   Color chocolate = new Color(210,105,30); // Create the color chocolate
   Color brown = new Color(165,42,42); // Create the color brown
   Color darkGreen = new Color(0,100,0); // Create the color dark green
   Color tan = new Color(210,180,140); // Create the color tan
   Color teal = new Color(0,128,128); // Create the color teal
   Color olive = new Color(128,128,0); // Create the color olive
   Color slateBlue = new Color(106,90,205); // Create the color slate blue
   Color darkKhaki = new Color(189,183,107); // Create the color dark Khaki
   Color indigo = new Color(75,0,130); // Create the color indigo
   Color crimson = new Color(220,20,60); // Create the color crimson
   Color orangeRed = new Color(255,69,0); // Create the color orange red
   Color rosyBrown = new Color(188,143,143); // Create the color rosy brown
   Color silver = new Color(192,192,192); // Create the color silver
   Color seaGreen = new Color(46,139,87); // Create the color sea green
   Color darkSlateBlue = new Color(72,61,139); // Create the color dark slate blue
   Color purple = new Color(128,0,128); // Create the color purple 
   
   // Put all these color into a array called colors along with pre-built in colors
   Color[] colors = { cadet, Color.BLUE, chocolate, Color.DARK_GRAY, Color.GRAY,
   						 Color.BLACK,Color.MAGENTA, Color.PINK, darkGreen, brown, Color.GREEN,
   						 Color.RED, Color.CYAN, tan, teal, olive, slateBlue, darkKhaki, indigo,
   						 crimson, orangeRed, rosyBrown, silver, seaGreen, darkSlateBlue, purple};
   
   // Create the paintComponent method to begin drawing the pie chart by calling the drawPieChart method
   public void paintComponent(Graphics g)
   {
   	 super.paintComponent(g);
   	 drawPieChart((Graphics) g, colors, character2, n); // Call the drawPieChart method
   }
   
   // Display the n most frequent letters with it probability in the xWords text file 
   // in the form of a pie chart
   public void drawPieChart(Graphics g, Color[] colors, HistogramLetters[] character, int n)
   {
   	double otherProb = 1.0; // calculate the remaining probability of other letters
   	double currentValue = 0.0; // Set currentValue to 0
   	int startAngle = 0; // Starting angle to be 0
   	int arcAngle = 0; // Starting arc angle to be 0
   	int x = 560; // Initial x coordinate for drawString method
   	int y = 50; // Initial y coordinate for drawString method
   	int xCord = 500; // Initial x coordinate for fillRect method
   	int yCord = 30; // Initial y coordinate for fillRect method 
   	int xNew = 630; // Initial x coordinate for the legend
		int yNew = 30; // Initial y coordinate for the legend
		int xNew2 = 690;  // Initial x coordinate for labeling the legend
		int yNew2 = 50; // initial y coordinate for labeling the legend
		g.setFont(new Font("default",Font.BOLD,12)); // make font bold
		g.drawString("Legend Key",580,20); // write legend above the legend
		//g.drawString("Total letters: " + (int)freqOfAllLetters, 200, 50);
   	for(int i = 0; i < n; i++) 
   	{
   		startAngle = (int)((currentValue * 360)+ 0.7); // Calculate the start angle for each segment
   		arcAngle = (int)((character[i].value * 360)+ 0.7); // Calculate the arc angle for each segment
   		g.setColor(colors[i]); // Set the color to the colors array at index i
   		g.fillArc(60,100,400,400,startAngle,arcAngle); // Draw the pie chart for each slice
   		if(y > x && yCord > x)
   		{
   			g.fillRect(xNew,yNew,50,30); // fill a rectangle with the given color to represent the legend
   			// label the legend block with the letter along with the probability of the letter
      		g.drawString("= "+ character[i].letter + ", " + character[i].value, xNew2, yNew2);
      		yNew2 += 40;
      		yNew += 40;
   		}
   		else
   		{
   			g.fillRect(xCord,yCord,50,30);
   			g.drawString("= "+ character[i].letter + ", " + character[i].value, x, y);
   			yCord += 40;
   			y += 40; 
   		}
   		currentValue += character[i].value; // sum up all the frequency values at index i
   	}
   	otherProb -= currentValue; // Calculate the remaining probability of remaining letters
   	otherProb = (double)Math.round(otherProb * 10000)/10000; // round to 4 decimal place
   	startAngle = (int)((currentValue * 360)+ 0.5); // Obtain the startAngle value
   	arcAngle = (int)((otherProb * 360)+ 0.5); // Calculate the arc angle for otherProb
   	g.setColor(Color.ORANGE); // Set the color to Orange
   	g.fillArc(60,100,400,400,startAngle,arcAngle); // Draw the remaining slice of the pie chart
   	if(y > x && yCord > x && n != 26)
   	{
   		g.fillRect(xNew, yNew, 50, 30);
   		g.drawString("= All other letters, " + otherProb, xNew2, yNew2); 
   	}
   	else
   	{
   		g.fillRect(xCord, yCord, 50, 30);
   		g.drawString("= All other letters, " + otherProb, x, y); 
   	}
   }
   
   public static void main(String[] args) 
   {
   	HistogramLetters[] character = new HistogramLetters[26]; // create a HistogramLetter array
 	
   	// Initialize the character array
 		for(int i = 0; i < character.length; i++)
 		{
 			character[i] = new HistogramLetters((char)(i + 'a')); // stores letters a-z in the array
 		}
 		try 
 		{
 			// Display an input dialogue that prompts the user to enter a text file ending with .txt
 			String text = JOptionPane.showInputDialog("Enter the text file with ending .txt");
 			
 			// Open the text file.
 			File file = new File(text);
 			Scanner textFile = new Scanner(file);
 			
 	 		// Read one line at a time as a String and call 
 			// countLetters to count the letters in that string
 			while(textFile.hasNext()) 
 			{
 				String line = textFile.next();
 				countLetters(line, character);
 			}
 			textFile.close(); // Close scanner to read the textFile
 		}
 		catch(FileNotFoundException e)
 		{
 			// Display this error message if text file you enter is not found
 			JOptionPane.showMessageDialog(null,"File Not Found!", "Error Message",
 													JOptionPane.ERROR_MESSAGE);
 			System.exit(0);
 		}

 		// Method that sort the list by frequency
 		sortElement(character);
 		// Method that calculate the probability of each letter
 		probabilityOfLetters(character);
 		// Method that rounds the frequency number to 4 decimal place
 		roundDecimal(character);
 		// Method that copy the elements in the character object to a new character object
 		copyArrayElements(character);
 		
 		// Display an input dialogue that prompts the user to enter
 		// a number n to calculate the n most frequent letters in the text file
 		String inputChoice = JOptionPane.showInputDialog("Enter a number n to display the n\n"
 																		+ "most frequent letters in a pie chart");
 		int choice = Integer.parseInt(inputChoice); // Convert inputChoice to an int
 		
 		HistogramLetters panel = new HistogramLetters(choice);
 		JFrame application = new JFrame("Histogram Letters Pie Chart");
 		application.add(panel); // Add the panel to the frame
 		application.setSize(850,630); // Set the size of the frame to 850 by 630
 		application.setVisible(true); // Make the frame visible
 		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Set the frame to exit when it is closed
   }
}