import java.util.Scanner;

/**
 * @author Luis Miguel Gomez 201729597 , Nicolas Rugeles 201731740
 *
 */
public class ProblemaC {
	
	private int x;
	
	private int y;

	private int[] CoordX;
	
	private int[] CoordY;
	
	private int tamanio;
	
	private int dim;
	
	private int maxX;
	
	private int minX;
	
	//private int tocaIzq;
	//private int noTocaIzq;
	//private int tocaDer;
	//private int noTocaDer;
	
	private int contadorDer;
	
	private int contadorIzq;

	public ProblemaC(int tam,int x1,int y1, int[] X, int[] Y,int dimension, int min, int max ) {
		x=x1;
		y=y1;
		dim = dimension;
		tamanio=tam+1;
		CoordX=X;
		CoordY=Y;
		contadorDer=0;
		contadorIzq=0;
		//tocaDer=x1;
		//noTocaIzq=x1;
		//noTocaDer=x1;
		//tocaIzq=x1;
		minX=min;
		maxX=max;

	}	
	public int contar() {
		//PONERLE EL PRIMER PUNTO AL FINAL A CADA UNO
		int resultado=-1;
		for (int i=0; i<tamanio-1;i++) {
			if(CoordX[i]==x && CoordY[i]==y) {
				//terminaaaaaaaaaaar es un vertice 
				return 0;
			}
			else if (CoordX[i]>=x && CoordX[i+1]>x||CoordX[i]>x && CoordX[i+1]>=x) {//si ambos son mas grandes 
				int rta=CompararY(i);
				if (rta==1||rta==2)
					contadorDer++;
				/*
				else if (rta==0) {
					//FALTAAAAAAAAAAAA revisar si es un vertice 
					if(CoordY[i]==CoordY[i+1]) {
						int max =Math.max(CoordX[i],CoordX[i+1]);
						if(max>tocaDer) {
							tocaDer=max;
						}
					}
					else if (CoordY[i]==y) {
						if(CoordX[i]>tocaDer) {
							tocaDer=CoordX[i];
						}
					}
					else if (CoordY[i+1]==y) {
						if(CoordX[i+1]>tocaDer) {
							tocaDer=CoordX[i+1];
						}
					}

				}
				 */
				//FALTA SUMARLE UNO A TOCADER
			}
			else if (CoordX[i]<=x && CoordX[i+1]<x||CoordX[i]<x && CoordX[i+1]<=x) {//si ambos son mas pequenos
				int rta=CompararY(i);
				if (rta==1||rta==2)
					contadorIzq++;
				/*
				if (rta==0) {
					if(CoordY[i]==CoordY[i+1]) {
						int min =Math.min(CoordX[i],CoordX[i+1]);
						if(min>tocaDer) {
							tocaDer=min;
						}
					}
					else if (CoordY[i]==y) {
						if(CoordX[i]<tocaIzq) {
							tocaIzq=CoordX[i];
						}
					}
					else if (CoordY[i+1]==y) {
						if(CoordX[i+1]<tocaIzq) {
							tocaIzq=CoordX[i+1];
						}
					}

				}
				 */
				//FALTA SUMARLE UNO A TOCAIzq
			}
			else if(CoordX[i]<x && CoordX[i+1]>x) {
				int rta=CompararY(i);
				if (rta==1) {
					VerificarPendiente(i);
					int resp= VerificarPendiente(i);
					if (resp==-1) {
						contadorDer++;
					}
					else if (resp==1) {
						contadorIzq++;
					}
					else if (resp==0) {
						//TERMINAAAAAAAAAAR pertenece a una arista
						return 0;
					}	
				}
				if (rta==2) {
					VerificarPendiente(i);
					int resp= VerificarPendiente(i);
					if (resp==1) {
						contadorDer++;
					}
					else if (resp==-1) {
						contadorIzq++;
					}
					else if (resp==0) {
						//TERMINAAAAAAAAAAR pertenece a una arista
						return 0;
					}	
				}
				/*
				if (rta==0) {
					//FALTAAAAAAAAAAAAA 
					if(CoordY[i]==CoordY[i+1]) {
						//TERMINAR
						return 0;
					}
					else if (CoordY[i]==y) {
						if(CoordX[i]<tocaIzq) {
							tocaIzq=CoordX[i];
						}
					}
					else if (CoordY[i+1]==y) {
						if(CoordX[i+1]>tocaDer) {
							tocaDer=CoordX[i+1];
						}
					}

				}
				 */
			}
			else if (CoordX[i]>x && CoordX[i+1]<x) {
				int rta=CompararY(i);
				if (rta==1) {
					VerificarPendiente(i);
					int resp= VerificarPendiente(i);
					if (resp==1) {
						contadorDer++;
					}
					else if (resp==-1) {
						contadorIzq++;
					}
					else if (resp==0) {
						//TERMINAAAAAAAAAAR pertenece a una arista
						return 0;
					}	
				}
				if (rta==2) {
					VerificarPendiente(i);
					int resp= VerificarPendiente(i);
					if (resp==-1) {
						contadorDer++;
					}
					else if (resp==1) {
						contadorIzq++;
					}
					else if (resp==0) {
						//TERMINAAAAAAAAAAR pertenece a una arista
						return 0;
					}	
				}
				/*
				if (rta==0) {
					if(CoordY[i]==CoordY[i+1]) {
						//TERMINAR
						return 0;
					}
					else if (CoordY[i]==y) {
						if(CoordX[i]>tocaDer) {
							tocaDer=CoordX[i];
						}
					}
					else if (CoordY[i+1]==y) {
						if(CoordX[i+1]<tocaIzq) {
							tocaIzq=CoordX[i+1];
						}
					}

				}
				 */
			}
			else if (CoordX[i]==x && CoordX[i+1]==x) {
				int rta=CompararY(i);
				if (rta==0||rta==1||rta==2) {
					//TERMINAR
					return 0;
				}
			}
		}
		return resultado;
	}
	public int CompararY(int i) {
		int rta=0;
		if (CoordY[i]>y && CoordY[i+1]<y) {
			rta=1;
		}
		else if(CoordY[i]<y && CoordY[i+1]>y) {
			rta=2;
		}
		else if (CoordY[i]>y && CoordY[i+1]>y) {
			rta=-1;
		}
		else if (CoordY[i]<y && CoordY[i+1]<y) {
			rta=-1;
		}
		return rta;
	}
	public int VerificarPendiente(int i) {
		int rta=0;
		double pendiente= (double)(CoordY[i]-CoordY[i+1])/(CoordX[i]-CoordX[i+1]);
		double punto=(double)(pendiente*x+(CoordY[i]-pendiente*CoordX[i]));
		if (y>punto) {
			rta=1;
		}
		else if(y<punto) {
			rta=-1;
		}

		return rta;
	}
	public int Resultado() {
		int resultado=20;
		if(x<minX || x>maxX)
			return 0;
		int rta=contar();
		//if (tocaDer==maxX)
		//contadorDer++;
		//if (tocaIzq==minX)
		//contadorIzq++;
		//System.out.println("contadorIzq"+ contadorIzq);
		//System.out.println("contadorDer"+ contadorDer);

		if (rta==0) {
			resultado=0;
		}
		else {
			if(contadorDer%2==1 && contadorIzq%2==1) {
				resultado=1;
			}
			if(contadorDer%2==0 && contadorIzq%2==0) {
				resultado=-1;
			}
		}
		return resultado;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String linea = sc.nextLine();
		
		int M=0;
		int N=0;
		int a=0;
		int b=0;
		int minimo=0;
		int maximo=0;
		int[] x =new int[1];
		int[] y=new int[1];
		
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
				x = new int [N+1];
				y = new int [N+1];
				//System.out.println();
				//System.out.println(M + " " + N + " " + a + " " + b);
			}
			else
			{
				//es el arreglo, aqui se llama al metodo para resolver
				//contador de posiciones
				int k = 0;
				minimo=M;
				maximo=0;
				for (int j = 0; j < 2* N; j += 2) {
					x[k] = Integer.parseInt(arreglo[j]);
					y[k] = Integer.parseInt(arreglo[j+1]);
					if (y[k]== b)
						y[k]+=1;
					//System.out.print(x[k] + " ");
					//System.out.print(y[k] + " ");
					if (minimo>x[k]) {
						minimo=x[k];
					}
					if (maximo<x[k]) {
						maximo=x[k];
					}
					k++;
				}
				x[N] = Integer.parseInt(arreglo[0]);
				y[N] = Integer.parseInt(arreglo[1]);
				//Aca se resuelve y responde
				ProblemaC prob=new ProblemaC(N,a,b,x,y,M,minimo,maximo);
				//System.out.println();
				//System.out.println(minimo + "min max    "+ maximo);
				System.out.println(prob.Resultado());
			}
			linea = sc.nextLine();
			if(linea.equals("0 0 0 0"))
				break;
		}
		//System.out.println("Acabe");
		sc.close();
		return;
	}
}