package Java_Basics.src.main.java.com.understanding.datastructures.Design;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;
public class FoodRatings {
    Map<String,Food> foodMap;
    Map<String,PriorityQueue<Food>> cuisineMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        cuisineMap = new HashMap<>();
        for(int i = 0; i < foods.length; i++){
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(food.foodName, food);

            if(!cuisineMap.containsKey(food.cuisine))
                cuisineMap.put(food.cuisine, new PriorityQueue<>(new FoodComparator()));

            cuisineMap.get(food.cuisine).offer(food);
        }
    }

    public void changeRating(String food, int newRating) {
        if(foodMap.containsKey(food)){
            Food foodObj = foodMap.get(food);
            foodObj.rating = newRating;
            cuisineMap.get(foodObj.cuisine).remove(foodObj);
            cuisineMap.get(foodObj.cuisine).offer(foodObj);
        }
    }

    public String highestRated(String cuisine) {
        if(cuisineMap.containsKey(cuisine)){
            PriorityQueue<Food> pq = cuisineMap.get(cuisine);
            while(!pq.isEmpty() && pq.peek().rating != foodMap.get(pq.peek().foodName).rating)
                pq.poll();

            return pq.peek().foodName;
        }

        return null;
    }

    public class Food{
        String foodName;
        String cuisine;
        int rating;

        public Food(String food, String cuisine, int rating){
            this.foodName = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    public class FoodComparator implements Comparator<Food> {
        public int compare(Food a, Food b){
            if(a.rating == b.rating){
                return a.foodName.compareTo(b.foodName);
            }else{
                return b.rating - a.rating;
            }
        }
    }
}