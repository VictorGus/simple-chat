(ns simple-chat-on-clojure.core
  (require '[org.httpkit.server :as hts]))

(defn app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP!"})

(def stop (hts/run-server app {:port 8080}))
