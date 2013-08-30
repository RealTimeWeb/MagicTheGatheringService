from print import Print
from list(string) import List(String)
class Card(object):
    """
    A Magic the Gathering Card
    """
    def __init__(self, id, name, mana_cost, converted_mana_cost, types, texts, flavors, power, toughness, watermark, set, rarity, all_sets, number, artist, rating, votes):
        """
        Creates a new Card
        
        :param self: This object
        :type self: Card
        :param id: A unique id that identifies this card.
        :type id: string
        :param name: The name of this card.
        :type name: string
        :param mana_cost: The Mana cost of this card.
        :type mana_cost: listof string
        :param converted_mana_cost: The converted mana cost.
        :type converted_mana_cost: string
        :param types: Card's types, usually at least one of "artifact", "creature", "enchantment", "instant", "land", "planeswalker", "sorcery", or "tribal". Cards can also have a supertype and/or subtype. 
        :type types: listof string
        :param texts: Any text blocks on the card.
        :type texts: listof string
        :param flavors: Any flavor texts on this card.
        :type flavors: listof List(String)
        :param power: The power (http://mtg.wikia.com/wiki/Power) of this card
        :type power: string
        :param toughness: The toughness (http://mtg.wikia.com/wiki/Toughness) of this card
        :type toughness: string
        :param watermark: The watermark of this card
        :type watermark: string
        :param set: The expansion set that this card belongs to.
        :type set: string
        :param rarity: How rare this card is, typically either "uncommon", "common", or "rare".
        :type rarity: string
        :param all_sets: All the expansion sets that this belongs to.
        :type all_sets: listof Print
        :param number: The Card Number.
        :type number: string
        :param artist: The name of the artist for the card's artwork.
        :type artist: string
        :param rating: The card's voted upon rating.
        :type rating: string
        :param votes: The number of times this card has been voted on.
        :type votes: string
        :returns: Card
        """
        self.id = id
        self.name = name
        self.mana_cost = mana_cost
        self.converted_mana_cost = converted_mana_cost
        self.types = types
        self.texts = texts
        self.flavors = flavors
        self.power = power
        self.toughness = toughness
        self.watermark = watermark
        self.set = set
        self.rarity = rarity
        self.all_sets = all_sets
        self.number = number
        self.artist = artist
        self.rating = rating
        self.votes = votes
    
    @staticmethod
    def _from_json(json_data):
        """
        Creates a Card from json data.
        
        :param json_data: The raw json data to parse
        :type json_data: dict
        :returns: Card
        """
        return Card(json_data['id'],
                    json_data['name'],
                    json_data['mana'],
                    json_data['cmc'],
                    json_data['type'],
                    json_data['text'],
                    json_data['flavor'][0] if json_data['flavor'] else [],
                    json_data['power'],
                    json_data['power'],
                    json_data['watermark'],
                    json_data['set'],
                    json_data['rarity'],
                    map(Print._from_json, json_data['prints']),
                    json_data['number'],
                    json_data['artist'],
                    json_data['rating'],
                    json_data['votes'])