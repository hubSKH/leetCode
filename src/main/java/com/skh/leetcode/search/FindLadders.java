package leetcode.search;

import java.util.*;

/**
 * 126. 单词接龙 II
 *
 * @Description 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，
 * 一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 * * 每对相邻的单词之间仅有单个字母不同。
 * * 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
 * * sk == endWord
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。
 * 请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，
 * 如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
 * @auther SHENKAIHUAN
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * 解释：存在 2 种最短的转换序列：
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 * @create 2021-10-25 20:45
 */
public class FindLadders {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList ("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> ladders = new FindLadders ().findLadders (beginWord, endWord, wordList);
        for (List<String> ladder : ladders) {
            System.out.println (ladder);
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<> ();
        Set<String> dict = new HashSet<> (wordList);
        if (!dict.contains (endWord)) {
            return result;
        }
        dict.remove (beginWord);
        Map<String, Integer> steps = new HashMap<> ();
        steps.put (beginWord, 0);
        Map<String, List<String>> from = new HashMap<> ();
        int step = 1;
        boolean found = false;
        int wordLen = beginWord.length ();
        Queue<String> queue = new LinkedList<> ();
        queue.offer (beginWord);
        // bfs
        while (!queue.isEmpty ()) {
            int size = queue.size ();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll ();
                char[] charArray = currWord.toCharArray ();
                for (int j = 0; j < wordLen; j++) {
                    char origin = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;
                        String nextWord = String.valueOf (charArray);
                        if (steps.containsKey (nextWord) && step == steps.get (nextWord)) {
                            from.get (nextWord).add (currWord);
                        }
                        if (!dict.contains (nextWord)) {
                            continue;
                        }
                        dict.remove (nextWord);
                        queue.offer (nextWord);
                        from.putIfAbsent (nextWord, new ArrayList<> ());
                        from.get (nextWord).add (currWord);
                        steps.put (nextWord, step);
                        if (nextWord.equals (endWord)) {
                            found = true;
                        }
                    }
                    charArray[j] = origin;
                }
            }
            step++;
            if (found) break;
        }

        if (found) {
            Deque<String> path = new ArrayDeque<> ();
            path.add (endWord);
            dfs (from, path, beginWord, endWord, result);
        }
        return result;
    }

    private void dfs(Map<String, List<String>> from, Deque<String> path, String beginWord, String endWord, List<List<String>> result) {
        if (endWord.equals (beginWord)) {
            result.add (new ArrayList<> (path));
            return;
        }
        for (String s : from.get (endWord)) {
            path.addFirst (s);
            dfs (from, path, beginWord, s, result);
            path.removeFirst ();
        }
    }


}
