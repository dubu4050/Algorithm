import java.io.*;
import java.util.Arrays;

class Student implements Comparable<Student>{
    String name;
    int korean;
    int eng;
    int math;

    public Student(String name, int korean, int eng, int math) {
        this.name = name;
        this.korean = korean;
        this.eng = eng;
        this.math = math;
    }
    @Override
    public int compareTo(Student o) {
        if(this.korean==o.korean){
            if(this.eng==o.eng){
                if(this.math==o.math)
                    return this.name.compareTo(o.name);
                return this.math<o.math?1:-1;
            }
            return this.eng>o.eng?1:-1;
        }
        return this.korean<o.korean?1:-1;
    }
    @Override
    public String toString() {
        return name;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            students[i]= new Student(input[0],Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3]));
        }
        Arrays.sort(students);
        for(Student s:students)
            System.out.println(s.toString());
    }
}
