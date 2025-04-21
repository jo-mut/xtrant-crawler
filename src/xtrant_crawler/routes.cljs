(ns xtrant-crawler.routes
  (:require
   ["lucide-react" :refer [HomeIcon]]
   ["react-router-dom" :refer [BrowserRouter Route Routes]]
   [reagent.core :as r]
   [xtrant-crawler.pages.home :as home]
   [xtrant-crawler.pages.auth.sign-in :as sign-in]
   [xtrant-crawler.pages.auth.sign-up :as sign-up]
   [xtrant-crawler.pages.not-found :as not-found]))

(def sidebar-routes
  [{:href  ""
    :label "Home"
    :icon  HomeIcon
    :component home/view}
   {:href  "/workflows"
    :label "Workflows"
    :icon  HomeIcon
    :component home/view}
   {:href  "/credentials"
    :label "Credentials"
    :icon  HomeIcon
    :component home/view}
   {:href  "/billing"
    :label "Billing"
    :icon  HomeIcon
    :component home/view}])

(defn home-routes []
  [:> Routes
   [:> Route
    {:path "/"
     :element (r/as-element [home/view])}]
   [:> Route
    {:path "/sign-in"
     :element (r/as-element [sign-in/view])}]
   [:> Route
    {:path "/sign-up"
     :element (r/as-element [sign-up/view])}]
   [:> Route
    {:path "/not-found"
     :element (r/as-element [not-found/view])}]])