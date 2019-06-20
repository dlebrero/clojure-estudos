(ns primeiras-linhas.core
  (:gen-class))

; Funções aritméticas.
(+ 1 2)
(* 2 3)
(/ 2 2)
(- 0 2)
(* 2 (+ 3 3))

; Strings.
(str "Oi, " "mundo!")
(= "Oi" "Olá")
(= "Oi" "Oi")

; Verificar se um número é par.
(even? 2)

; Verificar se 9 é múltiplo de 3.
(= 0 (mod 9 3))
