package Elements;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Field extends JPanel{
	private final int SIZE = 10;
	private Cell[][] cell;
	public Field(){
		super();
		cell = new Cell[SIZE][SIZE];
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++){
				cell[i][j] = new Cell(20);
				//cell[i][j].getSize()/2 - отсуп для цифр и букв
				cell[i][j].setX(cell[i][j].getSize()*i+cell[i][j].getSize()/2);
				cell[i][j].setY(cell[i][j].getSize()*j+cell[i][j].getSize()/2);
				
			}
		Cell oneCell = cell[0][0];
		//Задаём размеры поля
		this.setPreferredSize(new Dimension(oneCell.getSize()*SIZE+oneCell.getSize(),
				oneCell.getSize()*SIZE+oneCell.getSize()));
		this.setDoubleBuffered(true);
	
	}
	@Override
	public void paint(Graphics g){
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++){
				cell[i][j].paint(g);
			}
	}
	

}
