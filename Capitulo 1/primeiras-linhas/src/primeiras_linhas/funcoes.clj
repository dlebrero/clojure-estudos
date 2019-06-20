(ns primeiras-linhas.funcoes)

; Criar uma função que receba um parâmetro nome e printe
; "Oi, nome!".
(defn oi [nome]
  (str "Oi, " nome "!"))

(oi "Peter")
(oi "Margaret Hamilton")

; Verificar se um número é multiplo de 3.
(defn multiplo-de-3? [dividendo]
  (= 0 (mod dividendo 3)))

(multiplo-de-3? 9)
(multiplo-de-3? 20)
