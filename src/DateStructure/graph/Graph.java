package DateStructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    //存的节点值
    private List<String> verrexList;
    //对应的矩阵
    private int[][] edges;
    //边的个数
    private int numofEdges;
    //判断是否访问
    private boolean[] isVisited;

    public static void main(String[] args) {

        int n=5;
        Graph graph=new Graph(n);
        String[] vertexts=new String[]{"A","B","C","D","E"};
        for(String str:vertexts){

            graph.insertVertex(str);
        }

        graph.addVertex(0,1,1);
        graph.addVertex(0,2,1);
        graph.addVertex(1,2,1);
        graph.addVertex(1,3,1);
        graph.addVertex(1,4,1);

        graph.showGraph();

        //graph.dfs();
        graph.bfs();
    }
    //初始化矩阵，集合
    public Graph(int n){

        edges=new int[n][n];
        verrexList=new ArrayList<>();
        isVisited=new boolean[n];
    }
    //插入节点
    public void insertVertex(String vertex){

        verrexList.add(vertex);
    }
    //往矩阵中加入值
    public void addVertex(int v1,int v2,int weight){

        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numofEdges++;
    }
    //获取边的个数
    public int getNumOfEdges(){

        return numofEdges;

    }
    //获取节点个数
    public int getNumofVertext(){

        return verrexList.size();

    }
    //获取指定位置的值
    public String getValByIndex(int i){

        return verrexList.get(i);
    }

    //获取v1,v2的值，也就是对应矩阵中的位置的值
    public int getValOfEdges(int v1,int v2){

        return edges[v1][v2];

    }

    //显示图对应的矩阵，其实就是遍历二维数组
    public void showGraph(){

        for(int[] link:edges){

            System.out.println(Arrays.toString(link));
        }

    }
    //获取第一个邻接节点
    public int getFirstNeighbor(int index){

        for(int i=0;i<verrexList.size();i++){

            if(edges[index][i]>0){

                return i;
            }
        }
        return -1;
    }
    //如果第一个邻接节点不存在，则找下一个邻接节点
    public int getNextNeighbor(int v1,int v2){

        for(int j=v2+1;j<verrexList.size();j++){

            if(edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     * @param isVisited 判断是否访问
     * @param i 开始位置：0
     */
    public void dfs(boolean[] isVisited,int i){

        System.out.print(verrexList.get(i)+"-->");
        //将当前节点设置已访问
        isVisited[i]=true;
        //获取第一个邻接节点
        int firstNeighbor = getFirstNeighbor(i);

        while (firstNeighbor!=-1) {
            if(!isVisited[firstNeighbor]){
                dfs(isVisited,firstNeighbor);
            }

            firstNeighbor=getNextNeighbor(i,firstNeighbor);
        }
    }
    //深度优先遍历
    public void dfs(){

        for(int i=0;i<getNumofVertext();i++){

            if(!isVisited[i]){

                dfs(isVisited,i);
            }
        }
    }

    public void bfs(boolean[] isVisited,int i){
        //表示队列的头结点对应下标
        int u;
        //邻接节点w
        int w;
        //队列，记录节点访问的顺序
        LinkedList queue=new LinkedList();
        //访问节点，输出节点信息
        System.out.print(getValByIndex(i)+"==>");
        //标记为已访问
        isVisited[i]=true;
        //将节点加入队列
        queue.addLast(i);

        while(!queue.isEmpty()){
            //取出队列的头结点下标
            u = (int) queue.removeFirst();
            //得到第一个邻接结点的下标w
            w=getFirstNeighbor(u);
            while(w!=-1){

                if(!isVisited[i]){
                    System.out.print(getValByIndex(w)+"==>");
                    //标记为已访问
                    isVisited[w]=true;
                    //入队
                    queue.addLast(w);
                }

                w=getNextNeighbor(u,w);
            }
        }
    }

    public void bfs(){

        for(int i=0;i<getNumofVertext();i++){

            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }
}
