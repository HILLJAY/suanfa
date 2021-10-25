package DateStructure.stack;


import java.util.ArrayList;
import java.util.List;

public class LinkedStack {

    private int maxSize;
    private int top;
    private List<Car> cars;
    private Car head;

    public LinkedStack(int maxSize) {
        this.maxSize = maxSize;
        top=-1;
        cars=new ArrayList<>(maxSize);
        head=new Car(0);

    }

    public LinkedStack() {
    }

    public boolean isEmpty(){

        return top==-1;
    }

    public boolean isFull(){

        return top==maxSize-1;
    }

    public void push(Car car){

        if(isFull()){
            return;
        }

        Car temp=head;
        while (temp.getNext()!=null){
            temp=temp.getNext();
        }

        temp.setNext(car);

        cars.add(++top,car);
    }

    public Car pop(){

        if (isEmpty()){
            return null;
        }

        Car car = cars.get(--top);
        car.setNext(null);

        return car;

    }

    public void list(){

        if(isEmpty()){
            return;
        }

        for(int i=top;i>=0;i--){
            System.out.println(cars.get(i));
        }
    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack(5);

        linkedStack.push(new Car(2));
        linkedStack.push(new Car(3));

        linkedStack.pop();

        linkedStack.list();
    }

}

class Car{

    private int no;
    private Car next;

    public Car() {
    }

    public Car(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Car getNext() {
        return next;
    }

    public void setNext(Car next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Car{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }
}