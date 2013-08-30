#lang racket

; Provide the external structs
(provide (struct-out card))
(provide (struct-out print))

; Provide the external functions
(provide get-card)
(provide get-card/string)
(provide get-card/json)
(provide search-cards)
(provide search-cards/string)
(provide search-cards/json)
(provide disconnect-magic-the-gathering-service)
(provide connect-magic-the-gathering-service)

; Load the internal libraries
(require net/url)
(require srfi/19)
(require srfi/6)
(require racket/port)
(require json)
(require net/uri-codec)

; Define the structs
(define-struct card (id name mana-cost converted-mana-cost types texts flavors power toughness watermark set rarity all-sets number artist rating votes))

(define-struct print (set id))

(define (json->card jdata)
	(make-card (hash-ref jdata 'id)
			(hash-ref jdata 'name)
			(hash-ref jdata 'mana)
			(hash-ref jdata 'cmc)
			(hash-ref jdata 'type)
			(hash-ref jdata 'text)
			(if (empty? (hash-ref jdata 'flavor)) empty (first (hash-ref jdata 'flavor)))
			(hash-ref jdata 'power)
			(hash-ref jdata 'power)
			(hash-ref jdata 'watermark)
			(hash-ref jdata 'set)
			(hash-ref jdata 'rarity)
			(map json->print (hash-ref jdata 'prints))
			(hash-ref jdata 'number)
			(hash-ref jdata 'artist)
			(hash-ref jdata 'rating)
			(hash-ref jdata 'votes)))

(define (json->print jdata)
	(make-print (hash-ref jdata 'set)
			(hash-ref jdata 'id)))


; Handle connections
(define CONNECTION true)
(define (disconnect-magic-the-gathering-service)
	(set! CONNECTION false))
(define (connect-magic-the-gathering-service)
	(set! CONNECTION true))

; Build Client Store
(define CLIENT_STORE (read-json (open-input-file "cache.json")))

(define (boolean->string a-boolean)
	(if a-boolean
		"true"
		"false"))
(define (string->boolean a-string)
	(string=? a-string "true"))
(define (key-value pair)
	(string-append (symbol->string (car pair)) "=" (cdr pair)))
(define (convert-post-args data)
	(string->bytes/utf-8 (alist->form-urlencoded data)))
(define (convert-get-args url data)
	(string-append url "?" (string-join (map key-value data) "&")))
(define (hash-request url data)
	(string-append url "%{" (string-join (map key-value data) "}%{") "}"))
(define (post->json url full-data index-data)
	(if CONNECTION
		(port->string (post-pure-port (string->url url) (convert-post-args full-data)))
		(hash-ref CLIENT_STORE (hash-request url index-data) "")))
(define (get->json url full-data index-data)
	(if CONNECTION
		(port->string (get-pure-port (string->url (convert-get-args url full-data))))
		(hash-ref CLIENT_STORE (hash-request url index-data) "")))

; Define the services, and their helpers
(define (get-card id)
	(json->card (get-card/json id)))

(define (get-card/json id)
	(string->jsexpr (get-card/string id)))

(define (get-card/string id)
	(get->json (string-append "http://mtgapi.com/api/v1/fetch/id/" id) 
	 	(list) 
	 	(list (cons 'id id))))

(define (search-cards keyword)
	(map json->card (search-cards/json keyword)))

(define (search-cards/json keyword)
	(string->jsexpr (search-cards/string keyword)))

(define (search-cards/string keyword)
	(get->json (string-append "http://mtgapi.com/api/v1/fetch/search/" keyword) 
	 	(list) 
	 	(list (cons 'keyword keyword))))
