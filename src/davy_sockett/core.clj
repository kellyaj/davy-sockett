(ns davy-sockett.core)

(import '[java.net InetAddress InetSocketAddress ServerSocket])
(import '[java.nio.channels ServerSocketChannel])
(import '[java.io BufferedReader InputStreamReader PrintWriter])


(defn create-server []
  (let [davy (ServerSocket.)]
    (-> davy (.bind (InetSocketAddress. "localhost" 5000)))
    (let [socket (.accept davy)]
    (binding [*out* (PrintWriter. (.getOutputStream socket))
              *in* (BufferedReader. (InputStreamReader. (.getInputStream socket)))]
      (println (read-line))))))


(defn -main []
  (create-server))
