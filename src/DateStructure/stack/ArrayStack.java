package DateStructure.stack;

public class ArrayStack {

    private int maxSize;
    private int top=-1;
    private int[] stack;

    public ArrayStack(int maxSize){
        this.maxSize=maxSize;
        stack=new int[maxSize];
    }

    public boolean isFull(){

        return top==maxSize-1;
    }

    public boolean isEmpty(){

        return top==-1;
    }

    public void push(int value) throws Exception {

        if(isFull()){
            throw new Exception("栈已满");
        }

        stack[++top]=value;
    }

    public int pop() throws Exception {

        if(isEmpty()){
            throw new Exception("栈为空");
        }

        return stack[top--];
    }

    public void list() throws Exception {

        if(isEmpty()){
            throw new Exception("栈为空");
        }

        for(int i=top;i>=0;i--){
            System.out.println(stack[i]);
        }
    }


}

class Test{

    public static void main(String[] args) {
        ArrayStack arrayStack=new ArrayStack(5);

        try {
            arrayStack.push(1);
            arrayStack.push(2);
            arrayStack.push(3);
            arrayStack.push(4);
            arrayStack.push(5);

            System.out.println(".....>:"+arrayStack.pop());

            arrayStack.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
