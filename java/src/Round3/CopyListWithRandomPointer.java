package Round3;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        //[[7,null],[13,0],[11,4],[10,2],[1,0]]
        MyNewNode head=new MyNewNode(7,null,null);
        MyNewNode head1=new MyNewNode(13,null,null);
        MyNewNode head2=new MyNewNode(11,null,null);
        MyNewNode head3=new MyNewNode(10,null,null);
        MyNewNode head4=new MyNewNode(1,null,null);

        head.next=head1;
        head1.next=head2;
        head2.next=head3;
        head3.next=head4;

        head.random=null;
        head1.random=head;
        head2.random=head4;
        head3.random=head2;
        head4.random=head;

    }
}


class MyNewNode {
    public int val;
    public MyNewNode next;
    public MyNewNode random;

    public MyNewNode() {}

    public MyNewNode(int _val,MyNewNode _next,MyNewNode _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};