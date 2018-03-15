package chessgame.shubham.com;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JPanel
{
	public Square square[][] = new Square[8][8];
	public Color black = new Color(80, 80, 80);
	public Color white = new Color(255, 255, 255);
	public ChessMen chessMen[][] = new ChessMen[2][16];

	public Board() 
	{
		initilizeVariables();
		setLayout(new GridLayout(8, 8, 2, 2));
		for (int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				square[i][j].setPosition(i, j);
				add(square[i][j]);
			}
		}
	}

	public void initilizeVariables()
	{
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if((i + j) % 2 == 0 )
				{
					this.square[i][j] = new Square(i, j);
					this.square[i][j].setBackground(white);
				}
				else
				{
					this.square[i][j] = new Square(i, j);
					this.square[i][j].setBackground(black);
				}	
			}
		}
		
		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < 16; j++)
			{
				if(i == 0)
					chessMen[i][j] = new ChessMen((-1) * (j + 1));
				else
					chessMen[i][j] = new ChessMen(j + 1);
			}	
		}
	}
	
	public void initializeChessBoard()
	{
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				this.square[i][j].setStatus(true);
			}
		}
		
		for(int i = 0, k = 0; i < 2; i++)
		{
			for(int j = 0; j < 8; j++, k++)
			{
				this.square[i][j].add(chessMen[0][k]);
				this.square[i][j].setChessMen(chessMen[0][k]);
				this.square[i][j].setStatus(false);
			}
		}
		
		for(int i = 7, k = 0; i >= 6; i--)
		{
			for(int j = 7; j >= 0; j--, k++)
			{
				this.square[i][j].add(chessMen[1][k]);
				this.square[i][j].setChessMen(chessMen[1][k]);
				this.square[i][j].setStatus(false);
			}
		}
	}
}