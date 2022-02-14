public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_BLUE+"Hello from Runnable Thread");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ThreadColor.ANSI_RED+"MyRunnable Interrupted");
        }
        System.out.println(ThreadColor.ANSI_BLUE+"Three seconds have passed and I am awake");
    }
}
