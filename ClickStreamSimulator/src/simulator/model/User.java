/**
 * 
 */
package simulator.model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.UUID;

/**
 * @author nishantrathi
 *
 */
public class User {
	private String id;
	private Location location;
	private Stack<Item> itemToVisit;
	private Stack<Item> itemVisited;
	private int numberOfItemToAddToCart = 0;
	private boolean isGoingToOrder;
	private boolean isOrderSuccess;
	
	public User() {
		id = UUID.randomUUID().toString();
		location = Location.values()[new Random().nextInt(Location.values().length)];
		isGoingToOrder = Math.random() < 0.5;
		isOrderSuccess = Math.random() < 0.5;
		itemVisited = new Stack<>();
		int numOfItemsToVisit = (int)(Math.random() * Item.values().length); 
		Set<Item>itemToVisitSet = new HashSet<>();
		for(int i = 0; i < numOfItemsToVisit; i++) {
			itemToVisitSet.add(Item.values()[new Random().nextInt(Item.values().length)]);
		}
		itemToVisit = new Stack<>();
		itemToVisit.addAll(itemToVisitSet);
		numberOfItemToAddToCart = (int)(Math.random() * itemToVisitSet.size());
	}

	public Item visitNextItem() {
		if ( !itemToVisit.isEmpty()) {
			itemVisited.push(itemToVisit.peek());
			return itemToVisit.pop();
		} else {
			return null;
		}
	}

	public Item addNextItemToCart() {
		numberOfItemToAddToCart--;
		return numberOfItemToAddToCart < 0 ?  null : itemVisited.pop();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Stack<Item> getItemToVisit() {
		return itemToVisit;
	}

	public void setItemToVisit(Stack<Item> itemToVisit) {
		this.itemToVisit = itemToVisit;
	}

	public Stack<Item> getItemVisited() {
		return itemVisited;
	}

	public void setItemVisited(Stack<Item> itemVisited) {
		this.itemVisited = itemVisited;
	}

	public boolean isGoingToOrder() {
		return isGoingToOrder;
	}

	public void setGoingToOrder(boolean isGoingToOrder) {
		this.isGoingToOrder = isGoingToOrder;
	}

	public boolean isOrderSuccess() {
		return isOrderSuccess;
	}

	public void setOrderSuccess(boolean isOrderSuccess) {
		this.isOrderSuccess = isOrderSuccess;
	}

	public int getNumberOfItemToAddToCart() {
		return numberOfItemToAddToCart;
	}

	public void setNumberOfItemToAddToCart(int numberOfItemToAddToCart) {
		this.numberOfItemToAddToCart = numberOfItemToAddToCart;
	}
	
}
