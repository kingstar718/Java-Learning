package top.wujinxing.ch_5_questions.CrackingTheCodingInterview;

import java.util.*;

/**
 * @author wujinxing
 * date 2019 2019/8/18 21:41
 * description 有向路径检查
 *
 * 对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。
 *
 * 给定图中的两个结点的指针DirectedGraphNode* a, DirectedGraphNode* b(请不要在意数据类型，图是有向图),
 * 请返回一个bool，代表两点之间是否存在一条路径(a到b或b到a)。
 */
public class ch_4_2_Map_checkPath {

    Map<UndirectedGraphNode, Boolean> visitedMap = new HashMap<>();

    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        String method = "BFS";

        switch (method){
            case "DFS":
                if (checkDFS(a, b)){
                    return true;
                }else {
                    visitedMap.clear();
                    return checkDFS(b, a);
                }
            case "BFS":
                return checkBFS(a, b) || checkBFS(b, a);

            default:
                //错误的选择
                return false;
        }
    }

    private boolean checkDFS(UndirectedGraphNode a, UndirectedGraphNode b){
        if (a==null || b==null){
            return false;
        }
        if (a==b){
            return true;
        }
        visitedMap.put(a, true);

        for (UndirectedGraphNode neighbor: a.neighbors){
            if (!visitedMap.containsKey(neighbor) && checkDFS(neighbor, b)){
                return true;
            }
        }
        return false;
    }

    private boolean checkBFS(UndirectedGraphNode a, UndirectedGraphNode b){
        if (a==null || b==null){
            return false;
        }
        if (a==b){
            return true;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        //用来标记是否访问过该节点
        HashMap<UndirectedGraphNode, Boolean> visitedMap = new HashMap<>();
        visitedMap.put(a, true);
        queue.offer(a);
        while (!queue.isEmpty()){
            UndirectedGraphNode node  = queue.poll();//从队列头部移除
            for (UndirectedGraphNode neighbor: node.neighbors){
                if (!visitedMap.containsKey(neighbor)){//如果没访问过
                    if (neighbor==b){
                        return true;
                    }
                    visitedMap.put(neighbor, true);

                    queue.offer(neighbor);
                }
            }
        }
        return false;
    }


    static class UndirectedGraphNode {
        int label = 0;
        UndirectedGraphNode left = null;
        UndirectedGraphNode right = null;
        ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

        public UndirectedGraphNode(int label) {
            this.label = label;
        }
    }
}
