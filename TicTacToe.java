import java.util.Scanner;

public class TicTacToe
{
	public char[] grid = 
	{
		'1', '2', '3',
		'4', '5', '6',
		'7', '8', '9'
	};
	public char turn = 'X';
	public int draw = 0;
	public int[] gridSum = 
		{
			0, 0, 0,
			0, 0, 0,
			0, 0, 0
		};
	public char winner = 'N';
	Scanner input = new Scanner(System.in);
	
	
	public void play()
	{
		while (winner == 'N')
		{
			printGrid();
			getMove();
			checkWinner();
		}
	}
	public void printGrid()
	{
		System.out.println
		(
			grid[0] + " | " + grid[1] + " | " + grid[2] + "\n" +
			grid[3] + " | " + grid[4] + " | " + grid[5] + "\n" +
			grid[6] + " | " + grid[7] + " | " + grid[8] + "\n"
		);
	}
	
	public void getMove()
	{
		try {
			System.out.print(turn + "'s turn. Please select a cell (1-9): ");
			int move = input.nextInt();
			if (move < 1 || move > 9)
			{
				System.out.println("Please pick a cell between 1 and 9.");
				throw new Exception();
			}
			if (gridSum[move - 1] != 0)
			{
				System.out.println("Space is already occupied.");
				throw new Exception();
			}
			grid[move - 1] = turn;
			gridSum[move - 1] = turn == 'X' ? 1:-1;
			draw++;
			nextTurn();
		} 
		catch (Exception e) {
			getMove();
		}
	}
	
	public void nextTurn()
	{
		if (turn == 'X')
		{
			turn = 'O';
		}
		
		else
		{
			turn = 'X';
		}
	}
	
	public void checkWinner()
	{
		int row1 = gridSum[0] + gridSum[1] + gridSum[2];
		int row2 = gridSum[3] + gridSum[4] + gridSum[5];
		int row3 = gridSum[6] + gridSum[7] + gridSum[8];
		int column1 = gridSum[0] + gridSum[3] + gridSum[6];
		int column2 = gridSum[1] + gridSum[4] + gridSum[7];
		int column3 = gridSum[2] + gridSum[5] + gridSum[8];
		int diag1 = gridSum[0] + gridSum[4] + gridSum[8];
		int diag2 = gridSum[2] + gridSum[4] + gridSum[6];
		
		if (row1 == 3 || row1 == -3)
		{
			winner = row1 == 3 ? 'X':'O';
			showResults();
			System.out.println("Congratulations, " + winner + "!");
		}
		else if (row2 == 3 || row2 == -3)
		{
			winner = row2 == 3 ? 'X':'O';
			showResults();
			System.out.println("Congratulations, " + winner + "!");
		}
		else if (row3 == 3 || row3 == -3)
		{
			winner = row3 == 3 ? 'X':'O';
			showResults();
			System.out.println("Congratulations, " + winner + "!");
		}
		else if (column1 == 3 || column1 == -3)
		{
			winner = column1 == 3 ? 'X':'O';
			showResults();
			System.out.println("Congratulations, " + winner + "!");
		}	
		else if (column2 == 3 || column2 == -3)
		{
			winner = column2 == 3 ? 'X':'O';
			showResults();
			System.out.println("Congratulations, " + winner + "!");
		}	
		else if (column3 == 3 || column3 == -3)
		{
			winner = column3 == 3 ? 'X':'O';
			showResults();
			System.out.println("Congratulations, " + winner + "!");
		}

		else if (diag1 == 3 || diag1 == -3)
		{
			winner = diag1 == 3 ? 'X':'O';
			showResults();
			System.out.println("Congratulations, " + winner + "!");
		}
			
		else if (diag2 == 3 || diag2 == -3)
		{
			winner = diag2 == 3 ? 'X':'O';
			showResults();
			System.out.println("Congratulations, " + winner + "!");
		}
			
		else if (draw == 9)
		{
			winner = 'D';
			showResults();
			System.out.println("Draw!");
		}
	}
	
	public void showResults()
	{
		for (int i = 0; i < grid.length; i++)
		{
			if (Character.isDigit(grid[i]))
			{
				grid[i] = ' ';
			}
		}
		
		printGrid();
	}
}