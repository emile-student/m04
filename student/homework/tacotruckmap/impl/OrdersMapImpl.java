package com.olympic.cis143.m04.student.homework.tacotruckmap.impl;

import com.olympic.cis143.m04.student.homework.tacotruckmap.OrderDoesNotExistException;
import com.olympic.cis143.m04.student.homework.tacotruckmap.Orders;
import com.olympic.cis143.m04.student.homework.tacotruckmap.TacoImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersMapImpl implements Orders {
	
	
	private HashMap< String , TacoImpl> orderMap = new HashMap<>();

    @Override
    
    //adds a listing for this orderid in the HashMap
    public void createOrder(final String orderid) {
    	orderMap.put(orderid, null);
    }

    @Override
    //adds taco to the orderid in the HashMap, throwing an error if that orderid does not already exist
    public void addTacoToOrder(final String orderid, final TacoImpl taco) throws OrderDoesNotExistException {
    	if (orderMap.containsKey(orderid))
    		{
    		orderMap.put(orderid, taco);
    }
    	else throw new OrderDoesNotExistException(orderid);
    }
    
    //checks to see if any ordersid's exist in the orderMap
    @Override
    public boolean hasNext() {
    	return !orderMap.isEmpty();
        
    }

    
    //closes and returns order with orderid
    @Override
    public List<TacoImpl> closeOrder(final String orderid) throws OrderDoesNotExistException {
    	List<TacoImpl> closedOrders = new ArrayList<>();
    	//throws exception if the orderid doesn't exist
    	if (orderMap.containsKey(orderid)) {
    		// pulls the appropriate order, then deletes it from the hashmap
    		closedOrders.add(orderMap.get(orderid)); 
    		orderMap.remove(orderid);
    	}
    	else throw new OrderDoesNotExistException(orderid);
    	
        return closedOrders;
    }
    
    //checks how many orderid's are in orderMap
    @Override
    public int howManyOrders() {
        return orderMap.size();
    }
    
    //gets a list of orderids and their taco's that exist in orderMap
    @Override
    public List<TacoImpl> getListOfOrders(final String orderid) throws OrderDoesNotExistException {
    	//throw exception if the orderid doesn't exist
    	if (orderMap.containsKey(orderid)) {
    		//I don't understand why the null response isn't acceptable here, but our test wants 
    		//an empty list back if the orderid doesn't have a taco associated with it, 
    		//so thats what i'll send back.
    		List<TacoImpl> reList = new ArrayList<>();
    		if (orderMap.get(orderid) == null)
    		{
    			reList = Collections.emptyList();
    		}
    		else{
    		reList.add(orderMap.get(orderid));
    		}
    		return reList;
    	}
    	else throw new OrderDoesNotExistException(orderid);
    	
    	
    	
    	
    }
}
