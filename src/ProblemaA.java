import java.util.Scanner;

/**
 * 
 */

/**
 * @author Luis Miguel Gomez 201729597 , Nicolas Rugeles 201731740
 *
 */
public class ProblemaA {

	private static int N;

	private static int [] a;

	public static int resolver()
	{
		return 0;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String linea = sc.nextLine();
		for(int i = 0; !linea.equals("0"); i++)
		{
			if(i%2 == 0)
			{
				//Entonces es el tamanio del arreglo
				N = Integer.parseInt(linea);
				a = new int [N];
				System.out.println();
				System.out.println("N = " + N );
			}
			else
			{
				//es el arreglo, aqui se llama al metodo para resolver	
				String [] arreglo = linea.split(" ");
				System.out.print("a = ");
				for (int j = 0; j < N; j++) {
					a[j] = Integer.parseInt(arreglo[j]);
					System.out.print(a[j] + " ");
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
