import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {
    public static Stack copyStack(Stack stk){
        Stack newStack= new Stack(stk.size());
        Stack temp = new Stack(stk.size());
        while(!stk.isEmpty()){
            temp.push(stk.pop());
        }
        while(!temp.isEmpty()){
            int popped=temp.pop();
            newStack.push(popped);
            stk.push(popped);
        }
        return newStack;
    }

    public static boolean isBalanced(String[] prn){
        GenericStack<String> myStk = new GenericStack<>(String.class, prn.length/2);
        if (prn.length%2 ==1)
            return false;
        for (int i = 0; i <prn.length ; i++){
            if(prn[i]=="(" || prn[i]=="["){
                myStk.push(prn[i]);
            }
            else if(myStk.isEmpty()){
                return false;
            }
            else if (prn[i]=="]"){
                if(myStk.pop()!="["){
                    return false;
                }
            }
            else if (prn[i]==")") {
                if (myStk.pop() != "(") {
                    return false;
                }
            }
        }
        if(myStk.isEmpty())
            return true;

        return false;
    }



    public static void main(String[] args) {
//        Car car1=new Car("Toyota","corolla",110);
//        Car car2=new Car("Honda","Cvic",120);
//        Car car3=new Car("Honda","Accord",140);
//        Car car4=new Car("Porche","panamera",220);
//        LinkedList<Car> cars= new LinkedList();
//        cars.addToEnd(car1);
//        cars.addToEnd(car2);
//        cars.addToEnd(car3);
//        cars.addToEnd(car4);
//        cars.sort();
//        cars.display();
//        System.out.println(cars.findMax());
//        Student st1=new Student("2156","Sena",60,100);
//        Student st2=new Student("2101","Senh",80,50);
//        Student st3=new Student("2134","bena",90,20);
//        Student st4=new Student("2137","Sarena",20,65);
//        DoublyLinkedList<Student> stu = new DoublyLinkedList();
//        stu.addToFront(st1);
//        stu.addToFront(st2);
//        stu.addToFront(st3);
//        stu.addToFront(st4);
//        stu.display();

//        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//        bst.insert(25);
//        bst.insert(35);
 //       bst.insert(5);
 //       bst.insert(10);
 //       bst.insert(12);
 //       bst.insert(4);
 //       bst.insert(8);
 //       bst.insert(26);
 //       bst.insert(22);
//        bst.inorder();
 //       bst.preorder();
 //       bst.postorder();
//        System.out.println(bst.searchRecursively(5));


        Graph<Integer> graf = new Graph();
        graf.addVertex("1");
        graf.addVertex("2");
        graf.addVertex("3");
        graf.addVertex("4");
        graf.addVertex("5");
        graf.addEdge("2","5",1);
        graf.addEdge("1","3",1);
        graf.addEdge("4","5",1);
        graf.addEdge("3","4",1);
        graf.addEdge("2","3",1);

        graf.display2();
        graf.findNeighbors("2");




    }
}

