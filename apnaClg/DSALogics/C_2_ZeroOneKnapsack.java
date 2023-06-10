package DSALogics;

import java.util.Arrays;
import java.util.Comparator;

import DSALogics.C_1_FractionalKnapsack.ItemValue;

public class C_2_ZeroOneKnapsack {

	static class ItemValue{
		int profit;
		int weight;
		
		public ItemValue(int profit, int weight) {
			this.profit = profit;
			this.weight = weight;
		}
		
	}
	
	public static int getMaxProfit(ItemValue[] items, int capacity) {
		Arrays.sort(items, new Comparator<ItemValue>() {

			@Override
			public int compare(ItemValue o1, ItemValue o2) {
				int ratio1 = o1.profit/o1.weight;
				int ratio2 = o2.profit/o2.weight;
				return ratio2 - ratio1;
			}
			
		});
		
		int remainingCapacity = capacity;
		int totalValue = 0; 
		
		for(ItemValue item : items) {
			if(item.weight <= remainingCapacity) {
				totalValue += item.profit;
				remainingCapacity -= item.weight;
			}
		}
		return totalValue;
	}
	
	
	public static void main(String[] args) {
		ItemValue[] items = new ItemValue[]{
				new ItemValue(60,10),
				new ItemValue(100,20),
				new ItemValue(120,30)
		};
		
		int capacity = 50;
		int maxProfit = getMaxProfit(items,capacity);
		System.out.println(maxProfit);
	}

}
