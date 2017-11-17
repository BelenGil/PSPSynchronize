package Ejercicio4;

class Main {
	public static void main(String args[]) {
		Compartido c = new Compartido();
		Hilo holi = new Hilo("Amaneciendo",c);
		Hilo aio = new Hilo("Buenas noches, a descansar",c);
		holi.start();
		aio.start();
		try {
			holi.join();
			aio.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Otra semana de clases acabada");
	}
}

class Compartido {
	synchronized void holi(String msg) {
		System.out.println(msg);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Hilo extends Thread {
	String message;
	Compartido compartido;
	public Hilo(String msg, Compartido c) {
		this.message=msg;
		this.compartido=c;
	}
	
	@Override
	public void run() {
		synchronized (compartido) {
			for(int i = 0; i<5; i++) {
				compartido.holi(message+": "+(i+1));
			}
		}
	}
	
}
