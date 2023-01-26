import java.io.File;
import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class GenericDoublyLinkedList {

    public static void main(String[] args) throws IOException {
        DoublyLinkedList<Student> studentDoublyLinkedList = new DoublyLinkedList<>();

        File f = new File("C:\\Users\\senan\\desktop\\students.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        String[] lineArray;

        while (line != null) {
            lineArray = line.split(" ");
            Student student = new Student(lineArray[0], lineArray[1], Integer.parseInt(lineArray[2]), Integer.parseInt(lineArray[3]));
            studentDoublyLinkedList.addToFront(student);
            line = br.readLine();
        }

        Scanner response = new Scanner(System.in);
        boolean run = true, menu = true;

        DoublyLinkedList<Student> iteratorList;

        while (run) {

            System.out.print("To see menu press any button: ");
            response.nextLine();
            System.out.println();
            System.out.println("1- To display the initial doubly linked list content press 1");
            System.out.println("2- To display the students sorted by their overall average press 2");
            System.out.println("3- To display the student names sorted by their data structure grades press 3");
            System.out.println("4- To display the math average press 4");
            System.out.println("5- To display the student(s) who has the lowest Data Structures grade press 5");
            System.out.println("6- To delete the student whose id is entered press 6");
            System.out.println("7- To insert a new student to the list press 7");
            System.out.println("8- To find and display the student count press 8");
            System.out.println("9- To display the successful students for each course press 9");
            System.out.println("q- For quit press q");
            System.out.print("Enter command: ");

            switch (response.nextLine()) {
                case "1" -> studentDoublyLinkedList.display();

                case "2" -> {
                    iteratorList = studentDoublyLinkedList;
                    iteratorList.sortList();
                    iteratorList.display();
                }

                case "3" -> {
                    iteratorList = studentDoublyLinkedList;
                    DNode<Student> newNode = iteratorList.getHead(), index;
                    Student iterator;

                    if (iteratorList.getHead() == null) {
                        System.out.println("list is empty...");
                    } else {
                        while (newNode != null) {
                            index = newNode.next;
                            while (index != null) {
                                if (newNode.value.compareByDataStr(index.value) == -1) {
                                    iterator= newNode.value;
                                    newNode.value = index.value;
                                    index.value = iterator;
                                }
                                index = index.next;
                            }
                            newNode = newNode.next;
                        }
                    }
                    iteratorList.display();
                }

                case "4" -> {
                    DNode<Student> iterator = studentDoublyLinkedList.getHead();
                    double count = 0, sum = 0;
                    while (iterator != null) {
                        sum += iterator.value.getMath();
                        count++;
                        iterator = iterator.next;
                    }
                    System.out.println("Math avg. is " + sum + "/" + count + "= " + sum/count);
                }

                case "5" -> {
                    Student min;
                    if (studentDoublyLinkedList.getHead() == null) System.out.println("List is empty.");
                    else {
                        DNode<Student> iterator = studentDoublyLinkedList.getHead();
                        min = studentDoublyLinkedList.getHead().value;
                        while (iterator != null) {
                            if (iterator.value.compareByDataStr(min) == -1) {
                                min = iterator.value;
                            }
                            iterator = iterator.next;
                        }
                        iterator = studentDoublyLinkedList.getHead();
                        while (iterator != null) {
                            if (min.compareByDataStr(iterator.value) == 0) System.out.println(iterator);
                            iterator = iterator.next;
                        }
                    }
                }

                case "6" -> {
                    System.out.printf("Enter id: ");
                    Scanner userId = new Scanner(System.in);
                    String str = userId.nextLine();
                    if (studentDoublyLinkedList.getHead().value.compareById(str) == 1) {
                        studentDoublyLinkedList.setHead(studentDoublyLinkedList.getHead().next);
                    }
                    DNode<Student> iterator = studentDoublyLinkedList.getHead(), pre;
                    while (iterator.next != null) {
                        pre = iterator;
                        iterator = iterator.next;
                        if (iterator.value.compareById(str) == 1) {
                            System.out.println(iterator + " deleted.");
                            pre.next = iterator.next;
                        }
                    }
                    System.out.println();
                }

                case "7" -> {
                    Scanner info = new Scanner(System.in);
                    System.out.println("Enter id: ");
                    String id = info.nextLine();
                    System.out.println("Enter name: ");
                    String name = info.nextLine();
                    System.out.println("Enter math grade: ");
                    String mathG = info.nextLine();
                    System.out.println("Enter data structures grade: ");
                    String dataG = info.nextLine();
                    studentDoublyLinkedList.addToFront(new Student(id, name, Integer.parseInt(mathG), Integer.parseInt(dataG)));
                }

                case "8" -> System.out.println(studentDoublyLinkedList.countElement());

                case "9" -> {
                    double mathSum = 0, dataStrSum = 0, mathAvg, dataStrAvg, count = studentDoublyLinkedList.countElement();
                    DNode<Student> iterator = studentDoublyLinkedList.getHead();
                    while (iterator != null) {
                        mathSum += iterator.value.getMath();
                        dataStrSum += iterator.value.getDataStr();
                        iterator = iterator.next;
                    }
                    mathAvg = mathSum/count;
                    dataStrAvg = dataStrSum/count;

                    System.out.println("Math avg.: " + mathAvg + " and Data Str. avg.: " +dataStrAvg);

                    iterator = studentDoublyLinkedList.getHead();
                    while (iterator != null) {
                        if (iterator.value.getDataStr()>dataStrAvg && iterator.value.getMath()>mathAvg) System.out.println(iterator);
                        iterator = iterator.next;
                    }
                }

                case "q" -> {
                    run = false;
                    System.out.println("Quiting...");
                }

                default -> System.out.println("Enter commands correctly.");
            }
            System.out.println();
        }

    }
}