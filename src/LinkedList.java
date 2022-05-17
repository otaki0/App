public class LinkedList {
    Node header , last ,curr;
    private int size=0;

    public void print(){
        curr = header;

        while(curr!=null){
            System.out.println(curr.toString());
            curr=curr.next;
        }
    }

    public void sortedInsert(Node node){
        if(header == null){
            header = last = node;
            size++;
        }else if(header.next == null){
            if(header.freq < node.freq){
                header.next = node;
                node.prev = header;
                last = node;
                size++;
            }else{
                node.next = header;
                header.prev = node;
                header = node;
                size++;
            }
        }else{
            curr = header;
            while(curr != null && curr.freq < node.freq){
                curr = curr.next;
            }
            if(curr == null){
                last.next = node;
                node.prev = last;
                last = node;
                size++;
            }else if(curr == header){
                node.next = header;
                header.prev= node;
                header = node;
                size++;
            }else{
                node.next = curr;
                node.prev= curr.prev;
                curr.prev.next = node;
                curr.prev=node;
                size++;
            }
        }
    }

}
