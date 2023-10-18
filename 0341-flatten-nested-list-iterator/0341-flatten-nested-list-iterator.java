/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    private Stack<Iterator<NestedInteger>> iterators;
    private Integer nextInteger;

    public NestedIterator(List<NestedInteger> nestedList) {
        iterators = new Stack<>();
        iterators.push(nestedList.iterator());
        advance();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer result = nextInteger;
        advance();
        return result;
    }

    @Override
    public boolean hasNext() {
        return nextInteger != null;
    }

    private void advance() {
        nextInteger = null;
        while (!iterators.isEmpty() && nextInteger == null) {
            if (!iterators.peek().hasNext()) {
                iterators.pop();
            } else {
                NestedInteger nestedInteger = iterators.peek().next();
                if (nestedInteger.isInteger()) {
                    nextInteger = nestedInteger.getInteger();
                } else {
                    iterators.push(nestedInteger.getList().iterator());
                }
            }
        }
    }
}


/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */