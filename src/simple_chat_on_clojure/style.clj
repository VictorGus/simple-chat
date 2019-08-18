(ns simple-chat-on-clojure.style
  (:require [garden.core :as gc]))

(def main-style
  [:body {:display "block"
          :padding "1em"
          :background "#A19F9F" :color "white"}])

(def text-area-style
  [:.input-area {:display "flex"
                :justify-content "center"}])

(def text-input-style
  [:.text-area {:width "50%"
                :height "25%"}])
