(ns xtrant-crawler.pages.auth.sign-up
  (:require 
   ["@clerk/react-router" :refer [SignUp]]))

(defn view []
  [:div {:className "flex flex-col items-center justify-center h-screen"} 
   [:> SignUp]])