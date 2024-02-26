import java.util.*;

class DesignInMemoryFileSystem588 {
    
    private Node root;

    public DesignInMemoryFileSystem588() {
        root = new Node("");
    }

    public List<String> ls(String path) {
        Node node = traversePath(path);
        return node.isFile 
            ? List.of(node.name) // file
            : List.copyOf(node.nodeNameMap.keySet()); // all file names in the directory
    }

    public void mkdir(String path) {
        traversePath(path);
    }

    public void addContentToFile(String filePath, String content) {
        Node node = traversePath(filePath);
        node.content.append(content);
        node.isFile = true;
    }

    public String readContentFromFile(String filePath) {
        return traversePath(filePath).content.toString();
    }

    private Node traversePath(String path) {
        Node current = root;
        String[] paths = path.split("/");
        // root is always empty ("")
        int index = 1;
        while (index < paths.length) {
            String directory = paths[index];
            current.nodeNameMap.putIfAbsent(directory, new Node(directory));
            current = current.nodeNameMap.get(directory);
            index++;
        }
        return current;
    }

    public static void main(String[] args) {    
        DesignInMemoryFileSystem588 solution = new DesignInMemoryFileSystem588();

        // // Test 1
        // System.out.println(solution.ls("/"));
        // solution.mkdir("/a/b/c");
        // solution.addContentToFile("/a/b/c/d", "hello");
        // System.out.println(solution.ls("/"));
        // System.out.println(solution.readContentFromFile("/a/b/c/d"));

        // Test 2
        solution.mkdir("/zijzllb");
        System.out.println(solution.ls("/"));
        System.out.println(solution.ls("/zijzllb"));
        solution.mkdir("/r");
        System.out.println(solution.ls("/"));
        System.out.println(solution.ls("/r"));
        solution.addContentToFile("/zijzllb/hfktg", "d");
        System.out.println(solution.ls("/zijzllb/hfktg"));
        System.out.println(solution.ls("/"));
        System.out.println(solution.readContentFromFile("/zijzllb/hfktg"));
    }
}

class Node {
    String name;
    Map<String, Node> nodeNameMap;
    StringBuilder content;
    boolean isFile;

    Node(String name) {
        this.name = name;
        nodeNameMap = new TreeMap<>(); // lexicographic order
        content = new StringBuilder();
    }
}