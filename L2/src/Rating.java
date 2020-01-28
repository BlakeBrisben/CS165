/**
 * Created by garethhalladay on 8/27/17
 */
public class Rating {

    /**
     * ReviewType enum that allows users to distinguish between CRITIC, AUDIENCE, or an average of both
     */
    public enum ReviewType{CRITIC, AUDIENCE, BOTH}

    public static void main(String [] args){
        Rating noargs = new Rating();
        Rating rating1 = new Rating(30, 10, 45, 100);
        System.out.printf("Critic Score: %.0f\nNumber of Critics: %d\nAudience Score: %.0f\nNumber of people: %d\n",
                           rating1.getCriticScore(), rating1.getNumCritics(), rating1.getAudienceScore(), rating1.getNumCritics());
        System.out.println(noargs);
        System.out.println(rating1);

    }
}
