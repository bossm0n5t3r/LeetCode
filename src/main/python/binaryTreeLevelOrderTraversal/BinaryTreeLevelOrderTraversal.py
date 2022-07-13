from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> list[list[int]]:
        result = []
        if root is None:
            return result
        queue = [root]
        while queue:
            size = len(queue)
            tmp = []
            while size:
                size -= 1
                cur = queue.pop(0)
                tmp.append(cur.val)
                if cur.left is not None:
                    queue.append(cur.left)
                if cur.right is not None:
                    queue.append(cur.right)
            result.append(tmp)
        return result
