import java.util.ArrayList;
import java.util.Scanner;

//Ramón Alejandro Arias Rivera
//201718714
//Andrés Felipe Rojas Pinzón
//201715859

public class problemaB {

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

		for ( int i = 0; i<n ; i++) {
			int numA = Integer.parseInt(aa[i]);
			int numB = Integer.parseInt(bb[i]);

			if ( (numA <= 0 && numB <= 0) ) {
				invirtioEnA = false;
			}

			else if ( (numB > 0 && numB > numA) || (invirtioEnA && numB > 0)) {
				cc = (int) (cc * (1 + (numB*0.01)));
				invirtioEnA = false;
				//System.out.println(i + " Eligio B: " + numB);
			}

			else if ( i == n-1 && !invirtioEnA) {
				if ( numA > numB ) {
					cc = (int) (cc * (1 + (numA*0.01)));
					invirtioEnA = true;
					//System.out.println(i + " Eligio A: " + numA);
				}
				else {
					cc = (int) (cc * (1 + (numB*0.01)));
					invirtioEnA = false;
					//System.out.println(i + " Eligio B: " + numB);
				}
			}

			else if (i <= n-3 && !invirtioEnA) {
				int numA1 = Integer.parseInt(aa[i+1]);
				int numB1 = Integer.parseInt(bb[i+1]);
				int numA2 = Integer.parseInt(aa[i+2]);
				int numB2 = Integer.parseInt(bb[i+2]);
				//Si numA < 0 y numB > 0 o Si numB > numA y numB > 0

				if ( numA > 0 && numB > 0 && numA1 > 0 && numB1 > 0 && numA2 > 0 && numB2 > 0) {
					if ( numA + numB1 + numA2 > numB + numA1 + numB2 ) {
						cc = (int) (cc * (1 + (numA*0.01)));
						invirtioEnA = true;
						//System.out.println(i + " Eligio A: " + numA);
					}
					else {
						cc = (int) (cc * (1 + (numB*0.01)));
						invirtioEnA = false;
						//System.out.println(i + " Eligio B: " + numB);
					}
				}
				else if (numB < 0 ) {
					if ( numA + numB1 + numA2 > numA1 + numB2 ||
							numA + numB2 > numA1 + numA2) {
						cc = (int) (cc * (1 + (numA*0.01)));
						invirtioEnA = true;
						//System.out.println(i + " Eligio A: " + numA);
					}
				}
				else if (numB1 < 0) {
					if ( numA + numA2 > numB + numA1 + numB2) {
						cc = (int) (cc * (1 + (numA*0.01)));
						invirtioEnA = true;
						//System.out.println(i + " Eligio A: " + numA);
					}
					else {
						cc = (int) (cc * (1 + (numB*0.01)));
						invirtioEnA = false;
						//System.out.println(i + " Eligio B: " + numB);
					}
				}
				
				else if ( numA1 < 0) {
					if (numA > numB) {
						cc = (int) (cc * (1 + (numA*0.01)));
						invirtioEnA = true;
						//System.out.println(i + " Eligio A: " + numA);
					}
					else {
						cc = (int) (cc * (1 + (numB*0.01)));
						invirtioEnA = false;
						//System.out.println(i + " Eligio B: " + numB);
					}
				}
				
				else if ( numA2 < 0) {
					if (numA + numB1 > numB + numA1) {
						cc = (int) (cc * (1 + (numA*0.01)));
						invirtioEnA = true;
						//System.out.println(i + " Eligio A: " + numA);
					}
					else {
						cc = (int) (cc * (1 + (numB*0.01)));
						invirtioEnA = false;
						//System.out.println(i + " Eligio B: " + numB);
					}
				}
				
				else if ( numB2 < 0) {
					if (numA + numB1 + numA2 > numB + numA1) {
						cc = (int) (cc * (1 + (numA*0.01)));
						invirtioEnA = true;
						//System.out.println(i + " Eligio A: " + numA);
					}
					else {
						cc = (int) (cc * (1 + (numB*0.01)));
						invirtioEnA = false;
						//System.out.println(i + " Eligio B: " + numB);
					}
				}
			}
			else if (i == n-2 && !invirtioEnA) {
				int numA1 = Integer.parseInt(aa[i+1]);
				int numB1 = Integer.parseInt(bb[i+1]);

				if ( numA + numB1 > numB + numA1 ) {
					cc = (int) (cc * (1 + (numA*0.01)));
					invirtioEnA = true;
					//System.out.println(i + " Eligio A: " + numA);
				}
				else {
					cc = (int) (cc * (1 + (numB*0.01)));
					invirtioEnA = false;
					//System.out.println(i + " Eligio B: " + numB);
				}
			}
		}
		return cc;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		problemaB puntob = new problemaB();
		while (true) {
			System.out.println("");
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
				System.out.println(resultado);
			}
		}
	}

}
