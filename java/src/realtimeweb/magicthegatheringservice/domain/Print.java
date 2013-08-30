package realtimeweb.magicthegatheringservice.domain;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * The print expansion this belongs to.
 */
public class Print {
	
	
	private String set;
	private String id;
	
	
	/**
	 * The ID code of this set.
	
	 * @return String
	 */
	public String getSet() {
		return this.set;
	}
	
	/**
	 * 
	 * @param set The ID code of this set.
	 */
	public void setSet(String set) {
		this.set = set;
	}
	
	/**
	 * The unique id number of this set.
	
	 * @return String
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * 
	 * @param id The unique id number of this set.
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	/**
	 * The print expansion this belongs to.
	
	 * @return String
	 */
	public String toString() {
		return "Print[" + set + ", " + id + "]";
	}
	
	/**
	 * Internal constructor to create a Print from a Json representation.
	 * @param json The raw json data that will be parsed.
	 * @param gson The Gson parser. See <a href='https://code.google.com/p/google-gson/'>https://code.google.com/p/google-gson/</a> for more information.
	 * @return 
	 */
	public  Print(JsonObject json, Gson gson) {
		this.set = json.get("set").getAsString();
		this.id = json.get("id").getAsString();
	}
	
	/**
	 * Regular constructor to create a Print.
	 * @param set The ID code of this set.
	 * @param id The unique id number of this set.
	 * @return 
	 */
	public  Print(String set, String id) {
		this.set = set;
		this.id = id;
	}
	
}
