public class StackOperations {

    public static Stack removemin(Stack stky){
        Stack tmpStack = new Stack(stky.size());
        int min = tmpStack.pop();
        for (int i = tmpStack.peek(); i >=0 ;i++){


            if(i < min) {

                min = tmpStack.peek();
                tmpStack.pop();

                System.out.println(min);
            }


        }
            while(!tmpStack.isEmpty() && stky.peek() != min){
                stky.push(tmpStack.pop());
            }


        return stky;

            // i tried a lot thats why i couldnt delete this part of the code. thats not working sorry.
    }


    public static Stack sortStack(Stack stack) {

        Stack tempStack = new Stack(stack.size());
        while(!stack.isEmpty())
        {
            int inthetop=stack.pop();
            while(!tempStack.isEmpty() && tempStack.peek() > inthetop) {
                stack.push(tempStack.pop());
            }
            tempStack.push(inthetop);
        }
        return tempStack;
    }

    public static void main(String[] args){
        Stack sortedstack = new Stack(10);
        sortedstack.push(12);
        sortedstack.push(16);
        sortedstack.push(25);
        sortedstack.push(2);
        sortedstack.push(35);
        sortedstack.push(13);
        sortedstack.push(20);
        sortedstack.push(1);
        sortedstack.push(9);
        sortedstack.push(5);
        StackOperations.sortStack(sortedstack).display();
       // Stack tmpStack = new Stack(10);
       // tmpStack.push(12);
       // tmpStack.push(16);
       // tmpStack.push(25);
      //  tmpStack.push(2);
       // tmpStack.push(35);
       // tmpStack.push(13);
       // tmpStack.push(20);
       // tmpStack.push(1);
      //  tmpStack.push(9);
       // tmpStack.push(5);


    }

}

