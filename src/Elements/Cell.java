package Elements;

import java.awt.Color;
import java.awt.Graphics;



public class Cell {
	private State state;
	private int size,x,y;
	public Cell(int size){
		this.size = size;
		state = State.Void;
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
	public void paint(Graphics g){
		g.setColor(Color.MAGENTA);
		g.fill3DRect(getX(), getY(), getSize(), getSize(), true);
	}

}
