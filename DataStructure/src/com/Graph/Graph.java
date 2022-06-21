package com.Graph;

import java.util.ArrayList;
import java.util.List;

class Graph {
    public List<String> vertexList = new ArrayList<>();
    public int[][] edges;
    public int numOfEdges = 0;
    public boolean[] isVisited;

    public Graph(int[][] edges) {
        this.edges = edges;
    }

    public void insertVertex(String s){
        vertexList.add(s);
    }

    public void insertEdges(int v1, int v2, int weight){
        edges[v1][v2] = weight;
    }

    public void dfs(boolean[] isVisited, int i){
        System.out.println(vertexList.get(i));
        isVisited[i] = true;
        int Next = getFirstNeighbor(i);
        while (Next != -1){
            if(!isVisited[Next]){
                dfs(isVisited, Next);
            }
            Next = getNextNeighbor(Next, i);
        }
    }

    public void dfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            dfs(isVisited, i);
        }
    }

    public void bfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            bfs(isVisited, i);
        }
    }

    public void bfs(boolean[] isVisited, int i){
        System.out.println(i);
        isVisited[i] = true;
        int next = getFirstNeighbor(i);
        while (next != -1){
            if(!isVisited[next]){
                bfs(isVisited, next);
            }
            next = getNextNeighbor(i, next);
        }
    }


    public int getFirstNeighbor(int now){
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[now][j] != 0){
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int now, int next){
        for (int j = next + 1; j < vertexList.size(); j++) {
            if(edges[now][j] != 0){
                return j;
            }
        }
        return -1;
    }
}


