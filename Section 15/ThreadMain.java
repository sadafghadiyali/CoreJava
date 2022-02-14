public class ThreadMain
{
    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_BLACK+"Running from main method");

        Thread anotherThread= new AnotherThread();
        anotherThread.start();


        new Thread(){
            public void run(){
                System.out.println(ThreadColor.ANSI_PURPLE+"Running from Anonymous class Thread");
            }
        }.start();



        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        Thread myRunnableThread2=new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_PURPLE+"Printing from anonynous runnable ") ;
                try{
                    myRunnableThread.join(2000); //wait 2 seconds for myRunnableThread to be terminate
                    System.out.println(ThreadColor.ANSI_CYAN + "myRunnableThread timed out or terminated");
                }catch(InterruptedException e){
                    System.out.println(ThreadColor.ANSI_RED+"MyRunnableThread2 got interrupted");
                }
            }
        });

        myRunnableThread2.start();

        System.out.println(ThreadColor.ANSI_BLACK+"Hello again from main thread");
    }
}
