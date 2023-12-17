import java.util.HashMap;
import java.util.PriorityQueue;

class FoodRatings {
    HashMap<String,String> foodCuisine=new HashMap<>();
    HashMap<String,Integer> foodRating=new HashMap<>();
    HashMap<String,PriorityQueue<Pair>> rating=new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i=0;i<foods.length;i++){
            if(!foodCuisine.containsKey(foods[i])){
                foodCuisine.put(foods[i],cuisines[i]);
            }
            if(!foodRating.containsKey(foods[i])){
                foodRating.put(foods[i],ratings[i]);
            }
            if(!rating.containsKey(cuisines[i])){
                rating.put(cuisines[i],new PriorityQueue<>());
            }
            rating.get(cuisines[i]).offer(new Pair(ratings[i],foods[i]));
        }

    }

    public void changeRating(String food, int newRating) {
        int oldRating=foodRating.get(food);
        foodRating.put(food,newRating);
        String cuisine=foodCuisine.get(food);
        rating.get(cuisine).remove(new Pair(oldRating,food));
        rating.get(cuisine).offer(new Pair(newRating,food));

    }

    public String highestRated(String cuisine) {
        return rating.get(cuisine).peek().food;
    }

     public static void main(String[] args) {
         String[] food={"emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"};
         String[] cuisines={"snaxol","snaxol","snaxol","fajbervsj","fajbervsj"};
         int[] rating={2,6,18,6,5};

         FoodRatings foodRatings=new FoodRatings(food,cuisines,rating);

         foodRatings.changeRating("qnvseohnoe", 11);
         System.out.println(foodRatings.highestRated("fajbervsj"));
         foodRatings.changeRating("emgqdbo",3);
         foodRatings.changeRating("jmvfxjohq",9);
         foodRatings.changeRating("emgqdbo",14);

         System.out.println(foodRatings.highestRated("fajbervsj"));

         System.out.println(foodRatings.highestRated("snaxol"));


     }
}

class Pair implements Comparable<Pair>{
    int rating;
    String food;

    public Pair(int rating,String food){
        this.rating=rating;
        this.food=food;
    }

    @Override
    public int compareTo(Pair o){
        if(this.rating == o.rating){
            return this.food.compareTo(o.food);
        }
        return -1*Integer.compare(this.rating,o.rating);
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pair))
            return false;
        Pair other = (Pair)o;

        return this.rating == other.rating && this.food==other.food;
    }
}


/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */