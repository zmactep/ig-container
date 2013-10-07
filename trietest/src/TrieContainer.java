import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: mactep
 * Date: 04.10.13
 * Time: 10:10
 */
public class TrieContainer<D> {
    public Vector<TrieContainerData<D>> container = new Vector<TrieContainerData<D>>();

    public TrieContainer() {
    }

    public <C> void copyOf(TrieContainer<C> c) {
        this.container = new Vector<TrieContainerData<D>>();
        for(TrieContainerData<C> data : c.container) {
            this.container.addElement(new TrieContainerData<D>(data.getNode()));
        }
    }

    public void push(TrieNode node) {
        container.addElement(new TrieContainerData<D>(node));
    }

    public void setDataAt(int i, D data) {
        container.elementAt(i).setData(data);
    }

    public TrieNode nodeAt(int i) {
        return container.elementAt(i).getNode();
    }

    public D dataAt(int i) {
        return container.elementAt(i).getData();
    }

    public int size() {
        return container.size();
    }
}
