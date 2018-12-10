import java.util.Scanner;

public class problemaC {


	public void metodo(int longitud,String Arreglo)
	{
		String[] arr= Arreglo.split(" ");
		int limiteMenor=Integer.parseInt(arr[0]);
		int limiteSuperior=Integer.parseInt(arr[1]);
		int resultado=0;
		if(2*longitud-arr.length!=0)
		{
			System.out.println("La longitud ingresada no concuerda con la cantidad ingresada de datos");

		}
		else
		{
			int limInferiroMome=0;
			int limSupMoMe=0;
			for(int i =2;i<longitud*2;i+=2)
			{
				limInferiroMome=Integer.parseInt(arr[i]);
				limSupMoMe=Integer.parseInt(arr[i+1]);

				if(limiteSuperior<limInferiroMome)
				{

				}
				else if(limiteMenor>limSupMoMe)
				{
					
					limiteSuperior=limSupMoMe;
					limiteMenor=limInferiroMome;
				}
				else if(limiteMenor<=limInferiroMome || limiteSuperior>=limSupMoMe)
				{
					
					
					if(limiteMenor<limInferiroMome)
					{
						limiteMenor=limInferiroMome;

					}

					if(limiteSuperior>limSupMoMe)
					{

						limiteSuperior=limSupMoMe;
						
					}
					
				}
				
			}
			
			resultado =(limiteSuperior+limiteMenor)/2;


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
