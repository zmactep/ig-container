__author__ = 'mactep'

from memory_profiler import profile
from collections.abc import Iterable, Sized

from igct.trie.impl import TrieImpl
from igct.trie.cont import TrieContainer


class Trie(Iterable, Sized):
    __slots__ = ('_trie', '_cont', '_dfs_cache')

    def __init__(self):
        self._trie = TrieImpl()
        self._cont = TrieContainer([self._trie.root])
        self._dfs_cache = []

    def copyof(self, trie):
        self._trie = trie._trie
        self._cont.copyof(trie._cont)

    def insert(self, i, symbol):
        node = self._trie.insert(self._cont.nodeof(i), symbol)
        if node.nodeid == len(self._cont):
            self._cont.push(node)
        return node.nodeid

    def symbolof(self, i):
        return self._cont.nodeof(i).symbol

    def setdataof(self, i, data):
        self._cont.setdata(i, data)

    def dataof(self, i):
        return self._cont[i]

    def parentof(self, i):
        node = self._cont.nodeof(i).parent
        return node.nodeid if node else None

    def nextof(self, i, symbol):
        node = self._cont.nodeof(i)
        return node[symbol].nodeid

    def keysof(self, i):
        return self._cont.nodeof(i).keys()

    def isfork(self, i):
        return len(self._cont.nodeof(i)) > 1

    def isleaf(self, i):
        return len(self._cont.nodeof(i)) == 0

    def cache(self):
        def dfs(current, prev):
            self._dfs_cache[prev] = current
            prev = current
            node = self._cont.nodeof(current)
            for i in node:
                prev = dfs(node[i].nodeid, prev)
            return prev

        if len(self._dfs_cache) != len(self):
            self._dfs_cache = [0] * len(self)
            dfs(0, 0)
        return self._dfs_cache

    def dfs_next(self, i):
        self.cache()
        return self._dfs_cache[i]

    def __iter__(self):
        i = self.dfs_next(0)
        while i:
            yield i
            i = self.dfs_next(i)

    def __len__(self):
        return len(self._trie)

    def __str__(self):
        return "Trie [len=%i]" % len(self)

@profile
def f(alpha, ns, nl, eps=0):
    from numpy.random import randint
    a = Trie()
    total = 0
    for _ in range(ns):
        n = randint(nl - eps, nl + eps) if eps else nl
        total += n
        i = 0
        for _ in range(n):
            i = a.insert(i, chr(randint(alpha)))
    return a, (len(a) - 1) / total


def memtest():
    return f(4, 1000, 100)