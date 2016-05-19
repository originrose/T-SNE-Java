(defproject thinktopic/tsne-core "0.1.0-SNAPSHOT"
  :description "Clojure wrappers for a Java port of t-SNE is is Copyright (c) Leif Jonsson 2014.
The original Python implementation is Copyright (c) Laurens van der Maaten on 20-12-08,
Tilburg University. All rights reserved."
  :url "http://thinktopic.com"
  :license {:name "Custom" }
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [gov.nist.math/jama "1.0.2"]
                 [com.googlecode.efficient-java-matrix-library/core "0.26"]
                 [com.googlecode.efficient-java-matrix-library/equation "0.26"]
                 [net.mikera/vectorz-clj "0.43.1"]
                 [net.mikera/core.matrix "0.50.0"]]
  :java-source-paths ["src/main"]
  :source-paths ["src/clj"]

  :profiles {:test {:dependencies [[junit/junit "4.12"]]
                    :java-source-paths ["src/test"]
                    :plugins [[lein-junit "1.1.8"]]
                    :junit ["src/test"]}})
