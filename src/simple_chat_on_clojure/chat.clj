(ns simple-chat-on-clojure.chat
  (:require [org.httpkit.server :as ohs]
            [hiccup.core :as hc]))

(def users (atom {}))

(defn add-new-user [ch user]
  (swap! users #(assoc % ch user)))

(defn remove-user [ch]
  (println ch)
  (swap! users dissoc ch))

(defn broadcast [ch msg]
  (doseq [[ch u] @users]
    (ohs/send! ch msg)))

(defn format-message [usr msg]
  (hc/html [:div.message
            [:b (:name usr)]
            [:div.res
             [:pre msg]]]))

(defn on-msg [ch msg params]
  (let [u (get @users ch)
        msg msg]
    (println msg)
    (println params)
    (broadcast ch (format-message u msg))))
