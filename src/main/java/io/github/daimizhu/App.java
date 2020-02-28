package io.github.daimizhu;

import io.github.daimizhu.entity.TransactionNode;
import io.github.daimizhu.enums.Action;
import io.github.daimizhu.enums.Side;
import io.github.daimizhu.service.TransitionService;

import java.util.ArrayList;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        TransactionNode node1 = new TransactionNode(1,1,1, "REL", Action.INSERT, Side.BUY, 50);
        TransactionNode node2 = new TransactionNode(2,2,1, "ITC", Action.INSERT, Side.SELL, 40);
        TransactionNode node3 = new TransactionNode(3,3,1, "INF", Action.INSERT, Side.BUY, 70);
        TransactionNode node4 = new TransactionNode(4,1,2, "REL", Action.UPDATE, Side.BUY, 60);
        TransactionNode node5 = new TransactionNode(5,2,2, "ITC", Action.CANCEL, Side.BUY, 30);
        TransactionNode node6 = new TransactionNode(6,4,1, "INF", Action.INSERT, Side.SELL, 20);

        ArrayList<TransactionNode> transactions = new ArrayList<TransactionNode>();
        transactions.add(node1);
        transactions.add(node2);
        transactions.add(node3);
        transactions.add(node4);
        transactions.add(node5);
        transactions.add(node6);

        TransitionService tranService = new TransitionService(transactions);
        tranService.processTransaction();
        Map<String, Integer> outMap = tranService.calculateResult();
    }
}
