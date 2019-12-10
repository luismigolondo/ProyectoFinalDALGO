import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Luis Miguel Gomez 201729597 , Nicolas Rugeles 201731740
 *
 */
public class ProblemaB {

	private static int N = 0;

	private static int [] k;

	private static int [] a;

	private static int [] b;

	// Búsqueda binaria
	public static int binariaCola(int arr[], int T[], int l, int r, int key) 
	{ 
		while (r - l > 1) { 

			int m = l + (r - l) / 2; 
			if (arr[T[m]] >= key) 
				r = m; 
			else
				l = m; 
		} 

		return r; 
	} 

	public static int LIS( 
			int arr[], int n) 
	{ 

		int indicesCola[] = new int[n]; 

		// Inicializado todo el arreglo de indices con 0
		Arrays.fill(indicesCola, 0); 

		int prevIndices[] = new int[n]; 

		// Inicializado todo el arreglo de indices previos con -1
		Arrays.fill(prevIndices, -1); 

		// simepre apunta a una ubicacion en arreglo sin existir
		int tam = 1; 

		for (int i = 1; i < n; i++) { 
			if (arr[i] < arr[indicesCola[0]]) 
			{
				// es un valor mas pequeño entonces potencial para empezar
				indicesCola[0] = i; 
			}
			else if (arr[i] > arr[indicesCola[tam - 1]]) { 

				// Cómo es mayor que el pasado entonces es un nuevo valor para los indices previos y cola
				prevIndices[i] = indicesCola[tam - 1]; 
				indicesCola[tam++] = i; 
			} 
			else { 

				// cómo es igual, de igual forma se quiere guardar como candidato por si
				// luego sirve mas para otra subsecuencia.
				int pos = binariaCola(arr, indicesCola, -1, tam - 1, arr[i]); 

				prevIndices[i] = indicesCola[pos - 1]; 
				indicesCola[pos] = i; 
			} 
		} 

		// Aqui vamos a recorrer la lista LIS resultante de la tabla A
		for (int i = indicesCola[tam - 1]; i >= 0; i = prevIndices[i]) 
			System.out.print(arr[i] + " "); 

		return tam; 
	} 
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea = null;
		try {
			int i = 0;
			while ((linea = br.readLine()) != null) 
			{
				if(i == 0)
				{
					//Entonces es el tamanio del arreglo
					N = Integer.parseInt(linea);
					k = new int [N];				
					a = new int [N];
					b = new int [N];
					System.out.println("N = " + N );
				}
				else
				{
					//es la tripla
					String [] arreglo = linea.split(" ");
					k[i-1] = Integer.parseInt(arreglo[0]);
					a[i-1] = Integer.parseInt(arreglo[1]);
					b[i-1] = Integer.parseInt(arreglo[2]);
					System.out.println(k[i-1] + " " + a[i-1] + " " + b[i-1] + " ");
					if(i % N == 0)
						System.out.println(LIS(a, N));

				}

				if(linea.equals("0"))
					return;
				
				i++;
				i = i % ( N + 1 );
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		};
		return;

	}

}
