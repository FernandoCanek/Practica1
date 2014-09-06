import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class LoveLetter {

	private static Scanner lectorEntrada = new Scanner(System.in);
	static int numeroTokens = 1;
	static boolean verificadorTokkens;
	
	static Carta[] mazo;
	
	static Jugador p1;
	static Jugador p2;
	
	static Random random = new Random();
	
	static int cartaRepartida = 15;
	
	
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
		
		String nombreP1;
		String nombreP2;
		
		//Creando al jugador que usará la persona
		System.out.println("Por favor ingresa tu nombre");
		nombreP1 = lectorEntrada.next();
		p1 = new Jugador(nombreP1);
		p1.setAutomatico(1);
			
		//Creando al jugador que "usará" la máquina
		System.out.println("Ahora ingresa el nombre de tu oponente");
		nombreP2 = lectorEntrada.next();
		p2 = new Jugador(nombreP2);
		p2.setAutomatico(2);
		
		//iniciando el menu del juego, que estará presente en todo...
		muestraMenuPartida();
		
		 mazo = creaMazo();
		
		/** Carta[] temporal = barajear(mazo);
		 
		 for(int i = 0; i< 16; i++){
			 System.out.println(mazo[i].getNombre());
		 }**/
		 
		 
		 int i = 0;
		 
		 reparteCartas(mazo);
		 
		 do{
			 if(i%2 == 0){
				 p1.jugar1();
				 i++;
			 }else{
				 p2.jugar2();
				 i++;
			 }
		 }while(true);
		 
		 
		 /**
		 do{
			 if(ordenAleatorio == 1){
				 if(controlJugadas%2 == 0){
					 p1.jugar();
					 controlJugadas++;
				 }else{
					 p2.jugar();
					 controlJugadas++;
				 }
			 }if(ordenAleatorio == 2){
				 if(controlJugadas%2 == 0){
					 p2.jugar();
					 controlJugadas++;
				 }else{
					 p1.jugar();
					 controlJugadas++;
				 }
			 }
		 }while(true);**/

		 
		 
		
			
	}

	

	

	private static void reparteCartas(Carta[] mazo) {
			
		p1.mano[0] = mazo[cartaRepartida];
		cartaRepartida--;
		p1.mano[1] = mazo[cartaRepartida];
		cartaRepartida--;
		
		p2.mano[0] = mazo[cartaRepartida];
		cartaRepartida--;
		p2.mano[1] = mazo[cartaRepartida];
		cartaRepartida--;
		
		System.out.println("carta siguiente " + cartaRepartida);
				
		
	}

	private static void muestraMenuPartida() {
		System.out.println(p1.getNombre() + ": " + p1.getTokensJugador() + " Tokens ~~~~~~~~~~~~" + " " + p2.getNombre() + 
				": " + p2.getTokensJugador() + " Tokens");			
	}

	private static Carta[] creaMazo() {
		
		Carta[] mazoOrdenado = new Carta[16]; 
		
		mazoOrdenado[0] = new Carta("Guardia", 1);
		mazoOrdenado[1] = new Carta("Guardia", 1);
		mazoOrdenado[2] = new Carta("Guardia", 1);
		mazoOrdenado[3] = new Carta("Guardia", 1);
		mazoOrdenado[4] = new Carta("Guardia", 1);
		
		mazoOrdenado[5] = new Carta("Clerigo", 2);
		mazoOrdenado[6] = new Carta("Clerigo", 2);
		
		mazoOrdenado[7] = new Carta("Baron", 3);
		mazoOrdenado[8] = new Carta("Baron", 3);
		
		mazoOrdenado[9] = new Carta("Doncella", 4);
		mazoOrdenado[10] = new Carta("Doncella", 4);
		
		mazoOrdenado[11] = new Carta("Principe", 5);
		mazoOrdenado[12] = new Carta("Principe", 5);
		
		mazoOrdenado[13] = new Carta("Rey", 6);
		
		mazoOrdenado[14] = new Carta("Doncella", 7);
		
		mazoOrdenado[15] = new Carta("Princesa", 8);
		
				return mazoOrdenado;
		
	}
	
	//private static Carta[] barajear(Carta[] mazoOrdenado) {
		
		//Carta[] mazoBarajeado = new Carta[mazoOrdenado.length];
		
		 
		// return mazoBarajeado;
		
		
	//}
	
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
	Scanner lectorEntradaCarta = new Scanner(System.in); 

	Carta(String nombre, int numero){
		
		this.nombre = nombre;
		this.numero = numero;
		
				
	}
	
	public String getNombre(){
		
		return this.nombre;
		
	}
	
	public int getNumero(){
		
		return this.numero;
				
	}

	public void funcionalidad() {
		
		int numeroCartaJugada = this.numero;
		
		switch(numeroCartaJugada){
		case 1:
				System.out.println("Selecciona la carta de tu rival");
				System.out.println("(1) Guardia, (2)Clerigo, (3) Baron, (4) Doncella, (5) Principe, "
						+ "(6) Rey, (7) Doncella, (8) Princesa " );
				
			
			break;
		case 2:
			
			String nombreCarta1 =  LoveLetter.p2.mano[0].getNombre();
			String nombreCarta2 = LoveLetter.p2.mano[1].getNombre();
			System.out.println("Tu oponente tiene en su mano" + nombreCarta1+ ", " +nombreCarta2 );
			
			break;
			
		case 3:
			String nombreCarta1Propia = LoveLetter.p1.mano[0].getNombre();
			String nombreCarta1Enemigo = LoveLetter.p2.mano[0].getNombre();
			int cartaPropia = LoveLetter.p1.mano[0].getNumero();
			int cartaEnemigo = LoveLetter.p2.mano[0].getNumero();
			String mensajeGanador;
			
			System.out.println("Las cartas de ambos jugadores son: "+ nombreCarta1Propia + " y " + 
			nombreCarta1Enemigo);
			if(cartaPropia > cartaEnemigo){
				mensajeGanador = "Tu tienes la carta más alta, tu enemigo pierde";
				System.out.println(mensajeGanador);

			}if(cartaEnemigo < cartaPropia){
				mensajeGanador = "Tu enemigo tiene la carta más alta, tu pierdes";
				System.out.println(mensajeGanador);

				
			}if(cartaPropia == cartaEnemigo){
				mensajeGanador = " Cartas iguales, ninguno gana :(";
				System.out.println(mensajeGanador);

			}
			
			
			
			break;
			
			
			
		case 4:
			break;
		case 5:
			//se dará la nueva carta al rival
			break;
		case 6:
			
			Carta temp = LoveLetter.p1.mano[0];
			Carta temp2 = LoveLetter.p2.mano[0];
			
			LoveLetter.p1.mano[0] = temp2;
			LoveLetter.p2.mano[0] = temp;
		
			break;
			 
		case 7:

			break;
		case 8:

			System.out.println("Haz perdido el juego :'(");
			break;
		
		}
		
	}
	
}

