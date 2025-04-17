(ns xtrant-crawler.components.providers.app-providers
  (:require
   ["react" :refer [createContext useContext useEffect useState]]
   [reagent.core :as r]))

(def initial-state
  #js {:theme "system"
       :setTheme (fn [_] nil)})

(defonce theme-context (createContext initial-state))

(defn- f-theme-provider
  [{:keys [default-theme storage-key]
    :or {default-theme "system"
         storage-key "vite-ui-theme"} 
    :as props}
   children]
  (let [[theme set-theme]
        (useState (fn []
                    (or (.getItem js/localStorage storage-key)
                        default-theme)))]

    (useEffect
     (fn []
       (let [root (.-documentElement js/document)]
         (.remove (.-classList root) "light" "dark")
         (let [resolved-theme (if (= theme "system")
                                (if (.. js/window
                                        (matchMedia "(prefers-color-scheme: dark)")
                                        -matches)
                                  "dark"
                                  "light")
                                theme)]
           (.add (.-classList root) resolved-theme)))
       js/undefined)
     #js [theme])

    [:> (.-Provider theme-context)
     {:value #js {:theme theme
                  :setTheme (fn [new-theme]
                              (.setItem js/localStorage storage-key new-theme)
                              (set-theme new-theme))}}
     (r/as-element children)]))

(defn provider [props children]
  [:f> f-theme-provider props children])

(defn use-theme []
  (let [context (useContext theme-context)]
    (when-not context
      (throw (js/Error. "useTheme must be used within a ThemeProvider")))
    context))
