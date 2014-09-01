import java.util.InputMismatchException;
import java.util.Scanner;


public class LoveLetter {

	private static Scanner lectorEntrada = new Scanner(System.in);
	static int numeroTokens = 1;
	static boolean verificadorTokkens;
	
	static Carta[] mazo = new Carta[15];
	
	public static void main(String[] args) {
		 
		menuPrincipal();	
		
	}

	public static void menuPrincipal() {
		
		System.out.println("== Bienvenido a Love Letter == \n\n"  +
				" (1) Jugar partida \n (2) Seleccionar número de Tokens"
				+ "\n (3) Mostrar las reglas \n (4) Salir \n \n \n" );
		
		
		
		try{
			switch(lectorEntrada.nextInt()){
				case 1:
					iniciaPartida();
					break;
		
				case 2:
					asignaTokens();
					break;
			
				case 3:
					muestraReglas();
					break;
			
				case 4:
					System.out.println("Gracias por utilizar el juego Love-Letter, hasta pronto...");
					System.exit(0);
					break;
		
				default: 
					break;
			

				}
		}catch(InputMismatchException e){
			System.out.println("¡Valor incorrecto, ingrese un número entre 1-4! \n");	
			System.exit(0);
			
		}
	
	}
	
	
	

	private static void iniciaPartida() {
		
		creaMazo();
		creaOrdenAleatorio();
		
	}

	

	private static void creaMazo() {
		
		mazo[0] = new Carta("Guardia", 1);
		mazo[1] = new Carta("Guardia", 1);

		mazo[2] = new Carta("Clerigo", 2);
		mazo[3] = new Carta("Clerigo", 2);
		
		mazo[4] = new Carta("Baron", 3);
		mazo[5] = new Carta("Baron", 3);

		mazo[6] = new Carta("Doncella", 4);
		mazo[7] = new Carta("Doncella", 4);
		
		mazo[8] = new Carta("Principe", 5);
		mazo[9] = new Carta("Principe", 5);
		
		mazo[10] = new Carta("Rey", 6);
		mazo[11] = new Carta("Rey", 6);
		
		mazo[12] = new Carta("Condesa", 7);
		mazo[13] = new Carta("Condesa", 7);

		mazo[14] = new Carta("Princesa", 8);
		mazo[15] = new Carta("Princesa", 8);
	}
	
	private static void creaOrdenAleatorio() {
		
	}
	

	private static void asignaTokens() {
		
		System.out.println("\nUn Token es ganado cada vez que se gana un turno "
				+ "y tu carta es enviada a la Princesa Annette. \ndetermina "
				+ "el numero de Tokens que se utilizarán en la partida: \n \n"
				+ "Minimo = 1 \nMáximo = 3   \nActual:" + numeroTokens +"\n \n");
		
		
		int tokensTemporal = lectorEntrada.nextInt();
		
		verificadorTokkens = true;
		
		do{
			
			if(tokensTemporal > 0 && tokensTemporal < 4){
			
				numeroTokens = tokensTemporal;
				System.out.println("Actual: " +numeroTokens +"\n");
				verificadorTokkens = false;
			
			}else{
				
				System.out.println("\nEl numero elegido es muy alto\n");
				System.out.println("Por favor elije otro\n");
				asignaTokens();
			}
		}while(verificadorTokkens == true);
		
		System.out.println("Regresar al menu principal? s/n");
		
		char eleccion = lectorEntrada.next().charAt(0); 
		
		if(eleccion == 's'){
			menuPrincipal();
		}if (eleccion == 'n'){
			asignaTokens();
		}
	}

	private static void muestraReglas() {
		
		String reglas1 = "Tras el arresto de la Reina Marianna acusada de alta traición, nadie resultó \n"
				+ "más entristecida por la noticia que su hija la princesa Annete. Los pretendientes de\n"
				+ "la ciudad estado de Tempest buscan consolar la pena de Annete cortejandola para traer\n"
				+ "un poco de alegría a su vida. Tú eres uno de esos pretendientes, intentado que tu carta \n"
				+ "de amor llegue a la princesa. Lamentablemente ella se ha recluido en su palacio por lo \n"
				+ "que debes confiar que los intermediarios lleven tu mensaje. A lo largo del juego, \n"
				+ "mantendrás una carta en secreto en tu mano, que representa a quien llevará tu mensaje\n"
				+ "de amor a la princesa. Deberás asegurarte de que sea la persona más cercana a la \n"
				+ "princesa la que tenga tu carta al final del día, para que pueda entregarla primero...\n";
		
		String reglas2 = "Se le dara al jugador cuyo turno comienza una nueva carta del mazo. Durante tu turno, \n"
				+ "tomaras otra carta del mazo y deberás jugar la de menor valor. Si se encontraba protegido por \n"
				+ "la carta HandMaid el efecto de esta carta desaparecera. Un jugador podra utilizar una sobre su \n"
				+ "rival siempre y cuando este no se encuentre protegido por la HandMaid. Cada vez que el jugador \n"
				+ "use una carta su turno terminara.\n";
		
		
		String reglas3 =" \n(1) Guardia:\n"
				+ "Permite adivinar la mano del rival (cartas del 2-8) si adivina, el jugador rival sale del juego. (2 en el mazo).\n"
				+ "\n(2) Clérigo:\n"
				+ "Permite ver la mano del jugador rival. (2 en el mazo).\n"
				+ "\n(3) Baron:\n"
				+ "Compara manos con el rival, el jugador con la carta mas baja sale del juego. En caso de empate no sucede nada. (2 en el mazo).\n"
				+ "\n(4) Doncella:\n"
				+ "El jugador que utiliza esta carta es inmune a los ataques de los demas por un (1) turno. (2 en el mazo).\n"
				+ "\n(5) Principe:\n"
				+ "Permite “botar” la mano del jugador o la del rival. Y da una carta nueva del mazo. (2 en el mazo).\n"
				+ "\n(6) Rey:\n"
				+ "Intercambia manos entre jugadores.(2 en el mazo).\n"
				+ "\n(7) Condesa:\n"
				+ "Si el jugador tiene un Prince o King en su mano y la Countess debe jugar la Countess. (2 en el mazo).\n"
				+ "\n(8) Princesa:\n"
				+ "Si el jugador juega esta carta pierde el juego. (2 en el mazo)\n";
		
		
		 
		
		System.out.println("OBJETIVO: \n\n " + reglas1 +"\n\nDESARROLLO DEL JUEGO: \n\n" + reglas2 + 
				"\n\nPERSONAJES: \n\n" +reglas3);
		
		System.out.println("Regresar al menu principal? s/n");
		
		char eleccion = lectorEntrada.next().charAt(0); 
		
		if(eleccion == 's'){
			menuPrincipal();
		}if (eleccion == 'n'){
			muestraReglas();
		}
	}

}



class Carta{
	
	String nombre;
	int numero;

	Carta(){
		
	}
	
	Carta(String nombre, int numero){
		
		this.nombre = nombre;
		this.numero = numero;
		
				
	}
	
	public String setNombre(){
		
		return this.nombre;
		
	}
	
	public int setNumero(){
		
		return this.numero;
				
	}
	
}






















