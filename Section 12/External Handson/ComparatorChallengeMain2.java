import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }

    static final Comparator<Student> CHECKER = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            if (s1.cgpa == s2.cgpa) {
                return s1.fname.compareTo(s2.fname);
            }
            return Double.compare(s1.cgpa, s2.cgpa);
        }
    };
}
//Complete the code
public class ComparatorChallengeMain2
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        Collections.sort(studentList,Student.CHECKER);
        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}



