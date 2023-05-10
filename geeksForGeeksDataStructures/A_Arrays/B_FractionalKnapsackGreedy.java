package A_Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class B_FractionalKnapsackGreedy {
/*
 * in this problem, we are given weights and profit combination of n elements
 * we have a bag(knapsack) with a given weight, say W
 * our motive is to fill the knapsack till brim with max profit
 */
	
	static class Item{
		private int weight;
		private int profit;
		
		public Item(int weight, int profit) {
			this.weight = weight;
			this.profit = profit;
		}
		
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public int getWeight() {
			return this.weight;
		}
		
		public void setProfit(int profit) {
			this.profit = profit;
		}
		public int getProfit() {
			return this.profit;
		}
	}
	
	public static void main(String[] args) {
		//creating items here
		Item item1 = new Item(10,60); //60/10 : 6
		Item item2 = new Item(5,55); //55/5 : 11
		Item item3 = new Item(15,80); //80/15 : 5
		Item item4 = new Item(4, 40); //40/4 : 10
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
		
		int maxCapacityWeight = 20;
		
		knapsackFractionUsingGreedyAlgo(itemList,maxCapacityWeight);
		

	}

	private static void knapsackFractionUsingGreedyAlgo(ArrayList<Item> itemList, int maxCapacity) {
		
		Collections.sort(itemList, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				//here we find the ratio of profit to weight to maximize profit at least weight
				double profitToWeightRatio1 = ((double) o1.getProfit() / (double) o1.getWeight());
				double profitToWeightRatio2 = ((double) o2.getProfit() / (double) o2.getWeight());
				
				//we swap using comparators
				
				return profitToWeightRatio1 < profitToWeightRatio2 ? 1 : -1;
			}
			
		});
		
		int currentWeight = 0;
		double maxProfit = 0;
		
		double fraction = 0;
		
		for(int i = 0; i< itemList.size(); i++) {
			if(itemList.get(i).getWeight() <= (maxCapacity - currentWeight)) {
				maxProfit += (double) itemList.get(i).getProfit();
				currentWeight += itemList.get(i).getWeight();
				System.out.println("adding item of weight " + itemList.get(i).getWeight() + " with profit " + itemList.get(i).getProfit());
			}
			else {
				//finding the fraction to add
				fraction = ((double)maxCapacity - (double)currentWeight)/((double)itemList.get(i).getWeight());
				double itemFractionProfit = fraction * (double)itemList.get(i).getProfit();;
				maxProfit += itemFractionProfit;
				currentWeight += fraction * itemList.get(i).getWeight();
				System.out.println("adding item of weight " + itemList.get(i).getWeight() + " with profit " + itemFractionProfit);
				System.out.println("bag filled weight :" + currentWeight);
				break;
			}
		}
		
		System.out.println("max profit made : " + maxProfit + " while using weight of : " + currentWeight);
	}
}
