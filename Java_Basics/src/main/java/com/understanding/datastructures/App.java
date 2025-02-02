package Java_Basics.src.main.java.com.understanding.datastructures;

import Java_Basics.src.main.java.com.understanding.datastructures.Design.FoodRatings;

public class App
{
    public static void main( String[] args )
    {
        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}
        ,new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});

        foodRatings.highestRated("korean");
        foodRatings.highestRated("japanese");
        foodRatings.changeRating("sushi", 16);
        foodRatings.highestRated("japanese");
        foodRatings.changeRating("ramen", 16);
        foodRatings.highestRated("japanese");
    }
    
}