class Jugador{
	
	String nombre;
	int automatico;
	Carta[] mano = new Carta[2];
	int tokensJugador = 0;
	static Scanner lectorEntradaJugador = new Scanner(System.in);
	
	Jugador(String nombre){
		
		this.nombre = nombre;
		
	}
	
	public void setAutomatico(int automatico){//para diferenciar maquina de humano
		
		this.automatico = automatico;
	}
	
	public int getTokensJugador(){
		return this.tokensJugador;
	}

	public String getNombre(){
		return this.nombre;
	}
	
	
	
	public void jugar1(){
		
		int eleccion;
		String nombreCarta1 = mano[0].getNombre();
		String nombreCarta2 = mano[1].getNombre();
		System.out.println("Tienes en tu mano" + nombreCarta1 + ", "+ nombreCarta2);
		System.out.println("(1) Usar carta 1\n" + "(2) Usar carta 2\n" + "(3) Termina Juego\n");
		eleccion = lectorEntradaJugador.nextInt();
		
		if(eleccion == 1){
			mano[0].funcionalidad();
		}if (eleccion == 2){
			mano[1].funcionalidad();
		}if (eleccion == 3){
			LoveLetter.menuPrincipal();
		}
		}
	
	public void jugar2(){
		
	}
		
		
		
		
		
	
		
	
}



