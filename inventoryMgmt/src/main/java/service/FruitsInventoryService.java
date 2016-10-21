package main.java.service;

import java.math.BigDecimal;

import main.java.dto.Item;
import main.java.exceptions.ItemNotFoundException;
import main.java.exceptions.SystemException;


/**
 * The Interface FruitsInventoryService.
 */
public interface FruitsInventoryService {

	/**
	 * Adds the item to basket.
	 *
	 * @param item the item
	 * @return true, if adds the item to basket
	 * @throws SystemException
	 */
	public boolean addItemToBasket(Item item) throws SystemException;

	/**
	 * Removes the item from basket.
	 *
	 * @param item the item
	 * @return true, if removes the item from basket
	 * @throws ItemNotFoundException the item not found exception
	 * @throws SystemException
	 */
	public boolean removeItemFromBasket(Item item) throws ItemNotFoundException, SystemException;

	/**
	 * Calculate total cost.
	 *
	 * @return the big decimal
	 * @throws SystemException
	 */
	public BigDecimal calculateTotalCost() throws SystemException;
}
