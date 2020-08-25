package org.fj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Vertex {
    private int label;
    private boolean isVisited;

    public Vertex(char label) {
        this.label = label;
        this.isVisited = false;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}

public class Graph {
    private final int maxNodes = 20;
    private Vertex vertexList[];//顶点
    private int adjMat[][];//邻接矩阵
    private int nVerts;//当前顶点数目

    public Graph() {
        //初始化顶点数组
        vertexList = new Vertex[maxNodes];
        //初始化邻接矩阵
        adjMat = new int[maxNodes][maxNodes];
        for (int i = 0; i < maxNodes; i++) {
            for (int j = 0; j < maxNodes; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    /**
     * 添加顶点
     *
     * @param label
     */
    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    /**
     * 添加边
     *
     * @param start
     * @param end
     */
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }


    /**
     * 查找某个未访问过的顶点
     *
     * @param vertIndex 顶点序号
     * @return
     */
    public int getUnVisited(int vertIndex) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[vertIndex][i] == 1 && vertexList[i].isVisited() == false) {
                return i;
            }
        }

        return -1;
    }


    private Stack<Integer> stack = new Stack<>();

    /**
     * 深度遍历
     */
    public void dfs() {
        vertexList[0].setVisited(true);
        stack.push(0);

        while (!stack.isEmpty()) {
            //查看栈顶元素有没有未访问的邻接点
            int nextIndex = getUnVisited(stack.peek());
            if (nextIndex > 0) {
                //有则加入栈
                vertexList[nextIndex].setVisited(true);
                System.out.println(vertexList[nextIndex].getLabel());
                stack.push(nextIndex);
            } else {
                //无则弹出
                stack.pop();
            }
        }
    }

    public void mst() {
        while (!stack.isEmpty()) {
            //查看栈顶元素有没有未访问的邻接点
            int currentIndex = stack.peek();
            int nextIndex = getUnVisited(currentIndex);
            if (nextIndex > 0) {
                //有则加入栈
                vertexList[nextIndex].setVisited(true);
                System.out.println(vertexList[nextIndex].getLabel());
                stack.push(nextIndex);

                System.out.println(currentIndex);
                System.out.println(nextIndex);
            } else {
                //无则弹出
                stack.pop();
            }
        }
    }

    private Queue<Integer> queue = new LinkedList<>();

    /**
     * 广度遍历
     */
    public void bfs() {
        vertexList[0].setVisited(true);
        System.out.println(vertexList[0].getLabel());

        while (!stack.isEmpty()) {

            Integer currnetElement = queue.remove();
            int nextIndex = -1;

            //加入所有的邻接点
            while ((nextIndex = getUnVisited(currnetElement)) > -1) {
                vertexList[nextIndex].setVisited(true);
                System.out.println(vertexList[nextIndex].getLabel());
                queue.add(nextIndex);
            }
        }
    }

    /**
     * 查找没有后继的节点
     *
     * @return
     */
    public int findNoSuccessor() {
        //查找二维数组，如果某一行都是0，则表明该行对应的节点没有后继节点
        for (int i = 0; i < nVerts; i++) {
            boolean haveSuccessor = false;
            for (int j = 0; j < nVerts; j++) {
                if (adjMat[i][j] == 1) {
                    haveSuccessor = true;
                    break;
                }
            }
            if (!haveSuccessor) {
                return i;
            }
        }
        return -1;
    }

    public void topo() {


        int num = nVerts;
        Integer[] result = new Integer[num];

        while (nVerts > 0) {
            int indexWithNoSucessor = findNoSuccessor();
            if (indexWithNoSucessor == -1) {
                System.out.println("有环！");
                return;
            }

            //放到最后一个
            result[nVerts-1] = vertexList[indexWithNoSucessor].getLabel();
            //删除一个节点。顶点从vertexList中删除，后面的顶点向前移动填补空位，顶点的行列从邻接矩阵中删除

        }
    }
}
