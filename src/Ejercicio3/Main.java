package Ejercicio3;

	class Main {
		public static void main(String[] args ) {
			Hilo hilo1 = new Hilo("hilo1");
			Hilo hilo2 = new Hilo("hilo2");
			Hilo hilo3 = new Hilo("hilo3");
			Hilo hilo4 = new Hilo("hilo4");
			Hilo hilo5 = new Hilo("hilo5");
			
			hilo1.setPriority(Thread.MAX_PRIORITY);
			hilo2.setPriority(Thread.MIN_PRIORITY);
			hilo3.setPriority(Thread.MAX_PRIORITY);
			hilo4.setPriority(Thread.NORM_PRIORITY);
			hilo5.setPriority(Thread.MAX_PRIORITY);
			
			hilo1.start();
			hilo2.start();
			hilo3.start();
			hilo4.start();
			hilo5.start();
			
		}
	}
	
	class Hilo extends Thread{
		String message;
		public Hilo(String msg) {
			this.message=msg;
		}
		
		@Override
		public void run() {
			
			try {
				System.out.println(message);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
