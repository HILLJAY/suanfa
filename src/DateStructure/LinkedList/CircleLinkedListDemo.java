package DateStructure.LinkedList;

/**
 * 使用环形链表解决约瑟夫问题
 */
public class CircleLinkedListDemo {

    public static void main(String[] args) {

        CircleLinked circleLinked=new CircleLinked();

        circleLinked.addBoy(5);

        try {
            circleLinked.listLinkedList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        circleLinked.countBoy(1,2,5);
    }

}

class CircleLinked{

    //创建一个first节点
    private Boy first;
    //添加小孩节点，构建出环形链表
    public void addBoy(int nums){

        if(nums<1){
            return;
        }

        Boy curBoy=null;//辅助变量
        for(int i=1;i<=nums;i++){

            Boy boy=new Boy(i);

            if(i==1){
                first=boy;
                first.setNext(first);
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                curBoy=boy;
                boy.setNext(first);
            }
        }
    }

    public void listLinkedList() throws Exception {

        //判断链表是否为空
        if(first==null){
            throw new Exception("链表为空");
        }

        //因为first不能动，我们仍然使用辅助节点完成遍历
        Boy curBoy=first;

        while(true){
            System.out.printf("小孩的编号wei%d\n",curBoy.getNo());
            if(curBoy.getNext()==first){
                break;
            }
            //curBoy 后移
            curBoy=curBoy.getNext();
        }
    }

    /**
     *
     * startNo表示第几个小孩开始数数
     * countNo表示数几下
     * nums表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo,int countNo,int nums){

        //先对数据进行校验
        if(first==null||startNo<1||startNo>nums){
            throw new NullPointerException("找不到节点");
        }

        //创建一个辅助指针，帮助完成小孩出圈,首先定义到结尾
        Boy helper=first;
        while(true){
            if(helper.getNext()==first){
                break;
            }
            helper=helper.getNext();
        }

        //通过startNo,将first,helper节点移动startNo-1次，相对于startNo处于第一个和最后一个位置
        for(int j=0;j<startNo-1;j++){
            first=first.getNext();
            helper=helper.getNext();
        }

        while(true){
            if(first==helper){
                break;
            }

            for(int i=0;i<countNo-1;i++){
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.printf("此时要出圈的编号为%d\n",first.getNo());

            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后圈中的编号为%d\n",first.getNo());
    }
}

class Boy{

    private int no;
    private Boy next;

    public Boy(int no){
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }


    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }
}