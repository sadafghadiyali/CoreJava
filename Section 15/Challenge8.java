//=============using try lock to avoid deadlock=================
import java.util.concurrent.locks.ReentrantLock;

public class Challenge8 {

    public static void main(String[] args) {
        Tutor tutor = new Tutor();
        Student student = new Student(tutor);
        tutor.setStudent(student);

        Thread tutorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                tutor.studyTime();
            }
        });

        Thread studentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                student.handInAssignment();
            }
        });

        tutorThread.start();
        studentThread.start();
    }
}

class Tutor {
    private Student student;
    ReentrantLock lock;

    public synchronized void setStudent(Student student) {
        this.student = student;
        this.lock = new ReentrantLock();
    }

    public void studyTime() {
        try{
            if(lock.tryLock()){
                System.out.println("Tutor has arrived");
                try {
                    // wait for student to arrive and hand in assignment
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {

                }
                student.startStudy();
                System.out.println("Tutor is studying with student");
            }
        }finally {
            lock.unlock();
        }


    }

    public synchronized void getProgressReport() {
        // get progress report
        System.out.println("Tutor gave progress report");
    }
}

class Student {

    private Tutor tutor;
    ReentrantLock lock;

    Student(Tutor tutor) {
        this.tutor = tutor;
        this.lock=new ReentrantLock();
    }

    public synchronized void startStudy() {
        // study
        System.out.println("Student is studying");
    }

    public  void handInAssignment() {
        try{
            if(lock.tryLock()){
                tutor.getProgressReport();
                System.out.println("Student handed in assignment");
            }
        }finally {
            lock.unlock();
        }

    }
}