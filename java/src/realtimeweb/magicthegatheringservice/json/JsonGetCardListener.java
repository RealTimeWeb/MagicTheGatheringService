package realtimeweb.magicthegatheringservice.json;

import java.util.ArrayList;
import java.util.HashMap;
import realtimeweb.magicthegatheringservice.domain.Card;
/**
 * A listener for the getCard method. On success, passes the data into the getCardCompleted method. On failure, passes the exception to the getCardFailed method.
 */
public interface JsonGetCardListener {
	/**
	 * 
	 * @param data The method that should be overridden to handle the data if the method was successful.
	 */
	public abstract void getCardCompleted(String data);
	/**
	 * 
	 * @param error The method that should be overridden to handle an exception that occurred while getting the SearchResponse.
	 */
	public abstract void getCardFailed(Exception error);
}
