package io.github.daimizhu.entity;

public class ListNode {
    private TransactionNode first;

    public TransactionNode getFirst() {
        return first;
    }

    public void setFirst(TransactionNode first) {
        this.first = first;
    }

    public ListNode() {
        this.first = null;
    }

    /**
     * Insert node to list, make sure the sequence by the version
     * @param node
     */
    public void insert(TransactionNode node){
        TransactionNode pre = null;
        TransactionNode cur = this.first;
        while (cur != null && node.getVersion() >= cur.getVersion()){
            pre = cur;
            cur = cur.next;
        }
        if(pre ==null){
            //first = node;
            setFirst(node);
        }
        else {
            pre.next = node;
        }
        node.next = cur;

    }

    /**
     * List is empty or not
     * @return boolean
     */
    public boolean isEmpty(){
        return first==null;
    }

    /**
     * get the first node and remove
     * @return TransactionNode
     */
    public TransactionNode pop(){
        TransactionNode temp = first;
        if(first!=null){
            first = first.next;
        }
        return temp;
    }

    /**
     * Get first node
     * @return
     */
    public TransactionNode getHead(){
        return first;
    }

    /**
     * Remove the given node from list
     * @param node
     */
    public void remove(TransactionNode node){
        TransactionNode pre = null;
        TransactionNode cur = first;
        while (cur != null && node.getTransactionID() != cur.getTransactionID()){
            pre = cur;
            cur = cur.next;
            if(node.getTransactionID() == cur.getTransactionID()){
                pre.next = cur.next;
                break;
            }
        }

    }


}
