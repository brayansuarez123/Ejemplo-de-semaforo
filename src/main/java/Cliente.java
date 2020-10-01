import java.util.concurrent.Semaphore;

public class Cliente implements Runnable{
  int idCliente;
  Tienda tienda;
  static int numeroPermisos = 5; // Numero de probadores.
  static Semaphore semaforo = new Semaphore(numeroPermisos);

  public Cliente(int id, Tienda shop){
    this.idCliente = id;
    this.tienda = shop;
  }

  public void run(){
    try {
      semaforo.acquire();
      this.tienda.usarProbador(this.idCliente);
    } catch (InterruptedException E) {
    }
    semaforo.release();
  }

}