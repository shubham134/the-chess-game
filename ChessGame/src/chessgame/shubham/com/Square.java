package chessgame.shubham.com;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Square extends JPanel
{
	private boolean status = true;
	private ChessMen chessMen;
	private int row;
	private int col;
	
	public Square(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	
	public boolean getStatus()
	{
		return this.status;
	}
	
	public void setStatus(boolean status)
	{
		this.status = status;
	}
	
	public ChessMen getChessMen()
	{
		return this.chessMen;
	}
	
	public void setChessMen(ChessMen chessMen)
	{
		this.chessMen = chessMen;
	}

	public void setPosition(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	
	public int getRow()
	{
		return this.row;
	}

	public int getCol()
	{
		return this.col;
	}
}