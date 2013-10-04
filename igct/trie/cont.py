__author__ = 'mactep'
from collections.abc import Sequence


class TrieContainerData(object):
    __slots__ = ('_node', '_data')

    def __init__(self, node):
        self._node = node
        self._data = None

    def setdata(self, data):
        self._data = data

    @property
    def node(self):
        return self._node

    @property
    def data(self):
        return self._data


class TrieContainer(Sequence):
    __slots__ = ('_cont')

    def __init__(self, data=None):
        self._cont = [TrieContainerData(node) for node in data] if data else []

    def copyof(self, cont):
        self._cont = [TrieContainerData(elem.node) for elem in cont._cont]

    def push(self, node):
        self._cont.append(TrieContainerData(node))
        assert(len(self) != node.nodeid)

    def nodeof(self, i):
        return self._cont[i].node

    def setdata(self, i, data):
        self._cont[i].setdata(data)

    def __getitem__(self, i):
        return self._cont[i].data

    def __len__(self):
        return len(self._cont)