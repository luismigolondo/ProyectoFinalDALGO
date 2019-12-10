import java.util.Scanner;

/**
 * @author Luis Miguel Gomez 201729597 , Nicolas Rugeles 201731740
 *
 */
public class ProblemaA {

	private static int N;

	private static int [] a;

	public static int SR(int [] entrada)
	{
		int q = entrada.length; 
		//Matriz cuadrada del tamaño del input para hacer problema de programacion dinamica.
		int SRmatriz[][] = new int[q + 1][q + 1]; 
		//Tamaño del resultado
		int tam_resultado = 0; 
		//Aqui se concatenaran los numeros para el resultado 
		String resultado = ""; 

		//Aqui vamos recorriendo la tabla de abajo hacia arriba
		int indice = 0; 
		int i;

		for (i = 1; i <= q; i++) 
		{ 
			for (int j = i + 1; j <= q; j++) 
			{  
				if (entrada[i - 1] == entrada[j - 1] && SRmatriz[i - 1][j - 1] < (j - i)) 
				{ 
					//De esta forma se va moviendo uno en la tabla asignando valores
					SRmatriz[i][j] = SRmatriz[i - 1][j - 1] + 1;  
					if (SRmatriz[i][j] > tam_resultado) 
					{ 
						tam_resultado = SRmatriz[i][j]; 
						indice = Math.max(i, indice); 
					} 
				} 
				else 
				{ 
					SRmatriz[i][j] = 0; 
				} 
			} 
		} 
		// Proceso de concatenacion de los resultados... 
		if (tam_resultado > 0) { 
			for (i = indice - tam_resultado + 1; i <= indice; i++) { 
				resultado += entrada[i - 1]; 
			} 

		} 
		return tam_resultado; 
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String linea = sc.nextLine();
		for(int i = 0; sc.hasNextLine(); i++)
		{
			if(i%2 == 0)
			{
				//Entonces es el tamanio del arreglo
				N = Integer.parseInt(linea);
				a = new int[N];
			}
			else
			{
				//es el arreglo, aqui se llama al metodo para resolver	
				String [] arreglo = linea.split(" ");
				for (int j = 0; j < N; j++) 
				{
					a[j] = Integer.parseInt(arreglo[j]);
				}
				//Aca se resuelve y responde
				System.out.println(SR(a));
			}

			linea = sc.nextLine();
			if(linea.equals("0"))
				break;
		}
		sc.close();
		return;

	}
}
