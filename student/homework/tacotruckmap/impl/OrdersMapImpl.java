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
    public void createOrder(final String orderid) {
    	orderMap.put(orderid, null);
    }

    @Override
    public void addTacoToOrder(final String orderid, final TacoImpl taco) throws OrderDoesNotExistException {
    	if (orderMap.containsKey(orderid))
    		{
    		orderMap.put(orderid, taco);
    }
    	else throw new OrderDoesNotExistException(orderid);
    }
    @Override
    public boolean hasNext() {
    	return !orderMap.isEmpty();
        
    }

    @Override
    public List<TacoImpl> closeOrder(final String orderid) throws OrderDoesNotExistException {
    	List<TacoImpl> closedOrders = new ArrayList<>();
    	if (orderMap.containsKey(orderid)) {
    		closedOrders.add(orderMap.get(orderid));
    		orderMap.remove(orderid);
    	}
    	else throw new OrderDoesNotExistException(orderid);
    	
        return closedOrders;
    }

    @Override
    public int howManyOrders() {
        return orderMap.size();
    }

    @Override
    public List<TacoImpl> getListOfOrders(final String orderid) throws OrderDoesNotExistException {
    	if (orderMap.containsKey(orderid)) {
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
