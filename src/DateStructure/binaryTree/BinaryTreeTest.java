package DateStructure.binaryTree;

public class BinaryTreeTest {

    public static void main(String[] args) {

        BinaryTree binaryTree=new BinaryTree();

        Hero root = new Hero("hillhay", 1);
        binaryTree.setRoot(root);

        Hero node1 = new Hero("json", 2);
        Hero node2 = new Hero("jack", 3);
        Hero node3 = new Hero("bill", 4);
        Hero node4 = new Hero("hill", 5);

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);

        binaryTree.preOrder();

        binaryTree.delNode(2);

        System.out.println();

        binaryTree.preOrder();

    }

}

class BinaryTree{

    private Hero root;

    public void setRoot(Hero root) {
        this.root = root;
    }

    public void preOrder(){

        if(root!=null){
            root.preOrder();
        }else{
            System.out.println("根节点不存在");
        }

    }

    public void infixOrder(){

        if(root!=null){
            root.infixOrder();
        }else {
            System.out.println("根节点不存在");
        }

    }

    public void postOrder(){

        if(root!=null){
            root.postOrder();
        }else {
            System.out.println("根节点不存在");
        }

    }

    //查询方法
    public Hero preOrderSearch(int no){

        if(root!=null){
            return root.preOrderSearch(no);
        }else {
            return null;
        }

    }

    public Hero infixOrderSearch(int no){

        if(root!=null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }

    }

    public Hero postOrderSearch(int no){

        if(root!=null){
            return root.postOrderSearch(no);
        }else{
            return null;
        }

    }

    public void delNode(int no){

        if(root!=null){

            if(root.getNo()==no){
                root=null;
            }else {
                root.delNode(no);
            }

        }else {
            System.out.println("the tree is empty");
        }

    }

}

class Hero{

    private String name ;
    private int no;
    private Hero left;
    private Hero right;

    public Hero(String name, int no) {
        this.name = name;
        this.no = no;
    }

    public Hero() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Hero getLeft() {
        return left;
    }

    public void setLeft(Hero left) {
        this.left = left;
    }

    public Hero getRight() {
        return right;
    }

    public void setRight(Hero right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }

    public void preOrder(){

        System.out.println(this);

        if(this.left!=null){
            this.left.preOrder();
        }

        if(this.right!=null){
            this.right.preOrder();
        }

    }

    public void infixOrder(){

        if(this.left!=null){
            this.left.preOrder();
        }

        System.out.println(this);

        if(this.right!=null){
            this.right.preOrder();
        }

    }

    public void postOrder(){

        if(this.left!=null){
            this.left.preOrder();
        }

        if(this.right!=null){
            this.right.preOrder();
        }

        System.out.println(this);

    }

    //查找的方法
    public Hero preOrderSearch(int no){

        Hero result=null;

        if(this.no==no){
            return this;
        }

        if(this.left!=null){
            result=this.left.preOrderSearch(no);
        }

        if(result!=null){
            return result;
        }

        if(this.right!=null){
            result=this.right.preOrderSearch(no);
        }

        return result;
    }

    public Hero infixOrderSearch(int no){

        Hero result=null;

        if(this.left!=null){
            result=this.left.infixOrderSearch(no);
        }

        if(result!=null){
            return result;
        }

        if(this.no==no){
            return this;
        }

        if(this.right!=null){
            result=this.right.infixOrderSearch(no);
        }

        return result;
    }

    public Hero postOrderSearch(int no){

        Hero result=null;

        if(this.left!=null){
            result=this.left.postOrderSearch(no);
        }

        if(result!=null){
            return result;
        }

        if(this.right!=null){
            result=this.right.postOrderSearch(no);
        }

        if(this.no==no){
            return this;
        }

        return result;
    }

    //删除节点
    public void delNode(int no){

        if(this.left!=null&&this.left.no==no){
            this.left=null;
            return;
        }

        if(this.right!=null&&this.right.no==no){
            this.right=null;
            return;
        }

        if(this.left!=null){

            this.left.delNode(no);
        }

        if(this.right!=null){

            this.right.delNode(no);
        }

    }
}