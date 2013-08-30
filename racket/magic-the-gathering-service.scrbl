
#lang scribble/manual
 
@title{magic-the-gathering-service}
@author{author+email "" ""}

@section{Structs}
 
Access information about Magic the Gathering Cards.


@defproc[(make-card [id string?]
			[name string?]
			[mana-cost (listof string?)]
			[converted-mana-cost string?]
			[types (listof string?)]
			[texts (listof string?)]
			[flavors (listof list(string)?)]
			[power string?]
			[toughness string?]
			[watermark string?]
			[set string?]
			[rarity string?]
			[all-sets (listof print?)]
			[number string?]
			[artist string?]
			[rating string?]
			[votes string?]) card]{

A Magic the Gathering Card
@itemlist[

			@item{@racket[id] --- A unique id that identifies this card.}

			@item{@racket[name] --- The name of this card.}

			@item{@racket[mana-cost] --- The Mana cost of this card.}

			@item{@racket[converted-mana-cost] --- The converted mana cost.}

			@item{@racket[types] --- Card's types, usually at least one of "artifact", "creature", "enchantment", "instant", "land", "planeswalker", "sorcery", or "tribal". Cards can also have a supertype and/or subtype. }

			@item{@racket[texts] --- Any text blocks on the card.}

			@item{@racket[flavors] --- Any flavor texts on this card.}

			@item{@racket[power] --- The power (http://mtg.wikia.com/wiki/Power) of this card}

			@item{@racket[toughness] --- The toughness (http://mtg.wikia.com/wiki/Toughness) of this card}

			@item{@racket[watermark] --- The watermark of this card}

			@item{@racket[set] --- The expansion set that this card belongs to.}

			@item{@racket[rarity] --- How rare this card is, typically either "uncommon", "common", or "rare".}

			@item{@racket[all-sets] --- All the expansion sets that this belongs to.}

			@item{@racket[number] --- The Card Number.}

			@item{@racket[artist] --- The name of the artist for the card's artwork.}

			@item{@racket[rating] --- The card's voted upon rating.}

			@item{@racket[votes] --- The number of times this card has been voted on.}]}

@defproc[(make-print [set string?]
			[id string?]) print]{

The print expansion this belongs to.
@itemlist[

			@item{@racket[set] --- The ID code of this set.}

			@item{@racket[id] --- The unique id number of this set.}]}



@section{Functions}

@defproc[(disconnect-magic-the-gathering-service ) void]{

Establishes that data will be retrieved locally.
@itemlist[

		]}

@defproc[(connect-magic-the-gathering-service ) void]{

Establishes that the online service will be used.
@itemlist[

		]}

@defproc[(get-card [id number?]) card?]{

Retrieves a card by looking up its ID.
@itemlist[

			@item{@racket[id] --- The unique id number of the card.}]}

@defproc[(search-cards [keyword string?]) (listof card?)]{

Searches the database for cards with the keyword in the card's name.
@itemlist[

			@item{@racket[keyword] --- The search term to find this card.}]}

