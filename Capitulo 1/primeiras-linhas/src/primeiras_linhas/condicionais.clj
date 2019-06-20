(ns primeiras-linhas.condicionais)

; Criar uma função que exiba "Sim" se o número for par e "Não" se não for.
(defn par? [numero]
  (if (even? numero)
    "Sim"
    "Não"))

(par? 2)
