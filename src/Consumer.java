
public class Consumer extends Thread{
	private Buffer umBuffer;
	
	public Consumer(Buffer data){
		super("Consumer");
		this.umBuffer = data;
	}
	
	public void run(){
		int value = 0, sum = 0;
		do {
			try {
				Thread.sleep((int) Math.random() *3000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			value = umBuffer.bufferReader();
			sum += value;
		} while (value != 10);
		
		System.err.println(getName() + " consumed" +
							" Total: " + sum);
	}
}
