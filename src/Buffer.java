
public class Buffer {
	private int memory = -1;
	private boolean empty;
	
	public synchronized void bufferWriter (int value){
		while (empty == true) {
            try {
                System.err.println("Producer waiting...");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		System.err.println(Thread.currentThread().getName() +
				" producing in Buffer: " + value);
		this.memory = value;
        empty = true;
        notifyAll();
	}
	
	public synchronized int bufferReader(){
	       while (empty == false) {
	            try {
	                System.err.println("Consumer waiting...");
	                wait();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
		System.err.println(Thread.currentThread().getName() +
				" consuming in  Buffer: " + this.memory);
		empty = false;
        notifyAll();
		return this.memory;
	}
}
