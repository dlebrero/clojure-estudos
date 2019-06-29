(ns capitulo-cinco.core
  (:gen-class))

; Função que cria um resumo de uma transação.
(defn resumo [transacao]
  (select-keys transacao [:valor :tipo :data]))

; Transações.
(def transacoes
  [{:valor 33.0   :tipo "despesa" :comentario "Almoço"           :data "19/11/2016"}
   {:valor 2700.0 :tipo "receita" :comentario "Bico"             :data "01/12/2016"}
   {:valor 29.0   :tipo "despesa" :comentario "Livro de Clojure" :data "03/12/2016"}])

(map resumo transacoes)

(defn despesa? [transacao]
  (= (:tipo transacao) "despesa"))

(filter despesa? transacoes)

; Função que pega só o valor de uma transação
(defn so-valor [transacao]
  (:valor transacao))

(map so-valor (filter despesa? transacoes))

(reduce + (map so-valor (filter despesa? transacoes)))

; Verifica se o valor de uma transação é maior que 100.
(defn valor-grande? [transacao]
  (> (:valor transacao) 100))

(filter valor-grande? transacoes)

(def impares '(1 3 5 7 9))
(def ano-do-pentacampeonato-do-brasil 2002)
(def pi 3.14)
(def um-terco 1/3)

(fn [])

; Função anônima;
((fn [nome]
  (str "Olá, " nome "!"))
  "mundo novo")

; Função anônima;
(filter (fn [transacao]
          (> (:valor transacao) 100))
          transacoes)


; Função anônima curta.
(filter #(> (:valor %) 100)
        transacoes)

(reduce + (map #(:valor %)
               (filter #(= (:tipo %) "despesa")
                       transacoes)))

; Macro -> (Thread-First).
; O resultado da função anterior é passada como primeiro parâmetro da próxima função.

  ; Sem macro
  (so-valor (first transacoes))

  ; Com macro, aqui podemos observar a odem de execução.
  (-> (first transacoes)
      (so-valor))


; Macro ->> (Thread-Last).
; O resultado da função anterior é passada como primeiro parâmetro da próxima função.

  (->> (filter despesa? transacoes)
       (map so-valor)
       (reduce +))
