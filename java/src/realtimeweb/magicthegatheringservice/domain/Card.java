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
 * A Magic the Gathering Card
 */
public class Card {
	
	
	private String id;
	private String name;
	private ArrayList<String> manaCost;
	private String convertedManaCost;
	private ArrayList<String> types;
	private ArrayList<String> texts;
	private ArrayList<String> flavors;
	private String power;
	private String toughness;
	private String watermark;
	private String set;
	private String rarity;
	private ArrayList<Print> allSets;
	private String number;
	private String artist;
	private String rating;
	private String votes;
	
	
	/**
	 * A unique id that identifies this card.
	
	 * @return String
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * 
	 * @param id A unique id that identifies this card.
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * The name of this card.
	
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @param name The name of this card.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * The Mana cost of this card.
	
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getManaCost() {
		return this.manaCost;
	}
	
	/**
	 * 
	 * @param manaCost The Mana cost of this card.
	 */
	public void setManaCost(ArrayList<String> manaCost) {
		this.manaCost = manaCost;
	}
	
	/**
	 * The converted mana cost.
	
	 * @return String
	 */
	public String getConvertedManaCost() {
		return this.convertedManaCost;
	}
	
	/**
	 * 
	 * @param convertedManaCost The converted mana cost.
	 */
	public void setConvertedManaCost(String convertedManaCost) {
		this.convertedManaCost = convertedManaCost;
	}
	
