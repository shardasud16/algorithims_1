package com.sid.algo.week1.unionfind;

/**
 * To improve the performance issue as discussed
 * in {@link QuickFindUF} where we has O(n) as time
 * complexity of an operation we optimized our code.
 * Now wth following approach where are not looping the
 * entire Array. We have now converted this array like a
 * tree. Each index hold index of its parent. So for this algo
 * time complexity is log(n) i.e. height of the tree. This
 * is a significant improvement as compared to {@link QuickFindUF}
 * But there is still some issue. As we just simple move first input
 * under the second, there can be a scenario we have long tree and thus
 * in that worst case scenario we will again have O(n) performance.
 *
 * so we need to optimize this code further.
 *
 *  Ind: 0 1 2 3 4  5 6 7 8  9 10
 *  Val: 0 1 2 2 6 10 6 7 8 10 10
 *
 *  0  1    2   3    6  7  8   10
 *         /        /          / \
 *        3        4          5  9
 *
 * @author Sudhanshoo Sharda
 * @date January 19th 2021
 */
public class QuickUnionUF {

    int [] id;

    public QuickUnionUF(int n){

        id = new int[n];

        for(int i = 0; i < id.length; i++)
            id[i] = i;

    }

    public int getRoot(int i){
        while(i != id[i]) i = id[i];
        return i;

    }

    public boolean isConnected(int p, int q){
        return getRoot(p) == getRoot(q);
    }

    public void union(int p, int q){
        int pId = getRoot(p);
        int qId = getRoot(q);
        id[pId] = qId;

    }

    public static void main(String[] args) {
        QuickUnionUF qU = new QuickUnionUF(11);
        qU.union(1,2);
        qU.union(4,6);

        qU.union(9, 10);

        qU.union(5, 9);

        System.out.println(qU.isConnected(9, 10));
        System.out.println(qU.isConnected(1, 9));

    }


}
