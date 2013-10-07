import java.util.Iterator;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: mactep
 * Date: 04.10.13
 * Time: 10:50
 */
public class Trie<D> implements Iterable<Integer> {
    private TrieImplementation implementation = new TrieImplementation();
    private TrieContainer<D>   container      = new TrieContainer<D>();
    private Vector<Integer>    dfs_cache      = new Vector<Integer>();

    public Trie() {
        container.push(implementation.getRoot());
    }

    public <C> void copyOf(Trie<C> trie) {
        implementation = trie.implementation;
        container.copyOf(trie.container);
        dfs_cache = trie.dfs_cache;
    }

    public int insert(int i, byte symbol) {
        TrieNode node = implementation.insert(container.nodeAt(i), symbol);
        if(node.getId() == container.size()) {
            container.push(node);
        }
        return node.getId();
    }

    public byte symbolOf(int i) {
        return container.nodeAt(i).getSymbol();
    }

    public void setDataOf(int i, D data) {
        container.setDataAt(i, data);
    }

    public D dataOf(int i) {
        return container.dataAt(i);
    }

    public int parentOf(int i) {
        TrieNode node = container.nodeAt(i).getParent();
        if(node != null) {
            return node.getId();
        }

        return -1;
    }

    public int nextOf(int i, byte symbol) {
        return container.nodeAt(i).get(symbol).getId();
    }

    public boolean isFork(int i) {
        return container.nodeAt(i).keys().size() > 1;
    }

    public boolean isLeaf(int i) {
        return container.nodeAt(i).keys().size() == 0;
    }

    public int size() {
        return implementation.getSize();
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
