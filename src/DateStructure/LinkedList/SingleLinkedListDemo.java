package DateStructure.LinkedList;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {

        HeroNode heroNode1=new HeroNode(1,"tt","boy");
        HeroNode heroNode2=new HeroNode(5,"卢俊义","玉麒麟");
        HeroNode heroNode3=new HeroNode(2,"无用","智多星");
        HeroNode heroNode4=new HeroNode(4,"林冲","豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);

//        singleLinkedList.update(new HeroNode(2,"gyh","hilljay"));
//
//        singleLinkedList.delete(6);
//        //显示
//        singleLinkedList.list();

        singleLinkedList.reserveNode(singleLinkedList.getHead());

    }

}

//定义一个SinglelinkedList管理英雄
class SingleLinkedList{

    //先初始化一个头节点，头节点一般不要动,不存在具体的数据
    private HeroNode head=new HeroNode(0,"","");
    //添加节点到单向链表
    //思路：当不考虑编号的顺序时，
    //1.找到当前链表的最后节点
    //将最后合格节点的next只想新的几点


    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode){
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp=head;

        while(true){

            if(temp.next==null){
                break;
            }

            temp=temp.next;

        }
        //当退出这个while循环时，temp指向链表的最后
        //将最后的节点的next,指向新的节点
        temp.next=heroNode;
    }

    //第二种添加英雄的方式,添加到指定位置
    public void addByOrder(HeroNode heroNode){

        //因为头节点不能动，因此我们仍然通过一个辅助变量来帮助找到添加的位置
        //因为单链表，因此我们找的temp是位于添加位置的前一个节点，否则加入不了
        HeroNode temp=head;
        boolean flag=false;//标识添加的编号是否存在，默认为false

        while(true){
            if(temp.next==null){//说明temp已经在链表的最后
                break;//
            }

            if(temp.next.no>heroNode.no){//位置找到了就在temp的后面添加

                break;

            }else if(temp.next.no==heroNode.no){//说明希望添加的heroNode编号已经存在

                flag=true;
                break;
            }

            temp=temp.next;//将temp后移
        }

        if(flag){
            System.out.println("编号已经存在");
        }else {
            heroNode.next=temp.next;
            temp.next=heroNode;
        }

    }

    /**
     * 修改信息，在no不变的情况下修改信息
     * @param heroNode
     */
    public void update(HeroNode heroNode){

        HeroNode temp=head.next;
        boolean flag=false;

        if(temp==null){
            System.out.println("列表为空");
        }

        while(true){

            if(temp.next==null){
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

    /**
     * 链表删除
     * @param no
     */
    public void delete(int no){

        HeroNode temp=head;
        boolean flag=false;

        while(true){

            if(temp.next==null){
                break;
            }

            if(temp.next.no==no){

                flag=true;
                break;

            }
            temp=temp.next;
        }

        if(flag){
            temp.next=temp.next.next;
        }else {
            System.out.printf("编号为%d的节点不存在",no);
        }

    }


    //显示链表[遍历]
    public void list(){

        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量遍历
        HeroNode temp=head.next;
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

    //获取倒数第n个节点的数据
    public HeroNode getLastIndex(HeroNode hn,int index){

        if(hn.next==null){
            return null;
        }

        HeroNode temp=head.next;

        int length = getLength(hn);

        if(index<0||index>length){
            return null;
        }

        for(int i=0;i<length-index;i++){
            temp=temp.next;
        }
        return temp;
    }

    //获取单链表的节点个数（头节点不统计）
    public int getLength(HeroNode head){

        if(head.next==null){
            return 0;
        }

        int length=0;
        HeroNode temp=head.next;

        while(true){

            if(temp.next==null){
                return length;
            }else {
                length++;
            }

            temp=temp.next;
        }
    }

    //将单链表进行反转
    public void reverseList(HeroNode head){

        if(head.next==null||head.next.next==null){
            return;
        }

        HeroNode reserveHead=new HeroNode(0,"","");
        HeroNode cur=reserveHead.next;
        HeroNode next=null;

        while(cur!=null){
            next=cur.next;
            cur.next=reserveHead.next;
            reserveHead.next=cur;
            cur=next;
        }
        head.next=reserveHead.next;
    }

    //倒叙输出链表的节点，不改变链表的结构
    public void reserveNode(HeroNode head){

        if(head.next==null){
            return;
        }

        Stack<HeroNode> stack=new Stack<HeroNode>();

        HeroNode cur=head.next;

        while(cur!=null){
            stack.push(cur);
            cur=cur.next;
        }

        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}

//定义一个HeroNode,每个HeroNode对象就是一个节点
class HeroNode{

    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
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
