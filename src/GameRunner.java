import java.awt.*;
import javax.swing.*;

public class GameRunner extends JFrame{
	public GameRunner() {
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(new GameRenderer("Test Map 2.png"), BorderLayout.CENTER);
		
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[]args) {
		GameRunner run = new GameRunner();
	}
}