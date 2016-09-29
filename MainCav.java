import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.naming.InitialContext;


class MainCav extends Canvas implements MouseListener, MouseMotionListener, MouseWheelListener {
	Random random = new Random();
	int level = 1, line = 0, score = 0;
	int curt = 1, curtId = 0;
	int next = random.nextInt(7);
	Shapes shapes = new Shapes();
	Color[] colors = shapes.getColor();
	boolean[][] curtShape = shapes.getShape(curt, curtId), nextShape = shapes.getShape(next, 0);
	int[] curtBounds = shapes.getBound(curt, curtId);
	private int xO, yO, len;
	private int unit = 28;
	private boolean mouse;
	private boolean end = false;
	int curtX = 40 + 3 * 28, curtY = 56;
	int nextX = 40 + 12 * 28, nextY = 56;
	int leftBound = 40, rightBound = 40 + 10 * 28, upBound = 56, bottomBound = 56 + 20 * 28;
	Color[][] board = new Color[20][10];

	public  MainCav() {
//		board[19][1] = Color.black;
		addMouseMotionListener(this);
		addMouseListener(this);
		addMouseWheelListener(this);
		InitialContext();
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], null);
		}
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(!end){
					if (!mouse) {
						if (touchBottom()) {
							saveCurt();
							delete();
							curt = next;
							curtId = 0;
							next = random.nextInt(7);
							curtX = 40 + 3 * 28;
							curtY = 56;
						} else {
							curtY += unit;
						}
					}
					repaint();
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
	}
	public void InitialContext() {
		
	}
	void initgr(Graphics g) {
		Dimension dimension = getSize();
		int maxX = dimension.width - 1;
		int maxY = dimension.height - 1;
		len = Math.min(maxX,  maxY);
		float height = 0.95F * len;
		unit = (int) (height / 20F);
		xO = 40;
		yO = 56;
	}

	int iX(int x) {
		return xO + (x - 1) * unit;
	}
	int iY(int y) {
		return yO + (y - 1) * unit;
	}
	int round(float x) {
		return Math.round(x);
	}


	public void drawCube(int x, int y, Graphics g, Color color) {
		g.setColor(Color.BLACK);
		g.drawRect(x, y, unit, unit);
		g.setColor(color);
		g.fillRect(x, y, unit, unit);
	}

	public  void freshCurtShape(int x, int y, boolean[][] curtShape, Graphics g) {
		for (int i = 0; i < curtShape.length; i++) {
			for (int j = 0; j < curtShape[i].length; j++) {

				if (curtShape[i][j]) {
					drawCube(x + j * unit, y + i * unit, g, colors[curt]);
				}
			}
		}
	}
	
	public  void freshNextShape(int x, int y, boolean[][] nextShape, Graphics g) {
		for (int i = 0; i < nextShape.length; i++) {
			for (int j = 0; j < nextShape[i].length; j++) {

				if (nextShape[i][j]) {
					drawCube(x + j * unit, y + i * unit, g, colors[next]);
				}
			}
		}
	}
	public void paint(Graphics g) {
		initgr(g);
		// draw main canv
		g.drawRect(xO, yO, 10 * unit, 20 * unit);
		// draw next shape canv
		g.drawRect(xO + 11 * unit, yO, 6 * unit, 4 * unit);

		curtShape = shapes.getShape(curt, curtId);
		nextShape = shapes.getShape(next, 0);
		curtBounds = shapes.getBound(curt, curtId);
		freshCurtShape(curtX, curtY, curtShape, g);
		freshNextShape(nextX, nextY, nextShape, g);
		freshBoard(g);
		if(mouse){
			g.setColor(new Color(0, 102, 204));
			g.setFont(new Font("Font.TYPE1_FONT", Font.BOLD, round(1.3F * unit)));
			g.drawRect(xO + round(2.6F * unit), round(yO + 8F * unit), round(5.4F * unit), round(1.6F * unit));
			g.drawString("PAUSE", xO + round(3.2F * unit), round(yO + 9.2F * unit));
		}



		Font font = new Font("Font.TYPE1_FONT", Font.BOLD, Math.round(0.8F * unit));
		g.setFont(font);
		g.setColor(Color.BLACK);
		
		g.drawString("Level:         " + level, xO + 12 * unit, yO + 9 * unit);	
		g.drawString("Line:          " + line, xO + 12 * unit, yO + 11 * unit);	
		g.drawString("Score:        " + score, xO + 12 * unit, yO + 13 * unit);	

		// draw quit
		g.drawRect(xO + 12 * unit, yO + 18 * unit, round(4F * unit), round(1.6F * unit));
		g.drawString("QUIT", round(xO + 12.8F * unit), round(yO + 19.2F * unit));
	}
	
	public void saveCurt() {
		for (int i = 0; i < curtShape.length; i++) {
			for (int j = 0; j < curtShape[0].length; j++) {
				if (curtShape[i][j] == false) continue;
				int xIndex = (curtY - 56) / unit + i;
				int yIndex = (curtX - 40) / unit + j;
				board[xIndex][yIndex] = colors[curt];
			}
		}
	}
	
	public void delete() {
		for (int i = 0; i < board.length; i++) {
			int j = 0;
			for (; j < board[0].length; j++) {
				if (board[i][j] == null) break;
			}
			if (j == board[0].length) {
				line += 1;
				score += level;
				for (int k = i; k >= 0; k--) {
					if (k == 0) Arrays.fill(board[0], null);
					else board[k] = board[k - 1]; 
				}
			}
		}
	}
	public boolean touchBottom() {
		for (int i = 0; i < curtShape.length; i++) {
			for (int j = 0; j < curtShape[0].length; j++) {
				if (curtShape[i][j] == false) continue;
				int xIndex = (curtY - 56) / unit + i;
				int yIndex = (curtX - 40) / unit + j;
				if (xIndex == 19 || board[xIndex + 1][yIndex] != null) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public void freshBoard(Graphics g) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j]== null) continue;
				drawCube(40 + j * unit, 56 + i * unit, g, board[i][j]);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		int leftX = xO + 12 * unit;
		int rightX = xO + 12 * unit + round(4F * unit);
		int upperY = yO + 18 * unit;
		int lowerY = yO + 18 * unit + round(1.6F * unit);
		if(x  >= leftX && x <= rightX && y >= upperY && y <= lowerY){
			System.exit(0);
		}
	}
	

	// This part is for the function of pause the game

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(x >= xO && x <= xO + 10 * unit && y >= yO && y <= yO + 20 * unit){
			mouse = true;
		}else{
			mouse = false;
		}
//		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getModifiers() == InputEvent.BUTTON1_MASK) {
			if (curtX + curtBounds[1] * unit == leftBound) return;
			curtX -= unit;
			repaint();
		} else if(e.getModifiers() == InputEvent.BUTTON3_MASK) {
			if (curtX + curtBounds[0] * unit == rightBound) return;
			curtX += unit;
			repaint();
		}
			
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		if(e.getWheelRotation() < 0){
			if (curtId == 3) {
				curtId = 0;
			} else {
				curtId++;
			}
			move();
			
		} else {
			if (curtId == 0) {
				curtId = 3;
			} else {
				curtId--;
			}
			move();
		}
		repaint();
	}
	public void move() {
		int left = curtX + shapes.getBound(curt, curtId)[1] * unit;
		while (left < leftBound) {
			curtX += unit;
			left += unit;
		}
		int right = curtX + shapes.getBound(curt, curtId)[0] * unit;
		while (right > rightBound) {
			curtX -= unit;
			right -= unit;
		}
		int bottom = curtY + shapes.getBound(curt, curtId)[2] * unit;
		while (bottom > bottomBound) {
			curtY -= unit;
			bottom -= unit;
		}
	}

}