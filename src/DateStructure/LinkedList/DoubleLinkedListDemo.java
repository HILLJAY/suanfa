package DateStructure.LinkedList;

/**
 * 双向链表
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        System.out.println("双向链表的测试");

        HeroNode2 heroNode1=new HeroNode2(1,"tt","boy");
        HeroNode2 heroNode2=new HeroNode2(5,"卢俊义","玉麒麟");
        HeroNode2 heroNode3=new HeroNode2(2,"无用","智多星");
        HeroNode2 heroNode4=new HeroNode2(4,"林冲","豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);

        doubleLinkedList.list();
        System.out.println();
        //修改
        HeroNode2 heroNode5=new HeroNode2(4,"gyh","hilljay");
        doubleLinkedList.update(heroNode5);

        doubleLinkedList.list();

        System.out.println();

        doubleLinkedList.delete(4);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList{

    private HeroNode2 head=new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表的方法
    public void list(){

        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量遍历
        HeroNode2 temp=head.next;
        while(true){
            //判断是否到链表最后
            if(temp==null){
                break;
            }

            //输出节点信息
            System.out.println(temp);
            //将temp后移
            temp=temp.next;
        }
    }

    //默认添加到双向链表的最后
    public void add(HeroNode2 heroNode){
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode2 temp=head;

        while(true){

            if(temp.next==null){
                break;
            }

            temp=temp.next;

        }
        //当退出这个while循环时，temp指向链表的最后
        //将最后的节点的next,指向新的节点,形成一个双向链表
        temp.next=heroNode;
        heroNode.pre=temp;
    }

    //修改双向链表的一个节点,可以看到双向链表的节点修改和单向链表类似
    public void update(HeroNode2 heroNode){

        HeroNode2 temp=head.next;
        boolean flag=false;

        if(temp==null){
            System.out.println("列表为空");
        }
        while(true){

            assert temp != null;
            if(temp==null){
                break;
            }
            if(temp.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }

        if(flag){
            temp.name=heroNode.name;
            temp.nickName= heroNode.nickName;
        }else {
            System.out.printf("找不到编号为%d的信息\n",heroNode.no);
        }
    }

    //从双向链表中删除一个节点
    public void delete(int no) {

        HeroNode2 temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {//已经找到链表的最后
                break;
            }
            if (temp.no == no) {

                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.pre.next=temp.next;
            //如果是最后一个节点，则不需要执行下列代码，否则会出现空指针
            if (temp.next!=null) {
                temp.next.pre= temp.pre;
            }
        } else {
            System.out.printf("编号为%d的节点不存在", no);
        }
    }
}

class HeroNode2{

    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;//指向前一个节点，默认为null

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //为了显示方便，重写一下toString();

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

