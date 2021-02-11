/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

 type pair struct {
    now int
    later int
}

func max(a int, b int) int{
    if a > b {
        return a
    }
    return b 
}

func robTree(node *TreeNode) pair {
    /*
    now: max money earned if input node is robbed
    later: max money earned if input node is not robbed
    */
    if node == nil {
        return pair{}
    }

    left := robTree(node.Left)
    right := robTree(node.Right)
    
    p := pair{}
    p.now = node.Val + left.later + right.later
    p.later = max(left.now, left.later) + max(right.now, right.later)

    return p
    
}

func rob(root *TreeNode) int {    
    if root == nil {
        return 0
    }
    res := robTree(root)
    return max(res.now, res.later)
}