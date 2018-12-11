import java.util.Scanner;

public class problemaC {


	public void metodo(int longitud,String Arreglo)
	{
		String[] arr= Arreglo.split(" ");

		int resultado=0;
		if(2*longitud-arr.length!=0)
		{
			System.out.println("La longitud ingresada no concuerda con la cantidad ingresada de datos");
		}
		else
		{
			for(int i=0;i<longitud*2;i+=2)
			{

				int numero = i;

				for (int j=i;j<(longitud*2);j+=2)
				{


					if(Integer.parseInt(arr[i])>Integer.parseInt(arr[j]))
					{
						numero=j;
					}
				}


				String cambioX = arr[numero];
				String cambioY=arr[numero+1];

				arr[numero]= arr[i];
				arr[numero+1]= arr[i+1];
				arr[i]=cambioX;
				arr[i+1]=cambioY;
			}
		
			

			boolean esVacio=true;
			int CantidadMayor=0;
			int limiteMayor=Integer.MAX_VALUE;
			int limiteMenor=0;
			for(int i =0;i<longitud*2;i+=2)
			{
				int momentX=Integer.parseInt(arr[i]);
				int momentY=Integer.parseInt(arr[i+1]);
				int cantidadinter=0;
				
				for (int j = 0;j<longitud*2;j+=2)
				{
					if(i!=j)
					{
						
						int jx=Integer.parseInt(arr[j]);
						int jy=Integer.parseInt(arr[j+1]);

						if(momentY<jx)
						{

						}
						else if(momentX>jy)
						{
							
						}
						else if(momentY>=jx)
						{
							
							esVacio=false;

							if(momentX<jx)
								momentX=jx;
							if(momentY>jy)
								momentY=jy;
							cantidadinter++;
						}
					}
				}
				
				if(cantidadinter>CantidadMayor)
				{
					CantidadMayor=cantidadinter;
					limiteMayor=momentY;
					limiteMenor=momentX;
				}
			}
			if(esVacio)
			{
				limiteMayor=Integer.parseInt(arr[0]);
				limiteMenor=Integer.parseInt(arr[1]);
			}
			
			resultado = (limiteMayor+limiteMenor)/2;
			
		}
		System.out.println(resultado);
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		problemaC punto = new problemaC();

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

			punto.metodo(Integer.parseInt(longitud), arreglo);

		}
	}
}
