Usage is simple:

    MagicTheGatheringService mtgs = MagicTheGatheringService.getInstance();
    mtgs.connect(); // You can disconnect if you have a local cache you made!
    ArrayList<Card> cards = mtgs.searchCards("skeleton"); // And there you have the data
