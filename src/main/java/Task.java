public class Task implements Runnable{
    private static int order = 1;
    private static int currentOrder = 1;
    private static int num = 5;
    private static Object monitor = new Object();
    private int myOrder;
    private String myMessage;

    public Task(String mes) {
        myMessage = mes;
        myOrder = order++;
    }

    @Override
    public void run() {
        try{
                    for (int i = 0; i < num; i++) {
                        synchronized (monitor){
                            while(currentOrder != myOrder){
                                monitor.wait();
                            }
                            Thread.sleep(500);
                            System.out.print(myMessage + " ");
                            currentOrder++;
                            if(currentOrder == order){
                                currentOrder = 1;
                            }
                            monitor.notifyAll();
                        }
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
    }
}
