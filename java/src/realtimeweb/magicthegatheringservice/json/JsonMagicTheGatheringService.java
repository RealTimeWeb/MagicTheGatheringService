package realtimeweb.magicthegatheringservice.json;

import realtimeweb.magicthegatheringservice.main.AbstractMagicTheGatheringService;
import java.util.HashMap;
import realtimeweb.magicthegatheringservice.util.Util;

/**
 * Used to get data as a raw string.
 */
public class JsonMagicTheGatheringService implements AbstractMagicTheGatheringService {
	private static JsonMagicTheGatheringService instance;
	protected boolean local;
	private ClientStore clientStore;
	/**
	 * **For internal use only!** Protected Constructor guards against instantiation.
	
	 * @return 
	 */
	protected  JsonMagicTheGatheringService() {
		disconnect();
		this.clientStore = new ClientStore();
	}
	
	/**
	 * Retrieves the singleton instance.
	
	 * @return JsonMagicTheGatheringService
	 */
	public static JsonMagicTheGatheringService getInstance() {
		if (instance == null) {
			synchronized (JsonMagicTheGatheringService.class) {
				if (instance == null) {
					instance = new JsonMagicTheGatheringService();
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
		this.local = false;
	}
	
	/**
	 * Establishes that Business Search data should be retrieved locally. This does not require an internet connection.<br><br>If data is being retrieved locally, you must be sure that your parameters match locally stored data. Otherwise, you will get nothing in return.
	
	 */
	@Override
	public void disconnect() {
		this.local = true;
	}
	
	/**
	 * **For internal use only!** The ClientStore is the internal cache where offline data is stored.
	
	 * @return ClientStore
	 */
	public ClientStore getClientStore() {
		return this.clientStore;
	}
	
	/**
	 * Retrieves a card by looking up its ID.
	 * @param id The unique id number of the card.
	 * @return String
	 */
	public String getCard(int id) throws Exception {
		String url = String.format("http://mtgapi.com/api/v1/fetch/id/%s", String.valueOf(id));
		HashMap<String, String> parameters = new HashMap<String, String>();
		if (this.local) {
			return clientStore.getData(Util.hashRequest(url, parameters));
		}
		String jsonResponse = "";
		try {
		    jsonResponse = Util.get(url, parameters);
		    if (jsonResponse.startsWith("<")) {
		        throw new Exception(jsonResponse);
		    }
		    return jsonResponse;
		} catch (Exception e) {
		    throw new Exception(e.toString());
		}
	}
	
	/**
	 * Retrieves a card by looking up its ID.
	 * @param id The unique id number of the card.
	 * @param callback The listener that will be given the data (or error).
	 */
	public void getCard(final int id, final JsonGetCardListener callback) {
		
		Thread thread = new Thread() {
		    @Override
		    public void run() {
		        try {
		            callback.getCardCompleted(JsonMagicTheGatheringService.getInstance().getCard(id));
		        } catch (Exception e) {
		            callback.getCardFailed(e);
		        }
		    }
		};
		thread.start();
		
	}
	
	/**
	 * Searches the database for cards with the keyword in the card's name.
	 * @param keyword The search term to find this card.
	 * @return String
	 */
	public String searchCards(String keyword) throws Exception {
		String url = String.format("http://mtgapi.com/api/v1/fetch/search/%s", String.valueOf(keyword));
		HashMap<String, String> parameters = new HashMap<String, String>();
		if (this.local) {
			return clientStore.getData(Util.hashRequest(url, parameters));
		}
		String jsonResponse = "";
		try {
		    jsonResponse = Util.get(url, parameters);
		    if (jsonResponse.startsWith("<")) {
		        throw new Exception(jsonResponse);
		    }
		    return jsonResponse;
		} catch (Exception e) {
		    throw new Exception(e.toString());
		}
	}
	
	/**
	 * Searches the database for cards with the keyword in the card's name.
	 * @param keyword The search term to find this card.
	 * @param callback The listener that will be given the data (or error).
	 */
	public void searchCards(final String keyword, final JsonSearchCardsListener callback) {
		
		Thread thread = new Thread() {
		    @Override
		    public void run() {
		        try {
		            callback.searchCardsCompleted(JsonMagicTheGatheringService.getInstance().searchCards(keyword));
		        } catch (Exception e) {
		            callback.searchCardsFailed(e);
		        }
		    }
		};
		thread.start();
		
	}
	
}
