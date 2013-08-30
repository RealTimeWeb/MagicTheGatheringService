package realtimeweb.magicthegatheringservice.structured;

import realtimeweb.magicthegatheringservice.main.AbstractMagicTheGatheringService;
import realtimeweb.magicthegatheringservice.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import com.google.gson.Gson;
import realtimeweb.magicthegatheringservice.json.JsonMagicTheGatheringService;
import realtimeweb.magicthegatheringservice.json.JsonGetCardListener;
import realtimeweb.magicthegatheringservice.json.JsonSearchCardsListener;

/**
 * Used to get data as built-in Java objects (HashMap, ArrayList, etc.).
 */
public class StructuredMagicTheGatheringService implements AbstractMagicTheGatheringService {
	private static StructuredMagicTheGatheringService instance;
	private JsonMagicTheGatheringService jsonInstance;
	private Gson gson;
	/**
	 * **For internal use only!** Protected Constructor guards against instantiation.
	
	 * @return 
	 */
	protected  StructuredMagicTheGatheringService() {
		this.jsonInstance = JsonMagicTheGatheringService.getInstance();
		this.gson = new Gson();
	}
	
	/**
	 * Retrieves the singleton instance.
	
	 * @return StructuredMagicTheGatheringService
	 */
	public static StructuredMagicTheGatheringService getInstance() {
		if (instance == null) {
			synchronized (StructuredMagicTheGatheringService.class) {
				if (instance == null) {
					instance = new StructuredMagicTheGatheringService();
				}
			}
			
		}
		return instance;
	}
	
	/**
	 * Establishes a connection to the online service. Requires an internet connection.
	
	 */
	@Override
	public void connect() {
		jsonInstance.connect();
	}
	
	/**
	 * Establishes that Business Search data should be retrieved locally. This does not require an internet connection.<br><br>If data is being retrieved locally, you must be sure that your parameters match locally stored data. Otherwise, you will get nothing in return.
	
	 */
	@Override
	public void disconnect() {
		jsonInstance.disconnect();
	}
	
	/**
	 * Retrieves a card by looking up its ID.
	 * @param id The unique id number of the card.
	 * @return HashMap<String, Object>
	 */
	public HashMap<String, Object> getCard(int id) throws Exception {
		return gson.fromJson(jsonInstance.getCard(id), LinkedHashMap.class);
	}
	
	/**
	 * Retrieves a card by looking up its ID.
	 * @param id The unique id number of the card.
	 * @param callback The listener that will be given the data (or error)
	 */
	public void getCard(int id, final StructuredGetCardListener callback) {
		
		jsonInstance.getCard(id, new JsonGetCardListener() {
		    @Override
		    public void getCardFailed(Exception exception) {
		        callback.getCardFailed(exception);
		    }
		    
		    @Override
		    public void getCardCompleted(String data) {
		        callback.getCardCompleted(gson.fromJson(data, LinkedHashMap.class));
		    }
		});
		
	}
	
	/**
	 * Searches the database for cards with the keyword in the card's name.
	 * @param keyword The search term to find this card.
	 * @return HashMap<String, Object>
	 */
	public ArrayList searchCards(String keyword) throws Exception {
		return gson.fromJson(jsonInstance.searchCards(keyword), ArrayList.class);
	}
	
	/**
	 * Searches the database for cards with the keyword in the card's name.
	 * @param keyword The search term to find this card.
	 * @param callback The listener that will be given the data (or error)
	 */
	public void searchCards(String keyword, final StructuredSearchCardsListener callback) {
		
		jsonInstance.searchCards(keyword, new JsonSearchCardsListener() {
		    @Override
		    public void searchCardsFailed(Exception exception) {
		        callback.searchCardsFailed(exception);
		    }
		    
		    @Override
		    public void searchCardsCompleted(String data) {
		        callback.searchCardsCompleted(gson.fromJson(data, ArrayList.class));
		    }
		});
		
	}
	
}
