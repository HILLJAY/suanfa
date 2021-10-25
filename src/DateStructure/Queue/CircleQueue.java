package DateStructure.Queue;

public class CircleQueue {

    int rear;//队列尾
    int front;//队列头
    int maxSize;//数组最大容量
    int[] arr;//该数据用于存放数据，模拟队列

    public CircleQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
    }

    public boolean isFull(){

        return (rear+1) % maxSize==front;

    }

    public boolean isEmpty(){

        return rear==front;
    }

    public void addQueue(int n){

        if(isFull()){
            System.out.println("The Queue is full");
        }

        arr[rear]=n;

        rear=(rear+1)%maxSize;
    }

    public int getQueue(){

        if(isEmpty()){
            System.out.println("The Queue is empty");
        }

        int value=arr[front];

        front=(front+1)%maxSize;

        return value;
    }

    public void showQueue(){

        if(isEmpty()){
            System.out.println("The Queue is empty");
        }

        for(int i=front;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    public int size(){

        return (rear+maxSize-front)%maxSize;
    }

    public int headQueue(){

        if(isEmpty()){
            System.out.println("The Queue is empty");
        }

        return arr[front];
    }

    public static void main(String[] args) {

        CircleQueue circleQueue=new CircleQueue(4);

        circleQueue.addQueue(10);
        circleQueue.addQueue(20);
        circleQueue.addQueue(30);

        circleQueue.showQueue();

        circleQueue.getQueue();
        circleQueue.getQueue();
        circleQueue.getQueue();

        circleQueue.showQueue();

        circleQueue.addQueue(10);
        circleQueue.addQueue(20);

        circleQueue.showQueue();

    }

}
