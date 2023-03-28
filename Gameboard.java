import java.awt.geom.*;
import java.util.*;
import javax.swing.plaf.ColorUIResource;
import gpdraw.*;

public class Gameboard {
    private String [][] board;
    private ArrayList <Point2D.Double> points;
    private DrawingTool pencil;
    private ArrayList <Integer> winningXpoints;
    private ArrayList <Integer> winningYpoints;

    public Gameboard()
    {
        board = new String [3][3];
        pencil = new DrawingTool(new SketchPad(800,800));
        points = new ArrayList<Point2D.Double>
        (Arrays.asList(new Point2D.Double(-100, 300),
                       new Point2D.Double(-100, -300), 
                       new Point2D.Double(100, 300), 
                       new Point2D.Double(100, -300),
                       new Point2D.Double(-300, 100), 
                       new Point2D.Double(300, 100),
                       new Point2D.Double(-300, -100), 
                       new Point2D.Double(300, -100)));
    }
    public String [][] getBoard()
    {
      return board;
    }
    public void setBoard(int xPos, int yPos, String value)
    {
        board[xPos][yPos] = value;
    }
    public ArrayList<Integer> getWinningXpoints()
    {
      return winningXpoints;
    }
    public ArrayList<Integer> getWinningYpoints()
    {
      return winningYpoints;
    }
    public void drawBoard()
    {
        pencil.setWidth(5);
        for(int i = 0; i<8; i+=2)
        {
            pencil.up();
            pencil.move(points.get(i).getX(), points.get(i).getY());
            pencil.down();
            pencil.move(points.get(i+1).getX(), points.get(i+1).getY());
        }
        
    }

    public void boardDrawX(int xPos, int yPos)
    {
      if(xPos == 0 && yPos == 0)
      {
        drawX(-200, 200);
      } 
      else if(xPos == 0 && yPos == 1)
      {
        drawX(0, 200);
      }
      else if(xPos == 0 && yPos == 2)
      {
        drawX(200, 200);
      }
      else if(xPos == 1 && yPos == 0)
      {
        drawX(-200, 0);
      }
      else if(xPos == 1 && yPos == 1)
      {
        drawX(0, 0); 
      }
      else if(xPos == 1 && yPos == 2)
      {
        drawX(200, 0); 
      }
      else if(xPos == 2 && yPos == 0)
      {
        drawX(-200, -200);  
      }
      else if(xPos == 2 && yPos == 1)
      {
        drawX(0, -200);
      }
      else if(xPos == 2 && yPos == 2)
      {
        drawX(200, -200); 
      } 
    }
    public void boardDrawO(int xPos, int yPos)
    {
      if(xPos == 0 && yPos == 0)
      {
        drawO(-200, 200);
      } 
      else if(xPos == 0 && yPos == 1)
      {
        drawO(0, 200);
      }
      else if(xPos == 0 && yPos == 2)
      {
        drawO(200, 200);
      }
      else if(xPos == 1 && yPos == 0)
      {
        drawO(-200, 0);
      }
      else if(xPos == 1 && yPos == 1)
      {
        drawO(0, 0); 
      }
      else if(xPos == 1 && yPos == 2)
      {
        drawO(200, 0); 
      }
      else if(xPos == 2 && yPos == 0)
      {
        drawO(-200, -200);  
      }
      else if(xPos == 2 && yPos == 1)
      {
        drawO(0, -200);
      }
      else if(xPos == 2 && yPos == 2)
      {
        drawO(200, -200); 
      } 
    }
    public void drawX(int xPos, int yPos)
    {
        pencil.setColor(new ColorUIResource(0,0,255));
        pencil.up();
        pencil.move(xPos-75, yPos-75);
        pencil.down();
        pencil.move(xPos+75, yPos+75);
        pencil.up();
        pencil.move(xPos-75, yPos+75);
        pencil.down();
        pencil.move(xPos+75, yPos-75);
          
    }
    public void drawO(int xPos, int yPos)
    {
        pencil.setColor(new ColorUIResource(255,0,0));
        pencil.up();
        pencil.move(xPos, yPos);
        pencil.down();
        pencil.drawCircle(75);
    }

