package com.olympic.cis143.m04.student.tacotruck.set;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.olympic.cis143.m04.student.tacotruck.Orders;
import com.olympic.cis143.m04.student.tacotruck.TacoImpl;

public class OrdersSetImpl  implements Orders {
	
	//could implement with hashset containing all available possible orders - and a linked list for the 'pointers' to the orders
	private HashSet<TacoImpl> tacoOrders = new HashSet<>();
	
	//implement- 
	private Deque<TacoImpl> tacoOrderOrder = new LinkedList<>();
	
	
    @Override
    public void addOrder(TacoImpl tacoOrder) {
    	    	
    	tacoOrders.add(tacoOrder);
    	tacoOrderOrder.offerFirst(tacoOrder);
    }

    @Override
    public boolean hasNext() {
    	return !tacoOrders.isEmpty();
        
    }

    @Override
    //This one does not seem simple. Do i need to implement a list or something as well?
    // in order to ensure that I can remove the final element? This needs to be FIFO, but a set doesn't have an order??
    //this feels like it bypasses the point of using a set, but i don't see a way to use FIFO in a set effectively.
    //The set implementation could be because you need to check for duplicates over the entire set very quickly?? and only ever remove the last taco?
    public TacoImpl closeNextOrder() {
    	TacoImpl tacotoremove = tacoOrderOrder.removeLast();
    	tacoOrders.remove(tacotoremove);
        return tacotoremove;
    }

    @Override
    public int howManyOrders() {
        return tacoOrders.size();
    }
}
