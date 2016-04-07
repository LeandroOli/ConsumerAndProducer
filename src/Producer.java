
public class Producer extends Thread{
	private Buffer oBuffer;
	
	public Producer(Buffer data){
		super("Producer");
		this.oBuffer = data;
	}
	
	public void run(){
		for(int i =1; i <=10; i++){
			try {
				Thread.sleep((int) Math.random() * 3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			oBuffer.bufferWriter(i);
		}
		System.err.println(getName() + " produced!");
	}
}
