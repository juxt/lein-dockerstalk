(ns leiningen.dockerstalk
  (:require [leiningen.beanstalk.aws :as aws]
            [leiningen.beanstalk :refer [get-project-env project-environments]]
            [clojure.java.io :as io]))

(defn deploy
  "Deploy the file to Amazon Elastic Beanstalk."
  [project env-name path]
  (println (project-environments project))
  (if-let [env (or (get-project-env project env-name)
                   (get-project-env project (str (aws/app-name project) "-" env-name)))]
    (do
      (println "Deploying to" (aws/app-name project) (:name env))
      (aws/s3-upload-file project path)
      (aws/create-app-version project (.getName (io/file path)))
      (aws/deploy-environment project env))
    (println (str "Environment '" env-name "' not defined!"))))

(defn dockerstalk
  "I don't do a lot."
  [project subtask & args]
  (condp = subtask
    "deploy"
    (apply deploy project args)))
