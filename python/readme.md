Usage is simple:

    import regular as mtgservice

    cardList = mtgservice.search_cards("skeleton")

    for card in cardList:
        print card.name