    public boolean checkForWinner()
    {
      //cases for X
      if(board[0][0]!= null && board[0][1] != null && board [0][2] != null && board[0][0].equals("X") && board[0][1].equals("X") && board[0][2].equals("X"))
      {
        winningXpoints = new ArrayList<Integer>(Arrays.asList(0, 0, 0));
        winningYpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        
        return true;
      }
      if(board[1][0]!= null && board[1][1] != null && board [1][2] != null && board[1][0].equals("X") && board[1][1].equals("X") && board[1][2].equals("X"))
      {
        winningXpoints = new ArrayList<Integer>(Arrays.asList(1, 1, 1));
        winningYpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        return true;
      }
      if(board[2][0]!= null && board[2][1] != null && board [2][2] != null && board[2][0].equals("X") && board[2][1].equals("X") && board[2][2].equals("X"))
      {
        winningXpoints = new ArrayList<Integer>(Arrays.asList(2, 2, 2));
        winningYpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        return true;
      }
      if(board[0][0]!= null && board[1][0] != null && board [2][0] != null && board[0][0].equals("X") && board[1][0].equals("X") && board[2][0].equals("X"))
      {
        winningXpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        winningYpoints = new ArrayList<Integer>(Arrays.asList(0, 0, 0));
        return true;
      }
      if(board[0][1]!= null && board[1][1] != null && board [2][1] != null && board[0][1].equals("X") && board[1][1].equals("X") && board[2][1].equals("X"))
      {
        winningXpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        winningYpoints = new ArrayList<Integer>(Arrays.asList(1, 1, 1));
        return true;
      }
      if(board[0][2]!= null && board[1][2] != null && board [2][2] != null && board[0][2].equals("X") && board[1][2].equals("X") && board[2][2].equals("X"))
      {
        winningXpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        winningYpoints = new ArrayList<Integer>(Arrays.asList(2, 2, 2));
        return true;
      }
      if(board[0][0]!= null && board[1][1] != null && board [2][2] != null && board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X"))
      {
        winningXpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        winningYpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        return true;
      }
      if(board[2][0]!= null && board[1][1] != null && board [0][2] != null && board[2][0].equals("X") && board[1][1].equals("X") && board[0][2].equals("X"))
      {
        winningXpoints = new ArrayList<Integer>(Arrays.asList(2, 1, 0));
        winningYpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        return true;
      }


      //Cases for O
      if(board[0][0]!= null && board[0][1] != null && board [0][2] != null && board[0][0].equals("O") && board[0][1].equals("O") && board[0][2].equals("O"))
      {
        winningXpoints = new ArrayList<Integer>(Arrays.asList(0, 0, 0));
        winningYpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        return true;
      }
      if(board[1][0]!= null && board[1][1] != null && board [1][2] != null && board[1][0].equals("O") && board[1][1].equals("O") && board[1][2].equals("O"))
      {
        winningXpoints = new ArrayList<Integer>(Arrays.asList(1, 1, 1));
        winningYpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        return true;
      }
      if(board[2][0]!= null && board[2][1] != null && board [2][2] != null && board[2][0].equals("O") && board[2][1].equals("O") && board[2][2].equals("O"))
      {
        winningXpoints = new ArrayList<Integer>(Arrays.asList(2, 2, 2));
        winningYpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        return true;
      }
      if(board[0][0]!= null && board[1][0] != null && board [2][0] != null && board[0][0].equals("O") && board[1][0].equals("O") && board[2][0].equals("O"))
      {
        winningXpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        winningYpoints = new ArrayList<Integer>(Arrays.asList(0, 0, 0));
        return true;
      }
      if(board[0][1]!= null && board[1][1] != null && board [2][1] != null && board[0][1].equals("O") && board[1][1].equals("O") && board[2][1].equals("O"))
      {
        winningXpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        winningYpoints = new ArrayList<Integer>(Arrays.asList(1, 1, 1));
        return true;
      }
      if(board[0][2]!= null && board[1][2] != null && board [2][2] != null && board[0][2].equals("O") && board[1][2].equals("O") && board[2][2].equals("O"))
      {
        winningXpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        winningYpoints = new ArrayList<Integer>(Arrays.asList(2, 2, 2));
        return true;
      }
      if(board[0][0]!= null && board[1][1] != null && board [2][2] != null && board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O"))
      {
        winningXpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        winningYpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        return true;
      }
      if(board[2][0]!= null && board[1][1] != null && board [0][2] != null && board[2][0].equals("O") && board[1][1].equals("O") && board[0][2].equals("O"))
      {
        winningXpoints = new ArrayList<Integer>(Arrays.asList(2, 1, 0));
        winningYpoints = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        return true;
      }
        return false;
    }

    public void drawWinningLine(int xCord1, int yCord1, int xCord2, int yCord2)
    {
      pencil.setColor(new ColorUIResource(255, 255, 0));
      pencil.setWidth(25);
      if(xCord1 == 0 && yCord1 == 0 && xCord2 == 0 && yCord2 ==2)
      {
        pencil.up();
        pencil.move(-250,200);
        pencil.down();
        pencil.move(250,200);
      }
      if(xCord1 == 1 && yCord1 == 0 && xCord2 == 1 && yCord2 ==2)
      {
        pencil.up();
        pencil.move(-250,0);
        pencil.down();
        pencil.move(250,0);
      }
      if(xCord1 == 2 && yCord1 == 0 && xCord2 == 2 && yCord2 ==2)
      {
        pencil.up();
        pencil.move(-250,-200);
        pencil.down();
        pencil.move(250,-200);
      }
      if(xCord1 == 0 && yCord1 == 0 && xCord2 == 2 && yCord2 ==0)
      {
        pencil.up();
        pencil.move(-200,250);
        pencil.down();
        pencil.move(-200,-250);
      }
      if(xCord1 == 0 && yCord1 == 1 && xCord2 == 2 && yCord2 ==1)
      {
        pencil.up();
        pencil.move(0,250);
        pencil.down();
        pencil.move(0,-250);
      }
      if(xCord1 == 0 && yCord1 == 2 && xCord2 == 2 && yCord2 ==2)
      {
        pencil.up();
        pencil.move(200,250);
        pencil.down();
        pencil.move(200,-250);
      }
      if(xCord1 == 0 && yCord1 == 0 && xCord2 == 2 && yCord2 ==2)
      {
        pencil.up();
        pencil.move(-250,250);
        pencil.down();
        pencil.move(250,-250);
      }
      if(xCord1 == 2 && yCord1 == 0 && xCord2 == 0 && yCord2 ==2)
      {
        pencil.up();
        pencil.move(-250,-250);
        pencil.down();
        pencil.move(250,250);
      }
      //pencil.fillRect(200,100);

      
      
    }

    
}
