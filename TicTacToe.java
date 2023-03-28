import java.util.Scanner;
public class TicTacToe
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        Gameboard board = new Gameboard();
        board.drawBoard();

        for(int i = 0; i<9; i++)
        {
            if(i%2==0)
            {
                System.out.println("Player One, Enter Coordinate of X:");

                while(true)
                {
                    System.out.print("Row: ");
                    int row = input.nextInt()-1;
                    System.out.print("Column: ");
                    int col = input.nextInt()-1;

                    if(row>=0 && row<=2 && col>=0 && col<=2 && board.getBoard()[row][col]== null)
                    {
                        board.setBoard(row, col, "X");
                        board.boardDrawX(row, col);
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid input. Enter another position.");
                    }
                }
                
            }
            else
            {
                System.out.println("Player Two, Enter Coordinate of O: ");
    
                while(true)
                {
                    System.out.print("Row: ");
                    int row = input.nextInt()-1;
                    System.out.print("Column: ");
                    int col = input.nextInt()-1;

                    if(row>=0 && row<=2 && col>=0 && col<=2 && board.getBoard()[row][col]== null)
                    {
                        board.setBoard(row, col, "O");
                        board.boardDrawO(row, col);
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid input. Enter another new position.");
                    }
                    
                }
            }
            if(i%2 == 0 && board.checkForWinner())
            {
                board.drawWinningLine(board.getWinningXpoints().get(0), board.getWinningYpoints().get(0), board.getWinningXpoints().get(2), board.getWinningYpoints().get(2));
                
            
            }
            if(i%2 != 0 && board.checkForWinner())
            {
                board.drawWinningLine(board.getWinningXpoints().get(0), board.getWinningYpoints().get(0), board.getWinningXpoints().get(2), board.getWinningYpoints().get(2));

            }
            
            
        }
    }
}