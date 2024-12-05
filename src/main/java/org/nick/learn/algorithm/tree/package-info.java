/**
 * 二叉树遍历：
 * <p>
 * 前序遍历的递推公式：
 * preOrder(r) = print r->preOrder(r->left)->preOrder(r->right)
 * <p>
 * 中序遍历的递推公式：
 * inOrder(r) = inOrder(r->left)->print r->inOrder(r->right)
 * <p>
 * 后序遍历的递推公式：
 * postOrder(r) = postOrder(r->left)->postOrder(r->right)->print r
 *
 *
 *
 * 二叉树既可以用链式存储，也可以用数组顺序存储。
 * 数组顺序存储的方式比较适合完全二叉树，其他类型的二叉树用数组存储会比较浪费存储空间。
 * 除此之外，二叉树里非常重要的操作就是前、中、后序遍历操作，遍历的时间复杂度是 O(n)，
 * 需要理解并能用递归代码来实现。
 *
 */
package org.nick.learn.algorithm.tree;