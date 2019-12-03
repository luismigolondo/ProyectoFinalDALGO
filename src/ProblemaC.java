import java.util.Scanner;

/**
 * 
 */

/**
 * @author Luis Miguel Gomez 201729597 , Nicolas Rugeles 201731740
 *
 */
public class ProblemaC {

	private static int M;

	private static int N;

	private static int a;

	private static int b;

	private static int [] x;

	private static int [] y;

	public static int resolver()
	{
		int j = N - 1;
		boolean impares = false;
		int valor = -2;

		for ( int i = 0 ; i < N ; i++ ) {

			if (y[i] < b && y[j] >= b || y[j] < b && y[i] >= b) 
			{

				if ((x[i] + ( b - y[i] ) / ( y[j] - y[i] ) * ( x[j] - x[i] )) < a ) 
				{

					impares = !impares;

				}

			}

			j = i;

		}
		return valor = impares ? 1 : -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String linea = sc.nextLine();
		for(int i = 0; sc.hasNextLine(); i++)
		{
			String [] arreglo = linea.split(" ");
			if(i%2 == 0)
			{
				//Entonces asignamos M N a b
				M = Integer.parseInt(arreglo[0]);
				N = Integer.parseInt(arreglo[1]);
				a = Integer.parseInt(arreglo[2]);
				b = Integer.parseInt(arreglo[3]);

				x = new int [N];
				y = new int [N];
				System.out.println();
				System.out.println(M + " " + N + " " + a + " " + b);
			}
			else
			{
				//es el arreglo, aqui se llama al metodo para resolver

				//contador de posiciones
				int k = 0;

				for (int j = 0; j < 2* N; j += 2) {
					x[k] = Integer.parseInt(arreglo[j]);
					y[k] = Integer.parseInt(arreglo[j+1]);
					System.out.print(x[k] + " ");
					System.out.print(y[k] + " ");
					k++;
				}
				//Aca se resuelve y responde
				System.out.println();
				System.out.println(resolver() + "");
			}

			linea = sc.nextLine();
		}
		System.out.println("Acabe");
		sc.close();
		return;
	}
}
