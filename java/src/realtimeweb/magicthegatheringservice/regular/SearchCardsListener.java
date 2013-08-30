package realtimeweb.magicthegatheringservice.regular;

import java.util.ArrayList;
import java.util.HashMap;
import realtimeweb.magicthegatheringservice.domain.Card;
/**
 * A listener for the searchCards method. On success, passes the data into the searchCardsCompleted method. On failure, passes the exception to the searchCardsFailed method.
 */
public interface SearchCardsListener {
	/**
	 * 
	 * @param data The method that should be overridden to handle the data if the method was successful.
	 */
	public abstract void searchCardsCompleted(ArrayList<Card> data);
	/**
	 * 
	 * @param error The method that should be overridden to handle an exception that occurred while getting the SearchResponse.
	 */
	public abstract void searchCardsFailed(Exception error);
}
