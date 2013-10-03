__author__ = 'mactep'
from collections.abc import Sized

from igct.trie.node import Node


class TrieImpl(Sized):
    def __init__(self):
        self._root = Node(None, None, 0)
        self._size = 1

    def insert(self, node, symbol):
        if symbol not in node:
            node[symbol] = Node(node, symbol, self._size)
            self._size += 1
        return node[symbol]

    @property
    def root(self):
        return self._root

    def __len__(self):
        return self._size