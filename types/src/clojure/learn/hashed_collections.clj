(ns clojure.learn.hashed-collections)

; Sets
; Sets are like mathematical sets - unordered and with no duplicates.
; Sets are ideal for efficiently checking whether a collection containts an element, or to remove any arbitrary element.
(def players #{"Alice", "Bob", "Kelly"})

; Adding to a set
; As with vector and list, `conj` is used to add elements.
(conj players "Fred")

; Removing from a set
; The `disj` ("disjoin") function is used to remove one or more elements from a set.
(disj players "Bob" "Kelly")

; Checking containment
(contains? players "Kelly")

; Sorted sets
; Sorted sets are sorted according to a comparator function which can compare two elements.
; By default, Clojure's `compare` function is used, which sorts in "natural" order for number, strings, etc.
(conj (sorted-set) "Bravo" "Charlie" "Sigma" "Alpha")

; A custom comparator can alse be user with `sorted-set-by`.

; Into
; `into` is used for putting one collection into another.
(def players #{"Alice", "Bob", "Kelly"})
(def new-players ["Tim", "Sue", "Greg"])
(into players new-players)

; `into` returns a collection of the same type as its first argument.

; Maps
; Maps are represented as alternating keys and values surrounded by `{` and `}`.
(def scores {"Fred"   1400
             "Bob"    1240
             "Angela" 1024})

; When Clojure prints a map at the REPL, it will put `,'s between each key/value pair. These are purely used for readability
; - commas are treated as whitespace in Clojure. Feel free to use them in cases where they help you!
(println scores)
(def scores {"Fred"   1400,
             "Bob"    1240,
             "Angela" 1024})

; Adding new key-value pairs
; New values are added to maps with the `assoc` (short for "associate") function:
(assoc scores "Sally" 0)

; If the key used in `assoc` already exists, the value is replaced.
(assoc scores "Bob" 0)

; Removing key-value pairs
; The complementary operation for removing key-value pairs is `dissoc` ("dissociate"):
(dissoc scores "Bob")

; Looking up by key
; There are several ways to look up a value in a map. The most obvious is the function `get`:
(get scores "Angela")

; When the map in question is being treated as a constant lookup table, its common to invoke the map itself,
; treating it as a function:
(def directions {:north 0
                 :east  1
                 :south 2
                 :west  3})
(directions :north)

; You should not directly invoke a map unless you can guarantee it will be non-nil:
(def bad-lookup-map nil)
(bad-lookup-map :foo)

; Looking up with a default
; If you want to do a lookup and fall back to a default value when the key is not found, specify the default as an extra
; parameter:
(get scores "Sam" 0)
(directions :northwest -1)

; Using a default is also helpful to distinguish between a missing key and an existing key with a `nil` value.

; Check contains
; There are two other functions that are helpful in checking whether a map contains an entry.
(contains? scores "Fred")
(find scores "Fred")

; The `contains?` funciton is a predicate for checking containment. The `find` function finds the key/value entry
; in a map, not just the value.

; Keys or values
; You can also get just the keys or just the values in a map:
(keys scores)
(vals scores)

; While maps are unordered, there is a guarantee that keys, vals, and other functions that walk in "sequence" order
; will always walk a particular map instance entries in the same order.

; Building a map
; The `zipmap` function can be used to "zip" together two sequences (the keys and vals) into a map:
(def players #{"Alice", "Bob", "Kelly"})
(zipmap players (repeat 0))

; There are a variety of other ways to build up a map using CLojure's sequence functions.
(into {} (map (fn [player] [player 0]) players))
(reduce (fn [m player] (assoc m player 0)) {} players)

; Combining maps
; The `merge` function can be used to combine multiple maps into a single map:
(def new-scores {"Angela" 300, "Jeff" 900, "Bob" 0})
(merge scores new-scores)

; We merged two maps here but you can pass more as well.

; If both maps contain the same key, the rightmost one wins. Alternately, you can use `merge-with` to supply
; a function to invoke when there is a conflict:
(def new-scores {"Fred" 550 "Angela" 900 "Sam" 1000})
(merge-with + scores new-scores)

; In the case of conflict, the function is called on both values to get the new value.

; Sorted maps
; Similar to sorted sets, sorted maps maintain the keys in sorted order based on a comparator, using `compare` as the
; default comparator function.
(def sm (sorted-map
          "Bravo" 204,
          "Alfa" 35,
          "Sigma" 99,
          "Charlie" 100))
(println sm)
(keys sm)
(vals sm)