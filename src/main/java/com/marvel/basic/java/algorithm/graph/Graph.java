package com.marvel.basic.java.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图
 */
public class Graph {
    //节点数量
    private int v;
    //邻接表
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    //添加边
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    //广度优先搜索
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }

        //定义数组visited，用来记录已经被访问的定点，避免定点被重复访问
        boolean[] visited = new boolean[v];
        visited[s] = true;
        //定义队列queue，用来存储已经被访问、但连接的顶点还没有被访问的顶点
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        //prev用于记录搜索路径
        int[] prev = new int[v];
        for (int i=0; i<prev.length; ++i) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            int w = queue.poll();   //获取队列的第一个元素
            for (int i=0; i<adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }

                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    boolean found = false;  //全局变量或者类成员变量
    //深度优先搜索
    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }

        for (int i=0; i<adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i=0; i<v; ++i) {
            prev[i] = -1;
        }

        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    //递归打印s->t 路径
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);

        graph.bfs(0, 6);
        System.out.println();
        graph.dfs(0, 6);
    }
}
