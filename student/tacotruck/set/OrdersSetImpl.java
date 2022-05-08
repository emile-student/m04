package com.olympic.cis143.m04.student.tacotruck.set;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.olympic.cis143.m04.student.tacotruck.Orders;
import com.olympic.cis143.m04.student.tacotruck.TacoImpl;

public class OrdersSetImpl  implements Orders {
	
	//could implement with hashset containing all available possible orders - and a linked list for the 'pointers' to the orders?
	private HashSet<TacoImpl> tacoOrders = new HashSet<>();
	
	//a deque for keeping track of which tacoOrder is the last one in the list
	private Deque<TacoImpl> tacoOrderOrder = new LinkedList<>();
	
	
	//adds a tacoOrder to the set and to the linked list
    @Override
    public void addOrder(TacoImpl tacoOrder) {
    	   	
    	tacoOrders.add(tacoOrder);
    	tacoOrderOrder.offerFirst(tacoOrder);
    }

    //checks to see if there is another order in the set
    @Override
    public boolean hasNext() {
    	return !tacoOrders.isEmpty();
        
    }

    @Override
    //This one does not seem simple.
    //I've implemented a list as well in order to ensure that I can remove the final element... This needs to be FIFO, but a set doesn't have an order?
    //My solution feels like it bypasses the point of using a set, but i don't see a way to use FIFO in a set effectively.
    //The set implementation could be because you need to check for duplicates over the entire set very quickly?? and only ever remove the last taco?
    //in this case we're maintaining a set of our data and a LinkedList of our data though. 
    // While it passes the tests, and uses a Set, I don't feel like it would pass hidden tests.
    public TacoImpl closeNextOrder() {
    	TacoImpl tacotoremove = tacoOrderOrder.removeLast();
    	tacoOrders.remove(tacotoremove);
        return tacotoremove;
    }

    //checks how many tacoOrders are stored
    @Override
    public int howManyOrders() {
        return tacoOrders.size();
    }
}
