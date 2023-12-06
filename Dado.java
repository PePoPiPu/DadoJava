import java.util.Scanner;
import java.util.Random;

public class Dado{
    public static void main(String[] args){
        int fichasUsuario;
        int fichasMaquina;
        int apuestaUsuario;
        int apuestaMaquina;
        int caraUsuario;
        int caraMaquina;
        int puntosUsuario = 0;
        int puntosMaquina = 0;
        int rondas;
        int contadorRonda = 0;
        Scanner Entrada = new Scanner(System.in);

        System.out.print("¿Cuántas rondas quieres jugar? (Solo se pueden jugar un máximo de 10 >> )");
        rondas = Entrada.nextInt();

        System.out.print("Elije un número de fichas para ambos jugadores >> ");
        fichasUsuario = Entrada.nextInt();
        fichasMaquina = Entrada.nextInt();

        do {
            contadorRonda++;
            System.out.println("Ronda nº " + contadorRonda + ".");
            System.out.print("Elige el número de fichas que quieras apostar >> ");
            apuestaUsuario = Entrada.nextInt();
    
            Random randGen = new Random();
    
            apuestaMaquina = randGen.nextInt(101);
            System.out.println("La máquina juega con " + apuestaMaquina + " fichas.");

            System.out.println("El usuario tira un dado.");
            caraUsuario = randGen.nextInt(7);
            System.out.println("El usuario saca: " + caraUsuario);

            System.out.println("La máquina tira un dado: ");
            caraMaquina = randGen.nextInt(7);
            System.out.println("La máquina saca: " + caraMaquina);

            if(caraUsuario == caraMaquina){
                System.out.println("Empate.");
            } else if(caraUsuario < caraMaquina) {
                fichasUsuario -= apuestaUsuario;
                fichasMaquina += apuestaUsuario;
                puntosMaquina++;
                System.out.println("Gana la máquina y tiene " + puntosMaquina + " puntos.");
            } else {
                fichasMaquina -= apuestaMaquina;
                fichasUsuario += apuestaMaquina;
                puntosUsuario++;
                System.out.println("Gana el usuario y tiene " + puntosUsuario + " puntos.");
            }
        } while(contadorRonda != rondas);        
        if (puntosUsuario < puntosMaquina){
            System.out.println("Gana la máquina.");
        } else {
            System.out.println("Gana el usuario.");
        }
    } 
}
