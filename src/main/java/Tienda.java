
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tienda {

  public void usarProbador(int idClliente) {
    long tiempoNecesitado = (long) (Math.random() * 10000);
    try {
      System.out.println("El cliente " + idClliente + " acaba de entrar a un probador");
      Thread.sleep(tiempoNecesitado); // El cliente se tomara su tiempo para probarse la ropa.
      System.out.println("El cliente " + idClliente + " ha terminado en un tiempo " + tiempoNecesitado);
    } catch (InterruptedException E) {
      System.out.println("Se genero una excepcion probandose ropa");
    }
  }

  public static void main(String[] args) {
    Tienda tienda = new Tienda(); // Usaremos la misma referencia para que todos accedan a la misma tienda.
    ExecutorService ejecutor = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 20; i++) {
      ejecutor.execute(new Cliente(i, tienda));
    }
    ejecutor.shutdown();
    while (!ejecutor.isTerminated());
  }
}