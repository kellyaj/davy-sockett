(ns davy-sockett.core)

(import '[java.net InetAddress InetSocketAddress])
(import '[java.nio.channels ServerSocketChannel])
(import '[java.io OutputStreamWriter])


(defn create-server [port]
  (let [x (->
            (ServerSocketChannel/open)
            (.bind (InetSocketAddress. "localhost" 5000)))]
    (-> (.socket x) .accept)))


(defn -main []
  (create-server 5000))


;(println "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n\r\nHello World")))
