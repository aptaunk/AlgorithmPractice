import java.util.*;

public class DequeImpl<E> implements DequeInterface<E>
{
    private static class DequeNode<E> {
        public E data;
        public DequeNode<E> next;
        public DequeNode<E> prev;
        public DequeNode(E data, DequeNode<E> prev, DequeNode<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
        
    private class ForwardDequeListIterator implements ListIterator<E> {
        private DequeNode<E> itNext;
        private DequeNode<E> itPrev;
        private int itNextIndex;
        private DequeNode<E> lastPrevNext;
        public ForwardDequeListIterator() {
            this.itNext = head;
            this.itPrev = null;
            this.itNextIndex = 0;
            this.lastPrevNext = null;
        }
        public void add(E e) {
            DequeNode<E> toBeAdded = new DequeNode<E>(e,itPrev,itNext);
            if (itNext == null && itPrev == null) {
                itPrev = toBeAdded;
                head = toBeAdded;
                tail = toBeAdded;
            } else if (itNext == null && itPrev != null) {
                itPrev.next = toBeAdded;
                itPrev = toBeAdded;
                tail = toBeAdded;
            } else if (itNext != null && itPrev == null) {
                itNext.prev = toBeAdded;
                itPrev = toBeAdded;
                head = toBeAdded;
            } else {
                itPrev.next = toBeAdded;
                itNext.prev = toBeAdded;
                itPrev = toBeAdded;
            }
            lastPrevNext = null;
            itNextIndex++;
            size++;
        }
        public boolean hasNext() {
            return itNext != null;
        }
        public boolean hasPrevious() {
            return itPrev != null;
        }
        public E next() {
            lastPrevNext = itNext;
            itPrev = itNext;
            itNext = itNext.next;
            itNextIndex++;
            return lastPrevNext.data;
        }
        public int nextIndex() {
            return itNextIndex;
        }
        public E previous() {
            lastPrevNext = itPrev;
            itNext = itPrev;
            itPrev = itPrev.prev;
            itNextIndex--;
            return lastPrevNext.data;
        }
        public int previousIndex() {
            return itNextIndex-1;
        }
        public void remove() {
            if (lastPrevNext == itPrev) {
                itPrev = itPrev.prev;
                itNextIndex--;
            } else {
                itNext = itNext.next;
            }
            if (itPrev == null) {
                head = itNext;
            } else {
                itPrev.next = itNext;
            }
            if (itNext == null) {
                tail = itPrev;
            } else {
                itNext.prev = itPrev;
            }
            size--;
            lastPrevNext = null;
        }
        public void set(E e) {
            lastPrevNext.data = e;
        }
    }
    
    private class BackwardDequeListIterator implements ListIterator<E> {
        private DequeNode<E> itNext;
        private DequeNode<E> itPrev;
        private int itNextIndex;
        private DequeNode<E> lastPrevNext;
        public BackwardDequeListIterator() {
            this.itNext = tail;
            this.itPrev = null;
            this.itNextIndex = size-1;
            this.lastPrevNext = null;
        }
        public void add(E e) {
            DequeNode<E> toBeAdded = new DequeNode<E>(e,itNext,itPrev);
            if (itNext == null && itPrev == null) {
                itPrev = toBeAdded;
                head = toBeAdded;
                tail = toBeAdded;
            } else if (itNext == null && itPrev != null) {
                itPrev.prev = toBeAdded;
                itPrev = toBeAdded;
                head = toBeAdded;
            } else if (itNext != null && itPrev == null) {
                itNext.next = toBeAdded;
                itPrev = toBeAdded;
                tail = toBeAdded;
            } else {
                itPrev.prev = toBeAdded;
                itNext.next = toBeAdded;
                itPrev = toBeAdded;
            }
            lastPrevNext = null;
            size++;
        }
        public boolean hasNext() {
            return itNext != null;
        }
        public boolean hasPrevious() {
            return itPrev != null;
        }
        public E next() {
            lastPrevNext = itNext;
            itPrev = itNext;
            itNext = itNext.prev;
            itNextIndex--;
            return lastPrevNext.data;
        }
        public int nextIndex() {
            return itNextIndex;
        }
        public E previous() {
            lastPrevNext = itPrev;
            itNext = itPrev;
            itPrev = itPrev.next;
            itNextIndex++;
            return lastPrevNext.data;
        }
        public int previousIndex() {
            return itNextIndex+1;
        }
        public void remove() {
            if (lastPrevNext == itPrev) {
                itPrev = itPrev.next;
            } else {
                itNext = itNext.prev;
                itNextIndex--;
            }
            if (itPrev == null) {
                tail = itNext;
            } else {
                itPrev.prev = itNext;
            }
            if (itNext == null) {
                head = itPrev;
            } else {
                itNext.next = itPrev;
            }
            size--;
            lastPrevNext = null;
        }
        public void set(E e) {
            lastPrevNext.data = e;
        }
    }
    
    private DequeNode<E> head;
    private DequeNode<E> tail;
    private int size;
    
    public DequeImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void addHead(E e) {
        head = new DequeNode<E>(e,null,head);
        if (tail == null) {
            tail = head;
        }
        size++;
    }
    
    public void removeHead() {
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }
    
    public E getHead() {
        return head.data;
    }
    
    public void setHead(E e) {
        head.data = e;
    }
    
    public void addTail(E e) {
        tail = new DequeNode<E>(e,tail,null);
        if (head == null) {
            head = tail;
        }
        size++;
    }
    
    public void removeTail() {
        if (tail.prev == null) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }
    
    public E getTail() {
        return tail.data;
    }
    
    public void setTail(E e) {
        tail.data = e;
    }
    
    public ListIterator<E> forwardListIterator() {
        return new ForwardDequeListIterator();
    }
    
    public ListIterator<E> backwardListIterator(){
        return new BackwardDequeListIterator();
    }
}



