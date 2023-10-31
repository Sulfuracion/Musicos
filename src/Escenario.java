import javax.sound.midi.Soundbank;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class Escenario extends Thread{
    int CantantesMaximo=1;
    int MusicosMaximo=3;

    public void entraCantante(Thread hilo){
        synchronized(Escenario.class){
            int CantantesEnEscena = 0;
            for (int i=0;i==5;i++){
                if (CantantesEnEscena<CantantesMaximo){
                    System.out.println("El cantante entrea en escena " + hilo.getName() + i);
                    CantantesMaximo--;
                    CantantesEnEscena++;
                } else if (CantantesEnEscena==CantantesEnEscena) {
                    System.out.println("Ya hay un cantante en escena");
                    try {
                        sleep(10000);//tardan 10 segundos en cambiar de cantante
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Escenario.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                System.out.println("Sale el cantante " + i);
                CantantesMaximo++;
                CantantesEnEscena--;
            }

        }

    }
    public void entraMusico(Thread hilo) {
        synchronized (Escenario.class) {
            for (int i=0;i==5;i++){
                System.out.println("Entra el musico " + i);
                try {
                    sleep(5000);//tardan 5 segundos en entrar otro musico
                } catch (InterruptedException ex) {
                    Logger.getLogger(Escenario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    public void run(){
        System.out.println("empieza el show");
        Escenario es= new Escenario();
        int vueltas=0;
        while (vueltas<5){

            System.out.println(vueltas);
            es.entraMusico(this);
            es.entraCantante(this);
            vueltas++;

        }
    }




}
