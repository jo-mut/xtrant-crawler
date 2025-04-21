(ns xtrant-crawler.pages.auth.sign-in
  (:require
   ["@clerk/react-router" :refer [SignIn]]))

(defn view []
  [:div {:className "flex flex-col items-center justify-center h-screen"}
   [:> SignIn]])