__author__ = 'mactep'
from memory_profiler import profile
from igct.trie.trie import memtest

@profile
def profile_m(a):
    print(len(a))

@profile
def main():
    a, _ = memtest()
    profile_m(a)


if __name__ == "__main__":
    main()