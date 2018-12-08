import java.util.Scanner;

public class punto1 
{
	public int metodo(int longitud,String arreglo,int posicion)
	{
		String[] arr= arreglo.split(" ");
		
		int anterior = -1;
		int longitudMaxima=0;
		int longitudMomentanea=0;
		int longitudAux=0;
		
		boolean sale=false;
		boolean casiOrde=false;
		
		if(arr.length-longitud!=0)
		{
			System.out.println("La longitud del arreglo debe ser igual a la longitud del arreglo ingresado");
		}
		else
		{
			
			for(int i = posicion; i<longitud && !sale;i++)
			{
				int numero = Integer.parseInt(arr[i]);
				if(anterior<numero)
				{
					longitudMomentanea++;
					anterior=numero;
					
				}
				else if(!casiOrde)
				{
					longitudMomentanea++;
					casiOrde=true;
					longitudAux=metodo(longitud, arreglo, i+1);
				}
				else
				{
					sale=true;
					if(longitudMomentanea>longitudMaxima)
					{
						if(longitudMomentanea>longitudAux)
						{
							longitudMaxima=longitudMomentanea;
						}
						else
						{
							longitudMaxima=longitudAux;
						}
					}
					else if(longitudAux>longitudMaxima)
					{
						longitudMaxima=longitudAux;
					}
				}
			}
		}
		
		return longitudMaxima;
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		punto1 punto = new punto1();

		while(true)
		{
			System.out.println("Ingrese longitud del arreglo");

			String longitud = sc.nextLine();
			if(Integer.parseInt(longitud)==0)
			{
				System.out.println("Programa terminado");
				sc.close();
				break;
			}

			System.out.println("Ingrese el arreglo");

			String arreglo= sc.nextLine();
			
			int resultado=punto.metodo(Integer.parseInt(longitud), arreglo, 0);
			System.out.println(resultado);
		}


	}

}
