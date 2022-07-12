from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> list[int]:
        result = []
        if root is None:
            return result
        tmp = [[root]]
        while root is not None:
            cur_list = tmp.pop(0)
            result.append(cur_list[-1].val)
            next_tmp = []
            for i in range(len(cur_list)):
                cur = cur_list[i]
                if cur.left is not None:
                    next_tmp.append(cur.left)
                if cur.right is not None:
                    next_tmp.append(cur.right)
            if len(next_tmp) == 0:
                break
            tmp.append(next_tmp)
        return result
