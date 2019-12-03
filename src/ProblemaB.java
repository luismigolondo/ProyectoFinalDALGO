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
	
	public static int resolver()
	{
		return 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String linea = sc.nextLine();
		for(int i = 0; sc.hasNextLine();)
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
				if(i + 1 % N == 0)
					System.out.println(resolver());
				
			}
				
			linea = sc.nextLine();
			 i++;
			 i = i % ( N + 1 );
		}
		System.out.println("Acabe");
		sc.close();
		return;
		
	}

}
