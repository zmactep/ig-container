import java.util.Set;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: mactep
 * Date: 03.10.13
 * Time: 17:08
 */

public class TrieNode {
    private byte                    symbol   = 0;
    private TrieNode                parent   = null;
    private int                     id       = 0;
    private TreeMap<Byte, TrieNode> children = new TreeMap<Byte, TrieNode>();

    public TrieNode() {

    }

    public TrieNode(TrieNode parent, byte symbol, int id) {
        this.parent = parent;
        this.symbol = symbol;
        this.id = id;
    }

    public void push(TrieNode node) {
        children.put(node.getSymbol(), node);
    }

    public TrieNode get(byte symbol)
    {
        return children.get(symbol);
    }

    public boolean containsSymbol(byte symbol) {
        return children.containsKey(symbol);
    }

    public byte getSymbol() {
        return symbol;
    }

    public TrieNode getParent() {
        return parent;
    }

    public int getId() {
        return id;
    }

    public Set<Byte> keys() {
        return children.keySet();
    }
}
