(ns types.collections)

[1 2 3]

; Index access

; "Indexed" means that element of a vector can be retrieved by index.
; In Clojure (as in java), indexes start at 0, not 1.
; Use the `get` function to retrieve an element at an index:
(get ["abc" false 99] 0)

; If you calling get with an invalid index, return nil:
(get ["abc" false 99] 3)

; Count
(count [1 2 3])

; In addition to the lital `[ ]` syntax, Clojure vectors can be created with the `vector` function:
(vector 1 2 3)

; Adding elements

; Elements are added to a vector with `conj` (short for conjoin). Elements are alway added to a vector at the end:
(conj [1 2 3] 4 5 6)

; Immutability
; Clojure collections share important properties of simple values like strings and numbers, such as immutability and
; equality comparison by value.

; For example, lets create a vector and modify it with `conj`.
(def v [1 2 3])
(conj v 4 5 6)

; Here `conj` returned a new vector but if we examine the original vector, we see it's unchanged.
(println v)

; Any function that "changes" a collection return a new instance. Your program will need to remember or pass along the
; changed instance to take advantage of it.

; Lists

; Lists are sequential linked lists that add new elements at the head of the list, instead of at the tail like vectors.

; Constructing
; Because lists are evaluated by invoking the first element as a function, we must quote a list to prevent evaluation.
(def cards '(10 :ace :jack 9))

; Lists are not indexed so they must be walker using `first` and `rest`.
(first cards)
(rest cards)

; Adding elements
; `conj` can be used to add elements to a list just as with vectors. However, `conj` always add elements where it
; can be done in constant time for the data structure. In the case of lists, elements are added at the front:
(conj cards :queen)

; Stack access
; Lists can also be used as a stack with peek and pop:
(def stack '(:a :b))

(peek stack)

(pop stack)

(clojure.repl/doc peek)
(clojure.repl/doc pop)

(println stack)

