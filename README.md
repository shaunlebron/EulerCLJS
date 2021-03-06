Hi, I'm learning ClojureScript by doing Project Euler.

## Overview

- Run `lein run` in repo directory.
- Navigate to <http://localhost:3000/N> to see the answer to problem N.
- The answer to problem N is calculated by the function `euler.problemN.answer` in "src/cljs/euler-cljs/problemN.cljs".

## Setup

1. Installed [Leiningen](http://leiningen.org/).
2. Typed the following to create this CLJS project ([from here](http://squirrel.pl/blog/2013/01/02/get-started-with-clojurescript-with-leiningen-templates/)):

        lein run cljs-kickoff euler-cljs
        cd euler-cljs
        lein run

3. Opened a different terminal window to run the auto-compiler:


        lein cljsbuild auto

4. Navigated my browser to http://localhost:3000

## How I'm Learning

1. Doing [ClojureScript Koans](http://clojurescriptkoans.com)
1. Reading [ClojureScript Style Guide](https://github.com/bbatsov/clojure-style-guide)
1. Reading [Clojure Programming By Example](http://en.wikibooks.org/wiki/Clojure_Programming/By_Example)
1. Reading [Clojure Functional Programming](http://clojure.org/functional_programming)
1. Thumbing through [Clojure Core API](http://clojure.github.io/clojure/clojure.core-api.html)
1. Reading [ClojureScript - Differences from Clojure - Host Interop](https://github.com/clojure/clojurescript/wiki/Differences-from-Clojure#wiki-host-interop) for accessing javascript properties like `(.-Infinity js/window)` and functions like `(.sqrt js/Math 25)`.
1. Reading [Javascript to ClojureScript synonyms](http://kanaka.github.io/clojurescript/web/synonym.html)
1. Checking for better solutions on [Clojure Euler Wikispace](http://clojure-euler.wikispaces.com/Problem+001)
1. Experimenting in `lein repl` for Clojure REPL.
1. Experimenting in <http://clojurescript.net/> for ClojureScript REPL with a browser context.
1. Reading docstrings of functions I encounter with `(doc <funcname>)` in REPL.

## Rendering Answers to the page

I made the server pull the problem number from the URL and display the answer
on the page.  The answer to the problem is calculated in clojurescript on the
client side.  Mind you, this is a pointless separation of server and client.
Just experimenting.
