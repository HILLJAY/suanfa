package DateStructure.binaryTree.binaryTreeSort;

public class BinaryTreeNodeDemo {

    public static void main(String[] args) {

        int[] arr=new int[]{7,3,10,12,5,1,9,0};
        BinaryTree binaryTree=new BinaryTree();
        for(int i=0;i< arr.length;i++){

            binaryTree.addNode(new Node(arr[i]));
        }

        binaryTree.infixOrdered();

        binaryTree.delNode(1);
        System.out.println();

        binaryTree.infixOrdered();
    }

}

class BinaryTree{

    private Node root;

    public void addNode(Node node){

        if(root==null){
            root=node;
        }

        root.addNode(node);
    }

    public void infixOrdered(){

        if(root==null){
            return;
        }

        root.infixOrdered();

    }

    public Node search(int val){

        if(root==null)
            return null;

        return root.searchNode(val);
    }

    public Node searchParent(int val){

        if(root==null)
            return null;

        return root.searchParent(val);
    }

    /**
     * 返回的以node为根节点的二叉排序树的最小节点的值
     * 删除node为根节点的二叉排序树的最小节点
     * @param node
     * @return
     */
    public int delRightTreeNode(Node node){

        Node target=node;
        while(target.left!=null){
            target=target.left;
        }

        delNode(target.val);
        return target.val;
    }

    public void delNode(int val){

        if(root==null){
            return;
        }
        Node targetNode = search(val);
        if(targetNode==null){
            return;
        }else {

            if(root.left==null&&root.right==null){
                return;
            }

            Node parentNode = searchParent(val);
            //第一种情况，删除叶子节点
            if(targetNode.left==null&&targetNode.right==null){

                if(parentNode.left!=null&&parentNode.left.val== targetNode.val){
                    parentNode.left=null;
                }else if(parentNode.right!=null&&parentNode.right.val== targetNode.val){
                    parentNode.right=null;
                }

                //2.删除有两个节点的子树
            }else if(targetNode.left!=null&&targetNode.right!=null){

                int minVal = delRightTreeNode(targetNode.right);
                targetNode.val=minVal;

            }else {
                //3.删除有一个节点的子数
                if(parentNode.left.val==targetNode.val){
                    if(targetNode.left!=null){
                        parentNode.left=targetNode.left;
                    }else {
                        parentNode.left=targetNode.right;
                    }
                }else {
                    if(targetNode.left!=null){
                        parentNode.right=targetNode.left;
                    }else {
                        parentNode.right=targetNode.right;
                    }
                }
            }
        }
    }
}

class Node{

    int val;
    Node left;
    Node right;

    public  Node(int val){
        this.val=val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    /**
     * 查找需要删除的节点位置
     * @param val
     * @return
     */
    public Node searchNode(int val){

        if(this.val==val){
            return this;
        }else if(val<this.val){

            if(this.left==null){
                return null;
            }
            return this.left.searchNode(val);
        }else {

            if(this.right==null){
                return null;
            }
            return this.right.searchNode(val);
        }
    }

    /**
     * 找父节点
     * @param val
     * @return
     */
    public Node searchParent(int val){

        if(this.left!=null&&this.left.val==val||this.right!=null&&this.right.val==val){
            return this;
        }

        if(val<this.val){
            return this.left.searchParent(val);
        }else if(val>this.val){
            return this.right.searchParent(val);
        }else {
            return null;
        }
    }

    public void addNode(Node node){

        if(node==null)
            return;

        if(node.val<this.val){

            if(this.left==null){
                this.left=node;
            }else {
                this.left.addNode(node);
            }
        }else {

            if(node.val>this.val){

                if(this.right==null){
                    this.right=node;
                }else {
                    this.right.addNode(node);
                }
            }
        }

    }

    public void infixOrdered(){

        if(this.left!=null){
            this.left.infixOrdered();
        }

        System.out.println(this);

        if(this.right!=null){
            this.right.infixOrdered();
        }
    }
}
