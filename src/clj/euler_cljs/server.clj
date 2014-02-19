(ns euler-cljs.server
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.resource :as resources]
            [ring.util.response :as response])
  (:gen-class))

(defn page [path]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body
   (if (re-find #"^[\d]+$" path)
       (str "<script src='js/cljs.js'></script>"
            "Answer to <a href='http://projecteuler.net/problem=" path "'>problem " path "</a> = <span id='answer'></span>"
            "<script>window.onload = function() { document.getElementById('answer').innerHTML = euler.problem" path "(); }</script>")
       "Type a valid problem number in the URL")})

(defn handler [request]
  (-> (:uri request)
      (subs 1)
      (page)))

(def app 
  (-> handler
    (resources/wrap-resource "public")))

(defn -main [& args]
  (jetty/run-jetty app {:port 3000}))

