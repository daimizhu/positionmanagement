package io.github.daimizhu.service;

import io.github.daimizhu.entity.ListNode;
import io.github.daimizhu.entity.TransactionNode;
import io.github.daimizhu.enums.Action;
import java.util.ArrayList;

import java.util.HashMap;

import java.util.Map;

public class TransitionService {
    private ArrayList<TransactionNode> transactions;
    Map<Integer, ListNode> tranMap;

    public TransitionService(ArrayList<TransactionNode> transactions){
        this.transactions = transactions;
    }

    public void processTransaction() {
        tranMap = new HashMap<Integer, ListNode>();
        for (TransactionNode node : transactions) {
            int tradeID = node.getTradeID();
            if (!tranMap.containsKey(tradeID)) {
                ListNode listNode = new ListNode();
                listNode.insert(node);
                tranMap.put(tradeID, listNode);
            } else {
                ListNode listNode = tranMap.get(tradeID);
                listNode.insert(node);
            }
        }
        for (int key : tranMap.keySet()){
            ListNode listNode = tranMap.get(key);
            TransactionNode cur = listNode.getHead();
            while (listNode !=null && cur != null){
                switch (cur.getAction()){
                    case UPDATE:
                        update(listNode,cur);
                        break;
                    case CANCEL:
                        cancel(listNode);
                        break;
                }
                cur = cur.next;

            }

        }

    }

    /**
     * update listnode
     * @param listNode
     * @param node
     */
    private void update(ListNode listNode, TransactionNode node){
        TransactionNode head = listNode.getHead();
        head.setQuantity(node.getQuantity());
        head.setSecurityCode(node.getSecurityCode());
        head.setSide(node.getSide());
        listNode.remove(node);
    }

    /**
     * clear listnode
     * @param listNode
     */
    private void cancel(ListNode listNode){
        listNode.setFirst(null);
    }

    public Map<String, Integer> calculateResult() {
        Map<String, Integer> outMap = new HashMap<String, Integer>();
        for (int key : tranMap.keySet()) {
            ListNode listNode = tranMap.get(key);

            while (listNode != null && listNode.getHead() != null){
                TransactionNode node = listNode.pop();
                if(node != null){
                    String securityCode = node.getSecurityCode();
                    if (!outMap.containsKey(securityCode)) {
                        outMap.put(securityCode, node.getQuantity());
                    } else {
                        outMap.put(securityCode, outMap.get(securityCode) + node.getQuantity());
                    }
                }
            }

        }
        return  outMap;
    }



}
