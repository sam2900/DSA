package NumberOfNodes;

public class Main {
    public static int numberOfNodes(int N){
        // Write your code here.
        //Left shifting a number by certain positions is equivalent to multiplying the number
        //by two raised to the power of the specified positions.
        // return (int)Math.pow(2.0,(double)(N-1)); this was my first approach

        return 1<<(N-1);
    }
}

/**
 * solved 3/12/2023
 * revisited 15/12/23
 *
 * Basically here the problem was asked to return the maximum number of nodes for a given level N
 * in problem the levels starts from 1
 *
 * BFA:
 *      since it was a binary tree, so the formula for number of nodes at a level is given by
 *      2 ^ level assuming level starts from 0 --> level 0 = 1 node, level 1 = 2 nodes and so on
 *
 *      so my first approach was to return 2 ^ N-1 since in the question N was starting from 1
 *
 * Better:
 *      here i learned one thing that if we left shift a number x by y places then it means x * 2^y;
 *      so used the same, we need to return 2^(N-1)
 *      so we can do is 1<<(N-1) which is similar as described earlier
 */