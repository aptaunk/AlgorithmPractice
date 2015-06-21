public class ReverseLastFiveNodes
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
    
    public static void reverseLastFive(LinkedList list) {
        if (list.head == null) {
            return;
        }
        LinkedListNode last = list.head;
        int size = 1;
        while (last.next != null && size<6) {
            last = last.next;
            size++;
        }
        if (size == 6) {
            LinkedListNode prev = list.head;
            LinkedListNode[] reverseThis = new LinkedListNode[5];
            while (last.next != null) {
                last = last.next;
                prev = prev.next;
            }
            LinkedListNode curr = prev.next;
            for (int i=0; i<5; i++) {
                reverseThis[i] = curr;
                curr = curr.next;
            }
            prev.next = last;
            for (int i=4; i>=1; i--) {
                reverseThis[i].next = reverseThis[i-1];
            }
            reverseThis[0].next = null;
        } else {
            LinkedListNode[] reverseThis = new LinkedListNode[size];
            LinkedListNode curr = list.head;
            for (int i=0; i<size; i++) {
                reverseThis[i] = curr;
                curr = curr.next;
            }
            list.head = reverseThis[size-1];
            for (int i=size-1; i>=1; i--) {
                reverseThis[i].next = reverseThis[i-1];
            }
            reverseThis[0].next = null;
        }
    }
    
    public static void main () {
        LinkedList testList = new LinkedList(new int[]{1,2,3,4,5,6,7,8,9});
        reverseLastFive(testList);
        for (LinkedListNode curr = testList.head; curr != null; curr = curr.next) {
            System.out.print(""+curr.data+" ");
        }
    }
    
}
