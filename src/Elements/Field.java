package Elements;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Field extends JPanel{
	private final int SIZE = 10;
	private Cell[][] cell;
	public Field(){
		super();
		cell = new Cell[SIZE][SIZE];
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++)
				cell[i][j] = new Cell(20);
	}
	@Override
	public void paint(Graphics g){
		
	}
	

}
