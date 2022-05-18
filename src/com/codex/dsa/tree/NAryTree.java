package com.codex.dsa.tree;

import java.util.List;

public class NAryTree {

	
	public int val;
    public List<NAryTree> children;

    public NAryTree() {}

    public NAryTree(int _val,List<NAryTree> _children) {
        val = _val;
        children = _children;
    }
}
