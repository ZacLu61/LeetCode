import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class AnalyzeUserWebsiteVisitPattern1152 {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        
        List<Data> dataList = new ArrayList<>();
        for (int i=0; i<username.length; ++i) {
            dataList.add(new Data(username[i], timestamp[i], website[i]));
        }
        dataList.sort(Comparator.comparingInt(data -> data.timestamp));

        for (Data data : dataList) {
            if (!root.users.contains(data.username)) {
                root.users.add(data.username);
            }
            root.addChild(data.username, data.website);
        }
        while (!root.children.isEmpty()) {
            root = findWeb(root, result);
        }
        return result;
    }

    private TrieNode findWeb(TrieNode root, List<String> result) {
        List<String> websites = new ArrayList<>(root.children.keySet());
        Collections.sort(websites, (s1, s2) -> {
            if (root.children.get(s2).count == root.children.get(s1).count ) { 
                return s1.compareTo(s2);
            } 
            return root.children.get(s2).count - root.children.get(s1).count;
        });
        result.add(websites.get(0));
        return root.children.get(websites.get(0));
    }
    public static void main(String[] args) {
        // Test 1
        String[] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
        String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};
        // expect: {"home","about","career"}

        // // Test 2
        // String[] username = {"ua","ua","ua","ub","ub","ub"};
        // int[] timestamp = {1,2,3,4,5,6};
        // String[] website = {"a","b","c","a","b","c"};
        // // expect: {"a","b","a"}

        System.out.println(new AnalyzeUserWebsiteVisitPattern1152().mostVisitedPattern(username, timestamp, website));
    }
}

class TrieNode {
    int level;
    String website;
    int count;
    Map<String, TrieNode> children;
    Set<String> users;

    TrieNode() {
        level = 0;
        count = 0;
        children = new HashMap<>();
        users = new HashSet<>();
    }
    
    int addChild(String username, String website) {
        // not visited
        if (!users.contains(username)) {
            return 0;
        }
        // recursive down to the children
        if (level < 2) {
            for (TrieNode child : children.values()) {
                count = Math.max(count, child.addChild(username, website));
            }
        }
        TrieNode childNode;

        if (!children.containsKey(website)) {
            childNode = new TrieNode();
            childNode.website = website;
            childNode.level = level + 1;
            children.put(website, childNode);
        }
        
        childNode = children.get(website);
        if (!childNode.users.contains(username)) {
            if (childNode.level == 3) {
                childNode.count++;
            }
            childNode.users.add(username);
        }
        if (childNode.level == 3) {
            count = Math.max(count, childNode.count);
        }
        return count;
    }
}

class Data {
    String username;
    int timestamp;
    String website;

    Data(String username, int timestamp, String website) {
        this.username = username;
        this.website = website;
        this.timestamp = timestamp;
    }
}