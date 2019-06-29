(ns capitulo-cinco.core
  (:gen-class))

(defn resumo [transacao]
  (select-keys transacao [:valor :tipo :data]))
; Função que cria um resumo de uma transação.

(def transacoes
  [{:valor 33.0   :tipo "despesa" :comentario "Almoço"           :data "19/11/2016"}
   {:valor 2700.0 :tipo "receita" :comentario "Bico"             :data "01/12/2016"}
   {:valor 29.0   :tipo "despesa" :comentario "Livro de Clojure" :data "03/12/2016"}])
; Transações.

(map resumo transacoes)

(defn despesa? [transacao]
  (= (:tipo transacao) "despesa"))

(filter despesa? transacoes)

(defn so-valor [transacao]
  (:valor transacao))
; Função que pega só o valor de uma transação

(map so-valor (filter despesa? transacoes))

(reduce + (map so-valor (filter despesa? transacoes)))
