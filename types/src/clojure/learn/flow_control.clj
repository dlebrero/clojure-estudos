(ns clojure.learn.flow-control)

; If
; `if` is the most important conditional expression - it consists of a condition, a "then", and an "else".
; `if` will only evaluate the branch selected by the conditional.
(str "2 is " (if (even? 2) "even" "odd"))

; else is optional
(if (true? false) "Impossible!")

; Truth
; In Clojure, all values are logically true or false, The only "false" values are `false` and `nil` - all other values are logically true.
(if true :truthy :falsey)

; objects are true
(if (Object.) :truthy :falsey)

; empty collections are true
(if [] :truthy :falsey)

; zero is true
(if 0 :truthy :falsey)

(if false :truthy :falsey)

(if nil :truthy :falsey)

; `if` and `do`
; The `if` only takes a single expression for the "then" and "else". Use `do` to create larger blocks that are a single expression.

; Note that the only reason to do this is if you bodies have side effects! (Why?)
(if (even? 5)
  (do (println "even")
      true)
  (do (println "odd")
      false))

; when
; `when` is and `if` with only a `then`branch. It checks a condition and then evaluates any number of statements as a body
; (so no `do` is required). The value of the last expression is returned. If the condition is false, nil is returned.

; `when` communicates to a reader that there is no "else" branch.
(when (neg? x)
  (throw (RuntimeException. (str "x must be positive: " x))))

; cond
; `cond` is a series of tests and expressions. Each test is evaluated in order and the expression is evaluated and
; returned for the first true test.

(let [x 5]
  (cond
    (< x 2) "x is less than 2"
    (< x 10) "x is less than 10"))

; cond and else
(let [x 11]
  (cond
    (< x 2) "x is less than 2"
    (< x 10) "x is less than 10"
    :else "x is greater than or equal to 10"))

; case
; `case` compares an argument to a series of values to find a match. This is done in constant (not linear) time!
; However, each value must be a compile-time literal (numbers, strings, keywords, etc).

; Unlike `cond`, `case` will throw an exception if no value matches.
(defn foo [x]
  (case x
    5 "x is 5"
    10 "x is 10"))

(foo 5)

; case with else-expression
; `case` can have a final trailing expression that will be evaluated if no test matches.
(defn foo [x]
  (case x
    5 "x is 5"
    10 "x is 10"
    "x isn't 5 or 10"))
(foo 11)