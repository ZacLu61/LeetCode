import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SearchSuggestionsSystem1268 {
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        if (products == null || products.length == 0) {
            return result;
        }

        Arrays.sort(products);

        TrieNode root = buildTrie(products);
        TrieNode cur = root;

        for (char ch : searchWord.toCharArray()) {
            cur.nextMap.putIfAbsent(ch, new TrieNode());
            cur = cur.nextMap.get(ch);
            result.add(cur.words);
        }
        return result;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode cur = root;

            for (char ch : word.toCharArray()) {
                cur.nextMap.putIfAbsent(ch, new TrieNode());
                cur = cur.nextMap.get(ch);
                if (cur.words.size() < 3) {
                    cur.words.add(word);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // Test 1
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        // expect: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","
    
        // // Test 2
        // String[] products = {"havana"};
        // String searchWord = "havana";
        // // expect: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]

        System.out.println(new SearchSuggestionsSystem1268().suggestedProducts(products, searchWord));
    }
}

class TrieNode {
    List<String> words;
    Map<Character, TrieNode> nextMap;

    TrieNode() {
        nextMap = new HashMap<>();
        words = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "nextMap:" + nextMap + ", words:" + words;
    }
}