(ns davy-sockett.core)

(import '[java.net InetAddress InetSocketAddress ServerSocket])
(import '[java.nio.channels ServerSocketChannel])
(import '[java.io BufferedReader InputStreamReader PrintWriter])


(defn create-server []
  (let [davy ( ServerSocket.)]
    (-> davy (.bind (InetSocketAddress. "localhost" 5000)))
    (binding [*out* (PrintWriter. (.getOutputStream (.accept davy)))]
      (println "hello world"))))


(defn -main []
  (create-server))


;(println "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n\r\nHello World")))
