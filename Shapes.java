import java.awt.Color;

public class Shapes {
	private final boolean[][][][] ShapeOfSquares;
	private final int ShapeBound[][][];
	private final Color ColorArr[] = {Color.magenta,Color.red,Color.orange,Color.yellow,Color.green,Color.cyan,Color.pink};
	Shapes()
	{
		ShapeOfSquares = new boolean[7][4][4][4];
		ShapeBound = new int[7][4][4];
		ShapeOfSquares[0][0][0][0] = true;//Square 0
		ShapeOfSquares[0][0][0][1] = true;
		ShapeOfSquares[0][0][1][0] = true;
		ShapeOfSquares[0][0][1][1] = true;

		ShapeOfSquares[0][1][0][0] = true;//Square 1
		ShapeOfSquares[0][1][0][1] = true;
		ShapeOfSquares[0][1][1][0] = true;
		ShapeOfSquares[0][1][1][1] = true;

		ShapeOfSquares[0][2][0][0] = true;//Square 2
		ShapeOfSquares[0][2][0][1] = true;
		ShapeOfSquares[0][2][1][0] = true;
		ShapeOfSquares[0][2][1][1] = true;

		ShapeOfSquares[0][3][0][0] = true;//Square 3
		ShapeOfSquares[0][3][0][1] = true;
		ShapeOfSquares[0][3][1][0] = true;
		ShapeOfSquares[0][3][1][1] = true;

		ShapeOfSquares[1][0][0][2] = true;//Shape i 0
		ShapeOfSquares[1][0][1][2] = true;
		ShapeOfSquares[1][0][2][2] = true;
		ShapeOfSquares[1][0][3][2] = true;

		ShapeOfSquares[1][1][1][0] = true;//Shape i 1
		ShapeOfSquares[1][1][1][1] = true;
		ShapeOfSquares[1][1][1][2] = true;
		ShapeOfSquares[1][1][1][3] = true;

		ShapeOfSquares[1][2][0][2] = true;//Shape i 2
		ShapeOfSquares[1][2][1][2] = true;
		ShapeOfSquares[1][2][2][2] = true;
		ShapeOfSquares[1][2][3][2] = true;

		ShapeOfSquares[1][3][1][0] = true;//Shape i 3
		ShapeOfSquares[1][3][1][1] = true;
		ShapeOfSquares[1][3][1][2] = true;
		ShapeOfSquares[1][3][1][3] = true;

		ShapeOfSquares[2][0][0][1] = true;//Shape L 0
		ShapeOfSquares[2][0][1][1] = true;
		ShapeOfSquares[2][0][2][1] = true;
		ShapeOfSquares[2][0][2][2] = true;

		ShapeOfSquares[2][1][0][2] = true;//Shape L 1
		ShapeOfSquares[2][1][1][0] = true;
		ShapeOfSquares[2][1][1][1] = true;
		ShapeOfSquares[2][1][1][2] = true;

		ShapeOfSquares[2][2][0][1] = true;//Shape L 2
		ShapeOfSquares[2][2][0][2] = true;
		ShapeOfSquares[2][2][1][2] = true;
		ShapeOfSquares[2][2][2][2] = true;

		ShapeOfSquares[2][3][1][0] = true;//Shape L 3
		ShapeOfSquares[2][3][1][1] = true;
		ShapeOfSquares[2][3][1][2] = true;
		ShapeOfSquares[2][3][2][0] = true;

		ShapeOfSquares[3][0][0][0] = true;//Shape z 0
		ShapeOfSquares[3][0][0][1] = true;
		ShapeOfSquares[3][0][1][1] = true;
		ShapeOfSquares[3][0][1][2] = true;

		ShapeOfSquares[3][1][0][2] = true;//Shape z 1
		ShapeOfSquares[3][1][1][1] = true;
		ShapeOfSquares[3][1][1][2] = true;
		ShapeOfSquares[3][1][2][1] = true;

		ShapeOfSquares[3][2][0][0] = true;//Shape z 2
		ShapeOfSquares[3][2][0][1] = true;
		ShapeOfSquares[3][2][1][1] = true;
		ShapeOfSquares[3][2][1][2] = true;

		ShapeOfSquares[3][3][0][2] = true;//Shape z 3
		ShapeOfSquares[3][3][1][1] = true;
		ShapeOfSquares[3][3][1][2] = true;
		ShapeOfSquares[3][3][2][1] = true;
		
		ShapeOfSquares[4][0][0][1] = true;//Shape anti z 0
		ShapeOfSquares[4][0][0][2] = true;
		ShapeOfSquares[4][0][1][0] = true;
		ShapeOfSquares[4][0][1][1] = true;
		
		ShapeOfSquares[4][1][0][1] = true;//Shape anti z 1
		ShapeOfSquares[4][1][1][1] = true;
		ShapeOfSquares[4][1][1][2] = true;
		ShapeOfSquares[4][1][2][2] = true;
		
		ShapeOfSquares[4][2][0][1] = true;//Shape anti z 2
		ShapeOfSquares[4][2][0][2] = true;
		ShapeOfSquares[4][2][1][0] = true;
		ShapeOfSquares[4][2][1][1] = true;
		
		ShapeOfSquares[4][3][0][1] = true;//Shape anti z 3
		ShapeOfSquares[4][3][1][1] = true;
		ShapeOfSquares[4][3][1][2] = true;
		ShapeOfSquares[4][3][2][2] = true;
		
		ShapeOfSquares[5][0][0][2] = true;//Shape anti L 0
		ShapeOfSquares[5][0][1][2] = true;
		ShapeOfSquares[5][0][2][2] = true;
		ShapeOfSquares[5][0][2][1] = true;
		

		ShapeOfSquares[5][1][1][1] = true;//Shape anti L 1
		ShapeOfSquares[5][1][1][2] = true;
		ShapeOfSquares[5][1][1][3] = true;
		ShapeOfSquares[5][1][2][3] = true;
		
		ShapeOfSquares[5][2][0][1] = true;//Shape anti L 2
		ShapeOfSquares[5][2][0][2] = true;
		ShapeOfSquares[5][2][1][1] = true;
		ShapeOfSquares[5][2][2][1] = true;
		
		ShapeOfSquares[5][3][0][1] = true;//Shape anti L 3
		ShapeOfSquares[5][3][1][1] = true;
		ShapeOfSquares[5][3][1][2] = true;
		ShapeOfSquares[5][3][1][3] = true;
		
		
		ShapeOfSquares[6][0][0][1] = true;//Shape M 0
		ShapeOfSquares[6][0][1][0] = true;
		ShapeOfSquares[6][0][1][1] = true;
		ShapeOfSquares[6][0][1][2] = true;
		
		ShapeOfSquares[6][1][0][1] = true;//Shape M 1
		ShapeOfSquares[6][1][1][0] = true;
		ShapeOfSquares[6][1][1][1] = true;
		ShapeOfSquares[6][1][2][1] = true;
		
		ShapeOfSquares[6][2][1][0] = true;//Shape M 2
		ShapeOfSquares[6][2][1][1] = true;
		ShapeOfSquares[6][2][1][2] = true;
		ShapeOfSquares[6][2][2][1] = true;
		
		ShapeOfSquares[6][3][0][1] = true;//Shape M 3
		ShapeOfSquares[6][3][1][1] = true;
		ShapeOfSquares[6][3][1][2] = true;
		ShapeOfSquares[6][3][2][1] = true;
		
		
		

		ShapeBound[0][0][0] = 2; //Square 0 max X
		ShapeBound[0][0][1] = 0; //Square 0 min X
		ShapeBound[0][0][2] = 2; //Square 0 max Y

		ShapeBound[0][1][0] = 2; //Square 1 max X
		ShapeBound[0][1][1] = 0; //Square 1 min X
		ShapeBound[0][1][2] = 2; //Square 1 max Y

		ShapeBound[0][2][0] = 2; //Square 2 max X
		ShapeBound[0][2][1] = 0; //Square 2 min X
		ShapeBound[0][2][2] = 2; //Square 2 max Y

		ShapeBound[0][3][0] = 2; //Square 3 max X
		ShapeBound[0][3][1] = 0; //Square 3 min X
		ShapeBound[0][3][2] = 2; //Square 3 max Y

		ShapeBound[1][0][0] = 3; //Shape I 0 max X
		ShapeBound[1][0][1] = 2; //Shape I 0 min X
		ShapeBound[1][0][2] = 4; //Shape I 0 max Y

		ShapeBound[1][1][0] = 4; //Shape I 1 max X
		ShapeBound[1][1][1] = 0; //Shape I 1 min X
		ShapeBound[1][1][2] = 2; //Shape I 1 max Y

		ShapeBound[1][2][0] = 3; //Shape I 2 max X
		ShapeBound[1][2][1] = 2; //Shape I 2 min X
		ShapeBound[1][2][2] = 4; //Shape I 2 max Y

		ShapeBound[1][3][0] = 4; //Shape I 3 max X
		ShapeBound[1][3][1] = 0; //Shape I 3 min X
		ShapeBound[1][3][2] = 2; //Shape I 3 max Y

		ShapeBound[2][0][0] = 3; //Shape L 0 max X
		ShapeBound[2][0][1] = 1; //Shape L 0 min X
		ShapeBound[2][0][2] = 3; //Shape L 0 max Y

		ShapeBound[2][1][0] = 3; //Shape L 1 max X
		ShapeBound[2][1][1] = 0; //Shape L 1 min X
		ShapeBound[2][1][2] = 2; //Shape L 1 max Y

		ShapeBound[2][2][0] = 3; //Shape L 2 max X
		ShapeBound[2][2][1] = 1; //Shape L 2 min X
		ShapeBound[2][2][2] = 3; //Shape L 2 max Y

		ShapeBound[2][3][0] = 3; //Shape L 3 max X
		ShapeBound[2][3][1] = 0; //Shape L 3 min X
		ShapeBound[2][3][2] = 3; //Shape L 3 max Y

		ShapeBound[3][0][0] = 3; //Shape Z 0 max X
		ShapeBound[3][0][1] = 0; //Shape Z 0 min X
		ShapeBound[3][0][2] = 2; //Shape Z 0 max Y

		ShapeBound[3][1][0] = 3; //Shape Z 1 max X
		ShapeBound[3][1][1] = 1; //Shape Z 1 min X
		ShapeBound[3][1][2] = 3; //Shape Z 1 max Y

		ShapeBound[3][2][0] = 3; //Shape Z 2 max X
		ShapeBound[3][2][1] = 0; //Shape Z 2 min X
		ShapeBound[3][2][2] = 2; //Shape Z 2 max Y

		ShapeBound[3][3][0] = 3; //Shape Z 3 max X
		ShapeBound[3][3][1] = 1; //Shape Z 3 min X
		ShapeBound[3][3][2] = 3; //Shape Z 3 max Y
		
		ShapeBound[4][0][0] = 3; //Shape anti Z 0 max X
		ShapeBound[4][0][1] = 0; //Shape anti Z 0 min X
		ShapeBound[4][0][2] = 2; //Shape anti Z 0 max Y

		ShapeBound[4][1][0] = 3; //Shape anti Z 1 max X
		ShapeBound[4][1][1] = 1; //Shape anti Z 1 min X
		ShapeBound[4][1][2] = 3; //Shape anti Z 1 max Y

		ShapeBound[4][2][0] = 3; //Shape anti Z 2 max X
		ShapeBound[4][2][1] = 0; //Shape anti Z 2 min X
		ShapeBound[4][2][2] = 2; //Shape anti Z 2 max Y

		ShapeBound[4][3][0] = 3; //Shape anti Z 3 max X
		ShapeBound[4][3][1] = 1; //Shape anti Z 3 min X
		ShapeBound[4][3][2] = 3; //Shape anti Z 3 max Y
		
		ShapeBound[5][0][0] = 3; //Shape anti L 0 max X
		ShapeBound[5][0][1] = 1; //Shape anti L 0 min X
		ShapeBound[5][0][2] = 3; //Shape anti L 0 max Y

		ShapeBound[5][1][0] = 4; //Shape anti L 1 max X
		ShapeBound[5][1][1] = 1; //Shape anti L 1 min X
		ShapeBound[5][1][2] = 2; //Shape anti L 1 max Y

		ShapeBound[5][2][0] = 3; //Shape anti L 2 max X
		ShapeBound[5][2][1] = 1; //Shape anti L 2 min X
		ShapeBound[5][2][2] = 3; //Shape anti L 2 max Y

		ShapeBound[5][3][0] = 4; //Shape anti L 3 max X
		ShapeBound[5][3][1] = 1; //Shape anti L 3 min X
		ShapeBound[5][3][2] = 3; //Shape anti L 3 max Y
		
		ShapeBound[6][0][0] = 3; //Shape M 0 max X
		ShapeBound[6][0][1] = 0; //Shape M 0 min X
		ShapeBound[6][0][2] = 2; //Shape M 0 max Y

		ShapeBound[6][1][0] = 2; //Shape M 1 max X
		ShapeBound[6][1][1] = 0; //Shape M 1 min X
		ShapeBound[6][1][2] = 3; //Shape M 1 max Y

		ShapeBound[6][2][0] = 3; //Shape M 2 max X
		ShapeBound[6][2][1] = 0; //Shape anti L 2 min X
		ShapeBound[6][2][2] = 3; //Shape anti L 2 max Y

		ShapeBound[6][3][0] = 3; //Shape M 3 max X
		ShapeBound[6][3][1] = 1; //Shape M 3 min X
		ShapeBound[6][3][2] = 3; //Shape M 3 max Y

		/*
		for(int i=0;i<4;i++)
		{
			System.out.println("Shape No."+i);
			for(int j=0;j<4;j++)
			{
				for(int k=0;k<4;k++)
				{
					if(ShapeOfSquares[i][0][j][k])
						System.out.print("1");
					else
						System.out.print("0");
				}
				System.out.println();

			}
			System.out.println();
		}
		 */

	}
	public Color[] getColor()
	{
		return ColorArr;
	}
	public boolean[][][] getShape(int i)
	{
		return ShapeOfSquares[i];
	}
	public boolean[][] getShape(int i, int j)
	{
		return ShapeOfSquares[i][j];
	}
	public int[] getBound(int i, int j)
	{
		return ShapeBound[i][j];
	}
}
