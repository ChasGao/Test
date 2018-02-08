package Process;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableImpl implements Callable<String> {

	public static void main(String[] args) {
		Callable<String> callable = new CallableImpl("haha ");
		FutureTask<String> task = new FutureTask<String>(callable);
		String result = "";
		long beginTime = System.currentTimeMillis();
		new Thread(task).start();
		try {
			//调用get()阻塞主线程
			result = task.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("cost time "+ (endTime-beginTime));
		System.out.println(result);
		
		
	}

	private String str;
	
	@Override
	public String call() throws Exception {
        // 任务阻塞 1 秒
        Thread.sleep(3000);
		return this.str+"append some char";
	}

	
	/**
	 * construction
	 * @param str
	 */
	public CallableImpl(String str) {
		this.str = str;
	}

	
	
}
