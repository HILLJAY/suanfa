package DateStructure.Queue;

public class Queque {

    int rear;
    int front;

    int maxPoint;
    int[] arr;

    public Queque(int maxPoint) {
        this.maxPoint = maxPoint;
        arr=new int[maxPoint];
        front=-1;
        rear=-1;
    }

    public void addQueArr(int i){

        if(rear<maxPoint-1){
            arr[++rear]=i;
        }else {
            System.out.println("The queue is already full");
        }

    }

    public int getQueArr(){

        if(front==rear){
            System.out.println("The queue is empty");
        }else{
            return arr[++front];
        }
        return 0;
    }

    public void listArr(){

        for(int i=0;i<arr.length;i++){
            System.out.println(i+":"+arr[i]);
        }
    }

    public static void main(String[] args) {

        Queque queque=new Queque(5);

        queque.addQueArr(1);
        queque.addQueArr(2);

        int queArr = queque.getQueArr();
        System.out.println(queArr);
        queque.listArr();

        System.out.println(queque.front+":...."+queque.rear);
    }
}


