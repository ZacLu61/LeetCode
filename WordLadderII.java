import java.util.*;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        Map<String, List<String>> graph = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        boolean found = false;

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            List<String> nextLevel = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    found = true;
                }

                for (String next : getNeighbors(currentWord, words, graph)) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    queue.add(next);
                    visited.add(next);
                    nextLevel.add(next);
                }
            }
            if (found) {
                break;
            }
            for (String nextWord : nextLevel) {
                if (words.contains(nextWord)) {
                    words.remove(nextWord);
                }
            }
        }
        List<String> path = new ArrayList<>();
        backtrack(endWord, beginWord, graph, result, path);
        return result;
    }

    private List<String> getNeighbors(String target, Set<String> words,
            Map<String, List<String>> graph) {
        List<String> neighbors = new ArrayList<>();
        char[] word = target.toCharArray();

        for (int i = 0; i < word.length; ++i) {
            char originalChar = word[i];
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                if (ch == originalChar) {
                    continue;
                }
                // Update ch and check if in words
                word[i] = ch;
                String neighbor = new String(word);
                if (!words.contains(neighbor)) {
                    continue;
                }
                neighbors.add(neighbor);
                graph.putIfAbsent(neighbor, new ArrayList<>());
                graph.get(neighbor).add(target);
            }
            word[i] = originalChar;
        }
        return neighbors;
    }

    private void backtrack(String beginWord, String endWord, Map<String, List<String>> graph,
            List<List<String>> result, List<String> path) {
        if (beginWord.equals(endWord)) {
            List<String> copyList = new ArrayList<>(path);
            copyList.add(endWord);
            Collections.reverse(copyList);
            result.add(copyList);
            return;
        }
        if (!graph.containsKey(beginWord)) {
            return;
        }
        path.add(beginWord);
        for (String next : graph.get(beginWord)) {
            backtrack(next, endWord, graph, result, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        WordLadderII solution = new WordLadderII();

        // Test case 1
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<String>() {
            {
                add("hot");
                add("dot");
                add("dog");
                add("lot");
                add("log");
                add("cog");
            }
        };

        // Test case 2
        // String beginWord = "hit";
        // String endWord = "cog";
        // List<String> wordList = new ArrayList<String>() {
        // {
        // add("hot");
        // add("dot");
        // add("dog");
        // add("lot");
        // add("lot");
        // add("log");
        // }
        // };

        System.out.println(solution.findLadders(beginWord, endWord, wordList));
    }
}
