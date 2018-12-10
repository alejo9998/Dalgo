import java.util.Scanner;

public class problemaA 
{
	public int metodo(int longitud,String arreglo,int posicion)
	{
		//declaración de las variables
		String[] arr= arreglo.split(" ");
		
		int anterior = -1;
		int longitudMaxima=0;
		int longitudMomentanea=0;
		int longitudAux=0;
		
		boolean sale=false;
		boolean casiOrde=false;
		
		//validación de la longitud ingresada con la longitud del arreglo
		if(arr.length-longitud!=0)
		{
			System.out.println("La longitud del arreglo debe ser igual a la longitud ingresada");
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
					//recursión del metodo 
					longitudAux=metodo(longitud, arreglo, i+1);
				}
				else
					
				{
					
					
					sale=true;
					
				}
			}
		}
		
		//validacion del mayor resultado posible
	
			if(longitudMomentanea>longitudAux)
			{
				longitudMaxima=longitudMomentanea;
			}
			else
			{
				longitudMaxima=longitudAux;
			}
		
		
		return longitudMaxima;
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		problemaA punto = new problemaA();

		while(true)
		{
			

			String longitud = sc.nextLine();
			if(Integer.parseInt(longitud)==0)
			{
				System.out.println("Programa terminado");
				sc.close();
				break;
			}


			String arreglo= sc.nextLine();
			
			int resultado=punto.metodo(Integer.parseInt(longitud), arreglo, 0);
			System.out.println(resultado);
		}


	}

}
