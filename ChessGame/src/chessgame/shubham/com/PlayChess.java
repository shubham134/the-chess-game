package chessgame.shubham.com;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JFrame;
import java.awt.Color;

@SuppressWarnings("serial")
public class PlayChess extends JFrame implements MouseListener
{	
	public static Board board = new Board();
	public static ChessMen  playChessMen = null;
	public static Square clicked = null;
	public static Square source = null;
	public static Square target = null;
	public Random rand = new Random();
	
	public int N, row, col, tgtRow, tgtCol, optCount;
	public String mode = "white";
//	public String mode = "black";
	public int deletedKing = 0;
//	public static String pMode = "computerOnly";	
//	public static String pMode = "withComputer";
	public static String pMode = "withFriend";
	
	public Color blue = new Color(0, 200, 255);
	public Color red = new Color(255, 20, 20);
	public Color white = new Color(255, 255, 255);
	public Color black = new Color(80, 80, 80);
	public Color green = new Color(20, 255, 20);
	
	public PlayChess()
	{
		getContentPane().add(board);
		board.initializeChessBoard();
		selectActiveSquare();
	}

	void selectActiveSquare()
	{
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				board.square[i][j].addMouseListener(this);
			}	
		}
	}
	
	void initBackground()
	{
		for(int x = 0; x < 8; x++)
		{
			for(int y = 0; y < 8; y++)
			{
				if((x + y) % 2 == 0)
					board.square[x][y].setBackground(white);
				else
					board.square[x][y].setBackground(black);
			}
		}
	}
	
	void displayWinner(int deletedKing)
	{
		if(deletedKing < 0)
		{
			System.out.println("WHITE WINS!!!");
		}
		else if(deletedKing > 0)
		{
			System.out.println("BLACK WINS");
		}
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				board.square[i][j].removeMouseListener(this);
			}	
		}
	}
	
	void plus(int m, int n)
	{
		float a;
		a = board.square[m][n].getChessMen().pieceNo;
		for(int j = n ; j >= 0 ; j--)
		{
			if(board.square[m][j].getStatus())
			{
				optCount++;
				board.square[m][j].setBackground(blue);
			}
			else if(a / board.square[m][j].getChessMen().pieceNo < 0)
			{
				optCount++;
				board.square[m][j].setBackground(red);
				break;
			}
			else if(a / board.square[m][j].getChessMen().pieceNo > 0 && a != board.square[m][j].getChessMen().pieceNo)
			{
				break;
			}
		}
		for(int j = n ; j <= 7 ; j++)
		{
			if(board.square[m][j].getStatus())
			{
				optCount++;
				board.square[m][j].setBackground(blue);
			}
			else if(a / board.square[m][j].getChessMen().pieceNo < 0)
			{
				optCount++;
				board.square[m][j].setBackground(red);
				break;
			}
			else if(a / board.square[m][j].getChessMen().pieceNo > 0 && a != board.square[m][j].getChessMen().pieceNo)
			{
				break;
			}
		}
		for(int i = m ; i >= 0 ; i--)
		{
			if(board.square[i][n].getStatus())
			{
				optCount++;
				board.square[i][n].setBackground(blue);
			}
			else if(a / board.square[i][n].getChessMen().pieceNo < 0)
			{
				optCount++;
				board.square[i][n].setBackground(red);
				break;
			}
			else if(a / board.square[i][n].getChessMen().pieceNo > 0 && a != board.square[i][n].getChessMen().pieceNo)
			{
				break;
			}
		}
		for(int i = m ; i <= 7 ; i++)
		{
			if(board.square[i][n].getStatus())
			{
				optCount++;
				board.square[i][n].setBackground(blue);
			}
			else if(a / board.square[i][n].getChessMen().pieceNo < 0)
			{
				optCount++;
				board.square[i][n].setBackground(red);
				break;
			}
			else if(a / board.square[i][n].getChessMen().pieceNo > 0 && a != board.square[i][n].getChessMen().pieceNo)
			{
				break;
			}
		}
	}
	
	void cross(int m, int n)
	{
		float a;
		a = board.square[m][n].getChessMen().pieceNo;
		for(int i = m, j = n ; i >= 0 && j >= 0 ; i--, j--)
		{
			if(board.square[i][j].getStatus())
			{
				optCount++;
				board.square[i][j].setBackground(blue);
			}
			else if(a / board.square[i][j].getChessMen().pieceNo < 0)
			{
				optCount++;
				board.square[i][j].setBackground(red);
				break;
			}
			else if(a / board.square[i][j].getChessMen().pieceNo > 0 && a != board.square[i][j].getChessMen().pieceNo)
			{
				break;
			}
		}
		for(int i = m, j = n ; i <= 7 && j <= 7 ; i++, j++)
		{
			if(board.square[i][j].getStatus())
			{
				optCount++;
				board.square[i][j].setBackground(blue);
			}
			else if(a / board.square[i][j].getChessMen().pieceNo < 0)
			{
				optCount++;
				board.square[i][j].setBackground(red);
				break;
			}
			else if(a / board.square[i][j].getChessMen().pieceNo > 0 && a != board.square[i][j].getChessMen().pieceNo)
			{
				break;
			}
		}
		for(int i = m, j = n ; i >= 0 && j <= 7 ; i--, j++)
		{
			if(board.square[i][j].getStatus())
			{
				optCount++;
				board.square[i][j].setBackground(blue);
			}
			else if(a / board.square[i][j].getChessMen().pieceNo < 0)
			{
				optCount++;
				board.square[i][j].setBackground(red);
				break;
			}
			else if(a / board.square[i][j].getChessMen().pieceNo > 0 && a != board.square[i][j].getChessMen().pieceNo)
			{
				break;
			}
		}
		for(int i = m, j = n ; i <= 7 && j >= 0 ; i++, j--)
		{
			if(board.square[i][j].getStatus())
			{
				optCount++;
				board.square[i][j].setBackground(blue);
			}
			else if(a / board.square[i][j].getChessMen().pieceNo < 0)
			{
				optCount++;
				board.square[i][j].setBackground(red);
				break;
			}
			else if(a / board.square[i][j].getChessMen().pieceNo > 0 && a != board.square[i][j].getChessMen().pieceNo)
			{
				break;
			}
		}
	}
	
	void step(int m, int n, int sign)
	{
		float a;
		a = board.square[m][n].getChessMen().pieceNo;
		if(sign == -1 && m + 1 >= 0 && m + 1 <= 7)
		{
			if(board.square[m + 1][n].getStatus())
			{
				optCount++;
				board.square[m + 1][n].setBackground(blue);;
			}
			if(n - 1 >= 0 && n - 1 <= 7)
			{
				if(!board.square[m + 1][n - 1].getStatus())
				{
					if(a / board.square[m + 1][n - 1].getChessMen().pieceNo < 0)
					{
						optCount++;
						board.square[m + 1][n - 1].setBackground(red);
					}
				}
			}
			if(n + 1 >= 0 && n + 1 <= 7)
			{
				if(!board.square[m + 1][n + 1].getStatus())
				{
					if(a / board.square[m + 1][n + 1].getChessMen().pieceNo < 0)
					{
						optCount++;
						board.square[m + 1][n + 1].setBackground(red);
					}
				}
			}
		}
		if(sign == 1 && m - 1 >= 0 && m - 1 <= 7)
		{
			if(board.square[m - 1][n].getStatus())
			{
				optCount++;
				board.square[m - 1][n].setBackground(blue);;
			}
			if(n - 1 >= 0 && n - 1 <= 7)
			{
				if(!board.square[m - 1][n - 1].getStatus())
				{
					if(a / board.square[m - 1][n - 1].getChessMen().pieceNo < 0)
					{
						optCount++;
						board.square[m - 1][n - 1].setBackground(red);
					}
				}
			}
			if(n + 1 >= 0 && n + 1 <= 7)
			{
				if(!board.square[m - 1][n + 1].getStatus())
				{
					if(a / board.square[m - 1][n + 1].getChessMen().pieceNo < 0)
					{
						optCount++;
						board.square[m - 1][n + 1].setBackground(red);
					}
				}
			}
		}
		if(sign < 0 && m == 1)
		{
			if(board.square[m + 2][n].getStatus() && board.square[m + 1][n].getStatus())
			{
				optCount++;
				board.square[m + 2][n].setBackground(blue);
			}
		}
		if(sign > 0 && m == 6)
		{
			if(board.square[m - 2][n].getStatus() && board.square[m - 1][n].getStatus() )
			{
				optCount++;
				board.square[m - 2][n].setBackground(blue);
			}
		}
	}
	
	void twoHalf(int m, int n)
	{
		float a;
		int a1, b1, c1, d1, a2, b2, c2, d2;
		a1 = m - 2;
		b1 = m + 2;
		c1 = m - 1;
		d1 = m + 1;
		a2 = n - 2;
		b2 = n + 2;
		c2 = n - 1;
		d2 = n + 1;
		a = board.square[m][n].getChessMen().pieceNo;
		if(a1 >= 0 && a1 <= 7)
		{
			if(c2 >= 0 && c2 <= 7)
			{
				if(board.square[a1][c2].getStatus())
				{
					optCount++;
					board.square[a1][c2].setBackground(blue);
				}
				else if(a / board.square[a1][c2].getChessMen().pieceNo < 0)
				{
					optCount++;
					board.square[a1][c2].setBackground(red);
				}
			}
			if(d2 >= 0 && d2 <= 7)
			{
				if(board.square[a1][d2].getStatus())
				{
					optCount++;
					board.square[a1][d2].setBackground(blue);
				}
				else if(a / board.square[a1][d2].getChessMen().pieceNo < 0)
				{
					optCount++;
					board.square[a1][d2].setBackground(red);
				}
			}
		}
		if(b1 >= 0 && b1 <= 7)
		{
			if(c2 >= 0 && c2 <= 7)
			{
				if(board.square[b1][c2].getStatus())
				{
					optCount++;
					board.square[b1][c2].setBackground(blue);
				}
				else if(a / board.square[b1][c2].getChessMen().pieceNo < 0)
				{
					optCount++;
					board.square[b1][c2].setBackground(red);
				}
			}
			if(d2 >= 0 && d2 <= 7)
			{
				if(board.square[b1][d2].getStatus())
				{
					optCount++;
					board.square[b1][d2].setBackground(blue);
				}
				else if(a / board.square[b1][d2].getChessMen().pieceNo < 0)
				{
					optCount++;
					board.square[b1][d2].setBackground(red);
				}
			}
		}
		if(c1 >= 0 && c1 <= 7)
		{
			if(a2 >= 0 && a2 <= 7)
			{
				if(board.square[c1][a2].getStatus())
				{
					optCount++;
					board.square[c1][a2].setBackground(blue);
				}
				else if(a / board.square[c1][a2].getChessMen().pieceNo < 0)
				{
					optCount++;
					board.square[c1][a2].setBackground(red);
				}
			}
			if(b2 >= 0 && b2 <= 7)
			{
				if(board.square[c1][b2].getStatus())
				{
					optCount++;
					board.square[c1][b2].setBackground(blue);
				}
				else if(a / board.square[c1][b2].getChessMen().pieceNo < 0)
				{
					optCount++;
					board.square[c1][b2].setBackground(red);
				}
			}
		}
		if(d1 >= 0 && d1 <= 7)
		{
			if(a2 >= 0 && a2 <= 7)
			{
				if(board.square[d1][a2].getStatus())
				{
					optCount++;
					board.square[d1][a2].setBackground(blue);
				}
				else if(a / board.square[d1][a2].getChessMen().pieceNo < 0)
				{
					optCount++;
					board.square[d1][a2].setBackground(red);
				}
			}
			if(b2 >= 0 && b2 <= 7)
			{
				if(board.square[d1][b2].getStatus())
				{
					optCount++;
					board.square[d1][b2].setBackground(blue);
				}
				else if(a / board.square[d1][b2].getChessMen().pieceNo < 0)
				{
					optCount++;
					board.square[d1][b2].setBackground(red);
				}
			}
		}
	}
	
	void kingMove(int m, int n)
	{
		float a;
		a = board.square[m][n].getChessMen().pieceNo;
		if(m - 1 >= 0 && m - 1 <= 7)
		{
			if(board.square[m - 1][n].getStatus())
			{
				optCount++;
				board.square[m - 1][n].setBackground(blue);
			}
			else if(a / board.square[m - 1][n].getChessMen().pieceNo < 0)
			{
				optCount++;
				board.square[m - 1][n].setBackground(red);
			}
			if(n - 1 >= 0 && n - 1 <= 7)
			{
				if(board.square[m - 1][n - 1].getStatus())
				{
					optCount++;
					board.square[m - 1][n - 1].setBackground(blue);
				}
				else if(a / board.square[m - 1][n - 1].getChessMen().pieceNo < 0)
				{
					optCount++;
					board.square[m - 1][n - 1].setBackground(red);
				}
			}
			if(n + 1 >= 0 && n + 1 <= 7)
			{
				if(board.square[m - 1][n + 1].getStatus())
				{
					optCount++;
					board.square[m - 1][n + 1].setBackground(blue);
				}
				else if(a / board.square[m - 1][n + 1].getChessMen().pieceNo < 0)
				{
					optCount++;
					board.square[m - 1][n + 1].setBackground(red);
				}
			}
		}
		if(m + 1 >= 0 && m + 1 <= 7)
		{
			if(board.square[m + 1][n].getStatus())
			{
				optCount++;
				board.square[m + 1][n].setBackground(blue);
			}
			else if(a / board.square[m + 1][n].getChessMen().pieceNo < 0)
			{
				optCount++;
				board.square[m + 1][n].setBackground(red);
			}
			if(n - 1 >= 0 && n - 1 <= 7)
			{
				if(board.square[m + 1][n - 1].getStatus())
				{
					optCount++;
					board.square[m + 1][n - 1].setBackground(blue);
				}
				else if(a / board.square[m + 1][n - 1].getChessMen().pieceNo < 0)
				{
					optCount++;
					board.square[m + 1][n - 1].setBackground(red);
				}
			}
			if(n + 1 >= 0 && n + 1 <= 7)
			{
				if(board.square[m + 1][n + 1].getStatus())
				{
					optCount++;
					board.square[m + 1][n + 1].setBackground(blue);
				}
				else if(a / board.square[m + 1][n + 1].getChessMen().pieceNo < 0)
				{
					optCount++;
					board.square[m + 1][n + 1].setBackground(red);
				}
			}	
		}
		if(n - 1 >= 0 && n - 1 <= 7)
		{
			if(board.square[m][n - 1].getStatus())
			{
				optCount++;
				board.square[m][n - 1].setBackground(blue);
			}
			else if(a / board.square[m][n - 1].getChessMen().pieceNo < 0)
			{
				optCount++;
				board.square[m][n - 1].setBackground(red);
			}
		}
		if(n + 1 >= 0 && n + 1 <= 7)
		{
			if(board.square[m][n + 1].getStatus())
			{
				optCount++;
				board.square[m][n + 1].setBackground(blue);
			}
			else if(a / board.square[m][n + 1].getChessMen().pieceNo < 0)
			{
				optCount++;
				board.square[m][n + 1].setBackground(red);
			}
		}
	}
	
	void findOptions(int N, int I, int J, int display)
	{
		if(display == 1)
		{
			System.out.println(mode + "\nSelected " + N + " (" + I + ", " + J + ")");
			board.square[I][J].setBackground(green);
		}
		optCount = 0;
		int sign = 1;
		if(N < 0)
			sign = -1;
		if(N == 1 || N == -1 || N == 8 || N == -8)
		{
			plus(I, J);
		}
		if(N == 2 || N == -2 || N == 7 || N == -7)
		{
			twoHalf(I, J);
		}
		if(N == 3 || N == -3 || N == 6 || N == -6)
		{
			cross(I, J);
		}
		if(N == -4 || N == 5)
		{
			plus(I, J);
			cross(I, J);
		}
		if(N == 4 || N == -5)
		{
			kingMove(I, J);
		}
		if(N <= -9 && N >=-16 || N >= 9 && N <= 16)
		{
			step(I, J, sign);
		}
		if(display == 1)
		{
			for(int i = 0; i < 8; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					if(board.square[i][j].getBackground() == blue || board.square[i][j].getBackground() == red)
						System.out.println("Option (" + i + ", " + j + ")");
				}
			}	
		}
	}
	
	void dualPlay(Square clicked)
	{
		if(clicked.getBackground() == blue || clicked.getBackground() == red)
		{
			initBackground();
			target = clicked;
			moveFrom(source, target);
		}
		else if(clicked.getStatus() == false)
		{
			if(clicked.getChessMen().pieceNo < 0 && mode == "black" || clicked.getChessMen().pieceNo > 0 && mode == "white")
			{
				initBackground();
				checkCheck();
				source = clicked;
				N = source.getChessMen().pieceNo;
				row = source.getRow();
				col = source.getCol();
				findOptions(N, row, col, 1);
			}
		}
	}
	
	void singlePlay(Square clicked)
	{
		if(clicked.getBackground() == blue || clicked.getBackground() == red)
		{
			initBackground();
			target = clicked;
			moveFrom(source, target);
		}
		else if(clicked.getStatus() == false)
		{
			if(clicked.getChessMen().pieceNo > 0 && mode == "white")
			{
				initBackground();
				checkCheck();
				source = clicked;
				N = source.getChessMen().pieceNo;
				row = source.getRow();
				col = source.getCol();
				findOptions(N, row, col, 1);
			}
		}
	}
	
	void comPlayRandom()
	{
		int r[] = new int[50], c[] = new int[50];
		int cnt, index;
		int n, valid;
		do
		{
			valid = 0;
			cnt = 0;
			do
			{
				do
				{
					if(mode == "black")
						n = (-1) * (rand.nextInt(16) + 1);
					else
						n = rand.nextInt(16) + 1;
					for(int i = 0 ; i < 8 ; i++)
					{
						for(int j = 0 ; j < 8 ; j++)
						{
							if(board.square[i][j].getStatus() == false)
							{
								if(board.square[i][j].getChessMen().pieceNo == n)
								{
									valid = 1;
									source = board.square[i][j];
									row = source.getRow();
									col = source.getCol();
									break;
								}
							}
						}
					}
				}while(valid == 0);
				findOptions(n, row, col, 0);
			}while(optCount == 0);
			findOptions(n, row, col, 1);
			for(int i = 0 ; i < 8 ; i++)
			{
				for(int j = 0 ; j < 8 ; j++)
				{
					if(board.square[i][j].getBackground() == blue || board.square[i][j].getBackground() == red)
					{
						r[cnt] = i;
						c[cnt] = j;
						cnt++;
					}
				}
			}
			initBackground();
			index = rand.nextInt(cnt);
			target = board.square[r[index]][c[index]];
		}while(checkSafe(target.getRow(), target.getCol()) == false);
		moveFrom(source, target);
		checkCheck();
	}
	
	int comPlaySave()
	{
		int done = 0;
		return done;
	}
	
	int comPlaySafeDelete()
	{
		int done = 0;
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(board.square[i][j].getStatus() == false && done == 0)
				{
					if(board.square[i][j].getChessMen().pieceNo < 0 && mode == "black" || board.square[i][j].getChessMen().pieceNo > 0 && mode == "white")
					{
						source = board.square[i][j];
						N = source.getChessMen().pieceNo;
						row = source.getRow();
						col = source.getCol();
						findOptions(N, row, col, 0);
						for(int m = 0 ; m < 8 ; m++)
						{
							for(int n = 0 ; n < 8 ; n++)
							{
								if(board.square[m][n].getBackground() == red)
								{
									System.out.println("At (" + m + ", " + n + "): " + checkSafe(m, n));
									if(checkSafe(m, n) == true)
									{
										done = 1;
										findOptions(N, row, col, 1);
										target = board.square[m][n];
										moveFrom(source, target);
										checkCheck();
									}
								}
								if(done == 1)
									break;
							}
							if(done == 1)
								break;
						}
						initBackground();
						checkCheck();
					}
				}
				if(done == 1)
					break;
			}
			if(done == 1)
				break;
		}
		return done;
	}
	
	int comPlayDelete()
	{
		int done = 0;
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(board.square[i][j].getStatus() == false && done == 0)
				{
					if(board.square[i][j].getChessMen().pieceNo < 0 && mode == "black" || board.square[i][j].getChessMen().pieceNo > 0 && mode == "white")
					{
						source = board.square[i][j];
						N = source.getChessMen().pieceNo;
						row = source.getRow();
						col = source.getCol();
						findOptions(N, row, col, 0);
						for(int m = 0 ; m < 8 ; m++)
						{
							for(int n = 0 ; n < 8 ; n++)
							{
								if(board.square[m][n].getBackground() == red)
								{
									done = 1;
									findOptions(N, row, col, 1);
									target = board.square[m][n];
									moveFrom(source, target);
									checkCheck();
									break;
								}
							}
						}
						initBackground();
						checkCheck();
					}
				}
			}
		}
		return done;
	}
	
	void comPlay()
	{
		int done = comPlaySafeDelete();
	//	int done = comPlayDelete();
		if(done == 0)
		{
			done = comPlayDelete();
		}
		if(done == 0)
		{
			done = comPlaySave();
		}
		if(done == 0)
		{
			comPlayRandom();
		}
	}
	
	boolean checkSafe(int tgtRow, int tgtCol)
	{
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(board.square[i][j].getStatus() == false)
				{
					if((-1) * board.square[i][j].getChessMen().pieceNo > 0 && (i != tgtRow || j != tgtCol) && mode == "black" || board.square[i][j].getChessMen().pieceNo < 0 && mode == "white" && (i != tgtRow || j != tgtCol))
					{
						initBackground();
						findOptions((-1) * board.square[i][j].getChessMen().pieceNo, i, j, 0);
						if(board.square[tgtRow][tgtCol].getBackground() == red)
						{
							initBackground();
							return false;
						}
					}
				}
			}
		}
		initBackground();
		return true;
	}
	
	boolean checkCheck()
	{
		int kingI = -1, kingJ = -1;
		if(mode == "white")
		{
			for(int i = 0; i < 8; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					if(board.square[i][j].getStatus() == false)
					{
						if(board.square[i][j].getChessMen().pieceNo == 4)
						{
							kingI = i;
							kingJ = j;
						}
					}
				}
			}	
			for(int i = 0; i < 8; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					if(board.square[i][j].getStatus() == false)
					{
						if(board.square[i][j].getChessMen().pieceNo < 0)
						{
							findOptions(board.square[i][j].getChessMen().pieceNo, i, j, 0);
							if(board.square[kingI][kingJ].getBackground() == red)
							{
								initBackground();
								board.square[kingI][kingJ].setBackground(Color.ORANGE);
								return true;
							}
							initBackground();
						}
					}
				}
			}	
		}
		if(mode == "black")
		{
			for(int i = 0; i < 8; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					if(board.square[i][j].getStatus() == false)
					{
						if(board.square[i][j].getChessMen().pieceNo == -5)
						{
							kingI = i;
							kingJ = j;
						}
					}
				}
			}
			for(int i = 0; i < 8; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					if(board.square[i][j].getStatus() == false)
					{
						if(board.square[i][j].getChessMen().pieceNo > 0)
						{
							findOptions(board.square[i][j].getChessMen().pieceNo, i, j, 0);
							if(board.square[kingI][kingJ].getBackground() == red)
							{
								initBackground();
								board.square[kingI][kingJ].setBackground(Color.ORANGE);
								return true;
							}
							initBackground();
						}
					}
				}
			}	
		}
		return false;
	}
	
	void moveFrom(Square source, Square target)
	{
		playChessMen = source.getChessMen();
		tgtRow = target.getRow();
		tgtCol = target.getCol();
		System.out.println("Placed " + " (" + tgtRow + ", " + tgtCol + ")\n");
		if(board.square[tgtRow][tgtCol].getStatus() == false)
		{
			System.out.println("Deleted" + target.getChessMen().pieceNo + "\n");
			if(target.getChessMen().pieceNo == -5 || target.getChessMen().pieceNo == 4)
			{
				deletedKing = target.getChessMen().pieceNo;
				displayWinner(deletedKing);
				mode = "stop";
			}
			board.square[tgtRow][tgtCol].setChessMen(null);
			board.square[tgtRow][tgtCol].removeAll();
			board.square[tgtRow][tgtCol].setStatus(true);
		}
		board.square[row][col].setChessMen(null);
		board.square[row][col].removeAll();
		board.square[row][col].setStatus(true);
		board.square[tgtRow][tgtCol].add(playChessMen);
		board.square[tgtRow][tgtCol].setChessMen(playChessMen);
		board.square[tgtRow][tgtCol].setStatus(false);
		board.repaint();
		if(mode == "white")
			mode = "black";
		else if(mode == "black")
			mode = "white";
		checkCheck();
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		clicked = (Square) e.getSource();
		
		if(pMode == "withFriend" && mode != "stop")
		{
			dualPlay(clicked);
		}
		else if(pMode == "withComputer" && mode != "stop")
		{
			if(mode == "white")
				singlePlay(clicked);
			if(mode == "black")
			{
				comPlay();
				mode = "white";
			}
		}
		else
		{
			if(mode != "stop")
				comPlay();
		}
	}

	public static void main(String[] args)
	{	
		JFrame frame = new PlayChess();
		frame.setTitle("Chess");
		frame.setSize(700, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}