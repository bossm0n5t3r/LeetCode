package backspaceStringCompare

import java.util.Stack

class BackspaceStringCompare {
    fun backspaceCompare(s: String, t: String): Boolean {
        val sStack = Stack<Char>()
        val tStack = Stack<Char>()
        s.forEach { c ->
            if (c != '#') {
                sStack.add(c)
            } else {
                if (sStack.isNotEmpty()) sStack.pop()
            }
        }
        t.forEach { c ->
            if (c != '#') {
                tStack.add(c)
            } else {
                if (tStack.isNotEmpty()) tStack.pop()
            }
        }
        return sStack == tStack
    }
}
