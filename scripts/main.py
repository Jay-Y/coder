#! /usr/bin/env python
# coding: utf-8
import sys

from coder import *

if __name__ == '__main__':
    c = Coder()
    paths = None
    if sys.argv is not None and len(sys.argv) > 1:
        paths = sys.argv[1].split(",")
    if paths is not None and len(paths) > 0:
        for path in paths:
            if os.path.exists(path):
                c.coding(path)
    else:
        c.coding(None)
