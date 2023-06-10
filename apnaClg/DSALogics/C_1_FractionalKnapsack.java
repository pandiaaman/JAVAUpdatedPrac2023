package DSALogics;

import java.util.Arrays;
import java.util.Comparator;

/*
 *	in fractional knapsack, we are given a knapsack or bag of a fixed capacity
 *we are given items with weights and respective profits
 *our motive is to add items such that we increase the total profit
 * 
 * soln : sort the array of profit/weight to get the ratio
 * traverse through each item, add the item if the item's weight is less than the remaining capacity
 * if the items weight is more than the remaining capacity then find the fraction of the item that can be added
 * add that fraction of profit to the final value
 * 
 */
public class C_1_FractionalKnapsack {

	static class ItemValue{
		int profit;
		int weight;
		
		 ItemValue(int profit, int weight) {
			this.profit = profit;
			this.weight = weight;
		}
	}
	
	public static int getMaxProfit(ItemValue[] items, int capacity) {
		
		Arrays.sort(items, new Comparator<ItemValue>() {

			@Override
			public int compare(ItemValue o1, ItemValue o2) {
				double profitRatio1 = (double) o1.profit/ (double) o1.weight;
				double profitRatio2 = (double) o2.profit/ (double) o2.weight;
				return profitRatio2 > profitRatio1? 1 : -1;
			}
			
		});
		
		double remainingCapacity = (double) capacity;
		double value = 0d;
		
		for(ItemValue item : items) {
			System.out.println(item.weight + " -> " + item.profit);
			if(item.weight <= remainingCapacity) {
				
				value += (double) item.profit;
				remainingCapacity -= (double) item.weight;
			}
			else {
				
				value += (double) (item.profit) * (remainingCapacity)/ (double) (item.weight);
				remainingCapacity -= (double) (item.weight) * (remainingCapacity)/(double)(item.weight);
			}
			
			System.out.println("adding item :" + item.weight + " with profit :" + item.profit + " remaining capacity :" + remainingCapacity + " value :" + value);
		}
		

		
		return (int)value;
	}
	
	public static void main(String[] args) {
		ItemValue[] items = new ItemValue[]{
				new ItemValue(60,10),
				new ItemValue(100,20),
				new ItemValue(120,30)
		};

		int capacity = 50;
		
		int maxProfit = getMaxProfit(items, capacity);
		System.out.println(maxProfit);
	}

}
