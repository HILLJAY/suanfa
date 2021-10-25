package DateStructure.hash;

/**
 * 哈希表
 */
public class HashTableMain {

    public static void main(String[] args) {

        HashTable hashTable=new HashTable(8);

        Employee ggy = new Employee(1, "ggy");
        hashTable.add(ggy);
        hashTable.add(new Employee(111,"222"));
        hashTable.add(new Employee(5,"ggh"));

        hashTable.update(new Employee(1,"qtr"));

        hashTable.list();

    }

}

class HashTable{
    int size;

    LinkedHashTable[] hashTable;

    public HashTable(int size){
        this.size=size;

        hashTable=new LinkedHashTable[size];

        for(int i=0;i<size;i++){
            hashTable[i]=new LinkedHashTable();
        }
    }

    public int getInt(int no){

        return no%size;
    }

    public void add(Employee employee){

        int result = getInt(employee.getNo());
        hashTable[result].add(employee);

    }

    public void delete(Employee employee){

        int result = getInt(employee.getNo());

        hashTable[result].delete(employee);

    }

    public void list(){

        for(int i=0;i<hashTable.length;i++){
           hashTable[i].list(i);
        }

    }

    public void update(Employee employee){

        int result = getInt(employee.getNo());

        hashTable[result].update(employee);

    }

}

class LinkedHashTable{

    Employee head;
    Employee curEmp;

    public void add(Employee employee){

        if(head==null){
            head=employee;
            return;
        }

        curEmp=head;

        while(true){

            if(curEmp.getNext()==null){
                curEmp.setNext(employee);
                break;
            }

            curEmp=curEmp.getNext();

        }

    }

    public void delete(Employee employee){

        if(head!=null){
            curEmp=head;
        }

        while(curEmp!=null){

            if(curEmp.getNext().getNo()==employee.getNo()){
                curEmp.setNext(curEmp.getNext().getNext());
                break;
            }

            curEmp=curEmp.getNext();

        }

    }

    public void list(int i){

        if(head!=null){
            curEmp=head;
        }else{
            System.out.println("链表为空");
            return;
        }

        while(true){

            System.out.print("==>"+curEmp.getNo()+" "+curEmp.getName());

            if(curEmp.getNext()==null){
                break;
            }

            curEmp=curEmp.getNext();

        }

        System.out.println();

    }

    public void update(Employee employee){

        if(head!=null){
            curEmp=head;
        }

        while(curEmp!=null){

            if(curEmp.getNo()==employee.getNo()){
                curEmp.setName(employee.getName());
                break;
            }

            curEmp=curEmp.getNext();

        }

    }
}

class Employee{

    private int no;
    private String name;
    private Employee next;

    public Employee() {
    }

    public Employee(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getNext() {
        return next;
    }

    public void setNext(Employee next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}