	/**
	 * Card's types, usually at least one of "artifact", "creature", "enchantment", "instant", "land", "planeswalker", "sorcery", or "tribal". Cards can also have a supertype and/or subtype. 
	
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getTypes() {
		return this.types;
	}
	
	/**
	 * 
	 * @param types Card's types, usually at least one of "artifact", "creature", "enchantment", "instant", "land", "planeswalker", "sorcery", or "tribal". Cards can also have a supertype and/or subtype. 
	 */
	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}
	
	/**
	 * Any text blocks on the card.
	
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getTexts() {
		return this.texts;
	}
	
	/**
	 * 
	 * @param texts Any text blocks on the card.
	 */
	public void setTexts(ArrayList<String> texts) {
		this.texts = texts;
	}
	
	/**
	 * Any flavor texts on this card.
	
	 * @return ArrayList<list(string)>
	 */
	public ArrayList<String> getFlavors() {
		return this.flavors;
	}
	
	/**
	 * 
	 * @param flavors Any flavor texts on this card.
	 */
	public void setFlavors(ArrayList<String> flavors) {
		this.flavors = flavors;
	}
	
	/**
	 * The power (http://mtg.wikia.com/wiki/Power) of this card
	
	 * @return String
	 */
	public String getPower() {
		return this.power;
	}
	
	/**
	 * 
	 * @param power The power (http://mtg.wikia.com/wiki/Power) of this card
	 */
	public void setPower(String power) {
		this.power = power;
	}
	
	/**
	 * The toughness (http://mtg.wikia.com/wiki/Toughness) of this card
	
	 * @return String
	 */
	public String getToughness() {
		return this.toughness;
	}
	
	/**
	 * 
	 * @param toughness The toughness (http://mtg.wikia.com/wiki/Toughness) of this card
	 */
	public void setToughness(String toughness) {
		this.toughness = toughness;
	}
	
	/**
	 * The watermark of this card
	
	 * @return String
	 */
	public String getWatermark() {
		return this.watermark;
	}
	
	/**
	 * 
	 * @param watermark The watermark of this card
	 */
	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}
	
	/**
	 * The expansion set that this card belongs to.
	
	 * @return String
	 */
	public String getSet() {
		return this.set;
	}
	
	/**
	 * 
	 * @param set The expansion set that this card belongs to.
	 */
	public void setSet(String set) {
		this.set = set;
	}
	
	/**
	 * How rare this card is, typically either "uncommon", "common", or "rare".
	
	 * @return String
	 */
	public String getRarity() {
		return this.rarity;
	}
	
	/**
	 * 
	 * @param rarity How rare this card is, typically either "uncommon", "common", or "rare".
	 */
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	
	/**
	 * All the expansion sets that this belongs to.
	
	 * @return ArrayList<Print>
	 */
	public ArrayList<Print> getAllSets() {
		return this.allSets;
	}
	
	/**
	 * 
	 * @param allSets All the expansion sets that this belongs to.
	 */
	public void setAllSets(ArrayList<Print> allSets) {
		this.allSets = allSets;
	}
	
	/**
	 * The Card Number.
	
	 * @return String
	 */
	public String getNumber() {
		return this.number;
	}
	
	/**
	 * 
	 * @param number The Card Number.
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * The name of the artist for the card's artwork.
	
	 * @return String
	 */
	public String getArtist() {
		return this.artist;
	}
	
	/**
	 * 
	 * @param artist The name of the artist for the card's artwork.
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	/**
	 * The card's voted upon rating.
	
	 * @return String
	 */
	public String getRating() {
		return this.rating;
	}
	
	/**
	 * 
	 * @param rating The card's voted upon rating.
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	/**
	 * The number of times this card has been voted on.
	
	 * @return String
	 */
	public String getVotes() {
		return this.votes;
	}
	
	/**
	 * 
	 * @param votes The number of times this card has been voted on.
	 */
	public void setVotes(String votes) {
		this.votes = votes;
	}
	
	
	
	/**
	 * A Magic the Gathering Card
	
	 * @return String
	 */
	public String toString() {
		return "Card[" + id + ", " + name + ", " + manaCost + ", " + convertedManaCost + ", " + types + ", " + texts + ", " + flavors + ", " + power + ", " + toughness + ", " + watermark + ", " + set + ", " + rarity + ", " + allSets + ", " + number + ", " + artist + ", " + rating + ", " + votes + "]";
	}
	
	/**
	 * Internal constructor to create a Card from a Json representation.
	 * @param json The raw json data that will be parsed.
	 * @param gson The Gson parser. See <a href='https://code.google.com/p/google-gson/'>https://code.google.com/p/google-gson/</a> for more information.
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public  Card(JsonObject json, Gson gson) {
		this.id = json.get("id").getAsString();
		this.name = json.get("name").getAsString();
		this.manaCost = gson.fromJson(json.get("mana").getAsJsonArray(), ArrayList.class);
		this.convertedManaCost = json.get("cmc").getAsString();
		this.types = gson.fromJson(json.get("type").getAsJsonArray(), ArrayList.class);
		this.texts = gson.fromJson(json.get("text").getAsJsonArray(), ArrayList.class);
		if (json.get("flavor").getAsJsonArray().size() > 0) {
			this.flavors = gson.fromJson(json.get("flavor").getAsJsonArray().get(0).getAsJsonArray(), ArrayList.class);
		} else {
			this.flavors = new ArrayList<String>();
		}
		this.power = json.get("power").getAsString();
		this.toughness = json.get("power").getAsString();
		this.watermark = json.get("watermark").getAsString();
		this.set = json.get("set").getAsString();
		this.rarity = json.get("rarity").getAsString();
		JsonArray js = json.get("prints").getAsJsonArray();
		this.allSets = new ArrayList<Print>(); 
		for (int i = 0; i < js.size(); i += 1) {
			this.allSets.add(new Print(js.get(i).getAsJsonObject(), gson));
		}
		this.number = json.get("number").getAsString();
		this.artist = json.get("artist").getAsString();
		this.rating = json.get("rating").getAsString();
		this.votes = json.get("votes").getAsString();
	}
	
	/**
	 * Regular constructor to create a Card.
	 * @param id A unique id that identifies this card.
	 * @param name The name of this card.
	 * @param manaCost The Mana cost of this card.
	 * @param convertedManaCost The converted mana cost.
	 * @param types Card's types, usually at least one of "artifact", "creature", "enchantment", "instant", "land", "planeswalker", "sorcery", or "tribal". Cards can also have a supertype and/or subtype. 
	 * @param texts Any text blocks on the card.
	 * @param flavors Any flavor texts on this card.
	 * @param power The power (http://mtg.wikia.com/wiki/Power) of this card
	 * @param toughness The toughness (http://mtg.wikia.com/wiki/Toughness) of this card
	 * @param watermark The watermark of this card
	 * @param set The expansion set that this card belongs to.
	 * @param rarity How rare this card is, typically either "uncommon", "common", or "rare".
	 * @param allSets All the expansion sets that this belongs to.
	 * @param number The Card Number.
	 * @param artist The name of the artist for the card's artwork.
	 * @param rating The card's voted upon rating.
	 * @param votes The number of times this card has been voted on.
	 * @return 
	 */
	public  Card(String id, String name, ArrayList<String> manaCost, String convertedManaCost, ArrayList<String> types, ArrayList<String> texts, ArrayList<String> flavors, String power, String toughness, String watermark, String set, String rarity, ArrayList<Print> allSets, String number, String artist, String rating, String votes) {
		this.id = id;
		this.name = name;
		this.manaCost = manaCost;
		this.convertedManaCost = convertedManaCost;
		this.types = types;
		this.texts = texts;
		this.flavors = flavors;
		this.power = power;
		this.toughness = toughness;
		this.watermark = watermark;
		this.set = set;
		this.rarity = rarity;
		this.allSets = allSets;
		this.number = number;
		this.artist = artist;
		this.rating = rating;
		this.votes = votes;
	}
	
}
