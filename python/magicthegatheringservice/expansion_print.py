class ExpansionPrint(object):
    """
    The print expansion this belongs to.
    """
    def __init__(self, set, id):
        """
        Creates a new Print
        
        :param self: This object
        :type self: Print
        :param set: The ID code of this set.
        :type set: string
        :param id: The unique id number of this set.
        :type id: string
        :returns: Print
        """
        self.set = set
        self.id = id
    
    @staticmethod
    def _from_json(json_data):
        """
        Creates a Print from json data.
        
        :param json_data: The raw json data to parse
        :type json_data: dict
        :returns: Print
        """
        return ExpansionPrint(json_data['set'],
                              json_data['id'])