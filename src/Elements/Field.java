package Elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;

public class Field extends JPanel {
	private final int SIZE = 10;
	private Font font;
	private final String al = "АБВГДЕЖЗИК";
	private Cell[][] cell;

	public Field() {
		super();
		cell = new Cell[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++) {
				cell[i][j] = new Cell(30);
				// cell[i][j].getSize()/2 - отсуп для цифр и букв
				cell[i][j]
						.setX(cell[i][j].getSize() * j + cell[i][j].getSize());
				cell[i][j]
						.setY(cell[i][j].getSize() * i + cell[i][j].getSize());

			}
		Cell firstCell = cell[0][0];
		font = new Font("Verdana", Font.PLAIN, firstCell.getSize() / 2);
		// Задаём размеры поля
		this.setPreferredSize(new Dimension(firstCell.getSize() * SIZE
				+ firstCell.getSize(), firstCell.getSize() * SIZE
				+ firstCell.getSize()));
		this.setDoubleBuffered(true);
		this.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent mouseEvent) {
				// TODO Auto-generated method stub
				if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
					for (int i = 0; i < SIZE; i++)
						for (int j = 0; j < SIZE; j++)
							if (cell[i][j].getX() < mouseEvent.getX()
									&& cell[i][j].getX() + cell[i][j].getSize() > mouseEvent
											.getX()
									&& cell[i][j].getY() < mouseEvent.getY()
									&& cell[i][j].getY() + cell[i][j].getSize() > mouseEvent
											.getY()) {
								cell[i][j].click();
								update(getGraphics());
							}
				}
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	// Очистка поля для генерации кораблей
	public void clear() {
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				cell[i][j].clear();
	}

	private int getCountDeck() {
		int count = 0;
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				if (cell[i][j].getState() == State.Deck)
					count++;
		return count;
	}

	private boolean checkDiapasone(Diraction diraction, int cordI, int cordJ,
			int countDeck) {
		// Проверка вокруг диапозона клеток
		// Стоит ли корабль
//		System.out.println(diraction + ":");
		switch (diraction) {
		case Up:
		case Down:
			if (cordI + diraction.get() * countDeck < SIZE
					&& cordI + diraction.get() * countDeck >= 0) {

				for (int i = diraction.get() == 1 ? cordI - 1 : cordI + 1, i1 = 0; i1 < countDeck+2; i += diraction
						.get(),i1++) {
					for (int j = cordJ - 1; j <= cordJ + 1; j++) {
						// System.out.println(i + " " + j);
						if (i >= 0 && i < SIZE && j >= 0 && j < SIZE)
							if (cell[i][j].getState() == State.Deck)
								return false;
					}
				}
			} else
				return false;
		case Left:
		case Rigth:
			if (cordJ + diraction.get() * countDeck < SIZE
					&& cordJ + diraction.get() * countDeck >= 0) {

				for (int i = cordI - 1; i <= cordI + 1; i++) {
					for (int j = diraction.get() == 1 ? cordJ - 1 : cordJ + 1,j1 = 0; j1<countDeck+2; j += diraction
							.get(),j1++) {
						// System.out.println(i + " " + j);
						if (i >= 0 && i < SIZE && j >= 0 && j < SIZE)
							if (cell[i][j].getState() == State.Deck)
								return false;
					}
				}

			} else
				return false;
		}

		return true;

	}

	private boolean putShip(Diraction diraction, int cordI, int cordJ,
			int countDeck) {
		switch (diraction) {
		case Down:

		case Up:
			if (checkDiapasone(diraction, cordI, cordJ, countDeck)) {
				for (int i = cordI, i1 = 0; i1 < countDeck; i += diraction
						.get(), i1++) {
					cell[i][cordJ].setState(State.Deck);
				}
				return true;
			} else
				return false;
		case Left:

		case Rigth:

			if (checkDiapasone(diraction, cordI, cordJ, countDeck)) {
				for (int j = cordJ, j1 = 0; j1 < countDeck; j += diraction
						.get(),j1++) {
					cell[cordI][j].setState(State.Deck);
				}
				return true;
			} else
				return false;
		default:
			return false;

		}
	}

	public void generate() {
		this.clear();
		int countDeck = 20;
		Random random = new Random();
		while (countDeck != 0) {

			int cordI = random.nextInt(SIZE);
			int cordJ = random.nextInt(SIZE);
			Diraction diraction = Diraction.values()[random.nextInt(Diraction
					.values().length)];
			// System.out.println(cordI+" "+ cordJ+" "+ diraction.toString());
			if (countDeck > 16) {
				// Расстановка четырёхпалубника
				if (putShip(diraction, cordI, cordJ, 4)) {
					System.out.println(diraction + " "+cordI+ " "+cordJ+ " "+4);
					countDeck -= 4;
				}

			} else if (countDeck > 10) {
				// Расстановка трёхпалубников
				if (putShip(diraction, cordI, cordJ, 3)) {
					System.out.println(diraction + " "+cordI+ " "+cordJ+ " "+3);
					countDeck -= 3;
				}

			} else if (countDeck > 4) {
				// Расстановка двухпалубников
				if (putShip(diraction, cordI, cordJ, 2)) {
					System.out.println(diraction + " "+cordI+ " "+cordJ+ " "+2);
					countDeck -= 2;
				}
			} else {
				// Расстановка однопалубников
				if (putShip(diraction, cordI, cordJ, 1)) {
					System.out.println(diraction + " "+cordI+ " "+cordJ+ " "+1);
					countDeck -= 1;
				}
			}

		}
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(cell[i][j].getState() == State.Deck ? 1 + " "
						: 0 + " ");
				cell[i][j].click();
			}
			System.out.println();

		}

	}

	@Override
	public void paint(Graphics g) {
		// Расставляем координаты для первых точек букв и цифр.
		Cell firstCell = cell[0][0];
		int x = firstCell.getX() - firstCell.getSize();
		int y = firstCell.getY() - firstCell.getSize() / 2;
		// Рисуем клетки
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++) {
				cell[i][j].paint(g);
			}
		// Рисуем буквы и цифры
		g.setColor(Color.black);
		g.setFont(font);
		for (int i = 0; i < SIZE; i++) {
			x += firstCell.getSize();
			y += firstCell.getSize();

			g.drawString(String.valueOf(al.charAt(i)), x + font.getSize() / 2,
					firstCell.getY() - firstCell.getSize() / 2);
			g.drawString(String.valueOf(i + 1),
					firstCell.getX() - firstCell.getSize(), y + font.getSize()
							/ 2);
		}

	}

}
