package Ejercicio2;

class Q {
	/*
	 * La salida por pantalla son mensajes de "Obtengo: n" y "Pongo: n" intercaladamente
	 * 
	 * Esto se debe a la utilización de las funciones wait() y notify() junto al uso de un boolean
	 * que nos sirve como semáforo, para indicar en que momento se puede ejecutar la función y cuando nos
	 */
	  int n;
	  boolean valueSet = false;
	  
	  synchronized int get() {
	    if(!valueSet)
	      try {
	        wait();
	      } catch(InterruptedException e) {
	        System.out.println("InterruptedException capturada");
	      }
	    System.out.println("Obtengo: " + n);
	    valueSet = false;
	    notify();
	    return n;
	  }
	  
	  synchronized void put(int n) {
	    if(valueSet)
	      try {
	        wait();
	      } catch(InterruptedException e) {
	        System.out.println("InterruptedException capturada");
	      }
	    this.n = n;
	    valueSet = true;
	    System.out.println("Pongo: " + n);
	    notify();
	  }
	}

	class Producer implements Runnable {
	  Q q;
	  Producer(Q q) {
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
	
	class Consumer implements Runnable {
	  Q q;
	  Consumer(Q q) {
	    this.q = q;
	    new Thread(this, "Consumidor").start();
	  }
	  public void run() {
	    while(true) {
	      q.get();
	    }
	  }
	}
	
	class PCFixed {
	  public static void main(String args[]) {
	    Q q = new Q();
	    new Producer(q);
	    new Consumer(q);
	    System.out.println("Pulsa Control-C para parar.");
	  }
	}

