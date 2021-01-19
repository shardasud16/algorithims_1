package com.sid.algo.week1.unionfind;


/**
 * This is the first approach we are taking to solve
 * dynamic connectivity problem. We will analyse this
 * algo and then see if we can do any optimization.
 *
 * After the implementation as the names says
 * it is quick find so time Complexity for is O(1)
 * but union method Time complexity is O(n).
 *
 * If we perform union on n elements then it will be
 * quadratic N * N
 *
 * So we need to optimize this solution as
 * for billions of records and millions
 * of interactions it can take up to 30 computer years !!!
 */
public class QuickFindUF {

    int [] id;

    public QuickFindUF(int n){

        id = new int[n];

        for(int i = 0; i < id.length; i++)
            id[i] = i;

    }

    public boolean isConnected(int p, int q){
        return id[p] == id[q];
    }

    public void union(int p, int q){
        int idP = id[p];
        int idQ = id[q];

        if(!isConnected(p, q)){
            for(int i = 0; i < id.length; i++){
                if(id[i] == idP)
                    id[i] = idQ;
            }
        }
    }

    public static void main(String[] args) {
        QuickFindUF qf = new QuickFindUF(11);
        qf.union(1,2);
        qf.union(4,6);

        qf.union(9, 10);

        System.out.println(qf.isConnected(9, 10));
        System.out.println(qf.isConnected(1, 9));

    }


}


