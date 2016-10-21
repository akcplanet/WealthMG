package test.java;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import main.java.dto.Item;
import main.java.exceptions.ItemNotFoundException;
import main.java.exceptions.SystemException;
import main.java.service.FruitsInventoryService;
import main.java.service.implementations.FruitsInventoryServiceImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class FruitsInventoryTest.
 */
public class FruitsInventoryTest {

 	/** The fruits service. */
 	FruitsInventoryService fruitsService = new FruitsInventoryServiceImpl();

 	Item banana,oranges,apples,lemons,peaches,banana2;


 /**
  * Fill basket.
  */
 @Before
 public void fillBasket() {

	 banana= new Item("Banana",10,3,new BigDecimal(13.5));
	 oranges= new Item("Oranges",20,5,new BigDecimal(25));
	 apples= new Item("Apples",30,6,new BigDecimal(100));
	 lemons= new Item("Lemons",40,10,new BigDecimal(50));
	 peaches= new Item("Peaches",50,50,new BigDecimal(75.5));
	 banana2= new Item("Banana",10,7,new BigDecimal(60));

 }

 /**
  * No tear down.
  */
 @After
 public void clearData() {
	 fruitsService = null;
	 banana=oranges=apples=lemons=peaches=banana2=null;
 }

 /**
  * Adds the different itemsto basket test.
 * @throws SystemException
  */
 @Test
 public void addDifferentItemstoBasketTest() throws SystemException {

   assertEquals(fruitsService.addItemToBasket(banana), Boolean.FALSE);
   assertEquals(fruitsService.addItemToBasket(oranges), Boolean.FALSE);
   assertEquals(fruitsService.addItemToBasket(apples), Boolean.FALSE);
   assertEquals(fruitsService.addItemToBasket(peaches), Boolean.FALSE);
   assertEquals(fruitsService.addItemToBasket(lemons), Boolean.FALSE);

 }

 /**
  * Adds the similar itemsto basket test.
 * @throws SystemException
  */
 @Test
 public void addSimilarItemstoBasketTest() throws SystemException {



   assertEquals(fruitsService.addItemToBasket(banana), Boolean.FALSE);
   assertEquals(fruitsService.addItemToBasket(oranges), Boolean.FALSE);
   assertEquals(fruitsService.addItemToBasket(banana2), Boolean.TRUE);


 }

 /**
  * Removes the itemsfrom basket test.
  *
  * @throws ItemNotFoundException the item not found exception
 * @throws SystemException
  */
 @Test
 public void removeItemsfromBasketTest() throws ItemNotFoundException, SystemException {

   assertEquals(fruitsService.addItemToBasket(banana), Boolean.FALSE);
   assertEquals(fruitsService.addItemToBasket(oranges), Boolean.FALSE);
   assertEquals(fruitsService.addItemToBasket(banana2), Boolean.TRUE);

   assertEquals(fruitsService.removeItemFromBasket(banana2),Boolean.TRUE);

 }

 /**
  * Calculate total cost test.
  *
  * @throws ItemNotFoundException the item not found exception
 * @throws SystemException
  */
 @Test
 public void calculateTotalCostTest() throws ItemNotFoundException, SystemException {


   assertEquals(fruitsService.addItemToBasket(banana), Boolean.FALSE);
   assertEquals(fruitsService.addItemToBasket(apples), Boolean.FALSE);
   assertEquals(fruitsService.addItemToBasket(banana2), Boolean.TRUE);
   assertEquals(fruitsService.calculateTotalCost().doubleValue(), banana.getPrice().add(apples.getPrice()).doubleValue(),0.0);


 }


}

