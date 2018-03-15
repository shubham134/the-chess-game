package chessgame.shubham.com;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ChessMen extends JLabel
{
	public ImageIcon imageIcon;
	public int pieceNo;
	
	public ChessMen(int n)
	{
		if(n >= 9 && n <= 16)
		{
			this.pieceNo = n;
			imageIcon = new ImageIcon("the-chess-game-master/images/white_pawn.png");
			setIcon(imageIcon);
		}
		else if(n <= -9 && n >= -16)
		{
			this.pieceNo = n;
			imageIcon = new ImageIcon("the-chess-game-master/images/black_pawn.png");
			setIcon(imageIcon);
		}
		else if(n == 1 || n == 8)
		{
			this.pieceNo = n;
			imageIcon = new ImageIcon("the-chess-game-master/images/white_rook.png");
			setIcon(imageIcon);
		}
		else if(n == -1 || n == -8)
		{
			this.pieceNo = n;
			imageIcon = new ImageIcon("the-chess-game-master/images/black_rook.png");
			setIcon(imageIcon);
		}
		else if(n == 2 || n == 7)
		{
			this.pieceNo = n;
			imageIcon = new ImageIcon("the-chess-game-master/images/white_knight.png");
			setIcon(imageIcon);
		}
		else if(n == -2 || n == -7)
		{
			this.pieceNo = n;
			imageIcon = new ImageIcon("the-chess-game-master/images/black_knight.png");
			setIcon(imageIcon);
		}
		else if(n == 3 || n == 6)
		{
			this.pieceNo = n;
			imageIcon = new ImageIcon("the-chess-game-master/images/white_bishop.png");
			setIcon(imageIcon);
		}
		else if(n == -3 || n == -6)
		{
			this.pieceNo = n;
			imageIcon = new ImageIcon("the-chess-game-master/images/black_bishop.png");
			setIcon(imageIcon);
		}
		else if(n == 4)
		{
			this.pieceNo = n;
			imageIcon = new ImageIcon("the-chess-game-master/images/white_king.png");
			setIcon(imageIcon);
		}
		else if(n == -5)
		{
			this.pieceNo = n;
			imageIcon = new ImageIcon("the-chess-game-master/images/black_king.png");
			setIcon(imageIcon);
		}
		else if(n == 5)
		{
			this.pieceNo = n;
			imageIcon = new ImageIcon("the-chess-game-master/images/white_queen.png");
			setIcon(imageIcon);
		}
		else if(n == -4)
		{
			this.pieceNo = n;
			imageIcon = new ImageIcon("the-chess-game-master/images/black_queen.png");
			setIcon(imageIcon);
		}
	}
}