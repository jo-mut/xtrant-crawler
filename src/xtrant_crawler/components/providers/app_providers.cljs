(ns xtrant-crawler.components.providers.app-providers
  (:require
   ["react" :refer [createContext useContext useEffect useState]]
   [reagent.core :as r]))

(def initial-state
  {:theme "system"
   :setTheme (fn [] nil)})

(defonce theme-context (.createContext initial-state))

(defn theme-provider
  [{:keys [default-theme storage-key]
    :as props
    :or {default-theme "system"
         storage-key "vite-ui-theme"}} children]
  (let [[theme set-theme] (useState (fn []
                                      (or (.getItem js/localstorage storage-key)
                                          default-theme)))]

    (useEffect
     (fn []
       (let [root (.-documentElement (.document js/window))]
         (.remove (.-classList root) "light" "dark")
         (let [system-theme (-> js/window
                                (.matchMedia "(prefers-color-scheme: dark)")
                                .-matches)]
           (if (= theme :system)
             (.add (.-classList root) (if system-theme "dark" "light"))
             (.add (.-classList system-theme))))))
     [theme])

    (let [value #js {:theme theme
                     :setTheme (fn []
                                 (.setItem js/localstorage storage-key theme)
                                 (set-theme theme))}]
      [:> (.-Provider theme-context)
       {:value value}
       (r/as-element children)])))

(defn use-theme []
  (let [context (useContext theme-context)]
    (when-not context
      (throw (js/Error.  "useTheme must be used within a ThemeProvider")))
    context))

