package oop.interfaces.game;

public class ConnectFour implements Game
{
    private final int columns = 7;

    private final int rows = 6;

    private final int numberOfPlayers = 2;

    private final String[] symbols =
    { " ", "O", "X" };

    private int[][] board = null;

    private int next;

    private int winner = -1;

    @Override
    public String getNameOfGame()
    {
        return "4 gewinnt";
    }

    @Override
    public int getMinNumberOfPlayers()
    {
        return numberOfPlayers;
    }

    @Override
    public int getMaxNumberOfPlayers()
    {
        return numberOfPlayers;
    }

    @Override
    public void initialize(int players)
    {
        if (players != numberOfPlayers)
        {
            throw new IllegalArgumentException("Es dürfen genau" + numberOfPlayers + "Personen teilnehmen.");
        }
        board = new int[columns][rows];
        for (int i = 0; i < columns; i++)
        {
            for (int j = 0; j < rows; j++)
            {
                board[i][j] = -1;
            }
        }
        next = (int) Math.round(Math.random());

    }

    @Override
    public String getBoard() throws NotInitializedException
    {
        String line = "-".repeat(columns * 2 + 1) + "\n";
        StringBuilder sb = new StringBuilder();
        sb.append(line);
        for (int i = 0; i < board[0].length; i++)
        {
            sb.append("|");
            for (int j = 0; j < board.length; j++)
            {
                sb.append(symbols[board[j][i] + 1] + "|");
            }
            sb.append("\n");
            sb.append(line);
        }
        return sb.toString();
    }

    @Override
    public int getNextPlayer() throws NotInitializedException, GameFinishedException
    {
        if (board == null)
        {
            throw new NotInitializedException();
        }
        if (isFinished())
        {
            throw new GameFinishedException();
        }
        return next;
    }

    @Override
    public String getHintForInput()
    {
        return "Bitte eine Zahl von 1 bis " + columns + " angeben";
    }

    @Override
    public void makeMove(int player, String input) throws NotInitializedException, GameFinishedException, WrongPlayerException, BadInputException
    {
        if (board == null)
        {
            throw new NotInitializedException();
        }
        if (isFinished())
        {
            throw new GameFinishedException();
        }
        if (player != next)
        {
            throw new WrongPlayerException();
        }
        int col;
        try
        {
            col = Integer.parseInt(input);
        }
        catch (NumberFormatException e)
        {
            throw new BadInputException("falsche Eingabe");
        }
        if (col < 1 || col > columns)
        {
            throw new BadInputException("falsche Eingabe");
        }
        else
        {
            col--;
            int i = rows - 1;
            while (i >= 0 && board[col][i] != -1)
            {
                i--;
            }
            if (i < 0)
            {
                throw new BadInputException("Die Spalte ist voll");
            }
            else
            {
                board[col][i] = player;
                next = 1 - next;
            }
        }

    }

    @Override
    public boolean isFinished()
    {
        if (hasWinner())
        {
            return true;
        }
        boolean full = true;
        for (int i = 0; i < columns; i++)
        {
            for (int j = 0; j < rows; j++)
            {
                if (board[i][j] == -1)
                {
                    full = false;
                }
            }
        }
        return full;
    }

    public boolean verticalStreak()
    {
        int player = 1;
        int folge = 0;
        for (int i = 0; i < board.length; i++)
        {
            folge = 0;
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] != -1)
                {
                    if (board[i][j] == player)
                    {
                        folge++;
                        if (folge >= 4)
                        {
                            winner = player;
                            return true;
                        }
                    }
                    else
                    {
                        player = board[i][j];
                        folge = 1;
                    }
                }
                else
                {
                    folge = 0;
                }
            }
        }
        return false;
    }

    public boolean horizontalStreak()
    {
        int player = 1;
        int folge = 0;
        // Reihenweise durchgehen
        for (int i = 0; i < board[i].length; i++)
        {
            folge = 0;
            for (int j = 0; j < board.length; j++)
            {
                if (board[j][i] != -1)
                {
                    if (board[j][i] == player)
                    {
                        folge++;
                        if (folge >= 4)
                        {
                            winner = player;
                            return true;
                        }
                    }
                    else
                    {
                        player = board[j][i];
                        folge = 1;
                    }
                }
                else
                {
                    folge = 0;
                }
            }
        }
        return false;
    }

    public boolean diagonalStreak()
    {
        int player = 1;
        int folge = 0;
        // Diagonal runter
        // Die Anfänge in der ersten Spalte
        for (int i = rows - 1; i > 2; i--)
        {
            folge = 0;
            int row = i;
            int col = 0;
            while (row >= 0 && col < board.length)
            {
                if (board[col][row] != -1)
                {
                    if (board[col][row] == player)
                    {
                        folge++;
                        if (folge >= 4)
                        {
                            winner = player;
                            return true;
                        }
                    }
                    else
                    {
                        player = board[col][row];
                        folge = 1;
                    }
                }
                else
                {
                    folge = 0;
                }
                row--;
                col++;
            }
        }
        // Die Anfänge in den restlichen Spalten
        for (int i = 1; i < columns - 3; i++)
        {
            folge = 0;
            int col = i;
            int row = rows - 1;
            while (row >= 0 && col < board.length)
            {
                if (board[col][row] != -1)
                {
                    if (board[col][row] == player)
                    {
                        folge++;
                        if (folge >= 4)
                        {
                            winner = player;
                            return true;
                        }
                    }
                    else
                    {
                        player = board[col][row];
                        folge = 1;
                    }
                }
                else
                {
                    folge = 0;
                }
                row--;
                col++;
            }
        }

        // Diagonal runter
        // Die Anfänge in der ersten Spalte
        for (int i = rows - 4; i >= 0; i--)
        {
            folge = 0;
            int row = i;
            int col = 0;
            while (row < board[i].length && col < board.length)
            {
                if (board[col][row] != -1)
                {
                    if (board[col][row] == player)
                    {
                        folge++;
                        if (folge >= 4)
                        {
                            winner = player;
                            return true;
                        }
                    }
                    else
                    {
                        player = board[col][row];
                        folge = 1;
                    }
                }
                else
                {
                    folge = 0;
                }
                row++;
                col++;
            }
        }
        // Die Anfänge in den restlichen Spalten
        for (int i = 1; i < columns - 3; i++)
        {
            folge = 0;
            int col = i;
            int row = 0;
            while (row < board[i].length && col < board.length)
            {
                if (board[col][row] != -1)
                {
                    if (board[col][row] == player)
                    {
                        folge++;
                        if (folge >= 4)
                        {
                            winner = player;
                            return true;
                        }
                    }
                    else
                    {
                        player = board[col][row];
                        folge = 1;
                    }
                }
                else
                {
                    folge = 0;
                }
                row++;
                col++;
            }
        }
        return false;

    }

    @Override
    public boolean hasWinner()
    {

        if (horizontalStreak() || verticalStreak() || diagonalStreak())
        {
            return true;
        }
        return false;
    }

    @Override
    public int getWinner() throws NoWinnerException
    {
        if (!hasWinner())
        {
            throw new NoWinnerException();
        }
        return winner;
    }
}
