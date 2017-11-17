package Ejercicio2;

class Q1 {
	/*
	 * La salida por poantalla son varias iteraciones de "Obengo: n" seguidas de otras
	 * varias de "Pongo: n" y viceversa
	 * 
	 * Esto se debe a que aunque se trate del mismo objeto Q1, los threads no respetan ningún
	 * orden por lo tanto cada thread ejecuta la funcion cuando le da la gana, por eso el orden
	 * de impresion de los mensajes por pantalla es tan caótica
	 */
	  int n;
	  synchronized int get() {
	    System.out.println("Obtengo: " + n);
	    return n;
	  }
	  synchronized void put(int n) {
	    this.n = n;
	    System.out.println("Pongo: " + n);
	  }
	}
	class Producer1 implements Runnable {
	  Q1 q;
	  Producer1(Q1 q) {
	    this.q = q;
	    new Thread(this, "Productor").start();
	  }
	  public void run() {
	    int i = 0;
	    while(true) {
	      q.put(i++);
	    }
	  }
	}
	class Consumer1 implements Runnable {
	  Q1 q;
	  Consumer1(Q1 q) {
	    this.q = q;
	    new Thread(this, "Consumidor").start();
	  }
	  public void run() {
	    while(true) {
	      q.get();
	    }
	  }
	}
	class PC {
	  public static void main(String args[]) {
	    Q1 q = new Q1();
	    new Producer1(q);
	    new Consumer1(q);
	    System.out.println("Pulsa Control-C para parar.");
	  }
	}

