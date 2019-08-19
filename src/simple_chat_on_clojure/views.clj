(ns simple-chat-on-clojure.views
  (:require [hiccup.core :as hc]
            [garden.core :as gc]
            [simple-chat-on-clojure.style :as scs]))

(defn style [in-style]
  [:style (gc/css in-style)])

(defn js [pth]
  [:script {:src pth}])

(defn layout [title & content]
  (hc/html [:html
            [:head
             [:title title]
             (style scs/main-style)]
            [:body content
             (js "/assets/chat.js")]]))
