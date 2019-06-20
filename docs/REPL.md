# REPL - read, evaluate, print and loop
REPL é um ambiente interativo onde escrevemos códigos e eles são interpretados de imediato, gerando resultados
muito rápidos. É ideal para trechos pequenos e validação de ideias.

Como escrito no texto, REPL é um acrônimo para read, evaluate, print e loop. Isto quer dizer que ele vai ler nossos comandos,
interpretá-los, exibir na tela o resultado e repetir o processo. Python também oferece uma ferramenta para o mesmo propósito:
é só digitar `python` no terminal e teremos um interpretador. Scala e Erlang são exemplos de linguagens cujas
plataformas também oferecem tais ferramentas.

Programar no REPL é algo bem comum entre quem tem familiaridade com Clojure. Claro, em algum momento nossos códigos vão parar
em arquivos e serão empacotaos. Mas o REPL fornece um ambiente muito prático para experimentação e testes.
Algumas pessoas substituim o desenvolvimento guiado por testes (TDD) pelo ocnstante uso do REPL. Eu prefiro
continuar a criar casos de testes.

## REPL na prática
Abra o terminal e digite: 
- `lein repl`

Um terminal interativo deve aparecer, com uma mensagem mais ou menos assim:
- `nREPL server started on port 59553 on host 127.0.0.1 - nrepl://127.0.0.1:59553 REPL-y 0.4.3, nREPL 0.6.0`

E, esperando fornecer alguma informação, o terminal diz:
- `user=>`

Isso significa que já podemos escrever código! Digite o seguinte:
- `Valeu, Clojure`

Aperter `Enter` e veja o texto. Acredito que esse foi o Hello, world mais rápido da minha vida.

Digite `exit` para sair do REPL. Ou `quit`, ou aperte `control + d`.


