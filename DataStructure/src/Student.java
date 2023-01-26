public class Student implements Comparable<Student> {
    private final String id ,name;
    private final int math, dataStr;

    public Student(String id, String name, int math, int dataStr) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.dataStr = dataStr;
    }

    public int getMath() {
        return math;
    }

    public int getDataStr() {
        return dataStr;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", math=" + math +
                ", dataStr=" + dataStr +
                '}';
    }

    @Override
    public int compareTo(Student s) {

        if ((this.dataStr+this.math)/2>(s.dataStr+s.math)/2)
            return 1;
        else if ((this.dataStr+this.math)/2==(s.dataStr+s.math)/2)
            return 0;
        else
            return -1;
    }



    public int compareByDataStr(Student s) {

        return Integer.compare(this.dataStr, s.dataStr);
    }

    public int compareById(String s) {
        if (this.id.equals(s)) return 1;
        return 0;
    }
}
