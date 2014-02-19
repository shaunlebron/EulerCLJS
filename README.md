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

## Rendering Answers to the page

I made the server pull the problem number from the URL and display the answer
on the page.  The answer to the problem is calculated in clojurescript on the
client side.  Mind you, this is a pointless separation of server and client.
Just experimenting.
