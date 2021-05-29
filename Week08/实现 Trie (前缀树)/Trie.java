package medium.leetcode208;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: SolutionFirst
 * @Description: 实现 Trie (前缀树)
 * @Author: Liu Yong
 * @Date: 2021/5/18 9:49 下午
 */
public class Trie {

    class Node {
        boolean isEnd;
        Node[] children;

        Node() {
            this.children = new Node[26];
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node tempNode = root;
        char[] cs = word.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (tempNode.children[cs[i] - 'a'] == null) tempNode.children[cs[i] - 'a'] = new Node();
            tempNode = tempNode.children[cs[i] - 'a'];
            if (i == cs.length - 1) tempNode.isEnd = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node tempNode = root;
        char[] cs = word.toCharArray();
        for (int i = 0; i< cs.length; i++) {
            if (tempNode.children[cs[i] - 'a'] == null) break;
            if (tempNode.children[cs[i] - 'a'].isEnd && i == cs.length - 1) return true;
            tempNode = tempNode.children[cs[i] - 'a'];
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node tempNode = root;
        for (char c : prefix.toCharArray()) {
            if (tempNode.children[c - 'a'] == null) return false;
            tempNode = tempNode.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print("[");
        Trie trie = new Trie();
        System.out.print("null,");
        trie.insert("apple");
        System.out.print("null,");
        System.out.print(trie.search("apple") + ","); // 返回 True
        System.out.print(trie.search("app") + ","); // 返回 False
        System.out.print(trie.startsWith("app") + ","); // 返回 True
        trie.insert("app");
        System.out.print("null,");
        System.out.print(trie.search("app") + ","); // 返回 True
        System.out.print("]");
    }

}
