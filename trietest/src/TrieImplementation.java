/**
 * Created with IntelliJ IDEA.
 * User: mactep
 * Date: 04.10.13
 * Time: 10:38
 */
public class TrieImplementation {
    private TrieNode root = new TrieNode();
    private int      size = 1;

    public TrieImplementation() {
    }

    public TrieNode insert(TrieNode node, byte symbol) {
        if(!node.containsSymbol(symbol)) {
            TrieNode newnode = new TrieNode(node, symbol, size);
            node.push(newnode);
            size++;
        }

        return node.get(symbol);
    }

    public TrieNode getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }
}
