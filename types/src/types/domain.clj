(ns types.domain)

; Representing application domain information
; When we need to represent many domain information with the same set of fields know in advance, you can use a map with keywords key.

; Field accessors
; Since this is a map, the ways we’ve already discussed for looking up a value by key also work.
(def person
  {:first-name "Kelly"
   :last-name  "Keen"
   :age        32
   :occupation "Programmer"})

(get person :occupation)
(person :occupation)

; But really, the most common way to get field values for this use is by invoking the keyword. Just like with maps and
; sets, keywords are also functions. When a keyword is invoked, it looks itself up in the associative data structure that it was passed.
(:occupation person)

; Keyword invocation also takes an optional default value:
(:favorite-color person "Beige")

; Updating fields
; Since this is a map, we can just use `assoc` to add or modify fields:
(assoc person :occupation "Baker")

; Removing a field
; Use dissoc to remove fields:
(dissoc person :age)

; Nested entities
; It is common to see entities nested within other entities:
(def company
  {:name    "WidgetCo"
   :address {:street "123 Main St"
             :city   "Springfield"
             :state  "IL"}})

; You can use `get-in` to access fields at any level inside nested entities:
(get-in company [:address :citys])

; You can also use `assoc-in` or `update-in` to modify nested entities:
(assoc-in company [:address :street] "303 Broadway")

; Records

; An alternative to using maps is to create a "record". Records are designed specifically for this use case and
; generally have better performance. In addition, they have a named "type" which can be used for polymorphic behavior (more on that later).

; Records are defined with the list of field anmes for record instance. These will be treated as keyword keys in each record instance.

; Define a record structure.
(defrecord Person [first-name last-name age occupation])

; Positional constructor - generated
(def kelly (->Person "Kelly" "Keen" 32 "Programmer"))

; Map constructor - generated
(def kelly (map->Person
             {:first-name "Kelly"
              :last-name  "Keen"
              :age        32
              :occupation "Programmer"}))

; Records are used almost exactly the same as maps, with the caveat that they cannot be invoked as a function like maps.
(:occupation kelly)