import java.util.*;

public interface DequeInterface<E>
{
    public void addHead(E e);
    public void removeHead();
    public E getHead();
    public void setHead(E e);
    public void addTail(E e);
    public void removeTail();
    public E getTail();
    public void setTail(E e);
    public ListIterator<E> forwardListIterator();
    public ListIterator<E> backwardListIterator();
}
