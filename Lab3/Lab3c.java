/**
 * 
 * @author mike91doby
 *
 */
public class Lab3c {

	public static void main(String[] args) {
		// create string buffers for output
		StringBuffer buffer1 = new StringBuffer();
		StringBuffer buffer2 = new StringBuffer();
		
		// create two movies
		Movie movie1 = new Movie("Rio 2", Movie.mpaaRatingEnum.G);
		Movie movie2 = new Movie("Guardians Of The Galaxy", Movie.mpaaRatingEnum.PG13);
		
		// rate first movie
		movie1.addRating(1);
		movie1.addRating(1);
		movie1.addRating(1);
		movie1.addRating(2);
		movie1.addRating(2);
		movie1.addRating(2);
		movie1.addRating(3);
		movie1.addRating(3);
		movie1.addRating(4);
		movie1.addRating(5);
		
		
		// rate second movie
		movie2.addRating(4);
		movie2.addRating(4);
		movie2.addRating(5);
		movie2.addRating(5);
		movie2.addRating(5);
		movie2.addRating(4);
		
		// format output
		buffer1.append(movie1.getMovieName());
		buffer1.append(", Rated ");
		buffer1.append(movie1.getMPAARating());
		buffer1.append(" - Averate rating: ");
		buffer1.append(String.format("%3.1f", movie1.getAverage()));
		
		buffer2.append(movie2.getMovieName());
		buffer2.append(", Rated ");
		buffer2.append(movie2.getMPAARating());
		buffer2.append(" - Averate rating: ");
		buffer2.append(String.format("%3.1f", movie2.getAverage()));
		
		// output final strings
		System.out.println(buffer1);
		System.out.println(buffer2);
	}

}
