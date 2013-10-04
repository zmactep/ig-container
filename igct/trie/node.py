__author__ = 'mactep'
from collections.abc import MutableMapping


class Node(MutableMapping):
    __slots__ = ('_parent', '_symbol', '_node_id', '_children')

    def __init__(self, parent, symbol, node_id):
        self._parent = parent
        self._symbol = symbol
        self._node_id = node_id
        self._children = {}

    @property
    def nodeid(self):
        return self._node_id

    @property
    def parent(self):
        return self._parent

    @property
    def symbol(self):
        return self._symbol

    def __getitem__(self, item):
        return self._children[item]

    def __setitem__(self, key, value):
        self._children[key] = value

    def __delitem__(self, key):
        pass

    def __iter__(self):
        return iter(self._children)

    def __len__(self):
        return len(self._children)

    def __contains__(self, item):
        return item in self._children

    def __eq__(self, other):
        return self.nodeid == other.nodeid

    def __ne__(self, other):
        return self.nodeid != other.nodeid