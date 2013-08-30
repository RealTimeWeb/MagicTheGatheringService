import requests
import json
import threading
from _cache import _recursively_convert_unicode_to_str, lookup
from card import Card
import structured
def connect():
    """
    Connect to the online data source in order to get up-to-date information.
    
    :returns: void
    """
    structured.connect()
def disconnect():
    """
    Connect to the local cache, so no internet connection is required.
    
    :returns: void
    """
    structured.disconnect()
def get_card(id):
    """
    Retrieves a card by looking up its ID.
    
    :param id: The unique id number of the card.
    :type id: integer
    :returns: Card
    """
    return Card._from_json(structured.get_card(id))

def get_card_async(callback, error_callback, id):
    """
    Asynchronous version of get_card
    
    :param callback: Function that consumes the data (a Card) returned on success.
    :type callback: function
    :param error_callback: Function that consumes the exception returned on failure.
    :type error_callback: function
    :param id: The unique id number of the card.
    :type id: integer
    :returns: void
    """
    def server_call(callback, error_callback, id):
        """
        Internal closure to thread this call.
        
        :param callback: Function that consumes the data (a Card) returned on success.
        :type callback: function
        :param error_callback: Function that consumes the exception returned on failure.
        :type error_callback: function
        :param id: The unique id number of the card.
        :type id: integer
        :returns: void
        """
        try:
            callback(get_card(id))
        except Exception, e:
            error_callback(e)
    threading.Thread(target=server_call, args = (id,)).start()

def search_cards(keyword):
    """
    Searches the database for cards with the keyword in the card's name.
    
    :param keyword: The search term to find this card.
    :type keyword: string
    :returns: listof Card
    """
    return map(Card._from_json, structured.search_cards(keyword))

def search_cards_async(callback, error_callback, keyword):
    """
    Asynchronous version of search_cards
    
    :param callback: Function that consumes the data (a listof Card) returned on success.
    :type callback: function
    :param error_callback: Function that consumes the exception returned on failure.
    :type error_callback: function
    :param keyword: The search term to find this card.
    :type keyword: string
    :returns: void
    """
    def server_call(callback, error_callback, keyword):
        """
        Internal closure to thread this call.
        
        :param callback: Function that consumes the data (a listof Card) returned on success.
        :type callback: function
        :param error_callback: Function that consumes the exception returned on failure.
        :type error_callback: function
        :param keyword: The search term to find this card.
        :type keyword: string
        :returns: void
        """
        try:
            callback(search_cards(keyword))
        except Exception, e:
            error_callback(e)
    threading.Thread(target=server_call, args = (keyword,)).start()

