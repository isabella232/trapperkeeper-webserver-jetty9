(ns puppetlabs.trapperkeeper.testutils.webrouting.common
  (:require [puppetlabs.http.client.sync :as http-client]))

(defn http-get
  ([url]
   (http-get url {:as :text}))
  ([url options]
   (http-client/get url options)))

(def webrouting-plaintext-config
  {:webserver {:port 8080}
   :web-router-service {:puppetlabs.trapperkeeper.services.webrouting.webrouting-service-handlers-test/test-dummy "/foo"
                        :puppetlabs.bar/bar-service "/bar"}})

(def webrouting-plaintext-multiserver-config
  {:webserver {:default {:port 8080}
               :ziggy {:port 9000}}
   :web-router-service {:puppetlabs.trapperkeeper.services.webrouting.webrouting-service-handlers-test/test-dummy "/foo"}})

(def webrouting-plaintext-multiroute-config
  {:webserver {:port 8080}
   :web-router-service {:puppetlabs.trapperkeeper.services.webrouting.webrouting-service-handlers-test/test-dummy
                                                    {:default "/foo"
                                                     :ziggy   "/bar"}}})

(def webrouting-plaintext-multiserver-multiroute-config
  {:webserver {:default {:port 8080}
               :ziggy   {:port 9000}}
   :web-router-service {:puppetlabs.trapperkeeper.services.webrouting.webrouting-service-test/test-service
                                                    {:default "/foo"
                                                     :bowie   "/bar"}}})

(def webrouting-plaintext-override-config
  {:webserver {:port 8080}
   :web-router-service {:puppetlabs.trapperkeeper.services.webrouting.webrouting-service-override-settings-test/test-dummy "/foo"}})

(def webrouting-plaintext-multiserver-override-config
  {:webserver {:default {:port 8080}
               :ziggy   {:port 9000}}
   :web-router-service {:puppetlabs.trapperkeeper.services.webrouting.webrouting-service-override-settings-test/test-dummy "/foo"}})

(def default-options-for-https-client
  {:ssl-cert "./dev-resources/config/jetty/ssl/certs/localhost.pem"
   :ssl-key  "./dev-resources/config/jetty/ssl/private_keys/localhost.pem"
   :ssl-ca-cert "./dev-resources/config/jetty/ssl/certs/ca.pem"
   :as :text})
