import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.IOException;


public class GameRenderer extends JPanel{
	private int tileSize;
	private BufferedImage[][] map;	
	private boolean playerDrawLoc [][];
	private int[] playerLoc;
	
	
	public GameRenderer() {
		this.setPreferredSize(new Dimension(832, 832));
		
		tileSize = 64;
		
		playerDrawLoc = new boolean[this.getWidth() / tileSize][this.getHeight() / tileSize];
		playerDrawLoc[(int) Math.ceil(this.getPreferredSize().getWidth() / 2)]
				[(int) Math.ceil(this.getPreferredSize().getHeight() / 2)] = true;
		
		playerLoc = new int[] {0, 0};
	}
	
	public GameRenderer(int tileSize, int width, int height, String map) {
		this.tileSize = tileSize;
		this.setPreferredSize(new Dimension(width, height));
		
			try {
				this.map = loadMap(map);
			} catch (IOException e) {
				map = null;
			}
		
		playerDrawLoc = new boolean[this.getWidth() / tileSize][this.getHeight() / tileSize];
		playerDrawLoc[0][0] = true;
		
		playerLoc = new int[] {0, 0};
	}
	
	public GameRenderer(int tileSize, String map) {
		this.tileSize = tileSize;
		this.setPreferredSize(new Dimension(13 * tileSize, 13 * tileSize));
		
		try {
			this.map = loadMap(map);
		} catch (IOException e) {
			map = null;
			e.printStackTrace();
		}
		
		playerDrawLoc = new boolean[13][13];
		playerDrawLoc[0][0] = true;
		
		playerLoc = new int[] {0, 0};
	}
	//Testing
	public GameRenderer(String map) {
		this.tileSize = 64;
		this.setPreferredSize(new Dimension(13 * 64, 13 * 64));
		
		try {
			this.map = loadMap(map);
		}catch(IOException e) {
			map = null;
			e.printStackTrace();
		}
		
		playerDrawLoc = new boolean[13][13];
		playerDrawLoc[7][7] = true;
		
		playerLoc = new int[] {12, 12};
	}
	
	private BufferedImage[][] loadMap(String mapName) throws IOException{
		BufferedImage mapImg = ImageIO.read(this.getClass().getResource(mapName));
		int rows = mapImg.getHeight() / tileSize;
		int cols = mapImg.getWidth() / tileSize;
		BufferedImage[][] mapLoad = new BufferedImage[rows][cols];
		return mapLoad;
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.GRAY);
		int[] playerDraw = getPlayerDrawLoc();
		g.fillRect((playerDraw[1] - 1)* 64, (playerDraw[0] - 1) * 64, tileSize, tileSize);
	}
	
	public int[] getPlayerDrawLoc() {
		int[]playerLoc = new int[] {0, 0};
		
		for(int row = 0; row < playerDrawLoc.length; row ++) {
			for(int col = 0; col < playerDrawLoc[row].length; col ++) {
				if(playerDrawLoc[row][col]) {
					playerLoc[0] = row;
					playerLoc[1] = col;
				}
			}
		}
		return playerLoc;
	}
}