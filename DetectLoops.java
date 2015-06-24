import java.util.*;

public class DetectLoops
{
    public static class LinkedListNode
    {
        public int data;
        public LinkedListNode next;
        public LinkedListNode(int data) {
            this.data = data;
            next = null;
        }
    }
    
    public static class LinkedList
    {
        public LinkedListNode head;
        public LinkedList(int[] list) {
            head = list.length>0?new LinkedListNode(list[0]):null;
            LinkedListNode curr = head;
            for (int i=1; i<list.length; i++) {
                curr.next = new LinkedListNode(list[i]);
                curr = curr.next;
            }
        }
    }
    
    public static boolean hasLoops(LinkedList list) {
        HashSet<LinkedListNode> previousNodes = new HashSet<LinkedListNode>();
        for (LinkedListNode curr = list.head; curr != null; curr = curr.next) {
            if (previousNodes.contains(curr)) {
                return true;
            }
            previousNodes.add(curr);
        }
        return false;
    }
    
    public static void main () {
        LinkedList testList = new LinkedList(new int[]{1,2,3});
        testList.head.next.next.next = testList.head;
        System.out.println(hasLoops(testList));
    }
}

