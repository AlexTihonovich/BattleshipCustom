package Elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Field extends JPanel{
	private final int SIZE = 10;
	private Font font;
	private final String al = "АБВГДЕЖЗИК";
	private Cell[][] cell;
	public Field(){
		super();
		cell = new Cell[SIZE][SIZE];
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++){
				cell[i][j] = new Cell(30);
				//cell[i][j].getSize()/2 - отсуп для цифр и букв
				cell[i][j].setX(cell[i][j].getSize()*i+cell[i][j].getSize()/2);
				cell[i][j].setY(cell[i][j].getSize()*j+cell[i][j].getSize()/2);
				
			}
		Cell firstCell = cell[0][0];
		font = new Font("Verdana", Font.PLAIN, firstCell.getSize()/2);
		//Задаём размеры поля
		this.setPreferredSize(new Dimension(firstCell.getSize()*SIZE+firstCell.getSize()*2,
				firstCell.getSize()*SIZE+firstCell.getSize()*2));
		this.setDoubleBuffered(true);
	
	}
	@Override
	public void paint(Graphics g){
		//Расставляем координаты для первых точек букв и цифер.
		Cell firstCell = cell[0][0];
		int x = firstCell.getX() - firstCell.getSize();
		int y = firstCell.getY() - firstCell.getSize()/2;
		//Рисуем клетки
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++){
				cell[i][j].paint(g);
			}
		//Рисуем буквы и цифры
		g.setColor(Color.black);
		g.setFont(font);
		for(int i = 0; i < SIZE; i++){
			x+= firstCell.getSize();
			y+= firstCell.getSize();
			
			g.drawString(String.valueOf(al.charAt(i)), x+font.getSize()/2, firstCell.getY());
			g.drawString(String.valueOf(i+1), firstCell.getX()-firstCell.getSize()/2,y+font.getSize()/2 );
			
		}
	}
	

}
