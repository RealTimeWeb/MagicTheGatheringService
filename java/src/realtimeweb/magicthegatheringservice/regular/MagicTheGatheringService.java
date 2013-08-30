package realtimeweb.magicthegatheringservice.regular;

import realtimeweb.magicthegatheringservice.main.AbstractMagicTheGatheringService;
import realtimeweb.magicthegatheringservice.json.JsonMagicTheGatheringService;
import realtimeweb.magicthegatheringservice.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import realtimeweb.magicthegatheringservice.domain.Card;
import realtimeweb.magicthegatheringservice.json.JsonGetCardListener;
import realtimeweb.magicthegatheringservice.json.JsonSearchCardsListener;

/**
 * Used to get data as classes.
 */
public class MagicTheGatheringService implements AbstractMagicTheGatheringService {
	private static MagicTheGatheringService instance;
	private JsonMagicTheGatheringService jsonInstance;
	private Gson gson;
	/**
	 * **For internal use only!** Protected Constructor guards against instantiation.
	
	 * @return 
	 */
	protected  MagicTheGatheringService() {
		this.jsonInstance = JsonMagicTheGatheringService.getInstance();
		this.gson = new Gson();
	}
	
	/**
	 * Retrieves the singleton instance.
	
	 * @return MagicTheGatheringService
	 */
	public static MagicTheGatheringService getInstance() {
		if (instance == null) {
			synchronized (MagicTheGatheringService.class) {
				if (instance == null) {
					instance = new MagicTheGatheringService();
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
	 * @return Card
	 */
	public Card getCard(int id) throws Exception {
		String response = jsonInstance.getCard(id);
		JsonParser parser = new JsonParser();
		JsonObject top = parser.parse(response).getAsJsonObject();
		return new Card(top, gson);
	}
	
	/**
	 * Retrieves a card by looking up its ID.
	 * @param id The unique id number of the card.
	 * @param callback The listener that will receive the data (or error).
	 */
	public void getCard(int id, final GetCardListener callback) {
		
		jsonInstance.getCard(id, new JsonGetCardListener() {
		    @Override
		    public void getCardFailed(Exception exception) {
		        callback.getCardFailed(exception);
		    }
		    
		    @Override
		    public void getCardCompleted(String response) {
		        JsonParser parser = new JsonParser();
		JsonObject top = parser.parse(response).getAsJsonObject();
		        Card result = new Card(top, gson);
		        callback.getCardCompleted(result);
		    }
		});
		
	}
	
	/**
	 * Searches the database for cards with the keyword in the card's name.
	 * @param keyword The search term to find this card.
	 * @return ArrayList<Card>
	 */
	public ArrayList<Card> searchCards(String keyword) throws Exception {
		String response = jsonInstance.searchCards(keyword);
		JsonParser parser = new JsonParser();
		JsonArray allChildren = parser.parse(response).getAsJsonArray();
		ArrayList<Card> result = new ArrayList<Card>();
		for (int i = 0; i < allChildren.size(); i += 1) {
			result.add(new Card(allChildren.get(i).getAsJsonObject(), gson));
		}
		return result;
	}
	
	/**
	 * Searches the database for cards with the keyword in the card's name.
	 * @param keyword The search term to find this card.
	 * @param callback The listener that will receive the data (or error).
	 */
	public void searchCards(String keyword, final SearchCardsListener callback) {
		
		jsonInstance.searchCards(keyword, new JsonSearchCardsListener() {
		    @Override
		    public void searchCardsFailed(Exception exception) {
		        callback.searchCardsFailed(exception);
		    }
		    
		    @Override
		    public void searchCardsCompleted(String response) {
		        JsonParser parser = new JsonParser();
		      JsonArray allChildren = parser.parse(response).getAsJsonArray();
		        ArrayList<Card> result = new ArrayList<Card>();
		        for (int i = 0; i < allChildren.size(); i += 1) {
		            result.add(new Card(allChildren.get(i).getAsJsonObject(), gson));
		        }
		        callback.searchCardsCompleted(result);
		    }
		});
		
	}
	
}
