(ns davy-sockett.core)

(import '[java.net InetAddress InetSocketAddress ServerSocket])
(import '[java.nio.channels ServerSocketChannel])
(import '[java.io BufferedReader InputStreamReader PrintWriter])

(defn spinoff [new-socket]
  (binding [*out* (PrintWriter. (.getOutputStream new-socket))
            *in* (BufferedReader. (InputStreamReader. (.getInputStream new-socket)))]
    (println (read-line))
    (.close new-socket)))

(defn create-server []
  (let [davy (ServerSocket.)]
    (-> davy (.bind (InetSocketAddress. "localhost" 5000)))
    (spinoff (.accept davy))
    (.close davy))
  (create-server))


(defn -main []
  (create-server))
