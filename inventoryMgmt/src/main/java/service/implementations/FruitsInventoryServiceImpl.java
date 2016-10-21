package main.java.service.implementations;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import java.util.logging.Logger;

import main.java.dto.Item;
import main.java.exceptions.ItemNotFoundException;
import main.java.exceptions.SystemException;
import main.java.service.FruitsInventoryService;

/**
 * The FruitsInventoryServiceImpl provides functionality to add the items,
 * remove items from the basket and also calculate the total cost of the items
 * in the basket.
 *
 * @author Bhavika Shah
 * @version 1.0
 * @since 2016-10-21
 */
public class FruitsInventoryServiceImpl implements FruitsInventoryService {

	private static final Logger LOGGER = Logger.getLogger( FruitsInventoryServiceImpl.class.getName() );
	/** The basket. */
	private Map<Integer, Item> basket = new HashMap<Integer, Item>();

	/**
	 * This method is used to add items into the basket.
	 *
	 * @param item
	 *            This is the paramter to addItemToBasket method
	 * @return boolean returns true if item already exits and false if not.
	 * @throws SystemException
	 */
	@Override
	public boolean addItemToBasket(Item item) throws SystemException {
		try{
		// TODO Auto-generated method stub
		if (basket.containsKey(item.getProductCode())) {

			Item item1 = basket.get(item.getProductCode());

			item1.setPrice(item1.getPrice().add(item.getPrice()));

			item1.setQuantity(item1.getQuantity() + item.getQuantity());

			LOGGER.info("Existing item in basket updated =>"+item.getProductCode());
			return true;

		}

		basket.put(item.getProductCode(), item);
		LOGGER.info("New item added to basket");
		return false;
		}
		catch(Exception e)
		{
			throw new SystemException("Exception in adding item to basket-"+e.getMessage());
		}

	}

	/**
	 * This method is used to remove items from the basket.
	 *
	 * @param item
	 *            This is the paramter to addItemToBasket method
	 * @return boolean returns true if item already exits.
	 * @throws SystemException
	 */
	@Override
	public boolean removeItemFromBasket(Item item) throws ItemNotFoundException, SystemException {
try{

		if (basket.containsKey(item.getProductCode())) {

			basket.remove(item.getProductCode());
			LOGGER.info("Item removed from basket =>"+item.getProductCode());
			return true;

		} else
		{
			LOGGER.severe("Item not found => "+item.getProductCode());
			throw new ItemNotFoundException(

			"Item with ID - " + item.getProductCode() + " and name -"
					+ item.getProductName() + " is not Found.");
		}
	}
	catch(Exception e)
	{
		throw new SystemException("Exception in adding item to basket-"+e.getMessage());
	}

	}

	/**
	 * This method is used to calculate the total cost of items in the basket.
	 *
	 * @return Bigdecimal returns the total of all the items in the basket.
	 * @throws SystemException
	 */
	@Override
	public BigDecimal calculateTotalCost() throws SystemException {
		try{
		// TODO Auto-generated method stub
		BigDecimal totalCost = new BigDecimal(0.0);

		Iterator<Item> itrBasket = basket.values().iterator();

		while (itrBasket.hasNext()) {
			totalCost = totalCost.add(itrBasket.next().getPrice());

		}
		LOGGER.info("Total cost of items in the basket=> "+totalCost);
		return totalCost;
		}
		catch(Exception e)
		{
			throw new SystemException("Exception in adding item to basket-"+e.getMessage());
		}
	}

}
