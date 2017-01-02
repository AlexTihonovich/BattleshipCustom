package Elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Cell {

	private boolean fire;
	private State state;
	private int size, x, y;
	private Color color;
	private Font font;

	public Cell(int size) {
		this.size = size;
		state = State.Void;
		fire = false;
		color = new Color(59, 89, 182);
		font = new Font("Verdana", Font.PLAIN, getSize() / 2);
	}

	public void clear() {
		state = State.Void;
		fire = false;
	}

	public void click() {
		fire = true;
		if (state == State.Void) {
			state = State.Miss;
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean getFire() {
		return fire;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fill3DRect(getX(), getY(), getSize(), getSize(), !fire);
		if (fire && state == State.Deck) {
			g.setFont(font);
			g.setColor(Color.red);
			g.drawString("X", getX() + getSize() / 2 - font.getSize() / 2,
					getY() + getSize() / 2);
		}
	}

}
