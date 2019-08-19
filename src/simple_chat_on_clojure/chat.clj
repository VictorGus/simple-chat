(ns simple-chat-on-clojure.chat
  (:require [org.httpkit.server :as ohs]
            [hiccup.core :as hc]))

(def users (atom {}))

(defn add-new-user [ch user]
  (swap! users assoc users ch))

(defn remove-user [ch]
  (println ch)
  (swap! users dissoc ch))

(defn broadcast [msg]
  (doseq [[ch u] @users]
    (ohs/send! ch msg)))

(defn format-message [usr msg]
  (hc/html [:div.message
            [:b (:name usr)]
            [:div.res
             [:pre msg]]]))

(defn on-msg [ch msg]
  (let [u (get @users ch)
        msg msg]
    (get @users ch)
    (println msg)
    (broadcast (format-message u msg))))
