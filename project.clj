(defproject simple-chat-on-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [http-kit "2.3.0"]
                 [compojure "1.6.1"]
                 [hiccup "1.0.5"]
                 [garden "1.3.9"]]
  :repl-options {:init-ns simple-chat-on-clojure.core}
  :main simple-chat-on-clojure.core)
