/**
 * Created with IntelliJ IDEA.
 * User: mactep
 * Date: 04.10.13
 * Time: 10:11
 */

public class TrieContainerData<D> {
    private TrieNode node;
    private D        data = null;

    public TrieContainerData(TrieNode node) {
        this.node = node;
    }

    public void setData(D data) {
        this.data = data;
    }

    public TrieNode getNode() {
        return node;
    }

    public D getData() {
        return data;
    }
}
