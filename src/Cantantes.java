public class Cantantes extends Thread{
    Escenario CantantesMaximo;

    Cantantes(Escenario CantantesMaximo){
        this.CantantesMaximo=CantantesMaximo;
    }

    public void run(){
        CantantesMaximo.entraCantante(this);
    }
}
