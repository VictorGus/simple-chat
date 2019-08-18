(ns simple-chat-on-clojure.core
  (:use org.httpkit.server)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [simple-chat-on-clojure.views :as views]
            [simple-chat-on-clojure.style :as scs]
            [garden.core :as gc]))

(defn stat-handler [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP!"})

(defn chat-handler [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (views/layout "index"
                       (views/style [scs/text-area-style scs/text-input-style])
                       [:div#out.out-area]
                       [:div#input.input-area 
                        [:textarea#inp.text-area]])})

(defroutes app-routes
  (GET "/" [] chat-handler)
  (GET "/:name" [] chat-handler)
  (GET "/stat" [] stat-handler)
  (route/not-found "This page doesn't exist"))

(defn -main []
  (run-server #'app-routes {:port 8080})
  (println "Now server is running on port 8080"))
