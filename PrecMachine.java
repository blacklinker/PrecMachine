import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class PrecMachine{
	boolean [][] precs;
	Semaphore [][] semas;
	ArrayList <Thread> threads;
	
	
	class mythread implements Runnable{
		String name;
		int num;
		mythread(int num){
			this.name = "task";
			this.num = num;
		}
		@Override
		public void run() {
			for(int j=0;j<semas.length;j++) {		//use to acquire the semaphore of each task
				if(semas[j][num]!=null) {
					try {
						semas[j][num].acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					e.printStackTrace();
					}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("task "+ num);		//run the task, print the number of the task
			for(int i =0;i<semas[num].length;i++) {		//after finished, realease the semaphore
				if (semas[num][i]!=null) {
					semas[num][i].release();
				}
			}
			
		}
			
	}
		
	public PrecMachine(boolean[][] precs , Runnable[] jobs) throws InterruptedException {
		this.precs = precs;
		semas = new Semaphore[precs.length][precs[0].length];
		threads = new ArrayList<Thread>();
		for(int i=0;i<precs.length;i++) {
			for(int j=0;j<precs[i].length;j++) {
				if(precs[i][j] == true) {
					semas[i][j] = new Semaphore(0);
				}
				else {
					semas[i][j] = null;
				}
			}
		}
		for(int i=0;i<jobs.length;i++){
			threads.add(new Thread(new mythread(i)));
			}
		
	}
	public void run(){
		for(Thread x : threads) {
			x.start();
		}
	}	
}
