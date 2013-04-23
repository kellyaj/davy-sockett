(ns davy-sockett.core)

(import '[java.net InetAddress InetSocketAddress])
(import '[java.nio.channels ServerSocketChannel])


(defn create-server [port]
  (let [x (->
            (ServerSocketChannel/open)
            (.configureBlocking false)
            (.bind (InetSocketAddress. "localhost" port)))]
    ))


(defn -main []
  (create-server 5000))
