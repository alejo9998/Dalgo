import java.util.ArrayList;
import java.util.Scanner;

public class PuntoB {

	public int metodo (int n, int c, String a, String b  ){
		//Bolsa A
		String [] aa = a.split(" ");
		//Bolsa B
		String [] bb = b.split(" ");
		//Dinero de Juan
		int cc = c;

		//True si en k invirtio en A -- en k+1 no podra invertir
		//True si invirtio en A en el tiempo K, false si no
		boolean invirtioEnA = false;

		for (int i = 0; i<n; i++) {
			int numA = Integer.parseInt(aa[i]);
			int numB = Integer.parseInt(bb[i]);

			if ( numA > 0 && numB < 0) {
				cc = (int) (cc * (1 + (numA*0.01)));
				invirtioEnA = true;
				System.out.println(i + " Eligio A: " + numA);
			}

			else if ( numB > 0 && numA < 0) {
				cc = (int) (cc * (1 + (numB*0.01)));
				invirtioEnA = false;
				System.out.println(i + " Eligio B: " + numB);
			}

			else if ( numA > 0 && numB>0 && i != n-1 && numA > numB && !invirtioEnA) {

				int sigNumA = Integer.parseInt(aa[i+1]);
				int sigNumB = Integer.parseInt(bb[i+1]);
				if ( sigNumA > sigNumB && Math.abs(numA - numB) < Math.abs(sigNumA - sigNumB)) {
					cc = (int) (cc * (1 + (numB*0.01)));
					invirtioEnA = false;
					System.out.println(i + " Eligio B: " + numB);
				}
				else {
					cc = (int) (cc * (1 + (numA*0.01)));
					invirtioEnA = true;
					System.out.println(i + " Eligio A: " + numA);
				}

			}

			else {	
				if (numA > numB && numA > 0 && !invirtioEnA) {
					cc = (int) (cc * (1 + (numA*0.01)));
					invirtioEnA = true;
					System.out.println(i + " Eligio A: " + numA);
				}

				else if (invirtioEnA && numB > 0) {
					cc = (int) (cc * (1 + (numB*0.01)));
					invirtioEnA = false;
					System.out.println(i + " Eligio B: " + numB);
				}

				else if (numB >= numA && numB > 0) {
					cc = (int) (cc * (1 + (numB*0.01)));
					System.out.println(i + " Eligio B: " + numB);
				}	
			}
		}	
		return cc;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PuntoB puntob = new PuntoB();
		//int retornado = puntob.metodo(3, 1000, "2 10 4", "1 1 3");
		//int retornado = puntob.metodo(3, 1000, "-2 1 2", "1 0 3");
		//int retornado = puntob.metodo(4, 1000, "2 10 2 8", "1 1 1 3");
		//int retornado = puntob.metodo(4, 1000, "1 1 1 3", "2 10 2 8");
		//System.out.println(retornado);
		while (true) {
			System.out.println("Ingrese la prueba");
			String linea = sc.nextLine();
			if ( linea.equals("0 0")) {
				sc.close();
				break;
			}
			else {
				String nc = linea;
				String a = sc.nextLine();
				String b = sc.nextLine();
				String[] nncc = nc.split(" ");
				int resultado = puntob.metodo(Integer.parseInt(nncc[0]), Integer.parseInt(nncc[1]), a, b);
				System.out.println("Resultado de la prueba: " + resultado);
			}
		}
	}

}
