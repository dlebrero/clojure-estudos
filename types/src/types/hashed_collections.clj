(ns types.hashed-collections)

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


