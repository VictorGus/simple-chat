(ns simple-chat-on-clojure.core-test
  (:require [clojure.test :refer :all]
            [simple-chat-on-clojure.core :refer :all]))

(def simple-request {})

(def simple-response {:status 200
                      :headers {"Content-Type" "text/html"}
                      :body "<html><head><title>index</title><style>body {\n  display: block;\n  padding: 1em;\n  background: #A19F9F;\n  color: white;\n}</style></head><body><style>.input-area {\n  display: flex;\n  justify-content: center;\n}\n\n.text-area {\n  width: 50%;\n  height: 25%;\n}</style><div class=\"out-area\" id=\"out\"></div><div class=\"input-area\" id=\"input\"><textarea class=\"text-area\" id=\"inp\"></textarea></div><script src=\"/assets/chat.js\"></script></body></html>"})

(def another-simple-response {:status 200
                              :headers {"Content-Type" "text/html"}
                              :body "<html><head><title>index</title><style>body {\n  display: block;\n  padding: 1em;\n  background: #A19F9F;\n  color: white;\n}</style></head><body><p>Amount of users in a chat 0</p><script src=\"/assets/chat.js\"></script></body></html>"})

(deftest request-handler-test
  (testing "Response to request"
    (is (= simple-response (chat-handler simple-request)))))

(deftest another-request-handler-test
  (testing "Response to request"
    (is (= another-simple-response (stat-handler simple-request)))))

