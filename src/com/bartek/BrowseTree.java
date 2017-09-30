package com.bartek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BrowseTree {

    static class Tree {
        public Tree(int value) {
            this.value = value;
        }

        int value;
        List<Tree> children = new ArrayList<>();
    }

    public static List<List<Integer>>createList(Tree root){
        List<List<Integer>>ret = new ArrayList();
        createList(root, 0, ret);
        return ret;
    }

    private static void createList(Tree node, int level, List<List<Integer>>list){
        for(Tree tree: node.children){
            createList(tree, level +1, list);
        }

        while(list.size() <= level){
            list.add(new LinkedList<>());
        }

        list.get(level).add(node.value);
    }

    public static void main(String ars[]) {
        Tree first = new Tree(1);
        Tree second = new Tree(2);
        Tree third = new Tree(3);
        Tree fourth = new Tree(4);
        Tree fifth = new Tree(5);
        Tree sixth = new Tree(6);

        first.children.add(second);
        first.children.add(third);

        second.children.add(fourth);
        second.children.add(fifth);

        third.children.add(sixth);

        System.out.println(createList(first));
    }
}
