package org.cloud.face.tread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: TreadPoolConfig
 * @description: 线程池
 * @author: liulin
 * @create: 2019-07-03 11:09
 * @Version: 1.0
 */
public class TreadPoolConfig {

    //线程缓冲队列
    private static BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(100);
    // 核心线程数，会一直存活，即使没有任务，线程池也会维护线程的最少数量
    private static final int SIZE_CORE_POOL = 6;
    // 线程池维护线程的最大数量
    private static final int SIZE_MAX_POOL = 7;
    // 线程池维护线程所允许的空闲时间
    private static final long ALIVE_TIME = 2000;

    private static ThreadPoolExecutor pool = new ThreadPoolExecutor(SIZE_CORE_POOL, SIZE_MAX_POOL, ALIVE_TIME, TimeUnit.MILLISECONDS, bqueue, new ThreadPoolExecutor.CallerRunsPolicy());

    static {
        pool.prestartAllCoreThreads();
    }


    public static ThreadPoolExecutor getPool() {
        return pool;
    }

    public static void main(String[] args) {

		List<Integer> idList = new ArrayList<>();
        for(int i = 1; i < 500; i++){
			idList.add(i);
        }

		for (Integer id : idList) {
			pool.execute(new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + "执行...");
					System.out.println(Thread.currentThread().getName());
					System.out.println(id);
				}
			}));
		}
    }

    private static final ExecutorService EXECUTOR = new ThreadPoolExecutor(1,
            Runtime.getRuntime().availableProcessors(),60,TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(),new ThreadFactory(){
        @Override
        public Thread newThread(Runnable r){
            Thread t = new Thread(r,"VerfCodeSender");
            t.setDaemon(true);
            return t;
        }
    });
//
//    //生成并下发验证码短信到制定的手机号码
//    public void sendVerificationSme(final String misisdn){
//        Runnable task = new Runnable(){
//            @Override
//            public void run(){
//                //生成强随机数验证码
//                int verificationCode = new Random()
//                        .nextInt(999999);
//                DecimalFormat df = new DecimalFormat("000000");
//                String txtVerCode = df.format(verificationCode);
//
//                //发送验证码信息
//                sendSms(misisdn,txtVerCode);
//            }
//        };
//
//        EXECUTOR.submit(task);
//    }
//
//    private void sendSms(String msisdn,String verificationCode){
//        System.out.println("Sending verification code " + verificationCode + " to "
//                + msisdn);
//
//        //忽略其他与设计模式无关的代码
//    }
}

