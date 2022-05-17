public class Node {
    char letter;
    int freq ; 
    Node next, prev;
    public Node(){}
    public Node (char letter , int freq){
        this.freq=freq;
        this.letter=letter;
    }
    @Override
    public String toString() {
        return this.freq +" : "+this.letter;
    }
}
